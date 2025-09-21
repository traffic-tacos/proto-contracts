# Traffic Tacos Proto Contracts Integration Guide

This guide provides step-by-step instructions for integrating proto-contracts into each service of the Traffic Tacos platform.

## Table of Contents

- [Prerequisites](#prerequisites)
- [Service Integration](#service-integration)
  - [Gateway API (Go)](#gateway-api-go)
  - [Reservation API (Kotlin/Spring Boot)](#reservation-api-kotlinspring-boot)
  - [Inventory API (Go)](#inventory-api-go)
  - [Payment Sim API (Go)](#payment-sim-api-go)
  - [Reservation Worker (Go/Kotlin)](#reservation-worker-gokotlin)
  - [Reservation Web (React)](#reservation-web-react)
- [Code Generation](#code-generation)
- [Testing Integration](#testing-integration)
- [Deployment Considerations](#deployment-considerations)

## Prerequisites

### Development Environment
- **Go**: 1.22+ for Go services
- **Java**: 17+ for Kotlin services
- **Node.js**: 18+ for frontend build tools
- **Buf**: Latest version for proto management
- **Docker**: For containerized development

### AWS Environment Setup
```bash
# Configure AWS profile for tacos
aws configure --profile tacos
# Enter your AWS credentials for ap-northeast-2 region

# Verify access to required resources
aws dynamodb list-tables --profile tacos --region ap-northeast-2
aws sqs list-queues --profile tacos --region ap-northeast-2
aws events list-rules --profile tacos --region ap-northeast-2
```

---

## Service Integration

### Gateway API (Go)

The Gateway API serves as the Backend for Frontend (BFF) and handles all external traffic.

#### 1. Add Dependency

```bash
cd gateway-api
go get github.com/traffic-tacos/proto-contracts@latest
go mod tidy
```

#### 2. Import Required Packages

```go
// main.go or service files
import (
    "context"
    "log"

    commonpb "github.com/traffic-tacos/proto-contracts/gen/go/common/v1"
    gatewaypb "github.com/traffic-tacos/proto-contracts/gen/go/gateway/v1"
    reservationpb "github.com/traffic-tacos/proto-contracts/gen/go/reservation/v1"
    paymentpb "github.com/traffic-tacos/proto-contracts/gen/go/payment/v1"

    "google.golang.org/grpc"
    "google.golang.org/grpc/credentials/insecure"
)
```

#### 3. Implement gRPC Servers

**Queue Service Implementation**:
```go
// internal/queue/server.go
type QueueServer struct {
    gatewaypb.UnimplementedQueueServiceServer
    redis    *redis.Client
    metrics  *prometheus.Registry
}

func (s *QueueServer) JoinQueue(
    ctx context.Context,
    req *gatewaypb.JoinQueueRequest,
) (*gatewaypb.JoinQueueResponse, error) {
    // Validate request
    if req.EventId == "" {
        return &gatewaypb.JoinQueueResponse{
            Error: &commonpb.Error{
                Code:    commonpb.ErrorCode_ERROR_CODE_INVALID_ARGUMENT,
                Message: "event_id is required",
                TraceId: getTraceID(ctx),
            },
        }, nil
    }

    // Generate waiting token
    waitingToken := fmt.Sprintf("wtkn_%s_%d", req.EventId, time.Now().Unix())

    // Add to Redis queue
    position, err := s.redis.LPush(ctx,
        fmt.Sprintf("queue:%s", req.EventId),
        waitingToken,
    ).Result()
    if err != nil {
        return nil, status.Errorf(codes.Internal, "failed to join queue: %v", err)
    }

    // Calculate ETA (example: 1 minute per 100 people)
    eta := int32(position * 60 / 100)

    return &gatewaypb.JoinQueueResponse{
        WaitingToken: waitingToken,
        PositionHint: int32(position),
        EtaSeconds:   eta,
        Status:       gatewaypb.QueueStatus_QUEUE_STATUS_WAITING,
        ExpiresAt:    timestamppb.New(time.Now().Add(time.Hour)),
    }, nil
}
```

**Gateway Service Implementation**:
```go
// internal/gateway/server.go
type GatewayServer struct {
    gatewaypb.UnimplementedGatewayServiceServer
    reservationClient reservationpb.ReservationServiceClient
    inventoryClient   reservationpb.InventoryClient
    paymentClient     paymentpb.PaymentServiceClient
    jwtValidator      *auth.JWTValidator
}

func (s *GatewayServer) CreateReservation(
    ctx context.Context,
    req *gatewaypb.CreateReservationRequest,
) (*gatewaypb.CreateReservationResponse, error) {
    // Validate JWT token
    userCtx, err := s.jwtValidator.ValidateToken(ctx, req.Metadata.Headers["authorization"])
    if err != nil {
        return &gatewaypb.CreateReservationResponse{
            Error: &commonpb.Error{
                Code:    commonpb.ErrorCode_ERROR_CODE_UNAUTHENTICATED,
                Message: "invalid token",
                TraceId: getTraceID(ctx),
            },
        }, nil
    }

    // Forward to reservation service
    resp, err := s.reservationClient.CreateReservation(ctx, &reservationpb.CreateReservationRequest{
        EventId:           req.EventId,
        SeatIds:           req.SeatIds,
        Quantity:          req.Quantity,
        UserId:            userCtx.UserId,
        ReservationToken:  req.ReservationToken,
        IdempotencyKey:    req.IdempotencyKey,
        Metadata: &reservationpb.ReservationMetadata{
            Source:    "gateway",
            IpAddress: req.Metadata.IpAddress,
            UserAgent: req.Metadata.UserAgent,
        },
    })
    if err != nil {
        return nil, status.Errorf(codes.Internal, "reservation failed: %v", err)
    }

    return &gatewaypb.CreateReservationResponse{
        ReservationId:  resp.ReservationId,
        Status:         resp.Status,
        HoldExpiresAt:  resp.HoldExpiresAt,
        ReservedSeats:  resp.ReservedSeats,
        TotalAmount:    resp.TotalAmount,
        PaymentUrl:     resp.PaymentUrl,
    }, nil
}
```

#### 4. Configure gRPC Server

```go
// cmd/gateway-api/main.go
func main() {
    lis, err := net.Listen("tcp", ":8000")
    if err != nil {
        log.Fatalf("failed to listen: %v", err)
    }

    // Create gRPC server
    s := grpc.NewServer(
        grpc.UnaryInterceptor(grpc_middleware.ChainUnaryServer(
            grpc_tracing.UnaryServerInterceptor(),
            grpc_auth.UnaryServerInterceptor(),
            grpc_logging.UnaryServerInterceptor(),
        )),
    )

    // Register services
    queueServer := queue.NewServer(redisClient, metricsRegistry)
    gatewaypb.RegisterQueueServiceServer(s, queueServer)

    gatewayServer := gateway.NewServer(
        reservationClient,
        inventoryClient,
        paymentClient,
        jwtValidator,
    )
    gatewaypb.RegisterGatewayServiceServer(s, gatewayServer)

    log.Printf("Gateway API server listening on :8000")
    if err := s.Serve(lis); err != nil {
        log.Fatalf("failed to serve: %v", err)
    }
}
```

#### 5. Environment Configuration

```yaml
# config/gateway.yaml
server:
  port: 8000
  grpc_timeout: 600ms

downstream_services:
  reservation_api:
    address: "reservation-api:8001"
    timeout: 500ms
  inventory_api:
    address: "inventory-api:8002"
    timeout: 250ms
  payment_sim_api:
    address: "payment-sim-api:8003"
    timeout: 500ms

redis:
  address: "redis:6379"
  password: ""
  db: 0

aws:
  region: "ap-northeast-2"
  profile: "tacos"
```

---

### Reservation API (Kotlin/Spring Boot)

The Reservation API manages the core reservation lifecycle with 60-second holds.

#### 1. Add Dependency

```kotlin
// build.gradle.kts
dependencies {
    implementation("com.traffic-tacos:proto-contracts:1.0.0")
    implementation("io.grpc:grpc-kotlin-stub:1.4.0")
    implementation("io.grpc:grpc-netty-shaded:1.60.1")
    implementation("org.jetbrains.kotlinx:kotlinx-coroutines-core:1.7.3")
}
```

#### 2. Configure gRPC Server

```kotlin
// src/main/kotlin/com/traffictacos/reservation/config/GrpcConfig.kt
@Configuration
@EnableConfigurationProperties(GrpcProperties::class)
class GrpcConfig {

    @Bean
    fun grpcServer(
        reservationService: ReservationServiceImpl,
        grpcProperties: GrpcProperties
    ): NettyChannelBuilder {
        return NettyChannelBuilder.forPort(grpcProperties.port)
            .addService(reservationService)
            .build()
    }
}

@ConfigurationProperties(prefix = "grpc")
data class GrpcProperties(
    val port: Int = 8001,
    val timeout: Duration = Duration.ofMillis(500)
)
```

#### 3. Implement Service

```kotlin
// src/main/kotlin/com/trafficstacos/reservation/service/ReservationServiceImpl.kt
@Service
class ReservationServiceImpl(
    private val reservationRepository: ReservationRepository,
    private val inventoryClient: InventoryClient,
    private val eventPublisher: EventPublisher,
    private val idempotencyService: IdempotencyService
) : ReservationServiceGrpcKt.ReservationServiceCoroutineImplBase() {

    override suspend fun createReservation(
        request: CreateReservationRequest
    ): CreateReservationResponse {
        // Check idempotency
        val existingReservation = idempotencyService.checkIdempotency(
            request.idempotencyKey,
            Duration.ofMinutes(5)
        )
        if (existingReservation != null) {
            return existingReservation
        }

        try {
            // Check inventory availability
            val availabilityResponse = inventoryClient.checkAvailability(
                CheckAvailabilityRequest.newBuilder()
                    .setEventId(request.eventId)
                    .addAllSeatIds(request.seatIdsList)
                    .setQuantity(request.quantity)
                    .build()
            )

            if (!availabilityResponse.available) {
                return CreateReservationResponse.newBuilder()
                    .setError(
                        Error.newBuilder()
                            .setCode(ErrorCode.ERROR_CODE_INVENTORY_CONFLICT)
                            .setMessage("Seats no longer available")
                            .setTraceId(MDC.get("traceId"))
                            .build()
                    )
                    .build()
            }

            // Reserve seats with 60-second hold
            val reserveResponse = inventoryClient.reserveSeat(
                ReserveSeatRequest.newBuilder()
                    .setReservationId(UUID.randomUUID().toString())
                    .setEventId(request.eventId)
                    .addAllSeatIds(request.seatIdsList)
                    .setQuantity(request.quantity)
                    .setUserId(request.userId)
                    .setHoldExpiresAt(
                        Timestamp.newBuilder()
                            .setSeconds(Instant.now().plusSeconds(60).epochSecond)
                            .build()
                    )
                    .setIdempotencyKey(request.idempotencyKey)
                    .build()
            )

            if (reserveResponse.status != HoldStatus.HOLD_STATUS_ACTIVE) {
                throw RuntimeException("Failed to reserve seats")
            }

            // Create reservation record
            val reservation = Reservation(
                id = reserveResponse.holdId,
                eventId = request.eventId,
                userId = request.userId,
                status = ReservationStatus.RESERVATION_STATUS_PENDING,
                seatIds = request.seatIdsList,
                quantity = request.quantity,
                totalAmount = calculateAmount(availabilityResponse.availableSeatsList),
                holdExpiresAt = reserveResponse.holdExpiresAt.toInstant(),
                createdAt = Instant.now(),
                idempotencyKey = request.idempotencyKey
            )

            reservationRepository.save(reservation)

            // Schedule expiry event (60 seconds)
            eventPublisher.publishReservationCreated(
                ReservationCreatedEvent(
                    reservationId = reservation.id,
                    eventId = reservation.eventId,
                    userId = reservation.userId,
                    holdExpiresAt = reservation.holdExpiresAt,
                    seatIds = reservation.seatIds
                )
            )

            val response = CreateReservationResponse.newBuilder()
                .setReservationId(reservation.id)
                .setStatus(reservation.status)
                .setHoldExpiresAt(
                    Timestamp.newBuilder()
                        .setSeconds(reservation.holdExpiresAt.epochSecond)
                        .build()
                )
                .addAllReservedSeats(availabilityResponse.availableSeatsList)
                .setTotalAmount(
                    Money.newBuilder()
                        .setAmount(reservation.totalAmount)
                        .setCurrency("KRW")
                        .build()
                )
                .setPaymentUrl("${paymentBaseUrl}/payment/${reservation.id}")
                .build()

            // Store for idempotency
            idempotencyService.storeResult(request.idempotencyKey, response)

            return response

        } catch (e: Exception) {
            logger.error("Failed to create reservation", e)
            return CreateReservationResponse.newBuilder()
                .setError(
                    Error.newBuilder()
                        .setCode(ErrorCode.ERROR_CODE_INTERNAL)
                        .setMessage("Internal error: ${e.message}")
                        .setTraceId(MDC.get("traceId"))
                        .build()
                )
                .build()
        }
    }

    override suspend fun confirmReservation(
        request: ConfirmReservationRequest
    ): ConfirmReservationResponse {
        // Verify payment status
        val paymentStatus = paymentClient.getPaymentStatus(
            GetPaymentStatusRequest.newBuilder()
                .setPaymentIntentId(request.paymentIntentId)
                .setUserId(request.userId)
                .build()
        )

        if (paymentStatus.payment.status != PaymentStatus.PAYMENT_STATUS_COMPLETED) {
            return ConfirmReservationResponse.newBuilder()
                .setError(
                    Error.newBuilder()
                        .setCode(ErrorCode.ERROR_CODE_PAYMENT_NOT_APPROVED)
                        .setMessage("Payment not completed")
                        .setTraceId(MDC.get("traceId"))
                        .build()
                )
                .build()
        }

        // Get reservation
        val reservation = reservationRepository.findById(request.reservationId)
            ?: return ConfirmReservationResponse.newBuilder()
                .setError(
                    Error.newBuilder()
                        .setCode(ErrorCode.ERROR_CODE_NOT_FOUND)
                        .setMessage("Reservation not found")
                        .setTraceId(MDC.get("traceId"))
                        .build()
                )
                .build()

        // Commit seats via inventory
        val commitResponse = inventoryClient.commitReservation(
            CommitReservationRequest.newBuilder()
                .setReservationId(reservation.id)
                .setEventId(reservation.eventId)
                .addAllSeatIds(reservation.seatIds)
                .setQuantity(reservation.quantity)
                .setPaymentIntentId(request.paymentIntentId)
                .setUserId(request.userId)
                .setIdempotencyKey(request.idempotencyKey)
                .build()
        )

        if (commitResponse.status != CommitStatus.COMMIT_STATUS_SUCCESS) {
            return ConfirmReservationResponse.newBuilder()
                .setError(
                    Error.newBuilder()
                        .setCode(ErrorCode.ERROR_CODE_INVENTORY_CONFLICT)
                        .setMessage("Failed to commit reservation")
                        .setTraceId(MDC.get("traceId"))
                        .build()
                )
                .build()
        }

        // Update reservation status
        reservation.status = ReservationStatus.RESERVATION_STATUS_CONFIRMED
        reservation.confirmedAt = Instant.now()
        reservation.orderId = commitResponse.orderId
        reservationRepository.save(reservation)

        // Publish confirmation event
        eventPublisher.publishReservationConfirmed(
            ReservationConfirmedEvent(
                reservationId = reservation.id,
                orderId = commitResponse.orderId,
                userId = reservation.userId,
                eventId = reservation.eventId,
                seatIds = reservation.seatIds,
                confirmedAt = reservation.confirmedAt!!
            )
        )

        return ConfirmReservationResponse.newBuilder()
            .setOrderId(commitResponse.orderId)
            .setStatus(ReservationStatus.RESERVATION_STATUS_CONFIRMED)
            .setConfirmedAt(
                Timestamp.newBuilder()
                    .setSeconds(reservation.confirmedAt!!.epochSecond)
                    .build()
            )
            .addAllConfirmedSeats(commitResponse.soldSeatsList)
            .build()
    }
}
```

#### 4. Configure AWS Integration

```kotlin
// src/main/kotlin/com/trafficstacos/reservation/config/AwsConfig.kt
@Configuration
class AwsConfig {

    @Bean
    fun dynamoDbEnhancedClient(): DynamoDbEnhancedClient {
        return DynamoDbEnhancedClient.builder()
            .dynamoDbClient(
                DynamoDbClient.builder()
                    .region(Region.AP_NORTHEAST_2)
                    .credentialsProvider(ProfileCredentialsProvider.create("tacos"))
                    .build()
            )
            .build()
    }

    @Bean
    fun eventBridgeClient(): EventBridgeClient {
        return EventBridgeClient.builder()
            .region(Region.AP_NORTHEAST_2)
            .credentialsProvider(ProfileCredentialsProvider.create("tacos"))
            .build()
    }

    @Bean
    fun sqsClient(): SqsClient {
        return SqsClient.builder()
            .region(Region.AP_NORTHEAST_2)
            .credentialsProvider(ProfileCredentialsProvider.create("tacos"))
            .build()
    }
}
```

---

### Inventory API (Go)

The Inventory API ensures zero overselling through DynamoDB conditional updates.

#### 1. Integration Setup

```go
// cmd/inventory-api/main.go
import (
    reservationpb "github.com/traffic-tacos/proto-contracts/gen/go/reservation/v1"
)

type InventoryServer struct {
    reservationpb.UnimplementedInventoryServer
    dynamoDB  *dynamodb.Client
    metrics   *prometheus.Registry
}

func (s *InventoryServer) CommitReservation(
    ctx context.Context,
    req *reservationpb.CommitReservationRequest,
) (*reservationpb.CommitReservationResponse, error) {
    // Start DynamoDB transaction
    transactionItems := make([]types.TransactWriteItem, 0, len(req.SeatIds)+1)

    // For each seat, update status from RESERVED to SOLD
    for _, seatID := range req.SeatIds {
        transactionItems = append(transactionItems, types.TransactWriteItem{
            Update: &types.Update{
                TableName: aws.String("inventory_seats"),
                Key: map[string]types.AttributeValue{
                    "seat_id": &types.AttributeValueMemberS{Value: seatID},
                },
                UpdateExpression: aws.String("SET #status = :sold, reservation_id = :reservation_id, updated_at = :now"),
                ConditionExpression: aws.String("#status = :reserved AND reservation_id = :reservation_id"),
                ExpressionAttributeNames: map[string]string{
                    "#status": "status",
                },
                ExpressionAttributeValues: map[string]types.AttributeValue{
                    ":sold":           &types.AttributeValueMemberS{Value: "SOLD"},
                    ":reserved":       &types.AttributeValueMemberS{Value: "RESERVED"},
                    ":reservation_id": &types.AttributeValueMemberS{Value: req.ReservationId},
                    ":now":           &types.AttributeValueMemberS{Value: time.Now().Format(time.RFC3339)},
                },
            },
        })
    }

    // Update inventory counts
    transactionItems = append(transactionItems, types.TransactWriteItem{
        Update: &types.Update{
            TableName: aws.String("inventory"),
            Key: map[string]types.AttributeValue{
                "event_id": &types.AttributeValueMemberS{Value: req.EventId},
                "sk":       &types.AttributeValueMemberS{Value: "metadata"},
            },
            UpdateExpression: aws.String("ADD remaining_seats :decrement SET last_updated = :now"),
            ExpressionAttributeValues: map[string]types.AttributeValue{
                ":decrement": &types.AttributeValueMemberN{Value: fmt.Sprintf("-%d", req.Quantity)},
                ":now":       &types.AttributeValueMemberS{Value: time.Now().Format(time.RFC3339)},
            },
        },
    })

    // Execute transaction
    _, err := s.dynamoDB.TransactWriteItems(ctx, &dynamodb.TransactWriteItemsInput{
        TransactItems: transactionItems,
    })

    if err != nil {
        var conditionalCheckFailed *types.ConditionalCheckFailedException
        if errors.As(err, &conditionalCheckFailed) {
            return &reservationpb.CommitReservationResponse{
                Status: reservationpb.CommitStatus_COMMIT_STATUS_FAILED_CONFLICT,
                Error: &commonpb.Error{
                    Code:    commonpb.ErrorCode_ERROR_CODE_INVENTORY_CONFLICT,
                    Message: "Seats no longer held for this reservation",
                    TraceId: getTraceID(ctx),
                },
            }, nil
        }
        return nil, status.Errorf(codes.Internal, "transaction failed: %v", err)
    }

    // Generate order ID
    orderID := fmt.Sprintf("ord_%s_%d", req.ReservationId, time.Now().Unix())

    // Build sold seats response
    soldSeats := make([]*commonpb.Seat, len(req.SeatIds))
    for i, seatID := range req.SeatIds {
        soldSeats[i] = &commonpb.Seat{
            Id:     seatID,
            Status: commonpb.SeatStatus_SEAT_STATUS_SOLD,
        }
    }

    return &reservationpb.CommitReservationResponse{
        OrderId:    orderID,
        SoldSeats:  soldSeats,
        Status:     reservationpb.CommitStatus_COMMIT_STATUS_SUCCESS,
        CommittedAt: timestamppb.Now(),
    }, nil
}
```

---

### Payment Sim API (Go)

#### 1. Integration with Webhook Support

```go
// internal/payment/server.go
import (
    paymentpb "github.com/traffic-tacos/proto-contracts/gen/go/payment/v1"
    gatewaypb "github.com/traffic-tacos/proto-contracts/gen/go/gateway/v1"
)

func (s *PaymentServer) CreatePaymentIntent(
    ctx context.Context,
    req *paymentpb.CreatePaymentIntentRequest,
) (*paymentpb.CreatePaymentIntentResponse, error) {
    // Create payment intent
    paymentIntent := &PaymentIntent{
        ID:            fmt.Sprintf("pay_%d", time.Now().Unix()),
        ReservationID: req.ReservationId,
        Amount:        req.Amount,
        UserID:        req.UserId,
        Method:        req.Method,
        Scenario:      req.Scenario,
        WebhookURL:    req.WebhookUrl,
        Status:        paymentpb.PaymentStatus_PAYMENT_STATUS_PENDING,
        CreatedAt:     time.Now(),
        ExpiresAt:     time.Now().Add(15 * time.Minute),
    }

    // Store in database
    if err := s.paymentRepo.Save(paymentIntent); err != nil {
        return nil, status.Errorf(codes.Internal, "failed to create payment: %v", err)
    }

    // Schedule async processing based on scenario
    go s.processPaymentAsync(paymentIntent)

    return &paymentpb.CreatePaymentIntentResponse{
        PaymentIntentId: paymentIntent.ID,
        Status:          paymentIntent.Status,
        ClientSecret:    fmt.Sprintf("secret_%s", paymentIntent.ID),
        PaymentUrl:      fmt.Sprintf("%s/payment/%s", s.baseURL, paymentIntent.ID),
        ExpiresAt:       timestamppb.New(paymentIntent.ExpiresAt),
    }, nil
}

func (s *PaymentServer) processPaymentAsync(payment *PaymentIntent) {
    var delay time.Duration
    var finalStatus paymentpb.PaymentStatus

    switch payment.Scenario {
    case paymentpb.PaymentScenario_PAYMENT_SCENARIO_APPROVE:
        delay = time.Duration(2+rand.Intn(3)) * time.Second
        finalStatus = paymentpb.PaymentStatus_PAYMENT_STATUS_COMPLETED
    case paymentpb.PaymentScenario_PAYMENT_SCENARIO_FAIL:
        delay = time.Duration(1+rand.Intn(2)) * time.Second
        finalStatus = paymentpb.PaymentStatus_PAYMENT_STATUS_FAILED
    case paymentpb.PaymentScenario_PAYMENT_SCENARIO_DELAY:
        delay = time.Duration(10+rand.Intn(20)) * time.Second
        finalStatus = paymentpb.PaymentStatus_PAYMENT_STATUS_COMPLETED
    case paymentpb.PaymentScenario_PAYMENT_SCENARIO_RANDOM:
        delay = time.Duration(2+rand.Intn(5)) * time.Second
        if rand.Float32() < 0.7 {
            finalStatus = paymentpb.PaymentStatus_PAYMENT_STATUS_COMPLETED
        } else {
            finalStatus = paymentpb.PaymentStatus_PAYMENT_STATUS_FAILED
        }
    }

    time.Sleep(delay)

    // Update payment status
    payment.Status = finalStatus
    payment.ProcessedAt = time.Now()
    s.paymentRepo.Save(payment)

    // Send webhook
    s.sendWebhook(payment)
}

func (s *PaymentServer) sendWebhook(payment *PaymentIntent) {
    webhookData := &gatewaypb.PaymentWebhookData{
        PaymentIntentId: payment.ID,
        ReservationId:   payment.ReservationID,
        TransactionId:   fmt.Sprintf("txn_%d", time.Now().Unix()),
        Status:          convertToWebhookStatus(payment.Status),
        Amount:          payment.Amount,
        ProcessedAt:     timestamppb.New(payment.ProcessedAt),
    }

    webhookReq := &gatewaypb.PaymentWebhookRequest{
        WebhookId: fmt.Sprintf("wh_%d", time.Now().Unix()),
        EventType: convertToWebhookType(payment.Status),
        Data:      webhookData,
        Timestamp: timestamppb.Now(),
        Signature: s.generateHMACSignature(webhookData),
        Source:    "payment-sim-api",
        Attempt:   1,
    }

    // Send to webhook URL
    if err := s.sendWebhookHTTP(payment.WebhookURL, webhookReq); err != nil {
        log.Printf("Failed to send webhook: %v", err)
        // Implement retry logic here
    }
}
```

---

### Reservation Worker (Go/Kotlin)

#### 1. Go Implementation (Kubernetes Job)

```go
// cmd/worker/main.go
import (
    reservationpb "github.com/traffic-tacos/proto-contracts/gen/go/reservation/v1"
)

type WorkerServer struct {
    reservationpb.UnimplementedWorkerServiceServer
    inventoryClient    reservationpb.InventoryClient
    reservationClient  *http.Client // REST client for reservation-api
    sqsClient         *sqs.Client
}

func (w *WorkerServer) ProcessReservationExpiry(
    ctx context.Context,
    req *reservationpb.ProcessExpiryRequest,
) (*reservationpb.ProcessExpiryResponse, error) {
    log.Printf("Processing expiry for reservation %s", req.ReservationId)

    // Release seats via inventory service
    releaseResp, err := w.inventoryClient.ReleaseHold(ctx, &reservationpb.ReleaseHoldRequest{
        ReservationId:   req.ReservationId,
        EventId:         req.EventId,
        SeatIds:         req.SeatIds,
        Quantity:        req.Quantity,
        Reason:          "EXPIRED",
        IdempotencyKey:  fmt.Sprintf("expire_%s_%d", req.ReservationId, time.Now().Unix()),
    })

    if err != nil {
        log.Printf("Failed to release hold: %v", err)
        return &reservationpb.ProcessExpiryResponse{
            Status:     reservationpb.ProcessingStatus_PROCESSING_STATUS_FAILED,
            NextAction: "retry",
            Error: &commonpb.Error{
                Code:    commonpb.ErrorCode_ERROR_CODE_INTERNAL,
                Message: fmt.Sprintf("Failed to release seats: %v", err),
                TraceId: getTraceID(ctx),
            },
        }, nil
    }

    // Update reservation status via REST API
    updateReq := map[string]interface{}{
        "status":     "EXPIRED",
        "expired_at": time.Now().Format(time.RFC3339),
    }

    if err := w.updateReservationStatus(req.ReservationId, updateReq); err != nil {
        log.Printf("Failed to update reservation status: %v", err)
        return &reservationpb.ProcessExpiryResponse{
            Status:     reservationpb.ProcessingStatus_PROCESSING_STATUS_FAILED,
            NextAction: "retry",
            Error: &commonpb.Error{
                Code:    commonpb.ErrorCode_ERROR_CODE_INTERNAL,
                Message: fmt.Sprintf("Failed to update status: %v", err),
                TraceId: getTraceID(ctx),
            },
        }, nil
    }

    return &reservationpb.ProcessExpiryResponse{
        Status:        reservationpb.ProcessingStatus_PROCESSING_STATUS_SUCCESS,
        ReleasedSeats: releaseResp.ReleasedSeats,
        ProcessedAt:   timestamppb.Now(),
        NextAction:    "completed",
    }, nil
}

// SQS message processing loop
func (w *WorkerServer) processSQSMessages(ctx context.Context) {
    for {
        select {
        case <-ctx.Done():
            return
        default:
            // Receive messages from SQS
            result, err := w.sqsClient.ReceiveMessage(ctx, &sqs.ReceiveMessageInput{
                QueueUrl:            aws.String(w.queueURL),
                MaxNumberOfMessages: 10,
                WaitTimeSeconds:     20,
            })

            if err != nil {
                log.Printf("Failed to receive SQS messages: %v", err)
                time.Sleep(5 * time.Second)
                continue
            }

            for _, msg := range result.Messages {
                if err := w.processMessage(ctx, msg); err != nil {
                    log.Printf("Failed to process message: %v", err)
                } else {
                    // Delete processed message
                    w.sqsClient.DeleteMessage(ctx, &sqs.DeleteMessageInput{
                        QueueUrl:      aws.String(w.queueURL),
                        ReceiptHandle: msg.ReceiptHandle,
                    })
                }
            }
        }
    }
}
```

#### 2. KEDA Scaling Configuration

```yaml
# k8s/reservation-worker-scaledobject.yaml
apiVersion: keda.sh/v1alpha1
kind: ScaledObject
metadata:
  name: reservation-worker-scaler
  namespace: traffic-tacos
spec:
  scaleTargetRef:
    name: reservation-worker
  minReplicaCount: 0
  maxReplicaCount: 50
  triggers:
  - type: aws-sqs-queue
    metadata:
      queueURL: https://sqs.ap-northeast-2.amazonaws.com/123456789/reservation-events
      queueLength: "10"
      awsRegion: "ap-northeast-2"
      identityOwner: pod
```

---

### Reservation Web (React)

#### 1. API Client Generation

While the frontend doesn't directly use gRPC, it interacts with the Gateway API REST endpoints that are built on the proto contracts.

```typescript
// src/types/api.ts - Generated from proto definitions
export interface QueueJoinRequest {
  event_id: string;
  user_id?: string;
  session_id: string;
}

export interface QueueJoinResponse {
  waiting_token: string;
  position_hint: number;
  eta_seconds: number;
  status: QueueStatus;
  expires_at: string;
}

export interface CreateReservationRequest {
  event_id: string;
  seat_ids?: string[];
  quantity: number;
  user_id: string;
  reservation_token: string;
  idempotency_key: string;
}

export interface CreateReservationResponse {
  reservation_id: string;
  status: ReservationStatus;
  hold_expires_at: string;
  reserved_seats: Seat[];
  total_amount: Money;
  payment_url: string;
}
```

#### 2. WebSocket Integration

```typescript
// src/services/websocket.ts
import { QueueUpdateEvent, ReservationUpdateEvent } from '../types/api';

export class WebSocketService {
  private ws: WebSocket | null = null;
  private reconnectAttempts = 0;
  private maxReconnectAttempts = 5;

  connect(waitingToken: string, sessionId: string): Promise<void> {
    return new Promise((resolve, reject) => {
      const wsUrl = `${process.env.REACT_APP_WS_URL}/queue/${waitingToken}?session_id=${sessionId}`;
      this.ws = new WebSocket(wsUrl);

      this.ws.onopen = () => {
        console.log('WebSocket connected');
        this.reconnectAttempts = 0;
        resolve();
      };

      this.ws.onmessage = (event) => {
        const data = JSON.parse(event.data) as QueueUpdateEvent;
        this.handleQueueUpdate(data);
      };

      this.ws.onclose = () => {
        console.log('WebSocket disconnected');
        this.handleReconnect();
      };

      this.ws.onerror = (error) => {
        console.error('WebSocket error:', error);
        reject(error);
      };
    });
  }

  private handleQueueUpdate(event: QueueUpdateEvent) {
    switch (event.type) {
      case 'QUEUE_EVENT_TYPE_POSITION_CHANGED':
        // Update queue position in UI
        this.updateQueuePosition(event.queue_update);
        break;
      case 'QUEUE_EVENT_TYPE_ADMISSION_READY':
        // Show admission ready notification
        this.showAdmissionReady();
        break;
      case 'QUEUE_EVENT_TYPE_TOKEN_EXPIRED':
        // Handle token expiry
        this.handleTokenExpiry();
        break;
    }
  }

  private handleReconnect() {
    if (this.reconnectAttempts < this.maxReconnectAttempts) {
      this.reconnectAttempts++;
      const delay = Math.pow(2, this.reconnectAttempts) * 1000; // Exponential backoff
      setTimeout(() => {
        console.log(`Reconnecting... attempt ${this.reconnectAttempts}`);
        // Reconnect logic here
      }, delay);
    }
  }
}
```

---

## Code Generation

### Automated Generation

```bash
# In proto-contracts repository
make generate          # Generate all languages
make generate-go        # Go only
make generate-kotlin    # Kotlin only

# Verify generation
make test              # Run integration tests
```

### Manual Generation

```bash
# Go services
./scripts/generate-go.sh

# Kotlin services
./scripts/generate-kotlin.sh

# Publish packages
./scripts/publish.sh
```

---

## Testing Integration

### Unit Tests

```go
// gateway-api/internal/queue/server_test.go
func TestQueueServer_JoinQueue(t *testing.T) {
    server := &QueueServer{
        redis:   setupTestRedis(t),
        metrics: prometheus.NewRegistry(),
    }

    req := &gatewaypb.JoinQueueRequest{
        EventId:   "test-event",
        UserId:    "test-user",
        SessionId: "test-session",
    }

    resp, err := server.JoinQueue(context.Background(), req)
    require.NoError(t, err)
    assert.NotEmpty(t, resp.WaitingToken)
    assert.Equal(t, gatewaypb.QueueStatus_QUEUE_STATUS_WAITING, resp.Status)
}
```

### Integration Tests

```bash
# Test service connectivity
./test_connections.sh test

# Test gRPC communication
grpcurl -plaintext localhost:8002 reservation.v1.Inventory/CheckAvailability

# Load testing
./scripts/load-test.sh
```

---

## Deployment Considerations

### Environment Variables

Each service requires these environment variables:

```bash
# Common
AWS_REGION=ap-northeast-2
AWS_PROFILE=tacos
OTEL_TRACE_ENDPOINT=http://jaeger:14268/api/traces

# Service-specific
GRPC_PORT=8001
HTTP_PORT=3001
DOWNSTREAM_RESERVATION_URL=reservation-api:8001
DOWNSTREAM_INVENTORY_URL=inventory-api:8002
DOWNSTREAM_PAYMENT_URL=payment-sim-api:8003

# DynamoDB tables
DYNAMODB_RESERVATIONS_TABLE=reservations
DYNAMODB_INVENTORY_TABLE=inventory
DYNAMODB_ORDERS_TABLE=orders

# SQS queues
SQS_RESERVATION_WORKER_QUEUE=reservation-events
SQS_DLQ_QUEUE=reservation-events-dlq

# EventBridge
EVENTBRIDGE_BUS_NAME=traffic-tacos-events
```

### Health Checks

```yaml
# Kubernetes health check example
livenessProbe:
  grpc:
    port: 8001
    service: "reservation.v1.ReservationService"
  initialDelaySeconds: 30
  periodSeconds: 10

readinessProbe:
  grpc:
    port: 8001
    service: "reservation.v1.ReservationService"
  initialDelaySeconds: 5
  periodSeconds: 5
```

### Monitoring

```yaml
# Prometheus metrics
- job_name: 'traffic-tacos-grpc'
  static_configs:
    - targets: ['gateway-api:8000', 'reservation-api:8001', 'inventory-api:8002']
  metrics_path: '/metrics'
  scrape_interval: 15s
```

This integration guide provides comprehensive examples for each service. For detailed API specifications, refer to [API_SPECIFICATION.md](API_SPECIFICATION.md).
# Traffic Tacos Proto Contracts API Specification

This document provides detailed API specifications for all gRPC services in the Traffic Tacos platform.

## Table of Contents

- [Gateway Services](#gateway-services)
  - [QueueService](#queueservice)
  - [GatewayService](#gatewayservice)
  - [WebSocketService](#websocketservice)
  - [WebhookService](#webhookservice)
- [Business Services](#business-services)
  - [ReservationService](#reservationservice)
  - [Inventory](#inventory)
  - [PaymentService](#paymentservice)
- [Background Services](#background-services)
  - [WorkerService](#workerservice)
- [Common Services](#common-services)
  - [AdminService](#adminservice)

---

## Gateway Services

### QueueService

**Package**: `gateway.v1`
**Purpose**: Manages queue admission control for 30k RPS traffic handling

#### Methods

##### JoinQueue
Adds a user to the waiting queue for an event.

```protobuf
rpc JoinQueue(JoinQueueRequest) returns (JoinQueueResponse);
```

**Request**:
```protobuf
message JoinQueueRequest {
  string event_id = 1;          // Required: Event identifier
  string user_id = 2;           // Optional: For authenticated users
  string session_id = 3;        // Required: For tracking anonymous users
  QueueMetadata metadata = 4;   // Browser info, IP, etc.
}
```

**Response**:
```protobuf
message JoinQueueResponse {
  string waiting_token = 1;     // Token for queue operations
  int32 position_hint = 2;      // Estimated position in queue
  int32 eta_seconds = 3;        // Estimated wait time
  QueueStatus status = 4;       // Current queue status
  google.protobuf.Timestamp expires_at = 5;
  common.v1.Error error = 6;
}
```

**Error Codes**:
- `INVALID_ARGUMENT`: Missing required fields
- `ALREADY_EXISTS`: User already in queue
- `UNAVAILABLE`: Queue system unavailable

##### GetQueueStatus
Retrieves current queue position and status.

```protobuf
rpc GetQueueStatus(GetQueueStatusRequest) returns (GetQueueStatusResponse);
```

**Request**:
```protobuf
message GetQueueStatusRequest {
  string waiting_token = 1;     // Required: Queue token from JoinQueue
}
```

**Response**:
```protobuf
message GetQueueStatusResponse {
  QueueStatus status = 1;       // Current status
  int32 position = 2;           // Current position in queue
  int32 eta_seconds = 3;        // Updated ETA
  bool admission_ready = 4;     // Can request admission
  google.protobuf.Timestamp expires_at = 5;
  common.v1.Error error = 6;
}
```

##### RequestAdmission
Requests admission from waiting queue to reservation system.

```protobuf
rpc RequestAdmission(RequestAdmissionRequest) returns (RequestAdmissionResponse);
```

**Request**:
```protobuf
message RequestAdmissionRequest {
  string waiting_token = 1;     // Required: Queue token
  string event_id = 2;          // Required: Event identifier
  string user_id = 3;           // Optional: For authenticated users
}
```

**Response**:
```protobuf
message RequestAdmissionResponse {
  AdmissionStatus admission = 1;        // Granted/Denied
  string reservation_token = 2;         // Token for making reservations
  int32 ttl_seconds = 3;               // Admission validity period
  google.protobuf.Timestamp valid_until = 4;
  common.v1.Error error = 5;
}
```

**Business Rules**:
- Queue tokens expire after 1 hour of inactivity
- Admission is granted based on system capacity
- Reservation tokens are valid for 5 minutes

---

### GatewayService

**Package**: `gateway.v1`
**Purpose**: Backend for Frontend (BFF) orchestration and authentication

#### Methods

##### ValidateToken
Validates JWT tokens and extracts user context.

```protobuf
rpc ValidateToken(ValidateTokenRequest) returns (ValidateTokenResponse);
```

**Request**:
```protobuf
message ValidateTokenRequest {
  string token = 1;              // Required: JWT token
  string required_scope = 2;     // Optional: Required permission scope
}
```

**Response**:
```protobuf
message ValidateTokenResponse {
  bool valid = 1;
  UserContext user = 2;          // User information from token
  repeated string scopes = 3;    // Available permissions
  google.protobuf.Timestamp expires_at = 4;
  common.v1.Error error = 5;
}
```

##### CreateReservation
Orchestrates reservation creation across services.

```protobuf
rpc CreateReservation(CreateReservationRequest) returns (CreateReservationResponse);
```

**Request**:
```protobuf
message CreateReservationRequest {
  string event_id = 1;           // Required: Event identifier
  repeated string seat_ids = 2;  // Optional: Specific seats
  int32 quantity = 3;            // Required: Number of seats
  string user_id = 4;            // Required: User identifier
  string reservation_token = 5;  // Required: From queue admission
  string idempotency_key = 6;    // Required: For duplicate prevention
  RequestMetadata metadata = 7;  // Request tracking
}
```

**Response**:
```protobuf
message CreateReservationResponse {
  string reservation_id = 1;
  reservation.v1.ReservationStatus status = 2;
  google.protobuf.Timestamp hold_expires_at = 3;
  repeated common.v1.Seat reserved_seats = 4;
  common.v1.Money total_amount = 5;
  string payment_url = 6;        // URL for payment processing
  common.v1.Error error = 7;
}
```

**Flow**:
1. Validates reservation token
2. Checks inventory availability
3. Creates reservation with 60-second hold
4. Returns payment URL for frontend

---

### WebSocketService

**Package**: `gateway.v1`
**Purpose**: Real-time event streaming for live updates

#### Methods

##### StreamQueueUpdates
Streams real-time queue position updates.

```protobuf
rpc StreamQueueUpdates(StreamQueueRequest) returns (stream QueueUpdateEvent);
```

**Request**:
```protobuf
message StreamQueueRequest {
  string waiting_token = 1;      // Required: Queue token
  string session_id = 2;         // Required: Session identifier
  string event_id = 3;           // Optional: Event filter
}
```

**Response Stream**:
```protobuf
message QueueUpdateEvent {
  EventType type = 1;            // Update type
  QueueUpdate queue_update = 2;  // Position changes
  SystemUpdate system_update = 3; // System announcements
  google.protobuf.Timestamp timestamp = 4;
  string correlation_id = 5;
}
```

**Event Types**:
- `QUEUE_EVENT_TYPE_POSITION_CHANGED`: Position update
- `QUEUE_EVENT_TYPE_ADMISSION_READY`: Can request admission
- `QUEUE_EVENT_TYPE_TOKEN_EXPIRED`: Token expired
- `SYSTEM_EVENT_TYPE_EVENT_SOLD_OUT`: Event sold out

##### StreamReservationUpdates
Streams reservation status changes.

```protobuf
rpc StreamReservationUpdates(StreamReservationRequest) returns (stream ReservationUpdateEvent);
```

**Usage**: Frontend subscribes to get real-time reservation status, hold expiry warnings, payment confirmations.

---

### WebhookService

**Package**: `gateway.v1`
**Purpose**: Handles external webhooks with signature verification

#### Methods

##### ReceivePaymentWebhook
Receives payment status webhooks from external payment services.

```protobuf
rpc ReceivePaymentWebhook(PaymentWebhookRequest) returns (PaymentWebhookResponse);
```

**Request**:
```protobuf
message PaymentWebhookRequest {
  string webhook_id = 1;         // Webhook identifier
  PaymentWebhookType event_type = 2; // approved/failed/cancelled
  PaymentWebhookData data = 3;   // Payment details
  google.protobuf.Timestamp timestamp = 4;
  string signature = 5;          // HMAC signature
  string source = 6;             // payment-sim-api, stripe, etc.
  int32 attempt = 7;             // Retry attempt number
}
```

**Security**: All webhooks must include valid HMAC-SHA256 signatures.

---

## Business Services

### ReservationService

**Package**: `reservation.v1`
**Purpose**: Core reservation lifecycle management with 60-second holds

#### Methods

##### CreateReservation
Creates a new reservation with temporary hold.

```protobuf
rpc CreateReservation(CreateReservationRequest) returns (CreateReservationResponse);
```

**Request**:
```protobuf
message CreateReservationRequest {
  string event_id = 1;           // Required: Event identifier
  repeated string seat_ids = 2;  // Optional: Specific seat selection
  int32 quantity = 3;            // Required: Number of seats
  string user_id = 4;            // Required: User identifier
  string reservation_token = 5;  // Required: From queue admission
  string idempotency_key = 6;    // Required: UUID for deduplication
  ReservationMetadata metadata = 7; // Tracking metadata
}
```

**Response**:
```protobuf
message CreateReservationResponse {
  string reservation_id = 1;     // Unique reservation identifier
  ReservationStatus status = 2;  // PENDING (initial state)
  google.protobuf.Timestamp hold_expires_at = 3; // 60 seconds from now
  repeated common.v1.Seat reserved_seats = 4;
  common.v1.Money total_amount = 5;
  string payment_url = 6;        // Frontend payment URL
  common.v1.Error error = 7;
}
```

**Business Logic**:
1. Validates reservation token (from queue admission)
2. Checks inventory availability via gRPC
3. Creates 60-second hold in DynamoDB
4. Schedules expiry event via EventBridge
5. Returns reservation details for payment

**Idempotency**: Same `idempotency_key` returns existing reservation if within 5-minute window.

##### ConfirmReservation
Confirms reservation after successful payment.

```protobuf
rpc ConfirmReservation(ConfirmReservationRequest) returns (ConfirmReservationResponse);
```

**Request**:
```protobuf
message ConfirmReservationRequest {
  string reservation_id = 1;     // Required: Reservation to confirm
  string payment_intent_id = 2;  // Required: Successful payment
  string user_id = 3;            // Required: Authorization
  string idempotency_key = 4;    // Required: Duplicate prevention
}
```

**Response**:
```protobuf
message ConfirmReservationResponse {
  string order_id = 1;           // Generated order identifier
  ReservationStatus status = 2;  // CONFIRMED
  google.protobuf.Timestamp confirmed_at = 3;
  repeated common.v1.Seat confirmed_seats = 4;
  common.v1.Error error = 5;
}
```

**Flow**:
1. Verifies payment status via PaymentService
2. Commits seats via Inventory.CommitReservation
3. Updates status to CONFIRMED
4. Creates order record
5. Publishes confirmation event

---

### Inventory

**Package**: `reservation.v1`
**Purpose**: Seat availability and zero-oversell guarantee

#### Methods

##### CheckAvailability
Checks seat availability for an event.

```protobuf
rpc CheckAvailability(CheckAvailabilityRequest) returns (CheckAvailabilityResponse);
```

**Request**:
```protobuf
message CheckAvailabilityRequest {
  string event_id = 1;           // Required: Event identifier
  repeated string seat_ids = 2;  // Optional: Specific seats to check
  int32 quantity = 3;            // Optional: Number of any seats
  string section = 4;            // Optional: Preferred section
}
```

**Response**:
```protobuf
message CheckAvailabilityResponse {
  bool available = 1;            // Overall availability
  repeated common.v1.Seat available_seats = 2; // Available seat details
  repeated string unavailable_seat_ids = 3;     // Unavailable seats
  int32 remaining_in_section = 4;               // Count in section
  common.v1.Error error = 5;
}
```

##### CommitReservation
Permanently commits reserved seats (zero oversell).

```protobuf
rpc CommitReservation(CommitReservationRequest) returns (CommitReservationResponse);
```

**Implementation**: Uses DynamoDB conditional updates with optimistic locking to prevent overselling.

**Request**:
```protobuf
message CommitReservationRequest {
  string reservation_id = 1;     // Required: Reservation identifier
  string event_id = 2;           // Required: Event identifier
  repeated string seat_ids = 3;  // Required: Seats to commit
  int32 quantity = 4;            // Required: Quantity validation
  string payment_intent_id = 5;  // Required: Payment reference
  string user_id = 6;            // Required: User reference
  string idempotency_key = 7;    // Required: Duplicate prevention
}
```

**Zero Oversell Logic**:
```
FOR EACH seat IN seat_ids:
  UPDATE inventory_seats
  SET status = 'SOLD', reservation_id = :reservation_id
  WHERE seat_id = :seat_id AND status = 'RESERVED'
    AND reservation_id = :reservation_id

  IF updated_count = 0:
    ROLLBACK and return CONFLICT error
```

---

### PaymentService

**Package**: `payment.v1`
**Purpose**: Payment processing simulation with webhook notifications

#### Methods

##### CreatePaymentIntent
Creates a payment intent for reservation.

```protobuf
rpc CreatePaymentIntent(CreatePaymentIntentRequest) returns (CreatePaymentIntentResponse);
```

**Request**:
```protobuf
message CreatePaymentIntentRequest {
  string reservation_id = 1;     // Required: Associated reservation
  common.v1.Money amount = 2;    // Required: Payment amount
  string user_id = 3;            // Required: User identifier
  PaymentMethod method = 4;      // Required: Payment method
  PaymentScenario scenario = 5;  // Required: Simulation scenario
  string webhook_url = 6;        // Required: Callback URL
  string idempotency_key = 7;    // Required: Duplicate prevention
}
```

**Response**:
```protobuf
message CreatePaymentIntentResponse {
  string payment_intent_id = 1;  // Unique payment identifier
  PaymentStatus status = 2;      // PENDING (initial)
  string client_secret = 3;      // For frontend payment flow
  string payment_url = 4;        // Redirect URL for payment
  google.protobuf.Timestamp expires_at = 5; // Payment expiry
  common.v1.Error error = 6;
}
```

**Simulation Scenarios**:
- `PAYMENT_SCENARIO_APPROVE`: Always succeeds after 2-5 seconds
- `PAYMENT_SCENARIO_FAIL`: Always fails after 1-3 seconds
- `PAYMENT_SCENARIO_DELAY`: Succeeds after 10-30 seconds
- `PAYMENT_SCENARIO_RANDOM`: Random outcome (70% success rate)
- `PAYMENT_SCENARIO_TIMEOUT`: Simulates payment timeout

**Webhook Flow**:
1. Frontend initiates payment via `payment_url`
2. Payment processing happens asynchronously
3. Webhook sent to `webhook_url` with result
4. ReservationService processes webhook for confirmation

---

## Background Services

### WorkerService

**Package**: `reservation.v1`
**Purpose**: Background event processing with Kubernetes Job + KEDA scaling

#### Methods

##### ProcessReservationExpiry
Processes reservation expiry events (60-second timeout).

```protobuf
rpc ProcessReservationExpiry(ProcessExpiryRequest) returns (ProcessExpiryResponse);
```

**Request**:
```protobuf
message ProcessExpiryRequest {
  string reservation_id = 1;     // Required: Expired reservation
  string event_id = 2;           // Required: Event identifier
  repeated string seat_ids = 3;  // Required: Seats to release
  int32 quantity = 4;            // Required: Quantity validation
  google.protobuf.Timestamp expired_at = 5; // Expiry timestamp
  string correlation_id = 6;     // Required: Event correlation
  int32 retry_count = 7;         // Current retry attempt
}
```

**Response**:
```protobuf
message ProcessExpiryResponse {
  ProcessingStatus status = 1;   // SUCCESS/FAILED/RETRY
  repeated common.v1.Seat released_seats = 2; // Released seats
  google.protobuf.Timestamp processed_at = 3;
  string next_action = 4;        // "completed", "retry", "dlq"
  common.v1.Error error = 5;
}
```

**Processing Logic**:
1. Validates reservation is expired and not confirmed
2. Calls `Inventory.ReleaseHold` to free seats
3. Updates reservation status to EXPIRED
4. Publishes expiry event for analytics

**KEDA Scaling**: Auto-scales based on SQS queue depth (0-N pods).

##### ProcessPaymentResult
Processes payment webhook results (approved/failed).

```protobuf
rpc ProcessPaymentResult(ProcessPaymentRequest) returns (ProcessPaymentResponse);
```

**Flow for Payment Approved**:
1. Validates payment is approved
2. Calls `Inventory.CommitReservation` to finalize seats
3. Updates reservation status to CONFIRMED
4. Creates order record
5. Publishes confirmation event

**Flow for Payment Failed**:
1. Calls `Inventory.ReleaseHold` to free seats
2. Updates reservation status to CANCELLED
3. Publishes cancellation event

---

## Common Services

### AdminService

**Package**: `common.v1`
**Purpose**: System monitoring and operational tools

#### Methods

##### GetSystemHealth
Retrieves overall system health status.

```protobuf
rpc GetSystemHealth(SystemHealthRequest) returns (SystemHealthResponse);
```

**Response**:
```protobuf
message SystemHealthResponse {
  SystemHealthStatus overall_status = 1; // HEALTHY/DEGRADED/UNHEALTHY
  repeated ServiceHealthStatus services = 2; // Per-service status
  repeated DependencyStatus dependencies = 3; // External dependencies
  google.protobuf.Timestamp checked_at = 4;
  Error error = 5;
}
```

**Monitored Dependencies**:
- DynamoDB tables (reservations, inventory, orders)
- SQS queues (reservation-worker)
- EventBridge (custom event bus)
- Redis (gateway caching)

##### EmergencyAction
Executes emergency operational procedures.

```protobuf
rpc EmergencyAction(EmergencyActionRequest) returns (EmergencyActionResponse);
```

**Available Actions**:
- `EMERGENCY_ACTION_TYPE_STOP_ADMISSIONS`: Stop new queue admissions
- `EMERGENCY_ACTION_TYPE_CANCEL_RESERVATIONS`: Cancel all pending reservations
- `EMERGENCY_ACTION_TYPE_CIRCUIT_BREAKER`: Enable circuit breaker mode
- `EMERGENCY_ACTION_TYPE_MAINTENANCE_MODE`: Enter maintenance mode

**Security**: Requires special admin privileges and confirmation flag.

---

## Error Handling

All services use standardized error codes from `common.v1.ErrorCode`:

### Client Errors (4xx equivalent)
- `ERROR_CODE_INVALID_ARGUMENT`: Invalid request parameters
- `ERROR_CODE_UNAUTHENTICATED`: Missing or invalid JWT token
- `ERROR_CODE_FORBIDDEN`: Insufficient permissions
- `ERROR_CODE_NOT_FOUND`: Resource not found
- `ERROR_CODE_ALREADY_EXISTS`: Duplicate resource
- `ERROR_CODE_IDEMPOTENCY_REQUIRED`: Missing idempotency key
- `ERROR_CODE_RESERVATION_EXPIRED`: Reservation hold expired
- `ERROR_CODE_INVENTORY_CONFLICT`: Seat no longer available

### Server Errors (5xx equivalent)
- `ERROR_CODE_INTERNAL`: Internal service error
- `ERROR_CODE_UNAVAILABLE`: Service temporarily unavailable
- `ERROR_CODE_TIMEOUT`: Request timeout
- `ERROR_CODE_UPSTREAM_TIMEOUT`: Downstream service timeout

### Error Response Format
```protobuf
message Error {
  ErrorCode code = 1;            // Standard error code
  string message = 2;            // Human-readable message
  string trace_id = 3;           // Correlation ID for debugging
  repeated ErrorDetail details = 4; // Additional context
}
```

---

## Performance Specifications

### Latency Targets
- **QueueService**: P95 < 50ms
- **GatewayService**: P95 < 100ms
- **ReservationService**: P95 < 200ms
- **Inventory**: P95 < 50ms (critical path)
- **PaymentService**: P95 < 100ms
- **WorkerService**: P95 < 80ms (batch processing)

### Throughput Targets
- **System-wide**: 30,000 RPS sustained
- **Queue admissions**: 1,000 RPS controlled
- **Reservation creation**: 500-1,500 RPS
- **Payment processing**: 300-800 RPS

### Timeout Configuration
- **Client → Gateway**: 600ms
- **Gateway → Services**: 500ms
- **Service → Inventory**: 250ms (critical)
- **Webhook processing**: 30s

---

This specification covers all gRPC services and their integration patterns. For implementation examples, see the [Integration Guide](INTEGRATION_GUIDE.md).
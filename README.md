# Traffic Tacos Proto Contracts

This repository contains the centralized gRPC protocol definitions for the Traffic Tacos microservices platform.

## Table of Contents

- [Architecture Overview](#architecture-overview)
- [Repository Structure](#repository-structure)
- [Services & Proto Definitions](#services--proto-definitions)
- [Installation & Usage](#installation--usage)
  - [Go Projects](#go-projects)
  - [Kotlin/Java Projects](#kotlinjava-projects)
  - [Server Implementation Examples](#server-implementation-examples)
- [Quick Start Guide](#quick-start-guide)
- [Development](#development)
- [Performance Targets](#performance-targets)
- [Versioning](#versioning)
- [Contributing](#contributing)
- [Related Repositories](#related-repositories)

## Architecture Overview

Traffic Tacos is a high-performance ticket reservation system designed to handle **30k RPS traffic** with the following service architecture:

```
                    Layer 0: Frontend
              ┌─────────────────────────┐
              │   Reservation Web       │
              │     (React/Vite)        │
              └─────────┬───────────────┘
                        │ HTTP/REST + WebSocket
                        ▼
                    Layer 1: API Gateway
                ┌─────────────────────────┐
                │     Gateway API         │
                │    (Go/Fiber)          │
                └─────────┬───────────────┘
                          │ gRPC
                ┌─────────┼───────────────┐
                │         │               │
        Layer 2: Business Services        │
     ┌─────────────────┐ ┌─────────────────┐ ┌─────────────────┐
     │ Reservation API │ │  Inventory API  │ │ Payment Sim API │
     │ (Kotlin/Spring) │ │   (Go/gRPC)     │ │   (Go/Echo)     │
     └─────────┬───────┘ └─────────────────┘ └─────────────────┘
               │
               │ Events (EventBridge/SQS)
               ▼
        Layer 3: Background Processing
     ┌─────────────────────────────────────┐
     │      Reservation Worker             │
     │      (Kubernetes Job + KEDA)        │
     └─────────────────────────────────────┘
```

## Repository Structure

```
proto-contracts/
├── proto/
│   ├── reservation/v1/     # 예약 서비스 프로토콜
│   ├── payment/v1/         # 결제 서비스 프로토콜
│   ├── gateway/v1/         # 게이트웨이 프로토콜
│   └── common/v1/          # 공통 타입 정의
├── gen/                    # 생성된 코드
│   ├── go/                # Go 클라이언트/서버 코드
│   └── java/              # Java/Kotlin 클라이언트/서버 코드
├── scripts/               # 코드 생성 스크립트
└── .github/workflows/     # CI/CD 파이프라인
```

## Services & Proto Definitions

### Layer 1: API Gateway (gRPC)

- **Gateway Service** (`gateway/v1/gateway.proto`)
  - BFF (Backend for Frontend) 역할
  - 인증/인가, 레이트 리미팅
  - 서비스 오케스트레이션

- **Queue Service** (`gateway/v1/queue.proto`)
  - 대기열 관리 (30k RPS → 평탄화)
  - 입장 제어 및 트래픽 조절
  - 실시간 위치 업데이트

- **WebSocket Service** (`gateway/v1/websocket.proto`)
  - 실시간 이벤트 스트리밍
  - 대기열 위치, 예약 상태 업데이트
  - 결제 진행 상황 알림

- **Webhook Service** (`gateway/v1/webhook.proto`)
  - 외부 이벤트 수신 (결제 웹훅)
  - 예약 만료 알림 처리
  - HMAC 서명 검증

### Layer 2: Business Services (gRPC)

- **Reservation Service** (`reservation/v1/reservation.proto`)
  - 60초 Hold 메커니즘
  - EventBridge 기반 만료 처리
  - 멱등성 보장

- **Inventory Service** (`reservation/v1/inventory.proto`)
  - 실시간 재고 관리
  - 오버셀 0% 보장
  - DynamoDB 조건부 업데이트

- **Payment Service** (`payment/v1/payment.proto`)
  - 결제 시뮬레이션 (approve/fail/delay)
  - Webhook 기반 비동기 처리

### Layer 3: Background Processing (gRPC)

- **Worker Service** (`reservation/v1/worker.proto`)
  - 예약 만료 처리 (60초 홀드)
  - 결제 결과 후속 처리
  - 보상 트랜잭션 처리
  - Kubernetes Job + KEDA 스케일링

### Common Types (`common/v1/`)

- **types.proto**: Money, Timestamp, Address 등 공통 타입
- **errors.proto**: 통일된 에러 코드 및 메시지
- **admin.proto**: 시스템 관리 및 모니터링 기능

## Installation & Usage

### Go Projects

Traffic Tacos proto contracts are available as a Go module for easy integration.

#### Installation

```bash
go get github.com/traffic-tacos/proto-contracts@latest
```

#### Project Setup

Add to your `go.mod`:
```go
module your-service

go 1.23

require (
    github.com/traffic-tacos/proto-contracts v0.1.0
    google.golang.org/grpc v1.75.1
    google.golang.org/protobuf v1.36.6
)
```

#### Import and Usage

```go
package main

import (
    "context"
    "log"
    "time"

    commonv1 "github.com/traffic-tacos/proto-contracts/gen/go/common/v1"
    gatewayv1 "github.com/traffic-tacos/proto-contracts/gen/go/gateway/v1"
    reservationv1 "github.com/traffic-tacos/proto-contracts/gen/go/reservation/v1"
    paymentv1 "github.com/traffic-tacos/proto-contracts/gen/go/payment/v1"

    "google.golang.org/grpc"
    "google.golang.org/grpc/credentials/insecure"
)

func main() {
    // Connect to services
    conn, err := grpc.Dial("localhost:8080", grpc.WithTransportCredentials(insecure.NewCredentials()))
    if err != nil {
        log.Fatal(err)
    }
    defer conn.Close()

    // Create service clients
    queueClient := gatewayv1.NewQueueServiceClient(conn)
    reservationClient := reservationv1.NewReservationServiceClient(conn)
    inventoryClient := reservationv1.NewInventoryServiceClient(conn)
    paymentClient := paymentv1.NewPaymentServiceClient(conn)

    // Example: Join queue
    queueResp, err := queueClient.JoinQueue(context.Background(), &gatewayv1.JoinQueueRequest{
        EventId: "event_123",
        UserId:  "user_456",
    })
    if err != nil {
        log.Fatal(err)
    }
    log.Printf("Queue position: %d", queueResp.Position)

    // Example: Check inventory
    invResp, err := inventoryClient.CheckAvailability(context.Background(), &reservationv1.CheckAvailabilityRequest{
        EventId:  "event_123",
        Quantity: 2,
    })
    if err != nil {
        log.Fatal(err)
    }
    log.Printf("Available seats: %d", len(invResp.AvailableSeats))

    // Example: Create reservation
    reservation, err := reservationClient.CreateReservation(context.Background(), &reservationv1.CreateReservationRequest{
        EventId:  "event_123",
        UserId:   "user_456",
        SeatIds:  []string{"A1", "A2"},
        Quantity: 2,
        TotalAmount: &commonv1.Money{
            Amount:   100000, // 1000 KRW
            Currency: "KRW",
        },
    })
    if err != nil {
        log.Fatal(err)
    }
    log.Printf("Reservation created: %s", reservation.ReservationId)
}
```

### Kotlin/Java Projects

#### Gradle Setup (build.gradle.kts)

```kotlin
dependencies {
    // Proto contracts
    implementation("com.traffic-tacos:proto-contracts:1.0.0")

    // gRPC dependencies
    implementation("io.grpc:grpc-kotlin-stub:1.4.3")
    implementation("io.grpc:grpc-protobuf:1.69.0")
    implementation("io.grpc:grpc-netty:1.69.0")

    // Coroutines for async operations
    implementation("org.jetbrains.kotlinx:kotlinx-coroutines-core:1.9.0")
}
```

#### Maven Setup (pom.xml)

```xml
<dependencies>
    <!-- Proto contracts -->
    <dependency>
        <groupId>com.traffic-tacos</groupId>
        <artifactId>proto-contracts</artifactId>
        <version>1.0.0</version>
    </dependency>

    <!-- gRPC dependencies -->
    <dependency>
        <groupId>io.grpc</groupId>
        <artifactId>grpc-kotlin-stub</artifactId>
        <version>1.4.3</version>
    </dependency>
    <dependency>
        <groupId>io.grpc</groupId>
        <artifactId>grpc-protobuf</artifactId>
        <version>1.69.0</version>
    </dependency>
    <dependency>
        <groupId>io.grpc</groupId>
        <artifactId>grpc-netty</artifactId>
        <version>1.69.0</version>
    </dependency>
</dependencies>
```

#### Kotlin Usage Example

```kotlin
package com.traffic_tacos.example

import com.traffic_tacos.common.v1.Money
import com.traffic_tacos.gateway.v1.JoinQueueRequest
import com.traffic_tacos.gateway.v1.QueueServiceGrpcKt
import com.traffic_tacos.reservation.v1.CreateReservationRequest
import com.traffic_tacos.reservation.v1.ReservationServiceGrpcKt
import com.traffic_tacos.reservation.v1.CheckAvailabilityRequest
import com.traffic_tacos.reservation.v1.InventoryServiceGrpcKt
import com.traffic_tacos.payment.v1.CreatePaymentIntentRequest
import com.traffic_tacos.payment.v1.PaymentServiceGrpcKt

import io.grpc.ManagedChannelBuilder
import kotlinx.coroutines.runBlocking

class TrafficTacosClient {

    private val channel = ManagedChannelBuilder
        .forAddress("localhost", 8080)
        .usePlaintext()
        .build()

    private val queueService = QueueServiceGrpcKt.QueueServiceCoroutineStub(channel)
    private val reservationService = ReservationServiceGrpcKt.ReservationServiceCoroutineStub(channel)
    private val inventoryService = InventoryServiceGrpcKt.InventoryServiceCoroutineStub(channel)
    private val paymentService = PaymentServiceGrpcKt.PaymentServiceCoroutineStub(channel)

    suspend fun makeReservation(eventId: String, userId: String) {
        try {
            // 1. Join queue
            val queueResponse = queueService.joinQueue(
                JoinQueueRequest.newBuilder()
                    .setEventId(eventId)
                    .setUserId(userId)
                    .build()
            )
            println("Queue position: ${queueResponse.position}")

            // 2. Check availability
            val availabilityResponse = inventoryService.checkAvailability(
                CheckAvailabilityRequest.newBuilder()
                    .setEventId(eventId)
                    .setQuantity(2)
                    .build()
            )
            println("Available seats: ${availabilityResponse.availableSeatsCount}")

            // 3. Create reservation
            val reservationResponse = reservationService.createReservation(
                CreateReservationRequest.newBuilder()
                    .setEventId(eventId)
                    .setUserId(userId)
                    .addSeatIds("A1")
                    .addSeatIds("A2")
                    .setQuantity(2)
                    .setTotalAmount(
                        Money.newBuilder()
                            .setAmount(100000)
                            .setCurrency("KRW")
                            .build()
                    )
                    .build()
            )
            println("Reservation created: ${reservationResponse.reservationId}")

            // 4. Process payment
            val paymentResponse = paymentService.createPaymentIntent(
                CreatePaymentIntentRequest.newBuilder()
                    .setReservationId(reservationResponse.reservationId)
                    .setUserId(userId)
                    .setAmount(
                        Money.newBuilder()
                            .setAmount(100000)
                            .setCurrency("KRW")
                            .build()
                    )
                    .build()
            )
            println("Payment intent: ${paymentResponse.paymentIntentId}")

        } catch (e: Exception) {
            println("Error: ${e.message}")
        }
    }

    fun close() {
        channel.shutdown()
    }
}

fun main() = runBlocking {
    val client = TrafficTacosClient()
    client.makeReservation("event_123", "user_456")
    client.close()
}
```

#### Java Usage Example

```java
package com.traffic_tacos.example;

import com.traffic_tacos.common.v1.Money;
import com.traffic_tacos.gateway.v1.JoinQueueRequest;
import com.traffic_tacos.gateway.v1.QueueServiceGrpc;
import com.traffic_tacos.reservation.v1.CreateReservationRequest;
import com.traffic_tacos.reservation.v1.ReservationServiceGrpc;

import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;

public class TrafficTacosJavaClient {

    private final ManagedChannel channel;
    private final QueueServiceGrpc.QueueServiceBlockingStub queueService;
    private final ReservationServiceGrpc.ReservationServiceBlockingStub reservationService;

    public TrafficTacosJavaClient() {
        channel = ManagedChannelBuilder
            .forAddress("localhost", 8080)
            .usePlaintext()
            .build();

        queueService = QueueServiceGrpc.newBlockingStub(channel);
        reservationService = ReservationServiceGrpc.newBlockingStub(channel);
    }

    public void makeReservation(String eventId, String userId) {
        try {
            // Join queue
            var queueResponse = queueService.joinQueue(
                JoinQueueRequest.newBuilder()
                    .setEventId(eventId)
                    .setUserId(userId)
                    .build()
            );
            System.out.println("Queue position: " + queueResponse.getPosition());

            // Create reservation
            var reservationResponse = reservationService.createReservation(
                CreateReservationRequest.newBuilder()
                    .setEventId(eventId)
                    .setUserId(userId)
                    .addSeatIds("A1")
                    .addSeatIds("A2")
                    .setQuantity(2)
                    .setTotalAmount(
                        Money.newBuilder()
                            .setAmount(100000)
                            .setCurrency("KRW")
                            .build()
                    )
                    .build()
            );
            System.out.println("Reservation created: " + reservationResponse.getReservationId());

        } catch (Exception e) {
            System.err.println("Error: " + e.getMessage());
        }
    }

    public void close() {
        channel.shutdown();
    }

    public static void main(String[] args) {
        var client = new TrafficTacosJavaClient();
        client.makeReservation("event_123", "user_456");
        client.close();
    }
}
```

### Server Implementation Examples

#### Go gRPC Server

```go
package main

import (
    "context"
    "log"
    "net"

    reservationv1 "github.com/traffic-tacos/proto-contracts/gen/go/reservation/v1"
    "google.golang.org/grpc"
)

type reservationServer struct {
    reservationv1.UnimplementedReservationServiceServer
}

func (s *reservationServer) CreateReservation(ctx context.Context, req *reservationv1.CreateReservationRequest) (*reservationv1.CreateReservationResponse, error) {
    // Implementation logic here
    return &reservationv1.CreateReservationResponse{
        ReservationId: "rsv_" + req.UserId + "_" + req.EventId,
        Status:        reservationv1.ReservationStatus_RESERVATION_STATUS_PENDING,
    }, nil
}

func main() {
    lis, err := net.Listen("tcp", ":8080")
    if err != nil {
        log.Fatal(err)
    }

    server := grpc.NewServer()
    reservationv1.RegisterReservationServiceServer(server, &reservationServer{})

    log.Println("Server starting on :8080")
    if err := server.Serve(lis); err != nil {
        log.Fatal(err)
    }
}
```

#### Kotlin/Spring Boot gRPC Server

```kotlin
@GrpcService
class ReservationServiceImpl : ReservationServiceGrpcKt.ReservationServiceCoroutineImplBase() {

    override suspend fun createReservation(request: CreateReservationRequest): CreateReservationResponse {
        // Implementation logic here
        return CreateReservationResponse.newBuilder()
            .setReservationId("rsv_${request.userId}_${request.eventId}")
            .setStatus(ReservationStatus.RESERVATION_STATUS_PENDING)
            .build()
    }
}
```

## Quick Start Guide

### 1. Setting Up Your Project

Choose your language and follow the setup:

**Go Project:**
```bash
# Create new Go module
go mod init my-traffic-tacos-service

# Add proto contracts dependency
go get github.com/traffic-tacos/proto-contracts@latest

# Add gRPC dependencies
go get google.golang.org/grpc@latest
go get google.golang.org/protobuf@latest
```

**Kotlin/Gradle Project:**
```kotlin
// build.gradle.kts
plugins {
    kotlin("jvm") version "2.1.0"
}

dependencies {
    implementation("com.traffic-tacos:proto-contracts:1.0.0")
    implementation("io.grpc:grpc-kotlin-stub:1.4.3")
    implementation("io.grpc:grpc-protobuf:1.69.0")
    implementation("io.grpc:grpc-netty:1.69.0")
    implementation("org.jetbrains.kotlinx:kotlinx-coroutines-core:1.9.0")
}
```

### 2. Basic Client Implementation

**Go Client (5 minutes):**
```go
package main

import (
    "context"
    "log"

    gatewayv1 "github.com/traffic-tacos/proto-contracts/gen/go/gateway/v1"
    "google.golang.org/grpc"
    "google.golang.org/grpc/credentials/insecure"
)

func main() {
    // Connect to gateway
    conn, err := grpc.Dial("gateway.traffic-tacos.com:443",
        grpc.WithTransportCredentials(insecure.NewCredentials()))
    if err != nil {
        log.Fatal(err)
    }
    defer conn.Close()

    // Create client and join queue
    client := gatewayv1.NewQueueServiceClient(conn)
    resp, err := client.JoinQueue(context.Background(), &gatewayv1.JoinQueueRequest{
        EventId: "bts-concert-2024",
        UserId:  "user123",
    })
    if err != nil {
        log.Fatal(err)
    }

    log.Printf("You are #%d in queue. Wait time: %d seconds",
        resp.Position, resp.EstimatedWaitSeconds)
}
```

**Kotlin Client (5 minutes):**
```kotlin
import com.traffic_tacos.gateway.v1.JoinQueueRequest
import com.traffic_tacos.gateway.v1.QueueServiceGrpcKt
import io.grpc.ManagedChannelBuilder
import kotlinx.coroutines.runBlocking

fun main() = runBlocking {
    val channel = ManagedChannelBuilder
        .forAddress("gateway.traffic-tacos.com", 443)
        .useTransportSecurity()
        .build()

    val client = QueueServiceGrpcKt.QueueServiceCoroutineStub(channel)

    val response = client.joinQueue(
        JoinQueueRequest.newBuilder()
            .setEventId("bts-concert-2024")
            .setUserId("user123")
            .build()
    )

    println("You are #${response.position} in queue. Wait time: ${response.estimatedWaitSeconds} seconds")

    channel.shutdown()
}
```

### 3. Available Services

| Service | Port | Description |
|---------|------|-------------|
| **Gateway API** | :8080 | Queue management, rate limiting, authentication |
| **Reservation API** | :8081 | Ticket reservations, 60-second holds |
| **Inventory API** | :8082 | Real-time seat availability, zero overselling |
| **Payment Simulator** | :8083 | Payment processing simulation |

### 4. Common Usage Patterns

#### Complete Reservation Flow
```go
// 1. Join queue → 2. Check inventory → 3. Reserve → 4. Pay
```

#### Error Handling
```go
if status.Code(err) == codes.ResourceExhausted {
    // Queue is full, try again later
}
```

#### Timeouts and Retries
```go
ctx, cancel := context.WithTimeout(context.Background(), 5*time.Second)
defer cancel()
```

### 5. Testing Your Integration

```bash
# Test gRPC connectivity
grpcurl -plaintext localhost:8080 gateway.v1.QueueService/GetQueueStatus

# Monitor queue position
grpcurl -plaintext -d '{"event_id":"test","user_id":"me"}' \
  localhost:8080 gateway.v1.QueueService/JoinQueue
```

## Development

### Prerequisites

- [Buf](https://buf.build/) - Protocol buffer management
- Go 1.22+
- Java 17+ (for Kotlin generation)

### Code Generation

This repository includes pre-generated code for immediate use. To regenerate:

```bash
# Generate code for all languages
make generate

# Generate Go code only
make generate-go

# Generate Java/Kotlin code only
make generate-kotlin

# Lint proto files
make lint

# Check for breaking changes
make breaking
```

**Generated Files:**
- **Go**: 20 files in `gen/go/` (ready for import)
- **Java**: 335 files in `gen/java/` (ready for Maven/Gradle)

### Manual Generation

```bash
# Using buf directly
buf generate

# Using scripts
./scripts/generate-go.sh
./scripts/generate-kotlin.sh
```

## Performance Targets

- **Throughput**: 30k RPS system-wide
- **Latency**: P95 < 500ms
- **gRPC Timeout**: ≤ 250ms for inventory calls
- **Error Rate**: < 1%
- **Availability**: 99.9% target

## Versioning

This repository follows semantic versioning:

- **Major** (v1.x.x): Breaking API changes
- **Minor** (v1.x.x): New fields/services (backward compatible)
- **Patch** (v1.x.x): Bug fixes and documentation

## Contributing

1. Create feature branch from `main`
2. Add/modify proto definitions
3. Run `make lint` and `make generate`
4. Test generated code compiles
5. Submit PR with generated code

## Related Repositories

- [gateway-api](https://github.com/traffic-tacos/gateway-api) - API Gateway (Go)
- [reservation-api](https://github.com/traffic-tacos/reservation-api) - Reservation Service (Kotlin)
- [inventory-api](https://github.com/traffic-tacos/inventory-api) - Inventory Service (Go)
- [payment-sim-api](https://github.com/traffic-tacos/payment-sim-api) - Payment Simulator (Go)
- [reservation-worker](https://github.com/traffic-tacos/reservation-worker) - Background Worker (Go/Kotlin)
- [reservation-web](https://github.com/traffic-tacos/reservation-web) - Frontend (React)

## Support

For issues, questions, or contributions:
- 📋 [Issues](https://github.com/traffic-tacos/proto-contracts/issues)
- 💬 [Discussions](https://github.com/traffic-tacos/proto-contracts/discussions)
- 📧 Contact: proto-team@traffic-tacos.com
# Traffic Tacos Proto Contracts

This repository contains the centralized gRPC protocol definitions for the Traffic Tacos microservices platform.

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

### For Go Services (gateway-api, inventory-api, payment-sim-api, worker)

```bash
go get github.com/traffic-tacos/proto-contracts@latest
```

```go
import (
    commonpb "github.com/traffic-tacos/proto-contracts/gen/go/common/v1"
    gatewaypb "github.com/traffic-tacos/proto-contracts/gen/go/gateway/v1"
    reservationpb "github.com/traffic-tacos/proto-contracts/gen/go/reservation/v1"
    paymentpb "github.com/traffic-tacos/proto-contracts/gen/go/payment/v1"
)

// Usage examples
queueClient := gatewaypb.NewQueueServiceClient(conn)
reservationClient := reservationpb.NewReservationServiceClient(conn)
workerClient := reservationpb.NewWorkerServiceClient(conn)
```

### For Kotlin Services (reservation-api)

```kotlin
// build.gradle.kts
dependencies {
    implementation("com.traffic-tacos:proto-contracts:1.0.0")
    implementation("io.grpc:grpc-kotlin-stub:1.4.0")
}
```

```kotlin
import com.traffic_tacos.reservation.v1.ReservationServiceGrpcKt
import com.traffic_tacos.gateway.v1.QueueServiceGrpcKt
import com.traffic_tacos.payment.v1.PaymentServiceGrpcKt

// Usage examples
val reservationClient = ReservationServiceGrpcKt.ReservationServiceCoroutineStub(channel)
val queueClient = QueueServiceGrpcKt.QueueServiceCoroutineStub(channel)
val paymentClient = PaymentServiceGrpcKt.PaymentServiceCoroutineStub(channel)
```

## Development

### Prerequisites

- [Buf](https://buf.build/) - Protocol buffer management
- Go 1.22+
- Java 17+ (for Kotlin generation)

### Code Generation

```bash
# Generate code for all languages
make generate

# Generate Go code only
make generate-go

# Generate Java/Kotlin code only
make generate-java

# Lint proto files
make lint

# Check for breaking changes
make breaking
```

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
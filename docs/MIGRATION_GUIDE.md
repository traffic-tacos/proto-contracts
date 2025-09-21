# Migration Guide for Traffic Tacos Proto Contracts

This guide helps existing Traffic Tacos services migrate to the centralized proto-contracts system.

## Table of Contents

- [Overview](#overview)
- [Migration Timeline](#migration-timeline)
- [Service-by-Service Migration](#service-by-service-migration)
- [Breaking Changes](#breaking-changes)
- [Testing Migration](#testing-migration)
- [Rollback Strategy](#rollback-strategy)
- [Post-Migration Validation](#post-migration-validation)

## Overview

### Current State vs. Target State

**Before Migration:**
```
┌─────────────────┐    ┌─────────────────┐
│   Service A     │────│   Service B     │
│ (local protos)  │    │ (local protos)  │
└─────────────────┘    └─────────────────┘
         │                       │
         └───────┬───────────────┘
                 │
     ┌─────────────────┐
     │   Service C     │
     │ (copied protos) │
     └─────────────────┘
```

**After Migration:**
```
┌─────────────────┐    ┌─────────────────┐    ┌─────────────────┐
│   Service A     │    │   Service B     │    │   Service C     │
│                 │    │                 │    │                 │
└─────────┬───────┘    └─────────┬───────┘    └─────────┬───────┘
          │                      │                      │
          └──────────────────────┼──────────────────────┘
                                 │
                    ┌─────────────────┐
                    │ proto-contracts │
                    │  (centralized)  │
                    └─────────────────┘
```

### Benefits of Migration

1. **Single Source of Truth**: All gRPC contracts in one repository
2. **Version Management**: Centralized versioning and breaking change detection
3. **Code Generation**: Automated multi-language code generation
4. **Documentation**: Comprehensive API documentation
5. **Testing**: Integrated testing and validation

## Migration Timeline

### Phase 1: Infrastructure Setup (Week 1)
- [x] Create proto-contracts repository
- [x] Set up Buf configuration and code generation
- [x] Establish CI/CD pipeline
- [x] Write documentation and examples

### Phase 2: Gateway API Migration (Week 2)
- [ ] Migrate gateway-api to use proto-contracts
- [ ] Update queue management endpoints
- [ ] Implement WebSocket integration
- [ ] Update deployment configuration

### Phase 3: Business Services Migration (Week 3-4)
- [ ] Migrate reservation-api (Kotlin/Spring Boot)
- [ ] Migrate inventory-api (Go)
- [ ] Migrate payment-sim-api (Go)
- [ ] Update inter-service communication

### Phase 4: Background Services Migration (Week 5)
- [ ] Migrate reservation-worker
- [ ] Update event processing logic
- [ ] Verify KEDA scaling integration

### Phase 5: Frontend Integration (Week 6)
- [ ] Update reservation-web API integration
- [ ] Implement WebSocket real-time updates
- [ ] Update error handling

### Phase 6: Validation & Cleanup (Week 7)
- [ ] End-to-end testing
- [ ] Performance validation
- [ ] Remove legacy proto files
- [ ] Update documentation

## Service-by-Service Migration

### Gateway API (Go)

#### Current Structure
```
gateway-api/
├── proto/
│   ├── queue.proto          # Local queue definitions
│   └── reservation.proto    # Copied from reservation-api
├── internal/
│   ├── queue/
│   └── reservation/
└── ...
```

#### Migration Steps

1. **Add Proto Contracts Dependency**
```bash
cd gateway-api
go get github.com/traffic-tacos/proto-contracts@latest
go mod tidy
```

2. **Update Import Statements**
```go
// Before
import "./proto"

// After
import (
    gatewaypb "github.com/traffic-tacos/proto-contracts/gen/go/gateway/v1"
    reservationpb "github.com/traffic-tacos/proto-contracts/gen/go/reservation/v1"
)
```

3. **Update Service Implementation**
```go
// Before
type QueueServer struct {
    proto.UnimplementedQueueServiceServer
}

// After
type QueueServer struct {
    gatewaypb.UnimplementedQueueServiceServer
}
```

4. **Remove Local Proto Files**
```bash
rm -rf proto/
```

5. **Update Build Process**
```bash
# Remove proto generation from Makefile
# Update docker build to use generated code from dependency
```

#### Migration Checklist for Gateway API
- [ ] Update go.mod with proto-contracts dependency
- [ ] Replace local proto imports with centralized ones
- [ ] Update QueueService implementation
- [ ] Update GatewayService implementation
- [ ] Add WebSocketService implementation
- [ ] Add WebhookService implementation
- [ ] Update Dockerfile
- [ ] Update Kubernetes manifests
- [ ] Test gRPC connectivity
- [ ] Verify JWT validation
- [ ] Test queue flow end-to-end

---

### Reservation API (Kotlin/Spring Boot)

#### Current Structure
```
reservation-api/
├── src/main/proto/
│   ├── reservation.proto    # Local definitions
│   └── inventory.proto      # Interface definitions
├── src/main/kotlin/
│   ├── service/
│   └── controller/
└── build.gradle.kts
```

#### Migration Steps

1. **Update build.gradle.kts**
```kotlin
// Add dependency
dependencies {
    implementation("com.traffic-tacos:proto-contracts:1.0.0")
    implementation("io.grpc:grpc-kotlin-stub:1.4.0")

    // Remove protobuf plugin and generated code
    // configurations.implementation.exclude(group: "generated")
}

// Remove protobuf configuration
// protobuf { ... }
```

2. **Update Import Statements**
```kotlin
// Before
import com.trafficstacos.reservation.proto.*

// After
import com.traffic_tacos.reservation.v1.*
import com.traffic_tacos.common.v1.*
```

3. **Update Service Implementation**
```kotlin
// Before
class ReservationServiceImpl : ReservationServiceGrpc.ReservationServiceImplBase()

// After
class ReservationServiceImpl : ReservationServiceGrpcKt.ReservationServiceCoroutineImplBase()
```

4. **Update Configuration**
```kotlin
// application.yml
grpc:
  server:
    port: 8001
  client:
    inventory-api:
      address: static://inventory-api:8002
      negotiationType: plaintext
```

#### Migration Checklist for Reservation API
- [ ] Update build.gradle.kts dependencies
- [ ] Remove local proto files and generation
- [ ] Update service implementations
- [ ] Update gRPC client configurations
- [ ] Test reservation creation flow
- [ ] Test 60-second hold mechanism
- [ ] Test EventBridge integration
- [ ] Verify idempotency handling
- [ ] Test inventory service communication
- [ ] Update Spring Boot configuration

---

### Inventory API (Go)

#### Current Structure
```
inventory-api/
├── proto/
│   └── inventory.proto      # Current implementation
├── internal/
│   ├── server/
│   └── repository/
└── ...
```

#### Migration Steps

1. **Compare Proto Definitions**
```bash
# Compare existing proto with centralized version
diff inventory-api/proto/inventory.proto \
     proto-contracts/proto/reservation/v1/inventory.proto
```

2. **Update Dependencies**
```go
// go.mod
require (
    github.com/traffic-tacos/proto-contracts v1.0.0
    google.golang.org/grpc v1.60.1
)
```

3. **Update Implementation**
```go
// Before
import "./proto"

// After
import reservationpb "github.com/traffic-tacos/proto-contracts/gen/go/reservation/v1"

type InventoryServer struct {
    reservationpb.UnimplementedInventoryServer
    // ... other fields
}
```

#### Migration Checklist for Inventory API
- [ ] Compare and merge proto definitions
- [ ] Update Go module dependencies
- [ ] Update server implementation
- [ ] Test DynamoDB conditional updates
- [ ] Verify zero-oversell logic
- [ ] Test CommitReservation flow
- [ ] Test ReleaseHold flow
- [ ] Validate performance (P95 < 50ms)
- [ ] Update monitoring and metrics

---

### Payment Sim API (Go)

#### Current Structure
```
payment-sim-api/
├── proto/
│   └── payment.proto        # Current implementation
├── internal/
│   ├── payment/
│   └── webhook/
└── ...
```

#### Migration Steps

1. **Add Proto Contracts**
```bash
go get github.com/traffic-tacos/proto-contracts@latest
```

2. **Update Webhook Integration**
```go
// Update webhook payload format to match centralized definition
import gatewaypb "github.com/traffic-tacos/proto-contracts/gen/go/gateway/v1"

func (s *PaymentServer) sendWebhook(payment *Payment) error {
    webhookReq := &gatewaypb.PaymentWebhookRequest{
        WebhookId: generateWebhookID(),
        EventType: gatewaypb.PaymentWebhookType_PAYMENT_WEBHOOK_TYPE_APPROVED,
        Data: &gatewaypb.PaymentWebhookData{
            PaymentIntentId: payment.ID,
            ReservationId:   payment.ReservationID,
            Status:          gatewaypb.PaymentWebhookStatus_PAYMENT_WEBHOOK_STATUS_SUCCESS,
            Amount:          payment.Amount,
            ProcessedAt:     timestamppb.Now(),
        },
        Timestamp: timestamppb.Now(),
        Signature: s.generateSignature(payment),
        Source:    "payment-sim-api",
    }

    return s.sendWebhookHTTP(payment.WebhookURL, webhookReq)
}
```

#### Migration Checklist for Payment Sim API
- [ ] Update proto dependencies
- [ ] Update service implementation
- [ ] Update webhook payload format
- [ ] Test payment scenarios (approve/fail/delay)
- [ ] Test webhook delivery
- [ ] Verify HMAC signature generation
- [ ] Test integration with reservation-api

---

### Reservation Worker (Go/Kotlin)

#### Migration Steps

1. **Update Worker Implementation**
```go
import (
    reservationpb "github.com/traffic-tacos/proto-contracts/gen/go/reservation/v1"
    commonpb "github.com/traffic-tacos/proto-contracts/gen/go/common/v1"
)

type WorkerServer struct {
    reservationpb.UnimplementedWorkerServiceServer
    inventoryClient   reservationpb.InventoryClient
    sqsClient        *sqs.Client
}

func (w *WorkerServer) ProcessReservationExpiry(
    ctx context.Context,
    req *reservationpb.ProcessExpiryRequest,
) (*reservationpb.ProcessExpiryResponse, error) {
    // Implementation using centralized proto types
}
```

2. **Update KEDA Configuration**
```yaml
# k8s/reservation-worker-scaledobject.yaml
apiVersion: keda.sh/v1alpha1
kind: ScaledObject
metadata:
  name: reservation-worker-scaler
spec:
  scaleTargetRef:
    name: reservation-worker
  triggers:
  - type: aws-sqs-queue
    metadata:
      queueURL: https://sqs.ap-northeast-2.amazonaws.com/123456789/reservation-events
```

#### Migration Checklist for Reservation Worker
- [ ] Update proto dependencies
- [ ] Update SQS message processing
- [ ] Test reservation expiry handling
- [ ] Test payment result processing
- [ ] Verify KEDA auto-scaling
- [ ] Test error handling and DLQ
- [ ] Update Kubernetes manifests

---

### Reservation Web (React)

#### Migration Steps

1. **Update API Types**
```typescript
// src/types/api.ts - Update to match proto definitions
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

2. **Update WebSocket Integration**
```typescript
// Update to use new WebSocket message format from proto
interface QueueUpdateEvent {
  type: string;
  queue_update: {
    waiting_token: string;
    position: number;
    eta_seconds: number;
    admission_ready: boolean;
  };
  timestamp: string;
}
```

#### Migration Checklist for Reservation Web
- [ ] Update API type definitions
- [ ] Update queue flow implementation
- [ ] Update WebSocket integration
- [ ] Test real-time queue updates
- [ ] Test reservation creation flow
- [ ] Test payment integration
- [ ] Update error handling
- [ ] Test responsive design

## Breaking Changes

### API Changes

#### Queue Service
- **NEW**: `QueueMetadata` for tracking user information
- **CHANGED**: `GetQueueStatus` now returns `admission_ready` field
- **NEW**: `AdmissionStatus` enum for better status handling

#### Reservation Service
- **CHANGED**: `CreateReservationRequest` now requires `reservation_token`
- **NEW**: `ReservationMetadata` for request tracking
- **CHANGED**: Error responses now use standardized `common.v1.Error`

#### Inventory Service
- **NEW**: `CommitReservationRequest` includes `payment_intent_id`
- **CHANGED**: All timestamps use `google.protobuf.Timestamp`
- **NEW**: Comprehensive error handling with detailed status

### Database Schema Changes

#### Reservations Table
```sql
-- Add new columns for enhanced tracking
ALTER TABLE reservations ADD COLUMN payment_intent_id VARCHAR(255);
ALTER TABLE reservations ADD COLUMN metadata JSONB;
ALTER TABLE reservations ADD COLUMN trace_id VARCHAR(255);

-- Add indexes for performance
CREATE INDEX idx_reservations_payment_intent ON reservations(payment_intent_id);
CREATE INDEX idx_reservations_trace_id ON reservations(trace_id);
```

#### Inventory Tables
```sql
-- Add version field for optimistic locking
ALTER TABLE inventory ADD COLUMN version INTEGER DEFAULT 1;
ALTER TABLE inventory_seats ADD COLUMN version INTEGER DEFAULT 1;

-- Add reservation tracking
ALTER TABLE inventory_seats ADD COLUMN reservation_id VARCHAR(255);
ALTER TABLE inventory_seats ADD COLUMN hold_expires_at TIMESTAMP;
```

## Testing Migration

### Unit Tests

```go
// Test proto compatibility
func TestProtoCompatibility(t *testing.T) {
    // Test that old and new proto generate compatible JSON
    oldReq := &OldCreateReservationRequest{...}
    newReq := &reservationpb.CreateReservationRequest{...}

    oldJSON, _ := json.Marshal(oldReq)
    newJSON, _ := json.Marshal(newReq)

    // Compare structures
    assert.JSONEq(t, string(oldJSON), string(newJSON))
}
```

### Integration Tests

```bash
# Test complete flow with new protos
./test_migration.sh

# Scenarios to test:
# 1. Queue join -> admission -> reservation
# 2. Reservation creation -> payment -> confirmation
# 3. Reservation expiry handling
# 4. Error scenarios and rollback
# 5. WebSocket real-time updates
```

### Load Testing

```bash
# Test performance with new protos
./load_test_migration.sh

# Verify performance targets:
# - QueueService: P95 < 50ms
# - ReservationService: P95 < 200ms
# - Inventory: P95 < 50ms
# - Overall system: 30k RPS
```

## Rollback Strategy

### Quick Rollback (< 5 minutes)

1. **Revert Container Images**
```bash
kubectl set image deployment/gateway-api gateway-api=gateway-api:v1.0.0
kubectl set image deployment/reservation-api reservation-api=reservation-api:v1.0.0
kubectl set image deployment/inventory-api inventory-api=inventory-api:v1.0.0
```

2. **Verify Health Checks**
```bash
kubectl get pods -l app=gateway-api
kubectl get pods -l app=reservation-api
kubectl get pods -l app=inventory-api
```

### Full Rollback (< 30 minutes)

1. **Database Schema Rollback**
```sql
-- Remove new columns (data preserved)
ALTER TABLE reservations DROP COLUMN IF EXISTS payment_intent_id;
ALTER TABLE reservations DROP COLUMN IF EXISTS metadata;
ALTER TABLE inventory DROP COLUMN IF EXISTS version;
```

2. **Configuration Rollback**
```bash
# Restore previous configuration files
kubectl apply -f config/old/
```

3. **DNS/Load Balancer Rollback**
```bash
# Switch traffic back to old services if needed
kubectl patch service gateway-api -p '{"spec":{"selector":{"version":"v1.0.0"}}}'
```

### Rollback Decision Matrix

| Issue Type | Severity | Rollback Type | Time Limit |
|------------|----------|---------------|------------|
| Performance degradation | High | Quick | 5 minutes |
| Data corruption | Critical | Full | 30 minutes |
| Feature regression | Medium | Quick | 15 minutes |
| Integration failure | High | Quick | 10 minutes |

## Post-Migration Validation

### Health Checks

```bash
# Verify all services are healthy
curl -f http://gateway-api:8000/health
curl -f http://reservation-api:8001/health
curl -f http://inventory-api:8002/health
curl -f http://payment-sim-api:8003/health

# Check gRPC connectivity
grpcurl -plaintext gateway-api:8000 grpc.health.v1.Health/Check
grpcurl -plaintext reservation-api:8001 grpc.health.v1.Health/Check
grpcurl -plaintext inventory-api:8002 grpc.health.v1.Health/Check
```

### Functional Tests

```bash
# Run end-to-end test suite
./test_e2e_migration.sh

# Test scenarios:
# 1. Complete reservation flow
# 2. Queue management under load
# 3. Payment processing
# 4. Worker event processing
# 5. WebSocket real-time updates
# 6. Error handling and recovery
```

### Performance Validation

```bash
# Load test with target metrics
./load_test_post_migration.sh

# Verify:
# - Latency targets met
# - Throughput targets met
# - Error rates acceptable
# - Resource utilization normal
```

### Monitoring Setup

```yaml
# Update Prometheus rules for new metrics
groups:
- name: proto-contracts-migration
  rules:
  - alert: HighErrorRate
    expr: rate(grpc_server_handled_total{grpc_code!="OK"}[5m]) > 0.01
    for: 2m
    annotations:
      summary: "High gRPC error rate detected"

  - alert: HighLatency
    expr: histogram_quantile(0.95, grpc_server_handling_seconds_bucket) > 0.5
    for: 5m
    annotations:
      summary: "High gRPC latency detected"
```

### Data Validation

```sql
-- Verify data integrity after migration
SELECT
  COUNT(*) as total_reservations,
  COUNT(CASE WHEN status = 'CONFIRMED' THEN 1 END) as confirmed,
  COUNT(CASE WHEN status = 'EXPIRED' THEN 1 END) as expired,
  COUNT(CASE WHEN payment_intent_id IS NOT NULL THEN 1 END) as with_payment
FROM reservations
WHERE created_at > NOW() - INTERVAL '1 day';

-- Check for orphaned records
SELECT r.reservation_id
FROM reservations r
LEFT JOIN inventory_seats i ON r.reservation_id = i.reservation_id
WHERE r.status = 'CONFIRMED' AND i.reservation_id IS NULL;
```

## Migration Completion Checklist

### Infrastructure
- [ ] All services using proto-contracts v1.0.0+
- [ ] Local proto files removed from service repositories
- [ ] CI/CD pipelines updated
- [ ] Monitoring and alerting configured

### Services
- [ ] Gateway API migrated and tested
- [ ] Reservation API migrated and tested
- [ ] Inventory API migrated and tested
- [ ] Payment Sim API migrated and tested
- [ ] Reservation Worker migrated and tested
- [ ] Reservation Web migrated and tested

### Testing
- [ ] Unit tests passing
- [ ] Integration tests passing
- [ ] Load tests meeting performance targets
- [ ] End-to-end tests covering all flows

### Documentation
- [ ] API documentation updated
- [ ] Integration guides updated
- [ ] Runbooks updated
- [ ] Migration notes documented

### Performance
- [ ] Latency targets met (P95 < target)
- [ ] Throughput targets met (30k RPS)
- [ ] Error rates acceptable (< 1%)
- [ ] Resource utilization normal

### Monitoring
- [ ] All metrics collecting correctly
- [ ] Dashboards updated
- [ ] Alerts configured and tested
- [ ] Log aggregation working

Once all items are checked, the migration is complete and the old proto files can be archived.

## Support and Troubleshooting

### Common Issues

1. **Import Resolution Issues**
   - Verify go.mod/build.gradle dependencies
   - Check proto-contracts version compatibility
   - Clear module cache: `go clean -modcache`

2. **gRPC Connection Issues**
   - Verify service discovery configuration
   - Check network policies and firewall rules
   - Validate TLS configuration

3. **Performance Degradation**
   - Check for inefficient proto serialization
   - Verify connection pooling configuration
   - Monitor garbage collection impact

### Getting Help

- **Documentation**: See [API_SPECIFICATION.md](API_SPECIFICATION.md) and [INTEGRATION_GUIDE.md](INTEGRATION_GUIDE.md)
- **Issues**: Report problems at https://github.com/traffic-tacos/proto-contracts/issues
- **Discussions**: Use GitHub Discussions for questions
- **Emergency**: Contact the Traffic Tacos platform team

This migration guide ensures a smooth transition to the centralized proto-contracts system while maintaining system reliability and performance.
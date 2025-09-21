# Contributing to Traffic Tacos Proto Contracts

Thank you for your interest in contributing to the Traffic Tacos Proto Contracts repository! This guide will help you understand how to contribute effectively.

## 🎯 Overview

This repository contains the centralized gRPC protocol definitions for the Traffic Tacos microservices platform. Changes here affect all services in the ecosystem.

## 🔧 Development Setup

### Prerequisites

- [Buf](https://buf.build/) - Protocol buffer management
- Go 1.22+
- Java 17+
- Git

### Initial Setup

```bash
# Clone the repository
git clone https://github.com/traffic-tacos/proto-contracts.git
cd proto-contracts

# Install dependencies and generate code
make init

# Verify setup
make status
```

## 📝 Making Changes

### 1. Before You Start

- Check existing issues and PRs
- Discuss significant changes in an issue first
- Ensure your changes maintain backward compatibility

### 2. Development Workflow

```bash
# Create feature branch
git checkout -b feature/your-feature-name

# Make your changes to proto files
vim proto/reservation/v1/reservation.proto

# Generate code and test
make dev

# Run full test suite
make ci

# Commit your changes
git add .
git commit -m "feat: add new reservation status"
```

### 3. Code Generation

Always generate code after making proto changes:

```bash
# Generate all languages
make generate

# Generate specific language
make generate-go
make generate-kotlin
```

## 📋 Guidelines

### Proto File Guidelines

1. **Naming Conventions**
   - Use snake_case for field names
   - Use PascalCase for message and service names
   - Use SCREAMING_SNAKE_CASE for enum values

2. **Versioning**
   - All services use `/v1/` versioning
   - Breaking changes require new version

3. **Documentation**
   - Add comments for all services and messages
   - Include usage examples where appropriate

4. **Backward Compatibility**
   - Never remove fields (deprecate instead)
   - Don't change field numbers
   - Don't change field types

### Example Proto Structure

```protobuf
syntax = "proto3";

package reservation.v1;

option go_package = "github.com/traffic-tacos/proto-contracts/gen/go/reservation/v1;reservationv1";
option java_package = "com.traffic_tacos.reservation.v1";

// ReservationService manages ticket reservations
service ReservationService {
  // CreateReservation creates a new reservation with 60-second hold
  rpc CreateReservation(CreateReservationRequest) returns (CreateReservationResponse);
}

// CreateReservationRequest contains reservation creation parameters
message CreateReservationRequest {
  string event_id = 1;        // Required: Event identifier
  repeated string seat_ids = 2; // Optional: Specific seat selection
  int32 quantity = 3;         // Required: Number of seats
}
```

### Commit Message Format

Use conventional commits format:

- `feat:` - New features
- `fix:` - Bug fixes
- `docs:` - Documentation changes
- `style:` - Code style changes
- `refactor:` - Code refactoring
- `test:` - Test changes
- `chore:` - Build/tooling changes

Examples:
```
feat: add payment timeout handling to payment service
fix: correct field numbering in reservation.proto
docs: update installation instructions for Kotlin
```

## 🧪 Testing

### Test Your Changes

```bash
# Lint proto files
make lint

# Check for breaking changes
make breaking

# Generate and test all code
make test

# Full CI workflow
make ci
```

### Test Coverage

Ensure your changes include:

- Proto file validation
- Code generation for both Go and Kotlin
- Integration tests if adding new services

## 📦 Release Process

### Version Strategy

- **Major** (v2.0.0): Breaking changes
- **Minor** (v1.1.0): New features (backward compatible)
- **Patch** (v1.0.1): Bug fixes

### Release Steps

1. Update CHANGELOG.md
2. Create PR with version changes
3. After merge, create and push git tag
4. GitHub Actions will handle the release

## 🔍 Code Review

### PR Requirements

- [ ] Proto files follow naming conventions
- [ ] No breaking changes (unless major version)
- [ ] Generated code compiles for both Go and Kotlin
- [ ] Tests pass
- [ ] Documentation updated

### Review Checklist

Reviewers should verify:

- Backward compatibility maintained
- Field numbers are unique and never reused
- Comments and documentation are clear
- Generated code builds successfully

## 🤝 Getting Help

- **Issues**: Report bugs or request features
- **Discussions**: Ask questions or discuss ideas
- **Discord**: Join our development chat (link in README)

## 📊 Service Impact

Changes to this repository affect these services:

- **gateway-api** (Go) - API Gateway
- **reservation-api** (Kotlin) - Reservation Service
- **inventory-api** (Go) - Inventory Service
- **payment-sim-api** (Go) - Payment Simulator
- **reservation-worker** (Go/Kotlin) - Background Worker

## 🚀 Advanced Topics

### Adding a New Service

1. Create new proto file in appropriate directory
2. Define service interface and messages
3. Update buf.gen.yaml if needed
4. Generate code and test
5. Update documentation

### Breaking Changes

If you must make breaking changes:

1. Discuss in issue first
2. Create new version directory (e.g., `v2/`)
3. Update all dependent services
4. Coordinate rollout with team

### Custom Options

For service-specific needs, you can add custom options:

```protobuf
import "google/protobuf/descriptor.proto";

extend google.protobuf.ServiceOptions {
  bool requires_auth = 50001;
}

service ReservationService {
  option (requires_auth) = true;
  // ... service methods
}
```

## 📖 Resources

- [Buf Style Guide](https://buf.build/docs/style-guide)
- [Protocol Buffers Guide](https://protobuf.dev/programming-guides/)
- [gRPC Best Practices](https://grpc.io/docs/guides/best-practices/)
- [Semantic Versioning](https://semver.org/)

Thank you for contributing to Traffic Tacos! 🌮
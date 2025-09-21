#!/bin/bash

# generate-go.sh - Generate Go code from protobuf definitions
# Usage: ./scripts/generate-go.sh

set -euo pipefail

SCRIPT_DIR="$(cd "$(dirname "${BASH_SOURCE[0]}")" && pwd)"
PROJECT_ROOT="$(cd "${SCRIPT_DIR}/.." && pwd)"

cd "${PROJECT_ROOT}"

echo "🚀 Generating Go code from protobuf definitions..."

# Check if buf is installed
if ! command -v buf &> /dev/null; then
    echo "❌ buf is not installed. Please install buf from https://buf.build/"
    exit 1
fi

# Check if protoc-gen-go is installed
if ! command -v protoc-gen-go &> /dev/null; then
    echo "📦 Installing protoc-gen-go..."
    go install google.golang.org/protobuf/cmd/protoc-gen-go@latest
fi

# Check if protoc-gen-go-grpc is installed
if ! command -v protoc-gen-go-grpc &> /dev/null; then
    echo "📦 Installing protoc-gen-go-grpc..."
    go install google.golang.org/grpc/cmd/protoc-gen-go-grpc@latest
fi

# Clean existing generated files
echo "🧹 Cleaning existing Go generated files..."
rm -rf gen/go
mkdir -p gen/go

# Generate Go code using buf
echo "⚙️  Generating Go protobuf and gRPC code..."
buf generate --template buf.gen.yaml --include-imports

# Check if generation was successful
if [ ! -d "gen/go" ] || [ -z "$(find gen/go -name '*.go' 2>/dev/null)" ]; then
    echo "❌ Go code generation failed!"
    exit 1
fi

# Update go.mod and go.sum
echo "📝 Updating Go module dependencies..."
go mod tidy

# Format generated code
echo "🎨 Formatting generated Go code..."
find gen/go -name "*.go" -exec gofmt -w {} \;

# Verify generated code compiles
echo "🔍 Verifying generated Go code compiles..."
go build ./gen/go/...

# Generate a simple test file to verify imports work
echo "🧪 Creating integration test..."
cat > gen/go/integration_test.go << 'EOF'
//go:build integration

package main

import (
	"testing"

	commonv1 "github.com/traffic-tacos/proto-contracts/gen/go/common/v1"
	paymentv1 "github.com/traffic-tacos/proto-contracts/gen/go/payment/v1"
	reservationv1 "github.com/traffic-tacos/proto-contracts/gen/go/reservation/v1"
)

func TestGeneratedCodeImports(t *testing.T) {
	// Test that all generated packages can be imported
	_ = &commonv1.Money{}
	_ = &commonv1.Error{}
	_ = &reservationv1.Reservation{}
	_ = &paymentv1.Payment{}

	// Test enum values
	if commonv1.SeatStatus_SEAT_STATUS_AVAILABLE == 0 {
		t.Error("Enum values should not be zero")
	}

	if reservationv1.ReservationStatus_RESERVATION_STATUS_PENDING == 0 {
		t.Error("Enum values should not be zero")
	}

	t.Log("✅ All generated Go packages imported successfully")
}
EOF

# Run the integration test
go test -tags=integration ./gen/go/... -v

echo "✅ Go code generation completed successfully!"
echo ""
echo "Generated files:"
find gen/go -name "*.go" | head -10
if [ $(find gen/go -name "*.go" | wc -l) -gt 10 ]; then
    echo "... and $(expr $(find gen/go -name "*.go" | wc -l) - 10) more files"
fi
echo ""
echo "📖 To use in Go projects:"
echo "   go get github.com/traffic-tacos/proto-contracts@latest"
echo ""
echo "📝 Example import:"
echo '   import reservationpb "github.com/traffic-tacos/proto-contracts/gen/go/reservation/v1"'
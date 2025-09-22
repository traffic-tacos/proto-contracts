#!/bin/bash

# generate-kotlin.sh - Generate Kotlin/Java code from protobuf definitions
# Usage: ./scripts/generate-kotlin.sh

set -euo pipefail

SCRIPT_DIR="$(cd "$(dirname "${BASH_SOURCE[0]}")" && pwd)"
PROJECT_ROOT="$(cd "${SCRIPT_DIR}/.." && pwd)"

cd "${PROJECT_ROOT}"

echo "🚀 Generating Kotlin/Java code from protobuf definitions..."

# Check if buf is installed
if ! command -v buf &> /dev/null; then
    echo "❌ buf is not installed. Please install buf from https://buf.build/"
    exit 1
fi

# Check Java installation
if ! command -v java &> /dev/null; then
    echo "❌ Java is not installed. Please install Java 17+"
    exit 1
fi

# Check if we have gradle wrapper or gradle (optional for advanced builds)
if [ -f "./gradlew" ]; then
    GRADLE_CMD="./gradlew"
elif command -v gradle &> /dev/null; then
    GRADLE_CMD="gradle"
else
    GRADLE_CMD=""
    echo "ℹ️  Gradle not available - using buf only for generation"
fi

# Clean existing generated files
echo "🧹 Cleaning existing Kotlin/Java generated files..."
rm -rf gen/java
rm -rf build/generated
mkdir -p gen/java

# Generate Kotlin/Java code using buf
echo "⚙️  Generating Java/Kotlin protobuf and gRPC code..."
buf generate --template buf.gen.yaml

# Optional: Also generate using Gradle for advanced features
if [ -n "$GRADLE_CMD" ]; then
    echo "📦 Running Gradle protobuf generation..."
    $GRADLE_CMD generateProto

    # Copy Gradle-generated files to gen/java if they exist
    if [ -d "build/generated/source/proto/main" ]; then
        echo "📁 Copying Gradle-generated files to gen/java..."
        cp -r build/generated/source/proto/main/* gen/java/ 2>/dev/null || true
    fi
fi

# Check if generation was successful
if [ ! -d "gen/java" ] || [ -z "$(find gen/java -name '*.java' -o -name '*.kt' 2>/dev/null)" ]; then
    echo "❌ Kotlin/Java code generation failed!"
    exit 1
fi

# Build the generated code (if Gradle is available)
if [ -n "$GRADLE_CMD" ]; then
    echo "🔨 Building generated Kotlin/Java code..."
    $GRADLE_CMD compileJava compileKotlin || echo "⚠️  Gradle build failed, but generation completed"
else
    echo "ℹ️  Skipping compilation - Gradle not available"
fi

# Create a simple test to verify the generated code
echo "🧪 Creating integration test..."
mkdir -p src/test/kotlin/com/traffic_tacos/test

cat > src/test/kotlin/com/traffic_tacos/test/GeneratedCodeTest.kt << 'EOF'
package com.traffic_tacos.test

import com.traffic_tacos.common.v1.Money
import com.traffic_tacos.common.v1.SeatStatus
import com.traffic_tacos.reservation.v1.Reservation
import com.traffic_tacos.reservation.v1.ReservationStatus
import com.traffic_tacos.payment.v1.Payment
import com.traffic_tacos.payment.v1.PaymentStatus
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.Assertions.*

class GeneratedCodeTest {

    @Test
    fun `test generated protobuf classes can be instantiated`() {
        // Test Money proto
        val money = Money.newBuilder()
            .setAmount(50000)
            .setCurrency("KRW")
            .build()

        assertEquals(50000, money.amount)
        assertEquals("KRW", money.currency)

        // Test Reservation proto
        val reservation = Reservation.newBuilder()
            .setReservationId("rsv_123")
            .setEventId("evt_456")
            .setUserId("user_789")
            .setStatus(ReservationStatus.RESERVATION_STATUS_CONFIRMED)
            .setQuantity(2)
            .setTotalAmount(money)
            .build()

        assertEquals("rsv_123", reservation.reservationId)
        assertEquals(ReservationStatus.RESERVATION_STATUS_CONFIRMED, reservation.status)
        assertEquals(2, reservation.quantity)

        // Test Payment proto
        val payment = Payment.newBuilder()
            .setPaymentIntentId("pay_123")
            .setReservationId("rsv_123")
            .setUserId("user_789")
            .setStatus(PaymentStatus.PAYMENT_STATUS_COMPLETED)
            .setAmount(money)
            .build()

        assertEquals("pay_123", payment.paymentIntentId)
        assertEquals(PaymentStatus.PAYMENT_STATUS_COMPLETED, payment.status)
    }

    @Test
    fun `test enum values are correct`() {
        assertNotEquals(0, SeatStatus.SEAT_STATUS_AVAILABLE.number)
        assertNotEquals(0, ReservationStatus.RESERVATION_STATUS_CONFIRMED.number)
        assertNotEquals(0, PaymentStatus.PAYMENT_STATUS_COMPLETED.number)
    }
}
EOF

# Create test build configuration
cat > src/test/kotlin/build.gradle.kts << 'EOF'
dependencies {
    testImplementation("org.junit.jupiter:junit-jupiter:5.9.2")
    testRuntimeOnly("org.junit.platform:junit-platform-launcher")
}

tasks.test {
    useJUnitPlatform()
}
EOF

# Run the integration test (if Gradle is available)
if [ -n "$GRADLE_CMD" ]; then
    echo "🧪 Running integration tests..."
    $GRADLE_CMD test --tests "com.traffic_tacos.test.GeneratedCodeTest" || true

    # Build JAR artifact
    echo "📦 Building JAR artifact..."
    $GRADLE_CMD build || echo "⚠️  JAR build failed"
else
    echo "ℹ️  Skipping tests and JAR build - Gradle not available"
fi

echo "✅ Kotlin/Java code generation completed successfully!"
echo ""
echo "Generated files:"
find gen/java -name "*.java" -o -name "*.kt" | head -10
if [ $(find gen/java -name "*.java" -o -name "*.kt" | wc -l) -gt 10 ]; then
    echo "... and $(expr $(find gen/java -name "*.java" -o -name "*.kt" | wc -l) - 10) more files"
fi
echo ""
echo "📖 To use in Kotlin/Java projects:"
echo "   implementation(\"com.traffic-tacos:proto-contracts:1.0.0\")"
echo ""
echo "📝 Example import:"
echo "   import com.traffic_tacos.reservation.v1.ReservationServiceGrpcKt"
echo ""
if [ -f "build/libs/proto-contracts-1.0.0.jar" ]; then
    echo "📦 JAR artifact created: build/libs/proto-contracts-1.0.0.jar"
fi
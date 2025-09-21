package com.traffictacos.examples

import com.traffic_tacos.common.v1.ErrorCode
import com.traffic_tacos.common.v1.Money
import com.traffic_tacos.reservation.v1.*
import io.grpc.ManagedChannel
import io.grpc.ManagedChannelBuilder
import io.grpc.Status
import io.grpc.StatusException
import kotlinx.coroutines.*
import org.slf4j.LoggerFactory
import java.time.Instant
import java.util.*
import java.util.concurrent.TimeUnit

/**
 * Example demonstrating how to use the ReservationService gRPC client in Kotlin
 */
class ReservationServiceExample(
    private val channel: ManagedChannel
) {
    private val logger = LoggerFactory.getLogger(ReservationServiceExample::class.java)
    private val reservationClient = ReservationServiceGrpcKt.ReservationServiceCoroutineStub(channel)

    companion object {
        fun create(serverAddress: String, port: Int): ReservationServiceExample {
            val channel = ManagedChannelBuilder.forAddress(serverAddress, port)
                .usePlaintext()
                .build()
            return ReservationServiceExample(channel)
        }
    }

    /**
     * Creates a new reservation with automatic hold expiry
     */
    suspend fun createReservation(
        eventId: String,
        userId: String,
        seatIds: List<String>,
        quantity: Int,
        reservationToken: String
    ): CreateReservationResponse {
        val idempotencyKey = UUID.randomUUID().toString()

        val request = CreateReservationRequest.newBuilder()
            .setEventId(eventId)
            .setUserId(userId)
            .addAllSeatIds(seatIds)
            .setQuantity(quantity)
            .setReservationToken(reservationToken)
            .setIdempotencyKey(idempotencyKey)
            .setMetadata(
                ReservationMetadata.newBuilder()
                    .setSource("kotlin-example")
                    .setUserAgent("kotlin-client/1.0")
                    .setIpAddress("192.168.1.100")
                    .setSessionId("session_${System.currentTimeMillis()}")
                    .putTags("example", "true")
                    .build()
            )
            .build()

        try {
            val response = reservationClient.createReservation(request)

            if (response.hasError()) {
                throw ReservationException(
                    "Failed to create reservation: ${response.error.message}",
                    response.error.code
                )
            }

            logger.info("Reservation created successfully: ${response.reservationId}")
            logger.info("Status: ${response.status}")
            logger.info("Hold expires at: ${response.holdExpiresAt}")
            logger.info("Total amount: ${response.totalAmount.amount} ${response.totalAmount.currency}")

            return response

        } catch (e: StatusException) {
            logger.error("gRPC error creating reservation", e)
            throw ReservationException("gRPC error: ${e.status.description}", null, e)
        }
    }

    /**
     * Retrieves reservation details
     */
    suspend fun getReservation(reservationId: String, userId: String): GetReservationResponse {
        val request = GetReservationRequest.newBuilder()
            .setReservationId(reservationId)
            .setUserId(userId)
            .build()

        try {
            val response = reservationClient.getReservation(request)

            if (response.hasError()) {
                throw ReservationException(
                    "Failed to get reservation: ${response.error.message}",
                    response.error.code
                )
            }

            logger.info("Retrieved reservation: ${response.reservation.reservationId}")
            logger.info("Current status: ${response.reservation.status}")

            return response

        } catch (e: StatusException) {
            logger.error("gRPC error getting reservation", e)
            throw ReservationException("gRPC error: ${e.status.description}", null, e)
        }
    }

    /**
     * Confirms a reservation after successful payment
     */
    suspend fun confirmReservation(
        reservationId: String,
        paymentIntentId: String,
        userId: String
    ): ConfirmReservationResponse {
        val idempotencyKey = UUID.randomUUID().toString()

        val request = ConfirmReservationRequest.newBuilder()
            .setReservationId(reservationId)
            .setPaymentIntentId(paymentIntentId)
            .setUserId(userId)
            .setIdempotencyKey(idempotencyKey)
            .build()

        try {
            val response = reservationClient.confirmReservation(request)

            if (response.hasError()) {
                throw ReservationException(
                    "Failed to confirm reservation: ${response.error.message}",
                    response.error.code
                )
            }

            logger.info("Reservation confirmed successfully!")
            logger.info("Order ID: ${response.orderId}")
            logger.info("Confirmed at: ${response.confirmedAt}")

            return response

        } catch (e: StatusException) {
            logger.error("gRPC error confirming reservation", e)
            throw ReservationException("gRPC error: ${e.status.description}", null, e)
        }
    }

    /**
     * Cancels a reservation
     */
    suspend fun cancelReservation(
        reservationId: String,
        userId: String,
        reason: String
    ): CancelReservationResponse {
        val idempotencyKey = UUID.randomUUID().toString()

        val request = CancelReservationRequest.newBuilder()
            .setReservationId(reservationId)
            .setUserId(userId)
            .setReason(reason)
            .setIdempotencyKey(idempotencyKey)
            .build()

        try {
            val response = reservationClient.cancelReservation(request)

            if (response.hasError()) {
                throw ReservationException(
                    "Failed to cancel reservation: ${response.error.message}",
                    response.error.code
                )
            }

            logger.info("Reservation cancelled successfully")
            logger.info("Cancelled at: ${response.cancelledAt}")

            return response

        } catch (e: StatusException) {
            logger.error("gRPC error cancelling reservation", e)
            throw ReservationException("gRPC error: ${e.status.description}", null, e)
        }
    }

    /**
     * Lists user's reservations with optional filtering
     */
    suspend fun listReservations(
        userId: String,
        status: ReservationStatus? = null,
        eventId: String? = null
    ): ListReservationsResponse {
        val requestBuilder = ListReservationsRequest.newBuilder()
            .setUserId(userId)

        status?.let { requestBuilder.setStatus(it) }
        eventId?.let { requestBuilder.setEventId(it) }

        val request = requestBuilder.build()

        try {
            val response = reservationClient.listReservations(request)

            if (response.hasError()) {
                throw ReservationException(
                    "Failed to list reservations: ${response.error.message}",
                    response.error.code
                )
            }

            logger.info("Found ${response.reservationsCount} reservations")

            return response

        } catch (e: StatusException) {
            logger.error("gRPC error listing reservations", e)
            throw ReservationException("gRPC error: ${e.status.description}", null, e)
        }
    }

    /**
     * Monitors reservation status changes (polling example)
     */
    suspend fun monitorReservation(
        reservationId: String,
        userId: String,
        onStatusChange: (ReservationStatus) -> Unit
    ) = coroutineScope {
        var lastStatus: ReservationStatus? = null

        while (isActive) {
            try {
                val response = getReservation(reservationId, userId)
                val currentStatus = response.reservation.status

                if (lastStatus != currentStatus) {
                    logger.info("Reservation status changed: $lastStatus -> $currentStatus")
                    onStatusChange(currentStatus)
                    lastStatus = currentStatus
                }

                // Stop monitoring if reservation is in final state
                if (currentStatus in listOf(
                    ReservationStatus.RESERVATION_STATUS_CONFIRMED,
                    ReservationStatus.RESERVATION_STATUS_CANCELLED,
                    ReservationStatus.RESERVATION_STATUS_EXPIRED
                )) {
                    break
                }

                delay(5000) // Poll every 5 seconds

            } catch (e: ReservationException) {
                logger.error("Error monitoring reservation: ${e.message}")
                delay(10000) // Wait longer on error
            }
        }
    }

    /**
     * Closes the gRPC channel
     */
    fun close() {
        try {
            channel.shutdown()
            if (!channel.awaitTermination(5, TimeUnit.SECONDS)) {
                logger.warn("Channel did not terminate gracefully")
                channel.shutdownNow()
            }
        } catch (e: InterruptedException) {
            logger.error("Interrupted while closing channel", e)
            channel.shutdownNow()
        }
    }
}

/**
 * Custom exception for reservation operations
 */
class ReservationException(
    message: String,
    val errorCode: ErrorCode? = null,
    cause: Throwable? = null
) : Exception(message, cause)

/**
 * Example usage of the ReservationServiceExample
 */
suspend fun main() {
    val example = ReservationServiceExample.create("localhost", 8001)

    try {
        // Example parameters
        val eventId = "evt_2025_concert"
        val userId = "user_12345"
        val seatIds = listOf("A-12", "A-13")
        val quantity = 2
        val reservationToken = "rtkn_from_queue_admission"

        println("=== Reservation Flow Example ===")

        // Step 1: Create reservation
        println("\n1. Creating reservation...")
        val createResponse = example.createReservation(
            eventId = eventId,
            userId = userId,
            seatIds = seatIds,
            quantity = quantity,
            reservationToken = reservationToken
        )

        val reservationId = createResponse.reservationId
        println("✓ Reservation created: $reservationId")
        println("  Hold expires at: ${createResponse.holdExpiresAt}")
        println("  Reserved seats: ${createResponse.reservedSeatsList.map { it.id }}")

        // Step 2: Monitor reservation status
        println("\n2. Monitoring reservation status...")
        val monitoringJob = CoroutineScope(Dispatchers.IO).launch {
            example.monitorReservation(reservationId, userId) { status ->
                println("  📊 Status update: $status")
            }
        }

        // Step 3: Simulate payment delay
        println("\n3. Simulating payment process...")
        delay(10000) // 10 seconds

        // Step 4: Confirm reservation
        println("\n4. Confirming reservation...")
        val paymentIntentId = "pay_intent_${System.currentTimeMillis()}"

        try {
            val confirmResponse = example.confirmReservation(
                reservationId = reservationId,
                paymentIntentId = paymentIntentId,
                userId = userId
            )

            println("✓ Reservation confirmed!")
            println("  Order ID: ${confirmResponse.orderId}")
            println("  Confirmed seats: ${confirmResponse.confirmedSeatsList.map { it.id }}")

        } catch (e: ReservationException) {
            println("✗ Confirmation failed: ${e.message}")

            // Wait for expiry
            println("  Waiting for reservation to expire...")
            delay(60000) // Wait for 60-second hold to expire
        }

        // Step 5: Get final status
        println("\n5. Getting final reservation status...")
        val finalResponse = example.getReservation(reservationId, userId)
        println("  Final status: ${finalResponse.reservation.status}")

        if (finalResponse.reservation.hasOrderId()) {
            println("  Order ID: ${finalResponse.reservation.orderId}")
        }

        // Step 6: List all user reservations
        println("\n6. Listing all user reservations...")
        val listResponse = example.listReservations(userId)
        println("  Total reservations: ${listResponse.reservationsCount}")

        listResponse.reservationsList.forEach { reservation ->
            println("  - ${reservation.reservationId}: ${reservation.status}")
        }

        // Cancel monitoring
        monitoringJob.cancel()

    } catch (e: ReservationException) {
        println("❌ Reservation error: ${e.message}")
        e.errorCode?.let { println("   Error code: $it") }
    } catch (e: Exception) {
        println("❌ Unexpected error: ${e.message}")
        e.printStackTrace()
    } finally {
        example.close()
    }
}
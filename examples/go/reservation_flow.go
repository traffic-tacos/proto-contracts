package main

import (
	"context"
	"fmt"
	"log"
	"time"

	"github.com/google/uuid"
	commonpb "github.com/traffic-tacos/proto-contracts/gen/go/common/v1"
	gatewaypb "github.com/traffic-tacos/proto-contracts/gen/go/gateway/v1"
	reservationpb "github.com/traffic-tacos/proto-contracts/gen/go/reservation/v1"
	"google.golang.org/grpc"
	"google.golang.org/grpc/credentials/insecure"
)

// ReservationFlowExample demonstrates complete reservation flow
type ReservationFlowExample struct {
	gatewayClient     gatewaypb.GatewayServiceClient
	reservationClient reservationpb.ReservationServiceClient
	gatewayConn       *grpc.ClientConn
	reservationConn   *grpc.ClientConn
}

// NewReservationFlowExample creates a new example client
func NewReservationFlowExample(gatewayAddr, reservationAddr string) (*ReservationFlowExample, error) {
	// Connect to gateway
	gatewayConn, err := grpc.Dial(gatewayAddr, grpc.WithTransportCredentials(insecure.NewCredentials()))
	if err != nil {
		return nil, fmt.Errorf("failed to connect to gateway: %v", err)
	}

	// Connect to reservation service
	reservationConn, err := grpc.Dial(reservationAddr, grpc.WithTransportCredentials(insecure.NewCredentials()))
	if err != nil {
		gatewayConn.Close()
		return nil, fmt.Errorf("failed to connect to reservation: %v", err)
	}

	return &ReservationFlowExample{
		gatewayClient:     gatewaypb.NewGatewayServiceClient(gatewayConn),
		reservationClient: reservationpb.NewReservationServiceClient(reservationConn),
		gatewayConn:       gatewayConn,
		reservationConn:   reservationConn,
	}, nil
}

// Close closes all connections
func (r *ReservationFlowExample) Close() {
	r.gatewayConn.Close()
	r.reservationConn.Close()
}

// CreateReservation creates a new reservation through the gateway
func (r *ReservationFlowExample) CreateReservation(
	ctx context.Context,
	eventID, userID, reservationToken string,
	seatIDs []string,
	quantity int32,
) (*gatewaypb.CreateReservationResponse, error) {

	idempotencyKey := uuid.New().String()

	req := &gatewaypb.CreateReservationRequest{
		EventId:           eventID,
		SeatIds:           seatIDs,
		Quantity:          quantity,
		UserId:            userID,
		ReservationToken:  reservationToken,
		IdempotencyKey:    idempotencyKey,
		Metadata: &gatewaypb.RequestMetadata{
			RequestId: uuid.New().String(),
			TraceId:   fmt.Sprintf("trace_%d", time.Now().Unix()),
			UserAgent: "example-client/1.0",
			IpAddress: "192.168.1.100",
			SessionId: "session_example",
			Timestamp: timestamppb.Now(),
			Headers: map[string]string{
				"authorization": "Bearer jwt_token_here",
			},
		},
	}

	resp, err := r.gatewayClient.CreateReservation(ctx, req)
	if err != nil {
		return nil, fmt.Errorf("failed to create reservation: %v", err)
	}

	if resp.Error != nil {
		return nil, fmt.Errorf("reservation error: %s", resp.Error.Message)
	}

	return resp, nil
}

// GetReservation retrieves reservation details
func (r *ReservationFlowExample) GetReservation(
	ctx context.Context,
	reservationID, userID string,
) (*reservationpb.GetReservationResponse, error) {

	req := &reservationpb.GetReservationRequest{
		ReservationId: reservationID,
		UserId:        userID,
	}

	resp, err := r.reservationClient.GetReservation(ctx, req)
	if err != nil {
		return nil, fmt.Errorf("failed to get reservation: %v", err)
	}

	if resp.Error != nil {
		return nil, fmt.Errorf("get reservation error: %s", resp.Error.Message)
	}

	return resp, nil
}

// ConfirmReservation confirms a reservation after payment
func (r *ReservationFlowExample) ConfirmReservation(
	ctx context.Context,
	reservationID, paymentIntentID, userID string,
) (*reservationpb.ConfirmReservationResponse, error) {

	req := &reservationpb.ConfirmReservationRequest{
		ReservationId:   reservationID,
		PaymentIntentId: paymentIntentID,
		UserId:          userID,
		IdempotencyKey:  uuid.New().String(),
	}

	resp, err := r.reservationClient.ConfirmReservation(ctx, req)
	if err != nil {
		return nil, fmt.Errorf("failed to confirm reservation: %v", err)
	}

	if resp.Error != nil {
		return nil, fmt.Errorf("confirm reservation error: %s", resp.Error.Message)
	}

	return resp, nil
}

// WaitForHoldExpiry simulates waiting for hold expiry
func (r *ReservationFlowExample) WaitForHoldExpiry(
	ctx context.Context,
	reservationID, userID string,
	holdExpiresAt time.Time,
) error {

	ticker := time.NewTicker(5 * time.Second)
	defer ticker.Stop()

	for {
		select {
		case <-ctx.Done():
			return ctx.Err()
		case <-ticker.C:
			resp, err := r.GetReservation(ctx, reservationID, userID)
			if err != nil {
				log.Printf("Error checking reservation: %v", err)
				continue
			}

			log.Printf("Reservation status: %s", resp.Reservation.Status.String())

			if resp.Reservation.Status == reservationpb.ReservationStatus_RESERVATION_STATUS_EXPIRED {
				log.Println("Reservation expired!")
				return nil
			}

			if resp.Reservation.Status == reservationpb.ReservationStatus_RESERVATION_STATUS_CONFIRMED {
				log.Println("Reservation confirmed!")
				return nil
			}

			timeLeft := time.Until(holdExpiresAt)
			if timeLeft <= 0 {
				log.Println("Hold period expired, checking final status...")
				time.Sleep(2 * time.Second) // Give worker time to process
			} else {
				log.Printf("Time left on hold: %v", timeLeft.Round(time.Second))
			}
		}
	}
}

// Example demonstrates complete reservation flow
func main() {
	// Create client
	client, err := NewReservationFlowExample("localhost:8000", "localhost:8001")
	if err != nil {
		log.Fatalf("Failed to create client: %v", err)
	}
	defer client.Close()

	ctx, cancel := context.WithTimeout(context.Background(), 5*time.Minute)
	defer cancel()

	// Example parameters
	eventID := "evt_2025_concert"
	userID := "user_12345"
	reservationToken := "rtkn_from_queue_admission" // From queue admission
	seatIDs := []string{"A-12", "A-13"}
	quantity := int32(2)

	// Step 1: Create reservation
	log.Printf("Creating reservation for event: %s", eventID)
	createResp, err := client.CreateReservation(ctx, eventID, userID, reservationToken, seatIDs, quantity)
	if err != nil {
		log.Fatalf("Failed to create reservation: %v", err)
	}

	log.Printf("Reservation created: %s", createResp.ReservationId)
	log.Printf("Status: %s", createResp.Status.String())
	log.Printf("Hold expires at: %s", createResp.HoldExpiresAt.AsTime().Format(time.RFC3339))
	log.Printf("Total amount: %d %s", createResp.TotalAmount.Amount, createResp.TotalAmount.Currency)
	log.Printf("Payment URL: %s", createResp.PaymentUrl)

	// Display reserved seats
	log.Println("Reserved seats:")
	for _, seat := range createResp.ReservedSeats {
		log.Printf("  - %s (Section: %s, Row: %s)", seat.Id, seat.Section, seat.Row)
	}

	// Step 2: Simulate payment process (in real app, user would pay via payment URL)
	log.Println("\n--- Simulating payment process ---")
	paymentIntentID := fmt.Sprintf("pay_intent_%d", time.Now().Unix())
	log.Printf("Payment intent ID: %s", paymentIntentID)

	// Wait a bit to simulate payment processing time
	time.Sleep(3 * time.Second)

	// Step 3: Confirm reservation
	log.Println("Confirming reservation after payment...")
	confirmResp, err := client.ConfirmReservation(ctx, createResp.ReservationId, paymentIntentID, userID)
	if err != nil {
		log.Printf("Failed to confirm reservation: %v", err)

		// If confirmation fails, let's watch the reservation expire
		log.Println("Watching reservation for expiry...")
		err = client.WaitForHoldExpiry(ctx, createResp.ReservationId, userID, createResp.HoldExpiresAt.AsTime())
		if err != nil {
			log.Printf("Error while waiting: %v", err)
		}
		return
	}

	log.Printf("Reservation confirmed!")
	log.Printf("Order ID: %s", confirmResp.OrderId)
	log.Printf("Status: %s", confirmResp.Status.String())
	log.Printf("Confirmed at: %s", confirmResp.ConfirmedAt.AsTime().Format(time.RFC3339))

	// Display confirmed seats
	log.Println("Confirmed seats:")
	for _, seat := range confirmResp.ConfirmedSeats {
		log.Printf("  - %s (Status: %s)", seat.Id, seat.Status.String())
	}

	// Step 4: Get final reservation details
	log.Println("\nFetching final reservation details...")
	getResp, err := client.GetReservation(ctx, createResp.ReservationId, userID)
	if err != nil {
		log.Printf("Failed to get reservation: %v", err)
		return
	}

	reservation := getResp.Reservation
	log.Printf("Final reservation details:")
	log.Printf("  ID: %s", reservation.ReservationId)
	log.Printf("  Status: %s", reservation.Status.String())
	log.Printf("  Order ID: %s", reservation.OrderId)
	log.Printf("  Total Amount: %d %s", reservation.TotalAmount.Amount, reservation.TotalAmount.Currency)
	log.Printf("  Created: %s", reservation.CreatedAt.AsTime().Format(time.RFC3339))
	log.Printf("  Updated: %s", reservation.UpdatedAt.AsTime().Format(time.RFC3339))
}
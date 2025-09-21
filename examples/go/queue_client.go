package main

import (
	"context"
	"fmt"
	"log"
	"time"

	gatewaypb "github.com/traffic-tacos/proto-contracts/gen/go/gateway/v1"
	"google.golang.org/grpc"
	"google.golang.org/grpc/credentials/insecure"
)

// QueueClient demonstrates how to interact with the QueueService
type QueueClient struct {
	client gatewaypb.QueueServiceClient
	conn   *grpc.ClientConn
}

// NewQueueClient creates a new queue client
func NewQueueClient(address string) (*QueueClient, error) {
	conn, err := grpc.Dial(address, grpc.WithTransportCredentials(insecure.NewCredentials()))
	if err != nil {
		return nil, fmt.Errorf("failed to connect: %v", err)
	}

	client := gatewaypb.NewQueueServiceClient(conn)
	return &QueueClient{
		client: client,
		conn:   conn,
	}, nil
}

// Close closes the connection
func (qc *QueueClient) Close() error {
	return qc.conn.Close()
}

// JoinQueue joins a queue for an event
func (qc *QueueClient) JoinQueue(ctx context.Context, eventID, userID, sessionID string) (*gatewaypb.JoinQueueResponse, error) {
	req := &gatewaypb.JoinQueueRequest{
		EventId:   eventID,
		UserId:    userID,
		SessionId: sessionID,
		Metadata: &gatewaypb.QueueMetadata{
			IpAddress: "192.168.1.100",
			UserAgent: "example-client/1.0",
			Referer:   "https://traffic-tacos.com/events/" + eventID,
		},
	}

	resp, err := qc.client.JoinQueue(ctx, req)
	if err != nil {
		return nil, fmt.Errorf("failed to join queue: %v", err)
	}

	if resp.Error != nil {
		return nil, fmt.Errorf("queue join error: %s", resp.Error.Message)
	}

	return resp, nil
}

// WaitForAdmission polls queue status until admission is ready
func (qc *QueueClient) WaitForAdmission(ctx context.Context, waitingToken string) (*gatewaypb.GetQueueStatusResponse, error) {
	ticker := time.NewTicker(5 * time.Second)
	defer ticker.Stop()

	for {
		select {
		case <-ctx.Done():
			return nil, ctx.Err()
		case <-ticker.C:
			resp, err := qc.client.GetQueueStatus(ctx, &gatewaypb.GetQueueStatusRequest{
				WaitingToken: waitingToken,
			})
			if err != nil {
				return nil, fmt.Errorf("failed to get queue status: %v", err)
			}

			if resp.Error != nil {
				return nil, fmt.Errorf("queue status error: %s", resp.Error.Message)
			}

			log.Printf("Queue position: %d, ETA: %d seconds", resp.Position, resp.EtaSeconds)

			if resp.AdmissionReady {
				log.Println("Admission ready!")
				return resp, nil
			}

			if resp.Status == gatewaypb.QueueStatus_QUEUE_STATUS_EXPIRED {
				return nil, fmt.Errorf("queue token expired")
			}
		}
	}
}

// RequestAdmission requests admission to the reservation system
func (qc *QueueClient) RequestAdmission(ctx context.Context, waitingToken, eventID, userID string) (*gatewaypb.RequestAdmissionResponse, error) {
	req := &gatewaypb.RequestAdmissionRequest{
		WaitingToken: waitingToken,
		EventId:      eventID,
		UserId:       userID,
	}

	resp, err := qc.client.RequestAdmission(ctx, req)
	if err != nil {
		return nil, fmt.Errorf("failed to request admission: %v", err)
	}

	if resp.Error != nil {
		return nil, fmt.Errorf("admission error: %s", resp.Error.Message)
	}

	return resp, nil
}

// Example demonstrates the complete queue flow
func main() {
	// Create client
	client, err := NewQueueClient("localhost:8000")
	if err != nil {
		log.Fatalf("Failed to create client: %v", err)
	}
	defer client.Close()

	ctx, cancel := context.WithTimeout(context.Background(), 10*time.Minute)
	defer cancel()

	// Step 1: Join queue
	eventID := "evt_2025_concert"
	userID := "user_12345"
	sessionID := "session_abcdef"

	log.Printf("Joining queue for event: %s", eventID)
	joinResp, err := client.JoinQueue(ctx, eventID, userID, sessionID)
	if err != nil {
		log.Fatalf("Failed to join queue: %v", err)
	}

	log.Printf("Joined queue! Position hint: %d, ETA: %d seconds",
		joinResp.PositionHint, joinResp.EtaSeconds)

	// Step 2: Wait for admission
	log.Println("Waiting for admission...")
	statusResp, err := client.WaitForAdmission(ctx, joinResp.WaitingToken)
	if err != nil {
		log.Fatalf("Failed while waiting: %v", err)
	}

	// Step 3: Request admission
	log.Println("Requesting admission...")
	admissionResp, err := client.RequestAdmission(ctx, joinResp.WaitingToken, eventID, userID)
	if err != nil {
		log.Fatalf("Failed to get admission: %v", err)
	}

	if admissionResp.Admission == gatewaypb.AdmissionStatus_ADMISSION_STATUS_GRANTED {
		log.Printf("Admission granted! Reservation token: %s", admissionResp.ReservationToken)
		log.Printf("Token valid for %d seconds", admissionResp.TtlSeconds)
	} else {
		log.Printf("Admission denied: %s", admissionResp.Admission.String())
	}
}
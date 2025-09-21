/**
 * TypeScript example for interacting with Traffic Tacos Queue API
 * This demonstrates frontend integration with the Gateway API REST endpoints
 */

// Types derived from proto definitions
export interface QueueJoinRequest {
  event_id: string;
  user_id?: string;
  session_id: string;
  metadata?: {
    ip_address?: string;
    user_agent?: string;
    referer?: string;
    country_code?: string;
    headers?: Record<string, string>;
  };
}

export interface QueueJoinResponse {
  waiting_token: string;
  position_hint: number;
  eta_seconds: number;
  status: QueueStatus;
  expires_at: string;
  error?: ApiError;
}

export interface QueueStatusResponse {
  status: QueueStatus;
  position: number;
  eta_seconds: number;
  admission_ready: boolean;
  expires_at: string;
  error?: ApiError;
}

export interface AdmissionRequest {
  waiting_token: string;
  event_id: string;
  user_id?: string;
}

export interface AdmissionResponse {
  admission: AdmissionStatus;
  reservation_token: string;
  ttl_seconds: number;
  valid_until: string;
  error?: ApiError;
}

export enum QueueStatus {
  WAITING = "waiting",
  READY = "ready",
  EXPIRED = "expired",
  LEFT = "left",
  ERROR = "error"
}

export enum AdmissionStatus {
  GRANTED = "granted",
  DENIED = "denied",
  EXPIRED = "expired",
  INVALID = "invalid"
}

export interface ApiError {
  code: string;
  message: string;
  trace_id?: string;
  details?: Array<{
    field: string;
    reason: string;
    value?: string;
  }>;
}

/**
 * Client for interacting with the Traffic Tacos Queue API
 */
export class QueueClient {
  private baseUrl: string;
  private wsUrl: string;
  private sessionId: string;

  constructor(
    baseUrl: string = 'http://localhost:8000',
    wsUrl: string = 'ws://localhost:8000'
  ) {
    this.baseUrl = baseUrl;
    this.wsUrl = wsUrl;
    this.sessionId = this.generateSessionId();
  }

  /**
   * Join the queue for an event
   */
  async joinQueue(
    eventId: string,
    userId?: string,
    metadata?: QueueJoinRequest['metadata']
  ): Promise<QueueJoinResponse> {
    const request: QueueJoinRequest = {
      event_id: eventId,
      user_id: userId,
      session_id: this.sessionId,
      metadata: {
        user_agent: navigator.userAgent,
        referer: window.location.href,
        ...metadata
      }
    };

    const response = await this.post('/api/v1/queue/join', request);

    if (!response.ok) {
      throw new Error(`Failed to join queue: ${response.status}`);
    }

    const data: QueueJoinResponse = await response.json();

    if (data.error) {
      throw new QueueError(data.error.message, data.error.code);
    }

    return data;
  }

  /**
   * Get current queue status
   */
  async getQueueStatus(waitingToken: string): Promise<QueueStatusResponse> {
    const response = await this.get(`/api/v1/queue/status?token=${waitingToken}`);

    if (!response.ok) {
      throw new Error(`Failed to get queue status: ${response.status}`);
    }

    const data: QueueStatusResponse = await response.json();

    if (data.error) {
      throw new QueueError(data.error.message, data.error.code);
    }

    return data;
  }

  /**
   * Request admission from queue
   */
  async requestAdmission(
    waitingToken: string,
    eventId: string,
    userId?: string
  ): Promise<AdmissionResponse> {
    const request: AdmissionRequest = {
      waiting_token: waitingToken,
      event_id: eventId,
      user_id: userId
    };

    const response = await this.post('/api/v1/queue/enter', request);

    if (!response.ok) {
      throw new Error(`Failed to request admission: ${response.status}`);
    }

    const data: AdmissionResponse = await response.json();

    if (data.error) {
      throw new QueueError(data.error.message, data.error.code);
    }

    return data;
  }

  /**
   * Leave the queue voluntarily
   */
  async leaveQueue(waitingToken: string, reason?: string): Promise<void> {
    const request = {
      waiting_token: waitingToken,
      reason: reason || 'user_cancelled'
    };

    const response = await this.delete('/api/v1/queue/leave', request);

    if (!response.ok) {
      throw new Error(`Failed to leave queue: ${response.status}`);
    }
  }

  /**
   * Create WebSocket connection for real-time updates
   */
  createWebSocketConnection(
    waitingToken: string,
    onUpdate: (event: QueueUpdateEvent) => void,
    onError?: (error: Error) => void
  ): WebSocket {
    const wsUrl = `${this.wsUrl}/ws/queue/${waitingToken}?session_id=${this.sessionId}`;
    const ws = new WebSocket(wsUrl);

    ws.onmessage = (event) => {
      try {
        const data: QueueUpdateEvent = JSON.parse(event.data);
        onUpdate(data);
      } catch (error) {
        console.error('Failed to parse WebSocket message:', error);
        onError?.(new Error('Invalid WebSocket message format'));
      }
    };

    ws.onerror = (event) => {
      console.error('WebSocket error:', event);
      onError?.(new Error('WebSocket connection error'));
    };

    ws.onclose = (event) => {
      console.log('WebSocket connection closed:', event.code, event.reason);
    };

    return ws;
  }

  /**
   * Complete queue flow example
   */
  async completeQueueFlow(
    eventId: string,
    userId?: string,
    onStatusUpdate?: (status: QueueStatusResponse) => void
  ): Promise<AdmissionResponse> {
    // Step 1: Join queue
    console.log(`Joining queue for event: ${eventId}`);
    const joinResponse = await this.joinQueue(eventId, userId);

    console.log(`Joined queue! Position: ${joinResponse.position_hint}, ETA: ${joinResponse.eta_seconds}s`);

    // Step 2: Set up real-time updates
    const ws = this.createWebSocketConnection(
      joinResponse.waiting_token,
      (event) => {
        console.log('Queue update:', event);
        if (event.type === 'QUEUE_EVENT_TYPE_POSITION_CHANGED') {
          onStatusUpdate?.({
            status: QueueStatus.WAITING,
            position: event.queue_update.position,
            eta_seconds: event.queue_update.eta_seconds,
            admission_ready: event.queue_update.admission_ready,
            expires_at: event.queue_update.expires_at
          });
        }
      },
      (error) => console.error('WebSocket error:', error)
    );

    // Step 3: Poll for admission readiness
    return new Promise((resolve, reject) => {
      const pollInterval = setInterval(async () => {
        try {
          const status = await this.getQueueStatus(joinResponse.waiting_token);

          console.log(`Queue position: ${status.position}, ETA: ${status.eta_seconds}s`);
          onStatusUpdate?.(status);

          if (status.admission_ready) {
            clearInterval(pollInterval);
            ws.close();

            // Request admission
            const admission = await this.requestAdmission(
              joinResponse.waiting_token,
              eventId,
              userId
            );

            if (admission.admission === AdmissionStatus.GRANTED) {
              console.log(`Admission granted! Token: ${admission.reservation_token}`);
              resolve(admission);
            } else {
              reject(new Error(`Admission denied: ${admission.admission}`));
            }
          }

          if (status.status === QueueStatus.EXPIRED) {
            clearInterval(pollInterval);
            ws.close();
            reject(new Error('Queue token expired'));
          }

        } catch (error) {
          clearInterval(pollInterval);
          ws.close();
          reject(error);
        }
      }, 5000); // Poll every 5 seconds

      // Set timeout for maximum wait time
      setTimeout(() => {
        clearInterval(pollInterval);
        ws.close();
        reject(new Error('Queue timeout exceeded'));
      }, 30 * 60 * 1000); // 30 minutes
    });
  }

  // Private helper methods
  private async get(path: string): Promise<Response> {
    return fetch(`${this.baseUrl}${path}`, {
      method: 'GET',
      headers: {
        'Content-Type': 'application/json',
      },
    });
  }

  private async post(path: string, body: any): Promise<Response> {
    return fetch(`${this.baseUrl}${path}`, {
      method: 'POST',
      headers: {
        'Content-Type': 'application/json',
      },
      body: JSON.stringify(body),
    });
  }

  private async delete(path: string, body?: any): Promise<Response> {
    return fetch(`${this.baseUrl}${path}`, {
      method: 'DELETE',
      headers: {
        'Content-Type': 'application/json',
      },
      body: body ? JSON.stringify(body) : undefined,
    });
  }

  private generateSessionId(): string {
    return 'session_' + Math.random().toString(36).substr(2, 9);
  }
}

// WebSocket event types
export interface QueueUpdateEvent {
  type: string;
  queue_update: {
    waiting_token: string;
    position: number;
    eta_seconds: number;
    event_type: string;
    admission_ready: boolean;
    expires_at: string;
  };
  system_update?: {
    event_id: string;
    total_waiting: number;
    admission_rate: number;
    event_type: string;
    message: string;
  };
  timestamp: string;
  correlation_id: string;
}

// Custom error class
export class QueueError extends Error {
  constructor(
    message: string,
    public code?: string,
    public traceId?: string
  ) {
    super(message);
    this.name = 'QueueError';
  }
}

// Usage example
export async function exampleUsage() {
  const queueClient = new QueueClient();

  try {
    console.log('=== Queue Flow Example ===');

    const eventId = 'evt_2025_concert';
    const userId = 'user_12345';

    // Complete queue flow with real-time updates
    const admission = await queueClient.completeQueueFlow(
      eventId,
      userId,
      (status) => {
        console.log(`📊 Queue update - Position: ${status.position}, ETA: ${status.eta_seconds}s`);

        // Update UI here
        updateQueueUI(status);
      }
    );

    console.log('✅ Admission granted!');
    console.log(`🎫 Reservation token: ${admission.reservation_token}`);
    console.log(`⏰ Valid for: ${admission.ttl_seconds} seconds`);

    // Now you can use the reservation token to create a reservation
    // via the reservation API

  } catch (error) {
    console.error('❌ Queue flow failed:', error);

    if (error instanceof QueueError) {
      console.error(`Error code: ${error.code}`);
      console.error(`Trace ID: ${error.traceId}`);
    }
  }
}

// UI update function (implementation depends on your framework)
function updateQueueUI(status: QueueStatusResponse) {
  // Example using vanilla JavaScript
  const positionEl = document.getElementById('queue-position');
  const etaEl = document.getElementById('queue-eta');
  const statusEl = document.getElementById('queue-status');

  if (positionEl) positionEl.textContent = status.position.toString();
  if (etaEl) etaEl.textContent = `${Math.ceil(status.eta_seconds / 60)} minutes`;
  if (statusEl) statusEl.textContent = status.status;

  // Show admission ready notification
  if (status.admission_ready) {
    showNotification('🎉 You can now proceed to select your seats!', 'success');
  }
}

function showNotification(message: string, type: 'success' | 'error' | 'info') {
  // Implementation depends on your notification system
  console.log(`[${type.toUpperCase()}] ${message}`);
}
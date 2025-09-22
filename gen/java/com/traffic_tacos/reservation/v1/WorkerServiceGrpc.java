package com.traffic_tacos.reservation.v1;

import static io.grpc.MethodDescriptor.generateFullMethodName;

/**
 * <pre>
 * Worker service for background event processing
 * Handles reservation expiry, payment result processing, and cleanup tasks
 * Runs as Kubernetes Job with KEDA auto-scaling based on SQS queue depth
 * </pre>
 */
@io.grpc.stub.annotations.GrpcGenerated
public final class WorkerServiceGrpc {

  private WorkerServiceGrpc() {}

  public static final java.lang.String SERVICE_NAME = "reservation.v1.WorkerService";

  // Static method descriptors that strictly reflect the proto.
  private static volatile io.grpc.MethodDescriptor<com.traffic_tacos.reservation.v1.ProcessReservationExpiryRequest,
      com.traffic_tacos.reservation.v1.ProcessReservationExpiryResponse> getProcessReservationExpiryMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "ProcessReservationExpiry",
      requestType = com.traffic_tacos.reservation.v1.ProcessReservationExpiryRequest.class,
      responseType = com.traffic_tacos.reservation.v1.ProcessReservationExpiryResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<com.traffic_tacos.reservation.v1.ProcessReservationExpiryRequest,
      com.traffic_tacos.reservation.v1.ProcessReservationExpiryResponse> getProcessReservationExpiryMethod() {
    io.grpc.MethodDescriptor<com.traffic_tacos.reservation.v1.ProcessReservationExpiryRequest, com.traffic_tacos.reservation.v1.ProcessReservationExpiryResponse> getProcessReservationExpiryMethod;
    if ((getProcessReservationExpiryMethod = WorkerServiceGrpc.getProcessReservationExpiryMethod) == null) {
      synchronized (WorkerServiceGrpc.class) {
        if ((getProcessReservationExpiryMethod = WorkerServiceGrpc.getProcessReservationExpiryMethod) == null) {
          WorkerServiceGrpc.getProcessReservationExpiryMethod = getProcessReservationExpiryMethod =
              io.grpc.MethodDescriptor.<com.traffic_tacos.reservation.v1.ProcessReservationExpiryRequest, com.traffic_tacos.reservation.v1.ProcessReservationExpiryResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "ProcessReservationExpiry"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.traffic_tacos.reservation.v1.ProcessReservationExpiryRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.traffic_tacos.reservation.v1.ProcessReservationExpiryResponse.getDefaultInstance()))
              .setSchemaDescriptor(new WorkerServiceMethodDescriptorSupplier("ProcessReservationExpiry"))
              .build();
        }
      }
    }
    return getProcessReservationExpiryMethod;
  }

  private static volatile io.grpc.MethodDescriptor<com.traffic_tacos.reservation.v1.ProcessPaymentResultRequest,
      com.traffic_tacos.reservation.v1.ProcessPaymentResultResponse> getProcessPaymentResultMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "ProcessPaymentResult",
      requestType = com.traffic_tacos.reservation.v1.ProcessPaymentResultRequest.class,
      responseType = com.traffic_tacos.reservation.v1.ProcessPaymentResultResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<com.traffic_tacos.reservation.v1.ProcessPaymentResultRequest,
      com.traffic_tacos.reservation.v1.ProcessPaymentResultResponse> getProcessPaymentResultMethod() {
    io.grpc.MethodDescriptor<com.traffic_tacos.reservation.v1.ProcessPaymentResultRequest, com.traffic_tacos.reservation.v1.ProcessPaymentResultResponse> getProcessPaymentResultMethod;
    if ((getProcessPaymentResultMethod = WorkerServiceGrpc.getProcessPaymentResultMethod) == null) {
      synchronized (WorkerServiceGrpc.class) {
        if ((getProcessPaymentResultMethod = WorkerServiceGrpc.getProcessPaymentResultMethod) == null) {
          WorkerServiceGrpc.getProcessPaymentResultMethod = getProcessPaymentResultMethod =
              io.grpc.MethodDescriptor.<com.traffic_tacos.reservation.v1.ProcessPaymentResultRequest, com.traffic_tacos.reservation.v1.ProcessPaymentResultResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "ProcessPaymentResult"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.traffic_tacos.reservation.v1.ProcessPaymentResultRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.traffic_tacos.reservation.v1.ProcessPaymentResultResponse.getDefaultInstance()))
              .setSchemaDescriptor(new WorkerServiceMethodDescriptorSupplier("ProcessPaymentResult"))
              .build();
        }
      }
    }
    return getProcessPaymentResultMethod;
  }

  private static volatile io.grpc.MethodDescriptor<com.traffic_tacos.reservation.v1.ProcessCompensationRequest,
      com.traffic_tacos.reservation.v1.ProcessCompensationResponse> getProcessCompensationMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "ProcessCompensation",
      requestType = com.traffic_tacos.reservation.v1.ProcessCompensationRequest.class,
      responseType = com.traffic_tacos.reservation.v1.ProcessCompensationResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<com.traffic_tacos.reservation.v1.ProcessCompensationRequest,
      com.traffic_tacos.reservation.v1.ProcessCompensationResponse> getProcessCompensationMethod() {
    io.grpc.MethodDescriptor<com.traffic_tacos.reservation.v1.ProcessCompensationRequest, com.traffic_tacos.reservation.v1.ProcessCompensationResponse> getProcessCompensationMethod;
    if ((getProcessCompensationMethod = WorkerServiceGrpc.getProcessCompensationMethod) == null) {
      synchronized (WorkerServiceGrpc.class) {
        if ((getProcessCompensationMethod = WorkerServiceGrpc.getProcessCompensationMethod) == null) {
          WorkerServiceGrpc.getProcessCompensationMethod = getProcessCompensationMethod =
              io.grpc.MethodDescriptor.<com.traffic_tacos.reservation.v1.ProcessCompensationRequest, com.traffic_tacos.reservation.v1.ProcessCompensationResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "ProcessCompensation"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.traffic_tacos.reservation.v1.ProcessCompensationRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.traffic_tacos.reservation.v1.ProcessCompensationResponse.getDefaultInstance()))
              .setSchemaDescriptor(new WorkerServiceMethodDescriptorSupplier("ProcessCompensation"))
              .build();
        }
      }
    }
    return getProcessCompensationMethod;
  }

  private static volatile io.grpc.MethodDescriptor<com.traffic_tacos.reservation.v1.HealthCheckRequest,
      com.traffic_tacos.reservation.v1.HealthCheckResponse> getHealthCheckMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "HealthCheck",
      requestType = com.traffic_tacos.reservation.v1.HealthCheckRequest.class,
      responseType = com.traffic_tacos.reservation.v1.HealthCheckResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<com.traffic_tacos.reservation.v1.HealthCheckRequest,
      com.traffic_tacos.reservation.v1.HealthCheckResponse> getHealthCheckMethod() {
    io.grpc.MethodDescriptor<com.traffic_tacos.reservation.v1.HealthCheckRequest, com.traffic_tacos.reservation.v1.HealthCheckResponse> getHealthCheckMethod;
    if ((getHealthCheckMethod = WorkerServiceGrpc.getHealthCheckMethod) == null) {
      synchronized (WorkerServiceGrpc.class) {
        if ((getHealthCheckMethod = WorkerServiceGrpc.getHealthCheckMethod) == null) {
          WorkerServiceGrpc.getHealthCheckMethod = getHealthCheckMethod =
              io.grpc.MethodDescriptor.<com.traffic_tacos.reservation.v1.HealthCheckRequest, com.traffic_tacos.reservation.v1.HealthCheckResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "HealthCheck"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.traffic_tacos.reservation.v1.HealthCheckRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.traffic_tacos.reservation.v1.HealthCheckResponse.getDefaultInstance()))
              .setSchemaDescriptor(new WorkerServiceMethodDescriptorSupplier("HealthCheck"))
              .build();
        }
      }
    }
    return getHealthCheckMethod;
  }

  private static volatile io.grpc.MethodDescriptor<com.traffic_tacos.reservation.v1.GetJobStatusRequest,
      com.traffic_tacos.reservation.v1.GetJobStatusResponse> getGetJobStatusMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "GetJobStatus",
      requestType = com.traffic_tacos.reservation.v1.GetJobStatusRequest.class,
      responseType = com.traffic_tacos.reservation.v1.GetJobStatusResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<com.traffic_tacos.reservation.v1.GetJobStatusRequest,
      com.traffic_tacos.reservation.v1.GetJobStatusResponse> getGetJobStatusMethod() {
    io.grpc.MethodDescriptor<com.traffic_tacos.reservation.v1.GetJobStatusRequest, com.traffic_tacos.reservation.v1.GetJobStatusResponse> getGetJobStatusMethod;
    if ((getGetJobStatusMethod = WorkerServiceGrpc.getGetJobStatusMethod) == null) {
      synchronized (WorkerServiceGrpc.class) {
        if ((getGetJobStatusMethod = WorkerServiceGrpc.getGetJobStatusMethod) == null) {
          WorkerServiceGrpc.getGetJobStatusMethod = getGetJobStatusMethod =
              io.grpc.MethodDescriptor.<com.traffic_tacos.reservation.v1.GetJobStatusRequest, com.traffic_tacos.reservation.v1.GetJobStatusResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "GetJobStatus"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.traffic_tacos.reservation.v1.GetJobStatusRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.traffic_tacos.reservation.v1.GetJobStatusResponse.getDefaultInstance()))
              .setSchemaDescriptor(new WorkerServiceMethodDescriptorSupplier("GetJobStatus"))
              .build();
        }
      }
    }
    return getGetJobStatusMethod;
  }

  /**
   * Creates a new async stub that supports all call types for the service
   */
  public static WorkerServiceStub newStub(io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<WorkerServiceStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<WorkerServiceStub>() {
        @java.lang.Override
        public WorkerServiceStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new WorkerServiceStub(channel, callOptions);
        }
      };
    return WorkerServiceStub.newStub(factory, channel);
  }

  /**
   * Creates a new blocking-style stub that supports all types of calls on the service
   */
  public static WorkerServiceBlockingV2Stub newBlockingV2Stub(
      io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<WorkerServiceBlockingV2Stub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<WorkerServiceBlockingV2Stub>() {
        @java.lang.Override
        public WorkerServiceBlockingV2Stub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new WorkerServiceBlockingV2Stub(channel, callOptions);
        }
      };
    return WorkerServiceBlockingV2Stub.newStub(factory, channel);
  }

  /**
   * Creates a new blocking-style stub that supports unary and streaming output calls on the service
   */
  public static WorkerServiceBlockingStub newBlockingStub(
      io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<WorkerServiceBlockingStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<WorkerServiceBlockingStub>() {
        @java.lang.Override
        public WorkerServiceBlockingStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new WorkerServiceBlockingStub(channel, callOptions);
        }
      };
    return WorkerServiceBlockingStub.newStub(factory, channel);
  }

  /**
   * Creates a new ListenableFuture-style stub that supports unary calls on the service
   */
  public static WorkerServiceFutureStub newFutureStub(
      io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<WorkerServiceFutureStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<WorkerServiceFutureStub>() {
        @java.lang.Override
        public WorkerServiceFutureStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new WorkerServiceFutureStub(channel, callOptions);
        }
      };
    return WorkerServiceFutureStub.newStub(factory, channel);
  }

  /**
   * <pre>
   * Worker service for background event processing
   * Handles reservation expiry, payment result processing, and cleanup tasks
   * Runs as Kubernetes Job with KEDA auto-scaling based on SQS queue depth
   * </pre>
   */
  public interface AsyncService {

    /**
     * <pre>
     * Process reservation expiry events (60-second hold timeout)
     * </pre>
     */
    default void processReservationExpiry(com.traffic_tacos.reservation.v1.ProcessReservationExpiryRequest request,
        io.grpc.stub.StreamObserver<com.traffic_tacos.reservation.v1.ProcessReservationExpiryResponse> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getProcessReservationExpiryMethod(), responseObserver);
    }

    /**
     * <pre>
     * Process payment result events (approved/failed)
     * </pre>
     */
    default void processPaymentResult(com.traffic_tacos.reservation.v1.ProcessPaymentResultRequest request,
        io.grpc.stub.StreamObserver<com.traffic_tacos.reservation.v1.ProcessPaymentResultResponse> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getProcessPaymentResultMethod(), responseObserver);
    }

    /**
     * <pre>
     * Process compensation/retry events for failed operations
     * </pre>
     */
    default void processCompensation(com.traffic_tacos.reservation.v1.ProcessCompensationRequest request,
        io.grpc.stub.StreamObserver<com.traffic_tacos.reservation.v1.ProcessCompensationResponse> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getProcessCompensationMethod(), responseObserver);
    }

    /**
     * <pre>
     * Health check for worker instances
     * </pre>
     */
    default void healthCheck(com.traffic_tacos.reservation.v1.HealthCheckRequest request,
        io.grpc.stub.StreamObserver<com.traffic_tacos.reservation.v1.HealthCheckResponse> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getHealthCheckMethod(), responseObserver);
    }

    /**
     * <pre>
     * Get worker job status and metrics
     * </pre>
     */
    default void getJobStatus(com.traffic_tacos.reservation.v1.GetJobStatusRequest request,
        io.grpc.stub.StreamObserver<com.traffic_tacos.reservation.v1.GetJobStatusResponse> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getGetJobStatusMethod(), responseObserver);
    }
  }

  /**
   * Base class for the server implementation of the service WorkerService.
   * <pre>
   * Worker service for background event processing
   * Handles reservation expiry, payment result processing, and cleanup tasks
   * Runs as Kubernetes Job with KEDA auto-scaling based on SQS queue depth
   * </pre>
   */
  public static abstract class WorkerServiceImplBase
      implements io.grpc.BindableService, AsyncService {

    @java.lang.Override public final io.grpc.ServerServiceDefinition bindService() {
      return WorkerServiceGrpc.bindService(this);
    }
  }

  /**
   * A stub to allow clients to do asynchronous rpc calls to service WorkerService.
   * <pre>
   * Worker service for background event processing
   * Handles reservation expiry, payment result processing, and cleanup tasks
   * Runs as Kubernetes Job with KEDA auto-scaling based on SQS queue depth
   * </pre>
   */
  public static final class WorkerServiceStub
      extends io.grpc.stub.AbstractAsyncStub<WorkerServiceStub> {
    private WorkerServiceStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected WorkerServiceStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new WorkerServiceStub(channel, callOptions);
    }

    /**
     * <pre>
     * Process reservation expiry events (60-second hold timeout)
     * </pre>
     */
    public void processReservationExpiry(com.traffic_tacos.reservation.v1.ProcessReservationExpiryRequest request,
        io.grpc.stub.StreamObserver<com.traffic_tacos.reservation.v1.ProcessReservationExpiryResponse> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getProcessReservationExpiryMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     * <pre>
     * Process payment result events (approved/failed)
     * </pre>
     */
    public void processPaymentResult(com.traffic_tacos.reservation.v1.ProcessPaymentResultRequest request,
        io.grpc.stub.StreamObserver<com.traffic_tacos.reservation.v1.ProcessPaymentResultResponse> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getProcessPaymentResultMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     * <pre>
     * Process compensation/retry events for failed operations
     * </pre>
     */
    public void processCompensation(com.traffic_tacos.reservation.v1.ProcessCompensationRequest request,
        io.grpc.stub.StreamObserver<com.traffic_tacos.reservation.v1.ProcessCompensationResponse> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getProcessCompensationMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     * <pre>
     * Health check for worker instances
     * </pre>
     */
    public void healthCheck(com.traffic_tacos.reservation.v1.HealthCheckRequest request,
        io.grpc.stub.StreamObserver<com.traffic_tacos.reservation.v1.HealthCheckResponse> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getHealthCheckMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     * <pre>
     * Get worker job status and metrics
     * </pre>
     */
    public void getJobStatus(com.traffic_tacos.reservation.v1.GetJobStatusRequest request,
        io.grpc.stub.StreamObserver<com.traffic_tacos.reservation.v1.GetJobStatusResponse> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getGetJobStatusMethod(), getCallOptions()), request, responseObserver);
    }
  }

  /**
   * A stub to allow clients to do synchronous rpc calls to service WorkerService.
   * <pre>
   * Worker service for background event processing
   * Handles reservation expiry, payment result processing, and cleanup tasks
   * Runs as Kubernetes Job with KEDA auto-scaling based on SQS queue depth
   * </pre>
   */
  public static final class WorkerServiceBlockingV2Stub
      extends io.grpc.stub.AbstractBlockingStub<WorkerServiceBlockingV2Stub> {
    private WorkerServiceBlockingV2Stub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected WorkerServiceBlockingV2Stub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new WorkerServiceBlockingV2Stub(channel, callOptions);
    }

    /**
     * <pre>
     * Process reservation expiry events (60-second hold timeout)
     * </pre>
     */
    public com.traffic_tacos.reservation.v1.ProcessReservationExpiryResponse processReservationExpiry(com.traffic_tacos.reservation.v1.ProcessReservationExpiryRequest request) throws io.grpc.StatusException {
      return io.grpc.stub.ClientCalls.blockingV2UnaryCall(
          getChannel(), getProcessReservationExpiryMethod(), getCallOptions(), request);
    }

    /**
     * <pre>
     * Process payment result events (approved/failed)
     * </pre>
     */
    public com.traffic_tacos.reservation.v1.ProcessPaymentResultResponse processPaymentResult(com.traffic_tacos.reservation.v1.ProcessPaymentResultRequest request) throws io.grpc.StatusException {
      return io.grpc.stub.ClientCalls.blockingV2UnaryCall(
          getChannel(), getProcessPaymentResultMethod(), getCallOptions(), request);
    }

    /**
     * <pre>
     * Process compensation/retry events for failed operations
     * </pre>
     */
    public com.traffic_tacos.reservation.v1.ProcessCompensationResponse processCompensation(com.traffic_tacos.reservation.v1.ProcessCompensationRequest request) throws io.grpc.StatusException {
      return io.grpc.stub.ClientCalls.blockingV2UnaryCall(
          getChannel(), getProcessCompensationMethod(), getCallOptions(), request);
    }

    /**
     * <pre>
     * Health check for worker instances
     * </pre>
     */
    public com.traffic_tacos.reservation.v1.HealthCheckResponse healthCheck(com.traffic_tacos.reservation.v1.HealthCheckRequest request) throws io.grpc.StatusException {
      return io.grpc.stub.ClientCalls.blockingV2UnaryCall(
          getChannel(), getHealthCheckMethod(), getCallOptions(), request);
    }

    /**
     * <pre>
     * Get worker job status and metrics
     * </pre>
     */
    public com.traffic_tacos.reservation.v1.GetJobStatusResponse getJobStatus(com.traffic_tacos.reservation.v1.GetJobStatusRequest request) throws io.grpc.StatusException {
      return io.grpc.stub.ClientCalls.blockingV2UnaryCall(
          getChannel(), getGetJobStatusMethod(), getCallOptions(), request);
    }
  }

  /**
   * A stub to allow clients to do limited synchronous rpc calls to service WorkerService.
   * <pre>
   * Worker service for background event processing
   * Handles reservation expiry, payment result processing, and cleanup tasks
   * Runs as Kubernetes Job with KEDA auto-scaling based on SQS queue depth
   * </pre>
   */
  public static final class WorkerServiceBlockingStub
      extends io.grpc.stub.AbstractBlockingStub<WorkerServiceBlockingStub> {
    private WorkerServiceBlockingStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected WorkerServiceBlockingStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new WorkerServiceBlockingStub(channel, callOptions);
    }

    /**
     * <pre>
     * Process reservation expiry events (60-second hold timeout)
     * </pre>
     */
    public com.traffic_tacos.reservation.v1.ProcessReservationExpiryResponse processReservationExpiry(com.traffic_tacos.reservation.v1.ProcessReservationExpiryRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getProcessReservationExpiryMethod(), getCallOptions(), request);
    }

    /**
     * <pre>
     * Process payment result events (approved/failed)
     * </pre>
     */
    public com.traffic_tacos.reservation.v1.ProcessPaymentResultResponse processPaymentResult(com.traffic_tacos.reservation.v1.ProcessPaymentResultRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getProcessPaymentResultMethod(), getCallOptions(), request);
    }

    /**
     * <pre>
     * Process compensation/retry events for failed operations
     * </pre>
     */
    public com.traffic_tacos.reservation.v1.ProcessCompensationResponse processCompensation(com.traffic_tacos.reservation.v1.ProcessCompensationRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getProcessCompensationMethod(), getCallOptions(), request);
    }

    /**
     * <pre>
     * Health check for worker instances
     * </pre>
     */
    public com.traffic_tacos.reservation.v1.HealthCheckResponse healthCheck(com.traffic_tacos.reservation.v1.HealthCheckRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getHealthCheckMethod(), getCallOptions(), request);
    }

    /**
     * <pre>
     * Get worker job status and metrics
     * </pre>
     */
    public com.traffic_tacos.reservation.v1.GetJobStatusResponse getJobStatus(com.traffic_tacos.reservation.v1.GetJobStatusRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getGetJobStatusMethod(), getCallOptions(), request);
    }
  }

  /**
   * A stub to allow clients to do ListenableFuture-style rpc calls to service WorkerService.
   * <pre>
   * Worker service for background event processing
   * Handles reservation expiry, payment result processing, and cleanup tasks
   * Runs as Kubernetes Job with KEDA auto-scaling based on SQS queue depth
   * </pre>
   */
  public static final class WorkerServiceFutureStub
      extends io.grpc.stub.AbstractFutureStub<WorkerServiceFutureStub> {
    private WorkerServiceFutureStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected WorkerServiceFutureStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new WorkerServiceFutureStub(channel, callOptions);
    }

    /**
     * <pre>
     * Process reservation expiry events (60-second hold timeout)
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.traffic_tacos.reservation.v1.ProcessReservationExpiryResponse> processReservationExpiry(
        com.traffic_tacos.reservation.v1.ProcessReservationExpiryRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getProcessReservationExpiryMethod(), getCallOptions()), request);
    }

    /**
     * <pre>
     * Process payment result events (approved/failed)
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.traffic_tacos.reservation.v1.ProcessPaymentResultResponse> processPaymentResult(
        com.traffic_tacos.reservation.v1.ProcessPaymentResultRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getProcessPaymentResultMethod(), getCallOptions()), request);
    }

    /**
     * <pre>
     * Process compensation/retry events for failed operations
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.traffic_tacos.reservation.v1.ProcessCompensationResponse> processCompensation(
        com.traffic_tacos.reservation.v1.ProcessCompensationRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getProcessCompensationMethod(), getCallOptions()), request);
    }

    /**
     * <pre>
     * Health check for worker instances
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.traffic_tacos.reservation.v1.HealthCheckResponse> healthCheck(
        com.traffic_tacos.reservation.v1.HealthCheckRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getHealthCheckMethod(), getCallOptions()), request);
    }

    /**
     * <pre>
     * Get worker job status and metrics
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.traffic_tacos.reservation.v1.GetJobStatusResponse> getJobStatus(
        com.traffic_tacos.reservation.v1.GetJobStatusRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getGetJobStatusMethod(), getCallOptions()), request);
    }
  }

  private static final int METHODID_PROCESS_RESERVATION_EXPIRY = 0;
  private static final int METHODID_PROCESS_PAYMENT_RESULT = 1;
  private static final int METHODID_PROCESS_COMPENSATION = 2;
  private static final int METHODID_HEALTH_CHECK = 3;
  private static final int METHODID_GET_JOB_STATUS = 4;

  private static final class MethodHandlers<Req, Resp> implements
      io.grpc.stub.ServerCalls.UnaryMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ServerStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ClientStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.BidiStreamingMethod<Req, Resp> {
    private final AsyncService serviceImpl;
    private final int methodId;

    MethodHandlers(AsyncService serviceImpl, int methodId) {
      this.serviceImpl = serviceImpl;
      this.methodId = methodId;
    }

    @java.lang.Override
    @java.lang.SuppressWarnings("unchecked")
    public void invoke(Req request, io.grpc.stub.StreamObserver<Resp> responseObserver) {
      switch (methodId) {
        case METHODID_PROCESS_RESERVATION_EXPIRY:
          serviceImpl.processReservationExpiry((com.traffic_tacos.reservation.v1.ProcessReservationExpiryRequest) request,
              (io.grpc.stub.StreamObserver<com.traffic_tacos.reservation.v1.ProcessReservationExpiryResponse>) responseObserver);
          break;
        case METHODID_PROCESS_PAYMENT_RESULT:
          serviceImpl.processPaymentResult((com.traffic_tacos.reservation.v1.ProcessPaymentResultRequest) request,
              (io.grpc.stub.StreamObserver<com.traffic_tacos.reservation.v1.ProcessPaymentResultResponse>) responseObserver);
          break;
        case METHODID_PROCESS_COMPENSATION:
          serviceImpl.processCompensation((com.traffic_tacos.reservation.v1.ProcessCompensationRequest) request,
              (io.grpc.stub.StreamObserver<com.traffic_tacos.reservation.v1.ProcessCompensationResponse>) responseObserver);
          break;
        case METHODID_HEALTH_CHECK:
          serviceImpl.healthCheck((com.traffic_tacos.reservation.v1.HealthCheckRequest) request,
              (io.grpc.stub.StreamObserver<com.traffic_tacos.reservation.v1.HealthCheckResponse>) responseObserver);
          break;
        case METHODID_GET_JOB_STATUS:
          serviceImpl.getJobStatus((com.traffic_tacos.reservation.v1.GetJobStatusRequest) request,
              (io.grpc.stub.StreamObserver<com.traffic_tacos.reservation.v1.GetJobStatusResponse>) responseObserver);
          break;
        default:
          throw new AssertionError();
      }
    }

    @java.lang.Override
    @java.lang.SuppressWarnings("unchecked")
    public io.grpc.stub.StreamObserver<Req> invoke(
        io.grpc.stub.StreamObserver<Resp> responseObserver) {
      switch (methodId) {
        default:
          throw new AssertionError();
      }
    }
  }

  public static final io.grpc.ServerServiceDefinition bindService(AsyncService service) {
    return io.grpc.ServerServiceDefinition.builder(getServiceDescriptor())
        .addMethod(
          getProcessReservationExpiryMethod(),
          io.grpc.stub.ServerCalls.asyncUnaryCall(
            new MethodHandlers<
              com.traffic_tacos.reservation.v1.ProcessReservationExpiryRequest,
              com.traffic_tacos.reservation.v1.ProcessReservationExpiryResponse>(
                service, METHODID_PROCESS_RESERVATION_EXPIRY)))
        .addMethod(
          getProcessPaymentResultMethod(),
          io.grpc.stub.ServerCalls.asyncUnaryCall(
            new MethodHandlers<
              com.traffic_tacos.reservation.v1.ProcessPaymentResultRequest,
              com.traffic_tacos.reservation.v1.ProcessPaymentResultResponse>(
                service, METHODID_PROCESS_PAYMENT_RESULT)))
        .addMethod(
          getProcessCompensationMethod(),
          io.grpc.stub.ServerCalls.asyncUnaryCall(
            new MethodHandlers<
              com.traffic_tacos.reservation.v1.ProcessCompensationRequest,
              com.traffic_tacos.reservation.v1.ProcessCompensationResponse>(
                service, METHODID_PROCESS_COMPENSATION)))
        .addMethod(
          getHealthCheckMethod(),
          io.grpc.stub.ServerCalls.asyncUnaryCall(
            new MethodHandlers<
              com.traffic_tacos.reservation.v1.HealthCheckRequest,
              com.traffic_tacos.reservation.v1.HealthCheckResponse>(
                service, METHODID_HEALTH_CHECK)))
        .addMethod(
          getGetJobStatusMethod(),
          io.grpc.stub.ServerCalls.asyncUnaryCall(
            new MethodHandlers<
              com.traffic_tacos.reservation.v1.GetJobStatusRequest,
              com.traffic_tacos.reservation.v1.GetJobStatusResponse>(
                service, METHODID_GET_JOB_STATUS)))
        .build();
  }

  private static abstract class WorkerServiceBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoFileDescriptorSupplier, io.grpc.protobuf.ProtoServiceDescriptorSupplier {
    WorkerServiceBaseDescriptorSupplier() {}

    @java.lang.Override
    public com.google.protobuf.Descriptors.FileDescriptor getFileDescriptor() {
      return com.traffic_tacos.reservation.v1.WorkerProto.getDescriptor();
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.ServiceDescriptor getServiceDescriptor() {
      return getFileDescriptor().findServiceByName("WorkerService");
    }
  }

  private static final class WorkerServiceFileDescriptorSupplier
      extends WorkerServiceBaseDescriptorSupplier {
    WorkerServiceFileDescriptorSupplier() {}
  }

  private static final class WorkerServiceMethodDescriptorSupplier
      extends WorkerServiceBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoMethodDescriptorSupplier {
    private final java.lang.String methodName;

    WorkerServiceMethodDescriptorSupplier(java.lang.String methodName) {
      this.methodName = methodName;
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.MethodDescriptor getMethodDescriptor() {
      return getServiceDescriptor().findMethodByName(methodName);
    }
  }

  private static volatile io.grpc.ServiceDescriptor serviceDescriptor;

  public static io.grpc.ServiceDescriptor getServiceDescriptor() {
    io.grpc.ServiceDescriptor result = serviceDescriptor;
    if (result == null) {
      synchronized (WorkerServiceGrpc.class) {
        result = serviceDescriptor;
        if (result == null) {
          serviceDescriptor = result = io.grpc.ServiceDescriptor.newBuilder(SERVICE_NAME)
              .setSchemaDescriptor(new WorkerServiceFileDescriptorSupplier())
              .addMethod(getProcessReservationExpiryMethod())
              .addMethod(getProcessPaymentResultMethod())
              .addMethod(getProcessCompensationMethod())
              .addMethod(getHealthCheckMethod())
              .addMethod(getGetJobStatusMethod())
              .build();
        }
      }
    }
    return result;
  }
}

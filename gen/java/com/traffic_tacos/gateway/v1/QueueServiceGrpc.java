package com.traffic_tacos.gateway.v1;

import static io.grpc.MethodDescriptor.generateFullMethodName;

/**
 * <pre>
 * Queue service manages admission control and traffic shaping
 * Handles 30k RPS ingress and controls admission to prevent system overload
 * </pre>
 */
@io.grpc.stub.annotations.GrpcGenerated
public final class QueueServiceGrpc {

  private QueueServiceGrpc() {}

  public static final java.lang.String SERVICE_NAME = "gateway.v1.QueueService";

  // Static method descriptors that strictly reflect the proto.
  private static volatile io.grpc.MethodDescriptor<com.traffic_tacos.gateway.v1.JoinQueueRequest,
      com.traffic_tacos.gateway.v1.JoinQueueResponse> getJoinQueueMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "JoinQueue",
      requestType = com.traffic_tacos.gateway.v1.JoinQueueRequest.class,
      responseType = com.traffic_tacos.gateway.v1.JoinQueueResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<com.traffic_tacos.gateway.v1.JoinQueueRequest,
      com.traffic_tacos.gateway.v1.JoinQueueResponse> getJoinQueueMethod() {
    io.grpc.MethodDescriptor<com.traffic_tacos.gateway.v1.JoinQueueRequest, com.traffic_tacos.gateway.v1.JoinQueueResponse> getJoinQueueMethod;
    if ((getJoinQueueMethod = QueueServiceGrpc.getJoinQueueMethod) == null) {
      synchronized (QueueServiceGrpc.class) {
        if ((getJoinQueueMethod = QueueServiceGrpc.getJoinQueueMethod) == null) {
          QueueServiceGrpc.getJoinQueueMethod = getJoinQueueMethod =
              io.grpc.MethodDescriptor.<com.traffic_tacos.gateway.v1.JoinQueueRequest, com.traffic_tacos.gateway.v1.JoinQueueResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "JoinQueue"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.traffic_tacos.gateway.v1.JoinQueueRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.traffic_tacos.gateway.v1.JoinQueueResponse.getDefaultInstance()))
              .setSchemaDescriptor(new QueueServiceMethodDescriptorSupplier("JoinQueue"))
              .build();
        }
      }
    }
    return getJoinQueueMethod;
  }

  private static volatile io.grpc.MethodDescriptor<com.traffic_tacos.gateway.v1.GetQueueStatusRequest,
      com.traffic_tacos.gateway.v1.GetQueueStatusResponse> getGetQueueStatusMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "GetQueueStatus",
      requestType = com.traffic_tacos.gateway.v1.GetQueueStatusRequest.class,
      responseType = com.traffic_tacos.gateway.v1.GetQueueStatusResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<com.traffic_tacos.gateway.v1.GetQueueStatusRequest,
      com.traffic_tacos.gateway.v1.GetQueueStatusResponse> getGetQueueStatusMethod() {
    io.grpc.MethodDescriptor<com.traffic_tacos.gateway.v1.GetQueueStatusRequest, com.traffic_tacos.gateway.v1.GetQueueStatusResponse> getGetQueueStatusMethod;
    if ((getGetQueueStatusMethod = QueueServiceGrpc.getGetQueueStatusMethod) == null) {
      synchronized (QueueServiceGrpc.class) {
        if ((getGetQueueStatusMethod = QueueServiceGrpc.getGetQueueStatusMethod) == null) {
          QueueServiceGrpc.getGetQueueStatusMethod = getGetQueueStatusMethod =
              io.grpc.MethodDescriptor.<com.traffic_tacos.gateway.v1.GetQueueStatusRequest, com.traffic_tacos.gateway.v1.GetQueueStatusResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "GetQueueStatus"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.traffic_tacos.gateway.v1.GetQueueStatusRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.traffic_tacos.gateway.v1.GetQueueStatusResponse.getDefaultInstance()))
              .setSchemaDescriptor(new QueueServiceMethodDescriptorSupplier("GetQueueStatus"))
              .build();
        }
      }
    }
    return getGetQueueStatusMethod;
  }

  private static volatile io.grpc.MethodDescriptor<com.traffic_tacos.gateway.v1.RequestAdmissionRequest,
      com.traffic_tacos.gateway.v1.RequestAdmissionResponse> getRequestAdmissionMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "RequestAdmission",
      requestType = com.traffic_tacos.gateway.v1.RequestAdmissionRequest.class,
      responseType = com.traffic_tacos.gateway.v1.RequestAdmissionResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<com.traffic_tacos.gateway.v1.RequestAdmissionRequest,
      com.traffic_tacos.gateway.v1.RequestAdmissionResponse> getRequestAdmissionMethod() {
    io.grpc.MethodDescriptor<com.traffic_tacos.gateway.v1.RequestAdmissionRequest, com.traffic_tacos.gateway.v1.RequestAdmissionResponse> getRequestAdmissionMethod;
    if ((getRequestAdmissionMethod = QueueServiceGrpc.getRequestAdmissionMethod) == null) {
      synchronized (QueueServiceGrpc.class) {
        if ((getRequestAdmissionMethod = QueueServiceGrpc.getRequestAdmissionMethod) == null) {
          QueueServiceGrpc.getRequestAdmissionMethod = getRequestAdmissionMethod =
              io.grpc.MethodDescriptor.<com.traffic_tacos.gateway.v1.RequestAdmissionRequest, com.traffic_tacos.gateway.v1.RequestAdmissionResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "RequestAdmission"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.traffic_tacos.gateway.v1.RequestAdmissionRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.traffic_tacos.gateway.v1.RequestAdmissionResponse.getDefaultInstance()))
              .setSchemaDescriptor(new QueueServiceMethodDescriptorSupplier("RequestAdmission"))
              .build();
        }
      }
    }
    return getRequestAdmissionMethod;
  }

  private static volatile io.grpc.MethodDescriptor<com.traffic_tacos.gateway.v1.LeaveQueueRequest,
      com.traffic_tacos.gateway.v1.LeaveQueueResponse> getLeaveQueueMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "LeaveQueue",
      requestType = com.traffic_tacos.gateway.v1.LeaveQueueRequest.class,
      responseType = com.traffic_tacos.gateway.v1.LeaveQueueResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<com.traffic_tacos.gateway.v1.LeaveQueueRequest,
      com.traffic_tacos.gateway.v1.LeaveQueueResponse> getLeaveQueueMethod() {
    io.grpc.MethodDescriptor<com.traffic_tacos.gateway.v1.LeaveQueueRequest, com.traffic_tacos.gateway.v1.LeaveQueueResponse> getLeaveQueueMethod;
    if ((getLeaveQueueMethod = QueueServiceGrpc.getLeaveQueueMethod) == null) {
      synchronized (QueueServiceGrpc.class) {
        if ((getLeaveQueueMethod = QueueServiceGrpc.getLeaveQueueMethod) == null) {
          QueueServiceGrpc.getLeaveQueueMethod = getLeaveQueueMethod =
              io.grpc.MethodDescriptor.<com.traffic_tacos.gateway.v1.LeaveQueueRequest, com.traffic_tacos.gateway.v1.LeaveQueueResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "LeaveQueue"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.traffic_tacos.gateway.v1.LeaveQueueRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.traffic_tacos.gateway.v1.LeaveQueueResponse.getDefaultInstance()))
              .setSchemaDescriptor(new QueueServiceMethodDescriptorSupplier("LeaveQueue"))
              .build();
        }
      }
    }
    return getLeaveQueueMethod;
  }

  private static volatile io.grpc.MethodDescriptor<com.traffic_tacos.gateway.v1.GetQueueStatsRequest,
      com.traffic_tacos.gateway.v1.GetQueueStatsResponse> getGetQueueStatsMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "GetQueueStats",
      requestType = com.traffic_tacos.gateway.v1.GetQueueStatsRequest.class,
      responseType = com.traffic_tacos.gateway.v1.GetQueueStatsResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<com.traffic_tacos.gateway.v1.GetQueueStatsRequest,
      com.traffic_tacos.gateway.v1.GetQueueStatsResponse> getGetQueueStatsMethod() {
    io.grpc.MethodDescriptor<com.traffic_tacos.gateway.v1.GetQueueStatsRequest, com.traffic_tacos.gateway.v1.GetQueueStatsResponse> getGetQueueStatsMethod;
    if ((getGetQueueStatsMethod = QueueServiceGrpc.getGetQueueStatsMethod) == null) {
      synchronized (QueueServiceGrpc.class) {
        if ((getGetQueueStatsMethod = QueueServiceGrpc.getGetQueueStatsMethod) == null) {
          QueueServiceGrpc.getGetQueueStatsMethod = getGetQueueStatsMethod =
              io.grpc.MethodDescriptor.<com.traffic_tacos.gateway.v1.GetQueueStatsRequest, com.traffic_tacos.gateway.v1.GetQueueStatsResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "GetQueueStats"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.traffic_tacos.gateway.v1.GetQueueStatsRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.traffic_tacos.gateway.v1.GetQueueStatsResponse.getDefaultInstance()))
              .setSchemaDescriptor(new QueueServiceMethodDescriptorSupplier("GetQueueStats"))
              .build();
        }
      }
    }
    return getGetQueueStatsMethod;
  }

  /**
   * Creates a new async stub that supports all call types for the service
   */
  public static QueueServiceStub newStub(io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<QueueServiceStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<QueueServiceStub>() {
        @java.lang.Override
        public QueueServiceStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new QueueServiceStub(channel, callOptions);
        }
      };
    return QueueServiceStub.newStub(factory, channel);
  }

  /**
   * Creates a new blocking-style stub that supports all types of calls on the service
   */
  public static QueueServiceBlockingV2Stub newBlockingV2Stub(
      io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<QueueServiceBlockingV2Stub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<QueueServiceBlockingV2Stub>() {
        @java.lang.Override
        public QueueServiceBlockingV2Stub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new QueueServiceBlockingV2Stub(channel, callOptions);
        }
      };
    return QueueServiceBlockingV2Stub.newStub(factory, channel);
  }

  /**
   * Creates a new blocking-style stub that supports unary and streaming output calls on the service
   */
  public static QueueServiceBlockingStub newBlockingStub(
      io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<QueueServiceBlockingStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<QueueServiceBlockingStub>() {
        @java.lang.Override
        public QueueServiceBlockingStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new QueueServiceBlockingStub(channel, callOptions);
        }
      };
    return QueueServiceBlockingStub.newStub(factory, channel);
  }

  /**
   * Creates a new ListenableFuture-style stub that supports unary calls on the service
   */
  public static QueueServiceFutureStub newFutureStub(
      io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<QueueServiceFutureStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<QueueServiceFutureStub>() {
        @java.lang.Override
        public QueueServiceFutureStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new QueueServiceFutureStub(channel, callOptions);
        }
      };
    return QueueServiceFutureStub.newStub(factory, channel);
  }

  /**
   * <pre>
   * Queue service manages admission control and traffic shaping
   * Handles 30k RPS ingress and controls admission to prevent system overload
   * </pre>
   */
  public interface AsyncService {

    /**
     * <pre>
     * Join the waiting queue for an event
     * </pre>
     */
    default void joinQueue(com.traffic_tacos.gateway.v1.JoinQueueRequest request,
        io.grpc.stub.StreamObserver<com.traffic_tacos.gateway.v1.JoinQueueResponse> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getJoinQueueMethod(), responseObserver);
    }

    /**
     * <pre>
     * Check queue status and position
     * </pre>
     */
    default void getQueueStatus(com.traffic_tacos.gateway.v1.GetQueueStatusRequest request,
        io.grpc.stub.StreamObserver<com.traffic_tacos.gateway.v1.GetQueueStatusResponse> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getGetQueueStatusMethod(), responseObserver);
    }

    /**
     * <pre>
     * Request admission from waiting queue to reservation system
     * </pre>
     */
    default void requestAdmission(com.traffic_tacos.gateway.v1.RequestAdmissionRequest request,
        io.grpc.stub.StreamObserver<com.traffic_tacos.gateway.v1.RequestAdmissionResponse> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getRequestAdmissionMethod(), responseObserver);
    }

    /**
     * <pre>
     * Leave the queue voluntarily
     * </pre>
     */
    default void leaveQueue(com.traffic_tacos.gateway.v1.LeaveQueueRequest request,
        io.grpc.stub.StreamObserver<com.traffic_tacos.gateway.v1.LeaveQueueResponse> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getLeaveQueueMethod(), responseObserver);
    }

    /**
     * <pre>
     * Get queue statistics (for monitoring)
     * </pre>
     */
    default void getQueueStats(com.traffic_tacos.gateway.v1.GetQueueStatsRequest request,
        io.grpc.stub.StreamObserver<com.traffic_tacos.gateway.v1.GetQueueStatsResponse> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getGetQueueStatsMethod(), responseObserver);
    }
  }

  /**
   * Base class for the server implementation of the service QueueService.
   * <pre>
   * Queue service manages admission control and traffic shaping
   * Handles 30k RPS ingress and controls admission to prevent system overload
   * </pre>
   */
  public static abstract class QueueServiceImplBase
      implements io.grpc.BindableService, AsyncService {

    @java.lang.Override public final io.grpc.ServerServiceDefinition bindService() {
      return QueueServiceGrpc.bindService(this);
    }
  }

  /**
   * A stub to allow clients to do asynchronous rpc calls to service QueueService.
   * <pre>
   * Queue service manages admission control and traffic shaping
   * Handles 30k RPS ingress and controls admission to prevent system overload
   * </pre>
   */
  public static final class QueueServiceStub
      extends io.grpc.stub.AbstractAsyncStub<QueueServiceStub> {
    private QueueServiceStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected QueueServiceStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new QueueServiceStub(channel, callOptions);
    }

    /**
     * <pre>
     * Join the waiting queue for an event
     * </pre>
     */
    public void joinQueue(com.traffic_tacos.gateway.v1.JoinQueueRequest request,
        io.grpc.stub.StreamObserver<com.traffic_tacos.gateway.v1.JoinQueueResponse> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getJoinQueueMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     * <pre>
     * Check queue status and position
     * </pre>
     */
    public void getQueueStatus(com.traffic_tacos.gateway.v1.GetQueueStatusRequest request,
        io.grpc.stub.StreamObserver<com.traffic_tacos.gateway.v1.GetQueueStatusResponse> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getGetQueueStatusMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     * <pre>
     * Request admission from waiting queue to reservation system
     * </pre>
     */
    public void requestAdmission(com.traffic_tacos.gateway.v1.RequestAdmissionRequest request,
        io.grpc.stub.StreamObserver<com.traffic_tacos.gateway.v1.RequestAdmissionResponse> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getRequestAdmissionMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     * <pre>
     * Leave the queue voluntarily
     * </pre>
     */
    public void leaveQueue(com.traffic_tacos.gateway.v1.LeaveQueueRequest request,
        io.grpc.stub.StreamObserver<com.traffic_tacos.gateway.v1.LeaveQueueResponse> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getLeaveQueueMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     * <pre>
     * Get queue statistics (for monitoring)
     * </pre>
     */
    public void getQueueStats(com.traffic_tacos.gateway.v1.GetQueueStatsRequest request,
        io.grpc.stub.StreamObserver<com.traffic_tacos.gateway.v1.GetQueueStatsResponse> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getGetQueueStatsMethod(), getCallOptions()), request, responseObserver);
    }
  }

  /**
   * A stub to allow clients to do synchronous rpc calls to service QueueService.
   * <pre>
   * Queue service manages admission control and traffic shaping
   * Handles 30k RPS ingress and controls admission to prevent system overload
   * </pre>
   */
  public static final class QueueServiceBlockingV2Stub
      extends io.grpc.stub.AbstractBlockingStub<QueueServiceBlockingV2Stub> {
    private QueueServiceBlockingV2Stub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected QueueServiceBlockingV2Stub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new QueueServiceBlockingV2Stub(channel, callOptions);
    }

    /**
     * <pre>
     * Join the waiting queue for an event
     * </pre>
     */
    public com.traffic_tacos.gateway.v1.JoinQueueResponse joinQueue(com.traffic_tacos.gateway.v1.JoinQueueRequest request) throws io.grpc.StatusException {
      return io.grpc.stub.ClientCalls.blockingV2UnaryCall(
          getChannel(), getJoinQueueMethod(), getCallOptions(), request);
    }

    /**
     * <pre>
     * Check queue status and position
     * </pre>
     */
    public com.traffic_tacos.gateway.v1.GetQueueStatusResponse getQueueStatus(com.traffic_tacos.gateway.v1.GetQueueStatusRequest request) throws io.grpc.StatusException {
      return io.grpc.stub.ClientCalls.blockingV2UnaryCall(
          getChannel(), getGetQueueStatusMethod(), getCallOptions(), request);
    }

    /**
     * <pre>
     * Request admission from waiting queue to reservation system
     * </pre>
     */
    public com.traffic_tacos.gateway.v1.RequestAdmissionResponse requestAdmission(com.traffic_tacos.gateway.v1.RequestAdmissionRequest request) throws io.grpc.StatusException {
      return io.grpc.stub.ClientCalls.blockingV2UnaryCall(
          getChannel(), getRequestAdmissionMethod(), getCallOptions(), request);
    }

    /**
     * <pre>
     * Leave the queue voluntarily
     * </pre>
     */
    public com.traffic_tacos.gateway.v1.LeaveQueueResponse leaveQueue(com.traffic_tacos.gateway.v1.LeaveQueueRequest request) throws io.grpc.StatusException {
      return io.grpc.stub.ClientCalls.blockingV2UnaryCall(
          getChannel(), getLeaveQueueMethod(), getCallOptions(), request);
    }

    /**
     * <pre>
     * Get queue statistics (for monitoring)
     * </pre>
     */
    public com.traffic_tacos.gateway.v1.GetQueueStatsResponse getQueueStats(com.traffic_tacos.gateway.v1.GetQueueStatsRequest request) throws io.grpc.StatusException {
      return io.grpc.stub.ClientCalls.blockingV2UnaryCall(
          getChannel(), getGetQueueStatsMethod(), getCallOptions(), request);
    }
  }

  /**
   * A stub to allow clients to do limited synchronous rpc calls to service QueueService.
   * <pre>
   * Queue service manages admission control and traffic shaping
   * Handles 30k RPS ingress and controls admission to prevent system overload
   * </pre>
   */
  public static final class QueueServiceBlockingStub
      extends io.grpc.stub.AbstractBlockingStub<QueueServiceBlockingStub> {
    private QueueServiceBlockingStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected QueueServiceBlockingStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new QueueServiceBlockingStub(channel, callOptions);
    }

    /**
     * <pre>
     * Join the waiting queue for an event
     * </pre>
     */
    public com.traffic_tacos.gateway.v1.JoinQueueResponse joinQueue(com.traffic_tacos.gateway.v1.JoinQueueRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getJoinQueueMethod(), getCallOptions(), request);
    }

    /**
     * <pre>
     * Check queue status and position
     * </pre>
     */
    public com.traffic_tacos.gateway.v1.GetQueueStatusResponse getQueueStatus(com.traffic_tacos.gateway.v1.GetQueueStatusRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getGetQueueStatusMethod(), getCallOptions(), request);
    }

    /**
     * <pre>
     * Request admission from waiting queue to reservation system
     * </pre>
     */
    public com.traffic_tacos.gateway.v1.RequestAdmissionResponse requestAdmission(com.traffic_tacos.gateway.v1.RequestAdmissionRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getRequestAdmissionMethod(), getCallOptions(), request);
    }

    /**
     * <pre>
     * Leave the queue voluntarily
     * </pre>
     */
    public com.traffic_tacos.gateway.v1.LeaveQueueResponse leaveQueue(com.traffic_tacos.gateway.v1.LeaveQueueRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getLeaveQueueMethod(), getCallOptions(), request);
    }

    /**
     * <pre>
     * Get queue statistics (for monitoring)
     * </pre>
     */
    public com.traffic_tacos.gateway.v1.GetQueueStatsResponse getQueueStats(com.traffic_tacos.gateway.v1.GetQueueStatsRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getGetQueueStatsMethod(), getCallOptions(), request);
    }
  }

  /**
   * A stub to allow clients to do ListenableFuture-style rpc calls to service QueueService.
   * <pre>
   * Queue service manages admission control and traffic shaping
   * Handles 30k RPS ingress and controls admission to prevent system overload
   * </pre>
   */
  public static final class QueueServiceFutureStub
      extends io.grpc.stub.AbstractFutureStub<QueueServiceFutureStub> {
    private QueueServiceFutureStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected QueueServiceFutureStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new QueueServiceFutureStub(channel, callOptions);
    }

    /**
     * <pre>
     * Join the waiting queue for an event
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.traffic_tacos.gateway.v1.JoinQueueResponse> joinQueue(
        com.traffic_tacos.gateway.v1.JoinQueueRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getJoinQueueMethod(), getCallOptions()), request);
    }

    /**
     * <pre>
     * Check queue status and position
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.traffic_tacos.gateway.v1.GetQueueStatusResponse> getQueueStatus(
        com.traffic_tacos.gateway.v1.GetQueueStatusRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getGetQueueStatusMethod(), getCallOptions()), request);
    }

    /**
     * <pre>
     * Request admission from waiting queue to reservation system
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.traffic_tacos.gateway.v1.RequestAdmissionResponse> requestAdmission(
        com.traffic_tacos.gateway.v1.RequestAdmissionRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getRequestAdmissionMethod(), getCallOptions()), request);
    }

    /**
     * <pre>
     * Leave the queue voluntarily
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.traffic_tacos.gateway.v1.LeaveQueueResponse> leaveQueue(
        com.traffic_tacos.gateway.v1.LeaveQueueRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getLeaveQueueMethod(), getCallOptions()), request);
    }

    /**
     * <pre>
     * Get queue statistics (for monitoring)
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.traffic_tacos.gateway.v1.GetQueueStatsResponse> getQueueStats(
        com.traffic_tacos.gateway.v1.GetQueueStatsRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getGetQueueStatsMethod(), getCallOptions()), request);
    }
  }

  private static final int METHODID_JOIN_QUEUE = 0;
  private static final int METHODID_GET_QUEUE_STATUS = 1;
  private static final int METHODID_REQUEST_ADMISSION = 2;
  private static final int METHODID_LEAVE_QUEUE = 3;
  private static final int METHODID_GET_QUEUE_STATS = 4;

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
        case METHODID_JOIN_QUEUE:
          serviceImpl.joinQueue((com.traffic_tacos.gateway.v1.JoinQueueRequest) request,
              (io.grpc.stub.StreamObserver<com.traffic_tacos.gateway.v1.JoinQueueResponse>) responseObserver);
          break;
        case METHODID_GET_QUEUE_STATUS:
          serviceImpl.getQueueStatus((com.traffic_tacos.gateway.v1.GetQueueStatusRequest) request,
              (io.grpc.stub.StreamObserver<com.traffic_tacos.gateway.v1.GetQueueStatusResponse>) responseObserver);
          break;
        case METHODID_REQUEST_ADMISSION:
          serviceImpl.requestAdmission((com.traffic_tacos.gateway.v1.RequestAdmissionRequest) request,
              (io.grpc.stub.StreamObserver<com.traffic_tacos.gateway.v1.RequestAdmissionResponse>) responseObserver);
          break;
        case METHODID_LEAVE_QUEUE:
          serviceImpl.leaveQueue((com.traffic_tacos.gateway.v1.LeaveQueueRequest) request,
              (io.grpc.stub.StreamObserver<com.traffic_tacos.gateway.v1.LeaveQueueResponse>) responseObserver);
          break;
        case METHODID_GET_QUEUE_STATS:
          serviceImpl.getQueueStats((com.traffic_tacos.gateway.v1.GetQueueStatsRequest) request,
              (io.grpc.stub.StreamObserver<com.traffic_tacos.gateway.v1.GetQueueStatsResponse>) responseObserver);
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
          getJoinQueueMethod(),
          io.grpc.stub.ServerCalls.asyncUnaryCall(
            new MethodHandlers<
              com.traffic_tacos.gateway.v1.JoinQueueRequest,
              com.traffic_tacos.gateway.v1.JoinQueueResponse>(
                service, METHODID_JOIN_QUEUE)))
        .addMethod(
          getGetQueueStatusMethod(),
          io.grpc.stub.ServerCalls.asyncUnaryCall(
            new MethodHandlers<
              com.traffic_tacos.gateway.v1.GetQueueStatusRequest,
              com.traffic_tacos.gateway.v1.GetQueueStatusResponse>(
                service, METHODID_GET_QUEUE_STATUS)))
        .addMethod(
          getRequestAdmissionMethod(),
          io.grpc.stub.ServerCalls.asyncUnaryCall(
            new MethodHandlers<
              com.traffic_tacos.gateway.v1.RequestAdmissionRequest,
              com.traffic_tacos.gateway.v1.RequestAdmissionResponse>(
                service, METHODID_REQUEST_ADMISSION)))
        .addMethod(
          getLeaveQueueMethod(),
          io.grpc.stub.ServerCalls.asyncUnaryCall(
            new MethodHandlers<
              com.traffic_tacos.gateway.v1.LeaveQueueRequest,
              com.traffic_tacos.gateway.v1.LeaveQueueResponse>(
                service, METHODID_LEAVE_QUEUE)))
        .addMethod(
          getGetQueueStatsMethod(),
          io.grpc.stub.ServerCalls.asyncUnaryCall(
            new MethodHandlers<
              com.traffic_tacos.gateway.v1.GetQueueStatsRequest,
              com.traffic_tacos.gateway.v1.GetQueueStatsResponse>(
                service, METHODID_GET_QUEUE_STATS)))
        .build();
  }

  private static abstract class QueueServiceBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoFileDescriptorSupplier, io.grpc.protobuf.ProtoServiceDescriptorSupplier {
    QueueServiceBaseDescriptorSupplier() {}

    @java.lang.Override
    public com.google.protobuf.Descriptors.FileDescriptor getFileDescriptor() {
      return com.traffic_tacos.gateway.v1.QueueProto.getDescriptor();
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.ServiceDescriptor getServiceDescriptor() {
      return getFileDescriptor().findServiceByName("QueueService");
    }
  }

  private static final class QueueServiceFileDescriptorSupplier
      extends QueueServiceBaseDescriptorSupplier {
    QueueServiceFileDescriptorSupplier() {}
  }

  private static final class QueueServiceMethodDescriptorSupplier
      extends QueueServiceBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoMethodDescriptorSupplier {
    private final java.lang.String methodName;

    QueueServiceMethodDescriptorSupplier(java.lang.String methodName) {
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
      synchronized (QueueServiceGrpc.class) {
        result = serviceDescriptor;
        if (result == null) {
          serviceDescriptor = result = io.grpc.ServiceDescriptor.newBuilder(SERVICE_NAME)
              .setSchemaDescriptor(new QueueServiceFileDescriptorSupplier())
              .addMethod(getJoinQueueMethod())
              .addMethod(getGetQueueStatusMethod())
              .addMethod(getRequestAdmissionMethod())
              .addMethod(getLeaveQueueMethod())
              .addMethod(getGetQueueStatsMethod())
              .build();
        }
      }
    }
    return result;
  }
}

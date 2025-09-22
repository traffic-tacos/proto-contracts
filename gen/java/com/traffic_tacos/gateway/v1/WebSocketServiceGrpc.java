package com.traffic_tacos.gateway.v1;

import static io.grpc.MethodDescriptor.generateFullMethodName;

/**
 * <pre>
 * WebSocket service for real-time updates
 * Handles queue position updates, reservation status changes, payment updates
 * </pre>
 */
@io.grpc.stub.annotations.GrpcGenerated
public final class WebSocketServiceGrpc {

  private WebSocketServiceGrpc() {}

  public static final java.lang.String SERVICE_NAME = "gateway.v1.WebSocketService";

  // Static method descriptors that strictly reflect the proto.
  private static volatile io.grpc.MethodDescriptor<com.traffic_tacos.gateway.v1.StreamQueueUpdatesRequest,
      com.traffic_tacos.gateway.v1.StreamQueueUpdatesResponse> getStreamQueueUpdatesMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "StreamQueueUpdates",
      requestType = com.traffic_tacos.gateway.v1.StreamQueueUpdatesRequest.class,
      responseType = com.traffic_tacos.gateway.v1.StreamQueueUpdatesResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.SERVER_STREAMING)
  public static io.grpc.MethodDescriptor<com.traffic_tacos.gateway.v1.StreamQueueUpdatesRequest,
      com.traffic_tacos.gateway.v1.StreamQueueUpdatesResponse> getStreamQueueUpdatesMethod() {
    io.grpc.MethodDescriptor<com.traffic_tacos.gateway.v1.StreamQueueUpdatesRequest, com.traffic_tacos.gateway.v1.StreamQueueUpdatesResponse> getStreamQueueUpdatesMethod;
    if ((getStreamQueueUpdatesMethod = WebSocketServiceGrpc.getStreamQueueUpdatesMethod) == null) {
      synchronized (WebSocketServiceGrpc.class) {
        if ((getStreamQueueUpdatesMethod = WebSocketServiceGrpc.getStreamQueueUpdatesMethod) == null) {
          WebSocketServiceGrpc.getStreamQueueUpdatesMethod = getStreamQueueUpdatesMethod =
              io.grpc.MethodDescriptor.<com.traffic_tacos.gateway.v1.StreamQueueUpdatesRequest, com.traffic_tacos.gateway.v1.StreamQueueUpdatesResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.SERVER_STREAMING)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "StreamQueueUpdates"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.traffic_tacos.gateway.v1.StreamQueueUpdatesRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.traffic_tacos.gateway.v1.StreamQueueUpdatesResponse.getDefaultInstance()))
              .setSchemaDescriptor(new WebSocketServiceMethodDescriptorSupplier("StreamQueueUpdates"))
              .build();
        }
      }
    }
    return getStreamQueueUpdatesMethod;
  }

  private static volatile io.grpc.MethodDescriptor<com.traffic_tacos.gateway.v1.StreamReservationUpdatesRequest,
      com.traffic_tacos.gateway.v1.StreamReservationUpdatesResponse> getStreamReservationUpdatesMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "StreamReservationUpdates",
      requestType = com.traffic_tacos.gateway.v1.StreamReservationUpdatesRequest.class,
      responseType = com.traffic_tacos.gateway.v1.StreamReservationUpdatesResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.SERVER_STREAMING)
  public static io.grpc.MethodDescriptor<com.traffic_tacos.gateway.v1.StreamReservationUpdatesRequest,
      com.traffic_tacos.gateway.v1.StreamReservationUpdatesResponse> getStreamReservationUpdatesMethod() {
    io.grpc.MethodDescriptor<com.traffic_tacos.gateway.v1.StreamReservationUpdatesRequest, com.traffic_tacos.gateway.v1.StreamReservationUpdatesResponse> getStreamReservationUpdatesMethod;
    if ((getStreamReservationUpdatesMethod = WebSocketServiceGrpc.getStreamReservationUpdatesMethod) == null) {
      synchronized (WebSocketServiceGrpc.class) {
        if ((getStreamReservationUpdatesMethod = WebSocketServiceGrpc.getStreamReservationUpdatesMethod) == null) {
          WebSocketServiceGrpc.getStreamReservationUpdatesMethod = getStreamReservationUpdatesMethod =
              io.grpc.MethodDescriptor.<com.traffic_tacos.gateway.v1.StreamReservationUpdatesRequest, com.traffic_tacos.gateway.v1.StreamReservationUpdatesResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.SERVER_STREAMING)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "StreamReservationUpdates"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.traffic_tacos.gateway.v1.StreamReservationUpdatesRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.traffic_tacos.gateway.v1.StreamReservationUpdatesResponse.getDefaultInstance()))
              .setSchemaDescriptor(new WebSocketServiceMethodDescriptorSupplier("StreamReservationUpdates"))
              .build();
        }
      }
    }
    return getStreamReservationUpdatesMethod;
  }

  private static volatile io.grpc.MethodDescriptor<com.traffic_tacos.gateway.v1.StreamPaymentUpdatesRequest,
      com.traffic_tacos.gateway.v1.StreamPaymentUpdatesResponse> getStreamPaymentUpdatesMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "StreamPaymentUpdates",
      requestType = com.traffic_tacos.gateway.v1.StreamPaymentUpdatesRequest.class,
      responseType = com.traffic_tacos.gateway.v1.StreamPaymentUpdatesResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.SERVER_STREAMING)
  public static io.grpc.MethodDescriptor<com.traffic_tacos.gateway.v1.StreamPaymentUpdatesRequest,
      com.traffic_tacos.gateway.v1.StreamPaymentUpdatesResponse> getStreamPaymentUpdatesMethod() {
    io.grpc.MethodDescriptor<com.traffic_tacos.gateway.v1.StreamPaymentUpdatesRequest, com.traffic_tacos.gateway.v1.StreamPaymentUpdatesResponse> getStreamPaymentUpdatesMethod;
    if ((getStreamPaymentUpdatesMethod = WebSocketServiceGrpc.getStreamPaymentUpdatesMethod) == null) {
      synchronized (WebSocketServiceGrpc.class) {
        if ((getStreamPaymentUpdatesMethod = WebSocketServiceGrpc.getStreamPaymentUpdatesMethod) == null) {
          WebSocketServiceGrpc.getStreamPaymentUpdatesMethod = getStreamPaymentUpdatesMethod =
              io.grpc.MethodDescriptor.<com.traffic_tacos.gateway.v1.StreamPaymentUpdatesRequest, com.traffic_tacos.gateway.v1.StreamPaymentUpdatesResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.SERVER_STREAMING)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "StreamPaymentUpdates"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.traffic_tacos.gateway.v1.StreamPaymentUpdatesRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.traffic_tacos.gateway.v1.StreamPaymentUpdatesResponse.getDefaultInstance()))
              .setSchemaDescriptor(new WebSocketServiceMethodDescriptorSupplier("StreamPaymentUpdates"))
              .build();
        }
      }
    }
    return getStreamPaymentUpdatesMethod;
  }

  private static volatile io.grpc.MethodDescriptor<com.traffic_tacos.gateway.v1.SendMessageRequest,
      com.traffic_tacos.gateway.v1.SendMessageResponse> getSendMessageMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "SendMessage",
      requestType = com.traffic_tacos.gateway.v1.SendMessageRequest.class,
      responseType = com.traffic_tacos.gateway.v1.SendMessageResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<com.traffic_tacos.gateway.v1.SendMessageRequest,
      com.traffic_tacos.gateway.v1.SendMessageResponse> getSendMessageMethod() {
    io.grpc.MethodDescriptor<com.traffic_tacos.gateway.v1.SendMessageRequest, com.traffic_tacos.gateway.v1.SendMessageResponse> getSendMessageMethod;
    if ((getSendMessageMethod = WebSocketServiceGrpc.getSendMessageMethod) == null) {
      synchronized (WebSocketServiceGrpc.class) {
        if ((getSendMessageMethod = WebSocketServiceGrpc.getSendMessageMethod) == null) {
          WebSocketServiceGrpc.getSendMessageMethod = getSendMessageMethod =
              io.grpc.MethodDescriptor.<com.traffic_tacos.gateway.v1.SendMessageRequest, com.traffic_tacos.gateway.v1.SendMessageResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "SendMessage"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.traffic_tacos.gateway.v1.SendMessageRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.traffic_tacos.gateway.v1.SendMessageResponse.getDefaultInstance()))
              .setSchemaDescriptor(new WebSocketServiceMethodDescriptorSupplier("SendMessage"))
              .build();
        }
      }
    }
    return getSendMessageMethod;
  }

  /**
   * Creates a new async stub that supports all call types for the service
   */
  public static WebSocketServiceStub newStub(io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<WebSocketServiceStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<WebSocketServiceStub>() {
        @java.lang.Override
        public WebSocketServiceStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new WebSocketServiceStub(channel, callOptions);
        }
      };
    return WebSocketServiceStub.newStub(factory, channel);
  }

  /**
   * Creates a new blocking-style stub that supports all types of calls on the service
   */
  public static WebSocketServiceBlockingV2Stub newBlockingV2Stub(
      io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<WebSocketServiceBlockingV2Stub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<WebSocketServiceBlockingV2Stub>() {
        @java.lang.Override
        public WebSocketServiceBlockingV2Stub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new WebSocketServiceBlockingV2Stub(channel, callOptions);
        }
      };
    return WebSocketServiceBlockingV2Stub.newStub(factory, channel);
  }

  /**
   * Creates a new blocking-style stub that supports unary and streaming output calls on the service
   */
  public static WebSocketServiceBlockingStub newBlockingStub(
      io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<WebSocketServiceBlockingStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<WebSocketServiceBlockingStub>() {
        @java.lang.Override
        public WebSocketServiceBlockingStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new WebSocketServiceBlockingStub(channel, callOptions);
        }
      };
    return WebSocketServiceBlockingStub.newStub(factory, channel);
  }

  /**
   * Creates a new ListenableFuture-style stub that supports unary calls on the service
   */
  public static WebSocketServiceFutureStub newFutureStub(
      io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<WebSocketServiceFutureStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<WebSocketServiceFutureStub>() {
        @java.lang.Override
        public WebSocketServiceFutureStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new WebSocketServiceFutureStub(channel, callOptions);
        }
      };
    return WebSocketServiceFutureStub.newStub(factory, channel);
  }

  /**
   * <pre>
   * WebSocket service for real-time updates
   * Handles queue position updates, reservation status changes, payment updates
   * </pre>
   */
  public interface AsyncService {

    /**
     * <pre>
     * Establish real-time connection for queue updates
     * </pre>
     */
    default void streamQueueUpdates(com.traffic_tacos.gateway.v1.StreamQueueUpdatesRequest request,
        io.grpc.stub.StreamObserver<com.traffic_tacos.gateway.v1.StreamQueueUpdatesResponse> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getStreamQueueUpdatesMethod(), responseObserver);
    }

    /**
     * <pre>
     * Establish real-time connection for reservation updates
     * </pre>
     */
    default void streamReservationUpdates(com.traffic_tacos.gateway.v1.StreamReservationUpdatesRequest request,
        io.grpc.stub.StreamObserver<com.traffic_tacos.gateway.v1.StreamReservationUpdatesResponse> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getStreamReservationUpdatesMethod(), responseObserver);
    }

    /**
     * <pre>
     * Establish real-time connection for payment updates
     * </pre>
     */
    default void streamPaymentUpdates(com.traffic_tacos.gateway.v1.StreamPaymentUpdatesRequest request,
        io.grpc.stub.StreamObserver<com.traffic_tacos.gateway.v1.StreamPaymentUpdatesResponse> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getStreamPaymentUpdatesMethod(), responseObserver);
    }

    /**
     * <pre>
     * Send a message to a specific user/session
     * </pre>
     */
    default void sendMessage(com.traffic_tacos.gateway.v1.SendMessageRequest request,
        io.grpc.stub.StreamObserver<com.traffic_tacos.gateway.v1.SendMessageResponse> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getSendMessageMethod(), responseObserver);
    }
  }

  /**
   * Base class for the server implementation of the service WebSocketService.
   * <pre>
   * WebSocket service for real-time updates
   * Handles queue position updates, reservation status changes, payment updates
   * </pre>
   */
  public static abstract class WebSocketServiceImplBase
      implements io.grpc.BindableService, AsyncService {

    @java.lang.Override public final io.grpc.ServerServiceDefinition bindService() {
      return WebSocketServiceGrpc.bindService(this);
    }
  }

  /**
   * A stub to allow clients to do asynchronous rpc calls to service WebSocketService.
   * <pre>
   * WebSocket service for real-time updates
   * Handles queue position updates, reservation status changes, payment updates
   * </pre>
   */
  public static final class WebSocketServiceStub
      extends io.grpc.stub.AbstractAsyncStub<WebSocketServiceStub> {
    private WebSocketServiceStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected WebSocketServiceStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new WebSocketServiceStub(channel, callOptions);
    }

    /**
     * <pre>
     * Establish real-time connection for queue updates
     * </pre>
     */
    public void streamQueueUpdates(com.traffic_tacos.gateway.v1.StreamQueueUpdatesRequest request,
        io.grpc.stub.StreamObserver<com.traffic_tacos.gateway.v1.StreamQueueUpdatesResponse> responseObserver) {
      io.grpc.stub.ClientCalls.asyncServerStreamingCall(
          getChannel().newCall(getStreamQueueUpdatesMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     * <pre>
     * Establish real-time connection for reservation updates
     * </pre>
     */
    public void streamReservationUpdates(com.traffic_tacos.gateway.v1.StreamReservationUpdatesRequest request,
        io.grpc.stub.StreamObserver<com.traffic_tacos.gateway.v1.StreamReservationUpdatesResponse> responseObserver) {
      io.grpc.stub.ClientCalls.asyncServerStreamingCall(
          getChannel().newCall(getStreamReservationUpdatesMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     * <pre>
     * Establish real-time connection for payment updates
     * </pre>
     */
    public void streamPaymentUpdates(com.traffic_tacos.gateway.v1.StreamPaymentUpdatesRequest request,
        io.grpc.stub.StreamObserver<com.traffic_tacos.gateway.v1.StreamPaymentUpdatesResponse> responseObserver) {
      io.grpc.stub.ClientCalls.asyncServerStreamingCall(
          getChannel().newCall(getStreamPaymentUpdatesMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     * <pre>
     * Send a message to a specific user/session
     * </pre>
     */
    public void sendMessage(com.traffic_tacos.gateway.v1.SendMessageRequest request,
        io.grpc.stub.StreamObserver<com.traffic_tacos.gateway.v1.SendMessageResponse> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getSendMessageMethod(), getCallOptions()), request, responseObserver);
    }
  }

  /**
   * A stub to allow clients to do synchronous rpc calls to service WebSocketService.
   * <pre>
   * WebSocket service for real-time updates
   * Handles queue position updates, reservation status changes, payment updates
   * </pre>
   */
  public static final class WebSocketServiceBlockingV2Stub
      extends io.grpc.stub.AbstractBlockingStub<WebSocketServiceBlockingV2Stub> {
    private WebSocketServiceBlockingV2Stub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected WebSocketServiceBlockingV2Stub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new WebSocketServiceBlockingV2Stub(channel, callOptions);
    }

    /**
     * <pre>
     * Establish real-time connection for queue updates
     * </pre>
     */
    @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/10918")
    public io.grpc.stub.BlockingClientCall<?, com.traffic_tacos.gateway.v1.StreamQueueUpdatesResponse>
        streamQueueUpdates(com.traffic_tacos.gateway.v1.StreamQueueUpdatesRequest request) {
      return io.grpc.stub.ClientCalls.blockingV2ServerStreamingCall(
          getChannel(), getStreamQueueUpdatesMethod(), getCallOptions(), request);
    }

    /**
     * <pre>
     * Establish real-time connection for reservation updates
     * </pre>
     */
    @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/10918")
    public io.grpc.stub.BlockingClientCall<?, com.traffic_tacos.gateway.v1.StreamReservationUpdatesResponse>
        streamReservationUpdates(com.traffic_tacos.gateway.v1.StreamReservationUpdatesRequest request) {
      return io.grpc.stub.ClientCalls.blockingV2ServerStreamingCall(
          getChannel(), getStreamReservationUpdatesMethod(), getCallOptions(), request);
    }

    /**
     * <pre>
     * Establish real-time connection for payment updates
     * </pre>
     */
    @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/10918")
    public io.grpc.stub.BlockingClientCall<?, com.traffic_tacos.gateway.v1.StreamPaymentUpdatesResponse>
        streamPaymentUpdates(com.traffic_tacos.gateway.v1.StreamPaymentUpdatesRequest request) {
      return io.grpc.stub.ClientCalls.blockingV2ServerStreamingCall(
          getChannel(), getStreamPaymentUpdatesMethod(), getCallOptions(), request);
    }

    /**
     * <pre>
     * Send a message to a specific user/session
     * </pre>
     */
    public com.traffic_tacos.gateway.v1.SendMessageResponse sendMessage(com.traffic_tacos.gateway.v1.SendMessageRequest request) throws io.grpc.StatusException {
      return io.grpc.stub.ClientCalls.blockingV2UnaryCall(
          getChannel(), getSendMessageMethod(), getCallOptions(), request);
    }
  }

  /**
   * A stub to allow clients to do limited synchronous rpc calls to service WebSocketService.
   * <pre>
   * WebSocket service for real-time updates
   * Handles queue position updates, reservation status changes, payment updates
   * </pre>
   */
  public static final class WebSocketServiceBlockingStub
      extends io.grpc.stub.AbstractBlockingStub<WebSocketServiceBlockingStub> {
    private WebSocketServiceBlockingStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected WebSocketServiceBlockingStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new WebSocketServiceBlockingStub(channel, callOptions);
    }

    /**
     * <pre>
     * Establish real-time connection for queue updates
     * </pre>
     */
    public java.util.Iterator<com.traffic_tacos.gateway.v1.StreamQueueUpdatesResponse> streamQueueUpdates(
        com.traffic_tacos.gateway.v1.StreamQueueUpdatesRequest request) {
      return io.grpc.stub.ClientCalls.blockingServerStreamingCall(
          getChannel(), getStreamQueueUpdatesMethod(), getCallOptions(), request);
    }

    /**
     * <pre>
     * Establish real-time connection for reservation updates
     * </pre>
     */
    public java.util.Iterator<com.traffic_tacos.gateway.v1.StreamReservationUpdatesResponse> streamReservationUpdates(
        com.traffic_tacos.gateway.v1.StreamReservationUpdatesRequest request) {
      return io.grpc.stub.ClientCalls.blockingServerStreamingCall(
          getChannel(), getStreamReservationUpdatesMethod(), getCallOptions(), request);
    }

    /**
     * <pre>
     * Establish real-time connection for payment updates
     * </pre>
     */
    public java.util.Iterator<com.traffic_tacos.gateway.v1.StreamPaymentUpdatesResponse> streamPaymentUpdates(
        com.traffic_tacos.gateway.v1.StreamPaymentUpdatesRequest request) {
      return io.grpc.stub.ClientCalls.blockingServerStreamingCall(
          getChannel(), getStreamPaymentUpdatesMethod(), getCallOptions(), request);
    }

    /**
     * <pre>
     * Send a message to a specific user/session
     * </pre>
     */
    public com.traffic_tacos.gateway.v1.SendMessageResponse sendMessage(com.traffic_tacos.gateway.v1.SendMessageRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getSendMessageMethod(), getCallOptions(), request);
    }
  }

  /**
   * A stub to allow clients to do ListenableFuture-style rpc calls to service WebSocketService.
   * <pre>
   * WebSocket service for real-time updates
   * Handles queue position updates, reservation status changes, payment updates
   * </pre>
   */
  public static final class WebSocketServiceFutureStub
      extends io.grpc.stub.AbstractFutureStub<WebSocketServiceFutureStub> {
    private WebSocketServiceFutureStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected WebSocketServiceFutureStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new WebSocketServiceFutureStub(channel, callOptions);
    }

    /**
     * <pre>
     * Send a message to a specific user/session
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.traffic_tacos.gateway.v1.SendMessageResponse> sendMessage(
        com.traffic_tacos.gateway.v1.SendMessageRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getSendMessageMethod(), getCallOptions()), request);
    }
  }

  private static final int METHODID_STREAM_QUEUE_UPDATES = 0;
  private static final int METHODID_STREAM_RESERVATION_UPDATES = 1;
  private static final int METHODID_STREAM_PAYMENT_UPDATES = 2;
  private static final int METHODID_SEND_MESSAGE = 3;

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
        case METHODID_STREAM_QUEUE_UPDATES:
          serviceImpl.streamQueueUpdates((com.traffic_tacos.gateway.v1.StreamQueueUpdatesRequest) request,
              (io.grpc.stub.StreamObserver<com.traffic_tacos.gateway.v1.StreamQueueUpdatesResponse>) responseObserver);
          break;
        case METHODID_STREAM_RESERVATION_UPDATES:
          serviceImpl.streamReservationUpdates((com.traffic_tacos.gateway.v1.StreamReservationUpdatesRequest) request,
              (io.grpc.stub.StreamObserver<com.traffic_tacos.gateway.v1.StreamReservationUpdatesResponse>) responseObserver);
          break;
        case METHODID_STREAM_PAYMENT_UPDATES:
          serviceImpl.streamPaymentUpdates((com.traffic_tacos.gateway.v1.StreamPaymentUpdatesRequest) request,
              (io.grpc.stub.StreamObserver<com.traffic_tacos.gateway.v1.StreamPaymentUpdatesResponse>) responseObserver);
          break;
        case METHODID_SEND_MESSAGE:
          serviceImpl.sendMessage((com.traffic_tacos.gateway.v1.SendMessageRequest) request,
              (io.grpc.stub.StreamObserver<com.traffic_tacos.gateway.v1.SendMessageResponse>) responseObserver);
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
          getStreamQueueUpdatesMethod(),
          io.grpc.stub.ServerCalls.asyncServerStreamingCall(
            new MethodHandlers<
              com.traffic_tacos.gateway.v1.StreamQueueUpdatesRequest,
              com.traffic_tacos.gateway.v1.StreamQueueUpdatesResponse>(
                service, METHODID_STREAM_QUEUE_UPDATES)))
        .addMethod(
          getStreamReservationUpdatesMethod(),
          io.grpc.stub.ServerCalls.asyncServerStreamingCall(
            new MethodHandlers<
              com.traffic_tacos.gateway.v1.StreamReservationUpdatesRequest,
              com.traffic_tacos.gateway.v1.StreamReservationUpdatesResponse>(
                service, METHODID_STREAM_RESERVATION_UPDATES)))
        .addMethod(
          getStreamPaymentUpdatesMethod(),
          io.grpc.stub.ServerCalls.asyncServerStreamingCall(
            new MethodHandlers<
              com.traffic_tacos.gateway.v1.StreamPaymentUpdatesRequest,
              com.traffic_tacos.gateway.v1.StreamPaymentUpdatesResponse>(
                service, METHODID_STREAM_PAYMENT_UPDATES)))
        .addMethod(
          getSendMessageMethod(),
          io.grpc.stub.ServerCalls.asyncUnaryCall(
            new MethodHandlers<
              com.traffic_tacos.gateway.v1.SendMessageRequest,
              com.traffic_tacos.gateway.v1.SendMessageResponse>(
                service, METHODID_SEND_MESSAGE)))
        .build();
  }

  private static abstract class WebSocketServiceBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoFileDescriptorSupplier, io.grpc.protobuf.ProtoServiceDescriptorSupplier {
    WebSocketServiceBaseDescriptorSupplier() {}

    @java.lang.Override
    public com.google.protobuf.Descriptors.FileDescriptor getFileDescriptor() {
      return com.traffic_tacos.gateway.v1.WebSocketProto.getDescriptor();
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.ServiceDescriptor getServiceDescriptor() {
      return getFileDescriptor().findServiceByName("WebSocketService");
    }
  }

  private static final class WebSocketServiceFileDescriptorSupplier
      extends WebSocketServiceBaseDescriptorSupplier {
    WebSocketServiceFileDescriptorSupplier() {}
  }

  private static final class WebSocketServiceMethodDescriptorSupplier
      extends WebSocketServiceBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoMethodDescriptorSupplier {
    private final java.lang.String methodName;

    WebSocketServiceMethodDescriptorSupplier(java.lang.String methodName) {
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
      synchronized (WebSocketServiceGrpc.class) {
        result = serviceDescriptor;
        if (result == null) {
          serviceDescriptor = result = io.grpc.ServiceDescriptor.newBuilder(SERVICE_NAME)
              .setSchemaDescriptor(new WebSocketServiceFileDescriptorSupplier())
              .addMethod(getStreamQueueUpdatesMethod())
              .addMethod(getStreamReservationUpdatesMethod())
              .addMethod(getStreamPaymentUpdatesMethod())
              .addMethod(getSendMessageMethod())
              .build();
        }
      }
    }
    return result;
  }
}

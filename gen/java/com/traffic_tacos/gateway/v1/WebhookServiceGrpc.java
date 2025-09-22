package com.traffic_tacos.gateway.v1;

import static io.grpc.MethodDescriptor.generateFullMethodName;

/**
 * <pre>
 * Webhook service for receiving external events
 * Primarily handles payment webhooks from payment-sim-api
 * </pre>
 */
@io.grpc.stub.annotations.GrpcGenerated
public final class WebhookServiceGrpc {

  private WebhookServiceGrpc() {}

  public static final java.lang.String SERVICE_NAME = "gateway.v1.WebhookService";

  // Static method descriptors that strictly reflect the proto.
  private static volatile io.grpc.MethodDescriptor<com.traffic_tacos.gateway.v1.ReceivePaymentWebhookRequest,
      com.traffic_tacos.gateway.v1.ReceivePaymentWebhookResponse> getReceivePaymentWebhookMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "ReceivePaymentWebhook",
      requestType = com.traffic_tacos.gateway.v1.ReceivePaymentWebhookRequest.class,
      responseType = com.traffic_tacos.gateway.v1.ReceivePaymentWebhookResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<com.traffic_tacos.gateway.v1.ReceivePaymentWebhookRequest,
      com.traffic_tacos.gateway.v1.ReceivePaymentWebhookResponse> getReceivePaymentWebhookMethod() {
    io.grpc.MethodDescriptor<com.traffic_tacos.gateway.v1.ReceivePaymentWebhookRequest, com.traffic_tacos.gateway.v1.ReceivePaymentWebhookResponse> getReceivePaymentWebhookMethod;
    if ((getReceivePaymentWebhookMethod = WebhookServiceGrpc.getReceivePaymentWebhookMethod) == null) {
      synchronized (WebhookServiceGrpc.class) {
        if ((getReceivePaymentWebhookMethod = WebhookServiceGrpc.getReceivePaymentWebhookMethod) == null) {
          WebhookServiceGrpc.getReceivePaymentWebhookMethod = getReceivePaymentWebhookMethod =
              io.grpc.MethodDescriptor.<com.traffic_tacos.gateway.v1.ReceivePaymentWebhookRequest, com.traffic_tacos.gateway.v1.ReceivePaymentWebhookResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "ReceivePaymentWebhook"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.traffic_tacos.gateway.v1.ReceivePaymentWebhookRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.traffic_tacos.gateway.v1.ReceivePaymentWebhookResponse.getDefaultInstance()))
              .setSchemaDescriptor(new WebhookServiceMethodDescriptorSupplier("ReceivePaymentWebhook"))
              .build();
        }
      }
    }
    return getReceivePaymentWebhookMethod;
  }

  private static volatile io.grpc.MethodDescriptor<com.traffic_tacos.gateway.v1.ReceiveExpiryWebhookRequest,
      com.traffic_tacos.gateway.v1.ReceiveExpiryWebhookResponse> getReceiveExpiryWebhookMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "ReceiveExpiryWebhook",
      requestType = com.traffic_tacos.gateway.v1.ReceiveExpiryWebhookRequest.class,
      responseType = com.traffic_tacos.gateway.v1.ReceiveExpiryWebhookResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<com.traffic_tacos.gateway.v1.ReceiveExpiryWebhookRequest,
      com.traffic_tacos.gateway.v1.ReceiveExpiryWebhookResponse> getReceiveExpiryWebhookMethod() {
    io.grpc.MethodDescriptor<com.traffic_tacos.gateway.v1.ReceiveExpiryWebhookRequest, com.traffic_tacos.gateway.v1.ReceiveExpiryWebhookResponse> getReceiveExpiryWebhookMethod;
    if ((getReceiveExpiryWebhookMethod = WebhookServiceGrpc.getReceiveExpiryWebhookMethod) == null) {
      synchronized (WebhookServiceGrpc.class) {
        if ((getReceiveExpiryWebhookMethod = WebhookServiceGrpc.getReceiveExpiryWebhookMethod) == null) {
          WebhookServiceGrpc.getReceiveExpiryWebhookMethod = getReceiveExpiryWebhookMethod =
              io.grpc.MethodDescriptor.<com.traffic_tacos.gateway.v1.ReceiveExpiryWebhookRequest, com.traffic_tacos.gateway.v1.ReceiveExpiryWebhookResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "ReceiveExpiryWebhook"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.traffic_tacos.gateway.v1.ReceiveExpiryWebhookRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.traffic_tacos.gateway.v1.ReceiveExpiryWebhookResponse.getDefaultInstance()))
              .setSchemaDescriptor(new WebhookServiceMethodDescriptorSupplier("ReceiveExpiryWebhook"))
              .build();
        }
      }
    }
    return getReceiveExpiryWebhookMethod;
  }

  private static volatile io.grpc.MethodDescriptor<com.traffic_tacos.gateway.v1.RegisterWebhookRequest,
      com.traffic_tacos.gateway.v1.RegisterWebhookResponse> getRegisterWebhookMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "RegisterWebhook",
      requestType = com.traffic_tacos.gateway.v1.RegisterWebhookRequest.class,
      responseType = com.traffic_tacos.gateway.v1.RegisterWebhookResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<com.traffic_tacos.gateway.v1.RegisterWebhookRequest,
      com.traffic_tacos.gateway.v1.RegisterWebhookResponse> getRegisterWebhookMethod() {
    io.grpc.MethodDescriptor<com.traffic_tacos.gateway.v1.RegisterWebhookRequest, com.traffic_tacos.gateway.v1.RegisterWebhookResponse> getRegisterWebhookMethod;
    if ((getRegisterWebhookMethod = WebhookServiceGrpc.getRegisterWebhookMethod) == null) {
      synchronized (WebhookServiceGrpc.class) {
        if ((getRegisterWebhookMethod = WebhookServiceGrpc.getRegisterWebhookMethod) == null) {
          WebhookServiceGrpc.getRegisterWebhookMethod = getRegisterWebhookMethod =
              io.grpc.MethodDescriptor.<com.traffic_tacos.gateway.v1.RegisterWebhookRequest, com.traffic_tacos.gateway.v1.RegisterWebhookResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "RegisterWebhook"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.traffic_tacos.gateway.v1.RegisterWebhookRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.traffic_tacos.gateway.v1.RegisterWebhookResponse.getDefaultInstance()))
              .setSchemaDescriptor(new WebhookServiceMethodDescriptorSupplier("RegisterWebhook"))
              .build();
        }
      }
    }
    return getRegisterWebhookMethod;
  }

  private static volatile io.grpc.MethodDescriptor<com.traffic_tacos.gateway.v1.ValidateWebhookRequest,
      com.traffic_tacos.gateway.v1.ValidateWebhookResponse> getValidateWebhookMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "ValidateWebhook",
      requestType = com.traffic_tacos.gateway.v1.ValidateWebhookRequest.class,
      responseType = com.traffic_tacos.gateway.v1.ValidateWebhookResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<com.traffic_tacos.gateway.v1.ValidateWebhookRequest,
      com.traffic_tacos.gateway.v1.ValidateWebhookResponse> getValidateWebhookMethod() {
    io.grpc.MethodDescriptor<com.traffic_tacos.gateway.v1.ValidateWebhookRequest, com.traffic_tacos.gateway.v1.ValidateWebhookResponse> getValidateWebhookMethod;
    if ((getValidateWebhookMethod = WebhookServiceGrpc.getValidateWebhookMethod) == null) {
      synchronized (WebhookServiceGrpc.class) {
        if ((getValidateWebhookMethod = WebhookServiceGrpc.getValidateWebhookMethod) == null) {
          WebhookServiceGrpc.getValidateWebhookMethod = getValidateWebhookMethod =
              io.grpc.MethodDescriptor.<com.traffic_tacos.gateway.v1.ValidateWebhookRequest, com.traffic_tacos.gateway.v1.ValidateWebhookResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "ValidateWebhook"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.traffic_tacos.gateway.v1.ValidateWebhookRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.traffic_tacos.gateway.v1.ValidateWebhookResponse.getDefaultInstance()))
              .setSchemaDescriptor(new WebhookServiceMethodDescriptorSupplier("ValidateWebhook"))
              .build();
        }
      }
    }
    return getValidateWebhookMethod;
  }

  /**
   * Creates a new async stub that supports all call types for the service
   */
  public static WebhookServiceStub newStub(io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<WebhookServiceStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<WebhookServiceStub>() {
        @java.lang.Override
        public WebhookServiceStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new WebhookServiceStub(channel, callOptions);
        }
      };
    return WebhookServiceStub.newStub(factory, channel);
  }

  /**
   * Creates a new blocking-style stub that supports all types of calls on the service
   */
  public static WebhookServiceBlockingV2Stub newBlockingV2Stub(
      io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<WebhookServiceBlockingV2Stub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<WebhookServiceBlockingV2Stub>() {
        @java.lang.Override
        public WebhookServiceBlockingV2Stub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new WebhookServiceBlockingV2Stub(channel, callOptions);
        }
      };
    return WebhookServiceBlockingV2Stub.newStub(factory, channel);
  }

  /**
   * Creates a new blocking-style stub that supports unary and streaming output calls on the service
   */
  public static WebhookServiceBlockingStub newBlockingStub(
      io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<WebhookServiceBlockingStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<WebhookServiceBlockingStub>() {
        @java.lang.Override
        public WebhookServiceBlockingStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new WebhookServiceBlockingStub(channel, callOptions);
        }
      };
    return WebhookServiceBlockingStub.newStub(factory, channel);
  }

  /**
   * Creates a new ListenableFuture-style stub that supports unary calls on the service
   */
  public static WebhookServiceFutureStub newFutureStub(
      io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<WebhookServiceFutureStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<WebhookServiceFutureStub>() {
        @java.lang.Override
        public WebhookServiceFutureStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new WebhookServiceFutureStub(channel, callOptions);
        }
      };
    return WebhookServiceFutureStub.newStub(factory, channel);
  }

  /**
   * <pre>
   * Webhook service for receiving external events
   * Primarily handles payment webhooks from payment-sim-api
   * </pre>
   */
  public interface AsyncService {

    /**
     * <pre>
     * Receive payment webhook events
     * </pre>
     */
    default void receivePaymentWebhook(com.traffic_tacos.gateway.v1.ReceivePaymentWebhookRequest request,
        io.grpc.stub.StreamObserver<com.traffic_tacos.gateway.v1.ReceivePaymentWebhookResponse> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getReceivePaymentWebhookMethod(), responseObserver);
    }

    /**
     * <pre>
     * Receive reservation expiry webhook from EventBridge/Lambda
     * </pre>
     */
    default void receiveExpiryWebhook(com.traffic_tacos.gateway.v1.ReceiveExpiryWebhookRequest request,
        io.grpc.stub.StreamObserver<com.traffic_tacos.gateway.v1.ReceiveExpiryWebhookResponse> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getReceiveExpiryWebhookMethod(), responseObserver);
    }

    /**
     * <pre>
     * Register webhook endpoint for external services
     * </pre>
     */
    default void registerWebhook(com.traffic_tacos.gateway.v1.RegisterWebhookRequest request,
        io.grpc.stub.StreamObserver<com.traffic_tacos.gateway.v1.RegisterWebhookResponse> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getRegisterWebhookMethod(), responseObserver);
    }

    /**
     * <pre>
     * Validate webhook signature
     * </pre>
     */
    default void validateWebhook(com.traffic_tacos.gateway.v1.ValidateWebhookRequest request,
        io.grpc.stub.StreamObserver<com.traffic_tacos.gateway.v1.ValidateWebhookResponse> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getValidateWebhookMethod(), responseObserver);
    }
  }

  /**
   * Base class for the server implementation of the service WebhookService.
   * <pre>
   * Webhook service for receiving external events
   * Primarily handles payment webhooks from payment-sim-api
   * </pre>
   */
  public static abstract class WebhookServiceImplBase
      implements io.grpc.BindableService, AsyncService {

    @java.lang.Override public final io.grpc.ServerServiceDefinition bindService() {
      return WebhookServiceGrpc.bindService(this);
    }
  }

  /**
   * A stub to allow clients to do asynchronous rpc calls to service WebhookService.
   * <pre>
   * Webhook service for receiving external events
   * Primarily handles payment webhooks from payment-sim-api
   * </pre>
   */
  public static final class WebhookServiceStub
      extends io.grpc.stub.AbstractAsyncStub<WebhookServiceStub> {
    private WebhookServiceStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected WebhookServiceStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new WebhookServiceStub(channel, callOptions);
    }

    /**
     * <pre>
     * Receive payment webhook events
     * </pre>
     */
    public void receivePaymentWebhook(com.traffic_tacos.gateway.v1.ReceivePaymentWebhookRequest request,
        io.grpc.stub.StreamObserver<com.traffic_tacos.gateway.v1.ReceivePaymentWebhookResponse> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getReceivePaymentWebhookMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     * <pre>
     * Receive reservation expiry webhook from EventBridge/Lambda
     * </pre>
     */
    public void receiveExpiryWebhook(com.traffic_tacos.gateway.v1.ReceiveExpiryWebhookRequest request,
        io.grpc.stub.StreamObserver<com.traffic_tacos.gateway.v1.ReceiveExpiryWebhookResponse> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getReceiveExpiryWebhookMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     * <pre>
     * Register webhook endpoint for external services
     * </pre>
     */
    public void registerWebhook(com.traffic_tacos.gateway.v1.RegisterWebhookRequest request,
        io.grpc.stub.StreamObserver<com.traffic_tacos.gateway.v1.RegisterWebhookResponse> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getRegisterWebhookMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     * <pre>
     * Validate webhook signature
     * </pre>
     */
    public void validateWebhook(com.traffic_tacos.gateway.v1.ValidateWebhookRequest request,
        io.grpc.stub.StreamObserver<com.traffic_tacos.gateway.v1.ValidateWebhookResponse> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getValidateWebhookMethod(), getCallOptions()), request, responseObserver);
    }
  }

  /**
   * A stub to allow clients to do synchronous rpc calls to service WebhookService.
   * <pre>
   * Webhook service for receiving external events
   * Primarily handles payment webhooks from payment-sim-api
   * </pre>
   */
  public static final class WebhookServiceBlockingV2Stub
      extends io.grpc.stub.AbstractBlockingStub<WebhookServiceBlockingV2Stub> {
    private WebhookServiceBlockingV2Stub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected WebhookServiceBlockingV2Stub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new WebhookServiceBlockingV2Stub(channel, callOptions);
    }

    /**
     * <pre>
     * Receive payment webhook events
     * </pre>
     */
    public com.traffic_tacos.gateway.v1.ReceivePaymentWebhookResponse receivePaymentWebhook(com.traffic_tacos.gateway.v1.ReceivePaymentWebhookRequest request) throws io.grpc.StatusException {
      return io.grpc.stub.ClientCalls.blockingV2UnaryCall(
          getChannel(), getReceivePaymentWebhookMethod(), getCallOptions(), request);
    }

    /**
     * <pre>
     * Receive reservation expiry webhook from EventBridge/Lambda
     * </pre>
     */
    public com.traffic_tacos.gateway.v1.ReceiveExpiryWebhookResponse receiveExpiryWebhook(com.traffic_tacos.gateway.v1.ReceiveExpiryWebhookRequest request) throws io.grpc.StatusException {
      return io.grpc.stub.ClientCalls.blockingV2UnaryCall(
          getChannel(), getReceiveExpiryWebhookMethod(), getCallOptions(), request);
    }

    /**
     * <pre>
     * Register webhook endpoint for external services
     * </pre>
     */
    public com.traffic_tacos.gateway.v1.RegisterWebhookResponse registerWebhook(com.traffic_tacos.gateway.v1.RegisterWebhookRequest request) throws io.grpc.StatusException {
      return io.grpc.stub.ClientCalls.blockingV2UnaryCall(
          getChannel(), getRegisterWebhookMethod(), getCallOptions(), request);
    }

    /**
     * <pre>
     * Validate webhook signature
     * </pre>
     */
    public com.traffic_tacos.gateway.v1.ValidateWebhookResponse validateWebhook(com.traffic_tacos.gateway.v1.ValidateWebhookRequest request) throws io.grpc.StatusException {
      return io.grpc.stub.ClientCalls.blockingV2UnaryCall(
          getChannel(), getValidateWebhookMethod(), getCallOptions(), request);
    }
  }

  /**
   * A stub to allow clients to do limited synchronous rpc calls to service WebhookService.
   * <pre>
   * Webhook service for receiving external events
   * Primarily handles payment webhooks from payment-sim-api
   * </pre>
   */
  public static final class WebhookServiceBlockingStub
      extends io.grpc.stub.AbstractBlockingStub<WebhookServiceBlockingStub> {
    private WebhookServiceBlockingStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected WebhookServiceBlockingStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new WebhookServiceBlockingStub(channel, callOptions);
    }

    /**
     * <pre>
     * Receive payment webhook events
     * </pre>
     */
    public com.traffic_tacos.gateway.v1.ReceivePaymentWebhookResponse receivePaymentWebhook(com.traffic_tacos.gateway.v1.ReceivePaymentWebhookRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getReceivePaymentWebhookMethod(), getCallOptions(), request);
    }

    /**
     * <pre>
     * Receive reservation expiry webhook from EventBridge/Lambda
     * </pre>
     */
    public com.traffic_tacos.gateway.v1.ReceiveExpiryWebhookResponse receiveExpiryWebhook(com.traffic_tacos.gateway.v1.ReceiveExpiryWebhookRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getReceiveExpiryWebhookMethod(), getCallOptions(), request);
    }

    /**
     * <pre>
     * Register webhook endpoint for external services
     * </pre>
     */
    public com.traffic_tacos.gateway.v1.RegisterWebhookResponse registerWebhook(com.traffic_tacos.gateway.v1.RegisterWebhookRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getRegisterWebhookMethod(), getCallOptions(), request);
    }

    /**
     * <pre>
     * Validate webhook signature
     * </pre>
     */
    public com.traffic_tacos.gateway.v1.ValidateWebhookResponse validateWebhook(com.traffic_tacos.gateway.v1.ValidateWebhookRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getValidateWebhookMethod(), getCallOptions(), request);
    }
  }

  /**
   * A stub to allow clients to do ListenableFuture-style rpc calls to service WebhookService.
   * <pre>
   * Webhook service for receiving external events
   * Primarily handles payment webhooks from payment-sim-api
   * </pre>
   */
  public static final class WebhookServiceFutureStub
      extends io.grpc.stub.AbstractFutureStub<WebhookServiceFutureStub> {
    private WebhookServiceFutureStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected WebhookServiceFutureStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new WebhookServiceFutureStub(channel, callOptions);
    }

    /**
     * <pre>
     * Receive payment webhook events
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.traffic_tacos.gateway.v1.ReceivePaymentWebhookResponse> receivePaymentWebhook(
        com.traffic_tacos.gateway.v1.ReceivePaymentWebhookRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getReceivePaymentWebhookMethod(), getCallOptions()), request);
    }

    /**
     * <pre>
     * Receive reservation expiry webhook from EventBridge/Lambda
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.traffic_tacos.gateway.v1.ReceiveExpiryWebhookResponse> receiveExpiryWebhook(
        com.traffic_tacos.gateway.v1.ReceiveExpiryWebhookRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getReceiveExpiryWebhookMethod(), getCallOptions()), request);
    }

    /**
     * <pre>
     * Register webhook endpoint for external services
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.traffic_tacos.gateway.v1.RegisterWebhookResponse> registerWebhook(
        com.traffic_tacos.gateway.v1.RegisterWebhookRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getRegisterWebhookMethod(), getCallOptions()), request);
    }

    /**
     * <pre>
     * Validate webhook signature
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.traffic_tacos.gateway.v1.ValidateWebhookResponse> validateWebhook(
        com.traffic_tacos.gateway.v1.ValidateWebhookRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getValidateWebhookMethod(), getCallOptions()), request);
    }
  }

  private static final int METHODID_RECEIVE_PAYMENT_WEBHOOK = 0;
  private static final int METHODID_RECEIVE_EXPIRY_WEBHOOK = 1;
  private static final int METHODID_REGISTER_WEBHOOK = 2;
  private static final int METHODID_VALIDATE_WEBHOOK = 3;

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
        case METHODID_RECEIVE_PAYMENT_WEBHOOK:
          serviceImpl.receivePaymentWebhook((com.traffic_tacos.gateway.v1.ReceivePaymentWebhookRequest) request,
              (io.grpc.stub.StreamObserver<com.traffic_tacos.gateway.v1.ReceivePaymentWebhookResponse>) responseObserver);
          break;
        case METHODID_RECEIVE_EXPIRY_WEBHOOK:
          serviceImpl.receiveExpiryWebhook((com.traffic_tacos.gateway.v1.ReceiveExpiryWebhookRequest) request,
              (io.grpc.stub.StreamObserver<com.traffic_tacos.gateway.v1.ReceiveExpiryWebhookResponse>) responseObserver);
          break;
        case METHODID_REGISTER_WEBHOOK:
          serviceImpl.registerWebhook((com.traffic_tacos.gateway.v1.RegisterWebhookRequest) request,
              (io.grpc.stub.StreamObserver<com.traffic_tacos.gateway.v1.RegisterWebhookResponse>) responseObserver);
          break;
        case METHODID_VALIDATE_WEBHOOK:
          serviceImpl.validateWebhook((com.traffic_tacos.gateway.v1.ValidateWebhookRequest) request,
              (io.grpc.stub.StreamObserver<com.traffic_tacos.gateway.v1.ValidateWebhookResponse>) responseObserver);
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
          getReceivePaymentWebhookMethod(),
          io.grpc.stub.ServerCalls.asyncUnaryCall(
            new MethodHandlers<
              com.traffic_tacos.gateway.v1.ReceivePaymentWebhookRequest,
              com.traffic_tacos.gateway.v1.ReceivePaymentWebhookResponse>(
                service, METHODID_RECEIVE_PAYMENT_WEBHOOK)))
        .addMethod(
          getReceiveExpiryWebhookMethod(),
          io.grpc.stub.ServerCalls.asyncUnaryCall(
            new MethodHandlers<
              com.traffic_tacos.gateway.v1.ReceiveExpiryWebhookRequest,
              com.traffic_tacos.gateway.v1.ReceiveExpiryWebhookResponse>(
                service, METHODID_RECEIVE_EXPIRY_WEBHOOK)))
        .addMethod(
          getRegisterWebhookMethod(),
          io.grpc.stub.ServerCalls.asyncUnaryCall(
            new MethodHandlers<
              com.traffic_tacos.gateway.v1.RegisterWebhookRequest,
              com.traffic_tacos.gateway.v1.RegisterWebhookResponse>(
                service, METHODID_REGISTER_WEBHOOK)))
        .addMethod(
          getValidateWebhookMethod(),
          io.grpc.stub.ServerCalls.asyncUnaryCall(
            new MethodHandlers<
              com.traffic_tacos.gateway.v1.ValidateWebhookRequest,
              com.traffic_tacos.gateway.v1.ValidateWebhookResponse>(
                service, METHODID_VALIDATE_WEBHOOK)))
        .build();
  }

  private static abstract class WebhookServiceBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoFileDescriptorSupplier, io.grpc.protobuf.ProtoServiceDescriptorSupplier {
    WebhookServiceBaseDescriptorSupplier() {}

    @java.lang.Override
    public com.google.protobuf.Descriptors.FileDescriptor getFileDescriptor() {
      return com.traffic_tacos.gateway.v1.WebhookProto.getDescriptor();
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.ServiceDescriptor getServiceDescriptor() {
      return getFileDescriptor().findServiceByName("WebhookService");
    }
  }

  private static final class WebhookServiceFileDescriptorSupplier
      extends WebhookServiceBaseDescriptorSupplier {
    WebhookServiceFileDescriptorSupplier() {}
  }

  private static final class WebhookServiceMethodDescriptorSupplier
      extends WebhookServiceBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoMethodDescriptorSupplier {
    private final java.lang.String methodName;

    WebhookServiceMethodDescriptorSupplier(java.lang.String methodName) {
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
      synchronized (WebhookServiceGrpc.class) {
        result = serviceDescriptor;
        if (result == null) {
          serviceDescriptor = result = io.grpc.ServiceDescriptor.newBuilder(SERVICE_NAME)
              .setSchemaDescriptor(new WebhookServiceFileDescriptorSupplier())
              .addMethod(getReceivePaymentWebhookMethod())
              .addMethod(getReceiveExpiryWebhookMethod())
              .addMethod(getRegisterWebhookMethod())
              .addMethod(getValidateWebhookMethod())
              .build();
        }
      }
    }
    return result;
  }
}

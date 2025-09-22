package com.traffic_tacos.payment.v1;

import static io.grpc.MethodDescriptor.generateFullMethodName;

/**
 * <pre>
 * Payment service simulates external payment processing
 * Supports various scenarios: approve, fail, delay, random
 * </pre>
 */
@io.grpc.stub.annotations.GrpcGenerated
public final class PaymentServiceGrpc {

  private PaymentServiceGrpc() {}

  public static final java.lang.String SERVICE_NAME = "payment.v1.PaymentService";

  // Static method descriptors that strictly reflect the proto.
  private static volatile io.grpc.MethodDescriptor<com.traffic_tacos.payment.v1.CreatePaymentIntentRequest,
      com.traffic_tacos.payment.v1.CreatePaymentIntentResponse> getCreatePaymentIntentMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "CreatePaymentIntent",
      requestType = com.traffic_tacos.payment.v1.CreatePaymentIntentRequest.class,
      responseType = com.traffic_tacos.payment.v1.CreatePaymentIntentResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<com.traffic_tacos.payment.v1.CreatePaymentIntentRequest,
      com.traffic_tacos.payment.v1.CreatePaymentIntentResponse> getCreatePaymentIntentMethod() {
    io.grpc.MethodDescriptor<com.traffic_tacos.payment.v1.CreatePaymentIntentRequest, com.traffic_tacos.payment.v1.CreatePaymentIntentResponse> getCreatePaymentIntentMethod;
    if ((getCreatePaymentIntentMethod = PaymentServiceGrpc.getCreatePaymentIntentMethod) == null) {
      synchronized (PaymentServiceGrpc.class) {
        if ((getCreatePaymentIntentMethod = PaymentServiceGrpc.getCreatePaymentIntentMethod) == null) {
          PaymentServiceGrpc.getCreatePaymentIntentMethod = getCreatePaymentIntentMethod =
              io.grpc.MethodDescriptor.<com.traffic_tacos.payment.v1.CreatePaymentIntentRequest, com.traffic_tacos.payment.v1.CreatePaymentIntentResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "CreatePaymentIntent"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.traffic_tacos.payment.v1.CreatePaymentIntentRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.traffic_tacos.payment.v1.CreatePaymentIntentResponse.getDefaultInstance()))
              .setSchemaDescriptor(new PaymentServiceMethodDescriptorSupplier("CreatePaymentIntent"))
              .build();
        }
      }
    }
    return getCreatePaymentIntentMethod;
  }

  private static volatile io.grpc.MethodDescriptor<com.traffic_tacos.payment.v1.ProcessPaymentRequest,
      com.traffic_tacos.payment.v1.ProcessPaymentResponse> getProcessPaymentMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "ProcessPayment",
      requestType = com.traffic_tacos.payment.v1.ProcessPaymentRequest.class,
      responseType = com.traffic_tacos.payment.v1.ProcessPaymentResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<com.traffic_tacos.payment.v1.ProcessPaymentRequest,
      com.traffic_tacos.payment.v1.ProcessPaymentResponse> getProcessPaymentMethod() {
    io.grpc.MethodDescriptor<com.traffic_tacos.payment.v1.ProcessPaymentRequest, com.traffic_tacos.payment.v1.ProcessPaymentResponse> getProcessPaymentMethod;
    if ((getProcessPaymentMethod = PaymentServiceGrpc.getProcessPaymentMethod) == null) {
      synchronized (PaymentServiceGrpc.class) {
        if ((getProcessPaymentMethod = PaymentServiceGrpc.getProcessPaymentMethod) == null) {
          PaymentServiceGrpc.getProcessPaymentMethod = getProcessPaymentMethod =
              io.grpc.MethodDescriptor.<com.traffic_tacos.payment.v1.ProcessPaymentRequest, com.traffic_tacos.payment.v1.ProcessPaymentResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "ProcessPayment"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.traffic_tacos.payment.v1.ProcessPaymentRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.traffic_tacos.payment.v1.ProcessPaymentResponse.getDefaultInstance()))
              .setSchemaDescriptor(new PaymentServiceMethodDescriptorSupplier("ProcessPayment"))
              .build();
        }
      }
    }
    return getProcessPaymentMethod;
  }

  private static volatile io.grpc.MethodDescriptor<com.traffic_tacos.payment.v1.GetPaymentStatusRequest,
      com.traffic_tacos.payment.v1.GetPaymentStatusResponse> getGetPaymentStatusMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "GetPaymentStatus",
      requestType = com.traffic_tacos.payment.v1.GetPaymentStatusRequest.class,
      responseType = com.traffic_tacos.payment.v1.GetPaymentStatusResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<com.traffic_tacos.payment.v1.GetPaymentStatusRequest,
      com.traffic_tacos.payment.v1.GetPaymentStatusResponse> getGetPaymentStatusMethod() {
    io.grpc.MethodDescriptor<com.traffic_tacos.payment.v1.GetPaymentStatusRequest, com.traffic_tacos.payment.v1.GetPaymentStatusResponse> getGetPaymentStatusMethod;
    if ((getGetPaymentStatusMethod = PaymentServiceGrpc.getGetPaymentStatusMethod) == null) {
      synchronized (PaymentServiceGrpc.class) {
        if ((getGetPaymentStatusMethod = PaymentServiceGrpc.getGetPaymentStatusMethod) == null) {
          PaymentServiceGrpc.getGetPaymentStatusMethod = getGetPaymentStatusMethod =
              io.grpc.MethodDescriptor.<com.traffic_tacos.payment.v1.GetPaymentStatusRequest, com.traffic_tacos.payment.v1.GetPaymentStatusResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "GetPaymentStatus"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.traffic_tacos.payment.v1.GetPaymentStatusRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.traffic_tacos.payment.v1.GetPaymentStatusResponse.getDefaultInstance()))
              .setSchemaDescriptor(new PaymentServiceMethodDescriptorSupplier("GetPaymentStatus"))
              .build();
        }
      }
    }
    return getGetPaymentStatusMethod;
  }

  private static volatile io.grpc.MethodDescriptor<com.traffic_tacos.payment.v1.CancelPaymentRequest,
      com.traffic_tacos.payment.v1.CancelPaymentResponse> getCancelPaymentMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "CancelPayment",
      requestType = com.traffic_tacos.payment.v1.CancelPaymentRequest.class,
      responseType = com.traffic_tacos.payment.v1.CancelPaymentResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<com.traffic_tacos.payment.v1.CancelPaymentRequest,
      com.traffic_tacos.payment.v1.CancelPaymentResponse> getCancelPaymentMethod() {
    io.grpc.MethodDescriptor<com.traffic_tacos.payment.v1.CancelPaymentRequest, com.traffic_tacos.payment.v1.CancelPaymentResponse> getCancelPaymentMethod;
    if ((getCancelPaymentMethod = PaymentServiceGrpc.getCancelPaymentMethod) == null) {
      synchronized (PaymentServiceGrpc.class) {
        if ((getCancelPaymentMethod = PaymentServiceGrpc.getCancelPaymentMethod) == null) {
          PaymentServiceGrpc.getCancelPaymentMethod = getCancelPaymentMethod =
              io.grpc.MethodDescriptor.<com.traffic_tacos.payment.v1.CancelPaymentRequest, com.traffic_tacos.payment.v1.CancelPaymentResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "CancelPayment"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.traffic_tacos.payment.v1.CancelPaymentRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.traffic_tacos.payment.v1.CancelPaymentResponse.getDefaultInstance()))
              .setSchemaDescriptor(new PaymentServiceMethodDescriptorSupplier("CancelPayment"))
              .build();
        }
      }
    }
    return getCancelPaymentMethod;
  }

  private static volatile io.grpc.MethodDescriptor<com.traffic_tacos.payment.v1.ListPaymentsRequest,
      com.traffic_tacos.payment.v1.ListPaymentsResponse> getListPaymentsMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "ListPayments",
      requestType = com.traffic_tacos.payment.v1.ListPaymentsRequest.class,
      responseType = com.traffic_tacos.payment.v1.ListPaymentsResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<com.traffic_tacos.payment.v1.ListPaymentsRequest,
      com.traffic_tacos.payment.v1.ListPaymentsResponse> getListPaymentsMethod() {
    io.grpc.MethodDescriptor<com.traffic_tacos.payment.v1.ListPaymentsRequest, com.traffic_tacos.payment.v1.ListPaymentsResponse> getListPaymentsMethod;
    if ((getListPaymentsMethod = PaymentServiceGrpc.getListPaymentsMethod) == null) {
      synchronized (PaymentServiceGrpc.class) {
        if ((getListPaymentsMethod = PaymentServiceGrpc.getListPaymentsMethod) == null) {
          PaymentServiceGrpc.getListPaymentsMethod = getListPaymentsMethod =
              io.grpc.MethodDescriptor.<com.traffic_tacos.payment.v1.ListPaymentsRequest, com.traffic_tacos.payment.v1.ListPaymentsResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "ListPayments"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.traffic_tacos.payment.v1.ListPaymentsRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.traffic_tacos.payment.v1.ListPaymentsResponse.getDefaultInstance()))
              .setSchemaDescriptor(new PaymentServiceMethodDescriptorSupplier("ListPayments"))
              .build();
        }
      }
    }
    return getListPaymentsMethod;
  }

  private static volatile io.grpc.MethodDescriptor<com.traffic_tacos.payment.v1.SimulateWebhookRequest,
      com.traffic_tacos.payment.v1.SimulateWebhookResponse> getSimulateWebhookMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "SimulateWebhook",
      requestType = com.traffic_tacos.payment.v1.SimulateWebhookRequest.class,
      responseType = com.traffic_tacos.payment.v1.SimulateWebhookResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<com.traffic_tacos.payment.v1.SimulateWebhookRequest,
      com.traffic_tacos.payment.v1.SimulateWebhookResponse> getSimulateWebhookMethod() {
    io.grpc.MethodDescriptor<com.traffic_tacos.payment.v1.SimulateWebhookRequest, com.traffic_tacos.payment.v1.SimulateWebhookResponse> getSimulateWebhookMethod;
    if ((getSimulateWebhookMethod = PaymentServiceGrpc.getSimulateWebhookMethod) == null) {
      synchronized (PaymentServiceGrpc.class) {
        if ((getSimulateWebhookMethod = PaymentServiceGrpc.getSimulateWebhookMethod) == null) {
          PaymentServiceGrpc.getSimulateWebhookMethod = getSimulateWebhookMethod =
              io.grpc.MethodDescriptor.<com.traffic_tacos.payment.v1.SimulateWebhookRequest, com.traffic_tacos.payment.v1.SimulateWebhookResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "SimulateWebhook"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.traffic_tacos.payment.v1.SimulateWebhookRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.traffic_tacos.payment.v1.SimulateWebhookResponse.getDefaultInstance()))
              .setSchemaDescriptor(new PaymentServiceMethodDescriptorSupplier("SimulateWebhook"))
              .build();
        }
      }
    }
    return getSimulateWebhookMethod;
  }

  /**
   * Creates a new async stub that supports all call types for the service
   */
  public static PaymentServiceStub newStub(io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<PaymentServiceStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<PaymentServiceStub>() {
        @java.lang.Override
        public PaymentServiceStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new PaymentServiceStub(channel, callOptions);
        }
      };
    return PaymentServiceStub.newStub(factory, channel);
  }

  /**
   * Creates a new blocking-style stub that supports all types of calls on the service
   */
  public static PaymentServiceBlockingV2Stub newBlockingV2Stub(
      io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<PaymentServiceBlockingV2Stub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<PaymentServiceBlockingV2Stub>() {
        @java.lang.Override
        public PaymentServiceBlockingV2Stub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new PaymentServiceBlockingV2Stub(channel, callOptions);
        }
      };
    return PaymentServiceBlockingV2Stub.newStub(factory, channel);
  }

  /**
   * Creates a new blocking-style stub that supports unary and streaming output calls on the service
   */
  public static PaymentServiceBlockingStub newBlockingStub(
      io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<PaymentServiceBlockingStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<PaymentServiceBlockingStub>() {
        @java.lang.Override
        public PaymentServiceBlockingStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new PaymentServiceBlockingStub(channel, callOptions);
        }
      };
    return PaymentServiceBlockingStub.newStub(factory, channel);
  }

  /**
   * Creates a new ListenableFuture-style stub that supports unary calls on the service
   */
  public static PaymentServiceFutureStub newFutureStub(
      io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<PaymentServiceFutureStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<PaymentServiceFutureStub>() {
        @java.lang.Override
        public PaymentServiceFutureStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new PaymentServiceFutureStub(channel, callOptions);
        }
      };
    return PaymentServiceFutureStub.newStub(factory, channel);
  }

  /**
   * <pre>
   * Payment service simulates external payment processing
   * Supports various scenarios: approve, fail, delay, random
   * </pre>
   */
  public interface AsyncService {

    /**
     * <pre>
     * Create a payment intent for a reservation
     * </pre>
     */
    default void createPaymentIntent(com.traffic_tacos.payment.v1.CreatePaymentIntentRequest request,
        io.grpc.stub.StreamObserver<com.traffic_tacos.payment.v1.CreatePaymentIntentResponse> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getCreatePaymentIntentMethod(), responseObserver);
    }

    /**
     * <pre>
     * Process payment (simulate external payment gateway)
     * </pre>
     */
    default void processPayment(com.traffic_tacos.payment.v1.ProcessPaymentRequest request,
        io.grpc.stub.StreamObserver<com.traffic_tacos.payment.v1.ProcessPaymentResponse> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getProcessPaymentMethod(), responseObserver);
    }

    /**
     * <pre>
     * Get payment status
     * </pre>
     */
    default void getPaymentStatus(com.traffic_tacos.payment.v1.GetPaymentStatusRequest request,
        io.grpc.stub.StreamObserver<com.traffic_tacos.payment.v1.GetPaymentStatusResponse> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getGetPaymentStatusMethod(), responseObserver);
    }

    /**
     * <pre>
     * Cancel/refund payment
     * </pre>
     */
    default void cancelPayment(com.traffic_tacos.payment.v1.CancelPaymentRequest request,
        io.grpc.stub.StreamObserver<com.traffic_tacos.payment.v1.CancelPaymentResponse> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getCancelPaymentMethod(), responseObserver);
    }

    /**
     * <pre>
     * List payments for a user
     * </pre>
     */
    default void listPayments(com.traffic_tacos.payment.v1.ListPaymentsRequest request,
        io.grpc.stub.StreamObserver<com.traffic_tacos.payment.v1.ListPaymentsResponse> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getListPaymentsMethod(), responseObserver);
    }

    /**
     * <pre>
     * Webhook simulation endpoints
     * </pre>
     */
    default void simulateWebhook(com.traffic_tacos.payment.v1.SimulateWebhookRequest request,
        io.grpc.stub.StreamObserver<com.traffic_tacos.payment.v1.SimulateWebhookResponse> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getSimulateWebhookMethod(), responseObserver);
    }
  }

  /**
   * Base class for the server implementation of the service PaymentService.
   * <pre>
   * Payment service simulates external payment processing
   * Supports various scenarios: approve, fail, delay, random
   * </pre>
   */
  public static abstract class PaymentServiceImplBase
      implements io.grpc.BindableService, AsyncService {

    @java.lang.Override public final io.grpc.ServerServiceDefinition bindService() {
      return PaymentServiceGrpc.bindService(this);
    }
  }

  /**
   * A stub to allow clients to do asynchronous rpc calls to service PaymentService.
   * <pre>
   * Payment service simulates external payment processing
   * Supports various scenarios: approve, fail, delay, random
   * </pre>
   */
  public static final class PaymentServiceStub
      extends io.grpc.stub.AbstractAsyncStub<PaymentServiceStub> {
    private PaymentServiceStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected PaymentServiceStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new PaymentServiceStub(channel, callOptions);
    }

    /**
     * <pre>
     * Create a payment intent for a reservation
     * </pre>
     */
    public void createPaymentIntent(com.traffic_tacos.payment.v1.CreatePaymentIntentRequest request,
        io.grpc.stub.StreamObserver<com.traffic_tacos.payment.v1.CreatePaymentIntentResponse> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getCreatePaymentIntentMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     * <pre>
     * Process payment (simulate external payment gateway)
     * </pre>
     */
    public void processPayment(com.traffic_tacos.payment.v1.ProcessPaymentRequest request,
        io.grpc.stub.StreamObserver<com.traffic_tacos.payment.v1.ProcessPaymentResponse> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getProcessPaymentMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     * <pre>
     * Get payment status
     * </pre>
     */
    public void getPaymentStatus(com.traffic_tacos.payment.v1.GetPaymentStatusRequest request,
        io.grpc.stub.StreamObserver<com.traffic_tacos.payment.v1.GetPaymentStatusResponse> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getGetPaymentStatusMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     * <pre>
     * Cancel/refund payment
     * </pre>
     */
    public void cancelPayment(com.traffic_tacos.payment.v1.CancelPaymentRequest request,
        io.grpc.stub.StreamObserver<com.traffic_tacos.payment.v1.CancelPaymentResponse> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getCancelPaymentMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     * <pre>
     * List payments for a user
     * </pre>
     */
    public void listPayments(com.traffic_tacos.payment.v1.ListPaymentsRequest request,
        io.grpc.stub.StreamObserver<com.traffic_tacos.payment.v1.ListPaymentsResponse> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getListPaymentsMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     * <pre>
     * Webhook simulation endpoints
     * </pre>
     */
    public void simulateWebhook(com.traffic_tacos.payment.v1.SimulateWebhookRequest request,
        io.grpc.stub.StreamObserver<com.traffic_tacos.payment.v1.SimulateWebhookResponse> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getSimulateWebhookMethod(), getCallOptions()), request, responseObserver);
    }
  }

  /**
   * A stub to allow clients to do synchronous rpc calls to service PaymentService.
   * <pre>
   * Payment service simulates external payment processing
   * Supports various scenarios: approve, fail, delay, random
   * </pre>
   */
  public static final class PaymentServiceBlockingV2Stub
      extends io.grpc.stub.AbstractBlockingStub<PaymentServiceBlockingV2Stub> {
    private PaymentServiceBlockingV2Stub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected PaymentServiceBlockingV2Stub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new PaymentServiceBlockingV2Stub(channel, callOptions);
    }

    /**
     * <pre>
     * Create a payment intent for a reservation
     * </pre>
     */
    public com.traffic_tacos.payment.v1.CreatePaymentIntentResponse createPaymentIntent(com.traffic_tacos.payment.v1.CreatePaymentIntentRequest request) throws io.grpc.StatusException {
      return io.grpc.stub.ClientCalls.blockingV2UnaryCall(
          getChannel(), getCreatePaymentIntentMethod(), getCallOptions(), request);
    }

    /**
     * <pre>
     * Process payment (simulate external payment gateway)
     * </pre>
     */
    public com.traffic_tacos.payment.v1.ProcessPaymentResponse processPayment(com.traffic_tacos.payment.v1.ProcessPaymentRequest request) throws io.grpc.StatusException {
      return io.grpc.stub.ClientCalls.blockingV2UnaryCall(
          getChannel(), getProcessPaymentMethod(), getCallOptions(), request);
    }

    /**
     * <pre>
     * Get payment status
     * </pre>
     */
    public com.traffic_tacos.payment.v1.GetPaymentStatusResponse getPaymentStatus(com.traffic_tacos.payment.v1.GetPaymentStatusRequest request) throws io.grpc.StatusException {
      return io.grpc.stub.ClientCalls.blockingV2UnaryCall(
          getChannel(), getGetPaymentStatusMethod(), getCallOptions(), request);
    }

    /**
     * <pre>
     * Cancel/refund payment
     * </pre>
     */
    public com.traffic_tacos.payment.v1.CancelPaymentResponse cancelPayment(com.traffic_tacos.payment.v1.CancelPaymentRequest request) throws io.grpc.StatusException {
      return io.grpc.stub.ClientCalls.blockingV2UnaryCall(
          getChannel(), getCancelPaymentMethod(), getCallOptions(), request);
    }

    /**
     * <pre>
     * List payments for a user
     * </pre>
     */
    public com.traffic_tacos.payment.v1.ListPaymentsResponse listPayments(com.traffic_tacos.payment.v1.ListPaymentsRequest request) throws io.grpc.StatusException {
      return io.grpc.stub.ClientCalls.blockingV2UnaryCall(
          getChannel(), getListPaymentsMethod(), getCallOptions(), request);
    }

    /**
     * <pre>
     * Webhook simulation endpoints
     * </pre>
     */
    public com.traffic_tacos.payment.v1.SimulateWebhookResponse simulateWebhook(com.traffic_tacos.payment.v1.SimulateWebhookRequest request) throws io.grpc.StatusException {
      return io.grpc.stub.ClientCalls.blockingV2UnaryCall(
          getChannel(), getSimulateWebhookMethod(), getCallOptions(), request);
    }
  }

  /**
   * A stub to allow clients to do limited synchronous rpc calls to service PaymentService.
   * <pre>
   * Payment service simulates external payment processing
   * Supports various scenarios: approve, fail, delay, random
   * </pre>
   */
  public static final class PaymentServiceBlockingStub
      extends io.grpc.stub.AbstractBlockingStub<PaymentServiceBlockingStub> {
    private PaymentServiceBlockingStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected PaymentServiceBlockingStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new PaymentServiceBlockingStub(channel, callOptions);
    }

    /**
     * <pre>
     * Create a payment intent for a reservation
     * </pre>
     */
    public com.traffic_tacos.payment.v1.CreatePaymentIntentResponse createPaymentIntent(com.traffic_tacos.payment.v1.CreatePaymentIntentRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getCreatePaymentIntentMethod(), getCallOptions(), request);
    }

    /**
     * <pre>
     * Process payment (simulate external payment gateway)
     * </pre>
     */
    public com.traffic_tacos.payment.v1.ProcessPaymentResponse processPayment(com.traffic_tacos.payment.v1.ProcessPaymentRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getProcessPaymentMethod(), getCallOptions(), request);
    }

    /**
     * <pre>
     * Get payment status
     * </pre>
     */
    public com.traffic_tacos.payment.v1.GetPaymentStatusResponse getPaymentStatus(com.traffic_tacos.payment.v1.GetPaymentStatusRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getGetPaymentStatusMethod(), getCallOptions(), request);
    }

    /**
     * <pre>
     * Cancel/refund payment
     * </pre>
     */
    public com.traffic_tacos.payment.v1.CancelPaymentResponse cancelPayment(com.traffic_tacos.payment.v1.CancelPaymentRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getCancelPaymentMethod(), getCallOptions(), request);
    }

    /**
     * <pre>
     * List payments for a user
     * </pre>
     */
    public com.traffic_tacos.payment.v1.ListPaymentsResponse listPayments(com.traffic_tacos.payment.v1.ListPaymentsRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getListPaymentsMethod(), getCallOptions(), request);
    }

    /**
     * <pre>
     * Webhook simulation endpoints
     * </pre>
     */
    public com.traffic_tacos.payment.v1.SimulateWebhookResponse simulateWebhook(com.traffic_tacos.payment.v1.SimulateWebhookRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getSimulateWebhookMethod(), getCallOptions(), request);
    }
  }

  /**
   * A stub to allow clients to do ListenableFuture-style rpc calls to service PaymentService.
   * <pre>
   * Payment service simulates external payment processing
   * Supports various scenarios: approve, fail, delay, random
   * </pre>
   */
  public static final class PaymentServiceFutureStub
      extends io.grpc.stub.AbstractFutureStub<PaymentServiceFutureStub> {
    private PaymentServiceFutureStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected PaymentServiceFutureStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new PaymentServiceFutureStub(channel, callOptions);
    }

    /**
     * <pre>
     * Create a payment intent for a reservation
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.traffic_tacos.payment.v1.CreatePaymentIntentResponse> createPaymentIntent(
        com.traffic_tacos.payment.v1.CreatePaymentIntentRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getCreatePaymentIntentMethod(), getCallOptions()), request);
    }

    /**
     * <pre>
     * Process payment (simulate external payment gateway)
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.traffic_tacos.payment.v1.ProcessPaymentResponse> processPayment(
        com.traffic_tacos.payment.v1.ProcessPaymentRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getProcessPaymentMethod(), getCallOptions()), request);
    }

    /**
     * <pre>
     * Get payment status
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.traffic_tacos.payment.v1.GetPaymentStatusResponse> getPaymentStatus(
        com.traffic_tacos.payment.v1.GetPaymentStatusRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getGetPaymentStatusMethod(), getCallOptions()), request);
    }

    /**
     * <pre>
     * Cancel/refund payment
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.traffic_tacos.payment.v1.CancelPaymentResponse> cancelPayment(
        com.traffic_tacos.payment.v1.CancelPaymentRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getCancelPaymentMethod(), getCallOptions()), request);
    }

    /**
     * <pre>
     * List payments for a user
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.traffic_tacos.payment.v1.ListPaymentsResponse> listPayments(
        com.traffic_tacos.payment.v1.ListPaymentsRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getListPaymentsMethod(), getCallOptions()), request);
    }

    /**
     * <pre>
     * Webhook simulation endpoints
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.traffic_tacos.payment.v1.SimulateWebhookResponse> simulateWebhook(
        com.traffic_tacos.payment.v1.SimulateWebhookRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getSimulateWebhookMethod(), getCallOptions()), request);
    }
  }

  private static final int METHODID_CREATE_PAYMENT_INTENT = 0;
  private static final int METHODID_PROCESS_PAYMENT = 1;
  private static final int METHODID_GET_PAYMENT_STATUS = 2;
  private static final int METHODID_CANCEL_PAYMENT = 3;
  private static final int METHODID_LIST_PAYMENTS = 4;
  private static final int METHODID_SIMULATE_WEBHOOK = 5;

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
        case METHODID_CREATE_PAYMENT_INTENT:
          serviceImpl.createPaymentIntent((com.traffic_tacos.payment.v1.CreatePaymentIntentRequest) request,
              (io.grpc.stub.StreamObserver<com.traffic_tacos.payment.v1.CreatePaymentIntentResponse>) responseObserver);
          break;
        case METHODID_PROCESS_PAYMENT:
          serviceImpl.processPayment((com.traffic_tacos.payment.v1.ProcessPaymentRequest) request,
              (io.grpc.stub.StreamObserver<com.traffic_tacos.payment.v1.ProcessPaymentResponse>) responseObserver);
          break;
        case METHODID_GET_PAYMENT_STATUS:
          serviceImpl.getPaymentStatus((com.traffic_tacos.payment.v1.GetPaymentStatusRequest) request,
              (io.grpc.stub.StreamObserver<com.traffic_tacos.payment.v1.GetPaymentStatusResponse>) responseObserver);
          break;
        case METHODID_CANCEL_PAYMENT:
          serviceImpl.cancelPayment((com.traffic_tacos.payment.v1.CancelPaymentRequest) request,
              (io.grpc.stub.StreamObserver<com.traffic_tacos.payment.v1.CancelPaymentResponse>) responseObserver);
          break;
        case METHODID_LIST_PAYMENTS:
          serviceImpl.listPayments((com.traffic_tacos.payment.v1.ListPaymentsRequest) request,
              (io.grpc.stub.StreamObserver<com.traffic_tacos.payment.v1.ListPaymentsResponse>) responseObserver);
          break;
        case METHODID_SIMULATE_WEBHOOK:
          serviceImpl.simulateWebhook((com.traffic_tacos.payment.v1.SimulateWebhookRequest) request,
              (io.grpc.stub.StreamObserver<com.traffic_tacos.payment.v1.SimulateWebhookResponse>) responseObserver);
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
          getCreatePaymentIntentMethod(),
          io.grpc.stub.ServerCalls.asyncUnaryCall(
            new MethodHandlers<
              com.traffic_tacos.payment.v1.CreatePaymentIntentRequest,
              com.traffic_tacos.payment.v1.CreatePaymentIntentResponse>(
                service, METHODID_CREATE_PAYMENT_INTENT)))
        .addMethod(
          getProcessPaymentMethod(),
          io.grpc.stub.ServerCalls.asyncUnaryCall(
            new MethodHandlers<
              com.traffic_tacos.payment.v1.ProcessPaymentRequest,
              com.traffic_tacos.payment.v1.ProcessPaymentResponse>(
                service, METHODID_PROCESS_PAYMENT)))
        .addMethod(
          getGetPaymentStatusMethod(),
          io.grpc.stub.ServerCalls.asyncUnaryCall(
            new MethodHandlers<
              com.traffic_tacos.payment.v1.GetPaymentStatusRequest,
              com.traffic_tacos.payment.v1.GetPaymentStatusResponse>(
                service, METHODID_GET_PAYMENT_STATUS)))
        .addMethod(
          getCancelPaymentMethod(),
          io.grpc.stub.ServerCalls.asyncUnaryCall(
            new MethodHandlers<
              com.traffic_tacos.payment.v1.CancelPaymentRequest,
              com.traffic_tacos.payment.v1.CancelPaymentResponse>(
                service, METHODID_CANCEL_PAYMENT)))
        .addMethod(
          getListPaymentsMethod(),
          io.grpc.stub.ServerCalls.asyncUnaryCall(
            new MethodHandlers<
              com.traffic_tacos.payment.v1.ListPaymentsRequest,
              com.traffic_tacos.payment.v1.ListPaymentsResponse>(
                service, METHODID_LIST_PAYMENTS)))
        .addMethod(
          getSimulateWebhookMethod(),
          io.grpc.stub.ServerCalls.asyncUnaryCall(
            new MethodHandlers<
              com.traffic_tacos.payment.v1.SimulateWebhookRequest,
              com.traffic_tacos.payment.v1.SimulateWebhookResponse>(
                service, METHODID_SIMULATE_WEBHOOK)))
        .build();
  }

  private static abstract class PaymentServiceBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoFileDescriptorSupplier, io.grpc.protobuf.ProtoServiceDescriptorSupplier {
    PaymentServiceBaseDescriptorSupplier() {}

    @java.lang.Override
    public com.google.protobuf.Descriptors.FileDescriptor getFileDescriptor() {
      return com.traffic_tacos.payment.v1.PaymentProto.getDescriptor();
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.ServiceDescriptor getServiceDescriptor() {
      return getFileDescriptor().findServiceByName("PaymentService");
    }
  }

  private static final class PaymentServiceFileDescriptorSupplier
      extends PaymentServiceBaseDescriptorSupplier {
    PaymentServiceFileDescriptorSupplier() {}
  }

  private static final class PaymentServiceMethodDescriptorSupplier
      extends PaymentServiceBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoMethodDescriptorSupplier {
    private final java.lang.String methodName;

    PaymentServiceMethodDescriptorSupplier(java.lang.String methodName) {
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
      synchronized (PaymentServiceGrpc.class) {
        result = serviceDescriptor;
        if (result == null) {
          serviceDescriptor = result = io.grpc.ServiceDescriptor.newBuilder(SERVICE_NAME)
              .setSchemaDescriptor(new PaymentServiceFileDescriptorSupplier())
              .addMethod(getCreatePaymentIntentMethod())
              .addMethod(getProcessPaymentMethod())
              .addMethod(getGetPaymentStatusMethod())
              .addMethod(getCancelPaymentMethod())
              .addMethod(getListPaymentsMethod())
              .addMethod(getSimulateWebhookMethod())
              .build();
        }
      }
    }
    return result;
  }
}

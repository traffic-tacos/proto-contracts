package com.traffic_tacos.reservation.v1;

import static io.grpc.MethodDescriptor.generateFullMethodName;

/**
 * <pre>
 * Reservation service manages the ticket reservation lifecycle
 * Handles 60-second holds, EventBridge integration, and idempotency
 * </pre>
 */
@io.grpc.stub.annotations.GrpcGenerated
public final class ReservationServiceGrpc {

  private ReservationServiceGrpc() {}

  public static final java.lang.String SERVICE_NAME = "reservation.v1.ReservationService";

  // Static method descriptors that strictly reflect the proto.
  private static volatile io.grpc.MethodDescriptor<com.traffic_tacos.reservation.v1.CreateReservationRequest,
      com.traffic_tacos.reservation.v1.CreateReservationResponse> getCreateReservationMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "CreateReservation",
      requestType = com.traffic_tacos.reservation.v1.CreateReservationRequest.class,
      responseType = com.traffic_tacos.reservation.v1.CreateReservationResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<com.traffic_tacos.reservation.v1.CreateReservationRequest,
      com.traffic_tacos.reservation.v1.CreateReservationResponse> getCreateReservationMethod() {
    io.grpc.MethodDescriptor<com.traffic_tacos.reservation.v1.CreateReservationRequest, com.traffic_tacos.reservation.v1.CreateReservationResponse> getCreateReservationMethod;
    if ((getCreateReservationMethod = ReservationServiceGrpc.getCreateReservationMethod) == null) {
      synchronized (ReservationServiceGrpc.class) {
        if ((getCreateReservationMethod = ReservationServiceGrpc.getCreateReservationMethod) == null) {
          ReservationServiceGrpc.getCreateReservationMethod = getCreateReservationMethod =
              io.grpc.MethodDescriptor.<com.traffic_tacos.reservation.v1.CreateReservationRequest, com.traffic_tacos.reservation.v1.CreateReservationResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "CreateReservation"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.traffic_tacos.reservation.v1.CreateReservationRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.traffic_tacos.reservation.v1.CreateReservationResponse.getDefaultInstance()))
              .setSchemaDescriptor(new ReservationServiceMethodDescriptorSupplier("CreateReservation"))
              .build();
        }
      }
    }
    return getCreateReservationMethod;
  }

  private static volatile io.grpc.MethodDescriptor<com.traffic_tacos.reservation.v1.GetReservationRequest,
      com.traffic_tacos.reservation.v1.GetReservationResponse> getGetReservationMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "GetReservation",
      requestType = com.traffic_tacos.reservation.v1.GetReservationRequest.class,
      responseType = com.traffic_tacos.reservation.v1.GetReservationResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<com.traffic_tacos.reservation.v1.GetReservationRequest,
      com.traffic_tacos.reservation.v1.GetReservationResponse> getGetReservationMethod() {
    io.grpc.MethodDescriptor<com.traffic_tacos.reservation.v1.GetReservationRequest, com.traffic_tacos.reservation.v1.GetReservationResponse> getGetReservationMethod;
    if ((getGetReservationMethod = ReservationServiceGrpc.getGetReservationMethod) == null) {
      synchronized (ReservationServiceGrpc.class) {
        if ((getGetReservationMethod = ReservationServiceGrpc.getGetReservationMethod) == null) {
          ReservationServiceGrpc.getGetReservationMethod = getGetReservationMethod =
              io.grpc.MethodDescriptor.<com.traffic_tacos.reservation.v1.GetReservationRequest, com.traffic_tacos.reservation.v1.GetReservationResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "GetReservation"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.traffic_tacos.reservation.v1.GetReservationRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.traffic_tacos.reservation.v1.GetReservationResponse.getDefaultInstance()))
              .setSchemaDescriptor(new ReservationServiceMethodDescriptorSupplier("GetReservation"))
              .build();
        }
      }
    }
    return getGetReservationMethod;
  }

  private static volatile io.grpc.MethodDescriptor<com.traffic_tacos.reservation.v1.ConfirmReservationRequest,
      com.traffic_tacos.reservation.v1.ConfirmReservationResponse> getConfirmReservationMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "ConfirmReservation",
      requestType = com.traffic_tacos.reservation.v1.ConfirmReservationRequest.class,
      responseType = com.traffic_tacos.reservation.v1.ConfirmReservationResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<com.traffic_tacos.reservation.v1.ConfirmReservationRequest,
      com.traffic_tacos.reservation.v1.ConfirmReservationResponse> getConfirmReservationMethod() {
    io.grpc.MethodDescriptor<com.traffic_tacos.reservation.v1.ConfirmReservationRequest, com.traffic_tacos.reservation.v1.ConfirmReservationResponse> getConfirmReservationMethod;
    if ((getConfirmReservationMethod = ReservationServiceGrpc.getConfirmReservationMethod) == null) {
      synchronized (ReservationServiceGrpc.class) {
        if ((getConfirmReservationMethod = ReservationServiceGrpc.getConfirmReservationMethod) == null) {
          ReservationServiceGrpc.getConfirmReservationMethod = getConfirmReservationMethod =
              io.grpc.MethodDescriptor.<com.traffic_tacos.reservation.v1.ConfirmReservationRequest, com.traffic_tacos.reservation.v1.ConfirmReservationResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "ConfirmReservation"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.traffic_tacos.reservation.v1.ConfirmReservationRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.traffic_tacos.reservation.v1.ConfirmReservationResponse.getDefaultInstance()))
              .setSchemaDescriptor(new ReservationServiceMethodDescriptorSupplier("ConfirmReservation"))
              .build();
        }
      }
    }
    return getConfirmReservationMethod;
  }

  private static volatile io.grpc.MethodDescriptor<com.traffic_tacos.reservation.v1.CancelReservationRequest,
      com.traffic_tacos.reservation.v1.CancelReservationResponse> getCancelReservationMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "CancelReservation",
      requestType = com.traffic_tacos.reservation.v1.CancelReservationRequest.class,
      responseType = com.traffic_tacos.reservation.v1.CancelReservationResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<com.traffic_tacos.reservation.v1.CancelReservationRequest,
      com.traffic_tacos.reservation.v1.CancelReservationResponse> getCancelReservationMethod() {
    io.grpc.MethodDescriptor<com.traffic_tacos.reservation.v1.CancelReservationRequest, com.traffic_tacos.reservation.v1.CancelReservationResponse> getCancelReservationMethod;
    if ((getCancelReservationMethod = ReservationServiceGrpc.getCancelReservationMethod) == null) {
      synchronized (ReservationServiceGrpc.class) {
        if ((getCancelReservationMethod = ReservationServiceGrpc.getCancelReservationMethod) == null) {
          ReservationServiceGrpc.getCancelReservationMethod = getCancelReservationMethod =
              io.grpc.MethodDescriptor.<com.traffic_tacos.reservation.v1.CancelReservationRequest, com.traffic_tacos.reservation.v1.CancelReservationResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "CancelReservation"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.traffic_tacos.reservation.v1.CancelReservationRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.traffic_tacos.reservation.v1.CancelReservationResponse.getDefaultInstance()))
              .setSchemaDescriptor(new ReservationServiceMethodDescriptorSupplier("CancelReservation"))
              .build();
        }
      }
    }
    return getCancelReservationMethod;
  }

  private static volatile io.grpc.MethodDescriptor<com.traffic_tacos.reservation.v1.ListReservationsRequest,
      com.traffic_tacos.reservation.v1.ListReservationsResponse> getListReservationsMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "ListReservations",
      requestType = com.traffic_tacos.reservation.v1.ListReservationsRequest.class,
      responseType = com.traffic_tacos.reservation.v1.ListReservationsResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<com.traffic_tacos.reservation.v1.ListReservationsRequest,
      com.traffic_tacos.reservation.v1.ListReservationsResponse> getListReservationsMethod() {
    io.grpc.MethodDescriptor<com.traffic_tacos.reservation.v1.ListReservationsRequest, com.traffic_tacos.reservation.v1.ListReservationsResponse> getListReservationsMethod;
    if ((getListReservationsMethod = ReservationServiceGrpc.getListReservationsMethod) == null) {
      synchronized (ReservationServiceGrpc.class) {
        if ((getListReservationsMethod = ReservationServiceGrpc.getListReservationsMethod) == null) {
          ReservationServiceGrpc.getListReservationsMethod = getListReservationsMethod =
              io.grpc.MethodDescriptor.<com.traffic_tacos.reservation.v1.ListReservationsRequest, com.traffic_tacos.reservation.v1.ListReservationsResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "ListReservations"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.traffic_tacos.reservation.v1.ListReservationsRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.traffic_tacos.reservation.v1.ListReservationsResponse.getDefaultInstance()))
              .setSchemaDescriptor(new ReservationServiceMethodDescriptorSupplier("ListReservations"))
              .build();
        }
      }
    }
    return getListReservationsMethod;
  }

  private static volatile io.grpc.MethodDescriptor<com.traffic_tacos.reservation.v1.ExtendHoldRequest,
      com.traffic_tacos.reservation.v1.ExtendHoldResponse> getExtendHoldMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "ExtendHold",
      requestType = com.traffic_tacos.reservation.v1.ExtendHoldRequest.class,
      responseType = com.traffic_tacos.reservation.v1.ExtendHoldResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<com.traffic_tacos.reservation.v1.ExtendHoldRequest,
      com.traffic_tacos.reservation.v1.ExtendHoldResponse> getExtendHoldMethod() {
    io.grpc.MethodDescriptor<com.traffic_tacos.reservation.v1.ExtendHoldRequest, com.traffic_tacos.reservation.v1.ExtendHoldResponse> getExtendHoldMethod;
    if ((getExtendHoldMethod = ReservationServiceGrpc.getExtendHoldMethod) == null) {
      synchronized (ReservationServiceGrpc.class) {
        if ((getExtendHoldMethod = ReservationServiceGrpc.getExtendHoldMethod) == null) {
          ReservationServiceGrpc.getExtendHoldMethod = getExtendHoldMethod =
              io.grpc.MethodDescriptor.<com.traffic_tacos.reservation.v1.ExtendHoldRequest, com.traffic_tacos.reservation.v1.ExtendHoldResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "ExtendHold"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.traffic_tacos.reservation.v1.ExtendHoldRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.traffic_tacos.reservation.v1.ExtendHoldResponse.getDefaultInstance()))
              .setSchemaDescriptor(new ReservationServiceMethodDescriptorSupplier("ExtendHold"))
              .build();
        }
      }
    }
    return getExtendHoldMethod;
  }

  /**
   * Creates a new async stub that supports all call types for the service
   */
  public static ReservationServiceStub newStub(io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<ReservationServiceStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<ReservationServiceStub>() {
        @java.lang.Override
        public ReservationServiceStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new ReservationServiceStub(channel, callOptions);
        }
      };
    return ReservationServiceStub.newStub(factory, channel);
  }

  /**
   * Creates a new blocking-style stub that supports all types of calls on the service
   */
  public static ReservationServiceBlockingV2Stub newBlockingV2Stub(
      io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<ReservationServiceBlockingV2Stub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<ReservationServiceBlockingV2Stub>() {
        @java.lang.Override
        public ReservationServiceBlockingV2Stub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new ReservationServiceBlockingV2Stub(channel, callOptions);
        }
      };
    return ReservationServiceBlockingV2Stub.newStub(factory, channel);
  }

  /**
   * Creates a new blocking-style stub that supports unary and streaming output calls on the service
   */
  public static ReservationServiceBlockingStub newBlockingStub(
      io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<ReservationServiceBlockingStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<ReservationServiceBlockingStub>() {
        @java.lang.Override
        public ReservationServiceBlockingStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new ReservationServiceBlockingStub(channel, callOptions);
        }
      };
    return ReservationServiceBlockingStub.newStub(factory, channel);
  }

  /**
   * Creates a new ListenableFuture-style stub that supports unary calls on the service
   */
  public static ReservationServiceFutureStub newFutureStub(
      io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<ReservationServiceFutureStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<ReservationServiceFutureStub>() {
        @java.lang.Override
        public ReservationServiceFutureStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new ReservationServiceFutureStub(channel, callOptions);
        }
      };
    return ReservationServiceFutureStub.newStub(factory, channel);
  }

  /**
   * <pre>
   * Reservation service manages the ticket reservation lifecycle
   * Handles 60-second holds, EventBridge integration, and idempotency
   * </pre>
   */
  public interface AsyncService {

    /**
     * <pre>
     * Create a new reservation with temporary hold (60 seconds)
     * </pre>
     */
    default void createReservation(com.traffic_tacos.reservation.v1.CreateReservationRequest request,
        io.grpc.stub.StreamObserver<com.traffic_tacos.reservation.v1.CreateReservationResponse> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getCreateReservationMethod(), responseObserver);
    }

    /**
     * <pre>
     * Get reservation details
     * </pre>
     */
    default void getReservation(com.traffic_tacos.reservation.v1.GetReservationRequest request,
        io.grpc.stub.StreamObserver<com.traffic_tacos.reservation.v1.GetReservationResponse> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getGetReservationMethod(), responseObserver);
    }

    /**
     * <pre>
     * Confirm reservation after payment approval
     * </pre>
     */
    default void confirmReservation(com.traffic_tacos.reservation.v1.ConfirmReservationRequest request,
        io.grpc.stub.StreamObserver<com.traffic_tacos.reservation.v1.ConfirmReservationResponse> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getConfirmReservationMethod(), responseObserver);
    }

    /**
     * <pre>
     * Cancel reservation and release seats
     * </pre>
     */
    default void cancelReservation(com.traffic_tacos.reservation.v1.CancelReservationRequest request,
        io.grpc.stub.StreamObserver<com.traffic_tacos.reservation.v1.CancelReservationResponse> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getCancelReservationMethod(), responseObserver);
    }

    /**
     * <pre>
     * List user's reservations
     * </pre>
     */
    default void listReservations(com.traffic_tacos.reservation.v1.ListReservationsRequest request,
        io.grpc.stub.StreamObserver<com.traffic_tacos.reservation.v1.ListReservationsResponse> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getListReservationsMethod(), responseObserver);
    }

    /**
     * <pre>
     * Extend reservation hold (if allowed)
     * </pre>
     */
    default void extendHold(com.traffic_tacos.reservation.v1.ExtendHoldRequest request,
        io.grpc.stub.StreamObserver<com.traffic_tacos.reservation.v1.ExtendHoldResponse> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getExtendHoldMethod(), responseObserver);
    }
  }

  /**
   * Base class for the server implementation of the service ReservationService.
   * <pre>
   * Reservation service manages the ticket reservation lifecycle
   * Handles 60-second holds, EventBridge integration, and idempotency
   * </pre>
   */
  public static abstract class ReservationServiceImplBase
      implements io.grpc.BindableService, AsyncService {

    @java.lang.Override public final io.grpc.ServerServiceDefinition bindService() {
      return ReservationServiceGrpc.bindService(this);
    }
  }

  /**
   * A stub to allow clients to do asynchronous rpc calls to service ReservationService.
   * <pre>
   * Reservation service manages the ticket reservation lifecycle
   * Handles 60-second holds, EventBridge integration, and idempotency
   * </pre>
   */
  public static final class ReservationServiceStub
      extends io.grpc.stub.AbstractAsyncStub<ReservationServiceStub> {
    private ReservationServiceStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected ReservationServiceStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new ReservationServiceStub(channel, callOptions);
    }

    /**
     * <pre>
     * Create a new reservation with temporary hold (60 seconds)
     * </pre>
     */
    public void createReservation(com.traffic_tacos.reservation.v1.CreateReservationRequest request,
        io.grpc.stub.StreamObserver<com.traffic_tacos.reservation.v1.CreateReservationResponse> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getCreateReservationMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     * <pre>
     * Get reservation details
     * </pre>
     */
    public void getReservation(com.traffic_tacos.reservation.v1.GetReservationRequest request,
        io.grpc.stub.StreamObserver<com.traffic_tacos.reservation.v1.GetReservationResponse> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getGetReservationMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     * <pre>
     * Confirm reservation after payment approval
     * </pre>
     */
    public void confirmReservation(com.traffic_tacos.reservation.v1.ConfirmReservationRequest request,
        io.grpc.stub.StreamObserver<com.traffic_tacos.reservation.v1.ConfirmReservationResponse> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getConfirmReservationMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     * <pre>
     * Cancel reservation and release seats
     * </pre>
     */
    public void cancelReservation(com.traffic_tacos.reservation.v1.CancelReservationRequest request,
        io.grpc.stub.StreamObserver<com.traffic_tacos.reservation.v1.CancelReservationResponse> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getCancelReservationMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     * <pre>
     * List user's reservations
     * </pre>
     */
    public void listReservations(com.traffic_tacos.reservation.v1.ListReservationsRequest request,
        io.grpc.stub.StreamObserver<com.traffic_tacos.reservation.v1.ListReservationsResponse> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getListReservationsMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     * <pre>
     * Extend reservation hold (if allowed)
     * </pre>
     */
    public void extendHold(com.traffic_tacos.reservation.v1.ExtendHoldRequest request,
        io.grpc.stub.StreamObserver<com.traffic_tacos.reservation.v1.ExtendHoldResponse> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getExtendHoldMethod(), getCallOptions()), request, responseObserver);
    }
  }

  /**
   * A stub to allow clients to do synchronous rpc calls to service ReservationService.
   * <pre>
   * Reservation service manages the ticket reservation lifecycle
   * Handles 60-second holds, EventBridge integration, and idempotency
   * </pre>
   */
  public static final class ReservationServiceBlockingV2Stub
      extends io.grpc.stub.AbstractBlockingStub<ReservationServiceBlockingV2Stub> {
    private ReservationServiceBlockingV2Stub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected ReservationServiceBlockingV2Stub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new ReservationServiceBlockingV2Stub(channel, callOptions);
    }

    /**
     * <pre>
     * Create a new reservation with temporary hold (60 seconds)
     * </pre>
     */
    public com.traffic_tacos.reservation.v1.CreateReservationResponse createReservation(com.traffic_tacos.reservation.v1.CreateReservationRequest request) throws io.grpc.StatusException {
      return io.grpc.stub.ClientCalls.blockingV2UnaryCall(
          getChannel(), getCreateReservationMethod(), getCallOptions(), request);
    }

    /**
     * <pre>
     * Get reservation details
     * </pre>
     */
    public com.traffic_tacos.reservation.v1.GetReservationResponse getReservation(com.traffic_tacos.reservation.v1.GetReservationRequest request) throws io.grpc.StatusException {
      return io.grpc.stub.ClientCalls.blockingV2UnaryCall(
          getChannel(), getGetReservationMethod(), getCallOptions(), request);
    }

    /**
     * <pre>
     * Confirm reservation after payment approval
     * </pre>
     */
    public com.traffic_tacos.reservation.v1.ConfirmReservationResponse confirmReservation(com.traffic_tacos.reservation.v1.ConfirmReservationRequest request) throws io.grpc.StatusException {
      return io.grpc.stub.ClientCalls.blockingV2UnaryCall(
          getChannel(), getConfirmReservationMethod(), getCallOptions(), request);
    }

    /**
     * <pre>
     * Cancel reservation and release seats
     * </pre>
     */
    public com.traffic_tacos.reservation.v1.CancelReservationResponse cancelReservation(com.traffic_tacos.reservation.v1.CancelReservationRequest request) throws io.grpc.StatusException {
      return io.grpc.stub.ClientCalls.blockingV2UnaryCall(
          getChannel(), getCancelReservationMethod(), getCallOptions(), request);
    }

    /**
     * <pre>
     * List user's reservations
     * </pre>
     */
    public com.traffic_tacos.reservation.v1.ListReservationsResponse listReservations(com.traffic_tacos.reservation.v1.ListReservationsRequest request) throws io.grpc.StatusException {
      return io.grpc.stub.ClientCalls.blockingV2UnaryCall(
          getChannel(), getListReservationsMethod(), getCallOptions(), request);
    }

    /**
     * <pre>
     * Extend reservation hold (if allowed)
     * </pre>
     */
    public com.traffic_tacos.reservation.v1.ExtendHoldResponse extendHold(com.traffic_tacos.reservation.v1.ExtendHoldRequest request) throws io.grpc.StatusException {
      return io.grpc.stub.ClientCalls.blockingV2UnaryCall(
          getChannel(), getExtendHoldMethod(), getCallOptions(), request);
    }
  }

  /**
   * A stub to allow clients to do limited synchronous rpc calls to service ReservationService.
   * <pre>
   * Reservation service manages the ticket reservation lifecycle
   * Handles 60-second holds, EventBridge integration, and idempotency
   * </pre>
   */
  public static final class ReservationServiceBlockingStub
      extends io.grpc.stub.AbstractBlockingStub<ReservationServiceBlockingStub> {
    private ReservationServiceBlockingStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected ReservationServiceBlockingStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new ReservationServiceBlockingStub(channel, callOptions);
    }

    /**
     * <pre>
     * Create a new reservation with temporary hold (60 seconds)
     * </pre>
     */
    public com.traffic_tacos.reservation.v1.CreateReservationResponse createReservation(com.traffic_tacos.reservation.v1.CreateReservationRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getCreateReservationMethod(), getCallOptions(), request);
    }

    /**
     * <pre>
     * Get reservation details
     * </pre>
     */
    public com.traffic_tacos.reservation.v1.GetReservationResponse getReservation(com.traffic_tacos.reservation.v1.GetReservationRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getGetReservationMethod(), getCallOptions(), request);
    }

    /**
     * <pre>
     * Confirm reservation after payment approval
     * </pre>
     */
    public com.traffic_tacos.reservation.v1.ConfirmReservationResponse confirmReservation(com.traffic_tacos.reservation.v1.ConfirmReservationRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getConfirmReservationMethod(), getCallOptions(), request);
    }

    /**
     * <pre>
     * Cancel reservation and release seats
     * </pre>
     */
    public com.traffic_tacos.reservation.v1.CancelReservationResponse cancelReservation(com.traffic_tacos.reservation.v1.CancelReservationRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getCancelReservationMethod(), getCallOptions(), request);
    }

    /**
     * <pre>
     * List user's reservations
     * </pre>
     */
    public com.traffic_tacos.reservation.v1.ListReservationsResponse listReservations(com.traffic_tacos.reservation.v1.ListReservationsRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getListReservationsMethod(), getCallOptions(), request);
    }

    /**
     * <pre>
     * Extend reservation hold (if allowed)
     * </pre>
     */
    public com.traffic_tacos.reservation.v1.ExtendHoldResponse extendHold(com.traffic_tacos.reservation.v1.ExtendHoldRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getExtendHoldMethod(), getCallOptions(), request);
    }
  }

  /**
   * A stub to allow clients to do ListenableFuture-style rpc calls to service ReservationService.
   * <pre>
   * Reservation service manages the ticket reservation lifecycle
   * Handles 60-second holds, EventBridge integration, and idempotency
   * </pre>
   */
  public static final class ReservationServiceFutureStub
      extends io.grpc.stub.AbstractFutureStub<ReservationServiceFutureStub> {
    private ReservationServiceFutureStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected ReservationServiceFutureStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new ReservationServiceFutureStub(channel, callOptions);
    }

    /**
     * <pre>
     * Create a new reservation with temporary hold (60 seconds)
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.traffic_tacos.reservation.v1.CreateReservationResponse> createReservation(
        com.traffic_tacos.reservation.v1.CreateReservationRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getCreateReservationMethod(), getCallOptions()), request);
    }

    /**
     * <pre>
     * Get reservation details
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.traffic_tacos.reservation.v1.GetReservationResponse> getReservation(
        com.traffic_tacos.reservation.v1.GetReservationRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getGetReservationMethod(), getCallOptions()), request);
    }

    /**
     * <pre>
     * Confirm reservation after payment approval
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.traffic_tacos.reservation.v1.ConfirmReservationResponse> confirmReservation(
        com.traffic_tacos.reservation.v1.ConfirmReservationRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getConfirmReservationMethod(), getCallOptions()), request);
    }

    /**
     * <pre>
     * Cancel reservation and release seats
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.traffic_tacos.reservation.v1.CancelReservationResponse> cancelReservation(
        com.traffic_tacos.reservation.v1.CancelReservationRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getCancelReservationMethod(), getCallOptions()), request);
    }

    /**
     * <pre>
     * List user's reservations
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.traffic_tacos.reservation.v1.ListReservationsResponse> listReservations(
        com.traffic_tacos.reservation.v1.ListReservationsRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getListReservationsMethod(), getCallOptions()), request);
    }

    /**
     * <pre>
     * Extend reservation hold (if allowed)
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.traffic_tacos.reservation.v1.ExtendHoldResponse> extendHold(
        com.traffic_tacos.reservation.v1.ExtendHoldRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getExtendHoldMethod(), getCallOptions()), request);
    }
  }

  private static final int METHODID_CREATE_RESERVATION = 0;
  private static final int METHODID_GET_RESERVATION = 1;
  private static final int METHODID_CONFIRM_RESERVATION = 2;
  private static final int METHODID_CANCEL_RESERVATION = 3;
  private static final int METHODID_LIST_RESERVATIONS = 4;
  private static final int METHODID_EXTEND_HOLD = 5;

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
        case METHODID_CREATE_RESERVATION:
          serviceImpl.createReservation((com.traffic_tacos.reservation.v1.CreateReservationRequest) request,
              (io.grpc.stub.StreamObserver<com.traffic_tacos.reservation.v1.CreateReservationResponse>) responseObserver);
          break;
        case METHODID_GET_RESERVATION:
          serviceImpl.getReservation((com.traffic_tacos.reservation.v1.GetReservationRequest) request,
              (io.grpc.stub.StreamObserver<com.traffic_tacos.reservation.v1.GetReservationResponse>) responseObserver);
          break;
        case METHODID_CONFIRM_RESERVATION:
          serviceImpl.confirmReservation((com.traffic_tacos.reservation.v1.ConfirmReservationRequest) request,
              (io.grpc.stub.StreamObserver<com.traffic_tacos.reservation.v1.ConfirmReservationResponse>) responseObserver);
          break;
        case METHODID_CANCEL_RESERVATION:
          serviceImpl.cancelReservation((com.traffic_tacos.reservation.v1.CancelReservationRequest) request,
              (io.grpc.stub.StreamObserver<com.traffic_tacos.reservation.v1.CancelReservationResponse>) responseObserver);
          break;
        case METHODID_LIST_RESERVATIONS:
          serviceImpl.listReservations((com.traffic_tacos.reservation.v1.ListReservationsRequest) request,
              (io.grpc.stub.StreamObserver<com.traffic_tacos.reservation.v1.ListReservationsResponse>) responseObserver);
          break;
        case METHODID_EXTEND_HOLD:
          serviceImpl.extendHold((com.traffic_tacos.reservation.v1.ExtendHoldRequest) request,
              (io.grpc.stub.StreamObserver<com.traffic_tacos.reservation.v1.ExtendHoldResponse>) responseObserver);
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
          getCreateReservationMethod(),
          io.grpc.stub.ServerCalls.asyncUnaryCall(
            new MethodHandlers<
              com.traffic_tacos.reservation.v1.CreateReservationRequest,
              com.traffic_tacos.reservation.v1.CreateReservationResponse>(
                service, METHODID_CREATE_RESERVATION)))
        .addMethod(
          getGetReservationMethod(),
          io.grpc.stub.ServerCalls.asyncUnaryCall(
            new MethodHandlers<
              com.traffic_tacos.reservation.v1.GetReservationRequest,
              com.traffic_tacos.reservation.v1.GetReservationResponse>(
                service, METHODID_GET_RESERVATION)))
        .addMethod(
          getConfirmReservationMethod(),
          io.grpc.stub.ServerCalls.asyncUnaryCall(
            new MethodHandlers<
              com.traffic_tacos.reservation.v1.ConfirmReservationRequest,
              com.traffic_tacos.reservation.v1.ConfirmReservationResponse>(
                service, METHODID_CONFIRM_RESERVATION)))
        .addMethod(
          getCancelReservationMethod(),
          io.grpc.stub.ServerCalls.asyncUnaryCall(
            new MethodHandlers<
              com.traffic_tacos.reservation.v1.CancelReservationRequest,
              com.traffic_tacos.reservation.v1.CancelReservationResponse>(
                service, METHODID_CANCEL_RESERVATION)))
        .addMethod(
          getListReservationsMethod(),
          io.grpc.stub.ServerCalls.asyncUnaryCall(
            new MethodHandlers<
              com.traffic_tacos.reservation.v1.ListReservationsRequest,
              com.traffic_tacos.reservation.v1.ListReservationsResponse>(
                service, METHODID_LIST_RESERVATIONS)))
        .addMethod(
          getExtendHoldMethod(),
          io.grpc.stub.ServerCalls.asyncUnaryCall(
            new MethodHandlers<
              com.traffic_tacos.reservation.v1.ExtendHoldRequest,
              com.traffic_tacos.reservation.v1.ExtendHoldResponse>(
                service, METHODID_EXTEND_HOLD)))
        .build();
  }

  private static abstract class ReservationServiceBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoFileDescriptorSupplier, io.grpc.protobuf.ProtoServiceDescriptorSupplier {
    ReservationServiceBaseDescriptorSupplier() {}

    @java.lang.Override
    public com.google.protobuf.Descriptors.FileDescriptor getFileDescriptor() {
      return com.traffic_tacos.reservation.v1.ReservationProto.getDescriptor();
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.ServiceDescriptor getServiceDescriptor() {
      return getFileDescriptor().findServiceByName("ReservationService");
    }
  }

  private static final class ReservationServiceFileDescriptorSupplier
      extends ReservationServiceBaseDescriptorSupplier {
    ReservationServiceFileDescriptorSupplier() {}
  }

  private static final class ReservationServiceMethodDescriptorSupplier
      extends ReservationServiceBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoMethodDescriptorSupplier {
    private final java.lang.String methodName;

    ReservationServiceMethodDescriptorSupplier(java.lang.String methodName) {
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
      synchronized (ReservationServiceGrpc.class) {
        result = serviceDescriptor;
        if (result == null) {
          serviceDescriptor = result = io.grpc.ServiceDescriptor.newBuilder(SERVICE_NAME)
              .setSchemaDescriptor(new ReservationServiceFileDescriptorSupplier())
              .addMethod(getCreateReservationMethod())
              .addMethod(getGetReservationMethod())
              .addMethod(getConfirmReservationMethod())
              .addMethod(getCancelReservationMethod())
              .addMethod(getListReservationsMethod())
              .addMethod(getExtendHoldMethod())
              .build();
        }
      }
    }
    return result;
  }
}

package com.traffic_tacos.reservation.v1;

import static io.grpc.MethodDescriptor.generateFullMethodName;

/**
 * <pre>
 * Inventory service manages seat availability and reservations
 * This service ensures zero overselling through DynamoDB conditional updates
 * </pre>
 */
@io.grpc.stub.annotations.GrpcGenerated
public final class InventoryServiceGrpc {

  private InventoryServiceGrpc() {}

  public static final java.lang.String SERVICE_NAME = "reservation.v1.InventoryService";

  // Static method descriptors that strictly reflect the proto.
  private static volatile io.grpc.MethodDescriptor<com.traffic_tacos.reservation.v1.CheckAvailabilityRequest,
      com.traffic_tacos.reservation.v1.CheckAvailabilityResponse> getCheckAvailabilityMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "CheckAvailability",
      requestType = com.traffic_tacos.reservation.v1.CheckAvailabilityRequest.class,
      responseType = com.traffic_tacos.reservation.v1.CheckAvailabilityResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<com.traffic_tacos.reservation.v1.CheckAvailabilityRequest,
      com.traffic_tacos.reservation.v1.CheckAvailabilityResponse> getCheckAvailabilityMethod() {
    io.grpc.MethodDescriptor<com.traffic_tacos.reservation.v1.CheckAvailabilityRequest, com.traffic_tacos.reservation.v1.CheckAvailabilityResponse> getCheckAvailabilityMethod;
    if ((getCheckAvailabilityMethod = InventoryServiceGrpc.getCheckAvailabilityMethod) == null) {
      synchronized (InventoryServiceGrpc.class) {
        if ((getCheckAvailabilityMethod = InventoryServiceGrpc.getCheckAvailabilityMethod) == null) {
          InventoryServiceGrpc.getCheckAvailabilityMethod = getCheckAvailabilityMethod =
              io.grpc.MethodDescriptor.<com.traffic_tacos.reservation.v1.CheckAvailabilityRequest, com.traffic_tacos.reservation.v1.CheckAvailabilityResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "CheckAvailability"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.traffic_tacos.reservation.v1.CheckAvailabilityRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.traffic_tacos.reservation.v1.CheckAvailabilityResponse.getDefaultInstance()))
              .setSchemaDescriptor(new InventoryServiceMethodDescriptorSupplier("CheckAvailability"))
              .build();
        }
      }
    }
    return getCheckAvailabilityMethod;
  }

  private static volatile io.grpc.MethodDescriptor<com.traffic_tacos.reservation.v1.ReserveSeatRequest,
      com.traffic_tacos.reservation.v1.ReserveSeatResponse> getReserveSeatMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "ReserveSeat",
      requestType = com.traffic_tacos.reservation.v1.ReserveSeatRequest.class,
      responseType = com.traffic_tacos.reservation.v1.ReserveSeatResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<com.traffic_tacos.reservation.v1.ReserveSeatRequest,
      com.traffic_tacos.reservation.v1.ReserveSeatResponse> getReserveSeatMethod() {
    io.grpc.MethodDescriptor<com.traffic_tacos.reservation.v1.ReserveSeatRequest, com.traffic_tacos.reservation.v1.ReserveSeatResponse> getReserveSeatMethod;
    if ((getReserveSeatMethod = InventoryServiceGrpc.getReserveSeatMethod) == null) {
      synchronized (InventoryServiceGrpc.class) {
        if ((getReserveSeatMethod = InventoryServiceGrpc.getReserveSeatMethod) == null) {
          InventoryServiceGrpc.getReserveSeatMethod = getReserveSeatMethod =
              io.grpc.MethodDescriptor.<com.traffic_tacos.reservation.v1.ReserveSeatRequest, com.traffic_tacos.reservation.v1.ReserveSeatResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "ReserveSeat"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.traffic_tacos.reservation.v1.ReserveSeatRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.traffic_tacos.reservation.v1.ReserveSeatResponse.getDefaultInstance()))
              .setSchemaDescriptor(new InventoryServiceMethodDescriptorSupplier("ReserveSeat"))
              .build();
        }
      }
    }
    return getReserveSeatMethod;
  }

  private static volatile io.grpc.MethodDescriptor<com.traffic_tacos.reservation.v1.CommitReservationRequest,
      com.traffic_tacos.reservation.v1.CommitReservationResponse> getCommitReservationMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "CommitReservation",
      requestType = com.traffic_tacos.reservation.v1.CommitReservationRequest.class,
      responseType = com.traffic_tacos.reservation.v1.CommitReservationResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<com.traffic_tacos.reservation.v1.CommitReservationRequest,
      com.traffic_tacos.reservation.v1.CommitReservationResponse> getCommitReservationMethod() {
    io.grpc.MethodDescriptor<com.traffic_tacos.reservation.v1.CommitReservationRequest, com.traffic_tacos.reservation.v1.CommitReservationResponse> getCommitReservationMethod;
    if ((getCommitReservationMethod = InventoryServiceGrpc.getCommitReservationMethod) == null) {
      synchronized (InventoryServiceGrpc.class) {
        if ((getCommitReservationMethod = InventoryServiceGrpc.getCommitReservationMethod) == null) {
          InventoryServiceGrpc.getCommitReservationMethod = getCommitReservationMethod =
              io.grpc.MethodDescriptor.<com.traffic_tacos.reservation.v1.CommitReservationRequest, com.traffic_tacos.reservation.v1.CommitReservationResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "CommitReservation"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.traffic_tacos.reservation.v1.CommitReservationRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.traffic_tacos.reservation.v1.CommitReservationResponse.getDefaultInstance()))
              .setSchemaDescriptor(new InventoryServiceMethodDescriptorSupplier("CommitReservation"))
              .build();
        }
      }
    }
    return getCommitReservationMethod;
  }

  private static volatile io.grpc.MethodDescriptor<com.traffic_tacos.reservation.v1.ReleaseHoldRequest,
      com.traffic_tacos.reservation.v1.ReleaseHoldResponse> getReleaseHoldMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "ReleaseHold",
      requestType = com.traffic_tacos.reservation.v1.ReleaseHoldRequest.class,
      responseType = com.traffic_tacos.reservation.v1.ReleaseHoldResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<com.traffic_tacos.reservation.v1.ReleaseHoldRequest,
      com.traffic_tacos.reservation.v1.ReleaseHoldResponse> getReleaseHoldMethod() {
    io.grpc.MethodDescriptor<com.traffic_tacos.reservation.v1.ReleaseHoldRequest, com.traffic_tacos.reservation.v1.ReleaseHoldResponse> getReleaseHoldMethod;
    if ((getReleaseHoldMethod = InventoryServiceGrpc.getReleaseHoldMethod) == null) {
      synchronized (InventoryServiceGrpc.class) {
        if ((getReleaseHoldMethod = InventoryServiceGrpc.getReleaseHoldMethod) == null) {
          InventoryServiceGrpc.getReleaseHoldMethod = getReleaseHoldMethod =
              io.grpc.MethodDescriptor.<com.traffic_tacos.reservation.v1.ReleaseHoldRequest, com.traffic_tacos.reservation.v1.ReleaseHoldResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "ReleaseHold"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.traffic_tacos.reservation.v1.ReleaseHoldRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.traffic_tacos.reservation.v1.ReleaseHoldResponse.getDefaultInstance()))
              .setSchemaDescriptor(new InventoryServiceMethodDescriptorSupplier("ReleaseHold"))
              .build();
        }
      }
    }
    return getReleaseHoldMethod;
  }

  private static volatile io.grpc.MethodDescriptor<com.traffic_tacos.reservation.v1.GetInventoryStatusRequest,
      com.traffic_tacos.reservation.v1.GetInventoryStatusResponse> getGetInventoryStatusMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "GetInventoryStatus",
      requestType = com.traffic_tacos.reservation.v1.GetInventoryStatusRequest.class,
      responseType = com.traffic_tacos.reservation.v1.GetInventoryStatusResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<com.traffic_tacos.reservation.v1.GetInventoryStatusRequest,
      com.traffic_tacos.reservation.v1.GetInventoryStatusResponse> getGetInventoryStatusMethod() {
    io.grpc.MethodDescriptor<com.traffic_tacos.reservation.v1.GetInventoryStatusRequest, com.traffic_tacos.reservation.v1.GetInventoryStatusResponse> getGetInventoryStatusMethod;
    if ((getGetInventoryStatusMethod = InventoryServiceGrpc.getGetInventoryStatusMethod) == null) {
      synchronized (InventoryServiceGrpc.class) {
        if ((getGetInventoryStatusMethod = InventoryServiceGrpc.getGetInventoryStatusMethod) == null) {
          InventoryServiceGrpc.getGetInventoryStatusMethod = getGetInventoryStatusMethod =
              io.grpc.MethodDescriptor.<com.traffic_tacos.reservation.v1.GetInventoryStatusRequest, com.traffic_tacos.reservation.v1.GetInventoryStatusResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "GetInventoryStatus"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.traffic_tacos.reservation.v1.GetInventoryStatusRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.traffic_tacos.reservation.v1.GetInventoryStatusResponse.getDefaultInstance()))
              .setSchemaDescriptor(new InventoryServiceMethodDescriptorSupplier("GetInventoryStatus"))
              .build();
        }
      }
    }
    return getGetInventoryStatusMethod;
  }

  /**
   * Creates a new async stub that supports all call types for the service
   */
  public static InventoryServiceStub newStub(io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<InventoryServiceStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<InventoryServiceStub>() {
        @java.lang.Override
        public InventoryServiceStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new InventoryServiceStub(channel, callOptions);
        }
      };
    return InventoryServiceStub.newStub(factory, channel);
  }

  /**
   * Creates a new blocking-style stub that supports all types of calls on the service
   */
  public static InventoryServiceBlockingV2Stub newBlockingV2Stub(
      io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<InventoryServiceBlockingV2Stub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<InventoryServiceBlockingV2Stub>() {
        @java.lang.Override
        public InventoryServiceBlockingV2Stub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new InventoryServiceBlockingV2Stub(channel, callOptions);
        }
      };
    return InventoryServiceBlockingV2Stub.newStub(factory, channel);
  }

  /**
   * Creates a new blocking-style stub that supports unary and streaming output calls on the service
   */
  public static InventoryServiceBlockingStub newBlockingStub(
      io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<InventoryServiceBlockingStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<InventoryServiceBlockingStub>() {
        @java.lang.Override
        public InventoryServiceBlockingStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new InventoryServiceBlockingStub(channel, callOptions);
        }
      };
    return InventoryServiceBlockingStub.newStub(factory, channel);
  }

  /**
   * Creates a new ListenableFuture-style stub that supports unary calls on the service
   */
  public static InventoryServiceFutureStub newFutureStub(
      io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<InventoryServiceFutureStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<InventoryServiceFutureStub>() {
        @java.lang.Override
        public InventoryServiceFutureStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new InventoryServiceFutureStub(channel, callOptions);
        }
      };
    return InventoryServiceFutureStub.newStub(factory, channel);
  }

  /**
   * <pre>
   * Inventory service manages seat availability and reservations
   * This service ensures zero overselling through DynamoDB conditional updates
   * </pre>
   */
  public interface AsyncService {

    /**
     * <pre>
     * Check seat availability for the given event and seat selection
     * </pre>
     */
    default void checkAvailability(com.traffic_tacos.reservation.v1.CheckAvailabilityRequest request,
        io.grpc.stub.StreamObserver<com.traffic_tacos.reservation.v1.CheckAvailabilityResponse> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getCheckAvailabilityMethod(), responseObserver);
    }

    /**
     * <pre>
     * Reserve seats temporarily (60-second hold)
     * This creates a temporary hold that expires automatically
     * </pre>
     */
    default void reserveSeat(com.traffic_tacos.reservation.v1.ReserveSeatRequest request,
        io.grpc.stub.StreamObserver<com.traffic_tacos.reservation.v1.ReserveSeatResponse> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getReserveSeatMethod(), responseObserver);
    }

    /**
     * <pre>
     * Commit a reservation to permanent sale
     * This converts a temporary hold to a confirmed sale
     * </pre>
     */
    default void commitReservation(com.traffic_tacos.reservation.v1.CommitReservationRequest request,
        io.grpc.stub.StreamObserver<com.traffic_tacos.reservation.v1.CommitReservationResponse> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getCommitReservationMethod(), responseObserver);
    }

    /**
     * <pre>
     * Release a temporary hold
     * This frees up seats that were temporarily reserved
     * </pre>
     */
    default void releaseHold(com.traffic_tacos.reservation.v1.ReleaseHoldRequest request,
        io.grpc.stub.StreamObserver<com.traffic_tacos.reservation.v1.ReleaseHoldResponse> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getReleaseHoldMethod(), responseObserver);
    }

    /**
     * <pre>
     * Get current inventory status for an event
     * </pre>
     */
    default void getInventoryStatus(com.traffic_tacos.reservation.v1.GetInventoryStatusRequest request,
        io.grpc.stub.StreamObserver<com.traffic_tacos.reservation.v1.GetInventoryStatusResponse> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getGetInventoryStatusMethod(), responseObserver);
    }
  }

  /**
   * Base class for the server implementation of the service InventoryService.
   * <pre>
   * Inventory service manages seat availability and reservations
   * This service ensures zero overselling through DynamoDB conditional updates
   * </pre>
   */
  public static abstract class InventoryServiceImplBase
      implements io.grpc.BindableService, AsyncService {

    @java.lang.Override public final io.grpc.ServerServiceDefinition bindService() {
      return InventoryServiceGrpc.bindService(this);
    }
  }

  /**
   * A stub to allow clients to do asynchronous rpc calls to service InventoryService.
   * <pre>
   * Inventory service manages seat availability and reservations
   * This service ensures zero overselling through DynamoDB conditional updates
   * </pre>
   */
  public static final class InventoryServiceStub
      extends io.grpc.stub.AbstractAsyncStub<InventoryServiceStub> {
    private InventoryServiceStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected InventoryServiceStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new InventoryServiceStub(channel, callOptions);
    }

    /**
     * <pre>
     * Check seat availability for the given event and seat selection
     * </pre>
     */
    public void checkAvailability(com.traffic_tacos.reservation.v1.CheckAvailabilityRequest request,
        io.grpc.stub.StreamObserver<com.traffic_tacos.reservation.v1.CheckAvailabilityResponse> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getCheckAvailabilityMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     * <pre>
     * Reserve seats temporarily (60-second hold)
     * This creates a temporary hold that expires automatically
     * </pre>
     */
    public void reserveSeat(com.traffic_tacos.reservation.v1.ReserveSeatRequest request,
        io.grpc.stub.StreamObserver<com.traffic_tacos.reservation.v1.ReserveSeatResponse> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getReserveSeatMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     * <pre>
     * Commit a reservation to permanent sale
     * This converts a temporary hold to a confirmed sale
     * </pre>
     */
    public void commitReservation(com.traffic_tacos.reservation.v1.CommitReservationRequest request,
        io.grpc.stub.StreamObserver<com.traffic_tacos.reservation.v1.CommitReservationResponse> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getCommitReservationMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     * <pre>
     * Release a temporary hold
     * This frees up seats that were temporarily reserved
     * </pre>
     */
    public void releaseHold(com.traffic_tacos.reservation.v1.ReleaseHoldRequest request,
        io.grpc.stub.StreamObserver<com.traffic_tacos.reservation.v1.ReleaseHoldResponse> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getReleaseHoldMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     * <pre>
     * Get current inventory status for an event
     * </pre>
     */
    public void getInventoryStatus(com.traffic_tacos.reservation.v1.GetInventoryStatusRequest request,
        io.grpc.stub.StreamObserver<com.traffic_tacos.reservation.v1.GetInventoryStatusResponse> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getGetInventoryStatusMethod(), getCallOptions()), request, responseObserver);
    }
  }

  /**
   * A stub to allow clients to do synchronous rpc calls to service InventoryService.
   * <pre>
   * Inventory service manages seat availability and reservations
   * This service ensures zero overselling through DynamoDB conditional updates
   * </pre>
   */
  public static final class InventoryServiceBlockingV2Stub
      extends io.grpc.stub.AbstractBlockingStub<InventoryServiceBlockingV2Stub> {
    private InventoryServiceBlockingV2Stub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected InventoryServiceBlockingV2Stub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new InventoryServiceBlockingV2Stub(channel, callOptions);
    }

    /**
     * <pre>
     * Check seat availability for the given event and seat selection
     * </pre>
     */
    public com.traffic_tacos.reservation.v1.CheckAvailabilityResponse checkAvailability(com.traffic_tacos.reservation.v1.CheckAvailabilityRequest request) throws io.grpc.StatusException {
      return io.grpc.stub.ClientCalls.blockingV2UnaryCall(
          getChannel(), getCheckAvailabilityMethod(), getCallOptions(), request);
    }

    /**
     * <pre>
     * Reserve seats temporarily (60-second hold)
     * This creates a temporary hold that expires automatically
     * </pre>
     */
    public com.traffic_tacos.reservation.v1.ReserveSeatResponse reserveSeat(com.traffic_tacos.reservation.v1.ReserveSeatRequest request) throws io.grpc.StatusException {
      return io.grpc.stub.ClientCalls.blockingV2UnaryCall(
          getChannel(), getReserveSeatMethod(), getCallOptions(), request);
    }

    /**
     * <pre>
     * Commit a reservation to permanent sale
     * This converts a temporary hold to a confirmed sale
     * </pre>
     */
    public com.traffic_tacos.reservation.v1.CommitReservationResponse commitReservation(com.traffic_tacos.reservation.v1.CommitReservationRequest request) throws io.grpc.StatusException {
      return io.grpc.stub.ClientCalls.blockingV2UnaryCall(
          getChannel(), getCommitReservationMethod(), getCallOptions(), request);
    }

    /**
     * <pre>
     * Release a temporary hold
     * This frees up seats that were temporarily reserved
     * </pre>
     */
    public com.traffic_tacos.reservation.v1.ReleaseHoldResponse releaseHold(com.traffic_tacos.reservation.v1.ReleaseHoldRequest request) throws io.grpc.StatusException {
      return io.grpc.stub.ClientCalls.blockingV2UnaryCall(
          getChannel(), getReleaseHoldMethod(), getCallOptions(), request);
    }

    /**
     * <pre>
     * Get current inventory status for an event
     * </pre>
     */
    public com.traffic_tacos.reservation.v1.GetInventoryStatusResponse getInventoryStatus(com.traffic_tacos.reservation.v1.GetInventoryStatusRequest request) throws io.grpc.StatusException {
      return io.grpc.stub.ClientCalls.blockingV2UnaryCall(
          getChannel(), getGetInventoryStatusMethod(), getCallOptions(), request);
    }
  }

  /**
   * A stub to allow clients to do limited synchronous rpc calls to service InventoryService.
   * <pre>
   * Inventory service manages seat availability and reservations
   * This service ensures zero overselling through DynamoDB conditional updates
   * </pre>
   */
  public static final class InventoryServiceBlockingStub
      extends io.grpc.stub.AbstractBlockingStub<InventoryServiceBlockingStub> {
    private InventoryServiceBlockingStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected InventoryServiceBlockingStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new InventoryServiceBlockingStub(channel, callOptions);
    }

    /**
     * <pre>
     * Check seat availability for the given event and seat selection
     * </pre>
     */
    public com.traffic_tacos.reservation.v1.CheckAvailabilityResponse checkAvailability(com.traffic_tacos.reservation.v1.CheckAvailabilityRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getCheckAvailabilityMethod(), getCallOptions(), request);
    }

    /**
     * <pre>
     * Reserve seats temporarily (60-second hold)
     * This creates a temporary hold that expires automatically
     * </pre>
     */
    public com.traffic_tacos.reservation.v1.ReserveSeatResponse reserveSeat(com.traffic_tacos.reservation.v1.ReserveSeatRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getReserveSeatMethod(), getCallOptions(), request);
    }

    /**
     * <pre>
     * Commit a reservation to permanent sale
     * This converts a temporary hold to a confirmed sale
     * </pre>
     */
    public com.traffic_tacos.reservation.v1.CommitReservationResponse commitReservation(com.traffic_tacos.reservation.v1.CommitReservationRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getCommitReservationMethod(), getCallOptions(), request);
    }

    /**
     * <pre>
     * Release a temporary hold
     * This frees up seats that were temporarily reserved
     * </pre>
     */
    public com.traffic_tacos.reservation.v1.ReleaseHoldResponse releaseHold(com.traffic_tacos.reservation.v1.ReleaseHoldRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getReleaseHoldMethod(), getCallOptions(), request);
    }

    /**
     * <pre>
     * Get current inventory status for an event
     * </pre>
     */
    public com.traffic_tacos.reservation.v1.GetInventoryStatusResponse getInventoryStatus(com.traffic_tacos.reservation.v1.GetInventoryStatusRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getGetInventoryStatusMethod(), getCallOptions(), request);
    }
  }

  /**
   * A stub to allow clients to do ListenableFuture-style rpc calls to service InventoryService.
   * <pre>
   * Inventory service manages seat availability and reservations
   * This service ensures zero overselling through DynamoDB conditional updates
   * </pre>
   */
  public static final class InventoryServiceFutureStub
      extends io.grpc.stub.AbstractFutureStub<InventoryServiceFutureStub> {
    private InventoryServiceFutureStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected InventoryServiceFutureStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new InventoryServiceFutureStub(channel, callOptions);
    }

    /**
     * <pre>
     * Check seat availability for the given event and seat selection
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.traffic_tacos.reservation.v1.CheckAvailabilityResponse> checkAvailability(
        com.traffic_tacos.reservation.v1.CheckAvailabilityRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getCheckAvailabilityMethod(), getCallOptions()), request);
    }

    /**
     * <pre>
     * Reserve seats temporarily (60-second hold)
     * This creates a temporary hold that expires automatically
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.traffic_tacos.reservation.v1.ReserveSeatResponse> reserveSeat(
        com.traffic_tacos.reservation.v1.ReserveSeatRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getReserveSeatMethod(), getCallOptions()), request);
    }

    /**
     * <pre>
     * Commit a reservation to permanent sale
     * This converts a temporary hold to a confirmed sale
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.traffic_tacos.reservation.v1.CommitReservationResponse> commitReservation(
        com.traffic_tacos.reservation.v1.CommitReservationRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getCommitReservationMethod(), getCallOptions()), request);
    }

    /**
     * <pre>
     * Release a temporary hold
     * This frees up seats that were temporarily reserved
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.traffic_tacos.reservation.v1.ReleaseHoldResponse> releaseHold(
        com.traffic_tacos.reservation.v1.ReleaseHoldRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getReleaseHoldMethod(), getCallOptions()), request);
    }

    /**
     * <pre>
     * Get current inventory status for an event
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.traffic_tacos.reservation.v1.GetInventoryStatusResponse> getInventoryStatus(
        com.traffic_tacos.reservation.v1.GetInventoryStatusRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getGetInventoryStatusMethod(), getCallOptions()), request);
    }
  }

  private static final int METHODID_CHECK_AVAILABILITY = 0;
  private static final int METHODID_RESERVE_SEAT = 1;
  private static final int METHODID_COMMIT_RESERVATION = 2;
  private static final int METHODID_RELEASE_HOLD = 3;
  private static final int METHODID_GET_INVENTORY_STATUS = 4;

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
        case METHODID_CHECK_AVAILABILITY:
          serviceImpl.checkAvailability((com.traffic_tacos.reservation.v1.CheckAvailabilityRequest) request,
              (io.grpc.stub.StreamObserver<com.traffic_tacos.reservation.v1.CheckAvailabilityResponse>) responseObserver);
          break;
        case METHODID_RESERVE_SEAT:
          serviceImpl.reserveSeat((com.traffic_tacos.reservation.v1.ReserveSeatRequest) request,
              (io.grpc.stub.StreamObserver<com.traffic_tacos.reservation.v1.ReserveSeatResponse>) responseObserver);
          break;
        case METHODID_COMMIT_RESERVATION:
          serviceImpl.commitReservation((com.traffic_tacos.reservation.v1.CommitReservationRequest) request,
              (io.grpc.stub.StreamObserver<com.traffic_tacos.reservation.v1.CommitReservationResponse>) responseObserver);
          break;
        case METHODID_RELEASE_HOLD:
          serviceImpl.releaseHold((com.traffic_tacos.reservation.v1.ReleaseHoldRequest) request,
              (io.grpc.stub.StreamObserver<com.traffic_tacos.reservation.v1.ReleaseHoldResponse>) responseObserver);
          break;
        case METHODID_GET_INVENTORY_STATUS:
          serviceImpl.getInventoryStatus((com.traffic_tacos.reservation.v1.GetInventoryStatusRequest) request,
              (io.grpc.stub.StreamObserver<com.traffic_tacos.reservation.v1.GetInventoryStatusResponse>) responseObserver);
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
          getCheckAvailabilityMethod(),
          io.grpc.stub.ServerCalls.asyncUnaryCall(
            new MethodHandlers<
              com.traffic_tacos.reservation.v1.CheckAvailabilityRequest,
              com.traffic_tacos.reservation.v1.CheckAvailabilityResponse>(
                service, METHODID_CHECK_AVAILABILITY)))
        .addMethod(
          getReserveSeatMethod(),
          io.grpc.stub.ServerCalls.asyncUnaryCall(
            new MethodHandlers<
              com.traffic_tacos.reservation.v1.ReserveSeatRequest,
              com.traffic_tacos.reservation.v1.ReserveSeatResponse>(
                service, METHODID_RESERVE_SEAT)))
        .addMethod(
          getCommitReservationMethod(),
          io.grpc.stub.ServerCalls.asyncUnaryCall(
            new MethodHandlers<
              com.traffic_tacos.reservation.v1.CommitReservationRequest,
              com.traffic_tacos.reservation.v1.CommitReservationResponse>(
                service, METHODID_COMMIT_RESERVATION)))
        .addMethod(
          getReleaseHoldMethod(),
          io.grpc.stub.ServerCalls.asyncUnaryCall(
            new MethodHandlers<
              com.traffic_tacos.reservation.v1.ReleaseHoldRequest,
              com.traffic_tacos.reservation.v1.ReleaseHoldResponse>(
                service, METHODID_RELEASE_HOLD)))
        .addMethod(
          getGetInventoryStatusMethod(),
          io.grpc.stub.ServerCalls.asyncUnaryCall(
            new MethodHandlers<
              com.traffic_tacos.reservation.v1.GetInventoryStatusRequest,
              com.traffic_tacos.reservation.v1.GetInventoryStatusResponse>(
                service, METHODID_GET_INVENTORY_STATUS)))
        .build();
  }

  private static abstract class InventoryServiceBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoFileDescriptorSupplier, io.grpc.protobuf.ProtoServiceDescriptorSupplier {
    InventoryServiceBaseDescriptorSupplier() {}

    @java.lang.Override
    public com.google.protobuf.Descriptors.FileDescriptor getFileDescriptor() {
      return com.traffic_tacos.reservation.v1.InventoryProto.getDescriptor();
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.ServiceDescriptor getServiceDescriptor() {
      return getFileDescriptor().findServiceByName("InventoryService");
    }
  }

  private static final class InventoryServiceFileDescriptorSupplier
      extends InventoryServiceBaseDescriptorSupplier {
    InventoryServiceFileDescriptorSupplier() {}
  }

  private static final class InventoryServiceMethodDescriptorSupplier
      extends InventoryServiceBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoMethodDescriptorSupplier {
    private final java.lang.String methodName;

    InventoryServiceMethodDescriptorSupplier(java.lang.String methodName) {
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
      synchronized (InventoryServiceGrpc.class) {
        result = serviceDescriptor;
        if (result == null) {
          serviceDescriptor = result = io.grpc.ServiceDescriptor.newBuilder(SERVICE_NAME)
              .setSchemaDescriptor(new InventoryServiceFileDescriptorSupplier())
              .addMethod(getCheckAvailabilityMethod())
              .addMethod(getReserveSeatMethod())
              .addMethod(getCommitReservationMethod())
              .addMethod(getReleaseHoldMethod())
              .addMethod(getGetInventoryStatusMethod())
              .build();
        }
      }
    }
    return result;
  }
}

package com.traffic_tacos.gateway.v1;

import static io.grpc.MethodDescriptor.generateFullMethodName;

/**
 * <pre>
 * Gateway service acts as BFF (Backend for Frontend)
 * Handles authentication, rate limiting, and service orchestration
 * </pre>
 */
@io.grpc.stub.annotations.GrpcGenerated
public final class GatewayServiceGrpc {

  private GatewayServiceGrpc() {}

  public static final java.lang.String SERVICE_NAME = "gateway.v1.GatewayService";

  // Static method descriptors that strictly reflect the proto.
  private static volatile io.grpc.MethodDescriptor<com.traffic_tacos.gateway.v1.HealthCheckRequest,
      com.traffic_tacos.gateway.v1.HealthCheckResponse> getHealthCheckMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "HealthCheck",
      requestType = com.traffic_tacos.gateway.v1.HealthCheckRequest.class,
      responseType = com.traffic_tacos.gateway.v1.HealthCheckResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<com.traffic_tacos.gateway.v1.HealthCheckRequest,
      com.traffic_tacos.gateway.v1.HealthCheckResponse> getHealthCheckMethod() {
    io.grpc.MethodDescriptor<com.traffic_tacos.gateway.v1.HealthCheckRequest, com.traffic_tacos.gateway.v1.HealthCheckResponse> getHealthCheckMethod;
    if ((getHealthCheckMethod = GatewayServiceGrpc.getHealthCheckMethod) == null) {
      synchronized (GatewayServiceGrpc.class) {
        if ((getHealthCheckMethod = GatewayServiceGrpc.getHealthCheckMethod) == null) {
          GatewayServiceGrpc.getHealthCheckMethod = getHealthCheckMethod =
              io.grpc.MethodDescriptor.<com.traffic_tacos.gateway.v1.HealthCheckRequest, com.traffic_tacos.gateway.v1.HealthCheckResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "HealthCheck"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.traffic_tacos.gateway.v1.HealthCheckRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.traffic_tacos.gateway.v1.HealthCheckResponse.getDefaultInstance()))
              .setSchemaDescriptor(new GatewayServiceMethodDescriptorSupplier("HealthCheck"))
              .build();
        }
      }
    }
    return getHealthCheckMethod;
  }

  private static volatile io.grpc.MethodDescriptor<com.traffic_tacos.gateway.v1.ValidateTokenRequest,
      com.traffic_tacos.gateway.v1.ValidateTokenResponse> getValidateTokenMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "ValidateToken",
      requestType = com.traffic_tacos.gateway.v1.ValidateTokenRequest.class,
      responseType = com.traffic_tacos.gateway.v1.ValidateTokenResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<com.traffic_tacos.gateway.v1.ValidateTokenRequest,
      com.traffic_tacos.gateway.v1.ValidateTokenResponse> getValidateTokenMethod() {
    io.grpc.MethodDescriptor<com.traffic_tacos.gateway.v1.ValidateTokenRequest, com.traffic_tacos.gateway.v1.ValidateTokenResponse> getValidateTokenMethod;
    if ((getValidateTokenMethod = GatewayServiceGrpc.getValidateTokenMethod) == null) {
      synchronized (GatewayServiceGrpc.class) {
        if ((getValidateTokenMethod = GatewayServiceGrpc.getValidateTokenMethod) == null) {
          GatewayServiceGrpc.getValidateTokenMethod = getValidateTokenMethod =
              io.grpc.MethodDescriptor.<com.traffic_tacos.gateway.v1.ValidateTokenRequest, com.traffic_tacos.gateway.v1.ValidateTokenResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "ValidateToken"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.traffic_tacos.gateway.v1.ValidateTokenRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.traffic_tacos.gateway.v1.ValidateTokenResponse.getDefaultInstance()))
              .setSchemaDescriptor(new GatewayServiceMethodDescriptorSupplier("ValidateToken"))
              .build();
        }
      }
    }
    return getValidateTokenMethod;
  }

  private static volatile io.grpc.MethodDescriptor<com.traffic_tacos.gateway.v1.GetEventAvailabilityRequest,
      com.traffic_tacos.gateway.v1.GetEventAvailabilityResponse> getGetEventAvailabilityMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "GetEventAvailability",
      requestType = com.traffic_tacos.gateway.v1.GetEventAvailabilityRequest.class,
      responseType = com.traffic_tacos.gateway.v1.GetEventAvailabilityResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<com.traffic_tacos.gateway.v1.GetEventAvailabilityRequest,
      com.traffic_tacos.gateway.v1.GetEventAvailabilityResponse> getGetEventAvailabilityMethod() {
    io.grpc.MethodDescriptor<com.traffic_tacos.gateway.v1.GetEventAvailabilityRequest, com.traffic_tacos.gateway.v1.GetEventAvailabilityResponse> getGetEventAvailabilityMethod;
    if ((getGetEventAvailabilityMethod = GatewayServiceGrpc.getGetEventAvailabilityMethod) == null) {
      synchronized (GatewayServiceGrpc.class) {
        if ((getGetEventAvailabilityMethod = GatewayServiceGrpc.getGetEventAvailabilityMethod) == null) {
          GatewayServiceGrpc.getGetEventAvailabilityMethod = getGetEventAvailabilityMethod =
              io.grpc.MethodDescriptor.<com.traffic_tacos.gateway.v1.GetEventAvailabilityRequest, com.traffic_tacos.gateway.v1.GetEventAvailabilityResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "GetEventAvailability"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.traffic_tacos.gateway.v1.GetEventAvailabilityRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.traffic_tacos.gateway.v1.GetEventAvailabilityResponse.getDefaultInstance()))
              .setSchemaDescriptor(new GatewayServiceMethodDescriptorSupplier("GetEventAvailability"))
              .build();
        }
      }
    }
    return getGetEventAvailabilityMethod;
  }

  private static volatile io.grpc.MethodDescriptor<com.traffic_tacos.gateway.v1.CreateReservationRequest,
      com.traffic_tacos.gateway.v1.CreateReservationResponse> getCreateReservationMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "CreateReservation",
      requestType = com.traffic_tacos.gateway.v1.CreateReservationRequest.class,
      responseType = com.traffic_tacos.gateway.v1.CreateReservationResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<com.traffic_tacos.gateway.v1.CreateReservationRequest,
      com.traffic_tacos.gateway.v1.CreateReservationResponse> getCreateReservationMethod() {
    io.grpc.MethodDescriptor<com.traffic_tacos.gateway.v1.CreateReservationRequest, com.traffic_tacos.gateway.v1.CreateReservationResponse> getCreateReservationMethod;
    if ((getCreateReservationMethod = GatewayServiceGrpc.getCreateReservationMethod) == null) {
      synchronized (GatewayServiceGrpc.class) {
        if ((getCreateReservationMethod = GatewayServiceGrpc.getCreateReservationMethod) == null) {
          GatewayServiceGrpc.getCreateReservationMethod = getCreateReservationMethod =
              io.grpc.MethodDescriptor.<com.traffic_tacos.gateway.v1.CreateReservationRequest, com.traffic_tacos.gateway.v1.CreateReservationResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "CreateReservation"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.traffic_tacos.gateway.v1.CreateReservationRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.traffic_tacos.gateway.v1.CreateReservationResponse.getDefaultInstance()))
              .setSchemaDescriptor(new GatewayServiceMethodDescriptorSupplier("CreateReservation"))
              .build();
        }
      }
    }
    return getCreateReservationMethod;
  }

  private static volatile io.grpc.MethodDescriptor<com.traffic_tacos.gateway.v1.GetReservationRequest,
      com.traffic_tacos.gateway.v1.GetReservationResponse> getGetReservationMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "GetReservation",
      requestType = com.traffic_tacos.gateway.v1.GetReservationRequest.class,
      responseType = com.traffic_tacos.gateway.v1.GetReservationResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<com.traffic_tacos.gateway.v1.GetReservationRequest,
      com.traffic_tacos.gateway.v1.GetReservationResponse> getGetReservationMethod() {
    io.grpc.MethodDescriptor<com.traffic_tacos.gateway.v1.GetReservationRequest, com.traffic_tacos.gateway.v1.GetReservationResponse> getGetReservationMethod;
    if ((getGetReservationMethod = GatewayServiceGrpc.getGetReservationMethod) == null) {
      synchronized (GatewayServiceGrpc.class) {
        if ((getGetReservationMethod = GatewayServiceGrpc.getGetReservationMethod) == null) {
          GatewayServiceGrpc.getGetReservationMethod = getGetReservationMethod =
              io.grpc.MethodDescriptor.<com.traffic_tacos.gateway.v1.GetReservationRequest, com.traffic_tacos.gateway.v1.GetReservationResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "GetReservation"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.traffic_tacos.gateway.v1.GetReservationRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.traffic_tacos.gateway.v1.GetReservationResponse.getDefaultInstance()))
              .setSchemaDescriptor(new GatewayServiceMethodDescriptorSupplier("GetReservation"))
              .build();
        }
      }
    }
    return getGetReservationMethod;
  }

  private static volatile io.grpc.MethodDescriptor<com.traffic_tacos.gateway.v1.ConfirmReservationRequest,
      com.traffic_tacos.gateway.v1.ConfirmReservationResponse> getConfirmReservationMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "ConfirmReservation",
      requestType = com.traffic_tacos.gateway.v1.ConfirmReservationRequest.class,
      responseType = com.traffic_tacos.gateway.v1.ConfirmReservationResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<com.traffic_tacos.gateway.v1.ConfirmReservationRequest,
      com.traffic_tacos.gateway.v1.ConfirmReservationResponse> getConfirmReservationMethod() {
    io.grpc.MethodDescriptor<com.traffic_tacos.gateway.v1.ConfirmReservationRequest, com.traffic_tacos.gateway.v1.ConfirmReservationResponse> getConfirmReservationMethod;
    if ((getConfirmReservationMethod = GatewayServiceGrpc.getConfirmReservationMethod) == null) {
      synchronized (GatewayServiceGrpc.class) {
        if ((getConfirmReservationMethod = GatewayServiceGrpc.getConfirmReservationMethod) == null) {
          GatewayServiceGrpc.getConfirmReservationMethod = getConfirmReservationMethod =
              io.grpc.MethodDescriptor.<com.traffic_tacos.gateway.v1.ConfirmReservationRequest, com.traffic_tacos.gateway.v1.ConfirmReservationResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "ConfirmReservation"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.traffic_tacos.gateway.v1.ConfirmReservationRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.traffic_tacos.gateway.v1.ConfirmReservationResponse.getDefaultInstance()))
              .setSchemaDescriptor(new GatewayServiceMethodDescriptorSupplier("ConfirmReservation"))
              .build();
        }
      }
    }
    return getConfirmReservationMethod;
  }

  private static volatile io.grpc.MethodDescriptor<com.traffic_tacos.gateway.v1.CancelReservationRequest,
      com.traffic_tacos.gateway.v1.CancelReservationResponse> getCancelReservationMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "CancelReservation",
      requestType = com.traffic_tacos.gateway.v1.CancelReservationRequest.class,
      responseType = com.traffic_tacos.gateway.v1.CancelReservationResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<com.traffic_tacos.gateway.v1.CancelReservationRequest,
      com.traffic_tacos.gateway.v1.CancelReservationResponse> getCancelReservationMethod() {
    io.grpc.MethodDescriptor<com.traffic_tacos.gateway.v1.CancelReservationRequest, com.traffic_tacos.gateway.v1.CancelReservationResponse> getCancelReservationMethod;
    if ((getCancelReservationMethod = GatewayServiceGrpc.getCancelReservationMethod) == null) {
      synchronized (GatewayServiceGrpc.class) {
        if ((getCancelReservationMethod = GatewayServiceGrpc.getCancelReservationMethod) == null) {
          GatewayServiceGrpc.getCancelReservationMethod = getCancelReservationMethod =
              io.grpc.MethodDescriptor.<com.traffic_tacos.gateway.v1.CancelReservationRequest, com.traffic_tacos.gateway.v1.CancelReservationResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "CancelReservation"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.traffic_tacos.gateway.v1.CancelReservationRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.traffic_tacos.gateway.v1.CancelReservationResponse.getDefaultInstance()))
              .setSchemaDescriptor(new GatewayServiceMethodDescriptorSupplier("CancelReservation"))
              .build();
        }
      }
    }
    return getCancelReservationMethod;
  }

  private static volatile io.grpc.MethodDescriptor<com.traffic_tacos.gateway.v1.CreatePaymentIntentRequest,
      com.traffic_tacos.gateway.v1.CreatePaymentIntentResponse> getCreatePaymentIntentMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "CreatePaymentIntent",
      requestType = com.traffic_tacos.gateway.v1.CreatePaymentIntentRequest.class,
      responseType = com.traffic_tacos.gateway.v1.CreatePaymentIntentResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<com.traffic_tacos.gateway.v1.CreatePaymentIntentRequest,
      com.traffic_tacos.gateway.v1.CreatePaymentIntentResponse> getCreatePaymentIntentMethod() {
    io.grpc.MethodDescriptor<com.traffic_tacos.gateway.v1.CreatePaymentIntentRequest, com.traffic_tacos.gateway.v1.CreatePaymentIntentResponse> getCreatePaymentIntentMethod;
    if ((getCreatePaymentIntentMethod = GatewayServiceGrpc.getCreatePaymentIntentMethod) == null) {
      synchronized (GatewayServiceGrpc.class) {
        if ((getCreatePaymentIntentMethod = GatewayServiceGrpc.getCreatePaymentIntentMethod) == null) {
          GatewayServiceGrpc.getCreatePaymentIntentMethod = getCreatePaymentIntentMethod =
              io.grpc.MethodDescriptor.<com.traffic_tacos.gateway.v1.CreatePaymentIntentRequest, com.traffic_tacos.gateway.v1.CreatePaymentIntentResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "CreatePaymentIntent"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.traffic_tacos.gateway.v1.CreatePaymentIntentRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.traffic_tacos.gateway.v1.CreatePaymentIntentResponse.getDefaultInstance()))
              .setSchemaDescriptor(new GatewayServiceMethodDescriptorSupplier("CreatePaymentIntent"))
              .build();
        }
      }
    }
    return getCreatePaymentIntentMethod;
  }

  private static volatile io.grpc.MethodDescriptor<com.traffic_tacos.gateway.v1.GetPaymentStatusRequest,
      com.traffic_tacos.gateway.v1.GetPaymentStatusResponse> getGetPaymentStatusMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "GetPaymentStatus",
      requestType = com.traffic_tacos.gateway.v1.GetPaymentStatusRequest.class,
      responseType = com.traffic_tacos.gateway.v1.GetPaymentStatusResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<com.traffic_tacos.gateway.v1.GetPaymentStatusRequest,
      com.traffic_tacos.gateway.v1.GetPaymentStatusResponse> getGetPaymentStatusMethod() {
    io.grpc.MethodDescriptor<com.traffic_tacos.gateway.v1.GetPaymentStatusRequest, com.traffic_tacos.gateway.v1.GetPaymentStatusResponse> getGetPaymentStatusMethod;
    if ((getGetPaymentStatusMethod = GatewayServiceGrpc.getGetPaymentStatusMethod) == null) {
      synchronized (GatewayServiceGrpc.class) {
        if ((getGetPaymentStatusMethod = GatewayServiceGrpc.getGetPaymentStatusMethod) == null) {
          GatewayServiceGrpc.getGetPaymentStatusMethod = getGetPaymentStatusMethod =
              io.grpc.MethodDescriptor.<com.traffic_tacos.gateway.v1.GetPaymentStatusRequest, com.traffic_tacos.gateway.v1.GetPaymentStatusResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "GetPaymentStatus"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.traffic_tacos.gateway.v1.GetPaymentStatusRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.traffic_tacos.gateway.v1.GetPaymentStatusResponse.getDefaultInstance()))
              .setSchemaDescriptor(new GatewayServiceMethodDescriptorSupplier("GetPaymentStatus"))
              .build();
        }
      }
    }
    return getGetPaymentStatusMethod;
  }

  /**
   * Creates a new async stub that supports all call types for the service
   */
  public static GatewayServiceStub newStub(io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<GatewayServiceStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<GatewayServiceStub>() {
        @java.lang.Override
        public GatewayServiceStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new GatewayServiceStub(channel, callOptions);
        }
      };
    return GatewayServiceStub.newStub(factory, channel);
  }

  /**
   * Creates a new blocking-style stub that supports all types of calls on the service
   */
  public static GatewayServiceBlockingV2Stub newBlockingV2Stub(
      io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<GatewayServiceBlockingV2Stub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<GatewayServiceBlockingV2Stub>() {
        @java.lang.Override
        public GatewayServiceBlockingV2Stub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new GatewayServiceBlockingV2Stub(channel, callOptions);
        }
      };
    return GatewayServiceBlockingV2Stub.newStub(factory, channel);
  }

  /**
   * Creates a new blocking-style stub that supports unary and streaming output calls on the service
   */
  public static GatewayServiceBlockingStub newBlockingStub(
      io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<GatewayServiceBlockingStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<GatewayServiceBlockingStub>() {
        @java.lang.Override
        public GatewayServiceBlockingStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new GatewayServiceBlockingStub(channel, callOptions);
        }
      };
    return GatewayServiceBlockingStub.newStub(factory, channel);
  }

  /**
   * Creates a new ListenableFuture-style stub that supports unary calls on the service
   */
  public static GatewayServiceFutureStub newFutureStub(
      io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<GatewayServiceFutureStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<GatewayServiceFutureStub>() {
        @java.lang.Override
        public GatewayServiceFutureStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new GatewayServiceFutureStub(channel, callOptions);
        }
      };
    return GatewayServiceFutureStub.newStub(factory, channel);
  }

  /**
   * <pre>
   * Gateway service acts as BFF (Backend for Frontend)
   * Handles authentication, rate limiting, and service orchestration
   * </pre>
   */
  public interface AsyncService {

    /**
     * <pre>
     * Health check
     * </pre>
     */
    default void healthCheck(com.traffic_tacos.gateway.v1.HealthCheckRequest request,
        io.grpc.stub.StreamObserver<com.traffic_tacos.gateway.v1.HealthCheckResponse> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getHealthCheckMethod(), responseObserver);
    }

    /**
     * <pre>
     * Authentication and authorization
     * </pre>
     */
    default void validateToken(com.traffic_tacos.gateway.v1.ValidateTokenRequest request,
        io.grpc.stub.StreamObserver<com.traffic_tacos.gateway.v1.ValidateTokenResponse> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getValidateTokenMethod(), responseObserver);
    }

    /**
     * <pre>
     * Event and inventory queries
     * </pre>
     */
    default void getEventAvailability(com.traffic_tacos.gateway.v1.GetEventAvailabilityRequest request,
        io.grpc.stub.StreamObserver<com.traffic_tacos.gateway.v1.GetEventAvailabilityResponse> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getGetEventAvailabilityMethod(), responseObserver);
    }

    /**
     * <pre>
     * Reservation orchestration
     * </pre>
     */
    default void createReservation(com.traffic_tacos.gateway.v1.CreateReservationRequest request,
        io.grpc.stub.StreamObserver<com.traffic_tacos.gateway.v1.CreateReservationResponse> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getCreateReservationMethod(), responseObserver);
    }

    /**
     */
    default void getReservation(com.traffic_tacos.gateway.v1.GetReservationRequest request,
        io.grpc.stub.StreamObserver<com.traffic_tacos.gateway.v1.GetReservationResponse> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getGetReservationMethod(), responseObserver);
    }

    /**
     */
    default void confirmReservation(com.traffic_tacos.gateway.v1.ConfirmReservationRequest request,
        io.grpc.stub.StreamObserver<com.traffic_tacos.gateway.v1.ConfirmReservationResponse> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getConfirmReservationMethod(), responseObserver);
    }

    /**
     */
    default void cancelReservation(com.traffic_tacos.gateway.v1.CancelReservationRequest request,
        io.grpc.stub.StreamObserver<com.traffic_tacos.gateway.v1.CancelReservationResponse> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getCancelReservationMethod(), responseObserver);
    }

    /**
     * <pre>
     * Payment orchestration
     * </pre>
     */
    default void createPaymentIntent(com.traffic_tacos.gateway.v1.CreatePaymentIntentRequest request,
        io.grpc.stub.StreamObserver<com.traffic_tacos.gateway.v1.CreatePaymentIntentResponse> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getCreatePaymentIntentMethod(), responseObserver);
    }

    /**
     */
    default void getPaymentStatus(com.traffic_tacos.gateway.v1.GetPaymentStatusRequest request,
        io.grpc.stub.StreamObserver<com.traffic_tacos.gateway.v1.GetPaymentStatusResponse> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getGetPaymentStatusMethod(), responseObserver);
    }
  }

  /**
   * Base class for the server implementation of the service GatewayService.
   * <pre>
   * Gateway service acts as BFF (Backend for Frontend)
   * Handles authentication, rate limiting, and service orchestration
   * </pre>
   */
  public static abstract class GatewayServiceImplBase
      implements io.grpc.BindableService, AsyncService {

    @java.lang.Override public final io.grpc.ServerServiceDefinition bindService() {
      return GatewayServiceGrpc.bindService(this);
    }
  }

  /**
   * A stub to allow clients to do asynchronous rpc calls to service GatewayService.
   * <pre>
   * Gateway service acts as BFF (Backend for Frontend)
   * Handles authentication, rate limiting, and service orchestration
   * </pre>
   */
  public static final class GatewayServiceStub
      extends io.grpc.stub.AbstractAsyncStub<GatewayServiceStub> {
    private GatewayServiceStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected GatewayServiceStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new GatewayServiceStub(channel, callOptions);
    }

    /**
     * <pre>
     * Health check
     * </pre>
     */
    public void healthCheck(com.traffic_tacos.gateway.v1.HealthCheckRequest request,
        io.grpc.stub.StreamObserver<com.traffic_tacos.gateway.v1.HealthCheckResponse> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getHealthCheckMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     * <pre>
     * Authentication and authorization
     * </pre>
     */
    public void validateToken(com.traffic_tacos.gateway.v1.ValidateTokenRequest request,
        io.grpc.stub.StreamObserver<com.traffic_tacos.gateway.v1.ValidateTokenResponse> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getValidateTokenMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     * <pre>
     * Event and inventory queries
     * </pre>
     */
    public void getEventAvailability(com.traffic_tacos.gateway.v1.GetEventAvailabilityRequest request,
        io.grpc.stub.StreamObserver<com.traffic_tacos.gateway.v1.GetEventAvailabilityResponse> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getGetEventAvailabilityMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     * <pre>
     * Reservation orchestration
     * </pre>
     */
    public void createReservation(com.traffic_tacos.gateway.v1.CreateReservationRequest request,
        io.grpc.stub.StreamObserver<com.traffic_tacos.gateway.v1.CreateReservationResponse> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getCreateReservationMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void getReservation(com.traffic_tacos.gateway.v1.GetReservationRequest request,
        io.grpc.stub.StreamObserver<com.traffic_tacos.gateway.v1.GetReservationResponse> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getGetReservationMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void confirmReservation(com.traffic_tacos.gateway.v1.ConfirmReservationRequest request,
        io.grpc.stub.StreamObserver<com.traffic_tacos.gateway.v1.ConfirmReservationResponse> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getConfirmReservationMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void cancelReservation(com.traffic_tacos.gateway.v1.CancelReservationRequest request,
        io.grpc.stub.StreamObserver<com.traffic_tacos.gateway.v1.CancelReservationResponse> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getCancelReservationMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     * <pre>
     * Payment orchestration
     * </pre>
     */
    public void createPaymentIntent(com.traffic_tacos.gateway.v1.CreatePaymentIntentRequest request,
        io.grpc.stub.StreamObserver<com.traffic_tacos.gateway.v1.CreatePaymentIntentResponse> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getCreatePaymentIntentMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void getPaymentStatus(com.traffic_tacos.gateway.v1.GetPaymentStatusRequest request,
        io.grpc.stub.StreamObserver<com.traffic_tacos.gateway.v1.GetPaymentStatusResponse> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getGetPaymentStatusMethod(), getCallOptions()), request, responseObserver);
    }
  }

  /**
   * A stub to allow clients to do synchronous rpc calls to service GatewayService.
   * <pre>
   * Gateway service acts as BFF (Backend for Frontend)
   * Handles authentication, rate limiting, and service orchestration
   * </pre>
   */
  public static final class GatewayServiceBlockingV2Stub
      extends io.grpc.stub.AbstractBlockingStub<GatewayServiceBlockingV2Stub> {
    private GatewayServiceBlockingV2Stub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected GatewayServiceBlockingV2Stub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new GatewayServiceBlockingV2Stub(channel, callOptions);
    }

    /**
     * <pre>
     * Health check
     * </pre>
     */
    public com.traffic_tacos.gateway.v1.HealthCheckResponse healthCheck(com.traffic_tacos.gateway.v1.HealthCheckRequest request) throws io.grpc.StatusException {
      return io.grpc.stub.ClientCalls.blockingV2UnaryCall(
          getChannel(), getHealthCheckMethod(), getCallOptions(), request);
    }

    /**
     * <pre>
     * Authentication and authorization
     * </pre>
     */
    public com.traffic_tacos.gateway.v1.ValidateTokenResponse validateToken(com.traffic_tacos.gateway.v1.ValidateTokenRequest request) throws io.grpc.StatusException {
      return io.grpc.stub.ClientCalls.blockingV2UnaryCall(
          getChannel(), getValidateTokenMethod(), getCallOptions(), request);
    }

    /**
     * <pre>
     * Event and inventory queries
     * </pre>
     */
    public com.traffic_tacos.gateway.v1.GetEventAvailabilityResponse getEventAvailability(com.traffic_tacos.gateway.v1.GetEventAvailabilityRequest request) throws io.grpc.StatusException {
      return io.grpc.stub.ClientCalls.blockingV2UnaryCall(
          getChannel(), getGetEventAvailabilityMethod(), getCallOptions(), request);
    }

    /**
     * <pre>
     * Reservation orchestration
     * </pre>
     */
    public com.traffic_tacos.gateway.v1.CreateReservationResponse createReservation(com.traffic_tacos.gateway.v1.CreateReservationRequest request) throws io.grpc.StatusException {
      return io.grpc.stub.ClientCalls.blockingV2UnaryCall(
          getChannel(), getCreateReservationMethod(), getCallOptions(), request);
    }

    /**
     */
    public com.traffic_tacos.gateway.v1.GetReservationResponse getReservation(com.traffic_tacos.gateway.v1.GetReservationRequest request) throws io.grpc.StatusException {
      return io.grpc.stub.ClientCalls.blockingV2UnaryCall(
          getChannel(), getGetReservationMethod(), getCallOptions(), request);
    }

    /**
     */
    public com.traffic_tacos.gateway.v1.ConfirmReservationResponse confirmReservation(com.traffic_tacos.gateway.v1.ConfirmReservationRequest request) throws io.grpc.StatusException {
      return io.grpc.stub.ClientCalls.blockingV2UnaryCall(
          getChannel(), getConfirmReservationMethod(), getCallOptions(), request);
    }

    /**
     */
    public com.traffic_tacos.gateway.v1.CancelReservationResponse cancelReservation(com.traffic_tacos.gateway.v1.CancelReservationRequest request) throws io.grpc.StatusException {
      return io.grpc.stub.ClientCalls.blockingV2UnaryCall(
          getChannel(), getCancelReservationMethod(), getCallOptions(), request);
    }

    /**
     * <pre>
     * Payment orchestration
     * </pre>
     */
    public com.traffic_tacos.gateway.v1.CreatePaymentIntentResponse createPaymentIntent(com.traffic_tacos.gateway.v1.CreatePaymentIntentRequest request) throws io.grpc.StatusException {
      return io.grpc.stub.ClientCalls.blockingV2UnaryCall(
          getChannel(), getCreatePaymentIntentMethod(), getCallOptions(), request);
    }

    /**
     */
    public com.traffic_tacos.gateway.v1.GetPaymentStatusResponse getPaymentStatus(com.traffic_tacos.gateway.v1.GetPaymentStatusRequest request) throws io.grpc.StatusException {
      return io.grpc.stub.ClientCalls.blockingV2UnaryCall(
          getChannel(), getGetPaymentStatusMethod(), getCallOptions(), request);
    }
  }

  /**
   * A stub to allow clients to do limited synchronous rpc calls to service GatewayService.
   * <pre>
   * Gateway service acts as BFF (Backend for Frontend)
   * Handles authentication, rate limiting, and service orchestration
   * </pre>
   */
  public static final class GatewayServiceBlockingStub
      extends io.grpc.stub.AbstractBlockingStub<GatewayServiceBlockingStub> {
    private GatewayServiceBlockingStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected GatewayServiceBlockingStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new GatewayServiceBlockingStub(channel, callOptions);
    }

    /**
     * <pre>
     * Health check
     * </pre>
     */
    public com.traffic_tacos.gateway.v1.HealthCheckResponse healthCheck(com.traffic_tacos.gateway.v1.HealthCheckRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getHealthCheckMethod(), getCallOptions(), request);
    }

    /**
     * <pre>
     * Authentication and authorization
     * </pre>
     */
    public com.traffic_tacos.gateway.v1.ValidateTokenResponse validateToken(com.traffic_tacos.gateway.v1.ValidateTokenRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getValidateTokenMethod(), getCallOptions(), request);
    }

    /**
     * <pre>
     * Event and inventory queries
     * </pre>
     */
    public com.traffic_tacos.gateway.v1.GetEventAvailabilityResponse getEventAvailability(com.traffic_tacos.gateway.v1.GetEventAvailabilityRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getGetEventAvailabilityMethod(), getCallOptions(), request);
    }

    /**
     * <pre>
     * Reservation orchestration
     * </pre>
     */
    public com.traffic_tacos.gateway.v1.CreateReservationResponse createReservation(com.traffic_tacos.gateway.v1.CreateReservationRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getCreateReservationMethod(), getCallOptions(), request);
    }

    /**
     */
    public com.traffic_tacos.gateway.v1.GetReservationResponse getReservation(com.traffic_tacos.gateway.v1.GetReservationRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getGetReservationMethod(), getCallOptions(), request);
    }

    /**
     */
    public com.traffic_tacos.gateway.v1.ConfirmReservationResponse confirmReservation(com.traffic_tacos.gateway.v1.ConfirmReservationRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getConfirmReservationMethod(), getCallOptions(), request);
    }

    /**
     */
    public com.traffic_tacos.gateway.v1.CancelReservationResponse cancelReservation(com.traffic_tacos.gateway.v1.CancelReservationRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getCancelReservationMethod(), getCallOptions(), request);
    }

    /**
     * <pre>
     * Payment orchestration
     * </pre>
     */
    public com.traffic_tacos.gateway.v1.CreatePaymentIntentResponse createPaymentIntent(com.traffic_tacos.gateway.v1.CreatePaymentIntentRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getCreatePaymentIntentMethod(), getCallOptions(), request);
    }

    /**
     */
    public com.traffic_tacos.gateway.v1.GetPaymentStatusResponse getPaymentStatus(com.traffic_tacos.gateway.v1.GetPaymentStatusRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getGetPaymentStatusMethod(), getCallOptions(), request);
    }
  }

  /**
   * A stub to allow clients to do ListenableFuture-style rpc calls to service GatewayService.
   * <pre>
   * Gateway service acts as BFF (Backend for Frontend)
   * Handles authentication, rate limiting, and service orchestration
   * </pre>
   */
  public static final class GatewayServiceFutureStub
      extends io.grpc.stub.AbstractFutureStub<GatewayServiceFutureStub> {
    private GatewayServiceFutureStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected GatewayServiceFutureStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new GatewayServiceFutureStub(channel, callOptions);
    }

    /**
     * <pre>
     * Health check
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.traffic_tacos.gateway.v1.HealthCheckResponse> healthCheck(
        com.traffic_tacos.gateway.v1.HealthCheckRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getHealthCheckMethod(), getCallOptions()), request);
    }

    /**
     * <pre>
     * Authentication and authorization
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.traffic_tacos.gateway.v1.ValidateTokenResponse> validateToken(
        com.traffic_tacos.gateway.v1.ValidateTokenRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getValidateTokenMethod(), getCallOptions()), request);
    }

    /**
     * <pre>
     * Event and inventory queries
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.traffic_tacos.gateway.v1.GetEventAvailabilityResponse> getEventAvailability(
        com.traffic_tacos.gateway.v1.GetEventAvailabilityRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getGetEventAvailabilityMethod(), getCallOptions()), request);
    }

    /**
     * <pre>
     * Reservation orchestration
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.traffic_tacos.gateway.v1.CreateReservationResponse> createReservation(
        com.traffic_tacos.gateway.v1.CreateReservationRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getCreateReservationMethod(), getCallOptions()), request);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<com.traffic_tacos.gateway.v1.GetReservationResponse> getReservation(
        com.traffic_tacos.gateway.v1.GetReservationRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getGetReservationMethod(), getCallOptions()), request);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<com.traffic_tacos.gateway.v1.ConfirmReservationResponse> confirmReservation(
        com.traffic_tacos.gateway.v1.ConfirmReservationRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getConfirmReservationMethod(), getCallOptions()), request);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<com.traffic_tacos.gateway.v1.CancelReservationResponse> cancelReservation(
        com.traffic_tacos.gateway.v1.CancelReservationRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getCancelReservationMethod(), getCallOptions()), request);
    }

    /**
     * <pre>
     * Payment orchestration
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.traffic_tacos.gateway.v1.CreatePaymentIntentResponse> createPaymentIntent(
        com.traffic_tacos.gateway.v1.CreatePaymentIntentRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getCreatePaymentIntentMethod(), getCallOptions()), request);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<com.traffic_tacos.gateway.v1.GetPaymentStatusResponse> getPaymentStatus(
        com.traffic_tacos.gateway.v1.GetPaymentStatusRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getGetPaymentStatusMethod(), getCallOptions()), request);
    }
  }

  private static final int METHODID_HEALTH_CHECK = 0;
  private static final int METHODID_VALIDATE_TOKEN = 1;
  private static final int METHODID_GET_EVENT_AVAILABILITY = 2;
  private static final int METHODID_CREATE_RESERVATION = 3;
  private static final int METHODID_GET_RESERVATION = 4;
  private static final int METHODID_CONFIRM_RESERVATION = 5;
  private static final int METHODID_CANCEL_RESERVATION = 6;
  private static final int METHODID_CREATE_PAYMENT_INTENT = 7;
  private static final int METHODID_GET_PAYMENT_STATUS = 8;

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
        case METHODID_HEALTH_CHECK:
          serviceImpl.healthCheck((com.traffic_tacos.gateway.v1.HealthCheckRequest) request,
              (io.grpc.stub.StreamObserver<com.traffic_tacos.gateway.v1.HealthCheckResponse>) responseObserver);
          break;
        case METHODID_VALIDATE_TOKEN:
          serviceImpl.validateToken((com.traffic_tacos.gateway.v1.ValidateTokenRequest) request,
              (io.grpc.stub.StreamObserver<com.traffic_tacos.gateway.v1.ValidateTokenResponse>) responseObserver);
          break;
        case METHODID_GET_EVENT_AVAILABILITY:
          serviceImpl.getEventAvailability((com.traffic_tacos.gateway.v1.GetEventAvailabilityRequest) request,
              (io.grpc.stub.StreamObserver<com.traffic_tacos.gateway.v1.GetEventAvailabilityResponse>) responseObserver);
          break;
        case METHODID_CREATE_RESERVATION:
          serviceImpl.createReservation((com.traffic_tacos.gateway.v1.CreateReservationRequest) request,
              (io.grpc.stub.StreamObserver<com.traffic_tacos.gateway.v1.CreateReservationResponse>) responseObserver);
          break;
        case METHODID_GET_RESERVATION:
          serviceImpl.getReservation((com.traffic_tacos.gateway.v1.GetReservationRequest) request,
              (io.grpc.stub.StreamObserver<com.traffic_tacos.gateway.v1.GetReservationResponse>) responseObserver);
          break;
        case METHODID_CONFIRM_RESERVATION:
          serviceImpl.confirmReservation((com.traffic_tacos.gateway.v1.ConfirmReservationRequest) request,
              (io.grpc.stub.StreamObserver<com.traffic_tacos.gateway.v1.ConfirmReservationResponse>) responseObserver);
          break;
        case METHODID_CANCEL_RESERVATION:
          serviceImpl.cancelReservation((com.traffic_tacos.gateway.v1.CancelReservationRequest) request,
              (io.grpc.stub.StreamObserver<com.traffic_tacos.gateway.v1.CancelReservationResponse>) responseObserver);
          break;
        case METHODID_CREATE_PAYMENT_INTENT:
          serviceImpl.createPaymentIntent((com.traffic_tacos.gateway.v1.CreatePaymentIntentRequest) request,
              (io.grpc.stub.StreamObserver<com.traffic_tacos.gateway.v1.CreatePaymentIntentResponse>) responseObserver);
          break;
        case METHODID_GET_PAYMENT_STATUS:
          serviceImpl.getPaymentStatus((com.traffic_tacos.gateway.v1.GetPaymentStatusRequest) request,
              (io.grpc.stub.StreamObserver<com.traffic_tacos.gateway.v1.GetPaymentStatusResponse>) responseObserver);
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
          getHealthCheckMethod(),
          io.grpc.stub.ServerCalls.asyncUnaryCall(
            new MethodHandlers<
              com.traffic_tacos.gateway.v1.HealthCheckRequest,
              com.traffic_tacos.gateway.v1.HealthCheckResponse>(
                service, METHODID_HEALTH_CHECK)))
        .addMethod(
          getValidateTokenMethod(),
          io.grpc.stub.ServerCalls.asyncUnaryCall(
            new MethodHandlers<
              com.traffic_tacos.gateway.v1.ValidateTokenRequest,
              com.traffic_tacos.gateway.v1.ValidateTokenResponse>(
                service, METHODID_VALIDATE_TOKEN)))
        .addMethod(
          getGetEventAvailabilityMethod(),
          io.grpc.stub.ServerCalls.asyncUnaryCall(
            new MethodHandlers<
              com.traffic_tacos.gateway.v1.GetEventAvailabilityRequest,
              com.traffic_tacos.gateway.v1.GetEventAvailabilityResponse>(
                service, METHODID_GET_EVENT_AVAILABILITY)))
        .addMethod(
          getCreateReservationMethod(),
          io.grpc.stub.ServerCalls.asyncUnaryCall(
            new MethodHandlers<
              com.traffic_tacos.gateway.v1.CreateReservationRequest,
              com.traffic_tacos.gateway.v1.CreateReservationResponse>(
                service, METHODID_CREATE_RESERVATION)))
        .addMethod(
          getGetReservationMethod(),
          io.grpc.stub.ServerCalls.asyncUnaryCall(
            new MethodHandlers<
              com.traffic_tacos.gateway.v1.GetReservationRequest,
              com.traffic_tacos.gateway.v1.GetReservationResponse>(
                service, METHODID_GET_RESERVATION)))
        .addMethod(
          getConfirmReservationMethod(),
          io.grpc.stub.ServerCalls.asyncUnaryCall(
            new MethodHandlers<
              com.traffic_tacos.gateway.v1.ConfirmReservationRequest,
              com.traffic_tacos.gateway.v1.ConfirmReservationResponse>(
                service, METHODID_CONFIRM_RESERVATION)))
        .addMethod(
          getCancelReservationMethod(),
          io.grpc.stub.ServerCalls.asyncUnaryCall(
            new MethodHandlers<
              com.traffic_tacos.gateway.v1.CancelReservationRequest,
              com.traffic_tacos.gateway.v1.CancelReservationResponse>(
                service, METHODID_CANCEL_RESERVATION)))
        .addMethod(
          getCreatePaymentIntentMethod(),
          io.grpc.stub.ServerCalls.asyncUnaryCall(
            new MethodHandlers<
              com.traffic_tacos.gateway.v1.CreatePaymentIntentRequest,
              com.traffic_tacos.gateway.v1.CreatePaymentIntentResponse>(
                service, METHODID_CREATE_PAYMENT_INTENT)))
        .addMethod(
          getGetPaymentStatusMethod(),
          io.grpc.stub.ServerCalls.asyncUnaryCall(
            new MethodHandlers<
              com.traffic_tacos.gateway.v1.GetPaymentStatusRequest,
              com.traffic_tacos.gateway.v1.GetPaymentStatusResponse>(
                service, METHODID_GET_PAYMENT_STATUS)))
        .build();
  }

  private static abstract class GatewayServiceBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoFileDescriptorSupplier, io.grpc.protobuf.ProtoServiceDescriptorSupplier {
    GatewayServiceBaseDescriptorSupplier() {}

    @java.lang.Override
    public com.google.protobuf.Descriptors.FileDescriptor getFileDescriptor() {
      return com.traffic_tacos.gateway.v1.GatewayProto.getDescriptor();
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.ServiceDescriptor getServiceDescriptor() {
      return getFileDescriptor().findServiceByName("GatewayService");
    }
  }

  private static final class GatewayServiceFileDescriptorSupplier
      extends GatewayServiceBaseDescriptorSupplier {
    GatewayServiceFileDescriptorSupplier() {}
  }

  private static final class GatewayServiceMethodDescriptorSupplier
      extends GatewayServiceBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoMethodDescriptorSupplier {
    private final java.lang.String methodName;

    GatewayServiceMethodDescriptorSupplier(java.lang.String methodName) {
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
      synchronized (GatewayServiceGrpc.class) {
        result = serviceDescriptor;
        if (result == null) {
          serviceDescriptor = result = io.grpc.ServiceDescriptor.newBuilder(SERVICE_NAME)
              .setSchemaDescriptor(new GatewayServiceFileDescriptorSupplier())
              .addMethod(getHealthCheckMethod())
              .addMethod(getValidateTokenMethod())
              .addMethod(getGetEventAvailabilityMethod())
              .addMethod(getCreateReservationMethod())
              .addMethod(getGetReservationMethod())
              .addMethod(getConfirmReservationMethod())
              .addMethod(getCancelReservationMethod())
              .addMethod(getCreatePaymentIntentMethod())
              .addMethod(getGetPaymentStatusMethod())
              .build();
        }
      }
    }
    return result;
  }
}

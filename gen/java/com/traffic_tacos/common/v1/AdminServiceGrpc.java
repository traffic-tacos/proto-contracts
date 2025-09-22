package com.traffic_tacos.common.v1;

import static io.grpc.MethodDescriptor.generateFullMethodName;

/**
 * <pre>
 * Admin service for system management and monitoring
 * Provides operational capabilities across all services
 * </pre>
 */
@io.grpc.stub.annotations.GrpcGenerated
public final class AdminServiceGrpc {

  private AdminServiceGrpc() {}

  public static final java.lang.String SERVICE_NAME = "common.v1.AdminService";

  // Static method descriptors that strictly reflect the proto.
  private static volatile io.grpc.MethodDescriptor<com.traffic_tacos.common.v1.GetSystemHealthRequest,
      com.traffic_tacos.common.v1.GetSystemHealthResponse> getGetSystemHealthMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "GetSystemHealth",
      requestType = com.traffic_tacos.common.v1.GetSystemHealthRequest.class,
      responseType = com.traffic_tacos.common.v1.GetSystemHealthResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<com.traffic_tacos.common.v1.GetSystemHealthRequest,
      com.traffic_tacos.common.v1.GetSystemHealthResponse> getGetSystemHealthMethod() {
    io.grpc.MethodDescriptor<com.traffic_tacos.common.v1.GetSystemHealthRequest, com.traffic_tacos.common.v1.GetSystemHealthResponse> getGetSystemHealthMethod;
    if ((getGetSystemHealthMethod = AdminServiceGrpc.getGetSystemHealthMethod) == null) {
      synchronized (AdminServiceGrpc.class) {
        if ((getGetSystemHealthMethod = AdminServiceGrpc.getGetSystemHealthMethod) == null) {
          AdminServiceGrpc.getGetSystemHealthMethod = getGetSystemHealthMethod =
              io.grpc.MethodDescriptor.<com.traffic_tacos.common.v1.GetSystemHealthRequest, com.traffic_tacos.common.v1.GetSystemHealthResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "GetSystemHealth"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.traffic_tacos.common.v1.GetSystemHealthRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.traffic_tacos.common.v1.GetSystemHealthResponse.getDefaultInstance()))
              .setSchemaDescriptor(new AdminServiceMethodDescriptorSupplier("GetSystemHealth"))
              .build();
        }
      }
    }
    return getGetSystemHealthMethod;
  }

  private static volatile io.grpc.MethodDescriptor<com.traffic_tacos.common.v1.GetMetricsRequest,
      com.traffic_tacos.common.v1.GetMetricsResponse> getGetMetricsMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "GetMetrics",
      requestType = com.traffic_tacos.common.v1.GetMetricsRequest.class,
      responseType = com.traffic_tacos.common.v1.GetMetricsResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<com.traffic_tacos.common.v1.GetMetricsRequest,
      com.traffic_tacos.common.v1.GetMetricsResponse> getGetMetricsMethod() {
    io.grpc.MethodDescriptor<com.traffic_tacos.common.v1.GetMetricsRequest, com.traffic_tacos.common.v1.GetMetricsResponse> getGetMetricsMethod;
    if ((getGetMetricsMethod = AdminServiceGrpc.getGetMetricsMethod) == null) {
      synchronized (AdminServiceGrpc.class) {
        if ((getGetMetricsMethod = AdminServiceGrpc.getGetMetricsMethod) == null) {
          AdminServiceGrpc.getGetMetricsMethod = getGetMetricsMethod =
              io.grpc.MethodDescriptor.<com.traffic_tacos.common.v1.GetMetricsRequest, com.traffic_tacos.common.v1.GetMetricsResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "GetMetrics"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.traffic_tacos.common.v1.GetMetricsRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.traffic_tacos.common.v1.GetMetricsResponse.getDefaultInstance()))
              .setSchemaDescriptor(new AdminServiceMethodDescriptorSupplier("GetMetrics"))
              .build();
        }
      }
    }
    return getGetMetricsMethod;
  }

  private static volatile io.grpc.MethodDescriptor<com.traffic_tacos.common.v1.UpdateConfigRequest,
      com.traffic_tacos.common.v1.UpdateConfigResponse> getUpdateConfigMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "UpdateConfig",
      requestType = com.traffic_tacos.common.v1.UpdateConfigRequest.class,
      responseType = com.traffic_tacos.common.v1.UpdateConfigResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<com.traffic_tacos.common.v1.UpdateConfigRequest,
      com.traffic_tacos.common.v1.UpdateConfigResponse> getUpdateConfigMethod() {
    io.grpc.MethodDescriptor<com.traffic_tacos.common.v1.UpdateConfigRequest, com.traffic_tacos.common.v1.UpdateConfigResponse> getUpdateConfigMethod;
    if ((getUpdateConfigMethod = AdminServiceGrpc.getUpdateConfigMethod) == null) {
      synchronized (AdminServiceGrpc.class) {
        if ((getUpdateConfigMethod = AdminServiceGrpc.getUpdateConfigMethod) == null) {
          AdminServiceGrpc.getUpdateConfigMethod = getUpdateConfigMethod =
              io.grpc.MethodDescriptor.<com.traffic_tacos.common.v1.UpdateConfigRequest, com.traffic_tacos.common.v1.UpdateConfigResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "UpdateConfig"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.traffic_tacos.common.v1.UpdateConfigRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.traffic_tacos.common.v1.UpdateConfigResponse.getDefaultInstance()))
              .setSchemaDescriptor(new AdminServiceMethodDescriptorSupplier("UpdateConfig"))
              .build();
        }
      }
    }
    return getUpdateConfigMethod;
  }

  private static volatile io.grpc.MethodDescriptor<com.traffic_tacos.common.v1.TriggerOperationRequest,
      com.traffic_tacos.common.v1.TriggerOperationResponse> getTriggerOperationMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "TriggerOperation",
      requestType = com.traffic_tacos.common.v1.TriggerOperationRequest.class,
      responseType = com.traffic_tacos.common.v1.TriggerOperationResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<com.traffic_tacos.common.v1.TriggerOperationRequest,
      com.traffic_tacos.common.v1.TriggerOperationResponse> getTriggerOperationMethod() {
    io.grpc.MethodDescriptor<com.traffic_tacos.common.v1.TriggerOperationRequest, com.traffic_tacos.common.v1.TriggerOperationResponse> getTriggerOperationMethod;
    if ((getTriggerOperationMethod = AdminServiceGrpc.getTriggerOperationMethod) == null) {
      synchronized (AdminServiceGrpc.class) {
        if ((getTriggerOperationMethod = AdminServiceGrpc.getTriggerOperationMethod) == null) {
          AdminServiceGrpc.getTriggerOperationMethod = getTriggerOperationMethod =
              io.grpc.MethodDescriptor.<com.traffic_tacos.common.v1.TriggerOperationRequest, com.traffic_tacos.common.v1.TriggerOperationResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "TriggerOperation"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.traffic_tacos.common.v1.TriggerOperationRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.traffic_tacos.common.v1.TriggerOperationResponse.getDefaultInstance()))
              .setSchemaDescriptor(new AdminServiceMethodDescriptorSupplier("TriggerOperation"))
              .build();
        }
      }
    }
    return getTriggerOperationMethod;
  }

  private static volatile io.grpc.MethodDescriptor<com.traffic_tacos.common.v1.GetLogsRequest,
      com.traffic_tacos.common.v1.GetLogsResponse> getGetLogsMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "GetLogs",
      requestType = com.traffic_tacos.common.v1.GetLogsRequest.class,
      responseType = com.traffic_tacos.common.v1.GetLogsResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<com.traffic_tacos.common.v1.GetLogsRequest,
      com.traffic_tacos.common.v1.GetLogsResponse> getGetLogsMethod() {
    io.grpc.MethodDescriptor<com.traffic_tacos.common.v1.GetLogsRequest, com.traffic_tacos.common.v1.GetLogsResponse> getGetLogsMethod;
    if ((getGetLogsMethod = AdminServiceGrpc.getGetLogsMethod) == null) {
      synchronized (AdminServiceGrpc.class) {
        if ((getGetLogsMethod = AdminServiceGrpc.getGetLogsMethod) == null) {
          AdminServiceGrpc.getGetLogsMethod = getGetLogsMethod =
              io.grpc.MethodDescriptor.<com.traffic_tacos.common.v1.GetLogsRequest, com.traffic_tacos.common.v1.GetLogsResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "GetLogs"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.traffic_tacos.common.v1.GetLogsRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.traffic_tacos.common.v1.GetLogsResponse.getDefaultInstance()))
              .setSchemaDescriptor(new AdminServiceMethodDescriptorSupplier("GetLogs"))
              .build();
        }
      }
    }
    return getGetLogsMethod;
  }

  private static volatile io.grpc.MethodDescriptor<com.traffic_tacos.common.v1.EmergencyActionRequest,
      com.traffic_tacos.common.v1.EmergencyActionResponse> getEmergencyActionMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "EmergencyAction",
      requestType = com.traffic_tacos.common.v1.EmergencyActionRequest.class,
      responseType = com.traffic_tacos.common.v1.EmergencyActionResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<com.traffic_tacos.common.v1.EmergencyActionRequest,
      com.traffic_tacos.common.v1.EmergencyActionResponse> getEmergencyActionMethod() {
    io.grpc.MethodDescriptor<com.traffic_tacos.common.v1.EmergencyActionRequest, com.traffic_tacos.common.v1.EmergencyActionResponse> getEmergencyActionMethod;
    if ((getEmergencyActionMethod = AdminServiceGrpc.getEmergencyActionMethod) == null) {
      synchronized (AdminServiceGrpc.class) {
        if ((getEmergencyActionMethod = AdminServiceGrpc.getEmergencyActionMethod) == null) {
          AdminServiceGrpc.getEmergencyActionMethod = getEmergencyActionMethod =
              io.grpc.MethodDescriptor.<com.traffic_tacos.common.v1.EmergencyActionRequest, com.traffic_tacos.common.v1.EmergencyActionResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "EmergencyAction"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.traffic_tacos.common.v1.EmergencyActionRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.traffic_tacos.common.v1.EmergencyActionResponse.getDefaultInstance()))
              .setSchemaDescriptor(new AdminServiceMethodDescriptorSupplier("EmergencyAction"))
              .build();
        }
      }
    }
    return getEmergencyActionMethod;
  }

  /**
   * Creates a new async stub that supports all call types for the service
   */
  public static AdminServiceStub newStub(io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<AdminServiceStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<AdminServiceStub>() {
        @java.lang.Override
        public AdminServiceStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new AdminServiceStub(channel, callOptions);
        }
      };
    return AdminServiceStub.newStub(factory, channel);
  }

  /**
   * Creates a new blocking-style stub that supports all types of calls on the service
   */
  public static AdminServiceBlockingV2Stub newBlockingV2Stub(
      io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<AdminServiceBlockingV2Stub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<AdminServiceBlockingV2Stub>() {
        @java.lang.Override
        public AdminServiceBlockingV2Stub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new AdminServiceBlockingV2Stub(channel, callOptions);
        }
      };
    return AdminServiceBlockingV2Stub.newStub(factory, channel);
  }

  /**
   * Creates a new blocking-style stub that supports unary and streaming output calls on the service
   */
  public static AdminServiceBlockingStub newBlockingStub(
      io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<AdminServiceBlockingStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<AdminServiceBlockingStub>() {
        @java.lang.Override
        public AdminServiceBlockingStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new AdminServiceBlockingStub(channel, callOptions);
        }
      };
    return AdminServiceBlockingStub.newStub(factory, channel);
  }

  /**
   * Creates a new ListenableFuture-style stub that supports unary calls on the service
   */
  public static AdminServiceFutureStub newFutureStub(
      io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<AdminServiceFutureStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<AdminServiceFutureStub>() {
        @java.lang.Override
        public AdminServiceFutureStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new AdminServiceFutureStub(channel, callOptions);
        }
      };
    return AdminServiceFutureStub.newStub(factory, channel);
  }

  /**
   * <pre>
   * Admin service for system management and monitoring
   * Provides operational capabilities across all services
   * </pre>
   */
  public interface AsyncService {

    /**
     * <pre>
     * Get system health status
     * </pre>
     */
    default void getSystemHealth(com.traffic_tacos.common.v1.GetSystemHealthRequest request,
        io.grpc.stub.StreamObserver<com.traffic_tacos.common.v1.GetSystemHealthResponse> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getGetSystemHealthMethod(), responseObserver);
    }

    /**
     * <pre>
     * Get service metrics
     * </pre>
     */
    default void getMetrics(com.traffic_tacos.common.v1.GetMetricsRequest request,
        io.grpc.stub.StreamObserver<com.traffic_tacos.common.v1.GetMetricsResponse> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getGetMetricsMethod(), responseObserver);
    }

    /**
     * <pre>
     * Configure system settings
     * </pre>
     */
    default void updateConfig(com.traffic_tacos.common.v1.UpdateConfigRequest request,
        io.grpc.stub.StreamObserver<com.traffic_tacos.common.v1.UpdateConfigResponse> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getUpdateConfigMethod(), responseObserver);
    }

    /**
     * <pre>
     * Trigger manual operations
     * </pre>
     */
    default void triggerOperation(com.traffic_tacos.common.v1.TriggerOperationRequest request,
        io.grpc.stub.StreamObserver<com.traffic_tacos.common.v1.TriggerOperationResponse> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getTriggerOperationMethod(), responseObserver);
    }

    /**
     * <pre>
     * Get system logs
     * </pre>
     */
    default void getLogs(com.traffic_tacos.common.v1.GetLogsRequest request,
        io.grpc.stub.StreamObserver<com.traffic_tacos.common.v1.GetLogsResponse> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getGetLogsMethod(), responseObserver);
    }

    /**
     * <pre>
     * Emergency operations
     * </pre>
     */
    default void emergencyAction(com.traffic_tacos.common.v1.EmergencyActionRequest request,
        io.grpc.stub.StreamObserver<com.traffic_tacos.common.v1.EmergencyActionResponse> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getEmergencyActionMethod(), responseObserver);
    }
  }

  /**
   * Base class for the server implementation of the service AdminService.
   * <pre>
   * Admin service for system management and monitoring
   * Provides operational capabilities across all services
   * </pre>
   */
  public static abstract class AdminServiceImplBase
      implements io.grpc.BindableService, AsyncService {

    @java.lang.Override public final io.grpc.ServerServiceDefinition bindService() {
      return AdminServiceGrpc.bindService(this);
    }
  }

  /**
   * A stub to allow clients to do asynchronous rpc calls to service AdminService.
   * <pre>
   * Admin service for system management and monitoring
   * Provides operational capabilities across all services
   * </pre>
   */
  public static final class AdminServiceStub
      extends io.grpc.stub.AbstractAsyncStub<AdminServiceStub> {
    private AdminServiceStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected AdminServiceStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new AdminServiceStub(channel, callOptions);
    }

    /**
     * <pre>
     * Get system health status
     * </pre>
     */
    public void getSystemHealth(com.traffic_tacos.common.v1.GetSystemHealthRequest request,
        io.grpc.stub.StreamObserver<com.traffic_tacos.common.v1.GetSystemHealthResponse> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getGetSystemHealthMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     * <pre>
     * Get service metrics
     * </pre>
     */
    public void getMetrics(com.traffic_tacos.common.v1.GetMetricsRequest request,
        io.grpc.stub.StreamObserver<com.traffic_tacos.common.v1.GetMetricsResponse> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getGetMetricsMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     * <pre>
     * Configure system settings
     * </pre>
     */
    public void updateConfig(com.traffic_tacos.common.v1.UpdateConfigRequest request,
        io.grpc.stub.StreamObserver<com.traffic_tacos.common.v1.UpdateConfigResponse> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getUpdateConfigMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     * <pre>
     * Trigger manual operations
     * </pre>
     */
    public void triggerOperation(com.traffic_tacos.common.v1.TriggerOperationRequest request,
        io.grpc.stub.StreamObserver<com.traffic_tacos.common.v1.TriggerOperationResponse> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getTriggerOperationMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     * <pre>
     * Get system logs
     * </pre>
     */
    public void getLogs(com.traffic_tacos.common.v1.GetLogsRequest request,
        io.grpc.stub.StreamObserver<com.traffic_tacos.common.v1.GetLogsResponse> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getGetLogsMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     * <pre>
     * Emergency operations
     * </pre>
     */
    public void emergencyAction(com.traffic_tacos.common.v1.EmergencyActionRequest request,
        io.grpc.stub.StreamObserver<com.traffic_tacos.common.v1.EmergencyActionResponse> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getEmergencyActionMethod(), getCallOptions()), request, responseObserver);
    }
  }

  /**
   * A stub to allow clients to do synchronous rpc calls to service AdminService.
   * <pre>
   * Admin service for system management and monitoring
   * Provides operational capabilities across all services
   * </pre>
   */
  public static final class AdminServiceBlockingV2Stub
      extends io.grpc.stub.AbstractBlockingStub<AdminServiceBlockingV2Stub> {
    private AdminServiceBlockingV2Stub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected AdminServiceBlockingV2Stub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new AdminServiceBlockingV2Stub(channel, callOptions);
    }

    /**
     * <pre>
     * Get system health status
     * </pre>
     */
    public com.traffic_tacos.common.v1.GetSystemHealthResponse getSystemHealth(com.traffic_tacos.common.v1.GetSystemHealthRequest request) throws io.grpc.StatusException {
      return io.grpc.stub.ClientCalls.blockingV2UnaryCall(
          getChannel(), getGetSystemHealthMethod(), getCallOptions(), request);
    }

    /**
     * <pre>
     * Get service metrics
     * </pre>
     */
    public com.traffic_tacos.common.v1.GetMetricsResponse getMetrics(com.traffic_tacos.common.v1.GetMetricsRequest request) throws io.grpc.StatusException {
      return io.grpc.stub.ClientCalls.blockingV2UnaryCall(
          getChannel(), getGetMetricsMethod(), getCallOptions(), request);
    }

    /**
     * <pre>
     * Configure system settings
     * </pre>
     */
    public com.traffic_tacos.common.v1.UpdateConfigResponse updateConfig(com.traffic_tacos.common.v1.UpdateConfigRequest request) throws io.grpc.StatusException {
      return io.grpc.stub.ClientCalls.blockingV2UnaryCall(
          getChannel(), getUpdateConfigMethod(), getCallOptions(), request);
    }

    /**
     * <pre>
     * Trigger manual operations
     * </pre>
     */
    public com.traffic_tacos.common.v1.TriggerOperationResponse triggerOperation(com.traffic_tacos.common.v1.TriggerOperationRequest request) throws io.grpc.StatusException {
      return io.grpc.stub.ClientCalls.blockingV2UnaryCall(
          getChannel(), getTriggerOperationMethod(), getCallOptions(), request);
    }

    /**
     * <pre>
     * Get system logs
     * </pre>
     */
    public com.traffic_tacos.common.v1.GetLogsResponse getLogs(com.traffic_tacos.common.v1.GetLogsRequest request) throws io.grpc.StatusException {
      return io.grpc.stub.ClientCalls.blockingV2UnaryCall(
          getChannel(), getGetLogsMethod(), getCallOptions(), request);
    }

    /**
     * <pre>
     * Emergency operations
     * </pre>
     */
    public com.traffic_tacos.common.v1.EmergencyActionResponse emergencyAction(com.traffic_tacos.common.v1.EmergencyActionRequest request) throws io.grpc.StatusException {
      return io.grpc.stub.ClientCalls.blockingV2UnaryCall(
          getChannel(), getEmergencyActionMethod(), getCallOptions(), request);
    }
  }

  /**
   * A stub to allow clients to do limited synchronous rpc calls to service AdminService.
   * <pre>
   * Admin service for system management and monitoring
   * Provides operational capabilities across all services
   * </pre>
   */
  public static final class AdminServiceBlockingStub
      extends io.grpc.stub.AbstractBlockingStub<AdminServiceBlockingStub> {
    private AdminServiceBlockingStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected AdminServiceBlockingStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new AdminServiceBlockingStub(channel, callOptions);
    }

    /**
     * <pre>
     * Get system health status
     * </pre>
     */
    public com.traffic_tacos.common.v1.GetSystemHealthResponse getSystemHealth(com.traffic_tacos.common.v1.GetSystemHealthRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getGetSystemHealthMethod(), getCallOptions(), request);
    }

    /**
     * <pre>
     * Get service metrics
     * </pre>
     */
    public com.traffic_tacos.common.v1.GetMetricsResponse getMetrics(com.traffic_tacos.common.v1.GetMetricsRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getGetMetricsMethod(), getCallOptions(), request);
    }

    /**
     * <pre>
     * Configure system settings
     * </pre>
     */
    public com.traffic_tacos.common.v1.UpdateConfigResponse updateConfig(com.traffic_tacos.common.v1.UpdateConfigRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getUpdateConfigMethod(), getCallOptions(), request);
    }

    /**
     * <pre>
     * Trigger manual operations
     * </pre>
     */
    public com.traffic_tacos.common.v1.TriggerOperationResponse triggerOperation(com.traffic_tacos.common.v1.TriggerOperationRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getTriggerOperationMethod(), getCallOptions(), request);
    }

    /**
     * <pre>
     * Get system logs
     * </pre>
     */
    public com.traffic_tacos.common.v1.GetLogsResponse getLogs(com.traffic_tacos.common.v1.GetLogsRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getGetLogsMethod(), getCallOptions(), request);
    }

    /**
     * <pre>
     * Emergency operations
     * </pre>
     */
    public com.traffic_tacos.common.v1.EmergencyActionResponse emergencyAction(com.traffic_tacos.common.v1.EmergencyActionRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getEmergencyActionMethod(), getCallOptions(), request);
    }
  }

  /**
   * A stub to allow clients to do ListenableFuture-style rpc calls to service AdminService.
   * <pre>
   * Admin service for system management and monitoring
   * Provides operational capabilities across all services
   * </pre>
   */
  public static final class AdminServiceFutureStub
      extends io.grpc.stub.AbstractFutureStub<AdminServiceFutureStub> {
    private AdminServiceFutureStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected AdminServiceFutureStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new AdminServiceFutureStub(channel, callOptions);
    }

    /**
     * <pre>
     * Get system health status
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.traffic_tacos.common.v1.GetSystemHealthResponse> getSystemHealth(
        com.traffic_tacos.common.v1.GetSystemHealthRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getGetSystemHealthMethod(), getCallOptions()), request);
    }

    /**
     * <pre>
     * Get service metrics
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.traffic_tacos.common.v1.GetMetricsResponse> getMetrics(
        com.traffic_tacos.common.v1.GetMetricsRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getGetMetricsMethod(), getCallOptions()), request);
    }

    /**
     * <pre>
     * Configure system settings
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.traffic_tacos.common.v1.UpdateConfigResponse> updateConfig(
        com.traffic_tacos.common.v1.UpdateConfigRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getUpdateConfigMethod(), getCallOptions()), request);
    }

    /**
     * <pre>
     * Trigger manual operations
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.traffic_tacos.common.v1.TriggerOperationResponse> triggerOperation(
        com.traffic_tacos.common.v1.TriggerOperationRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getTriggerOperationMethod(), getCallOptions()), request);
    }

    /**
     * <pre>
     * Get system logs
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.traffic_tacos.common.v1.GetLogsResponse> getLogs(
        com.traffic_tacos.common.v1.GetLogsRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getGetLogsMethod(), getCallOptions()), request);
    }

    /**
     * <pre>
     * Emergency operations
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.traffic_tacos.common.v1.EmergencyActionResponse> emergencyAction(
        com.traffic_tacos.common.v1.EmergencyActionRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getEmergencyActionMethod(), getCallOptions()), request);
    }
  }

  private static final int METHODID_GET_SYSTEM_HEALTH = 0;
  private static final int METHODID_GET_METRICS = 1;
  private static final int METHODID_UPDATE_CONFIG = 2;
  private static final int METHODID_TRIGGER_OPERATION = 3;
  private static final int METHODID_GET_LOGS = 4;
  private static final int METHODID_EMERGENCY_ACTION = 5;

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
        case METHODID_GET_SYSTEM_HEALTH:
          serviceImpl.getSystemHealth((com.traffic_tacos.common.v1.GetSystemHealthRequest) request,
              (io.grpc.stub.StreamObserver<com.traffic_tacos.common.v1.GetSystemHealthResponse>) responseObserver);
          break;
        case METHODID_GET_METRICS:
          serviceImpl.getMetrics((com.traffic_tacos.common.v1.GetMetricsRequest) request,
              (io.grpc.stub.StreamObserver<com.traffic_tacos.common.v1.GetMetricsResponse>) responseObserver);
          break;
        case METHODID_UPDATE_CONFIG:
          serviceImpl.updateConfig((com.traffic_tacos.common.v1.UpdateConfigRequest) request,
              (io.grpc.stub.StreamObserver<com.traffic_tacos.common.v1.UpdateConfigResponse>) responseObserver);
          break;
        case METHODID_TRIGGER_OPERATION:
          serviceImpl.triggerOperation((com.traffic_tacos.common.v1.TriggerOperationRequest) request,
              (io.grpc.stub.StreamObserver<com.traffic_tacos.common.v1.TriggerOperationResponse>) responseObserver);
          break;
        case METHODID_GET_LOGS:
          serviceImpl.getLogs((com.traffic_tacos.common.v1.GetLogsRequest) request,
              (io.grpc.stub.StreamObserver<com.traffic_tacos.common.v1.GetLogsResponse>) responseObserver);
          break;
        case METHODID_EMERGENCY_ACTION:
          serviceImpl.emergencyAction((com.traffic_tacos.common.v1.EmergencyActionRequest) request,
              (io.grpc.stub.StreamObserver<com.traffic_tacos.common.v1.EmergencyActionResponse>) responseObserver);
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
          getGetSystemHealthMethod(),
          io.grpc.stub.ServerCalls.asyncUnaryCall(
            new MethodHandlers<
              com.traffic_tacos.common.v1.GetSystemHealthRequest,
              com.traffic_tacos.common.v1.GetSystemHealthResponse>(
                service, METHODID_GET_SYSTEM_HEALTH)))
        .addMethod(
          getGetMetricsMethod(),
          io.grpc.stub.ServerCalls.asyncUnaryCall(
            new MethodHandlers<
              com.traffic_tacos.common.v1.GetMetricsRequest,
              com.traffic_tacos.common.v1.GetMetricsResponse>(
                service, METHODID_GET_METRICS)))
        .addMethod(
          getUpdateConfigMethod(),
          io.grpc.stub.ServerCalls.asyncUnaryCall(
            new MethodHandlers<
              com.traffic_tacos.common.v1.UpdateConfigRequest,
              com.traffic_tacos.common.v1.UpdateConfigResponse>(
                service, METHODID_UPDATE_CONFIG)))
        .addMethod(
          getTriggerOperationMethod(),
          io.grpc.stub.ServerCalls.asyncUnaryCall(
            new MethodHandlers<
              com.traffic_tacos.common.v1.TriggerOperationRequest,
              com.traffic_tacos.common.v1.TriggerOperationResponse>(
                service, METHODID_TRIGGER_OPERATION)))
        .addMethod(
          getGetLogsMethod(),
          io.grpc.stub.ServerCalls.asyncUnaryCall(
            new MethodHandlers<
              com.traffic_tacos.common.v1.GetLogsRequest,
              com.traffic_tacos.common.v1.GetLogsResponse>(
                service, METHODID_GET_LOGS)))
        .addMethod(
          getEmergencyActionMethod(),
          io.grpc.stub.ServerCalls.asyncUnaryCall(
            new MethodHandlers<
              com.traffic_tacos.common.v1.EmergencyActionRequest,
              com.traffic_tacos.common.v1.EmergencyActionResponse>(
                service, METHODID_EMERGENCY_ACTION)))
        .build();
  }

  private static abstract class AdminServiceBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoFileDescriptorSupplier, io.grpc.protobuf.ProtoServiceDescriptorSupplier {
    AdminServiceBaseDescriptorSupplier() {}

    @java.lang.Override
    public com.google.protobuf.Descriptors.FileDescriptor getFileDescriptor() {
      return com.traffic_tacos.common.v1.AdminProto.getDescriptor();
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.ServiceDescriptor getServiceDescriptor() {
      return getFileDescriptor().findServiceByName("AdminService");
    }
  }

  private static final class AdminServiceFileDescriptorSupplier
      extends AdminServiceBaseDescriptorSupplier {
    AdminServiceFileDescriptorSupplier() {}
  }

  private static final class AdminServiceMethodDescriptorSupplier
      extends AdminServiceBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoMethodDescriptorSupplier {
    private final java.lang.String methodName;

    AdminServiceMethodDescriptorSupplier(java.lang.String methodName) {
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
      synchronized (AdminServiceGrpc.class) {
        result = serviceDescriptor;
        if (result == null) {
          serviceDescriptor = result = io.grpc.ServiceDescriptor.newBuilder(SERVICE_NAME)
              .setSchemaDescriptor(new AdminServiceFileDescriptorSupplier())
              .addMethod(getGetSystemHealthMethod())
              .addMethod(getGetMetricsMethod())
              .addMethod(getUpdateConfigMethod())
              .addMethod(getTriggerOperationMethod())
              .addMethod(getGetLogsMethod())
              .addMethod(getEmergencyActionMethod())
              .build();
        }
      }
    }
    return result;
  }
}

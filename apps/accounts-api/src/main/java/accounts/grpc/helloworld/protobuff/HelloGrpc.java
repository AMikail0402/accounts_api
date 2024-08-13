package accounts.grpc.helloworld.protobuff;

import static io.grpc.MethodDescriptor.generateFullMethodName;
import static io.grpc.stub.ClientCalls.asyncBidiStreamingCall;
import static io.grpc.stub.ClientCalls.asyncClientStreamingCall;
import static io.grpc.stub.ClientCalls.asyncServerStreamingCall;
import static io.grpc.stub.ClientCalls.asyncUnaryCall;
import static io.grpc.stub.ClientCalls.blockingServerStreamingCall;
import static io.grpc.stub.ClientCalls.blockingUnaryCall;
import static io.grpc.stub.ClientCalls.futureUnaryCall;
import static io.grpc.stub.ServerCalls.asyncBidiStreamingCall;
import static io.grpc.stub.ServerCalls.asyncClientStreamingCall;
import static io.grpc.stub.ServerCalls.asyncServerStreamingCall;
import static io.grpc.stub.ServerCalls.asyncUnaryCall;
import static io.grpc.stub.ServerCalls.asyncUnimplementedStreamingCall;
import static io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall;

/**
 * <pre>
 * The greeting service definition.
 * </pre>
 */
@javax.annotation.Generated(
    value = "by gRPC proto compiler (version 1.15.0)",
    comments = "Source: helloworld.proto")
public final class HelloGrpc {

  private HelloGrpc() {}

  public static final String SERVICE_NAME = "Hello";

  // Static method descriptors that strictly reflect the proto.
  private static volatile io.grpc.MethodDescriptor<accounts.grpc.helloworld.protobuff.Helloworld.LoginRequest,
      accounts.grpc.helloworld.protobuff.Helloworld.ApiResponse> getLoginMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "login",
      requestType = accounts.grpc.helloworld.protobuff.Helloworld.LoginRequest.class,
      responseType = accounts.grpc.helloworld.protobuff.Helloworld.ApiResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<accounts.grpc.helloworld.protobuff.Helloworld.LoginRequest,
      accounts.grpc.helloworld.protobuff.Helloworld.ApiResponse> getLoginMethod() {
    io.grpc.MethodDescriptor<accounts.grpc.helloworld.protobuff.Helloworld.LoginRequest, accounts.grpc.helloworld.protobuff.Helloworld.ApiResponse> getLoginMethod;
    if ((getLoginMethod = HelloGrpc.getLoginMethod) == null) {
      synchronized (HelloGrpc.class) {
        if ((getLoginMethod = HelloGrpc.getLoginMethod) == null) {
          HelloGrpc.getLoginMethod = getLoginMethod = 
              io.grpc.MethodDescriptor.<accounts.grpc.helloworld.protobuff.Helloworld.LoginRequest, accounts.grpc.helloworld.protobuff.Helloworld.ApiResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(
                  "Hello", "login"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  accounts.grpc.helloworld.protobuff.Helloworld.LoginRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  accounts.grpc.helloworld.protobuff.Helloworld.ApiResponse.getDefaultInstance()))
                  .setSchemaDescriptor(new HelloMethodDescriptorSupplier("login"))
                  .build();
          }
        }
     }
     return getLoginMethod;
  }

  private static volatile io.grpc.MethodDescriptor<accounts.grpc.helloworld.protobuff.Helloworld.Empty,
      accounts.grpc.helloworld.protobuff.Helloworld.ApiResponse> getLogoutMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "logout",
      requestType = accounts.grpc.helloworld.protobuff.Helloworld.Empty.class,
      responseType = accounts.grpc.helloworld.protobuff.Helloworld.ApiResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<accounts.grpc.helloworld.protobuff.Helloworld.Empty,
      accounts.grpc.helloworld.protobuff.Helloworld.ApiResponse> getLogoutMethod() {
    io.grpc.MethodDescriptor<accounts.grpc.helloworld.protobuff.Helloworld.Empty, accounts.grpc.helloworld.protobuff.Helloworld.ApiResponse> getLogoutMethod;
    if ((getLogoutMethod = HelloGrpc.getLogoutMethod) == null) {
      synchronized (HelloGrpc.class) {
        if ((getLogoutMethod = HelloGrpc.getLogoutMethod) == null) {
          HelloGrpc.getLogoutMethod = getLogoutMethod = 
              io.grpc.MethodDescriptor.<accounts.grpc.helloworld.protobuff.Helloworld.Empty, accounts.grpc.helloworld.protobuff.Helloworld.ApiResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(
                  "Hello", "logout"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  accounts.grpc.helloworld.protobuff.Helloworld.Empty.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  accounts.grpc.helloworld.protobuff.Helloworld.ApiResponse.getDefaultInstance()))
                  .setSchemaDescriptor(new HelloMethodDescriptorSupplier("logout"))
                  .build();
          }
        }
     }
     return getLogoutMethod;
  }

  /**
   * Creates a new async stub that supports all call types for the service
   */
  public static HelloStub newStub(io.grpc.Channel channel) {
    return new HelloStub(channel);
  }

  /**
   * Creates a new blocking-style stub that supports unary and streaming output calls on the service
   */
  public static HelloBlockingStub newBlockingStub(
      io.grpc.Channel channel) {
    return new HelloBlockingStub(channel);
  }

  /**
   * Creates a new ListenableFuture-style stub that supports unary calls on the service
   */
  public static HelloFutureStub newFutureStub(
      io.grpc.Channel channel) {
    return new HelloFutureStub(channel);
  }

  /**
   * <pre>
   * The greeting service definition.
   * </pre>
   */
  public static abstract class HelloImplBase implements io.grpc.BindableService {

    /**
     */
    public void login(accounts.grpc.helloworld.protobuff.Helloworld.LoginRequest request,
        io.grpc.stub.StreamObserver<accounts.grpc.helloworld.protobuff.Helloworld.ApiResponse> responseObserver) {
      asyncUnimplementedUnaryCall(getLoginMethod(), responseObserver);
    }

    /**
     */
    public void logout(accounts.grpc.helloworld.protobuff.Helloworld.Empty request,
        io.grpc.stub.StreamObserver<accounts.grpc.helloworld.protobuff.Helloworld.ApiResponse> responseObserver) {
      asyncUnimplementedUnaryCall(getLogoutMethod(), responseObserver);
    }

    @java.lang.Override public final io.grpc.ServerServiceDefinition bindService() {
      return io.grpc.ServerServiceDefinition.builder(getServiceDescriptor())
          .addMethod(
            getLoginMethod(),
            asyncUnaryCall(
              new MethodHandlers<
                accounts.grpc.helloworld.protobuff.Helloworld.LoginRequest,
                accounts.grpc.helloworld.protobuff.Helloworld.ApiResponse>(
                  this, METHODID_LOGIN)))
          .addMethod(
            getLogoutMethod(),
            asyncUnaryCall(
              new MethodHandlers<
                accounts.grpc.helloworld.protobuff.Helloworld.Empty,
                accounts.grpc.helloworld.protobuff.Helloworld.ApiResponse>(
                  this, METHODID_LOGOUT)))
          .build();
    }
  }

  /**
   * <pre>
   * The greeting service definition.
   * </pre>
   */
  public static final class HelloStub extends io.grpc.stub.AbstractStub<HelloStub> {
    private HelloStub(io.grpc.Channel channel) {
      super(channel);
    }

    private HelloStub(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected HelloStub build(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      return new HelloStub(channel, callOptions);
    }

    /**
     */
    public void login(accounts.grpc.helloworld.protobuff.Helloworld.LoginRequest request,
        io.grpc.stub.StreamObserver<accounts.grpc.helloworld.protobuff.Helloworld.ApiResponse> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getLoginMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void logout(accounts.grpc.helloworld.protobuff.Helloworld.Empty request,
        io.grpc.stub.StreamObserver<accounts.grpc.helloworld.protobuff.Helloworld.ApiResponse> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getLogoutMethod(), getCallOptions()), request, responseObserver);
    }
  }

  /**
   * <pre>
   * The greeting service definition.
   * </pre>
   */
  public static final class HelloBlockingStub extends io.grpc.stub.AbstractStub<HelloBlockingStub> {
    private HelloBlockingStub(io.grpc.Channel channel) {
      super(channel);
    }

    private HelloBlockingStub(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected HelloBlockingStub build(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      return new HelloBlockingStub(channel, callOptions);
    }

    /**
     */
    public accounts.grpc.helloworld.protobuff.Helloworld.ApiResponse login(accounts.grpc.helloworld.protobuff.Helloworld.LoginRequest request) {
      return blockingUnaryCall(
          getChannel(), getLoginMethod(), getCallOptions(), request);
    }

    /**
     */
    public accounts.grpc.helloworld.protobuff.Helloworld.ApiResponse logout(accounts.grpc.helloworld.protobuff.Helloworld.Empty request) {
      return blockingUnaryCall(
          getChannel(), getLogoutMethod(), getCallOptions(), request);
    }
  }

  /**
   * <pre>
   * The greeting service definition.
   * </pre>
   */
  public static final class HelloFutureStub extends io.grpc.stub.AbstractStub<HelloFutureStub> {
    private HelloFutureStub(io.grpc.Channel channel) {
      super(channel);
    }

    private HelloFutureStub(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected HelloFutureStub build(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      return new HelloFutureStub(channel, callOptions);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<accounts.grpc.helloworld.protobuff.Helloworld.ApiResponse> login(
        accounts.grpc.helloworld.protobuff.Helloworld.LoginRequest request) {
      return futureUnaryCall(
          getChannel().newCall(getLoginMethod(), getCallOptions()), request);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<accounts.grpc.helloworld.protobuff.Helloworld.ApiResponse> logout(
        accounts.grpc.helloworld.protobuff.Helloworld.Empty request) {
      return futureUnaryCall(
          getChannel().newCall(getLogoutMethod(), getCallOptions()), request);
    }
  }

  private static final int METHODID_LOGIN = 0;
  private static final int METHODID_LOGOUT = 1;

  private static final class MethodHandlers<Req, Resp> implements
      io.grpc.stub.ServerCalls.UnaryMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ServerStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ClientStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.BidiStreamingMethod<Req, Resp> {
    private final HelloImplBase serviceImpl;
    private final int methodId;

    MethodHandlers(HelloImplBase serviceImpl, int methodId) {
      this.serviceImpl = serviceImpl;
      this.methodId = methodId;
    }

    @java.lang.Override
    @java.lang.SuppressWarnings("unchecked")
    public void invoke(Req request, io.grpc.stub.StreamObserver<Resp> responseObserver) {
      switch (methodId) {
        case METHODID_LOGIN:
          serviceImpl.login((accounts.grpc.helloworld.protobuff.Helloworld.LoginRequest) request,
              (io.grpc.stub.StreamObserver<accounts.grpc.helloworld.protobuff.Helloworld.ApiResponse>) responseObserver);
          break;
        case METHODID_LOGOUT:
          serviceImpl.logout((accounts.grpc.helloworld.protobuff.Helloworld.Empty) request,
              (io.grpc.stub.StreamObserver<accounts.grpc.helloworld.protobuff.Helloworld.ApiResponse>) responseObserver);
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

  private static abstract class HelloBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoFileDescriptorSupplier, io.grpc.protobuf.ProtoServiceDescriptorSupplier {
    HelloBaseDescriptorSupplier() {}

    @java.lang.Override
    public com.google.protobuf.Descriptors.FileDescriptor getFileDescriptor() {
      return accounts.grpc.helloworld.protobuff.Helloworld.getDescriptor();
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.ServiceDescriptor getServiceDescriptor() {
      return getFileDescriptor().findServiceByName("Hello");
    }
  }

  private static final class HelloFileDescriptorSupplier
      extends HelloBaseDescriptorSupplier {
    HelloFileDescriptorSupplier() {}
  }

  private static final class HelloMethodDescriptorSupplier
      extends HelloBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoMethodDescriptorSupplier {
    private final String methodName;

    HelloMethodDescriptorSupplier(String methodName) {
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
      synchronized (HelloGrpc.class) {
        result = serviceDescriptor;
        if (result == null) {
          serviceDescriptor = result = io.grpc.ServiceDescriptor.newBuilder(SERVICE_NAME)
              .setSchemaDescriptor(new HelloFileDescriptorSupplier())
              .addMethod(getLoginMethod())
              .addMethod(getLogoutMethod())
              .build();
        }
      }
    }
    return result;
  }
}

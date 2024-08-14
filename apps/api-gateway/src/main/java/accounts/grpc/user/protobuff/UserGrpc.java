package accounts.grpc.user.protobuff;

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
    comments = "Source: user.proto")
public final class UserGrpc {

  private UserGrpc() {}

  public static final String SERVICE_NAME = "User";

  // Static method descriptors that strictly reflect the proto.
  private static volatile io.grpc.MethodDescriptor<accounts.grpc.user.protobuff.UserOuterClass.Empty,
      accounts.grpc.user.protobuff.UserOuterClass.UserList> getGetUsersMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "getUsers",
      requestType = accounts.grpc.user.protobuff.UserOuterClass.Empty.class,
      responseType = accounts.grpc.user.protobuff.UserOuterClass.UserList.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<accounts.grpc.user.protobuff.UserOuterClass.Empty,
      accounts.grpc.user.protobuff.UserOuterClass.UserList> getGetUsersMethod() {
    io.grpc.MethodDescriptor<accounts.grpc.user.protobuff.UserOuterClass.Empty, accounts.grpc.user.protobuff.UserOuterClass.UserList> getGetUsersMethod;
    if ((getGetUsersMethod = UserGrpc.getGetUsersMethod) == null) {
      synchronized (UserGrpc.class) {
        if ((getGetUsersMethod = UserGrpc.getGetUsersMethod) == null) {
          UserGrpc.getGetUsersMethod = getGetUsersMethod = 
              io.grpc.MethodDescriptor.<accounts.grpc.user.protobuff.UserOuterClass.Empty, accounts.grpc.user.protobuff.UserOuterClass.UserList>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(
                  "User", "getUsers"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  accounts.grpc.user.protobuff.UserOuterClass.Empty.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  accounts.grpc.user.protobuff.UserOuterClass.UserList.getDefaultInstance()))
                  .setSchemaDescriptor(new UserMethodDescriptorSupplier("getUsers"))
                  .build();
          }
        }
     }
     return getGetUsersMethod;
  }

  private static volatile io.grpc.MethodDescriptor<accounts.grpc.user.protobuff.UserOuterClass.AddUserDto,
      accounts.grpc.user.protobuff.UserOuterClass.Empty> getAddUserMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "addUser",
      requestType = accounts.grpc.user.protobuff.UserOuterClass.AddUserDto.class,
      responseType = accounts.grpc.user.protobuff.UserOuterClass.Empty.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<accounts.grpc.user.protobuff.UserOuterClass.AddUserDto,
      accounts.grpc.user.protobuff.UserOuterClass.Empty> getAddUserMethod() {
    io.grpc.MethodDescriptor<accounts.grpc.user.protobuff.UserOuterClass.AddUserDto, accounts.grpc.user.protobuff.UserOuterClass.Empty> getAddUserMethod;
    if ((getAddUserMethod = UserGrpc.getAddUserMethod) == null) {
      synchronized (UserGrpc.class) {
        if ((getAddUserMethod = UserGrpc.getAddUserMethod) == null) {
          UserGrpc.getAddUserMethod = getAddUserMethod = 
              io.grpc.MethodDescriptor.<accounts.grpc.user.protobuff.UserOuterClass.AddUserDto, accounts.grpc.user.protobuff.UserOuterClass.Empty>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(
                  "User", "addUser"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  accounts.grpc.user.protobuff.UserOuterClass.AddUserDto.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  accounts.grpc.user.protobuff.UserOuterClass.Empty.getDefaultInstance()))
                  .setSchemaDescriptor(new UserMethodDescriptorSupplier("addUser"))
                  .build();
          }
        }
     }
     return getAddUserMethod;
  }

  private static volatile io.grpc.MethodDescriptor<accounts.grpc.user.protobuff.UserOuterClass.DeleteUserDto,
      accounts.grpc.user.protobuff.UserOuterClass.Empty> getDeleteUserMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "deleteUser",
      requestType = accounts.grpc.user.protobuff.UserOuterClass.DeleteUserDto.class,
      responseType = accounts.grpc.user.protobuff.UserOuterClass.Empty.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<accounts.grpc.user.protobuff.UserOuterClass.DeleteUserDto,
      accounts.grpc.user.protobuff.UserOuterClass.Empty> getDeleteUserMethod() {
    io.grpc.MethodDescriptor<accounts.grpc.user.protobuff.UserOuterClass.DeleteUserDto, accounts.grpc.user.protobuff.UserOuterClass.Empty> getDeleteUserMethod;
    if ((getDeleteUserMethod = UserGrpc.getDeleteUserMethod) == null) {
      synchronized (UserGrpc.class) {
        if ((getDeleteUserMethod = UserGrpc.getDeleteUserMethod) == null) {
          UserGrpc.getDeleteUserMethod = getDeleteUserMethod = 
              io.grpc.MethodDescriptor.<accounts.grpc.user.protobuff.UserOuterClass.DeleteUserDto, accounts.grpc.user.protobuff.UserOuterClass.Empty>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(
                  "User", "deleteUser"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  accounts.grpc.user.protobuff.UserOuterClass.DeleteUserDto.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  accounts.grpc.user.protobuff.UserOuterClass.Empty.getDefaultInstance()))
                  .setSchemaDescriptor(new UserMethodDescriptorSupplier("deleteUser"))
                  .build();
          }
        }
     }
     return getDeleteUserMethod;
  }

  /**
   * Creates a new async stub that supports all call types for the service
   */
  public static UserStub newStub(io.grpc.Channel channel) {
    return new UserStub(channel);
  }

  /**
   * Creates a new blocking-style stub that supports unary and streaming output calls on the service
   */
  public static UserBlockingStub newBlockingStub(
      io.grpc.Channel channel) {
    return new UserBlockingStub(channel);
  }

  /**
   * Creates a new ListenableFuture-style stub that supports unary calls on the service
   */
  public static UserFutureStub newFutureStub(
      io.grpc.Channel channel) {
    return new UserFutureStub(channel);
  }

  /**
   * <pre>
   * The greeting service definition.
   * </pre>
   */
  public static abstract class UserImplBase implements io.grpc.BindableService {

    /**
     */
    public void getUsers(accounts.grpc.user.protobuff.UserOuterClass.Empty request,
        io.grpc.stub.StreamObserver<accounts.grpc.user.protobuff.UserOuterClass.UserList> responseObserver) {
      asyncUnimplementedUnaryCall(getGetUsersMethod(), responseObserver);
    }

    /**
     */
    public void addUser(accounts.grpc.user.protobuff.UserOuterClass.AddUserDto request,
        io.grpc.stub.StreamObserver<accounts.grpc.user.protobuff.UserOuterClass.Empty> responseObserver) {
      asyncUnimplementedUnaryCall(getAddUserMethod(), responseObserver);
    }

    /**
     */
    public void deleteUser(accounts.grpc.user.protobuff.UserOuterClass.DeleteUserDto request,
        io.grpc.stub.StreamObserver<accounts.grpc.user.protobuff.UserOuterClass.Empty> responseObserver) {
      asyncUnimplementedUnaryCall(getDeleteUserMethod(), responseObserver);
    }

    @java.lang.Override public final io.grpc.ServerServiceDefinition bindService() {
      return io.grpc.ServerServiceDefinition.builder(getServiceDescriptor())
          .addMethod(
            getGetUsersMethod(),
            asyncUnaryCall(
              new MethodHandlers<
                accounts.grpc.user.protobuff.UserOuterClass.Empty,
                accounts.grpc.user.protobuff.UserOuterClass.UserList>(
                  this, METHODID_GET_USERS)))
          .addMethod(
            getAddUserMethod(),
            asyncUnaryCall(
              new MethodHandlers<
                accounts.grpc.user.protobuff.UserOuterClass.AddUserDto,
                accounts.grpc.user.protobuff.UserOuterClass.Empty>(
                  this, METHODID_ADD_USER)))
          .addMethod(
            getDeleteUserMethod(),
            asyncUnaryCall(
              new MethodHandlers<
                accounts.grpc.user.protobuff.UserOuterClass.DeleteUserDto,
                accounts.grpc.user.protobuff.UserOuterClass.Empty>(
                  this, METHODID_DELETE_USER)))
          .build();
    }
  }

  /**
   * <pre>
   * The greeting service definition.
   * </pre>
   */
  public static final class UserStub extends io.grpc.stub.AbstractStub<UserStub> {
    private UserStub(io.grpc.Channel channel) {
      super(channel);
    }

    private UserStub(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected UserStub build(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      return new UserStub(channel, callOptions);
    }

    /**
     */
    public void getUsers(accounts.grpc.user.protobuff.UserOuterClass.Empty request,
        io.grpc.stub.StreamObserver<accounts.grpc.user.protobuff.UserOuterClass.UserList> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getGetUsersMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void addUser(accounts.grpc.user.protobuff.UserOuterClass.AddUserDto request,
        io.grpc.stub.StreamObserver<accounts.grpc.user.protobuff.UserOuterClass.Empty> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getAddUserMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void deleteUser(accounts.grpc.user.protobuff.UserOuterClass.DeleteUserDto request,
        io.grpc.stub.StreamObserver<accounts.grpc.user.protobuff.UserOuterClass.Empty> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getDeleteUserMethod(), getCallOptions()), request, responseObserver);
    }
  }

  /**
   * <pre>
   * The greeting service definition.
   * </pre>
   */
  public static final class UserBlockingStub extends io.grpc.stub.AbstractStub<UserBlockingStub> {
    private UserBlockingStub(io.grpc.Channel channel) {
      super(channel);
    }

    private UserBlockingStub(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected UserBlockingStub build(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      return new UserBlockingStub(channel, callOptions);
    }

    /**
     */
    public accounts.grpc.user.protobuff.UserOuterClass.UserList getUsers(accounts.grpc.user.protobuff.UserOuterClass.Empty request) {
      return blockingUnaryCall(
          getChannel(), getGetUsersMethod(), getCallOptions(), request);
    }

    /**
     */
    public accounts.grpc.user.protobuff.UserOuterClass.Empty addUser(accounts.grpc.user.protobuff.UserOuterClass.AddUserDto request) {
      return blockingUnaryCall(
          getChannel(), getAddUserMethod(), getCallOptions(), request);
    }

    /**
     */
    public accounts.grpc.user.protobuff.UserOuterClass.Empty deleteUser(accounts.grpc.user.protobuff.UserOuterClass.DeleteUserDto request) {
      return blockingUnaryCall(
          getChannel(), getDeleteUserMethod(), getCallOptions(), request);
    }
  }

  /**
   * <pre>
   * The greeting service definition.
   * </pre>
   */
  public static final class UserFutureStub extends io.grpc.stub.AbstractStub<UserFutureStub> {
    private UserFutureStub(io.grpc.Channel channel) {
      super(channel);
    }

    private UserFutureStub(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected UserFutureStub build(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      return new UserFutureStub(channel, callOptions);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<accounts.grpc.user.protobuff.UserOuterClass.UserList> getUsers(
        accounts.grpc.user.protobuff.UserOuterClass.Empty request) {
      return futureUnaryCall(
          getChannel().newCall(getGetUsersMethod(), getCallOptions()), request);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<accounts.grpc.user.protobuff.UserOuterClass.Empty> addUser(
        accounts.grpc.user.protobuff.UserOuterClass.AddUserDto request) {
      return futureUnaryCall(
          getChannel().newCall(getAddUserMethod(), getCallOptions()), request);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<accounts.grpc.user.protobuff.UserOuterClass.Empty> deleteUser(
        accounts.grpc.user.protobuff.UserOuterClass.DeleteUserDto request) {
      return futureUnaryCall(
          getChannel().newCall(getDeleteUserMethod(), getCallOptions()), request);
    }
  }

  private static final int METHODID_GET_USERS = 0;
  private static final int METHODID_ADD_USER = 1;
  private static final int METHODID_DELETE_USER = 2;

  private static final class MethodHandlers<Req, Resp> implements
      io.grpc.stub.ServerCalls.UnaryMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ServerStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ClientStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.BidiStreamingMethod<Req, Resp> {
    private final UserImplBase serviceImpl;
    private final int methodId;

    MethodHandlers(UserImplBase serviceImpl, int methodId) {
      this.serviceImpl = serviceImpl;
      this.methodId = methodId;
    }

    @java.lang.Override
    @java.lang.SuppressWarnings("unchecked")
    public void invoke(Req request, io.grpc.stub.StreamObserver<Resp> responseObserver) {
      switch (methodId) {
        case METHODID_GET_USERS:
          serviceImpl.getUsers((accounts.grpc.user.protobuff.UserOuterClass.Empty) request,
              (io.grpc.stub.StreamObserver<accounts.grpc.user.protobuff.UserOuterClass.UserList>) responseObserver);
          break;
        case METHODID_ADD_USER:
          serviceImpl.addUser((accounts.grpc.user.protobuff.UserOuterClass.AddUserDto) request,
              (io.grpc.stub.StreamObserver<accounts.grpc.user.protobuff.UserOuterClass.Empty>) responseObserver);
          break;
        case METHODID_DELETE_USER:
          serviceImpl.deleteUser((accounts.grpc.user.protobuff.UserOuterClass.DeleteUserDto) request,
              (io.grpc.stub.StreamObserver<accounts.grpc.user.protobuff.UserOuterClass.Empty>) responseObserver);
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

  private static abstract class UserBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoFileDescriptorSupplier, io.grpc.protobuf.ProtoServiceDescriptorSupplier {
    UserBaseDescriptorSupplier() {}

    @java.lang.Override
    public com.google.protobuf.Descriptors.FileDescriptor getFileDescriptor() {
      return accounts.grpc.user.protobuff.UserOuterClass.getDescriptor();
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.ServiceDescriptor getServiceDescriptor() {
      return getFileDescriptor().findServiceByName("User");
    }
  }

  private static final class UserFileDescriptorSupplier
      extends UserBaseDescriptorSupplier {
    UserFileDescriptorSupplier() {}
  }

  private static final class UserMethodDescriptorSupplier
      extends UserBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoMethodDescriptorSupplier {
    private final String methodName;

    UserMethodDescriptorSupplier(String methodName) {
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
      synchronized (UserGrpc.class) {
        result = serviceDescriptor;
        if (result == null) {
          serviceDescriptor = result = io.grpc.ServiceDescriptor.newBuilder(SERVICE_NAME)
              .setSchemaDescriptor(new UserFileDescriptorSupplier())
              .addMethod(getGetUsersMethod())
              .addMethod(getAddUserMethod())
              .addMethod(getDeleteUserMethod())
              .build();
        }
      }
    }
    return result;
  }
}

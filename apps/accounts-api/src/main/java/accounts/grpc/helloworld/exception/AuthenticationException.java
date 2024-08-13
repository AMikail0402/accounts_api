package accounts.grpc.helloworld.exception;

import io.grpc.Status;
import io.grpc.stub.StreamObserver;

public class AuthenticationException extends RuntimeException {
    AuthenticationException(){}
    public <T> AuthenticationException(StreamObserver<T> responseObserver, String message){
        super(message);
        responseObserver.onError(Status.PERMISSION_DENIED.withDescription(message).asRuntimeException());
    }
}

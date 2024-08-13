package accounts.grpc.helloworld.service;

import accounts.grpc.helloworld.protobuff.Accounting.ApiResponse;
import accounts.grpc.helloworld.protobuff.Accounting.Empty;
import accounts.grpc.helloworld.protobuff.Accounting.LoginRequest;
import accounts.grpc.helloworld.protobuff.userGrpc;
import io.grpc.stub.StreamObserver;

public class UserService extends userGrpc.userImplBase {

    @Override
    public void login(LoginRequest request,
        StreamObserver<ApiResponse> responseObserver){

        System.out.println("LOGIN IST GESCHEHEN");

        String username = request.getUsername();
        String password = request.getPassword();

        ApiResponse.Builder response  = ApiResponse.newBuilder(); 

        if(username.equals(password)){
            response.setResponseCode(200).setResponsemessage("Success");
        }
        else {
            response.setResponseCode(401).setResponsemessage("Authentifizierungsfehler");
        }

        responseObserver.onNext(response.build());
        responseObserver.onCompleted();

    }

    @Override
    public void logout(Empty request,
        StreamObserver<ApiResponse> responseObserver){
       
    }

}

package accounts.grpc.helloworld.service;


import accounts.grpc.helloworld.exception.AuthenticationException;
import accounts.grpc.helloworld.protobuff.Helloworld.ApiResponse;
import accounts.grpc.helloworld.protobuff.Helloworld.Empty;
import accounts.grpc.helloworld.protobuff.Helloworld.LoginRequest;
import accounts.grpc.helloworld.protobuff.HelloGrpc.HelloImplBase;

import accounts.grpc.util.ResponseBuilder;

import io.grpc.stub.StreamObserver;


public class HelloService extends HelloImplBase {

    @Override
    public void login(LoginRequest request,
        StreamObserver<ApiResponse> responseObserver){

        String username = request.getUsername();
        String password = request.getPassword();

        ApiResponse.Builder response  = ApiResponse.newBuilder(); 

        if(username.equals(password)){
            response.setResponseCode(200).setResponsemessage("Success");
        }
        else {
            throw new AuthenticationException(responseObserver,"Nutzername und Passwort stimmen nicht überein");
        }

        new ResponseBuilder<ApiResponse>(responseObserver)
                            .onNext(response.build()).build()
                            .onCompleted();
    }

    @Override
    public void logout(Empty empty,StreamObserver<ApiResponse> responseObserver){
            
        ApiResponse response  = ApiResponse.newBuilder()
                                           .setResponseCode(200)
                                           .setResponsemessage("Logout erfolgreich")
                                           .build();
        

        new ResponseBuilder<ApiResponse>(responseObserver).onNext(response).build().onCompleted();
        
    }

}

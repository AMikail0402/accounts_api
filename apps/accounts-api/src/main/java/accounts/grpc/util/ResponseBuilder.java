package accounts.grpc.util;

import io.grpc.stub.StreamObserver;

public class ResponseBuilder<T> {
    
    StreamObserver<T> response;

    public ResponseBuilder(StreamObserver<T> response){
        this.response = response;
    }

    public ResponseBuilder<T> onNext(T payload){
        
        this.response.onNext(payload);

        return this;
    }

    public StreamObserver<T> build(){
        return this.response;
    }

}

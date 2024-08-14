package accounts.grpc.user;

import static io.grpc.stub.ServerCalls.asyncBidiStreamingCall;

import java.io.IOException;
import java.sql.Array;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutionException;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.common.util.concurrent.FutureCallback;
import com.google.common.util.concurrent.Futures;
import com.google.common.util.concurrent.ListenableFuture;
import com.google.common.util.concurrent.MoreExecutors;

import accounts.grpc.user.protobuff.UserGrpc;
import accounts.grpc.user.protobuff.UserGrpc.UserBlockingStub;
import accounts.grpc.user.protobuff.UserGrpc.UserFutureStub;
import accounts.grpc.user.protobuff.UserGrpc.UserStub;
import accounts.grpc.user.protobuff.UserOuterClass.UserList;
import accounts.grpc.user.protobuff.UserOuterClass.UserReadDto;

import io.grpc.Channel;
import io.grpc.ChannelCredentials;
import io.grpc.Grpc;
import io.grpc.InsecureChannelCredentials;
import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;
import io.grpc.Status;
import io.grpc.Status.Code;
import io.netty.util.concurrent.Future;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

public class UserCallBack {

    static Channel channel = ManagedChannelBuilder
            .forAddress("localhost", 8081)
            .usePlaintext()
            .build();
    
    static ObjectMapper mapper = new ObjectMapper();

    static UserBlockingStub stub = UserGrpc.newBlockingStub(channel);
    static  OkHttpClient client = new OkHttpClient();
    public static void main( String[] args ) throws InterruptedException, ExecutionException, IOException
    {
        run();
        int iterations = 50;
        
        int devation = 0;
        for(int j = 0;j<5;j++){
            Long before = System.currentTimeMillis();
            for(int i =0;i<iterations;i++){
                run();
            }
            Long after = System.currentTimeMillis()-before;
            System.out.println("Zeit für Grpc"+after);
            httpRun();
            Long beforehttp = System.currentTimeMillis();
            for(int i =0;i<iterations;i++){
                httpRun();
            }
            Long afterhttp = System.currentTimeMillis()-beforehttp;
            System.out.println("Zeit für http"+afterhttp);
            devation += afterhttp -after;
        }
        devation = devation/5;

        System.out.println("GRPC ist um "+devation+" ms schneller als http");
        
    }
    
    public static List<UserReadDto> run() throws InterruptedException, ExecutionException{
        int errors = 0;
        Long before = System.currentTimeMillis();

        List<UserReadDto> allUsers = new ArrayList<>();

        return stub.getUsers(null).getUserReadDataList();

    }

    public static UserReadDto[] httpRun() throws IOException{


        Request request = new Request.Builder()
        .url("http://localhost:8080/api/user")
        .get()
        .addHeader("User-Agent", "insomnia/2023.5.8")
        .build();

        Response response = client.newCall(request).execute();
        
        UserReadDto[] userlist = mapper.readValue(response.body().string(), UserReadDto[].class);

        System.out.println();
      
        return userlist;

    }
}

package accounts.grpc.user;

import java.util.concurrent.ExecutionException;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.google.gson.Gson;

import accounts.grpc.user.protobuff.UserGrpc;
import accounts.grpc.user.protobuff.UserGrpc.UserBlockingStub;
import accounts.util.EnvUtils;
import io.grpc.Channel;
import io.grpc.ManagedChannelBuilder;

@RestController
@RequestMapping("api/helloworld")
public class UserCallBack {

    Channel channel = ManagedChannelBuilder
            .forAddress(
                EnvUtils.getEnv("ACCOUNTS_API_DOMAIN"),
                Integer.parseInt(EnvUtils.getEnv("ACCOUNTS_API_PORT"))
            )
            .usePlaintext()
            .build();
    
    UserBlockingStub stub = UserGrpc.newBlockingStub(channel);

    Gson gson = new Gson();

    @PostMapping
    public String test(){
        return "test";
    }

    @GetMapping
    public  String getUsers() throws InterruptedException, ExecutionException{
       return gson.toJson(stub.getUsers(null).getUserReadDataList());

    }


}

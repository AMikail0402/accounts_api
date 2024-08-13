package accounts;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.WebApplicationType;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;

import accounts.grpc.helloworld.service.UserService;
import io.grpc.Grpc;
import io.grpc.InsecureServerCredentials;
import io.grpc.Server;
import io.grpc.ServerCredentials;

@SpringBootApplication
public class App 
{
    public static void main( String[] args ) throws Exception{
        
        new SpringApplicationBuilder(App.class)
        .web(WebApplicationType.NONE)
        .run();

        ServerCredentials credential = InsecureServerCredentials.create();
        Server server = Grpc.newServerBuilderForPort(8081, credential)
                            .addService(new UserService())
                            .build()
                            .start();
        server.awaitTermination();



    }


}

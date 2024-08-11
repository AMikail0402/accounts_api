package accounts.app;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.WebApplicationType;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.scheduling.annotation.EnableScheduling;

import io.grpc.Grpc;
import io.grpc.InsecureServerCredentials;
import io.grpc.Server;
import io.grpc.ServerCredentials;

@EnableScheduling
@SpringBootApplication
public class App 
{
    public static void main( String[] args ) throws Exception{

        new SpringApplicationBuilder(App.class)
        .web(WebApplicationType.NONE)
        .run();

        ServerCredentials credential = InsecureServerCredentials.create();
        Server server = Grpc.newServerBuilderForPort(8081, credential).build().start();
        server.awaitTermination();
    }

}

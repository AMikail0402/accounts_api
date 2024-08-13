package accounts;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.WebApplicationType;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.context.annotation.Bean;

import accounts.grpc.helloworld.service.HelloService;
import accounts.grpc.user.service.UserService;

import io.grpc.Grpc;
import io.grpc.InsecureServerCredentials;
import io.grpc.Server;
import io.grpc.ServerCredentials;
import io.grpc.netty.NettyServerBuilder;


@SpringBootApplication

public class App 
{
    public static void main(String[] args) {
        SpringApplication.run(App.class, args);
    }

    @Bean
    public CommandLineRunner startGrpcServer(UserService userService) {
        return args -> {
            Server server = NettyServerBuilder.forPort(8081)
                .addService(new HelloService())
                .addService(userService)
                .build()
                .start();

            Runtime.getRuntime().addShutdownHook(new Thread(server::shutdown));

            server.awaitTermination();
        };
    }

}

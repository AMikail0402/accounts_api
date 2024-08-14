package accounts;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.WebApplicationType;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.context.annotation.Bean;

import accounts.grpc.helloworld.service.HelloService;
import accounts.grpc.user.service.UserService;


import io.grpc.Server;
import io.grpc.netty.NettyServerBuilder;


@SpringBootApplication

public class App 
{
    public static void main(String[] args) {
        new SpringApplicationBuilder(App.class)
        .web(WebApplicationType.NONE) 
        .run(args);
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

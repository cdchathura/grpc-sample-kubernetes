package com.chathura.edu.grpcsamplekubernetes.grpc;

import com.chathura.edu.grpcsamplekubernetes.service.HelloServiceImpl;
import io.grpc.Server;
import io.grpc.ServerBuilder;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.io.IOException;

@Component
public class GrpcServer {

    @Value("${server.port}")
    private Integer port;

    @PostConstruct
    public void initServer() throws IOException, InterruptedException {
        Server server = ServerBuilder.forPort(port)
                .addService(new HelloServiceImpl()).build();
        System.out.println("Starting server... on "+ port);
        server.start();
        System.out.println("Server started!");
        server.awaitTermination();
    }

}

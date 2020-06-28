package com.chathura.edu.grpcsamplekubernetes.service;

import com.chathura.edu.grpcsamplekubernetes.HelloRequest;
import com.chathura.edu.grpcsamplekubernetes.HelloResponse;
import com.chathura.edu.grpcsamplekubernetes.HelloServiceGrpc;
import io.grpc.stub.StreamObserver;


public class HelloServiceImpl extends HelloServiceGrpc.HelloServiceImplBase {

    @Override
    public void hello(
            HelloRequest request, StreamObserver<HelloResponse> responseObserver) {

        String greeting = new StringBuilder()
                .append("Hello, ")
                .append(request.getFirstName())
                .append(" ")
                .append(request.getLastName())
                .toString();

        HelloResponse response = HelloResponse.newBuilder()
                .setGreeting(greeting)
                .build();

        responseObserver.onNext(response);
        responseObserver.onCompleted();
    }


}

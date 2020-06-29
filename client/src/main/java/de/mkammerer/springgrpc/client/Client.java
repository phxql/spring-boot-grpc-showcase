package de.mkammerer.springgrpc.client;

import de.mkammerer.springgrpc.protocol.HelloWorldGrpc;
import de.mkammerer.springgrpc.protocol.HelloWorldRequest;
import de.mkammerer.springgrpc.protocol.HelloWorldResponse;
import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;

class Client {
    public static void main(String[] args) {
        ManagedChannel channel = ManagedChannelBuilder.forAddress("localhost", 6565).usePlaintext().build();

        HelloWorldGrpc.HelloWorldBlockingStub stub = HelloWorldGrpc.newBlockingStub(channel);

        HelloWorldResponse response = stub.hello(HelloWorldRequest.newBuilder().setName("Moritz").build());

        System.out.println(response.getMessage());
    }
}

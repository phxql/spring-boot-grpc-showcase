package de.mkammerer.springgrpc.server;

import de.mkammerer.springgrpc.protocol.HelloWorldGrpc;
import de.mkammerer.springgrpc.protocol.HelloWorldRequest;
import de.mkammerer.springgrpc.protocol.HelloWorldResponse;
import io.grpc.stub.StreamObserver;
import org.lognet.springboot.grpc.GRpcService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@GRpcService
class HelloWorldService extends HelloWorldGrpc.HelloWorldImplBase {
    private static final Logger LOGGER = LoggerFactory.getLogger(HelloWorldService.class);

    private final HelloFormatter helloFormatter;

    HelloWorldService(HelloFormatter helloFormatter) {
        this.helloFormatter = helloFormatter;
    }

    @Override
    public void hello(HelloWorldRequest request, StreamObserver<HelloWorldResponse> responseObserver) {
        LOGGER.debug("hello()");

        responseObserver.onNext(HelloWorldResponse.newBuilder().setMessage(helloFormatter.format(request.getName())).build());
        responseObserver.onCompleted();
    }
}

package de.mkammerer.springgrpc.server;

import org.springframework.stereotype.Component;

// Just a small component to test if dependency injection works in gRPC services
@Component
class HelloFormatter {
    public String format(String name) {
        return "Hello, " + name;
    }
}

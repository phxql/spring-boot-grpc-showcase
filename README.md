# Spring Boot with gRPC

This small project showcases Spring together with gRPC. It consists of 3 modules:

* `protocol`: contains the proto file and the rpc definition. Will generate java classes when compiled.
* `server`: uses protocol module, implemements the rpc stub in Spring Boot
* `client`: uses protocol module, implements a client in plain java (no Spring)

The project uses [grpc-spring-boot-starter](https://github.com/LogNet/grpc-spring-boot-starter) for the heavy 
lifting.

The main work on that was to get the Gradle build files right.

## Build it

`./gradlew clean build`

## Run it via gradle

1. `./gradlew :server:bootRun`
1. `./gradlew :client:run` in another terminal

## Invoke the service via grpc-cli

The server has gRPC reflection support enabled (see [application.yaml](server/src/main/resources/application.yaml)),
so you can invoke the service via the grpc-cli. First start the server, then interact with it via the CLI:

```
# Start server
./gradlew :server:bootRun

# List all services
grpc_cli ls localhost:6565

# Get HelloWorldService definition
grpc_cli ls localhost:6565 -l grpcchat.HelloWorld

# Get request proto definition
grpc_cli type localhost:6565 grpcchat.HelloWorldRequest

# Get response proto definition
grpc_cli type localhost:6565 grpcchat.HelloWorldResponse

# Call the service
grpc_cli call localhost:6565 grpcchat.HelloWorld.Hello "name: 'Moritz'"
```

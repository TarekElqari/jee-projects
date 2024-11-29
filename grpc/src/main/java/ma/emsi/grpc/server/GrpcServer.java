package ma.emsi.grpc.server;

import io.grpc.Server;
import io.grpc.ServerBuilder;
import ma.emsi.grpc.services.BankGrpcService;

import java.io.IOException;

public class GrpcServer {

    public static void main(String[] args) {
        try {
            Server server = ServerBuilder.forPort(5555)
                    .addService(new BankGrpcService())
                    .build();
            System.out.println("gRPC Server started on port 5555...");
            server.start();

            Runtime.getRuntime().addShutdownHook(new Thread(() -> {
                System.out.println("Shutting down gRPC server...");
                if (server != null) {
                    server.shutdown();
                }
                System.out.println("Server shut down successfully.");
            }));

            server.awaitTermination();
        } catch (IOException | InterruptedException e) {
            System.err.println("Error starting gRPC server: " + e.getMessage());
            e.printStackTrace();
        }
    }
}

package ma.emsi.grpc.clients;

import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;
import io.grpc.stub.StreamObserver;
import ma.emsi.grpc.stubs.Bank;
import ma.emsi.grpc.stubs.BankServiceGrpc;

import java.io.IOException;

public class Client2 {
    public static void main(String[] args) throws IOException {
        // Creating a managed channel for gRPC communication
        ManagedChannel managedChannel = ManagedChannelBuilder.forAddress("localhost", 5555)
                .usePlaintext() // Ensures that the connection is made in plaintext, without SSL
                .build();

        // Creating an asynchronous stub to interact with the gRPC server
        BankServiceGrpc.BankServiceStub asyncStub = BankServiceGrpc.newStub(managedChannel);

        // Creating a request object for currency conversion
        Bank.ConvertCurrencyRequest request = Bank.ConvertCurrencyRequest.newBuilder()
                .setCurrencyFrom("MAD") // Setting the source currency (Moroccan Dirham)
                .setCurrencyTo("USD")   // Setting the target currency (US Dollars)
                .setAmount(7500)        // Setting the amount to be converted
                .build();

        // Sending the request asynchronously and receiving the response
        asyncStub.convert(request, new StreamObserver<Bank.ConvertCurrencyResponse>() {
            @Override
            public void onNext(Bank.ConvertCurrencyResponse convertCurrencyResponse) {
                // Handling the response when received
                System.out.println("********************");
                System.out.println(convertCurrencyResponse);
                System.out.println("********************");
            }

            @Override
            public void onError(Throwable throwable) {
                // Handling any error that occurs during communication
                System.out.println("Error occurred: " + throwable.getMessage());
            }

            @Override
            public void onCompleted() {
                // Handling the completion of the gRPC call
                System.out.println("END...");
            }
        });

        // Waiting for the server response before closing
        System.out.println("...?");
        System.in.read(); // Keeps the program running to wait for the async response
    }
}

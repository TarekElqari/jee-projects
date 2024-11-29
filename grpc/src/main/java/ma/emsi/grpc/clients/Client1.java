package ma.emsi.grpc.clients;

import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;
import ma.emsi.grpc.stubs.Bank;
import ma.emsi.grpc.stubs.BankServiceGrpc;

public class Client1 {
    public static void main(String[] args) {
        // Creating a managed channel for gRPC communication
        ManagedChannel managedChannel = ManagedChannelBuilder.forAddress("localhost", 5555)
                .usePlaintext() // This ensures that the connection is made in plaintext, not SSL
                .build();

        // Creating a stub to interact with the gRPC server using the blocking API
        BankServiceGrpc.BankServiceBlockingStub blockingStub =
                BankServiceGrpc.newBlockingStub(managedChannel);

        // Creating a request object for currency conversion
        Bank.ConvertCurrencyRequest request = Bank.ConvertCurrencyRequest.newBuilder()
                .setCurrencyFrom("MAD") // Setting the source currency as Moroccan Dirham
                .setCurrencyTo("USD")   // Setting the target currency as US Dollars
                .setAmount(7600)        // Setting the amount to be converted
                .build();

        // Sending the request and receiving the response from the server
        Bank.ConvertCurrencyResponse currencyResponse = blockingStub.convert(request);

        // Printing the response to the console
        System.out.println(currencyResponse);
    }
}

package ma.emsi.grpc.services;


import io.grpc.stub.StreamObserver;
import ma.emsi.grpc.stubs.Bank;
import ma.emsi.grpc.stubs.BankServiceGrpc;

public class BankGrpcService extends BankServiceGrpc.BankServiceImplBase {

    @Override
    public void convert(Bank.ConvertCurrencyRequest request,
                        StreamObserver<Bank.ConvertCurrencyResponse> responseObserver) {
        // Extract parameters
        String currencyFrom = request.getCurrencyFrom();
        String currencyTo = request.getCurrencyTo();
        double amount = request.getAmount();

        // Conversion logic (using a dummy exchange rate)
        double exchangeRate = 11.4;
        double result = amount * exchangeRate;

        // Build the response
        Bank.ConvertCurrencyResponse response = Bank.ConvertCurrencyResponse.newBuilder()
                .setCurrencyFrom(currencyFrom)
                .setCurrencyTo(currencyTo)
                .setAmount(amount)
                .setResult(result)
                .build();

        // Send response and complete the call
        responseObserver.onNext(response);
        responseObserver.onCompleted();
    }
}

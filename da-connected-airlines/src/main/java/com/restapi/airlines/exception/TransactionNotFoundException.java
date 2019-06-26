package com.restapi.airlines.exception;

public class TransactionNotFoundException extends RuntimeException { //Transaction not found exception
    public TransactionNotFoundException(){ //Transaction not found exception with default message
        super("Transaction ID not Found");
    }
    public TransactionNotFoundException(String message){ //Transaction not found exception with custom message
        super(message);
    }
}

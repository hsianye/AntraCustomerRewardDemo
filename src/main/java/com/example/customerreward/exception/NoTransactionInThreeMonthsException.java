package com.example.customerreward.exception;

public class NoTransactionInThreeMonthsException extends RuntimeException{
    public NoTransactionInThreeMonthsException(String msg){
        super(msg);
    }
}

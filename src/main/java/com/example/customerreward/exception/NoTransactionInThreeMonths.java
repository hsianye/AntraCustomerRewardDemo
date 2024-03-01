package com.example.customerreward.exception;

public class NoTransactionInThreeMonths extends RuntimeException{
    public NoTransactionInThreeMonths(String msg){
        super(msg);
    }
}

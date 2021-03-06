package com.bank.account.exceptions;


public class EmptyDataException extends Exception {

    private String message;

    public EmptyDataException(String message) {
        this.message = message;
    }

    @Override
    public String toString() {
        return "EmptyDataException: " + message;
    }
}

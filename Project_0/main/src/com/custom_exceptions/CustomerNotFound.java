package com.custom_exceptions;

public class CustomerNotFound extends RuntimeException{
    public CustomerNotFound(String message){
        super(message);
    }
}

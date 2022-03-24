package com.custom_exceptions;

public class InvalidUsername extends RuntimeException{
    public InvalidUsername(String message){
        super(message);
    }
}

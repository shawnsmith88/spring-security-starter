package com.ss.example.springsecuritystarter.Exceptions;

public class UsernameExistsException extends Exception {
    public UsernameExistsException(String message){
        super(message);
    }
    public UsernameExistsException(String message, Throwable cause){
        super(message,cause);
    }
}

package com.myproject.exception;

public class ResourceAlreadyExistException extends Exception {

    public ResourceAlreadyExistException(String message, Exception e){
        super(message,e);
    }

    public ResourceAlreadyExistException(String message){
         super(message);
    }
}

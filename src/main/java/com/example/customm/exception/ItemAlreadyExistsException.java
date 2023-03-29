package com.example.customm.exception;

public class ItemAlreadyExistsException extends RuntimeException{

    public ItemAlreadyExistsException(String message){
        super(message);
    }
}

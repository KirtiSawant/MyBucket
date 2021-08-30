package com.mybucket.exception;

public class UserNotFoundException extends RuntimeException{
    public UserNotFoundException(int  uid) {
        super(String.format("Sprint with Id %d not found", uid));

    }
}

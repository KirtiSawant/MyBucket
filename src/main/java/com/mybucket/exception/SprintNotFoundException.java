package com.mybucket.exception;

public class SprintNotFoundException extends RuntimeException{
    public SprintNotFoundException(Integer sid) {

        super(String.format("Sprint with Id %d not found", sid));
    }
}

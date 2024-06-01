package com.universitymanager.aggregate.common;

public class ApplicationFailure extends RuntimeException{
    public ApplicationFailure(String message){
       super(message);
    }
}

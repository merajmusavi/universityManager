package com.universitymanager.aggregate.common;

public class Result<T>{
    private final T value;
    private final Throwable error;

    private Result(T value, Throwable error) {
        this.value = value;
        this.error = error;
    }

    public static <T> Result<T> success(T value){
        return new Result<>(value,null);
    }

    public static <T> Result<T> failure(Throwable error){
        return new Result<>(null,error);
    }

    public boolean isSuccess(){
        return error == null;
    }
    public boolean isFailure(){
        return error !=null;
    }

    public T getValue(){
        if (isSuccess()){
            return value;
        }else {
            throw  new IllegalStateException("Result does not contain a value");
        }
    }

    public Throwable getError() {
        if (isSuccess()) {
            throw new IllegalStateException("Result does not contain an error.");
        }
        return error;
    }


}

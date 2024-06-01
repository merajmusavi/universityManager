package com.universitymanager.aggregate.course.valueobject;

import com.universitymanager.aggregate.common.ApplicationFailure;
import com.universitymanager.aggregate.common.Result;

public class Code {
    public String value;
    public Code(String code){
        this.value = code;
    }
    public static Result<Code> makeNew(String code){
        if (isValidCode(code)){
            return Result.success(new Code(code));
        }else {
            return Result.failure(new InvalidCode("code : " + code + " is invalid "));
        }
    }
    public static boolean isValidCode(String code){
        Long value = Long.valueOf(code);
        if (value >= 1){
            return true;
        }else {
            return false;
        }
    }
    public static class InvalidCode extends ApplicationFailure {

        public InvalidCode(String message) {
            super(message);
        }
    }
}

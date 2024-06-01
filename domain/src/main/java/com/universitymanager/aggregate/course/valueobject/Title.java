package com.universitymanager.aggregate.course.valueobject;

import com.universitymanager.aggregate.common.Result;

public class Title {
    public String value;

    public Title(String title) {
        this.value = title;
    }

    public static Result<Title> makeNew(String title) {
        if (isValidTitle(title)){
            return Result.success(new Title(title));
        }else {
            return Result.failure(new IllegalArgumentException("invalid title format"));
        }
    }

    private static boolean isValidTitle(String title) {
        int length = title.length();
        return length >= 10 && length <= 40;
    }
}

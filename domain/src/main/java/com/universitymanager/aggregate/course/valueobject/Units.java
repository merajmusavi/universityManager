package com.universitymanager.aggregate.course.valueobject;

import com.universitymanager.aggregate.common.ApplicationFailure;
import com.universitymanager.aggregate.common.Result;

public class Units {
    public String value;

    public Units(String units) {
        this.value = units;
    }

    public static Result<Units> makeNew(String units) {
        if (isValidUnits(units)) {
            return Result.success(new Units(units));
        } else {
            return Result.failure(new InvalidUnits("invalid units"));
        }
    }

    private static boolean isValidUnits(String units) {
        try {
            int value = Integer.parseInt(units);
            int length = units.length();
            return value > 0 && length >= 1 && length <= 6;
        } catch (NumberFormatException e) {
            return false;
        }
    }

    public static class InvalidUnits extends ApplicationFailure {

        public InvalidUnits(String message) {
            super(message);
        }
    }

}

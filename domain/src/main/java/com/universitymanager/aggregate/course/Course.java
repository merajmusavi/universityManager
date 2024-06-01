package com.universitymanager.aggregate.course;

import com.universitymanager.aggregate.common.Result;
import com.universitymanager.aggregate.course.valueobject.Code;
import com.universitymanager.aggregate.course.valueobject.Title;
import com.universitymanager.aggregate.course.valueobject.Units;

public class Course {
    Code code;
    Title title;
    Units units;

    public Code getCode() {
        return code;
    }

    public void setCode(Code code) {
        this.code = code;
    }

    public Title getTitle() {
        return title;
    }

    public void setTitle(Title title) {
        this.title = title;
    }

    public Units getUnits() {
        return units;
    }

    public void setUnits(Units units) {
        this.units = units;
    }

    private Course(Code code, Title title, Units units) {
        this.code = code;
        this.title = title;
        this.units = units;
    }

    public static Result<Course> makeNew(
            String code,
            String title,
            String units
    ) {
        Result<Code> codeResult = code != null ? Code.makeNew(code) : Result.success(null);
        Result<Title> titleResult = title != null ? Title.makeNew(title) : Result.success(null);
        Result<Units> unitsResult = units != null ? Units.makeNew(units) : Result.success(null);
        return Result.success(
                new Course(
                        codeResult.getValue(),
                        titleResult.getValue(),
                        unitsResult.getValue()
                )
        );
    }
}

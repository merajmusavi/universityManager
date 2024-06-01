package com.universitymanager.aggregate.course;

import com.universitymanager.aggregate.common.Result;
import com.universitymanager.aggregate.course.valueobject.Code;
import com.universitymanager.aggregate.course.valueobject.Title;
import com.universitymanager.aggregate.course.valueobject.Units;

public class Course {
    Code code;
    Title title;
    Units units;
    Long professorId;

    public Long getProfessorId() {
        return professorId;
    }

    public void setProfessorId(Long professorId) {
        this.professorId = professorId;
    }

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

    private Course(Code code, Title title, Units units, Long professorId) {
        this.code = code;
        this.title = title;
        this.units = units;
        this.professorId = professorId;
    }

    public static Result<Course> makeNew(
            Code code,
            Title title,
            Units units,
            Long professorId
    ) {

        return Result.success(
                new Course(
                        code,
                        title,
                        units,
                        professorId
                )
        );
    }
}

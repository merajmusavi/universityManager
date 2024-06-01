package com.universitymanager.aggregate.course;

import com.universitymanager.aggregate.model.cmd.CourseCmd;

public interface CourseRepository {
    public void save(CourseCmd course);
}

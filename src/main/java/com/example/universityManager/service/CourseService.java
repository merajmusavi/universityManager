package com.example.universityManager.service;

import com.example.universityManager.dto.course.AddCourseDto;
import com.example.universityManager.dto.course.ShowCourseDto;
import com.example.universityManager.dto.course.UpdateCourseDto;
import com.example.universityManager.entity.Course;

public interface CourseService {
    public boolean deleteById(Long id);

    public void save(AddCourseDto course);

    public Course findById(Long id);

    public Boolean isCourseWithThisCodeExists(Long code);

    public Boolean isCourseWithThisIdExists(Long id);

    public Course update(UpdateCourseDto course);

    public ShowCourseDto showCourseByCode(long code);
}

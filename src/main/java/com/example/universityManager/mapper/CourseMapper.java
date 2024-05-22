package com.example.universityManager.mapper;

import com.example.universityManager.dto.course.UpdateCourseDto;
import com.example.universityManager.entity.Course;

public class CourseMapper {
    public static void updateEntityFromDto(UpdateCourseDto updateCourseDto, Course course){
        if (updateCourseDto == null || course == null){
            return;
        }
        course.setTitle(updateCourseDto.getTitle());
    }
}

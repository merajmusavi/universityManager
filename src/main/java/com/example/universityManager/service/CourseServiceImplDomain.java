package com.example.universityManager.service;

import com.example.universityManager.mapper.CourseMapper;
import com.example.universityManager.repository.CourseRepository;
import com.universitymanager.aggregate.common.Result;
import com.universitymanager.aggregate.course.Course;
import com.universitymanager.aggregate.course.usecase.SaveCourseUc;
import com.universitymanager.aggregate.model.cmd.CourseCmd;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Service;

@Service
public class CourseServiceImplDomain implements com.universitymanager.aggregate.course.CourseRepository {
    private final SaveCourseUc saveCourseUc;

    private final CourseRepository courseRepository;

    public CourseServiceImplDomain(@Lazy SaveCourseUc saveCourseUc, CourseRepository courseRepository) {
        this.saveCourseUc = saveCourseUc;
        this.courseRepository = courseRepository;
    }

    @Override
    public void save(CourseCmd course) {
        com.example.universityManager.entity.Course courseEntity = new com.example.universityManager.entity.Course();
        CourseMapper.saveEntityFromDomainDto(course, courseEntity);
        courseRepository.save(courseEntity);
    }
}

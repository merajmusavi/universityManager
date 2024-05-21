package com.example.universityManager.service;

import com.example.universityManager.entity.Course;
import com.example.universityManager.exception.ConflictException;
import com.example.universityManager.exception.NotFoundException;
import com.example.universityManager.repository.CourseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class CourseServiceImpl implements CourseService {
    private final CourseRepository courseRepository;

    @Autowired
    public CourseServiceImpl(CourseRepository courseRepository) {
        this.courseRepository = courseRepository;
    }

    @Override
    public boolean deleteById(Long id) {

        Boolean courseWithThisIdExists = isCourseWithThisIdExists(id);
        if (courseWithThisIdExists) {
            courseRepository.deleteById(id);
            return true;
        } else {
            return false;
        }
    }

    @Override
    public void save(Course course) {
        Optional<Course> foundedCourse = courseRepository.findByCode(Long.valueOf(course.getCode()));
        if (foundedCourse.isPresent()) {
            throw new ConflictException("already there is a book with this id ");
        } else {
            courseRepository.save(course);
        }
    }

    @Override
    public Course findById(Long id) {
        Optional<Course> foundedCourse = courseRepository.findById(id);
        if (foundedCourse.isPresent()) {
            return foundedCourse.get();
        } else {
            throw new NotFoundException("course with " + id + "already exists found");
        }
    }

    @Override
    public Boolean isCourseWithThisCodeExists(Long code) {
        Optional<Course> foundedCourse = courseRepository.findByCode(code);
        if (foundedCourse.isPresent()) {
            return true;
        } else {
            return false;

        }
    }

    @Override
    public Boolean isCourseWithThisIdExists(Long id) {
        Optional<Course> foundedCourse = courseRepository.findById(id);
        if (foundedCourse.isPresent()) {
            return true;
        } else {
            return false;

        }
    }

    @Override
    public Course update(Course course) {
        Optional<Course> foundedCourse = courseRepository.findById(course.getId());
        if (foundedCourse.isPresent()) {
            courseRepository.save(course);
            return foundedCourse.get();
        } else {
            throw new NotFoundException("course with " + course.getId() + "already exists found");

        }
    }


}

package com.example.universityManager.service;

import com.example.universityManager.entity.Course;
import com.example.universityManager.exception.ConflictException;
import com.example.universityManager.exception.NotFoundException;
import com.example.universityManager.repository.CourseRepository;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class CourseService {
    private final CourseRepository courseRepository;

    @Autowired
    public CourseService(CourseRepository courseRepository) {
        this.courseRepository = courseRepository;
    }


    public void save(Course course) {
        Optional<Course> foundedCourse = courseRepository.findByCode(course.getCode());
        if (foundedCourse.isPresent()) {
            throw new ConflictException("already there is a book with this id ");
        } else {
            courseRepository.save(course);
        }
    }

    public Course findById(Long id) {
        Optional<Course> foundedCourse = courseRepository.findById(id);
        if (foundedCourse.isPresent()) {
            return foundedCourse.get();
        } else {
            throw new NotFoundException("course with " + id + "already exists found");
        }
    }

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

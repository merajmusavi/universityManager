package com.example.universityManager.service;

import com.example.universityManager.dto.course.AddCourseDto;
import com.example.universityManager.dto.course.UpdateCourseDto;
import com.example.universityManager.entity.Course;
import com.example.universityManager.entity.Professor;
import com.example.universityManager.exception.ConflictException;
import com.example.universityManager.exception.NotFoundException;
import com.example.universityManager.mapper.CourseMapper;
import com.example.universityManager.repository.CourseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class CourseServiceImpl implements CourseService {
    private final CourseRepository courseRepository;
    private final ProfessorService professorService;

    @Autowired
    public CourseServiceImpl(CourseRepository courseRepository, ProfessorService professorService) {
        this.courseRepository = courseRepository;
        this.professorService = professorService;
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
    public void save(AddCourseDto courseDto) {
        Optional<Course> foundedCourse = courseRepository.findByCode(Long.valueOf(courseDto.getCode()));
        Professor foundedProfessor = professorService.findById(courseDto.getProfessorId());

        if (foundedCourse.isPresent()) {
            throw new ConflictException("already there is a course with this code ");
        } else if (foundedProfessor == null) {
            throw new ConflictException("there is no professor with this id :  " + courseDto.getProfessorId() );
        } else {
            Course course = new Course();
            CourseMapper.saveEntityFromDto(courseDto, course);
            courseRepository.save(course);
        }
    }

    @Override
    public Course findById(Long id) {
        Optional<Course> foundedCourse = courseRepository.findById(id);
        if (foundedCourse.isPresent()) {
            return foundedCourse.get();
        } else {
            throw new NotFoundException("course with " + id + "not found");
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
    public Course update(UpdateCourseDto courseDto) {
        Optional<Course> foundedCourse = courseRepository.findById(courseDto.getId());
        if (foundedCourse.isPresent()) {
            Course course1 = foundedCourse.get();
            CourseMapper.updateEntityFromDto(courseDto, course1);
            courseRepository.save(course1);
            return foundedCourse.get();
        } else {

            throw new NotFoundException("course with " + courseDto.getId() + "not found");
        }
    }


}

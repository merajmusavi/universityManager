package com.example.universityManager.controller;

import com.example.universityManager.dto.CourseDto;
import com.example.universityManager.entity.Course;
import com.example.universityManager.entity.Professor;
import com.example.universityManager.repository.ProfessorRepository;
import com.example.universityManager.service.CourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/course/v1")
public class CourseController {
    private final CourseService courseService;

    private final ProfessorRepository professorRepository;

    @Autowired
    public CourseController(CourseService courseService, ProfessorRepository professorRepository) {
        this.courseService = courseService;
        this.professorRepository = professorRepository;
    }

    @PostMapping("/save")
    @ResponseStatus(HttpStatus.CREATED)
    public void save(@RequestBody CourseDto courseDto) {
        Professor professor = professorRepository.findById(courseDto.getProfessorId()).orElseThrow(() -> new RuntimeException("Professor not found"));

        Course course = new Course();
        course.setCode(courseDto.getCode());
        course.setProfessor(professor);
        course.setTitle(courseDto.getTitle());
        course.setUnits(courseDto.getUnits());
        courseService.save(course);
    }
}

package com.example.universityManager.controller;

import com.example.universityManager.dto.CourseDto;
import com.example.universityManager.dto.ErrorEntity;
import com.example.universityManager.entity.Course;
import com.example.universityManager.entity.Professor;
import com.example.universityManager.repository.ProfessorRepository;
import com.example.universityManager.service.CourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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
    public ResponseEntity<?> save(@RequestBody CourseDto courseDto) {
        Optional<Professor> foundedProfessor = professorRepository.findById(courseDto.getProfessorId());

        if (!foundedProfessor.isPresent()) {
            ErrorEntity status = new ErrorEntity();
            status.setStatus("there is no professor with this id");
            return ResponseEntity.ok(status);
        }

        Course course = new Course();

        Boolean isExists = courseService.isCourseWithThisCodeExists(Long.valueOf(courseDto.getCode()));
        if (isExists){
            ErrorEntity status = new ErrorEntity();
            status.setStatus("there is a course with "+ courseDto.getCode() + " already");
            return ResponseEntity.ok(status);
        }


        course.setCode(courseDto.getCode());

        course.setProfessor(foundedProfessor.get());
        course.setTitle(courseDto.getTitle());
        course.setUnits(courseDto.getUnits());
        courseService.save(course);


        return ResponseEntity.ok(courseDto);
    }
}

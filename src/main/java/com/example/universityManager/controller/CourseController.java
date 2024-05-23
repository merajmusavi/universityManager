package com.example.universityManager.controller;

import com.example.universityManager.dto.course.AddCourseDto;
import com.example.universityManager.dto.ErrorEntity;
import com.example.universityManager.dto.course.UpdateCourseDto;
import com.example.universityManager.entity.Course;
import com.example.universityManager.entity.Professor;
import com.example.universityManager.repository.ProfessorRepository;
import com.example.universityManager.service.CourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
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

    @PostMapping("/update")
    @ResponseStatus(HttpStatus.ACCEPTED)
    public ResponseEntity<?> update(@RequestBody UpdateCourseDto courseDto) {
        Course updated = courseService.update(courseDto);
        return ResponseEntity.ok(updated);
    }

    @PostMapping("/save")
    @ResponseStatus(HttpStatus.CREATED)
    public ResponseEntity<?> save(@RequestBody AddCourseDto courseDto) {
        courseService.save(courseDto);
        return ResponseEntity.ok(courseDto);
    }

    @GetMapping("/delete/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public ResponseEntity<?> delete(@PathVariable Long id) {
        boolean deletedStatus = courseService.deleteById(id);
        HashMap<String, Long> deletedCourse = new HashMap<>();
        deletedCourse.put("id", id);
        return ResponseEntity.ok(deletedCourse);

    }
}

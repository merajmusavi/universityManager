package com.example.universityManager.controller;

import com.example.universityManager.dto.course.AddCourseDto;
import com.example.universityManager.dto.student.AddStudentDto;
import com.example.universityManager.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/student/v1")
public class StudentController {


    private final StudentService studentService;

    @Autowired
    public StudentController(StudentService studentService) {
        this.studentService = studentService;
    }

    @PostMapping
    @ResponseStatus(HttpStatus.ACCEPTED)
    public ResponseEntity<?> addStudent(@RequestBody AddStudentDto dto) {
        studentService.save(dto);
        return ResponseEntity.ok("");
    }

}

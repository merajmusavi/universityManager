package com.example.universityManager.controller;

import com.example.universityManager.dto.student.AddStudentDto;
import com.example.universityManager.dto.student.UpdateStudentDto;
import com.example.universityManager.service.StudentService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/student/v1")
public class StudentController {

    private static final Logger logger = LoggerFactory.getLogger(StudentController.class);
    private final StudentService studentService;

    @Autowired
    public StudentController(StudentService studentService) {
        this.studentService = studentService;
    }

    @PostMapping("/add")
    @ResponseStatus(HttpStatus.ACCEPTED)
    public ResponseEntity<?> addStudent(@RequestBody AddStudentDto dto) {
        studentService.save(dto);
        return ResponseEntity.ok("");
    }

    @PostMapping("/update")
    public ResponseEntity<?> updateStudent(@RequestBody UpdateStudentDto updateStudentDto) {
        boolean updateSuccess = studentService.update(updateStudentDto);
        return ResponseEntity.ok(updateStudentDto);



    }
    @GetMapping("/delete/{id}")
    public ResponseEntity<?> deleteStudent(@PathVariable Long id){
        logger.info("start the method for deleting user : " + id);
        boolean isDeletedStudent = studentService.deleteById(id);

        if (isDeletedStudent){
            logger.warn("student with " + id + " deleted");
            return ResponseEntity.ok().build();
        }else {
            logger.warn("student with " + id + " don`t deleted");
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
    }

}

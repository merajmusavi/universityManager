package com.example.universityManager.controller;

import com.example.universityManager.dto.course.AddCourseDto;
import com.example.universityManager.dto.course.AssignStudentToCourseDto;
import com.example.universityManager.dto.course.ShowCourseDto;
import com.example.universityManager.dto.course.UpdateCourseDto;
import com.example.universityManager.dto.student.ShowStudentDto;
import com.example.universityManager.entity.Course;
import com.example.universityManager.repository.ProfessorRepository;
import com.example.universityManager.service.CourseService;
import com.example.universityManager.service.CourseServiceImpl;
import com.example.universityManager.service.CourseServiceImplDomain;
import com.universitymanager.aggregate.course.CourseRepository;
import com.universitymanager.aggregate.model.cmd.CourseCmd;
import org.checkerframework.checker.units.qual.A;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;

@RestController
@RequestMapping("/course/v1")
public class CourseController {
    private final CourseService courseService;
    private final ProfessorRepository professorRepository;
    private final CourseServiceImplDomain courseServiceImplDomain;
    @Autowired
    public CourseController(CourseService courseService, ProfessorRepository professorRepository, CourseServiceImplDomain courseServiceImplDomain) {
        this.courseService = courseService;
        this.professorRepository = professorRepository;
        this.courseServiceImplDomain = courseServiceImplDomain;
    }

    @PostMapping("/update")
    @ResponseStatus(HttpStatus.ACCEPTED)
    public ResponseEntity<?> update(@RequestBody UpdateCourseDto courseDto) {
        Course updated = courseService.update(courseDto);
        return ResponseEntity.ok(updated);
    }

    @PostMapping("/save")
    @ResponseStatus(HttpStatus.CREATED)
    public ResponseEntity<?> save(@RequestBody CourseCmd courseCmd) {


        courseServiceImplDomain.save(courseCmd);
        return ResponseEntity.ok(courseCmd);
    }

    @GetMapping("/delete/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public ResponseEntity<?> delete(@PathVariable Long id) {
        boolean deletedStatus = courseService.deleteById(id);
        HashMap<String, Long> deletedCourse = new HashMap<>();
        deletedCourse.put("id", id);
        return ResponseEntity.ok(deletedCourse);

    }

    @GetMapping("/getCourseByCode/{code}")
    @ResponseStatus(HttpStatus.OK)
    public ShowCourseDto showCourse(@PathVariable Long code) {
        return courseService.showCourseByCode(code);
    }

    @PostMapping("/addCourseStudent")
    public void AddCourse(@RequestBody AssignStudentToCourseDto addDto) {
        courseService.addStudent(addDto.getCourseCode(), addDto.getStudentCode());
    }

    @GetMapping("/students/{codeCourse}")
    public List<ShowStudentDto> showStudentDto(@PathVariable String codeCourse) {
        return courseService.listStudents(codeCourse);
    }

}

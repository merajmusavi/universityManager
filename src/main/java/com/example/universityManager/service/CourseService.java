package com.example.universityManager.service;

import com.example.universityManager.dto.course.AddCourseDto;
import com.example.universityManager.dto.course.ShowCourseDto;
import com.example.universityManager.dto.course.UpdateCourseDto;
import com.example.universityManager.dto.student.ShowStudentDto;
import com.example.universityManager.entity.Course;
import com.example.universityManager.entity.Student;

import java.util.List;

public interface CourseService {
    boolean deleteById(Long id);

    void save(AddCourseDto course);

    Course findById(Long id);

    Boolean isCourseWithThisCodeExists(Long code);

    Boolean isCourseWithThisIdExists(Long id);

    Course update(UpdateCourseDto course);

    ShowCourseDto showCourseByCode(long code);

    void addStudent(String codeCourse, String stdNumber);

    Course findByCode(String codeCourse);

    void update(Course course);
    public List<ShowStudentDto> listStudents(String codeCourse);
    void removeCourse(String codeCourse, String stdNumber);
}

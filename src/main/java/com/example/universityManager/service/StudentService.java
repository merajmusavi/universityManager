package com.example.universityManager.service;

import com.example.universityManager.dto.course.ShowCourseDto;
import com.example.universityManager.dto.course.UpdateCourseDto;
import com.example.universityManager.dto.student.AddStudentDto;
import com.example.universityManager.dto.student.UpdateStudentDto;
import com.example.universityManager.entity.Course;
import com.example.universityManager.entity.Student;

public interface StudentService {
    public boolean deleteById(Long id);

    public void save(AddStudentDto studentDto);

    public Student findById(Long id);

    public Boolean isStdWithThisCodeExists(Long code);

    public Boolean isStdWithThisIdExists(Long id);


    public Boolean update(UpdateStudentDto updateStudentDto);

}

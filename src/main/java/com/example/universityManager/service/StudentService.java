package com.example.universityManager.service;

import com.example.universityManager.dto.course.ShowCourseDto;
import com.example.universityManager.dto.course.UpdateCourseDto;
import com.example.universityManager.dto.student.AddStudentDto;
import com.example.universityManager.dto.student.ShowStudentDto;
import com.example.universityManager.dto.student.UpdateStudentDto;
import com.example.universityManager.entity.Course;
import com.example.universityManager.entity.Student;

public interface StudentService {
    public boolean deleteById(Long id);

     void save(AddStudentDto studentDto);

     Student findById(Long id);

     Boolean isStdWithThisCodeExists(Long code);

     Boolean isStdWithThisIdExists(Long id);


     Boolean update(UpdateStudentDto updateStudentDto);

     ShowStudentDto showStudentDto(Long id);
}

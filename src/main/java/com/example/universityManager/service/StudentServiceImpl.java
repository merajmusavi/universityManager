package com.example.universityManager.service;

import com.example.universityManager.dto.student.AddStudentDto;
import com.example.universityManager.entity.Student;
import com.example.universityManager.mapper.StudentMapper;
import com.example.universityManager.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class StudentServiceImpl implements StudentService {

    private final StudentRepository studentRepository;

    @Autowired
    public StudentServiceImpl(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;

    }


    @Override
    public boolean deleteById(Long id) {
        return false;
    }

    @Override
    public void save(AddStudentDto studentDto) {
        Student student = new Student();
        StudentMapper.saveEntityFromDto(studentDto, student);
        studentRepository.save(student);
    }

    @Override
    public Student findById(Long id) {
        return null;
    }

    @Override
    public Boolean isStdWithThisCodeExists(Long code) {
        return null;
    }

    @Override
    public Boolean isStdWithThisIdExists(Long id) {
        return null;
    }

    @Override
    public Student update() {
        return null;
    }
}

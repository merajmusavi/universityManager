package com.example.universityManager.service;

import com.example.universityManager.dto.student.AddStudentDto;
import com.example.universityManager.dto.student.ShowStudentDto;
import com.example.universityManager.dto.student.UpdateStudentDto;
import com.example.universityManager.entity.Student;
import com.example.universityManager.exception.AlreadyExistsException;
import com.example.universityManager.exception.NotFoundException;
import com.example.universityManager.mapper.StudentMapper;
import com.example.universityManager.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;


@Service
public class StudentServiceImpl implements StudentService {

    private final StudentRepository studentRepository;

    @Autowired
    public StudentServiceImpl(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;

    }


    @Override
    public boolean deleteById(Long id) {
        Optional<Student> findStudentById = studentRepository.findById(id);
        if (findStudentById.isEmpty()) {
            return false;
        } else {
            studentRepository.deleteById(id);
            return true;
        }
    }

    @Override
    public void save(AddStudentDto studentDto) {
        Optional<Student> foundedStudentByUserName = studentRepository.findByUsername(studentDto.getUserName());

        Optional<Student> foundedStudentByNationalCode = studentRepository.findByNationalCode(studentDto.getNationalCode());

        Optional<Student> foundedStudentByStdNumber = studentRepository.findByStdNumber(studentDto.getStd_number());

        if (foundedStudentByUserName.isPresent()) {
            throw new AlreadyExistsException("student with username : " + studentDto.getUserName() + " already exists");
        }
        if (foundedStudentByNationalCode.isPresent()) {
            throw new AlreadyExistsException("student with nationalCode : " + studentDto.getNationalCode() + " already exists");
        }

        if (foundedStudentByStdNumber.isPresent()) {
            throw new AlreadyExistsException("student with student number : " + studentDto.getStd_number() + " already exists");
        }


        Student student = new Student();
        StudentMapper.saveEntityFromDto(studentDto, student);
        studentRepository.save(student);
    }

    @Override
    public Student findById(Long id) {
        Optional<Student> foundedStudent = studentRepository.findById(id);
        if (foundedStudent.isPresent()) {
            return foundedStudent.get();
        } else {
            throw new NotFoundException("there is no student with " + id + " this id");
        }
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
    public Boolean update(UpdateStudentDto dto) {
        Student foundedStudentById = findById(dto.getId());

        StudentMapper.updateEntityFromDto(dto, foundedStudentById);
        studentRepository.save(foundedStudentById);
        return true;

    }

    @Override
    public ShowStudentDto showStudentDto(Long id) {
        Student foundedStudent = findById(id);
        ShowStudentDto showStudentDto = new ShowStudentDto();

        StudentMapper.showDtoFromEntity(showStudentDto, foundedStudent);

        return showStudentDto;
    }

    @Override
    public Student findByStdNumber(String stdNumber) {
        Optional<Student> foundedStudentByStdNumber = studentRepository.findByStdNumber(Long.valueOf(stdNumber));
        if (foundedStudentByStdNumber.isPresent()){
            return foundedStudentByStdNumber.get();
        }else {
            throw new NotFoundException("student with student number: : "+ stdNumber + " not found") ;
        }
    }

    @Override
    public void update(Student student) {
        studentRepository.save(student);
    }
}

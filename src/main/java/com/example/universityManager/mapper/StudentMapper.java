package com.example.universityManager.mapper;

import com.example.universityManager.dto.student.AddStudentDto;
import com.example.universityManager.entity.Student;
import com.example.universityManager.enums.AcademicLevel;
import com.example.universityManager.enums.Gender;

import java.util.Date;

public class StudentMapper {
    public static void saveEntityFromDto(AddStudentDto dto, Student student) {
        if (dto == null || student == null) {
            return;
        }
        student.setAcademicRank(AcademicLevel.valueOf(dto.getAcademicRank()));
        student.setStdNumber(dto.getStd_number());
        student.setBirthday(Date.from(dto.getBirthDay()));
        student.setName(dto.getName());
        student.setFamily(dto.getFamily());
        student.setGender(Gender.valueOf(dto.getGender()));
        student.setUsername(dto.getUserName());
        student.setPassword(dto.getPassword());
        student.setNationalCode(dto.getNationalCode());
    }
}

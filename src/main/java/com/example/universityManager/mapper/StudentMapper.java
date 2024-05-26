package com.example.universityManager.mapper;

import com.example.universityManager.dto.student.AddStudentDto;
import com.example.universityManager.dto.student.ShowStudentDto;
import com.example.universityManager.dto.student.UpdateStudentDto;
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

    public static void showDtoFromEntity(ShowStudentDto dto, Student student) {
        if (dto == null || student == null) {
            return;
        }
        dto.setAcademic_rank(student.getAcademicRank());
        dto.setBirthDay(student.getBirthday());

        dto.setFamily(student.getFamily());
        dto.setName(student.getName());
        dto.setGender(student.getGender());
        dto.setNationalCode(student.getNationalCode());
        dto.setStd_number(String.valueOf(student.getStdNumber()));
        dto.setUsername(student.getUsername());
    }

    public static void updateEntityFromDto(UpdateStudentDto dto, Student student) {
        if (dto == null || student == null) {
            return;
        }

        student.setName(dto.getName());
        student.setFamily(dto.getFamily());
        student.setPassword(dto.getPassword());
    }
}

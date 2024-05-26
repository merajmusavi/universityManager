package com.example.universityManager.mapper;

import com.example.universityManager.dto.professor.AddProfessorDto;
import com.example.universityManager.dto.professor.UpdateProfessorDto;
import com.example.universityManager.entity.Professor;

public class ProfessorMapper {

    public static void saveEntityFromDto(AddProfessorDto dto, Professor professor) {
        if (dto == null || professor == null) {
            return;
        }
        professor.setGender(dto.getGender());
        professor.setBirthday(dto.getBirthday());
        professor.setPassword(dto.getPassword());
        professor.setAcademicRank(dto.getAcademicRank());
        professor.setFamily(dto.getFamily());
        professor.setUsername(dto.getUsername());
        professor.setName(dto.getName());
        professor.setCode(dto.getCode());
        professor.setNationalCode(String.valueOf(dto.getNationalCode()));
    }

    public static void updateEntityFromDto(UpdateProfessorDto dto, Professor professor) {
        if (dto == null || professor == null) {
            return;
        }
        professor.setName(dto.getName());
        professor.setNationalCode(dto.getNational_code());
        professor.setFamily(dto.getFamily());
        professor.setFamily(dto.getAcademic_rank());
    }
}

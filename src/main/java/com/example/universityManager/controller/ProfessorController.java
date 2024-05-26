package com.example.universityManager.controller;

import com.example.universityManager.dto.ProfessorDto;
import com.example.universityManager.entity.Professor;
import com.example.universityManager.service.ProfessorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/professor/v1")
public class ProfessorController {
    private final ProfessorService professorService;

    @Autowired
    public ProfessorController(ProfessorService professorService) {
        this.professorService = professorService;

    }

    @GetMapping("/save")
    @ResponseStatus(HttpStatus.CREATED)
    public void save(@RequestBody ProfessorDto dto) {
        Professor professor = new Professor();

        professor.setCode(dto.getCode());
        professor.setAcademicRank(dto.getAcademicRank());
        professor.setFamily(dto.getFamily());
        professor.setName(dto.getName());
        professor.setUsername(dto.getUsername());
        professor.setPassword(dto.getPassword());
        professor.setBirthday(dto.getBirthday());
        professor.setGender(dto.getGender());
        professor.setNationalCode(String.valueOf(dto.getNationalCode()));

    }

}

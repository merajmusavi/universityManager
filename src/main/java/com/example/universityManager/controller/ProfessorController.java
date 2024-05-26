package com.example.universityManager.controller;

import com.example.universityManager.dto.professor.AddProfessorDto;
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
    public void save(@RequestBody AddProfessorDto dto) {
        professorService.save(dto);

    }

}

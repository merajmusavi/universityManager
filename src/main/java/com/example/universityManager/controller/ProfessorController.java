package com.example.universityManager.controller;

import com.example.universityManager.dto.professor.AddProfessorDto;
import com.example.universityManager.dto.professor.ShowProfessorDto;
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

    @PostMapping("/save")
    @ResponseStatus(HttpStatus.CREATED)
    public void save(@RequestBody AddProfessorDto dto) {
        professorService.save(dto);

    }

    @GetMapping("/find/{code}")
    @ResponseStatus(HttpStatus.ACCEPTED)
    public ShowProfessorDto show(@PathVariable String code) {
        return professorService.findProfessorByCode(code);
    }

}

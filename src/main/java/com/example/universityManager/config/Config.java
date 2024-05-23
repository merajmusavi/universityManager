package com.example.universityManager.config;

import com.example.universityManager.mapper.CourseMapper;
import com.example.universityManager.service.ProfessorService;
import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;

@Configuration
public class Config {
    @Autowired
    ProfessorService professorService;

    @PostConstruct
    public void init() {
        CourseMapper.setProfessorService(professorService);
    }
}

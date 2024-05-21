package com.example.universityManager.service;

import com.example.universityManager.entity.Course;
import com.example.universityManager.entity.Professor;

public interface ProfessorService {
    public boolean deleteById(Long id);

    public void save(Professor professor);

    public Professor findById(Long id);


    public Boolean isProfessorWithThisIdExists(Long id);

    public Professor update(Professor professor);
}

package com.example.universityManager.repository;

import com.example.universityManager.entity.Professor;
import org.springframework.stereotype.Repository;

@Repository
public interface ProfessorRepository extends UserRepository<Professor> {
}

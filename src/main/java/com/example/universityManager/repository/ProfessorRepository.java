package com.example.universityManager.repository;

import com.example.universityManager.entity.Course;
import com.example.universityManager.entity.Professor;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ProfessorRepository extends UserRepository<Professor> {
    Optional<Professor> findByCode(Long code);

}

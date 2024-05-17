package com.example.universityManager.repository;

import com.example.universityManager.entity.Student;
import org.springframework.stereotype.Repository;

@Repository
public interface StudentRepository extends UserRepository<Student> {
}

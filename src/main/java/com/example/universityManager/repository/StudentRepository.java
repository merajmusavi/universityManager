package com.example.universityManager.repository;

import com.example.universityManager.entity.Course;
import com.example.universityManager.entity.Student;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface StudentRepository extends UserRepository<Student> {

    Optional<Student> findByNationalCode(String nationalCode);

    Optional<Student> findByUsername(String userName);

    Optional<Student> findByStdNumber(Long stdNumber);


}

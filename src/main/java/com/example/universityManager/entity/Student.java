package com.example.universityManager.entity;

import com.example.universityManager.enums.AcademicLevel;
import com.example.universityManager.enums.AcademicRank;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.HashSet;
import java.util.Set;

@Getter
@Setter
@NoArgsConstructor
@Entity
public class Student extends User {
    @Column(nullable = false, unique = true)
    private Long stdNumber;
    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private AcademicLevel academicRank;

    @ManyToMany(mappedBy = "students")
    private Set<Course> courses = new HashSet<>();
}

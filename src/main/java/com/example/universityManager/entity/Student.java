package com.example.universityManager.entity;

import com.example.universityManager.enums.AcademicLevel;
import jakarta.persistence.*;
import lombok.NoArgsConstructor;

import java.util.HashSet;
import java.util.Set;


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

    public Long getStdNumber() {
        return stdNumber;
    }

    public void setStdNumber(Long stdNumber) {
        this.stdNumber = stdNumber;
    }

    public AcademicLevel getAcademicRank() {
        return academicRank;
    }

    public void setAcademicRank(AcademicLevel academicRank) {
        this.academicRank = academicRank;
    }

    public Set<Course> getCourses() {
        return courses;
    }

    public void setCourses(Set<Course> courses) {
        this.courses = courses;
    }
}

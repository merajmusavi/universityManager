package com.example.universityManager.dto.student;

import com.example.universityManager.enums.Gender;

import java.time.Instant;

public class AddStudentDto {
    private String name;
    private Instant birthDay;
    private String family;
    private String gender;
    private String nationalCode;
    private String userName;
    private String password;
    private Long std_number;
    private String academicRank;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Instant getBirthDay() {
        return birthDay;
    }

    public void setBirthDay(Instant birthDay) {
        this.birthDay = birthDay;
    }

    public String getFamily() {
        return family;
    }

    public void setFamily(String family) {
        this.family = family;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getNationalCode() {
        return nationalCode;
    }

    public void setNationalCode(String nationalCode) {
        this.nationalCode = nationalCode;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Long getStd_number() {
        return std_number;
    }

    public void setStd_number(Long std_number) {
        this.std_number = std_number;
    }

    public String getAcademicRank() {
        return academicRank;
    }

    public void setAcademicRank(String academicRank) {
        this.academicRank = academicRank;
    }
}

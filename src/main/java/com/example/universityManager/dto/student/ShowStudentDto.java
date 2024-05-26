package com.example.universityManager.dto.student;

import com.example.universityManager.enums.AcademicLevel;
import com.example.universityManager.enums.AcademicRank;
import com.example.universityManager.enums.Gender;

import java.util.Date;

public class ShowStudentDto {
    private Date birthDay;
    private String family;
    private String name;
    private Gender gender;
    private String nationalCode;
    private String std_number;
    private AcademicLevel academic_level;
    private String username;


    public Date getBirthDay() {
        return birthDay;
    }

    public void setBirthDay(Date birthDay) {
        this.birthDay = birthDay;
    }

    public String getFamily() {
        return family;
    }

    public void setFamily(String family) {
        this.family = family;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Gender getGender() {
        return gender;
    }

    public void setGender(Gender gender) {
        this.gender = gender;
    }

    public String getNationalCode() {
        return nationalCode;
    }

    public void setNationalCode(String nationalCode) {
        this.nationalCode = nationalCode;
    }

    public String getStd_number() {
        return std_number;
    }

    public void setStd_number(String std_number) {
        this.std_number = std_number;
    }

    public AcademicLevel getAcademic_level() {
        return academic_level;
    }

    public void setAcademic_rank(AcademicLevel academic_level) {
        this.academic_level = academic_level;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }
}

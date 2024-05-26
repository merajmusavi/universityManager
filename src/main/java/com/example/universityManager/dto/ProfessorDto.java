package com.example.universityManager.dto;

import com.example.universityManager.enums.AcademicRank;
import com.example.universityManager.enums.Gender;

import java.util.Date;

public class ProfessorDto {
    private Date birthday;
    private String family;
    private Gender gender;
    private String name;
    private Long nationalCode;
    private String password;
    private String username;
    private AcademicRank academicRank;
    private Integer code;

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public AcademicRank getAcademicRank() {
        return academicRank;
    }

    public void setAcademicRank(AcademicRank academicRank) {
        this.academicRank = academicRank;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Long getNationalCode() {
        return nationalCode;
    }

    public void setNationalCode(Long nationalCode) {
        this.nationalCode = nationalCode;
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

    public String getFamily() {
        return family;
    }

    public void setFamily(String family) {
        this.family = family;
    }

    public Date getBirthday() {
        return birthday;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }
}

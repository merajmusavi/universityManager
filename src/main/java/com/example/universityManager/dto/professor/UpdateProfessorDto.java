package com.example.universityManager.dto.professor;

public class UpdateProfessorDto {
    private String name;
    private String family;
    private String national_code;
    private String academic_rank;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getFamily() {
        return family;
    }

    public void setFamily(String family) {
        this.family = family;
    }

    public String getNational_code() {
        return national_code;
    }

    public void setNational_code(String national_code) {
        this.national_code = national_code;
    }

    public String getAcademic_rank() {
        return academic_rank;
    }

    public void setAcademic_rank(String academic_rank) {
        this.academic_rank = academic_rank;
    }
}

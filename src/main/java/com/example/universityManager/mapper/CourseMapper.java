package com.example.universityManager.mapper;

import com.example.universityManager.dto.course.UpdateCourseDto;
import com.example.universityManager.entity.Course;
import com.example.universityManager.entity.Professor;
import com.example.universityManager.service.ProfessorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CourseMapper {


    private static ProfessorService professorService;

    public static void setProfessorService(ProfessorService professorService) {
        CourseMapper.professorService = professorService;
    }

    public static void updateEntityFromDto(UpdateCourseDto updateCourseDto, Course course) {
        if (updateCourseDto == null || course == null) {
            return;
        }
        Professor foundedProfessor = professorService.findById(updateCourseDto.getProfessorId());


        course.setProfessor(foundedProfessor);
        course.setTitle(updateCourseDto.getTitle());

    }
}

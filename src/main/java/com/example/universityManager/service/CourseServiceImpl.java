package com.example.universityManager.service;

import com.example.universityManager.dto.course.AddCourseDto;
import com.example.universityManager.dto.course.ShowCourseDto;
import com.example.universityManager.dto.course.UpdateCourseDto;
import com.example.universityManager.entity.Course;
import com.example.universityManager.entity.Professor;
import com.example.universityManager.entity.Student;
import com.example.universityManager.exception.ConflictException;
import com.example.universityManager.exception.NotFoundException;
import com.example.universityManager.mapper.CourseMapper;
import com.example.universityManager.mapper.StudentMapper;
import com.example.universityManager.repository.CourseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class CourseServiceImpl implements CourseService {
    private final CourseRepository courseRepository;
    private final ProfessorService professorService;
    private final StudentService studentService;

    @Autowired
    public CourseServiceImpl(CourseRepository courseRepository, ProfessorService professorService, StudentService studentService) {
        this.courseRepository = courseRepository;
        this.professorService = professorService;
        this.studentService = studentService;
    }

    @Override
    public boolean deleteById(Long id) {

        Boolean courseWithThisIdExists = isCourseWithThisIdExists(id);
        if (courseWithThisIdExists) {
            courseRepository.deleteById(id);
            return true;
        } else {
            throw new NotFoundException("there is no course with this id: " + id);
        }
    }

    @Override
    public void save(AddCourseDto courseDto) {
        Optional<Course> foundedCourse = courseRepository.findByCode(Long.valueOf(courseDto.getCode()));
        Professor foundedProfessor = professorService.findById(courseDto.getProfessorId());

        if (foundedCourse.isPresent()) {
            throw new ConflictException("already there is a course with this code ");
        } else if (foundedProfessor == null) {
            throw new ConflictException("there is no professor with this id :  " + courseDto.getProfessorId());
        } else {
            Course course = new Course();
            CourseMapper.saveEntityFromDto(courseDto, course);
            courseRepository.save(course);
        }
    }

    @Override
    public Course findById(Long id) {
        Optional<Course> foundedCourse = courseRepository.findById(id);
        if (foundedCourse.isPresent()) {
            return foundedCourse.get();
        } else {
            throw new NotFoundException("course with " + id + "not found");
        }
    }

    @Override
    public Boolean isCourseWithThisCodeExists(Long code) {
        Optional<Course> foundedCourse = courseRepository.findByCode(code);
        if (foundedCourse.isPresent()) {
            return true;
        } else {
            return false;

        }
    }

    @Override
    public Boolean isCourseWithThisIdExists(Long id) {
        Optional<Course> foundedCourse = courseRepository.findById(id);
        if (foundedCourse.isPresent()) {
            return true;
        } else {
            return false;

        }
    }

    @Override
    public Course update(UpdateCourseDto courseDto) {
        Optional<Course> foundedCourse = courseRepository.findById(courseDto.getId());
        if (foundedCourse.isPresent()) {
            Course course1 = foundedCourse.get();
            CourseMapper.updateEntityFromDto(courseDto, course1);
            courseRepository.save(course1);
            return foundedCourse.get();
        } else {

            throw new NotFoundException("course with " + courseDto.getId() + "not found");
        }
    }

    @Override
    public ShowCourseDto showCourseByCode(long code) {
        Optional<Course> foundedCourse = courseRepository.findByCode(code);
        if (foundedCourse.isPresent()) {
            ShowCourseDto showCourseDto = new ShowCourseDto();
            Course course = foundedCourse.get();


            showCourseDto.setProfessorName(course.getProfessor().getName());

            showCourseDto.setUnit(course.getTitle());
            showCourseDto.setTitle(String.valueOf(course.getUnits()));
            List<Long> listOfStudents = course.getStudents().stream().map(Student::getStdNumber)
                    .collect(Collectors.toList());

            showCourseDto.setStudents(listOfStudents);
            return showCourseDto;
        } else {
            throw new NotFoundException("course with code " + code + "not found");
        }
    }


    @Override
    public void addStudent(String codeCourse, String stdNumber) {
        Student foundedStudent = studentService.findByStdNumber(stdNumber);
        Course foundedCourse = findByCode(codeCourse);
        foundedCourse.getStudents().add(foundedStudent);
        foundedStudent.getCourses().add(foundedCourse);
        studentService.update(foundedStudent);
        update(foundedCourse);
    }

    @Override
    public Course findByCode(String codeCourse) {
        Optional<Course> foundedCourseByCode = courseRepository.findByCode(Long.valueOf(codeCourse));
        if (foundedCourseByCode.isPresent()) {
            return foundedCourseByCode.get();
        } else {
            throw new NotFoundException("course with code : " + codeCourse + " not found");
        }
    }

    @Override
    public void update(Course course) {
        courseRepository.save(course);
    }


}

package com.universitymanager.aggregate.course.usecase;

import com.universitymanager.aggregate.common.CommandUseCase;
import com.universitymanager.aggregate.common.Result;
import com.universitymanager.aggregate.course.Course;
import com.universitymanager.aggregate.course.CourseRepository;
import com.universitymanager.aggregate.course.valueobject.Code;
import com.universitymanager.aggregate.course.valueobject.Title;
import com.universitymanager.aggregate.course.valueobject.Units;
import com.universitymanager.aggregate.exception.NotFoundException;
import com.universitymanager.aggregate.model.cmd.CourseCmd;
import com.universitymanager.aggregate.professor.Professor;
import com.universitymanager.aggregate.professor.ProfessorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SaveCourseUc implements CommandUseCase<CourseCmd, Course> {

    @Autowired
    private CourseRepository courseRepository;
    @Autowired
    private ProfessorRepository professorRepository;

    @Override
    public Result<Course> execute(CourseCmd courseCmd) {
        Result<Code> codeResult = Code.makeNew(courseCmd.getCode());
        Result<Title> titleResult = Title.makeNew(courseCmd.getTitle());
        Result<Units> unitsResult = Units.makeNew(courseCmd.getUnits());
        if (codeResult.isFailure()) {
            return Result.failure(new IllegalArgumentException("invalid code"));
        }
        if (titleResult.isFailure()) {
            return Result.failure(new IllegalArgumentException("invalid title"));
        }
        if (unitsResult.isFailure()) {

            return Result.failure(new IllegalArgumentException("invalid units"));
        }
        Professor foundedProfessor = professorRepository.findById(courseCmd.getProfessorId());

        if (foundedProfessor==null){
            throw new NotFoundException("professor with " + courseCmd.getProfessorId() + " id not found");
        }

        Result<Course> courseResult = Course.makeNew(
                codeResult.getValue(),
                titleResult.getValue(),
                unitsResult.getValue(),
                courseCmd.getProfessorId()
        );
        if (courseResult.isSuccess()) {
            courseRepository.save(courseCmd);
            return Result.success(courseResult.getValue());
        } else {
            return Result.failure(new IllegalArgumentException("invalid course type"));
        }

    }
}

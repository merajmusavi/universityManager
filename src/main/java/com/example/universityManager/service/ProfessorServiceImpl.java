package com.example.universityManager.service;

import com.example.universityManager.entity.Course;
import com.example.universityManager.entity.Professor;
import com.example.universityManager.exception.ConflictException;
import com.example.universityManager.exception.NotFoundException;
import com.example.universityManager.repository.ProfessorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ProfessorServiceImpl implements ProfessorService {
    private final ProfessorRepository professorRepository;

    @Autowired
    public ProfessorServiceImpl(ProfessorRepository professorRepository) {
        this.professorRepository = professorRepository;
    }

    @Override
    public boolean deleteById(Long id) {
        Boolean professorWithThisIdExists = isProfessorWithThisIdExists(id);
        if (professorWithThisIdExists) {
            professorRepository.deleteById(id);
            return true;
        } else {
            return false;
        }

    }

    @Override
    public void save(Professor professor) {
        Optional<Course> foundedProfessor = professorRepository.findByCode(Long.valueOf(professor.getCode()));
        if (foundedProfessor.isPresent()) {
            throw new ConflictException("already there is a professor with this code ");

        } else {
            professorRepository.save(professor);
        }
    }

    @Override
    public Professor findById(Long id) {
        Optional<Professor> foundedProfessor = professorRepository.findById(id);
        if (foundedProfessor.isPresent()) {
            return foundedProfessor.get();
        } else {
            throw new NotFoundException("professor with " + id + "not found");


        }
    }


    @Override
    public Boolean isProfessorWithThisIdExists(Long id) {
        Optional<Professor> foundedProfessor = professorRepository.findById(id);
        if (foundedProfessor.isPresent()) {
            return true;

        } else {
            return false;
        }
    }

    @Override
    public Professor update(Professor professor) {
        Boolean professorWithThisIdExists = isProfessorWithThisIdExists(professor.getId());
        if (professorWithThisIdExists) {
            professorRepository.save(professor);
            return professor;
        } else {
            throw new NotFoundException("professor with " + professor.getId() + "not found");
        }
    }
}

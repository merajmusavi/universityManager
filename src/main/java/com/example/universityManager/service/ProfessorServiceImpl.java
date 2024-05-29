package com.example.universityManager.service;

import com.example.universityManager.dto.professor.AddProfessorDto;
import com.example.universityManager.dto.professor.ShowProfessorDto;
import com.example.universityManager.entity.Professor;
import com.example.universityManager.exception.AlreadyExistsException;
import com.example.universityManager.exception.NotFoundException;
import com.example.universityManager.mapper.ProfessorMapper;
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
    public void save(AddProfessorDto professorDto) {
        Optional<Professor> foundedProfessor = professorRepository.findByCode(Long.valueOf(professorDto.getCode()));
        if (foundedProfessor.isPresent()) {
            throw new AlreadyExistsException("professor with this code :" + professorDto.getCode() + " already exists");
        }
        Professor professor = new Professor();
        ProfessorMapper.saveEntityFromDto(professorDto, professor);
        professorRepository.save(professor);
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
        } else   {
            throw new NotFoundException("professor with " + professor.getId() + "not found");
        }
    }

    @Override
    public ShowProfessorDto findProfessorByCode(String code) {
        Optional<Professor> foundedProfessorByCode = professorRepository.findByCode(Long.valueOf(code));
        if (foundedProfessorByCode.isPresent()){
            ShowProfessorDto showProfessorDto = new ShowProfessorDto();
             ProfessorMapper.showDtoFromEntity(showProfessorDto,foundedProfessorByCode.get());
             return showProfessorDto;
        }else {
            throw new NotFoundException("professor with code : " + code + " not found");
        }
    }
}

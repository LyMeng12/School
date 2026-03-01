package com.systemSchool.School.api.Service.Impl;

import com.systemSchool.School.api.DTO.StudentDTO;
import com.systemSchool.School.api.Repository.StudentRepository;
import com.systemSchool.School.api.Service.StudentService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentServiceIpml implements StudentService {

    private final StudentRepository studentRepository;

    public StudentServiceIpml(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    @Override
    public void create(StudentDTO studentDTO) {

    }

    @Override
    public void update(StudentDTO studentDTO, Long id) {

    }

    @Override
    public StudentDTO delete(Long id) {
        return null;
    }

    @Override
    public List<StudentDTO> findAll() {
        return List.of();
    }
}

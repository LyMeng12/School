package com.systemSchool.School.api.Service.Impl;

import com.systemSchool.School.api.DTO.StudentDTO.StudentRequest;
import com.systemSchool.School.api.DTO.StudentDTO.StudentResponse;
import com.systemSchool.School.api.Repository.StudentRepository;
import com.systemSchool.School.api.Service.StudentService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentServiceImpl implements StudentService {
    private final StudentRepository studentRepository;

    public StudentServiceImpl(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }


    @Override
    public void newStudent(StudentRequest studentRequest) {

    }

    @Override
    public void updateStudent(Long id, StudentRequest studentRequest) {

    }

    @Override
    public void deleteStudent(Long id) {

    }

    @Override
    public StudentResponse getStudent(Long id) {
        return null;
    }

    @Override
    public List<StudentResponse> getStudents() {
        return List.of();
    }
}

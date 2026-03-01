package com.systemSchool.School.api.Service;

import com.systemSchool.School.api.DTO.StudentDTO;

import java.util.List;

public interface StudentService {
    void create(StudentDTO studentDTO);
    void update(StudentDTO studentDTO, Long id);
    StudentDTO delete(Long id);
    List<StudentDTO> findAll();
}

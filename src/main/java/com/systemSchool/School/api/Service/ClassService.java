package com.systemSchool.School.api.Service;

import com.systemSchool.School.api.DTO.ClassDTO;
import com.systemSchool.School.api.DTO.StudentDTO;

import java.util.List;

public interface ClassService {
    void create(ClassDTO classDTO);
    void update(ClassDTO classDTO, Long id);
    ClassDTO delete(Long id);
    List<ClassDTO> findAll();
}

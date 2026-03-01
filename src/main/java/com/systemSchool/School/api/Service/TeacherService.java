package com.systemSchool.School.api.Service;

import com.systemSchool.School.api.DTO.StudentDTO;
import com.systemSchool.School.api.DTO.TeacherDTO;

import java.util.List;

public interface TeacherService {
    void create(TeacherDTO teacherDTO);
    void update(TeacherDTO teacherDTO, Long id);
    TeacherDTO delete(Long id);
    List<TeacherDTO> findAll();
}

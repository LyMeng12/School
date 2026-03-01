package com.systemSchool.School.api.Service;

import com.systemSchool.School.api.DTO.StudentDTO;
import com.systemSchool.School.api.DTO.SubjectDTO;

import java.util.List;

public interface SubjectService {
    void create(SubjectDTO subjectDTO);
    void update(SubjectDTO subjectDTO, Long id);
    SubjectDTO delete(Long id);
    List<SubjectDTO> findAll();
}

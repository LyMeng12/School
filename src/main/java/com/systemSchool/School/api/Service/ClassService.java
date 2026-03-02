package com.systemSchool.School.api.Service;

import com.systemSchool.School.api.DTO.ClassDTO;
import com.systemSchool.School.api.DTO.StudentDTO;

import java.util.List;

public interface ClassService {
    void newClass(ClassDTO Class);
    void updateClass(ClassDTO Class,Long id);
    void deleteClass(Long id);
    ClassDTO getClass(Long id);
    List<ClassDTO> getAllClass_s();
}

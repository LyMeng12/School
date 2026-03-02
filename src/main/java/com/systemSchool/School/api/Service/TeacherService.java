package com.systemSchool.School.api.Service;

import com.systemSchool.School.api.DTO.TeacherDTO;

import java.util.List;

public interface TeacherService {
    void newTeacher(TeacherDTO teacher);
    void updateTeacher(TeacherDTO teacher,Long id);
    void deleteTeacher(Long id);
    TeacherDTO getTeacher(Long id);
    List<TeacherDTO> getAllTeachers();
}

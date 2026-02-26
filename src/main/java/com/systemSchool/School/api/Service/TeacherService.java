package com.systemSchool.School.api.Service;

import com.systemSchool.School.api.dto.TeacherDTO;

import java.util.List;

public interface TeacherService {
    void createTeacher(TeacherDTO teacherDTO);
    void updateTeacher(TeacherDTO teacherDTO,Long id);
    void deleteTeacher(Long id);
    TeacherDTO getTeacherById(Long id);
    List<TeacherDTO> getAllTeachers();


}

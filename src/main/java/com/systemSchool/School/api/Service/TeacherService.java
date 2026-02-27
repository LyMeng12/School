package com.systemSchool.School.api.Service;

import com.systemSchool.School.api.dto.TeacherDTO;

import java.util.List;

public interface TeacherService {
    void createTeacher(TeacherDTO teacherDTO);
    TeacherDTO updateTeacher(TeacherDTO teacherDTO, Long TeacherId);
    void deleteTeacher(Long TeacherId);
    TeacherDTO getTeacherById(Long TeacherId);
    List<TeacherDTO> getAllTeachers();


}

package com.systemSchool.School.api.Service.Impl;

import com.systemSchool.School.api.Service.TeacherService;
import com.systemSchool.School.api.dto.TeacherDTO;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TeacherServiceIpml implements TeacherService {

    @Override
    public void createTeacher(TeacherDTO teacherDTO) {

    }

    @Override
    public void updateTeacher(TeacherDTO teacherDTO, Long id) {

    }

    @Override
    public void deleteTeacher(Long id) {

    }

    @Override
    public TeacherDTO getTeacherById(Long id) {
        return null;
    }

    @Override
    public List<TeacherDTO> getAllTeachers() {
        return List.of();
    }
}

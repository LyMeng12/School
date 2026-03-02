package com.systemSchool.School.api.Service.Impl;

import com.systemSchool.School.api.DTO.TeacherDTO;
import com.systemSchool.School.api.Repository.TeacherRepository;
import com.systemSchool.School.api.Service.TeacherService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TeacherServiceImpl implements TeacherService {

    private final TeacherRepository teacherRepository;

    public TeacherServiceImpl(TeacherRepository teacherRepository) {
        this.teacherRepository = teacherRepository;
    }

    @Override
    public void newTeacher(TeacherDTO teacher) {

    }

    @Override
    public void updateTeacher(TeacherDTO teacher, Long id) {

    }

    @Override
    public void deleteTeacher(Long id) {

    }

    @Override
    public TeacherDTO getTeacher(Long id) {
        return null;
    }

    @Override
    public List<TeacherDTO> getAllTeachers() {
        return List.of();
    }


}

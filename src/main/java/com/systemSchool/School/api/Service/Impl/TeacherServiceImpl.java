package com.systemSchool.School.api.Service.Impl;

import com.systemSchool.School.api.DTO.TeacherDTO.TeacherRequest;
import com.systemSchool.School.api.DTO.TeacherDTO.TeacherResponse;
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
    public void newTeacher(TeacherRequest teacherRequest) {

    }

    @Override
    public void updateTeacher(Long Id, TeacherRequest teacherRequest) {

    }

    @Override
    public void deleteTeacher(Long Id) {

    }

    @Override
    public TeacherResponse getTeacherById(Long Id) {
        return null;
    }

    @Override
    public List<TeacherResponse> getAllTeachers() {
        return List.of();
    }
}

package com.systemSchool.School.api.Service.Impl;

import com.systemSchool.School.api.DTO.TeacherDTO;
import com.systemSchool.School.api.Repository.TeacherRepository;
import com.systemSchool.School.api.Service.StudentService;
import com.systemSchool.School.api.Service.TeacherService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TeacherServiceIpml implements TeacherService {

    private final TeacherRepository teacherRepository;

    public TeacherServiceIpml(TeacherRepository teacherRepository) {
        this.teacherRepository = teacherRepository;
    }

    @Override
    public void create(TeacherDTO teacherDTO) {

    }

    @Override
    public void update(TeacherDTO teacherDTO, Long id) {

    }

    @Override
    public TeacherDTO delete(Long id) {
        return null;
    }

    @Override
    public List<TeacherDTO> findAll() {
        return List.of();
    }
}

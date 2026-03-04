package com.systemSchool.School.api.Service.Impl;

import com.systemSchool.School.api.DTO.TeacherDTO;
import com.systemSchool.School.api.Model.TeacherAPI;
import com.systemSchool.School.api.Repository.TeacherRepository;
import com.systemSchool.School.api.Service.TeacherService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TeacherServiceImpl implements TeacherService {

    private final TeacherRepository teacherRepository;

    public TeacherServiceImpl(TeacherRepository teacherRepository) {
        this.teacherRepository = teacherRepository;
    }

    @Override
    public void newTeacher(TeacherDTO teacher) {
        TeacherAPI teacherAPI = new TeacherAPI();
        teacherAPI.setTeacherName(teacher.getTeacherName());
        teacherAPI.setTeacherAge(teacher.getTeacherAge());
        teacherAPI.setTeacherGender(teacher.getTeacherGender());
        teacherAPI.setTeacherSalary(teacher.getTeacherSalary());
        teacherRepository.save(teacherAPI);
    }

    @Override
    public void updateTeacher(TeacherDTO teacher, Long id) {

    }

    @Override
    public void deleteTeacher(Long id) {

    }

    @Override
    public TeacherDTO getTeacher(Long id) {
        Optional<TeacherAPI> teacherAPI = teacherRepository.findById(id);
        if (teacherAPI.isPresent()) {
            TeacherDTO teacherDTO = new TeacherDTO();
            teacherDTO.setTeacherName(teacherAPI.get().getTeacherName());
            teacherDTO.setTeacherAge(teacherAPI.get().getTeacherAge());
            teacherDTO.setTeacherGender(teacherAPI.get().getTeacherGender());
            teacherDTO.setTeacherSalary(teacherAPI.get().getTeacherSalary());
            return teacherDTO;
        }
        return null;
    }

    @Override
    public List<TeacherDTO> getAllTeachers() {
        return List.of();
    }


}

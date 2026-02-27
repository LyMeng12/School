package com.systemSchool.School.api.Service.Impl;

import com.systemSchool.School.api.Entity.Teacher;
import com.systemSchool.School.api.Repository.TeacherRepository;
import com.systemSchool.School.api.Service.TeacherService;
import com.systemSchool.School.api.dto.TeacherDTO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Slf4j
@Service
public class TeacherServiceIpml implements TeacherService {

    private final TeacherRepository teacherRepository;

    public TeacherServiceIpml(TeacherRepository teacherRepository) {
        this.teacherRepository = teacherRepository;
    }

    @Override
    public void createTeacher(TeacherDTO teacherDTO) {
        Teacher teacher = new Teacher();
        teacher.setTeacherName(teacherDTO.getTeacherName());
        teacher.setAge(teacherDTO.getAge());
        teacher.setGender(teacherDTO.getGender());
        teacher.setPhoneNumber(teacherDTO.getPhoneNumber());
        teacher.setSalary(teacherDTO.getSalary());
        teacherRepository.save(teacher);
    }

    @Override
    public TeacherDTO updateTeacher(TeacherDTO teacherDTO, Long TeacherId) {
        Optional<Teacher> teacherDTO1 = teacherRepository.findById(TeacherId);
        if (teacherDTO1.isEmpty()) {
            log.info("Teacher with id " + TeacherId + " found");
            return null;
        }
        Teacher teacher = teacherDTO1.get();
        teacher.setTeacherName(teacherDTO.getTeacherName());
        teacher.setAge(teacherDTO.getAge());
        teacher.setGender(teacherDTO.getGender());
        teacher.setPhoneNumber(teacherDTO.getPhoneNumber());
        teacher.setSalary(teacherDTO.getSalary());
        teacherRepository.save(teacher);
        TeacherDTO teacherDTO2 = new TeacherDTO();
        teacherDTO2.setTeacherName(teacherDTO1.get().getTeacherName());
        teacherDTO2.setAge(teacherDTO1.get().getAge());
        teacherDTO2.setGender(teacherDTO1.get().getGender());
        teacherDTO2.setPhoneNumber(teacherDTO1.get().getPhoneNumber());
        teacherDTO2.setSalary(teacherDTO1.get().getSalary());
        return teacherDTO2;
    }

    @Override
    public void deleteTeacher(Long id) {
        teacherRepository.deleteById(id);
    }

    @Override
    public TeacherDTO getTeacherById(Long id) {
        Optional<Teacher> teachers = teacherRepository.findById(id);
        if (teachers.isEmpty()) {
            log.info("Teacher with id " + id + " not found");
            return null;
        }
        TeacherDTO teacherDTO = new TeacherDTO();
        teacherDTO.setTeacherId(teachers.get().getId());
        teacherDTO.setTeacherName(teachers.get().getTeacherName());
        teacherDTO.setAge(teachers.get().getAge());
        teacherDTO.setGender(teachers.get().getGender());
        teacherDTO.setPhoneNumber(teachers.get().getPhoneNumber());
        teacherDTO.setSalary(teachers.get().getSalary());
        return teacherDTO;

    }

    @Override
    public List<TeacherDTO> getAllTeachers() {
        ArrayList<TeacherDTO> teacherDTOArrayList = new ArrayList<>();
        List<Teacher> teachers = teacherRepository.findAll();
        if(teachers.isEmpty()) {
            log.info("No teachers found");
        }
        for (Teacher teacher : teachers) {
            TeacherDTO teacherDTO = new TeacherDTO();
            teacherDTO.setTeacherId(teacher.getId());
            teacherDTO.setTeacherName(teacher.getTeacherName());
            teacherDTO.setAge(teacher.getAge());
            teacherDTO.setGender(teacher.getGender());
            teacherDTO.setPhoneNumber(teacher.getPhoneNumber());
            teacherDTO.setSalary(teacher.getSalary());
            teacherDTOArrayList.add(teacherDTO);
        }
        return teacherDTOArrayList;
    }
}

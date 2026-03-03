package com.systemSchool.School.api.Service.Impl;

import com.systemSchool.School.api.DTO.SubjectDTO;
import com.systemSchool.School.api.DTO.TeacherDTO;
import com.systemSchool.School.api.Entity.SubjectAPI;
import com.systemSchool.School.api.Entity.TeacherAPI;
import com.systemSchool.School.api.Repository.SubjectRepository;
import com.systemSchool.School.api.Repository.TeacherRepository;
import com.systemSchool.School.api.Service.SubjectService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Slf4j
@Service
public class SubjectServiceImpl implements SubjectService {

    private final SubjectRepository subjectRepository;
    private final TeacherRepository teacherRepository;

    public SubjectServiceImpl(SubjectRepository subjectRepository, TeacherRepository teacherRepository) {
        this.subjectRepository = subjectRepository;
        this.teacherRepository = teacherRepository;
    }

    @Override
    public SubjectDTO AddTeacher(List<Long>teacherId, Long subjectId) {
        Optional<SubjectAPI> subjectAPI = subjectRepository.findById(subjectId);
        SubjectAPI subject = subjectAPI.get();
//        Optional List<TeacherAPI> teacherAIP = teacherRepository.findAll(teacherId);
        if (subjectAPI.isPresent()) {
            log.info("Add Teacher", subjectId);
            List<TeacherAPI> teacherAPIS = teacherRepository.findAllById(teacherId);
            subject.setTeacherAPI(teacherAPIS);
            subjectRepository.save(subject);
        }
        return null;
    }

    @Override
    public void addSubject(SubjectDTO subjectDTO) {
        SubjectAPI subjectAPI = new SubjectAPI();
        subjectAPI.setSubjectName(subjectDTO.getSubjectName());
        subjectRepository.save(subjectAPI);
    }

    @Override
    public SubjectDTO deleteSubject(Long subjectId) {
        Optional<SubjectAPI> subjectAPI = subjectRepository.findById(subjectId);
        if (subjectAPI.isPresent()) {
            log.info("Delete Subject", subjectAPI.get().getSubjectName());
            subjectRepository.delete(subjectAPI.get());
        }
        return null;

    }

    @Override
    public void updateSubject(SubjectDTO subjectDTO, Long id) {

    }

    @Override
    public SubjectDTO getSubjectById(Long id) {
        Optional<SubjectAPI> subjectAPI = subjectRepository.findById(id);
        if (subjectAPI.isPresent()) {
            log.info("Get Subject", subjectAPI.get().getSubjectName());
            SubjectDTO subjectDTO = new SubjectDTO();
            subjectDTO.setSubjectId(subjectAPI.get().getSubjectId());
            subjectDTO.setSubjectName(subjectAPI.get().getSubjectName());
            subjectDTO.setTeacherDTOs(List.of(new TeacherDTO()));
            return subjectDTO;
        }
        return null;
    }

    @Override
    public List<SubjectDTO> getAllSubjects() {

        return List.of();
    }
}

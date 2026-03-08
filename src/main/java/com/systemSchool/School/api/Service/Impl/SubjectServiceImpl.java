package com.systemSchool.School.api.Service.Impl;

import com.systemSchool.School.api.DTO.ClassDTO.ClassRequest;
import com.systemSchool.School.api.DTO.SubjectDTO.SubjectRequest;
import com.systemSchool.School.api.DTO.SubjectDTO.SubjectResponse;
import com.systemSchool.School.api.DTO.TeacherDTO.TeacherRequest;
import com.systemSchool.School.api.DTO.TeacherDTO.TeacherResponse;
import com.systemSchool.School.api.Model.ClassAPI;
import com.systemSchool.School.api.Model.SubjectAPI;
import com.systemSchool.School.api.Model.TeacherAPI;
import com.systemSchool.School.api.Repository.SubjectRepository;
import com.systemSchool.School.api.Service.SubjectService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Slf4j
@Service
public class SubjectServiceImpl implements SubjectService {
    private final SubjectRepository subjectRepository;

    public SubjectServiceImpl(SubjectRepository subjectRepository) {
        this.subjectRepository = subjectRepository;
    }


    @Override
    public void saveSubject(SubjectRequest subjectRequest) {
        SubjectAPI subjectAPI = new SubjectAPI();
        subjectAPI.setSubjectName(subjectRequest.getSubjectName());
        subjectRepository.save(subjectAPI);
    }

    @Override
    public void updateSubject(Long id, SubjectRequest subjectRequest) {
        Optional<SubjectAPI> subjectAPI = subjectRepository.findById(id);
        if (subjectAPI.isPresent()) {
            subjectAPI.get().setSubjectName(subjectRequest.getSubjectName());
            subjectRepository.save(subjectAPI.get());
        }
        log.error("Subject not found",id);
    }

    @Override
    public void deleteSubject(Long id) {
        subjectRepository.deleteById(id);
    }

    @Override
    public SubjectResponse getSubject(Long id) {
        Optional<SubjectAPI> subjectAPI = subjectRepository.findById(id);

        if (subjectAPI.isEmpty()) {
            log.error("Subject not found");
            return null;
        }
        SubjectResponse subjectResponse = new SubjectResponse();
        subjectResponse.setSubjectId(subjectAPI.get().getSubjectId());
        subjectResponse.setSubjectName(subjectAPI.get().getSubjectName());
        TeacherAPI teacherAPI = subjectAPI.get().getTeacher();
        if (teacherAPI != null) {
            TeacherRequest teacherRequest = new TeacherRequest();
            teacherRequest.setTeacherName(teacherAPI.getTeacherName());
            teacherRequest.setSalary(teacherAPI.getSalary());
            subjectResponse.setTeachers(teacherRequest);
        }else {
            subjectResponse.setTeachers(null);
        }
        return subjectResponse;
    }

    @Override
    public List<SubjectResponse> getAllSubjects() {
        List<SubjectAPI> subjectAPIList = subjectRepository.findAll();
        List<SubjectResponse> subjectResponseList = new ArrayList<>();
        for (SubjectAPI subjectAPI : subjectAPIList) {
            SubjectResponse subjectResponse = new SubjectResponse();
            subjectResponse.setSubjectId(subjectAPI.getSubjectId());
            subjectResponse.setSubjectName(subjectAPI.getSubjectName());
            TeacherAPI teacherAPI = subjectAPI.getTeacher();
            if (teacherAPI != null) {
                TeacherRequest teacherRequest = new TeacherRequest();
                teacherRequest.setTeacherName(teacherAPI.getTeacherName());
                teacherRequest.setSalary(teacherAPI.getSalary());
                subjectResponse.setTeachers(teacherRequest);
            }else {
                subjectResponse.setTeachers(null);
            }
            subjectResponseList.add(subjectResponse);
        }
        return subjectResponseList;
    }
}

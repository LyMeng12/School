package com.systemSchool.School.api.Service.Impl;

import com.systemSchool.School.api.DTO.ClassDTO.ClassRequest;
import com.systemSchool.School.api.DTO.StudentDTO.StudentRequest;
import com.systemSchool.School.api.DTO.SubjectDTO.SubjectRequest;
import com.systemSchool.School.api.DTO.SubjectDTO.SubjectResponse;
import com.systemSchool.School.api.DTO.TeacherDTO.TeacherRequest;
import com.systemSchool.School.api.DTO.TeacherDTO.TeacherResponse;
import com.systemSchool.School.api.Model.SubjectAPI;
import com.systemSchool.School.api.Model.TeacherAPI;
import com.systemSchool.School.api.Repository.SubjectRepository;
import com.systemSchool.School.api.Repository.TeacherRepository;
import com.systemSchool.School.api.Service.TeacherService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Slf4j
@Service
public class TeacherServiceImpl implements TeacherService {

    private final TeacherRepository teacherRepository;
    private final SubjectRepository subjectRepository;

    public TeacherServiceImpl(TeacherRepository teacherRepository, SubjectRepository subjectRepository) {
        this.teacherRepository = teacherRepository;
        this.subjectRepository = subjectRepository;
    }

    @Override
    public void newTeacher(TeacherRequest teacherRequest) {
        TeacherAPI teacherAPI = new TeacherAPI();
        teacherAPI.setTeacherName(teacherRequest.getTeacherName());
        teacherAPI.setSalary(teacherRequest.getSalary());
        teacherRepository.save(teacherAPI);
    }

    @Override
    public void updateTeacher(Long Id, TeacherRequest teacherRequest) {
        Optional<TeacherAPI> teacherAPI = teacherRepository.findById(Id);
        if (teacherAPI.isEmpty()) {
            log.error("Teacher not found",Id);
        }
        TeacherAPI teacherAPI1 = teacherAPI.get();
        teacherAPI1.setTeacherName(teacherRequest.getTeacherName());
        teacherAPI1.setSalary(teacherRequest.getSalary());
        teacherRepository.save(teacherAPI1);
    }

    @Override
    public void deleteTeacher(Long Id) {
        teacherRepository.deleteById(Id);
    }

    @Override
    public TeacherResponse getTeacherById(Long Id) {
        Optional<TeacherAPI> teacherAPI = teacherRepository.findById(Id);
        if (teacherAPI.isEmpty()) {
            log.error("Teacher not found",Id);
            return null;
        }
        TeacherResponse teacherResponse = new TeacherResponse();
        teacherResponse.setTeacherId(teacherAPI.get().getTeacherId());
        teacherResponse.setTeacherName(teacherAPI.get().getTeacherName());
        teacherResponse.setSalary(teacherAPI.get().getSalary());
        teacherResponse.setSubjects(
                teacherAPI.get().getSubjects().stream().map(subjectAPI -> {
                   SubjectRequest subjectResponse = new SubjectRequest();
                   subjectResponse.setSubjectName(subjectAPI.getSubjectName());
                   return subjectResponse;
                }).toList()
        );
        teacherResponse.setClasses(
                teacherAPI.get().getClasses().stream().map(classAPI -> {
                    ClassRequest classResponse = new ClassRequest();
                    classResponse.setClassId(classAPI.getClassId());
                    classResponse.setClassName(classAPI.getClassName());
                    classResponse.setClassRoom(classAPI.getClassRoom());
                    return classResponse;
                }).toList()
        );
        return teacherResponse;
    }

    @Override
    public List<TeacherResponse> getAllTeachers() {
        List<TeacherAPI> teacherAPI = teacherRepository.findAll();
        List<TeacherResponse> teacherResponseList = new ArrayList<>();
        for (TeacherAPI teacherAPI1 : teacherAPI) {
            TeacherResponse teacherResponse = new TeacherResponse();
            teacherResponse.setTeacherId(teacherAPI1.getTeacherId());
            teacherResponse.setTeacherName(teacherAPI1.getTeacherName());
            teacherResponse.setSalary(teacherAPI1.getSalary());
            teacherResponse.setSubjects(
                    teacherAPI1.getSubjects().stream().map(subjectAPI -> {
                        SubjectRequest subjectResponse = new SubjectRequest();
                        subjectResponse.setSubjectName(subjectAPI.getSubjectName());
                        return subjectResponse;
                    }).toList()
            );
            teacherResponse.setClasses(
                    teacherAPI1.getClasses().stream().map(classAPI -> {
                        ClassRequest classResponse = new ClassRequest();
                        classResponse.setClassId(classAPI.getClassId());
                        classResponse.setClassName(classAPI.getClassName());
                        classResponse.setClassRoom(classAPI.getClassRoom());
                        return classResponse;
                    }).toList()
            );
            teacherResponseList.add(teacherResponse);
        }

        return teacherResponseList;
    }

    @Override
    public void AddSubjectToTeacher(Long TeacherId, SubjectRequest subjectRequest) {
        Optional<TeacherAPI> teacherAPI = teacherRepository.findById(TeacherId);
        if (teacherAPI.isEmpty()) {
            log.error("Teacher not found",TeacherId);
        }
        Optional<SubjectAPI> subjectAPI = subjectRepository.findById(subjectRequest.getSubjectId());
        SubjectAPI subjectAPI1 = subjectAPI.get();
        subjectAPI1.setTeacher(teacherAPI.get());
        subjectRepository.save(subjectAPI1);
    }

    @Override
    public void RemoveSubjectFromTeacher(Long TeacherId, SubjectRequest subjectRequest) {
        Optional<TeacherAPI> teacherAPI = teacherRepository.findById(TeacherId);
        if (teacherAPI.isEmpty()) {
            log.error("Teacher not found",TeacherId);
        }
        Optional<SubjectAPI> subjectAPI = subjectRepository.findById(subjectRequest.getSubjectId());
        if (subjectAPI.isEmpty()) {
            log.error("Subject not found",subjectRequest.getSubjectId());
        }
        SubjectAPI subjectAPI1 = subjectAPI.get();
        subjectAPI1.setTeacher(null);
        subjectRepository.save(subjectAPI1);
    }
}

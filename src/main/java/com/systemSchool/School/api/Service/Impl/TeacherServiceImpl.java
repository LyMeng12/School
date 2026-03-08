package com.systemSchool.School.api.Service.Impl;

import com.systemSchool.School.api.DTO.ClassDTO.ClassRequest;
import com.systemSchool.School.api.DTO.StudentDTO.StudentRequest;
import com.systemSchool.School.api.DTO.SubjectDTO.SubjectRequest;
import com.systemSchool.School.api.DTO.SubjectDTO.SubjectResponse;
import com.systemSchool.School.api.DTO.TeacherDTO.TeacherRequest;
import com.systemSchool.School.api.DTO.TeacherDTO.TeacherResponse;
import com.systemSchool.School.api.Model.SubjectAPI;
import com.systemSchool.School.api.Model.TeacherAPI;
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

    public TeacherServiceImpl(TeacherRepository teacherRepository) {
        this.teacherRepository = teacherRepository;
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
                    classResponse.setClassName(classAPI.getClassName());
                    classResponse.setClassRoom(classAPI.getClassRoom());
                    return classResponse;
                }).toList()
        );
        teacherResponse.setStudents(
               teacherAPI.get().getStudents().stream().map(studentAPI -> {
                   StudentRequest studentResponse = new StudentRequest();
                   studentResponse.setStudentName(studentAPI.getStudentName());
                   studentResponse.setStudentGender(studentAPI.getGender());
                   studentResponse.setStudentAge(studentAPI.getAge());
                   return studentResponse;
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
                        classResponse.setClassName(classAPI.getClassName());
                        classResponse.setClassRoom(classAPI.getClassRoom());
                        return classResponse;
                    }).toList()
            );
            teacherResponse.setStudents(
                    teacherAPI1.getStudents().stream().map(studentAPI -> {
                        StudentRequest studentResponse = new StudentRequest();
                        studentResponse.setStudentName(studentAPI.getStudentName());
                        studentResponse.setStudentGender(studentAPI.getGender());
                        studentResponse.setStudentAge(studentAPI.getAge());
                        return studentResponse;
                    }).toList()
            );
            teacherResponseList.add(teacherResponse);
        }

        return teacherResponseList;
    }
}

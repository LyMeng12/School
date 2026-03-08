package com.systemSchool.School.api.Service.Impl;

import com.systemSchool.School.api.DTO.ClassDTO.ClassRequest;
import com.systemSchool.School.api.DTO.ClassDTO.ClassResponse;
import com.systemSchool.School.api.DTO.StudentDTO.StudentRequest;
import com.systemSchool.School.api.DTO.StudentDTO.StudentResponse;
import com.systemSchool.School.api.DTO.TeacherDTO.TeacherRequest;
import com.systemSchool.School.api.Model.ClassAPI;
import com.systemSchool.School.api.Model.StudentAPI;
import com.systemSchool.School.api.Repository.ClassRepository;
import com.systemSchool.School.api.Service.ClassService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@Slf4j
public class ClassServiceImpl implements ClassService {
    private final ClassRepository classRepository;

    public ClassServiceImpl(ClassRepository classRepository) {
        this.classRepository = classRepository;
    }

    @Override
    public void newClass(ClassRequest classRequest) {
        ClassAPI classResponse = new ClassAPI();
        classResponse.setClassName(classRequest.getClassName());
        classResponse.setClassRoom(classRequest.getClassRoom());
        classRepository.save(classResponse);
    }

    @Override
    public void updateClass(Long id, ClassRequest classRequest) {
        Optional<ClassAPI> classResponse = classRepository.findById(id);
        if(classResponse.isEmpty()) {
            log.error("Class not found",id);
        }
        classResponse.get().setClassName(classRequest.getClassName());
        classResponse.get().setClassRoom(classRequest.getClassRoom());
        classRepository.save(classResponse.get());
    }

    @Override
    public void deleteClass(Long id) {
        Optional<ClassAPI> classResponse = classRepository.findById(id);
        if(classResponse.isEmpty()) {
            log.error("Class not found",id);
        }
        classRepository.delete(classResponse.get());
    }

    @Override
    public ClassResponse getClassById(Long id) {
        Optional<ClassAPI> classResponse = classRepository.findById(id);
        if(classResponse.isEmpty()) {
            log.error("Class not found",id);
            return null;
        }
        ClassResponse classResponseDTO = new ClassResponse();
        classResponseDTO.setClassId(classResponse.get().getClassId());
        classResponseDTO.setClassName(classResponse.get().getClassName());
        classResponseDTO.setClassRoom(classResponse.get().getClassRoom());
        classResponseDTO.setStudents(
                classResponse.get().getStudentAPI().stream().map(studentAPI ->{
                    StudentRequest studentResponseDTO = new StudentRequest();
                    studentResponseDTO.setStudentName(studentAPI.getStudentName());
                    studentResponseDTO.setStudentGender(studentAPI.getGender());
                    studentResponseDTO.setStudentAge(studentAPI.getAge());
                    return studentResponseDTO;
                }).toList()
        );
        classResponseDTO.setTeachers(
                classResponse.get().getTeacherAPI().stream().map(teacherAPI ->{
                    TeacherRequest teacherResponseDTO = new TeacherRequest();
                    teacherResponseDTO.setTeacherName(teacherAPI.getTeacherName());
                    return teacherResponseDTO;
                }).toList()
        );
        return classResponseDTO;
    }

    @Override
    public List<ClassResponse> getAllClasses() {
        List<ClassAPI> all = classRepository.findAll();
        List<ClassResponse> classResponses = new ArrayList<>();
        for(ClassAPI classAPI : all) {
            ClassResponse classResponseDTO = new ClassResponse();
            classResponseDTO.setClassId(classAPI.getClassId());
            classResponseDTO.setClassName(classAPI.getClassName());
            classResponseDTO.setClassRoom(classAPI.getClassRoom());
            classResponseDTO.setStudents(
                    classAPI.getStudentAPI().stream().map(studentAPI -> {

                        StudentRequest studentResponseDTO = new StudentRequest();
                        studentResponseDTO.setStudentName(studentAPI.getStudentName());
                        studentResponseDTO.setStudentAge(studentAPI.getAge());
                        studentResponseDTO.setStudentGender(studentAPI.getGender());
                        return studentResponseDTO;

                    }).toList()
            );
            classResponseDTO.setTeachers(
                    classAPI.getTeacherAPI().stream().map(teacherAPI -> {

                        TeacherRequest teacherResponseDTO = new TeacherRequest();
                        teacherResponseDTO.setTeacherName(teacherAPI.getTeacherName());
                        teacherResponseDTO.setSalary(teacherAPI.getSalary());
                        return teacherResponseDTO;

                    }).toList()
            );
            classResponses.add(classResponseDTO);

        }
        return classResponses;
    }
}

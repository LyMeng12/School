package com.systemSchool.School.api.Service.Impl;

import com.systemSchool.School.api.DTO.ClassDTO.ClassRequest;
import com.systemSchool.School.api.DTO.StudentDTO.StudentRequest;
import com.systemSchool.School.api.DTO.StudentDTO.StudentResponse;
import com.systemSchool.School.api.DTO.TeacherDTO.TeacherRequest;
import com.systemSchool.School.api.Model.ClassAPI;
import com.systemSchool.School.api.Model.StudentAPI;
import com.systemSchool.School.api.Model.TeacherAPI;
import com.systemSchool.School.api.Repository.ClassRepository;
import com.systemSchool.School.api.Repository.StudentRepository;
import com.systemSchool.School.api.Service.StudentService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Slf4j
@Service
public class StudentServiceImpl implements StudentService {
    private final StudentRepository studentRepository;
    private final ClassRepository classRepository;

    public StudentServiceImpl(StudentRepository studentRepository,ClassRepository classRepository) {
        this.studentRepository = studentRepository;
        this.classRepository = classRepository;
    }


    @Override
    public StudentResponse newStudent(StudentRequest studentRequest) {
        StudentAPI studentAPI = new StudentAPI();
        studentAPI.setStudentName(studentRequest.getStudentName());
        studentAPI.setGender(studentRequest.getStudentGender());
        studentAPI.setAge(studentRequest.getStudentAge());
        studentRepository.save(studentAPI);
        return null;
    }

    @Override
    public void updateStudent(Long id, StudentRequest studentRequest) {
        Optional<StudentAPI> studentAPI = studentRepository.findById(id);
        if (studentAPI.isEmpty()) {
            log.error("Student with id {} not found", id);
        }
        studentAPI.get().setStudentName(studentRequest.getStudentName());
        studentAPI.get().setGender(studentRequest.getStudentGender());
        studentAPI.get().setAge(studentRequest.getStudentAge());
        studentRepository.save(studentAPI.get());
    }

    @Override
    public void deleteStudent(Long id) {
        Optional<StudentAPI> studentAPI = studentRepository.findById(id);
        if (studentAPI.isEmpty()) {
            log.error("Student with id {} not found", id);
        }
        studentRepository.delete(studentAPI.get());
    }

    @Override
    public StudentResponse getStudent(Long id) {
        Optional<StudentAPI> studentAPI = studentRepository.findById(id);
        if (studentAPI.isEmpty()) {
            log.error("Student with id {} not found", id);
            return null;
        }
        StudentResponse studentResponse = new StudentResponse();
        studentResponse.setStudentId(studentAPI.get().getStudentId());
        studentResponse.setStudentName(studentAPI.get().getStudentName());
        studentResponse.setStudentGender(studentAPI.get().getGender());
        studentResponse.setStudentAge(studentAPI.get().getAge());
        ClassAPI classAPI = studentAPI.get().getClassAPI();
        if (classAPI == null) {
            studentResponse.setClasses(null);
        }else {
            ClassRequest classResponse = new ClassRequest();
            classResponse.setClassName(classAPI.getClassName());
            classResponse.setClassRoom(classAPI.getClassRoom());
            studentResponse.setClasses(classResponse);
        }

        return studentResponse;
    }

    @Override
    public StudentResponse getStudentByName(String name) {
        Optional<StudentAPI> student = studentRepository.findByStudentName(name);
        if (student.isEmpty()) {
            log.error("Student with name {} not found", name);
            return null;
        }
        StudentResponse studentResponse = new StudentResponse();
        studentResponse.setStudentId(student.get().getStudentId());
        studentResponse.setStudentName(student.get().getStudentName());
        studentResponse.setStudentGender(student.get().getGender());
        studentResponse.setStudentAge(student.get().getAge());
        ClassAPI classAPI = student.get().getClassAPI();
        if(classAPI == null) {
            studentResponse.setClasses(null);
        }else {
            ClassRequest classResponse = new ClassRequest();
            classResponse.setClassName(classAPI.getClassName());
            classResponse.setClassRoom(classAPI.getClassRoom());
            studentResponse.setClasses(classResponse);
        }

        return studentResponse;
    }

    @Override
    public List<StudentResponse> getStudents() {
        List<StudentAPI> studentAPIList = studentRepository.findAll();
        List<StudentResponse> studentResponseList = new ArrayList<>();
        for (StudentAPI studentAPI : studentAPIList) {
            StudentResponse studentResponse = new StudentResponse();
            studentResponse.setStudentId(studentAPI.getStudentId());
            studentResponse.setStudentName(studentAPI.getStudentName());
            studentResponse.setStudentGender(studentAPI.getGender());
            studentResponse.setStudentAge(studentAPI.getAge());
            ClassAPI classAPI = studentAPI.getClassAPI();
            if(classAPI == null) {
                studentResponse.setClasses(null);
            }
            else {
                ClassRequest classResponse = new ClassRequest();
                classResponse.setClassId(classAPI.getClassId());
                classResponse.setClassName(classAPI.getClassName());
                classResponse.setClassRoom(classAPI.getClassRoom());
                studentResponse.setClasses(classResponse);
            }
        }
        return studentResponseList;
    }


}

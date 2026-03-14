package com.systemSchool.School.api.Service.Impl;

import com.systemSchool.School.api.DTO.ClassDTO.ClassRequest;
import com.systemSchool.School.api.DTO.ClassDTO.ClassResponse;
import com.systemSchool.School.api.DTO.StudentDTO.StudentRequest;
import com.systemSchool.School.api.DTO.StudentDTO.StudentResponse;
import com.systemSchool.School.api.DTO.TeacherDTO.TeacherRequest;
import com.systemSchool.School.api.Model.ClassAPI;
import com.systemSchool.School.api.Model.StudentAPI;
import com.systemSchool.School.api.Model.TeacherAPI;
import com.systemSchool.School.api.Repository.ClassRepository;
import com.systemSchool.School.api.Repository.StudentRepository;
import com.systemSchool.School.api.Repository.TeacherRepository;
import com.systemSchool.School.api.Service.ClassService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Service
@Slf4j
public class ClassServiceImpl implements ClassService {
    private final ClassRepository classRepository;
    private final StudentRepository studentRepository;
    private final TeacherRepository teacherRepository;


    public ClassServiceImpl(ClassRepository classRepository, StudentRepository studentRepository, TeacherRepository teacherRepository) {
        this.classRepository = classRepository;
        this.studentRepository = studentRepository;
        this.teacherRepository = teacherRepository;
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
                    studentResponseDTO.setStudentId(studentAPI.getStudentId());
                    studentResponseDTO.setStudentName(studentAPI.getStudentName());
                    studentResponseDTO.setStudentGender(studentAPI.getGender());
                    studentResponseDTO.setStudentAge(studentAPI.getAge());
                    return studentResponseDTO;
                }).toList()
        );
        //stream<List<ClassResponse>>
        classResponseDTO.setTeachers(
                classResponse.get().getTeacherAPI().stream().map(teacherAPI ->{
                    TeacherRequest teacherResponseDTO = new TeacherRequest();
                    teacherResponseDTO.setTeacherId(teacherAPI.getTeacherId());
                    teacherResponseDTO.setTeacherName(teacherAPI.getTeacherName());
                    teacherResponseDTO.setSalary(teacherAPI.getSalary());
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
                        studentResponseDTO.setStudentId(studentAPI.getStudentId());
                        studentResponseDTO.setStudentName(studentAPI.getStudentName());
                        studentResponseDTO.setStudentAge(studentAPI.getAge());
                        studentResponseDTO.setStudentGender(studentAPI.getGender());
                        return studentResponseDTO;

                    }).toList()
            );
            classResponseDTO.setTeachers(
                    classAPI.getTeacherAPI().stream().map(teacherAPI -> {

                        TeacherRequest teacherResponseDTO = new TeacherRequest();
                        teacherResponseDTO.setTeacherId(teacherAPI.getTeacherId());
                        teacherResponseDTO.setTeacherName(teacherAPI.getTeacherName());
                        teacherResponseDTO.setSalary(teacherAPI.getSalary());
                        return teacherResponseDTO;

                    }).toList()
            );
            classResponses.add(classResponseDTO);

        }
        return classResponses;
    }

    @Override
    public ClassResponse getClassByName(String className) {
        Optional<ClassAPI>classResponse = classRepository.findByClassName(className);
        if(classResponse.isEmpty()) {
            log.error("Class not found",className);
        }
        ClassResponse classResponseDTO = new ClassResponse();
        classResponseDTO.setClassId(classResponse.get().getClassId());
        classResponseDTO.setClassName(classResponse.get().getClassName());
        classResponseDTO.setClassRoom(classResponse.get().getClassRoom());
        classResponseDTO.setStudents(
                classResponse.get().getStudentAPI().stream().map(studentAPI -> {

                    StudentRequest studentResponseDTO = new StudentRequest();
                    studentResponseDTO.setStudentId(studentAPI.getStudentId());
                    studentResponseDTO.setStudentName(studentAPI.getStudentName());
                    studentResponseDTO.setStudentAge(studentAPI.getAge());
                    studentResponseDTO.setStudentGender(studentAPI.getGender());
                    return studentResponseDTO;

                }).toList()
        );
        classResponseDTO.setTeachers(
                classResponse.get().getTeacherAPI().stream().map(teacherAPI -> {

                    TeacherRequest teacherResponseDTO = new TeacherRequest();
                    teacherResponseDTO.setTeacherId(teacherAPI.getTeacherId());
                    teacherResponseDTO.setTeacherName(teacherAPI.getTeacherName());
                    teacherResponseDTO.setSalary(teacherAPI.getSalary());
                    return teacherResponseDTO;

                }).toList()
        );
        return classResponseDTO;
    }

    @Override
    public ClassResponse addStudetIntoClass(Long classId, List<StudentRequest> students) {
        Optional<ClassAPI> classResponse = classRepository.findById(classId);
        if(classResponse.isEmpty()) {
            log.error("Class not found",classId);
        }

        // 2. Find all students and set class
        List<StudentAPI> studentEntities = students.stream().map(studentRequest -> {

            StudentAPI student = studentRepository.findById(studentRequest.getStudentId())
                    .orElseThrow(() -> new RuntimeException("Student not found: " + studentRequest.getStudentId()));

            // assign class
            student.setClassAPI(classResponse.get());

            return student;

        }).toList();

        // 3. Save all students at once
        studentRepository.saveAll(studentEntities);
        ClassResponse classResponseDTO = new ClassResponse();
        classResponseDTO.setClassId(classResponse.get().getClassId());
        classResponseDTO.setClassName(classResponse.get().getClassName());
        classResponseDTO.setClassRoom(classResponse.get().getClassRoom());
        classResponseDTO.setStudents(
                classResponse.get().getStudentAPI().stream().map(studentAPI ->{
                    StudentRequest studentResponseDTO = new StudentRequest();
                    studentResponseDTO.setStudentId(studentAPI.getStudentId());
                    studentResponseDTO.setStudentName(studentAPI.getStudentName());
                    studentResponseDTO.setStudentGender(studentAPI.getGender());
                    studentResponseDTO.setStudentAge(studentAPI.getAge());
                    return studentResponseDTO;
                }).toList()
        );
        //stream<List<ClassResponse>>
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
    public ClassResponse removeStudentIntoClass(Long classId, List<StudentRequest> studentRequests) {
        Optional<ClassAPI> classResponse = classRepository.findById(classId);
        if(classResponse.isEmpty()) {
            log.error("Class not found",classId);
        }

        // 2. Find all students and set class
        List<StudentAPI> studentEntities = studentRequests.stream().map(studentRequest -> {

            StudentAPI student = studentRepository.findById(studentRequest.getStudentId())
                    .orElseThrow(() -> new RuntimeException("Student not found: " + studentRequest.getStudentId()));

            // assign class
            student.setClassAPI(null);

            return student;

        }).toList();

        // 3. Save all students at once
        studentRepository.saveAll(studentEntities);
        ClassResponse classResponseDTO = new ClassResponse();
        classResponseDTO.setClassId(classResponse.get().getClassId());
        classResponseDTO.setClassName(classResponse.get().getClassName());
        classResponseDTO.setClassRoom(classResponse.get().getClassRoom());
        classResponseDTO.setStudents(
                classResponse.get().getStudentAPI().stream().map(studentAPI ->{
                    StudentRequest studentResponseDTO = new StudentRequest();
                    studentResponseDTO.setStudentId(studentAPI.getStudentId());
                    studentResponseDTO.setStudentName(studentAPI.getStudentName());
                    studentResponseDTO.setStudentGender(studentAPI.getGender());
                    studentResponseDTO.setStudentAge(studentAPI.getAge());
                    return studentResponseDTO;
                }).toList()
        );
        //stream<List<ClassResponse>>
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
    public ClassResponse addTeacherIntoClass(Long classId, List<TeacherRequest> teacherRequests) {
        Optional<ClassAPI> classResponse = classRepository.findById(classId);
        if(classResponse.isEmpty()) {
            log.error("Class not found",classId);
            return null;
        }
        List<TeacherAPI> teacherAPIS = new ArrayList<>();
        for(TeacherRequest teacherRequest : teacherRequests) {
            Optional<TeacherAPI> teacherAPIOptional = teacherRepository.findById(teacherRequest.getTeacherId());
            if(teacherAPIOptional.isEmpty()) {
                log.error("Teacher not found",teacherRequest.getTeacherId());
                return null;
            }
            TeacherAPI teacherAPI = new TeacherAPI();
            teacherAPI.setTeacherId(teacherRequest.getTeacherId());
            teacherAPI.setTeacherName(teacherRequest.getTeacherName());
            teacherAPI.setSalary(teacherRequest.getSalary());
            teacherAPIS.add(teacherAPI);
        }
        classResponse.get().setTeacherAPI(teacherAPIS);
        classRepository.save(classResponse.get());
        ClassResponse classResponseDTO = new ClassResponse();
        classResponseDTO.setClassId(classResponse.get().getClassId());
        classResponseDTO.setClassName(classResponse.get().getClassName());
        classResponseDTO.setClassRoom(classResponse.get().getClassRoom());
        classResponseDTO.setStudents(
                classResponse.get().getStudentAPI().stream().map(studentAPI ->{
                    StudentRequest studentResponseDTO = new StudentRequest();
                    studentResponseDTO.setStudentId(studentAPI.getStudentId());
                    studentResponseDTO.setStudentName(studentAPI.getStudentName());
                    studentResponseDTO.setStudentGender(studentAPI.getGender());
                    studentResponseDTO.setStudentAge(studentAPI.getAge());
                    return studentResponseDTO;
                }).toList()
        );
        //stream<List<ClassResponse>>
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
    public ClassResponse removeTeacherIntoClass(Long classId, List<TeacherRequest> teacherRequests) {
        return null;
    }


}

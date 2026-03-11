package com.systemSchool.School.api.Service.Impl;

import com.systemSchool.School.api.DTO.ClassDTO.ClassRequest;
import com.systemSchool.School.api.DTO.ClassDTO.ClassResponse;
import com.systemSchool.School.api.DTO.StudentDTO.StudentRequest;
import com.systemSchool.School.api.DTO.StudentDTO.StudentResponse;
import com.systemSchool.School.api.DTO.TeacherDTO.TeacherRequest;
import com.systemSchool.School.api.Model.ClassAPI;
import com.systemSchool.School.api.Model.StudentAPI;
import com.systemSchool.School.api.Repository.ClassRepository;
import com.systemSchool.School.api.Repository.StudentRepository;
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
    private final StudentRepository studentRepository;

    public ClassServiceImpl(ClassRepository classRepository, StudentRepository studentRepository) {
        this.classRepository = classRepository;
        this.studentRepository = studentRepository;
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
                        teacherResponseDTO.setTeacherName(teacherAPI.getTeacherName());
                        teacherResponseDTO.setSalary(teacherAPI.getSalary());
                        return teacherResponseDTO;

                    }).toList()
            );
            classResponses.add(classResponseDTO);

        }
        return classResponses;
    }


//    Student

    @Override
    public ClassResponse getClassByStudentName(String StudentName) {
        Optional<ClassAPI> classAPI = classRepository.findByClassName(StudentName);
        if(classAPI.isEmpty()) {
            log.error("Class not found",StudentName);
            return null;
        }
        ClassResponse classResponseDTO = new ClassResponse();
        classResponseDTO.setClassId(classAPI.get().getClassId());
        classResponseDTO.setClassName(classAPI.get().getClassName());
        classResponseDTO.setClassRoom(classAPI.get().getClassRoom());
        classResponseDTO.setStudents(
                classAPI.get().getStudentAPI().stream().map(studentAPI -> {
                    StudentRequest studentResponseDTO = new StudentRequest();
                    studentResponseDTO.setStudentName(studentAPI.getStudentName());
                    studentResponseDTO.setStudentGender(studentAPI.getGender());
                    studentResponseDTO.setStudentAge(studentAPI.getAge());
                    return studentResponseDTO;
                }).toList()
        );
        classResponseDTO.setTeachers(
                classAPI.get().getTeacherAPI().stream().map(teacherAPI -> {
                    TeacherRequest teacherResponseDTO = new TeacherRequest();
                    teacherResponseDTO.setTeacherName(teacherAPI.getTeacherName());
                    teacherResponseDTO.setSalary(teacherAPI.getSalary());
                    return teacherResponseDTO;
                }).toList()
        );
        return classResponseDTO;
    }

    @Override
    public void addStudentIntoClass(Long classId, StudentRequest studentRequest) {
        Optional<ClassAPI> classResponse = classRepository.findById(classId);
        if(classResponse.isEmpty()) {
            log.error("Class not found",classId);
        }
        StudentAPI studentResponseDTO = new StudentAPI();
        studentResponseDTO.setStudentId(studentRequest.getStudentId());
        studentResponseDTO.setStudentName(studentRequest.getStudentName());
        studentResponseDTO.setGender(studentRequest.getStudentGender());
        studentResponseDTO.setAge(studentRequest.getStudentAge());
        studentResponseDTO.setClassAPI(classResponse.get());
        classResponse.get().getStudentAPI().add(studentResponseDTO);

        classRepository.save(classResponse.get());
    }

    @Override
    public void deleteStudentFromClass(Long classId, String StudentName) {
        Optional<ClassAPI> classResponse = classRepository.findById(classId);
        if(classResponse.isEmpty()) {
            log.error("Class not found",classId);
        }
        classResponse.get().getStudentAPI().stream().map(studentAPI -> {
            studentAPI.setStudentName(null);
            return studentAPI;
        }).toList();
    }

    @Override
    public void updateStudentInClass(Long classId,Long studentId, StudentRequest studentRequest) {
        Optional<ClassAPI> classResponse = classRepository.findById(classId);
        if(classResponse.isEmpty()) {
            log.error("Class not found",classId);
        }
        Optional<StudentAPI> studentResponse = studentRepository.findById(studentId);
        if(studentResponse.isEmpty()) {
            log.error("Student not found",studentId);
        }
        studentResponse.get().setClassAPI(null);
        studentRepository.save(studentResponse.get());
        StudentAPI studentResponseDTO = studentResponse.get();
        studentResponseDTO.setClassAPI(classResponse.get());
        studentRepository.save(studentResponseDTO);

    }


//    teacher

    @Override
    public ClassResponse getClassByTeacherName(String TeacherName) {
        return null;
    }

    @Override
    public void addStudentIntoClass(Long classId, TeacherRequest teacherRequest) {

    }

    @Override
    public void deleteTeacherFromClass(Long classId, String TeacherName) {

    }

    @Override
    public void updateTeacherInClass(Long classId, String TeacherName, TeacherRequest teacherRequest) {

    }
}

package com.systemSchool.School.api.Service.Impl;

import com.systemSchool.School.api.DTO.ClassDTO;
import com.systemSchool.School.api.DTO.StudentDTO;
import com.systemSchool.School.api.Entity.ClassAPI;
import com.systemSchool.School.api.Entity.StudentAPI;
import com.systemSchool.School.api.Repository.StudentRepository;
import com.systemSchool.School.api.Service.StudentService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Slf4j
@Service
public class StudentServiceImpl implements StudentService {

    private final StudentRepository studentRepository;

    public StudentServiceImpl(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    @Override
    public void newStudent(StudentDTO student) {
        StudentAPI stu = new StudentAPI();
        stu.setStudentName(student.getStudentName());
        stu.setGender(student.getGender());
        stu.setDob(student.getDob());
        stu.setEmail(student.getEmail());
        studentRepository.save(stu);
    }

    @Override
    public void updateStudent(StudentDTO student, Long id) {

    }

    @Override
    public void deleteStudent(Long id) {
        studentRepository.deleteById(id);
    }

    @Override
    public StudentDTO getStudent(Long id) {
        StudentDTO student = new StudentDTO();
        Optional<StudentAPI> stu = studentRepository.findById(id);
        if (stu.isEmpty()) {
            log.error("Student not found",id);
            return null;
        }
        student.setStudentId(stu.get().getStudentId());
        student.setStudentName(stu.get().getStudentName());
        student.setGender(stu.get().getGender());
        student.setDob(stu.get().getDob());
        student.setEmail(stu.get().getEmail());
        ClassAPI clazz = new ClassAPI();
        if(clazz != null){
            ClassDTO classDTO = new ClassDTO();
            classDTO.setClassName(clazz.getClassName());
            student.setClassDTO(classDTO);
        }
        return student;
    }

    @Override
    public List<StudentDTO> getAllStudents() {
        return List.of();
    }
}

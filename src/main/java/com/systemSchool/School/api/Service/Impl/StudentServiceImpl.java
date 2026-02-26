package com.systemSchool.School.api.Service.Impl;

import com.systemSchool.School.api.Entity.Student;
import com.systemSchool.School.api.Repository.StudentRepository;
import com.systemSchool.School.api.Service.StudentServer;
import com.systemSchool.School.api.dto.StudentDTO;
import lombok.Data;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
@Slf4j
public  class StudentServiceImpl implements StudentServer{
    private final StudentRepository studentRepository;

    public StudentServiceImpl(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }


    @Override
    public void NewStudent(StudentDTO studentDTO) {
        Student stu = new Student();
        stu.setStudentName(studentDTO.getStudentName());
        stu.setStudentGender(studentDTO.getStudentGender());
        stu.setStudentDOB(studentDTO.getStudentDOB());
        stu.setClassName(studentDTO.getClassName());
        studentRepository.save(stu);
    }

    @Override
    public StudentDTO UpdateStudent(Long StudentId, StudentDTO studentDTO) {
        Optional<Student> stu = studentRepository.findById(StudentId);
        if(stu.isEmpty()){
            log.info("Student not found", StudentId);
            return null;
        }
        Student student = stu.get();
        student.setStudentName(studentDTO.getStudentName());
        student.setStudentGender(studentDTO.getStudentGender());
        student.setStudentDOB(studentDTO.getStudentDOB());
        student.setClassName(studentDTO.getClassName());
        studentRepository.save(student);
        StudentDTO studentDTO1 = new StudentDTO();
        studentDTO1.setStudentName(stu.get().getStudentName());
        studentDTO1.setStudentGender(stu.get().getStudentGender());
        studentDTO1.setStudentDOB(stu.get().getStudentDOB());
        studentDTO1.setClassName(stu.get().getClassName());
        return studentDTO1;
    }


    @Override
    public void DeleteStudent(Long StudentId) {
        studentRepository.deleteById(StudentId);
    }

    @Override
    public StudentDTO getStudent(Long StudentId) {
        StudentDTO studentDTO = new StudentDTO();
        Optional<Student> stu = studentRepository.findById(StudentId);
        if(stu.isEmpty()){
            log.info("Student {} not  found", StudentId);
            return null;
        }
        studentDTO.setStudenId(stu.get().getStudentId());
        studentDTO.setStudentName(stu.get().getStudentName());
        studentDTO.setStudentGender(stu.get().getStudentGender());
        studentDTO.setStudentDOB(stu.get().getStudentDOB());
        studentDTO.setClassName(stu.get().getClassName());
        return studentDTO;
    }

    @Override
    public List<StudentDTO> getAllStudents() {
        List<StudentDTO> studentDTOList = new ArrayList<>();
        List<Student> students = studentRepository.findAll();
        if (students.isEmpty()) {
            log.info("No students found");
            return null;
        }
        for (Student student : students) {
            StudentDTO studentDTO = new StudentDTO();
            studentDTO.setStudenId(student.getStudentId());
            studentDTO.setStudentName(student.getStudentName());
            studentDTO.setStudentGender(student.getStudentGender());
            studentDTO.setStudentDOB(student.getStudentDOB());
            studentDTO.setClassName(student.getClassName());
            studentDTOList.add(studentDTO);
        }
        return studentDTOList;
    }
}

package com.systemSchool.School.api.Service;

import com.systemSchool.School.api.DTO.StudentDTO;

import java.util.List;

public interface StudentService {
    void newStudent(StudentDTO student);
    void updateStudent(StudentDTO student,Long id);
    void deleteStudent(Long id);
    StudentDTO getStudent(Long id);
    List<StudentDTO> getAllStudents();
}

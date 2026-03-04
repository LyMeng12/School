package com.systemSchool.School.api.Service;

import com.systemSchool.School.api.DTO.ClassDTO;
import com.systemSchool.School.api.DTO.StudentDTO;

import java.util.List;
import java.util.Optional;

public interface StudentService {

    Optional<StudentDTO> addClass(Long studentId, Long classId);

    StudentDTO deleteClass(Long studentId);
    void newStudent(StudentDTO student);
    void updateStudent(StudentDTO student,Long id);
    StudentDTO deleteStudent(Long id);
    StudentDTO getStudent(Long id);
    List<StudentDTO> getAllStudents();
}

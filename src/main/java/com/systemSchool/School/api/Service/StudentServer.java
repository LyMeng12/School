package com.systemSchool.School.api.Service;

import com.systemSchool.School.api.dto.StudentDTO;

import java.util.List;

public interface StudentServer {
    void NewStudent(StudentDTO studentDTO);
    StudentDTO UpdateStudent(Long StudentId, StudentDTO studentDTO);

    void DeleteStudent(Long StudentId);
    StudentDTO getStudent(Long StudentId);
    List<StudentDTO> getAllStudents();

}

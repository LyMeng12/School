package com.systemSchool.School.api.Service;


import com.systemSchool.School.api.DTO.StudentDTO.StudentRequest;
import com.systemSchool.School.api.DTO.StudentDTO.StudentResponse;

import java.util.List;

public interface StudentService {
    void newStudent(StudentRequest studentRequest);
    void updateStudent(Long id,StudentRequest studentRequest);
    void deleteStudent(Long id);
    StudentResponse getStudent(Long id);
    List<StudentResponse> getStudents();
}

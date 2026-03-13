package com.systemSchool.School.api.Service;


import com.systemSchool.School.api.DTO.ClassDTO.ClassRequest;
import com.systemSchool.School.api.DTO.ClassDTO.ClassResponse;
import com.systemSchool.School.api.DTO.StudentDTO.StudentRequest;
import com.systemSchool.School.api.DTO.TeacherDTO.TeacherRequest;
import com.systemSchool.School.api.Model.ClassAPI;

import java.util.List;
import java.util.Optional;

public interface ClassService {
    void newClass(ClassRequest classRequest);
    void updateClass(Long id, ClassRequest classRequest);
    void deleteClass(Long id);
    ClassResponse getClassById(Long id);
    List<ClassResponse> getAllClasses();
    ClassResponse getClassByName(String className);

    // Student
    ClassResponse addStudetIntoClass(Long classId, List<StudentRequest> studentRequests);
    ClassResponse removeStudentIntoClass(Long classId, List<StudentRequest> studentRequests);

    // Teacher
    ClassResponse addTeacherIntoClass(Long classId, List<TeacherRequest> teacherRequests);
    ClassResponse removeTeacherIntoClass(Long classId, List<TeacherRequest> teacherRequests);
}

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

//    student
    ClassResponse getClassByStudentName(String StudentName);
    void addStudentIntoClass(Long classId,StudentRequest studentRequest);
    void deleteStudentFromClass(Long classId, String StudentName);
    void updateStudentInClass(Long classId,String StudentName, StudentRequest studentRequest);

//    teacher
ClassResponse getClassByTeacherName(String TeacherName);
    void addStudentIntoClass(Long classId, TeacherRequest teacherRequest);
    void deleteTeacherFromClass(Long classId, String TeacherName);
    void updateTeacherInClass(Long classId,String TeacherName, TeacherRequest teacherRequest);
}

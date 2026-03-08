package com.systemSchool.School.api.Service;


import com.systemSchool.School.api.DTO.TeacherDTO.TeacherRequest;
import com.systemSchool.School.api.DTO.TeacherDTO.TeacherResponse;

import java.util.List;

public interface TeacherService {
    void newTeacher(TeacherRequest teacherRequest);
    void updateTeacher(Long Id,TeacherRequest teacherRequest);
    void deleteTeacher(Long Id);
    TeacherResponse getTeacherById(Long Id);
    List<TeacherResponse> getAllTeachers();
}

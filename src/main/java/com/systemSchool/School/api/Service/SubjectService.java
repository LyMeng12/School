package com.systemSchool.School.api.Service;

import com.systemSchool.School.api.DTO.SubjectDTO;
import com.systemSchool.School.api.DTO.TeacherDTO;

import javax.security.auth.Subject;
import java.util.List;

public interface SubjectService {
    SubjectDTO AddTeacher(List<Long> teacherId, Long subjectId);
    void addSubject(SubjectDTO subjectDTO);
    SubjectDTO deleteSubject(Long subjectId);
    void updateSubject(SubjectDTO subjectDTO,Long id);
    SubjectDTO getSubjectById(Long id);
    List<SubjectDTO> getAllSubjects();
}

package com.systemSchool.School.api.Service;

import com.systemSchool.School.api.DTO.SubjectDTO;

import javax.security.auth.Subject;
import java.util.List;

public interface SubjectService {
    void addSubject(SubjectDTO subjectDTO);
    void deleteSubject(SubjectDTO subjectDTO);
    void updateSubject(SubjectDTO subjectDTO,Long id);
    SubjectDTO getSubjectById(Long id);
    List<SubjectDTO> getAllSubjects();
}

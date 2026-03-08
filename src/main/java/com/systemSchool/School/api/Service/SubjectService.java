package com.systemSchool.School.api.Service;


import com.systemSchool.School.api.DTO.SubjectDTO.SubjectRequest;
import com.systemSchool.School.api.DTO.SubjectDTO.SubjectResponse;

import javax.security.auth.Subject;
import java.util.List;

public interface SubjectService {
    void saveSubject(SubjectRequest subjectRequest);
    void updateSubject(Long id,SubjectRequest subjectRequest);
    void deleteSubject(Long id);
    SubjectResponse getSubject(Long id);
    List<SubjectResponse> getAllSubjects();
}

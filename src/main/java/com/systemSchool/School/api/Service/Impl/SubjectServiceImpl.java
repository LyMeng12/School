package com.systemSchool.School.api.Service.Impl;

import com.systemSchool.School.api.DTO.SubjectDTO.SubjectRequest;
import com.systemSchool.School.api.DTO.SubjectDTO.SubjectResponse;
import com.systemSchool.School.api.Repository.SubjectRepository;
import com.systemSchool.School.api.Service.SubjectService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SubjectServiceImpl implements SubjectService {
    private final SubjectRepository subjectRepository;

    public SubjectServiceImpl(SubjectRepository subjectRepository) {
        this.subjectRepository = subjectRepository;
    }


    @Override
    public void saveSubject(SubjectRequest subjectRequest) {

    }

    @Override
    public void updateSubject(Long id, SubjectRequest subjectRequest) {

    }

    @Override
    public void deleteSubject(Long id) {

    }

    @Override
    public SubjectResponse getSubject(Long id) {
        return null;
    }

    @Override
    public List<SubjectResponse> getAllSubjects() {
        return List.of();
    }
}

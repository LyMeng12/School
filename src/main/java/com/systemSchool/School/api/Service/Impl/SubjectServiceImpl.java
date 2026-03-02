package com.systemSchool.School.api.Service.Impl;

import com.systemSchool.School.api.DTO.SubjectDTO;
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
    public void addSubject(SubjectDTO subjectDTO) {

    }

    @Override
    public void deleteSubject(SubjectDTO subjectDTO) {

    }

    @Override
    public void updateSubject(SubjectDTO subjectDTO, Long id) {

    }

    @Override
    public SubjectDTO getSubjectById(Long id) {
        return null;
    }

    @Override
    public List<SubjectDTO> getAllSubjects() {
        return List.of();
    }
}

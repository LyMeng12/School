package com.systemSchool.School.api.Service.Impl;

import com.systemSchool.School.api.DTO.SubjectDTO;
import com.systemSchool.School.api.Entitty.Subject;
import com.systemSchool.School.api.Repository.SubjectRepository;
import com.systemSchool.School.api.Service.StudentService;
import com.systemSchool.School.api.Service.SubjectService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SubjectServiceIpml implements SubjectService {

    private final SubjectRepository subjectRepository;

    public SubjectServiceIpml(SubjectRepository subjectRepository) {
        this.subjectRepository = subjectRepository;
    }

    @Override
    public void create(SubjectDTO subjectDTO) {
        Subject subject = new Subject();
        subject.setSubjectName(subjectDTO.getSubjectName());
        subjectRepository.save(subject);
    }

    @Override
    public void update(SubjectDTO subjectDTO, Long id) {

    }

    @Override
    public SubjectDTO delete(Long id) {
        return null;
    }

    @Override
    public List<SubjectDTO> findAll() {
        return List.of();
    }
}

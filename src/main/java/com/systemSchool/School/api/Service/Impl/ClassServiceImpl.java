package com.systemSchool.School.api.Service.Impl;

import com.systemSchool.School.api.DTO.ClassDTO;
import com.systemSchool.School.api.Repository.ClassRepository;
import com.systemSchool.School.api.Service.ClassService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ClassServiceImpl implements ClassService {

    private final ClassRepository classRepository;

    public ClassServiceImpl(ClassRepository classRepository) {
        this.classRepository = classRepository;
    }


    @Override
    public void newClass(ClassDTO Class) {

    }

    @Override
    public void updateClass(ClassDTO Class, Long id) {

    }

    @Override
    public void deleteClass(Long id) {

    }

    @Override
    public ClassDTO getClass(Long id) {
        return null;
    }

    @Override
    public List<ClassDTO> getAllClass_s() {
        return List.of();
    }
}

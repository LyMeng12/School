package com.systemSchool.School.api.Service.Impl;

import com.systemSchool.School.api.DTO.ClassDTO;
import com.systemSchool.School.api.Entitty.ClassAPI;
import com.systemSchool.School.api.Repository.ClassAPIRepository;
import com.systemSchool.School.api.Service.ClassService;
import com.systemSchool.School.api.Service.StudentService;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class ClassServiceIpml implements ClassService {
    private final ClassAPIRepository classAPIRepository;

    public ClassServiceIpml(ClassAPIRepository classAPIRepository) {
        this.classAPIRepository = classAPIRepository;
    }


    @Override
    public void create(ClassDTO classDTO) {
        ClassAPI classAPI = new ClassAPI();
        classAPI.setClassName(classDTO.getClassName());
        classAPI.setRoomNumber(classDTO.getRoomNumber());
        classAPIRepository.save(classAPI);
    }

    @Override
    public void update(ClassDTO classDTO, Long id) {

    }

    @Override
    public ClassDTO delete(Long id) {
        return null;
    }

    @Override
    public List<ClassDTO> findAll() {
        return List.of();
    }
}

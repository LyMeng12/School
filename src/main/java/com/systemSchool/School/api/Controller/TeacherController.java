package com.systemSchool.School.api.Controller;

import com.systemSchool.School.api.DTO.TeacherDTO;
import com.systemSchool.School.api.Service.TeacherService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
public class TeacherController {

    private TeacherService teacherService;

    @Autowired
    public TeacherController(TeacherService teacherService) {
        this.teacherService = teacherService;
    }


    @PostMapping("/teacher/post")
    public ResponseEntity<Object> createTeacher(@RequestBody TeacherDTO teacherDTO) {
        teacherService.newTeacher(teacherDTO);
        log.info("Teacher created", teacherDTO);
        return ResponseEntity.accepted().build();
    }
}

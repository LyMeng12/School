package com.systemSchool.School.api.Controller;

import com.systemSchool.School.api.Entity.Teacher;
import com.systemSchool.School.api.Service.TeacherService;
import com.systemSchool.School.api.dto.TeacherDTO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@RequestMapping("/teacher")
public class TeacherController {
    private TeacherService teacherService;

    @Autowired
    public TeacherController(TeacherService teacherService) {
        this.teacherService = teacherService;
    }
    @PostMapping("/post")
    public ResponseEntity<Object> postTeacher(@RequestBody TeacherDTO teacher) {
        log.info("Post Teacher : {}", teacher);
        teacherService.createTeacher(teacher);
        return ResponseEntity.ok().build();
    }

}

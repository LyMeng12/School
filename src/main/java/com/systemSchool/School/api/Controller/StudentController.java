package com.systemSchool.School.api.Controller;

import com.systemSchool.School.api.DTO.StudentDTO;
import com.systemSchool.School.api.Entitty.Student;
import com.systemSchool.School.api.Service.StudentService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
public class StudentController {
    private StudentService studentService;

    @Autowired
    public StudentController(StudentService studentService) {
        this.studentService = studentService;
    }

    @PostMapping("/student/post")
    public ResponseEntity<Object> addStudent(@RequestBody StudentDTO studentDTO) {
        log.info("Add student {}", studentDTO);
        studentService.create(studentDTO);
        return ResponseEntity.ok().build();
    }
}

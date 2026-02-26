package com.systemSchool.School.api.Controller;

import com.systemSchool.School.api.Entity.Student;
import com.systemSchool.School.api.Service.StudentServer;
import com.systemSchool.School.api.dto.StudentDTO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
public class Controller {
    @Autowired
    private StudentServer studentServer;




    @PostMapping("/student/post")
    public StudentEntity<Object> NewStudent(@RequestBody StudentDTO newStudent){
        log.info("New student created: {}",newStudent);
        studentServer.NewStudent(newStudent);
        return StudentEntity.;

    }
}

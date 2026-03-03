package com.systemSchool.School.api.Controller;

import com.systemSchool.School.api.DTO.ClassDTO;
import com.systemSchool.School.api.Service.ClassService;
import com.systemSchool.School.api.Service.StudentService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
public class ClassController {

    private ClassService classServices;

    @Autowired
    public ClassController(ClassService classService) {
        this.classServices=classService;
    }

    @PostMapping("/class/post")
    public ResponseEntity<Object> postClass(@RequestBody ClassDTO classDTO) {
        classServices.newClass(classDTO);
        log.info("New class created", classDTO);
        return ResponseEntity.accepted().build();
    }

}

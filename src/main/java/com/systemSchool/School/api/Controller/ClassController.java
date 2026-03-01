package com.systemSchool.School.api.Controller;

import com.systemSchool.School.api.DTO.ClassDTO;
import com.systemSchool.School.api.Service.ClassService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
public class ClassController {
    private ClassService classService;

    @Autowired
    public ClassController(ClassService classService) {
        this.classService = classService;
    }

    @PostMapping("/class/post")
    public ResponseEntity<Object> postClass(@RequestBody ClassDTO classDTO) {
        log.info("ClassDTO: {}", classDTO);
        classService.create(classDTO);
        return ResponseEntity.ok().build();
    }
}

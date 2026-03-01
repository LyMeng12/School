package com.systemSchool.School.api.Controller;

import com.systemSchool.School.api.DTO.SubjectDTO;
import com.systemSchool.School.api.Service.SubjectService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
public class SubjectController {
    private SubjectService subjectService;

    @Autowired
    public SubjectController(SubjectService subjectService) {
        this.subjectService = subjectService;
    }

    @PostMapping("/subject/post")
    public ResponseEntity<Object> postSubject(@RequestBody SubjectDTO subjectDTO) {
        log.info("POST subject", subjectDTO);
        subjectService.create(subjectDTO);
        return ResponseEntity.ok().build();
    }
}

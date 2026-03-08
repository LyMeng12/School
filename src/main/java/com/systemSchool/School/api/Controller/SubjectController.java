package com.systemSchool.School.api.Controller;

import com.systemSchool.School.api.DTO.SubjectDTO.SubjectRequest;
import com.systemSchool.School.api.DTO.SubjectDTO.SubjectResponse;
import com.systemSchool.School.api.Service.SubjectService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@RestController
public class SubjectController {

    private SubjectService subjectService;

    @Autowired
    public SubjectController(SubjectService subjectService) {
        this.subjectService = subjectService;
    }

    @GetMapping("/subject/{id}")
    public ResponseEntity<SubjectResponse> getSubject(@PathVariable Long id) {
        return ResponseEntity.ok(subjectService.getSubject(id));
    }

    @GetMapping("/subject")
    public ResponseEntity<List<SubjectResponse>> getAllSubjects() {
        return ResponseEntity.ok(subjectService.getAllSubjects());
    }

    @DeleteMapping("/subject/{id}")
    public ResponseEntity<SubjectResponse> deleteSubject(@PathVariable Long id) {
        SubjectResponse subject = subjectService.getSubject(id);
        if (subject != null) {
            subjectService.deleteSubject(id);
            log.info("Subject deleted successfully");
            return ResponseEntity.ok(subject);
        }
        log.error("Subject not found",id);
        return ResponseEntity.notFound().build();
    }

    @PostMapping("/subject/post")
    public ResponseEntity<SubjectResponse> newSubject(@RequestBody SubjectRequest subjectRequest) {
        subjectService.saveSubject(subjectRequest);
        log.info("Subject created successfully");

        return ResponseEntity.ok().build();
    }

    @PutMapping("/subject/{id}")
    public ResponseEntity<SubjectResponse> updateSubject(@PathVariable Long id, @RequestBody SubjectRequest subjectRequest) {
        SubjectResponse subject = subjectService.getSubject(id);
        if (subject != null) {
            subjectService.updateSubject(id, subjectRequest);
            log.info("Subject updated successfully");
            return ResponseEntity.ok(subject);
        }
        log.error("Subject not found",id);
        return ResponseEntity.notFound().build();
    }


}

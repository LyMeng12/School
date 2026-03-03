package com.systemSchool.School.api.Controller;

import com.systemSchool.School.api.DTO.SubjectDTO;
import com.systemSchool.School.api.Service.SubjectService;
import com.systemSchool.School.api.Service.TeacherService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.security.auth.Subject;
import java.util.List;
import java.util.Optional;

@Slf4j
@RestController
public class SubjectController {

    private SubjectService subjectService;

    @Autowired
    public SubjectController(SubjectService subjectService, TeacherService teacherService)
    {
        this.subjectService = subjectService;
    }
    @PutMapping("/subjec/{subjectId}/teacher/{teacherId}")
    public ResponseEntity<Object> addTeacher(@PathVariable Long subjectId, @PathVariable List<Long> teacherId){
        subjectService.AddTeacher(teacherId,subjectId);
        return null;
    }


    @PostMapping("/subject/post")
    public ResponseEntity<Object> createSubject(@RequestBody SubjectDTO subject){
        subjectService.addSubject(subject);
        log.info("Create Subject", subject);
        return ResponseEntity.ok().body(subject);
    }

    @GetMapping("/subject/{id}")
    public ResponseEntity<SubjectDTO> getSubject(@PathVariable Long id){
        SubjectDTO stu = subjectService.getSubjectById(id);
        if (stu != null) {
            log.info("Get Subject", stu);
            return ResponseEntity.ok().body(stu);
        }
        return ResponseEntity.notFound().build();
    }

    @DeleteMapping("/subject/delete/{id}")
    public ResponseEntity<Object> deleteSubject(@PathVariable Long id){
        subjectService.deleteSubject(id);
        if (subjectService.getSubjectById(id) != null) {
            log.info("Delete Subject", subjectService.getSubjectById(id));
        }
        return ResponseEntity.notFound().build();
    }
}

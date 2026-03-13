package com.systemSchool.School.api.Controller;

import com.systemSchool.School.api.DTO.ClassDTO.ClassRequest;
import com.systemSchool.School.api.DTO.ClassDTO.ClassResponse;
import com.systemSchool.School.api.DTO.StudentDTO.StudentRequest;
import com.systemSchool.School.api.DTO.StudentDTO.StudentResponse;
import com.systemSchool.School.api.Model.ClassAPI;
import com.systemSchool.School.api.Service.ClassService;
import com.systemSchool.School.api.Service.StudentService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@Slf4j
@RestController
public class ClassController {

    private ClassService classService;
    private StudentService studentService;

    @Autowired
    public ClassController(ClassService classService, StudentService studentService) {
        this.classService = classService;
        this.studentService = studentService;
    }

    @GetMapping("/class")
    public ResponseEntity<List<ClassResponse>> getAllClasses() {
        return ResponseEntity.ok().body(classService.getAllClasses());
    }
    @GetMapping("/class/{id}")
    public ResponseEntity<ClassResponse> getClassById(@PathVariable Long id) {
        ClassResponse classResponse = classService.getClassById(id);
        return ResponseEntity.ok().body(classResponse);
    }

    @GetMapping("/class/{className}")
    public ResponseEntity<ClassResponse> getClassByName(@PathVariable String className) {
        ClassResponse classResponse = classService.getClassByName(className);
        if (classResponse != null) {
            log.info("Class " + className + " found");
            return ResponseEntity.ok().body(classResponse);
        }
        log.info("Class " + className + " not found");
        return ResponseEntity.notFound().build();
    }

    @PostMapping("/class/post")
    public ResponseEntity<ClassResponse> postClass(@RequestBody ClassRequest classRequest) {
        classService.newClass(classRequest);
        log.info("New class created", classRequest);
        return ResponseEntity.ok().build();
    }
    @DeleteMapping("/class/{id}")
    public ResponseEntity<?> deleteClass(@PathVariable Long id) {
        ClassResponse classResponse = classService.getClassById(id);

        if (classResponse!=null) {
            classService.deleteClass(id);
            return ResponseEntity.ok().build();
        }
        return ResponseEntity.notFound().build();

    }
    @PutMapping("/class/{id}")
    public ResponseEntity<ClassResponse> updateClass(@PathVariable Long id, @RequestBody ClassRequest classRequest) {
        ClassResponse classResponse = classService.getClassById(id);
        if (classResponse!=null) {
            classService.updateClass(id, classRequest);
            log.info("Class updated", classRequest);
            return ResponseEntity.ok().build();
        }
        return ResponseEntity.notFound().build();
    }

    @PostMapping("/class/{classId}/student/")
    public ResponseEntity<ClassResponse> addStudent(@PathVariable Long classId, @RequestBody List<StudentRequest> studentRequest) {
        ClassResponse classResponse = classService.getClassById(classId);
        if (classResponse!=null) {
            classService.addStudetIntoClass(classId, studentRequest);
            log.info("Student added", studentRequest);
            return ResponseEntity.ok().body(classResponse);
        }
        log.error("Class " + classId + " not found");
        return ResponseEntity.notFound().build();
    }
    @DeleteMapping("/class/{classId}/student/")
    public ResponseEntity<ClassResponse> deleteStudent(@PathVariable Long classId, @RequestBody List<StudentRequest> studentRequest) {
        ClassResponse classResponse = classService.getClassById(classId);
        if (classResponse!=null) {
            classService.removeStudentIntoClass(classId, studentRequest);
            log.info("Student removed", studentRequest);
            return ResponseEntity.ok().body(classResponse);
        }
        log.error("Class " + classId + " not found");
        return ResponseEntity.notFound().build();
    }

}

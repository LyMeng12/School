package com.systemSchool.School.api.Controller;

import com.systemSchool.School.api.DTO.StudentDTO.StudentRequest;
import com.systemSchool.School.api.DTO.StudentDTO.StudentResponse;
import com.systemSchool.School.api.Service.StudentService;
import lombok.Getter;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@Slf4j
@RestController
public class StudentController {

    private StudentService studentService;

    @Autowired
    public StudentController(StudentService studentService) {
        this.studentService = studentService;
    }

    @GetMapping("/student/{id}")
    public ResponseEntity<StudentResponse> getStudent(@PathVariable Long id) {
        StudentResponse studentResponse = studentService.getStudent(id);
        if (studentResponse != null) {
            return ResponseEntity.ok().body(studentResponse);
        }
        return ResponseEntity.notFound().build();
    }
    @GetMapping("/student")
    public ResponseEntity<List<StudentResponse>> getAllStudents() {
        return ResponseEntity.ok().body(studentService.getStudents());
    }
    @PutMapping("/student/{id}")
    public ResponseEntity<StudentRequest> updateStudent(@PathVariable Long id, @RequestBody StudentRequest studentRequest) {
        StudentResponse classresponse = studentService.getStudent(id);
        if (classresponse != null) {
            studentService.updateStudent(id, studentRequest);
            return ResponseEntity.ok().body(studentRequest);
        }
        log.error("Id Not found: " + id);
        return ResponseEntity.noContent().build();
    }
    @DeleteMapping("/student/{id}")
    public ResponseEntity<StudentResponse> deleteStudent(@PathVariable Long id) {
        StudentResponse studentResponse = studentService.getStudent(id);
        if (studentResponse != null) {
            studentService.deleteStudent(id);
            return ResponseEntity.ok().body(studentResponse);
        }
        log.error("Id Not found: " + id);
        return ResponseEntity.noContent().build();
    }
    @PostMapping("/student/post")
    public ResponseEntity<StudentResponse> postStudent(@RequestBody StudentRequest studentRequest) {
        StudentResponse studentResponse= studentService.newStudent(studentRequest);
        return ResponseEntity.ok().body(studentResponse);
    }


}

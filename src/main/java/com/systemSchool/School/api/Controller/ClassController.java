package com.systemSchool.School.api.Controller;

import com.systemSchool.School.api.DTO.ClassDTO.ClassRequest;
import com.systemSchool.School.api.DTO.ClassDTO.ClassResponse;
import com.systemSchool.School.api.Model.ClassAPI;
import com.systemSchool.School.api.Service.ClassService;
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

    @Autowired
    public ClassController(ClassService classService) {
        this.classService = classService;
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

}

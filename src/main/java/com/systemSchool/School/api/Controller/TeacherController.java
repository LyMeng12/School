package com.systemSchool.School.api.Controller;

import com.systemSchool.School.api.Entity.Teacher;
import com.systemSchool.School.api.Service.TeacherService;
import com.systemSchool.School.api.dto.TeacherDTO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@RestController
@RequestMapping("/teacher")
public class TeacherController {
    private TeacherService teacherService;

    @Autowired
    public TeacherController(TeacherService teacherService) {
        this.teacherService = teacherService;
    }
    @PostMapping("/post")
    public ResponseEntity<Object> postTeacher(@RequestBody TeacherDTO teacher) {
        log.info("Post Teacher : {}", teacher);
        teacherService.createTeacher(teacher);
        return ResponseEntity.ok().build();
    }
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Object> deleteTeacher(@PathVariable Long id) {
        teacherService.deleteTeacher(id);
        if(teacherService.getAllTeachers().isEmpty()){
            return ResponseEntity.ok().build();
        }
        return ResponseEntity.ok().build();
    }

    @PutMapping("/put/{id}")
    public ResponseEntity<Object> putTeacher(@RequestBody TeacherDTO teacher,@PathVariable Long id) {
        log.info("Put Teacher : {}", teacher);
        teacherService.updateTeacher(teacher, id);
        if (teacherService==null) {
            return ResponseEntity.ok().build();
        }
        return ResponseEntity.ok().build();

    }

    @GetMapping("/get/{id}")
    public ResponseEntity<Object> getTeacher(@PathVariable Long id) {
        log.info("Get Teacher : {}", id);
        TeacherDTO teacher = teacherService.getTeacherById(id);
        if (teacher==null) {
            return ResponseEntity.ok().build();
        }
        return ResponseEntity.ok().body(teacher);
    }

    @GetMapping("/get")
    public ResponseEntity<Object> getTeacher() {
        log.info("Get Teacher");
        List<TeacherDTO> teacher=teacherService.getAllTeachers();
        return ResponseEntity.ok().body(teacher);
    }
}

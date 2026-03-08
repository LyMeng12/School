package com.systemSchool.School.api.Controller;

import com.systemSchool.School.api.DTO.TeacherDTO.TeacherRequest;
import com.systemSchool.School.api.DTO.TeacherDTO.TeacherResponse;
import com.systemSchool.School.api.Service.TeacherService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@Slf4j
@RestController
public class TeacherController {
    private TeacherService teacherService;

    @Autowired
    public TeacherController(TeacherService teacherService) {
        this.teacherService = teacherService;
    }

    @GetMapping("/teacher")
    public ResponseEntity<List<TeacherResponse>> getTeacher(){
        return ResponseEntity.ok().body(teacherService.getAllTeachers());
    }

    @GetMapping("/teacher/{id}")
    public ResponseEntity<TeacherResponse> getTeacherById(@PathVariable Long id){
        return ResponseEntity.ok().body(teacherService.getTeacherById(id));
    }

    @DeleteMapping("/teacher/{id}")
    public ResponseEntity<TeacherResponse> deleteTeacherById(@PathVariable Long id){
        TeacherResponse teacherResponse = teacherService.getTeacherById(id);
        if(teacherResponse != null) {
            teacherService.deleteTeacher(id);
            log.info("Teacher with id {} was deleted", id);
            return ResponseEntity.ok().body(teacherResponse);
        }
        return ResponseEntity.notFound().build();
    }

    @PutMapping("/teacher/{id}")
    public ResponseEntity<TeacherResponse> updateTeacher(@PathVariable Long id, @RequestBody TeacherRequest teacherRequest){
        TeacherResponse teacherResponse = teacherService.getTeacherById(id);
        if(teacherResponse != null) {
            teacherService.updateTeacher(id, teacherRequest);
            log.info("Teacher with id {} was updated", id);
            return ResponseEntity.ok().build();
        }
        return ResponseEntity.notFound().build();
    }



}

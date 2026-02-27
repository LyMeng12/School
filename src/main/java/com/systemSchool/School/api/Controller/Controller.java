package com.systemSchool.School.api.Controller;

import com.systemSchool.School.api.Entity.Student;
import com.systemSchool.School.api.Service.StudentServer;
import com.systemSchool.School.api.dto.StudentDTO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@RestController
@RequestMapping("/student")
public class Controller {
    @Autowired
    private StudentServer studentServer;




    @PostMapping("/post")
    public ResponseEntity<Object> NewStudent(@RequestBody StudentDTO newStudent){
        log.info("New student created: {}",newStudent);
        studentServer.NewStudent(newStudent);
        return ResponseEntity.ok().build();
    }
    @PutMapping("/put/{id}")
    public ResponseEntity<Object> UpdateStudent(@RequestBody StudentDTO newStudent,@PathVariable String id){
        log.info("Update student created: {}",newStudent);
        studentServer.UpdateStudent(Long.parseLong(id),newStudent);
        if(studentServer == null){
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok().build();
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Object> DeleteStudent(@PathVariable String id){
        log.info("Delete student with id: {}",id);
        studentServer.DeleteStudent(Long.parseLong(id));
        return ResponseEntity.ok().build();
    }

    @GetMapping("/get/{id}")
    public ResponseEntity<Object> getStudent(@PathVariable Long id){
        log.info("Get student by id: {}",id);
        StudentDTO studentDTO = studentServer.getStudent(id);
        if(studentDTO == null){
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok().body(studentDTO);
    }

    @GetMapping("/get")
    public ResponseEntity<Object> getStudent(){
        log.info("Get student");
        List<StudentDTO>studentDTOS=studentServer.getAllStudents();
        return ResponseEntity.ok().body(studentDTOS);
    }
}

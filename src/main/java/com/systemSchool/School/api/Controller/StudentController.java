package com.systemSchool.School.api.Controller;

import com.systemSchool.School.api.DTO.StudentDTO;
import com.systemSchool.School.api.Service.StudentService;
import lombok.Getter;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
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
    @PutMapping("/Student/{studentId}/class/{classId}")
    public ResponseEntity<StudentDTO> updateStudent(@PathVariable Long studentId,@PathVariable Long classId){
        Optional<StudentDTO> stu = studentService.addClass(studentId,classId);
        if(stu==null){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return ResponseEntity.ok(stu.get());
    }

    @PostMapping("/student/post")
    public ResponseEntity<Object> createStudent(@RequestBody StudentDTO student){
        log.info("Create Student", student);
        studentService.newStudent(student);
        return ResponseEntity.ok().build();
    }
    @PutMapping("/student/put/{id}")
    public ResponseEntity<Object> putStudent(@PathVariable Long id, @RequestBody StudentDTO student){
        StudentDTO studentDTO = studentService.getStudent(id);
        if(studentDTO == null){
            log.info("Student not found", id);
            return ResponseEntity.notFound().build();
        }
        studentService.updateStudent(student, id);
        return ResponseEntity.ok().build();
    }

    @DeleteMapping("/student/delete/{id}")
    public ResponseEntity<Object> deleteStudent(@PathVariable Long id){
        StudentDTO stu = studentService.deleteStudent(id);
        if(stu == null){
            log.error("Delete Student", id);
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok().body(stu);
    }

    @GetMapping("/student/{id}")
    public ResponseEntity<StudentDTO> getStudent(@PathVariable Long id){
        StudentDTO stu=studentService.getStudent(id);
        if(stu==null){
            return ResponseEntity.notFound().build();
        }
        log.info("Get Student", id);
        return ResponseEntity.ok().body(stu);
    }

    @GetMapping("/student")
    public ResponseEntity<List<StudentDTO>> getAllStudents(){
        log.info("Get All Students");
        List<StudentDTO> students = studentService.getAllStudents();
        return ResponseEntity.ok().body(students);
    }

}

package com.systemSchool.School.api.Model;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.List;

@Getter
@Setter
@ToString
@Entity
@Table(name="TeacherAPI")
public class TeacherAPI {

    @Id

    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long teacherId;
    private String teacherName;

    private Double salary;
    @OneToMany(mappedBy = "teacher")
    private List<SubjectAPI> subjects;


    @ManyToMany(mappedBy = "teacherAPI")
    private List<ClassAPI> classes;
    @OneToMany(mappedBy = "TeacherAPI",cascade = CascadeType.ALL)
    @JsonManagedReference
    private List<StudentAPI> students;




}

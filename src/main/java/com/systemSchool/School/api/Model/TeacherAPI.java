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
    private Long teacherId;
    private String teacherName;
    private String teacherSubject;
    private Double salary;

    @ManyToMany
    @JoinTable(
            name = "teacher_class",
            joinColumns = @JoinColumn(name = "teacher_id"),
            inverseJoinColumns = @JoinColumn(name = "class_id")
    )
    private List<ClassAPI> classes;
    @OneToMany(mappedBy = "studentAPI",cascade = CascadeType.ALL)
    @JsonManagedReference
    private List<StudentAPI> students;




}

package com.systemSchool.School.api.Model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@Entity
@Table(name="Teacher")
public class TeacherAPI {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long teacherId;
    @Column(unique=true, nullable=false)
    private String teacherName;
    @Column(unique=true, nullable=false)
    private Long teacherAge;
    @Column(unique=true, nullable=false)
    private String teacherGender;
    @Column(unique=true, nullable=false)
    private Double teacherSalary;
    @ManyToOne
    private SubjectAPI subjectAPI;
    @ManyToMany
    private List<ClassAPI> classAPI;
}

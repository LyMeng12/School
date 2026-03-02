package com.systemSchool.School.api.Entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.List;

@Getter
@Setter
@ToString
@Entity
@Table(name="Class")
public class ClassAPI {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long classId;
    @Column(unique=true, nullable=false)
    private String className;
    @Column(unique=true, nullable=false)
    private String classNumber;

    @OneToMany
    private List<StudentAPI> students;

    @ManyToMany
    @JoinTable(name = "class_teacher",joinColumns = @JoinColumn(name = "class_id"),inverseJoinColumns = @JoinColumn(name = "teacher_id"))
    private List<TeacherAPI> teachers;
}

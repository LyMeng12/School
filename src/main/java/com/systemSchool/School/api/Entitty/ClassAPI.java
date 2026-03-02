package com.systemSchool.School.api.Entitty;

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
    private Long classId;
    private String className;
    private String classNumber;

    @OneToMany
    private List<StudentAPI> students;

    @ManyToMany
    @JoinTable(name = "class_teacher",joinColumns = @JoinColumn(name = "class_id"),inverseJoinColumns = @JoinColumn(name = "teacher_id"))
    private List<TeacherAPI> teachers;
}

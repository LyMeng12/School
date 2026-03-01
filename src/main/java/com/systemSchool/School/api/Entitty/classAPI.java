package com.systemSchool.School.api.Entitty;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@ToString
@Entity
@Table(name = "Class")
public class classAPI {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(unique = true, nullable = false)
    private String className;

    @Column(unique = true, nullable = false)
    private String roomNumber;

    @ManyToMany
    @JoinTable(name = "teacher_class", // join table
            joinColumns = @JoinColumn(name = "teacher_id"), // FK to Student
            inverseJoinColumns = @JoinColumn(name = "class_id"))
    private List<teacher> teachers;

    @OneToMany(mappedBy = "students", cascade = CascadeType.ALL)
    private List<student>students;



}

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
@Table(name = "Class")
public class ClassAPI {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(unique = true, nullable = false)
    private String className;

    @Column(unique = true, nullable = false)
    private String roomNumber;

    @ManyToMany
    @JoinTable(name = "teacher_class", // join table
            joinColumns = @JoinColumn(name = "class_id"), // FK to Student
            inverseJoinColumns = @JoinColumn(name = "teacher_id"))
    private List<Teacher> teachers;

    @OneToMany(mappedBy = "classAPI", cascade = CascadeType.ALL)
    private List<Student> students;



}

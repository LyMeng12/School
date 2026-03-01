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
@Table(name="Student")
public class Student {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false,unique = true)
    private String name;

    @Column(nullable = false,unique = true)
    private String gender;

    @Column(nullable = false,unique = true)
    private String dob;

    @Column(nullable = false,unique = true)
    private String email;

    @ManyToOne
    @JoinColumn(name = "class_id") // lowercase, consistent
    private ClassAPI classAPI;

    @ManyToMany
    @JoinTable(
            name = "students_subject", // join table
            joinColumns = @JoinColumn(name = "students_id"), // FK to Student
            inverseJoinColumns = @JoinColumn(name = "subjects_id")
    )
    private List<Subject> subjects;



}


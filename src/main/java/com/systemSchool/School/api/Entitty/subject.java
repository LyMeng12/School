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
@Table(name="Subject")
public class subject {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(length = 50, nullable = false, unique = true)
    private String subjectName;

    @ManyToOne
    @JoinColumn(name = "teacherId")
    private teacher teacher;

    @ManyToMany(mappedBy = "student")
    private List<student> students;

}

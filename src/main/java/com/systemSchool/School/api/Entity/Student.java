package com.systemSchool.School.api.Entity;

import jakarta.persistence.*;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.Date;

@Getter
@Setter
@ToString
@Data
@Entity
@Table(name="student")
public class Student {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long StudentId;
    @Column(name="StudentName",nullable = false)
    private String StudentName;
    @Column(name="StudentGender", nullable=false)
    private String StudentGender;
    @Column(name="DOB", nullable=false)
    @Temporal(TemporalType.DATE)
    private Date StudentDOB;
    @Column(name="Class",nullable = false)
    private String ClassName;
}

package com.systemSchool.School.api.Entity;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name="teacher")
public class Teacher {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Long id;
    @Column(name="teacherName", nullable=false)
    private String teacherName;
    @Column (name="age",nullable=false)
    private Long age;
    @Column (name = "gender", nullable=false)
    private String gender;
    @Column (name = "phoneNumber", nullable=false)
    private String phoneNumber;
    @Column(name="Salary", nullable=false)
    private Double salary;



}

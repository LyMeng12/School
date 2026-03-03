package com.systemSchool.School.api.Entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@Entity
@Table(name="Student")
public class StudentAPI {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long studentId;
    @Column(unique=true, nullable=false)
    private String studentName;
    @Column(unique=true, nullable=false)
    private String gender;
    @Column(unique=true, nullable=false)
    private String dob;
    @Column(unique=true, nullable=false)
    private String email;
    @ManyToOne
    private ClassAPI classId;

}

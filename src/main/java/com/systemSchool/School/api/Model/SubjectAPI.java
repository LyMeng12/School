package com.systemSchool.School.api.Model;

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
public class SubjectAPI {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long subjectId;

    private String subjectName;


    @ManyToOne
    @JoinColumn(name = "teacher_id")
    private TeacherAPI teacher;
}

package com.systemSchool.School.api.Model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@Entity
@Table(name="Subject")
public class SubjectAPI {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long subjectId;
    @Column(unique=true, nullable=false)
    private String subjectName;

    @OneToMany
    private List<TeacherAPI> teacherAPI;
}

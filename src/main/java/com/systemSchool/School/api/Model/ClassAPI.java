package com.systemSchool.School.api.Model;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.List;

@Getter
@Setter
@ToString
@Entity
@Table(name="ClassAPI")
public class ClassAPI {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long classId;
    private String className;
    private String classRoom;

    @OneToMany(mappedBy = "classAPI",cascade = CascadeType.ALL)
    @JsonManagedReference
    private List<StudentAPI> studentAPI;

    @ManyToMany
    @JoinTable(
            name = "class_teacher",
            joinColumns = @JoinColumn(name = "class_id"),
            inverseJoinColumns = @JoinColumn(name = "teacher_id")
    )
    private List<TeacherAPI> teacherAPI;
}

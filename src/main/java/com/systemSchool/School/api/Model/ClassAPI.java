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
    private Long classId;
    private String className;
    private String room;

    @OneToMany(mappedBy = "classAPI",cascade = CascadeType.ALL)
    @JsonManagedReference
    private List<StudentAPI> studentAPI;

    @ManyToMany
    @JoinColumn(name = "classes")
    private List<TeacherAPI> teacherAPI;
}

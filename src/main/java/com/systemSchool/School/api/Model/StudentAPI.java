package com.systemSchool.School.api.Model;


import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@Entity
@Table(name="StudentAPI")
public class StudentAPI {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long studentId;
    private String studentName;
    private String gender;
    private Long age;
    @ManyToOne
    @JoinColumn(name="class_id")
    @JsonBackReference
    private ClassAPI classAPI;


}

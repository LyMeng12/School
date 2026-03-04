package com.systemSchool.School.api.Model;

import com.systemSchool.School.api.DTO.StudentDTO;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@Entity
@Table(name="Student")
public class StudentAPI extends StudentDTO {
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
    @JoinColumn(name = "class_id")
    private ClassAPI classAPI;

}

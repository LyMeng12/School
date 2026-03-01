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
@Table(name="Teacher")
public class teacher {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(unique = true, nullable = false)
    private String name;

    @OneToMany(mappedBy = "teacher",cascade = CascadeType.ALL)
    private List<subject> subjects;

    @ManyToMany(mappedBy = "class")
    private List<classAPI> classapis;


    @Column(unique=true,nullable = false)
    private Double salary;
}

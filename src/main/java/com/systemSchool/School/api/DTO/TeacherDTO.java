package com.systemSchool.School.api.DTO;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.List;

@Setter
@Getter
@ToString
public class TeacherDTO {

    @JsonProperty("TeacherId")
    private Long id;
    @JsonProperty("TeacherName")
    private String name;
    @JsonProperty("Subject")
    private List<SubjectDTO> subjects;
    @JsonProperty("Class")
    private List<ClassDTO> classes;
    @JsonProperty("Salary")
    private Double salary;

}

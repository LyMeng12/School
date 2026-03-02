package com.systemSchool.School.api.DTO;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.systemSchool.School.api.Entity.ClassAPI;
import com.systemSchool.School.api.Entity.SubjectAPI;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.List;

@Getter
@Setter
@ToString
public class TeacherDTO {
    @JsonProperty("teacher_id")
    private Long teacherId;
    @JsonProperty("teacher_name")
    private String teacherName;
    @JsonProperty("teacher_age")
    private Integer teacherAge;
    @JsonProperty("teacher_gender")
    private String teacherGender;
    @JsonProperty("teacher_salary")
    private Double teacherSalary;
    @JsonProperty("teacher_subject")
    private SubjectAPI subjectAPI;
    @JsonProperty("teacher_class")
    private List<ClassDTO> classDTOs;
}

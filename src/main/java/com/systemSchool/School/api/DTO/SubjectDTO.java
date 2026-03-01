package com.systemSchool.School.api.DTO;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.systemSchool.School.api.Entitty.Student;
import com.systemSchool.School.api.Entitty.Teacher;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.List;

@Setter
@Getter
@ToString
public class SubjectDTO {

    @JsonProperty("Id")
    private Long id;
    @JsonProperty("SubjectName")
    private String subjectName;
    @JsonProperty("TeacherName")
    private Teacher teacher;
    @JsonProperty("Student")
    private List<Student> students;

}

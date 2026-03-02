package com.systemSchool.School.api.DTO;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.List;

@Getter
@Setter
@ToString
public class ClassDTO {
    @JsonProperty("class_id")
    private Long classId;
    @JsonProperty("class_name")
    private String className;
    @JsonProperty("class_number")
    private String classNumber;
    @JsonProperty("student_name")
    private List<StudentDTO> studentDTOs;
    @JsonProperty("teacher_name")
    private List<TeacherDTO> teacherDTOs;
}

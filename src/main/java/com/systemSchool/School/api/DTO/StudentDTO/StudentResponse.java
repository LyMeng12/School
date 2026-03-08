package com.systemSchool.School.api.DTO.StudentDTO;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.systemSchool.School.api.DTO.ClassDTO.ClassRequest;
import com.systemSchool.School.api.DTO.ClassDTO.ClassResponse;
import com.systemSchool.School.api.DTO.TeacherDTO.TeacherResponse;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.List;

@Getter
@Setter
@ToString
public class StudentResponse {
    @JsonProperty("StudentID")
    private String studentId;
    @JsonProperty("StudentName")
    private String StudentName;
    @JsonProperty("StudentGender")
    private String StudentGender;
    @JsonProperty("StudentAge")
    private Long StudentAge;

    @JsonProperty("Class")
    private ClassRequest Classes;

    @JsonProperty("Teachers")
    private List<TeacherResponse> Teachers;
}

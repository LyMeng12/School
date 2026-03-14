package com.systemSchool.School.api.DTO.TeacherDTO;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.systemSchool.School.api.DTO.ClassDTO.ClassRequest;
import com.systemSchool.School.api.DTO.ClassDTO.ClassResponse;
import com.systemSchool.School.api.DTO.StudentDTO.StudentRequest;
import com.systemSchool.School.api.DTO.StudentDTO.StudentResponse;
import com.systemSchool.School.api.DTO.SubjectDTO.SubjectRequest;
import com.systemSchool.School.api.DTO.SubjectDTO.SubjectResponse;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.List;

@JsonAutoDetect(fieldVisibility = JsonAutoDetect.Visibility.ANY,
        getterVisibility = JsonAutoDetect.Visibility.NONE)
@Getter
@Setter
@ToString
public class TeacherResponse {
    @JsonProperty("TeacherId")
    private Long TeacherId;
    @JsonProperty("TeacherName")
    private String TeacherName;
    @JsonProperty("Salary")
    private Double salary;
    @JsonProperty("Subjects")
    private List<SubjectRequest> Subjects;
    @JsonProperty("ClassS")
    private List<ClassRequest> Classes;
}

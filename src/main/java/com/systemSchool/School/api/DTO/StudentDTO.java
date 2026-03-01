package com.systemSchool.School.api.DTO;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.List;

@Setter
@Getter
@ToString
public class StudentDTO {

    @JsonProperty("StudentId")
    private Long id;
    @JsonProperty("StudentName")
    private String name;
    @JsonProperty("StudentGender")
    private String gender;
    @JsonProperty("Day of Birthday")
    private String dob;
    @JsonProperty("Email")
    private String email;
    @JsonProperty("ClassName")
    private ClassDTO classDTO;
    @JsonProperty("Subjects")
    private List<SubjectDTO> subjects;
}

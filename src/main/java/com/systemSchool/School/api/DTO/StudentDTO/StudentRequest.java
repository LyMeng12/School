package com.systemSchool.School.api.DTO.StudentDTO;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class StudentRequest {
    @JsonProperty("StudentName")
    private String studentName;
    @JsonProperty("StudentGender")
    private String studentGender;
    @JsonProperty("StudentAge")
    private Long studentAge;
}

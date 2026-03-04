package com.systemSchool.School.api.DTO;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class StudentDTO {
    @JsonProperty("student_id")
    private Long studentId;
    @JsonProperty("student_name")
    private String studentName;
    @JsonProperty("gender")
    private String gender;
    @JsonProperty("dob")
    private String dob;
    @JsonProperty("Email")
    private String email;
    @JsonProperty("Class")
    private ClassDTO classDTO;
}

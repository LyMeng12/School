package com.systemSchool.School.api.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class StudentDTO {
    @JsonProperty("StudenId")
    private Long studenId;

    @JsonProperty("StudentName")
    private String studentName;

    @JsonProperty("StudentGender")
    private String studentGender;

    @JsonProperty("Class")
    private String className;

    @JsonProperty("DOB")
    private Data StudentDOB;

}

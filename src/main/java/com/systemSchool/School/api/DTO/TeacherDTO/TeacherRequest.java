package com.systemSchool.School.api.DTO.TeacherDTO;

import com.fasterxml.jackson.annotation.JacksonInject;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class TeacherRequest {
    @JsonProperty("TeacherId")
    private Long TeacherId;
    @JsonProperty("TeacherName")
    private String TeacherName;
    @JsonProperty("Salary")
    private Double Salary;

}

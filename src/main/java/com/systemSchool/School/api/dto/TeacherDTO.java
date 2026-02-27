package com.systemSchool.School.api.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class TeacherDTO {

    @JsonProperty("teacherID")
    private Long teacherId;
    @JsonProperty("teacherName")
    private String teacherName;
    @JsonProperty("age")
    private Long age;
    @JsonProperty("gender")
    private String gender;
    @JsonProperty("phoneNumber")
    private String phoneNumber;
    @JsonProperty("salary")
    private Double salary;
}

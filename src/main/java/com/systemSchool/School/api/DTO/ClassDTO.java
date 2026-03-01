package com.systemSchool.School.api.DTO;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.List;

@Setter
@Getter
@ToString
public class ClassDTO {

    @JsonProperty("ClassId")
    private Long id;
    @JsonProperty("ClassName")
    private String className;
    @JsonProperty("RoomNumber")
    private String roomNumber;
    @JsonProperty("TeacherName")
    private List<TeacherDTO> teachers;
    @JsonProperty("Student")
    private List<StudentDTO> students;

}

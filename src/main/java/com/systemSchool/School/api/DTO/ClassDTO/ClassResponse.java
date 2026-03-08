package com.systemSchool.School.api.DTO.ClassDTO;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.systemSchool.School.api.DTO.StudentDTO.StudentRequest;
import com.systemSchool.School.api.DTO.StudentDTO.StudentResponse;
import com.systemSchool.School.api.DTO.TeacherDTO.TeacherRequest;
import com.systemSchool.School.api.DTO.TeacherDTO.TeacherResponse;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.List;

@Getter
@Setter
@ToString
public class ClassResponse {
    @JsonProperty("ClassID")
    private Long classId;
    @JsonProperty("ClassName")
    private String className;
    @JsonProperty("ClassRoom")
    private String classRoom;
    @JsonProperty("Students")
    private List<StudentRequest> students;
    @JsonProperty("Teachers")
    private List<TeacherRequest> teachers;
}

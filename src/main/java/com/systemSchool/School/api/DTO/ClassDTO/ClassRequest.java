package com.systemSchool.School.api.DTO.ClassDTO;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.systemSchool.School.api.DTO.StudentDTO.StudentRequest;
import com.systemSchool.School.api.DTO.TeacherDTO.TeacherRequest;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.List;

@Getter
@Setter
@ToString
public class ClassRequest {
    @JsonProperty("ClassId")
    private Long classId;
    @JsonProperty("ClassName")
    private String className;
    @JsonProperty("ClassRoom")
    private String classRoom;

}

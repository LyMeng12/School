package com.systemSchool.School.api.DTO.SubjectDTO;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.systemSchool.School.api.DTO.TeacherDTO.TeacherRequest;
import com.systemSchool.School.api.DTO.TeacherDTO.TeacherResponse;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.List;

@Getter
@Setter
@ToString
public class SubjectResponse {
    @JsonProperty("SubjectId")
    private Long SubjectId;
    @JsonProperty("SubjectName")
    private String SubjectName;
    @JsonProperty("Teachers")
    private List<TeacherRequest> Teachers;

}

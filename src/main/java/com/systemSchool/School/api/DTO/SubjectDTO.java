package com.systemSchool.School.api.DTO;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.List;

@Getter
@Setter
@ToString
public class SubjectDTO {
    @JsonProperty("subject_id")
    private Long subjectId;
    @JsonProperty("subject_name")
    private String subjectName;
    @JsonProperty("teacher_subject")
    private List<TeacherDTO> teacherDTOs;
}

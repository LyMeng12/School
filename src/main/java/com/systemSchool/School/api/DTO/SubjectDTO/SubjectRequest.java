package com.systemSchool.School.api.DTO.SubjectDTO;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class SubjectRequest {
    @JsonProperty("SubjectName")
    private String SubjectName;
}

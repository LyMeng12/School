package com.systemSchool.School.api.DTO.ClassDTO;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class ClassRequest {
    @JsonProperty("ClassName")
    private String className;
    @JsonProperty("ClassRoom")
    private String classRoom;
}

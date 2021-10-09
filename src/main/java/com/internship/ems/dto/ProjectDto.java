package com.internship.ems.dto;

import lombok.Data;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotEmpty;

@Data
public class ProjectDto {

    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long ProjectId;
    @NotEmpty(message = "No name given")
    private String name;
    private String description;
}

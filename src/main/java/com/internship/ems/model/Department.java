package com.internship.ems.model;

import lombok.Data;
import org.springframework.validation.annotation.Validated;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
@Table(name = "department")
@Data

public class Department {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long  departmentId;
    @NotNull
    @Size(min= 2, max = 50, message = "Not valid name")
    private String name;
    private String description;
}

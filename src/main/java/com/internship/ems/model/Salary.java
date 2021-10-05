package com.internship.ems.model;

import lombok.Data;

import javax.persistence.*;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import java.util.Date;

@Entity
@Table(name = "salary")
@Data
public class Salary {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long salaryId;
    @NotNull
    private Date issueDate;
    @NotNull
    @Min(2000)
    private float amount;
    private float bonus;
}

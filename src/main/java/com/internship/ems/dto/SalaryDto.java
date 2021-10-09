package com.internship.ems.dto;

import com.internship.ems.model.Employee;
import lombok.Data;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import java.util.Date;

@Data
public class SalaryDto {

    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long salaryId;
    @NotNull(message = "No date given")
    private Date issueDate;
    @NotNull
    @Min(2000)
    private float amount;
    private float bonus;
    private Employee employee;
}

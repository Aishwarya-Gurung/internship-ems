package com.internship.ems.dto;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.internship.ems.enums.Gender;
import com.internship.ems.model.Department;
import com.internship.ems.model.Salary;
import lombok.Data;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.util.Date;
@Data
public class EmployeeDto {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long employeeId;
   @NotEmpty
    private String firstName;
    @NotEmpty(message = "No last name given")
    private String lastName;
    @NotNull(message = "not valid")
    @Enumerated(EnumType.STRING)
    private Gender gender;
    @NotNull
    @Min(value = 18)
    private int age;
    @NotEmpty
    @Email
    private String email;
    @NotEmpty(message = "No designation given")
//    @Column(name = "designation", nullable = false)
    private String designation;
    @NotNull(message = "No hire date given")
    private Date hireDate;
    private Date resignedDate;
    private String address;

    @JsonBackReference(value = "employee-department")
    private Department department;

    @JsonBackReference(value = "employee-salary")
    public Salary salary;

}

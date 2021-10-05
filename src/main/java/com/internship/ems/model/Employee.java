package com.internship.ems.model;

import lombok.Data;

import javax.persistence.*;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.Date;

@Entity
@Table(name = "employee")
@Data
public class Employee {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long  employeeId;
    @NotNull
    @Size(min=2, max = 50, message = "Not valid first name")
    private String firstName;
    @NotNull
    @Size(min=2, max = 50, message = "Not valid last name")
    private String lastName;
    @NotNull
    @Size(min = 4)
    private String gender;
    @NotNull
   @Min(20)
    private int age;
    @NotNull
    @Size(min=7, message = "email not valid")
    private String email;
    @NotNull
    @Size(min=2, message = "Invalid")
    private String designation;
    @NotNull
    private Date hireDate;
    private Date resignedDate;
    private String address;
}

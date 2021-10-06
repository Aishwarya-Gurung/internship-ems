package com.internship.ems.model;

import com.internship.ems.enums.Gender;
import lombok.Data;

import javax.persistence.*;
import javax.validation.constraints.*;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Date;

@Entity
@Table(name = "employee", schema = "EMS", uniqueConstraints= {@UniqueConstraint(columnNames={"email"})})
@Data
public class Employee {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long employeeId;
    @NotEmpty(message = "No first name given")
    private String firstName;
    @NotEmpty(message = "No last name given")
    private String lastName;
    @NotNull(message = "not valid")
    private Gender gender;
    @NotNull
    @Min(value = 18)
    private int age;
    @NotEmpty
    @Email
    private String email;
//    @NotEmpty(message = "No designation given")
    @Column(name = "designation", nullable = false)
    private String designation;
//    @NotNull(message = "No hire date given")
    private Date hireDate;
    private Date resignedDate;
    private String address;

    @PrePersist
    public void PrePersist(){
        ZoneId defaultZoneId = ZoneId.systemDefault();
        LocalDate localDate = LocalDate.now();
        this.setHireDate(Date.from(localDate.atStartOfDay(defaultZoneId).toInstant()));
    }


}

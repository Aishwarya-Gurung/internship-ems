package com.internship.ems.model;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import java.util.Date;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "salary", schema = "EMS")
@Data
public class Salary {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long salaryId;
    @NotNull(message = "No date given")
    private Date issueDate;
    @NotNull
    @Min(2000)
    private float amount;
    private float bonus;

    @OneToOne(mappedBy = "salary")
    private Employee employee;

    @JsonManagedReference(value = "employee-salary")
    public Employee getEmployee(){
        return employee;
    }

    @PreRemove
    public void PreRemove(){
        System.out.println("Entity "+this+" will be removed.");
    }

    @PostRemove
    public void PostRemove(){
        System.out.println("Entity "+this+" was removed.");
    }
}

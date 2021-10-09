package com.internship.ems.model;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.List;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "department", schema = "EMS")
@Data

public class Department {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long  departmentId;
    @NotEmpty(message = "No name given")
    private String name;
    private String description;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "department",  fetch = FetchType.LAZY)
    private List<Employee> employee;

    @JsonManagedReference(value =  "employee-department")
    public List<Employee> getEmployee() {
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

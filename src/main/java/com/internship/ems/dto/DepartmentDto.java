package com.internship.ems.dto;

import com.internship.ems.model.Employee;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotEmpty;
import java.util.List;


@Data
@AllArgsConstructor
@NoArgsConstructor
public class DepartmentDto {

    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long  departmentId;
    @NotEmpty(message = "No name given")
    private String name;
    private String description;
    private List<Employee> employee;
}

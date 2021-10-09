package com.internship.ems.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.internship.ems.enums.Gender;
import com.internship.ems.listener.EmployeeListener;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.*;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Date;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "employee", schema = "EMS", uniqueConstraints= {@UniqueConstraint(columnNames={"email"})})
@Data
@EntityListeners(EmployeeListener.class)
@NamedQuery(name = "Employee.getEmployeeByNamedQuery", query = "select e from Employee e where e.department.departmentId=:id")
public class Employee {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long employeeId;
    @Column(insertable=false, updatable = false, nullable = false, columnDefinition = "varchar(255) default 'John Snow'")
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
//    @NotEmpty(message = "No designation given")
    @Column(name = "designation", nullable = false)
    private String designation;
//    @NotNull(message = "No hire date given")
    private Date hireDate;
    private Date resignedDate;
    private String address;

    @ManyToOne
    @JoinColumn(name = "departmentId")
    private Department department;

    @OneToOne
    @JoinColumn(name = "salaryId")
    public Salary salary;

    @JsonBackReference(value = "employee-department")
    public Department getDepartment(){
        return department;
    }

    @JsonBackReference(value = "employee-salary")
    public Salary getSalary(){
        return salary;
    }


    @PrePersist
    public void PrePersist(){
        ZoneId defaultZoneId = ZoneId.systemDefault();
        LocalDate localDate = LocalDate.now();
        this.setHireDate(Date.from(localDate.atStartOfDay(defaultZoneId).toInstant()));
    }


}

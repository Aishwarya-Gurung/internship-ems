package com.internship.ems.controller;

import com.internship.ems.dto.EmployeeDto;
import com.internship.ems.model.*;
import com.internship.ems.service.EmployeeService;
import com.internship.ems.service.ProjectService;
import com.internship.ems.service.SalaryService;
import com.internship.ems.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.util.List;

@RestController
@Validated
public class EmployeeController {
    @Autowired
    EmployeeService service;

    @GetMapping("/employee")
    public List<EmployeeDto> getAllEmployee(){
        return service.getAll();
    }

    @GetMapping("/employee/{id}")
    public EmployeeDto getEmployeeById(@PathVariable Long id){
        return service.getById(id);
    }

    @PostMapping("/addEmployee")
    public ResponseEntity<EmployeeDto> saveEmployee(@Valid @RequestBody EmployeeDto employeeDto){
        return new ResponseEntity<>(service.saveEmployee(employeeDto), HttpStatus.CREATED);
    }

    @PutMapping("/updateEmployee/{id}")
    public ResponseEntity<EmployeeDto> updateEmployee(@PathVariable Long id, @RequestBody EmployeeDto employeeInfoDto) {
        return new ResponseEntity<>(service.updateEmployee(id, employeeInfoDto), HttpStatus.CREATED);
    }

    @DeleteMapping("/deleteEmployee/{id}")
    public String deleteEmployee(@PathVariable Long id){
        return service.deleteEmployee(id);
    }
}

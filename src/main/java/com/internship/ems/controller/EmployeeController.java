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
import org.springframework.web.bind.annotation.*;

import javax.transaction.Transactional;
import javax.validation.Valid;
import java.util.List;

@RestController
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

    @GetMapping("/getEmployeeByDesignation/{designation}")
    public List<EmployeeDto> getEmployeeByDesignation(@PathVariable String designation){
        return service.findEmployeeByDesignation(designation);
    }

    @GetMapping("/employeeByFirstName/{firstName}")
    public List<EmployeeDto> findEmployeeByFirstName(@PathVariable String firstName){
        return service.getEmployeeByFirstName(firstName);
    }

    @GetMapping("/custom/employees/namedquery")
    public List<EmployeeDto> getEmployeeByNamedQuery(@RequestParam("departmentId") long departmentId) {
        return service.getByNamedQuery(departmentId);
    }

    @GetMapping("/custom/employees/typedQuery")
    public List<EmployeeDto> getEmployeeByTypedQuery(@RequestParam("departmentId") long departmentId) {
        return service.getByTypedQuery(departmentId);
    }

    @GetMapping("/custom/employees/criteriaApi")
    public List<EmployeeDto> getEmployeeByJpql(@RequestParam("amount") float amount, @RequestParam("bonus") float bonus) {
        return service.getByCriteriaApi(amount, bonus);
    }

    @PostMapping("/addEmployee")
    public ResponseEntity<EmployeeDto> saveEmployee(@Valid @RequestBody EmployeeDto employeeDto){
        return new ResponseEntity<>(service.saveEmployee(employeeDto), HttpStatus.CREATED);
    }

    @PutMapping("/updateEmployee/{id}")
    public ResponseEntity<EmployeeDto> updateEmployee(@PathVariable Long id, @RequestBody EmployeeDto employeeInfoDto) {
        return new ResponseEntity<>(service.updateEmployee(id, employeeInfoDto), HttpStatus.CREATED);
    }


    @Transactional
    @PutMapping("/updateEmployeeAgeById/{id}&{age}")
    public String updateEmployeeAgeById(@PathVariable long id, @PathVariable int age){
        return service.updateById(id, age);
    }

    @DeleteMapping("/deleteEmployee/{id}")
    public String deleteEmployee(@PathVariable Long id){
        return service.deleteEmployee(id);
    }

    @Transactional
    @DeleteMapping("/deleteEmployeeById/{id}")
    public String  deleteEmployeeById(@PathVariable long id){
        return service.deleteEmployeeById(id);
    }
}

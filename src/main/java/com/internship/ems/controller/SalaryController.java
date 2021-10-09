package com.internship.ems.controller;

import com.internship.ems.dto.SalaryDto;
import com.internship.ems.model.Department;
import com.internship.ems.model.Salary;
import com.internship.ems.model.User;
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
import javax.validation.constraints.NotNull;
import java.util.List;

@RestController
public class SalaryController {
    @Autowired
    SalaryService service;

    @GetMapping("/salary")
    public List<SalaryDto> getAll(){
        return service.getAll();
    }

    @GetMapping("/salary/{id}")
    public SalaryDto getSalaryById(@PathVariable Long id){
        return service.getById(id);
    }

    @PostMapping("/addSalary")
    public ResponseEntity<SalaryDto> saveSalary(@Valid @RequestBody SalaryDto salaryDto){
        return new ResponseEntity<>(service.saveSalary(salaryDto), HttpStatus.CREATED);
    }

    @PutMapping("/updateSalary/{id}")
    public ResponseEntity<SalaryDto> updateSalary(@PathVariable Long id, @RequestBody SalaryDto salaryDto){
        return new ResponseEntity<SalaryDto>( service.updateSalary(id, salaryDto) ,HttpStatus.CREATED);
    }

    @DeleteMapping("/deleteSalary/{id}")
    public String deleteSalary(@PathVariable Long id){
        service.deleteSalary(id);

        return "Salary of id: "+id+" deleted!!";
    }
}

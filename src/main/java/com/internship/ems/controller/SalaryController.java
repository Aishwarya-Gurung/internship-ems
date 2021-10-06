package com.internship.ems.controller;

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
@Validated
public class SalaryController {
    @Autowired
    SalaryService service;

    @PostMapping("/addSalary")
    public Salary addSalary(@Valid @RequestBody Salary salary){

        return service.save(salary);
    }
//@PostMapping("/addSalary")
//public ResponseEntity<Salary> addSalary(@Valid @RequestBody Salary salary){
//    Salary saveSalary = service.save(salary);
//    return new ResponseEntity<Salary>(saveSalary, HttpStatus.CREATED);
//}

    @GetMapping("/salary")
    public List<Salary> getAllSalary(){

        return service.getAll();
    }

    @GetMapping("/salary/{id}")
    public Salary getSalaryById(@PathVariable Long id){

        return service.getById(id);
    }



    @PutMapping("/updateSalary/{id}")
    public Salary updateSalary(@PathVariable Long id, @RequestBody Salary salaryInfo) {
        return service.updateSalary(id, salaryInfo);
    }

    @DeleteMapping("/deleteSalary/{id}")
    public String removeSalary(@PathVariable Long id){
          return service.deleteSalary(id);
    }
}

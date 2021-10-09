package com.internship.ems.controller;

import com.internship.ems.dto.DepartmentDto;
import com.internship.ems.model.*;
import com.internship.ems.service.*;
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
public class DepartmentController {
    @Autowired
    DepartmentService service;

    @GetMapping("/department")
    public ResponseEntity<List<DepartmentDto>> getAll(){
        return new ResponseEntity<>(service.getAll(), HttpStatus.OK);
    }

    @GetMapping("/department/{id}")
    public DepartmentDto getById(@PathVariable Long id){
        return service.getById(id);
    }



    @PostMapping("/addDepartment")
    public ResponseEntity<DepartmentDto> saveDepartment(@RequestBody DepartmentDto departmentDto){
        return new ResponseEntity<DepartmentDto>(
                service.saveDepartment(departmentDto), HttpStatus.CREATED);
    }

    @PutMapping("/updateDepartment/{id}")
    public ResponseEntity<DepartmentDto> updateDepartment(@PathVariable Long id, @RequestBody DepartmentDto departmentDto){
        return new ResponseEntity<DepartmentDto>(
                service.updateEmployee(id, departmentDto), HttpStatus.CREATED);
    }

    @DeleteMapping("/deleteDepartment/{id}")
    public String deleteDepartment(@PathVariable Long id){
        return service.deleteDepartment(id);
    }

}

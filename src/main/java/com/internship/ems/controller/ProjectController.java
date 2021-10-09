package com.internship.ems.controller;

import com.internship.ems.dto.ProjectDto;
import com.internship.ems.model.Department;
import com.internship.ems.model.Project;
import com.internship.ems.model.Salary;
import com.internship.ems.model.User;
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
import javax.validation.constraints.NotNull;
import java.util.List;

@RestController
public class ProjectController {
    @Autowired
    ProjectService service;

    @GetMapping("/project")
    public List<ProjectDto> getAllProject(){
        return service.getAll();
    }

    @GetMapping("/project/{id}")
    public ProjectDto getProjectById(@PathVariable Long id){
        return service.getById(id);
    }

    @PostMapping("/addProject")
    public ProjectDto saveProject(@Valid @RequestBody ProjectDto projectDto){
        return service.saveProject(projectDto);
    }

    @PutMapping("/updateProject/{id}")
    public ProjectDto updateProject(@PathVariable Long id,@RequestBody ProjectDto projectInfoDto){
        return service.updateProject(id, projectInfoDto);
    }

    @DeleteMapping("/deleteProject/{id}")
    public String deleteProject(@PathVariable Long id){
        return service.deleteProject(id);
    }

}

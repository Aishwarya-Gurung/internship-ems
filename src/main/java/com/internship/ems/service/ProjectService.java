package com.internship.ems.service;

import com.internship.ems.Mapper.ProjectMapper;
import com.internship.ems.dao.ProjectRepository;
import com.internship.ems.dao.SalaryRepository;
import com.internship.ems.dao.UserRepository;
import com.internship.ems.dto.ProjectDto;
import com.internship.ems.model.Project;
import com.internship.ems.model.Salary;
import com.internship.ems.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import java.util.ArrayList;
import java.util.List;

@Service

public class ProjectService {
    @Autowired
    private ProjectRepository projectRepo;

    @Autowired
    private ProjectMapper projectMapper;

    public ProjectDto saveProject(ProjectDto projectDto){
        Project projectModel = projectMapper.dtoToModel(projectDto);
        return  projectMapper.modelToDto( projectRepo.save(projectModel) );
    }

    public ProjectDto getById(Long id){
        Project projectWithSearchedId = projectRepo.findById(id).orElseThrow(EntityNotFoundException::new);

        return  projectMapper.modelToDto( projectRepo.findById(id).orElseThrow(EntityNotFoundException::new) );
    }

    public List<ProjectDto> getAll(){
        return projectMapper.modelsToDtos( (List<Project>) projectRepo.findAll() );
    }

    public ProjectDto updateProject(Long id, ProjectDto newProjectDto){
        Project newProjectModel= projectMapper.dtoToModel( newProjectDto );

        Project project = projectRepo.findById(id).orElseThrow(EntityNotFoundException::new);
        project.setName(newProjectModel.getName());
        project.setDescription(newProjectModel.getDescription());
        projectRepo.save(project);

        return projectMapper.modelToDto( project );
    }

    public String deleteProject(Long id){
        projectRepo.deleteById(id);

        return "Id " +id+" deleted!! ";
    }
}

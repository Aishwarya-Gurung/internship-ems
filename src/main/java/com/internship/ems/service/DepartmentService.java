package com.internship.ems.service;

import com.internship.ems.Mapper.DepartmentMapper;
import com.internship.ems.dao.DepartmentRepository;
import com.internship.ems.dao.ProjectRepository;
import com.internship.ems.dao.SalaryRepository;
import com.internship.ems.dao.UserRepository;
import com.internship.ems.dto.DepartmentDto;
import com.internship.ems.model.Department;
import com.internship.ems.model.Project;
import com.internship.ems.model.Salary;
import com.internship.ems.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import java.util.ArrayList;
import java.util.List;

@Service
public class DepartmentService {
    @Autowired
    private DepartmentRepository departmentRepo;
    @Autowired
    private DepartmentMapper departmentMapper;

    public DepartmentDto saveDepartment(DepartmentDto departmentDto){
        Department departmentModel = departmentMapper.dtoToModel(departmentDto);
        Department DepartmentSaved = departmentRepo.save(departmentModel);

        return departmentMapper.modelToDto(DepartmentSaved);
    }

    public DepartmentDto getById(Long id){
        return departmentMapper.modelToDto( departmentRepo.findById(id).orElseThrow(EntityNotFoundException::new));
    }

    public List<DepartmentDto> getAll() {
        List<Department> result = new ArrayList<>();
        departmentRepo.findAll().forEach(result::add);

        return departmentMapper.modelsToDtos(result);
    }

    public DepartmentDto  updateEmployee(Long id, DepartmentDto newDepartmentDto){
        Department department = departmentRepo.findById(id).orElseThrow(EntityNotFoundException::new);

        Department newDepartmentModel = departmentMapper.dtoToModel(newDepartmentDto);
        department.setName(newDepartmentModel.getName());
        department.setDescription(newDepartmentModel.getDescription());
        departmentRepo.save(department);

        return departmentMapper.modelToDto(department);
    }

    public String deleteDepartment(Long id){
        departmentRepo.deleteById(id);

        return "id "+id+" deleted !!";
    }
}

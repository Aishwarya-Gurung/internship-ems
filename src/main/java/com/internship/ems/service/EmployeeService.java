package com.internship.ems.service;

import com.internship.ems.Mapper.EmployeeMapper;
import com.internship.ems.dao.EmployeeRepository;
import com.internship.ems.dao.ProjectRepository;
import com.internship.ems.dao.SalaryRepository;
import com.internship.ems.dao.UserRepository;
import com.internship.ems.dto.EmployeeDto;
import com.internship.ems.model.Employee;
import com.internship.ems.model.Project;
import com.internship.ems.model.Salary;
import com.internship.ems.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import java.util.ArrayList;
import java.util.List;

@Service
public class EmployeeService {
    @Autowired
    private EmployeeRepository employeeRepo;

    @Autowired
    private EmployeeMapper employeeMapper;

    public EmployeeDto saveEmployee(EmployeeDto employeeDto){
        Employee employeeModel = employeeMapper.DtoToModel(employeeDto);
        Employee employeeSaved = employeeRepo.save(employeeModel);

        return employeeMapper.modelToDto( employeeSaved ) ;
    }

    public EmployeeDto getById(Long id){
        return employeeMapper.modelToDto( employeeRepo.findById(id).orElseThrow(EntityNotFoundException::new) );
    }

    public List<EmployeeDto> getAll(){
        List<Employee> employeesList = (List<Employee>) employeeRepo.findAll();

        return employeeMapper.modelsToDtos(employeesList);
    }

    public EmployeeDto updateEmployee(Long id, EmployeeDto newEmployeeDto){
        Employee employeeModel = employeeMapper.DtoToModel(newEmployeeDto);

        Employee employee = employeeRepo.findById(id).orElseThrow(EntityNotFoundException::new);
        employee.setFirstName(employeeModel.getFirstName());
        employee.setLastName(employeeModel.getLastName());
        employee.setGender(employeeModel.getGender());
        employee.setAge(employeeModel.getAge());
        employee.setEmail(employeeModel.getEmail());
        employee.setDesignation(employeeModel.getDesignation());
        employee.setHireDate(employeeModel.getHireDate());
        employee.setResignedDate(employeeModel.getResignedDate());
        employee.setAddress(employeeModel.getAddress());
        employeeRepo.save(employee);

        return employeeMapper.modelToDto(employee);
    }

    public String deleteEmployee(Long id){
        employeeRepo.deleteById(id);

        return "Id " +id+" deleted!! ";
    }
}

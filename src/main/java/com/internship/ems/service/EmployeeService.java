package com.internship.ems.service;

import com.internship.ems.Mapper.EmployeeMapper;
import com.internship.ems.dao.*;
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

    @Autowired
    private EmployeeDao employeeDao;

    public EmployeeDto saveEmployee(EmployeeDto employeeDto){
        Employee employeeModel = employeeMapper.DtoToModel(employeeDto);
        Employee employeeSaved = employeeRepo.save(employeeModel);

        return employeeMapper.modelToDto( employeeSaved ) ;
    }

    public EmployeeDto getById(Long id){
        return employeeMapper.modelToDto( employeeRepo.findById(id).orElseThrow(EntityNotFoundException::new) );
    }

    public List<EmployeeDto> getEmployeeByFirstName(String firstName){

        return employeeMapper.modelsToDtos( employeeRepo.getUserByFirstName(firstName) );
    }

    public List<EmployeeDto> findEmployeeByDesignation(String designation) {
        return employeeMapper.modelsToDtos(employeeRepo.findEmployeeByDesignation(designation));
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

    public String updateById(Long id, int age){
        employeeRepo.updateEmployeeById(id, age);
        return "Age of id: "+id+" updated";
    }

    public String deleteEmployee(Long id){
        employeeRepo.deleteById(id);

        return "Id " +id+" deleted!! ";
    }
    public String deleteEmployeeById(long id){
        employeeRepo.deleteEmployeeById(id);

        return "ID: "+id+" Deleted";
    }




        public List<EmployeeDto> getByNamedQuery(long departmentId) {
        return employeeMapper.modelsToDtos(employeeDao.getEmployeeByNamedQuery(departmentId));
    }

    public List<EmployeeDto> getByTypedQuery(long departmentId) {
        return employeeMapper.modelsToDtos(employeeDao.getEmployeeByTypedQuery(departmentId));
    }

    public List<EmployeeDto> getByCriteriaApi(float amount, float bonus) {
        return employeeMapper.modelsToDtos(employeeDao.getEmployee(amount, bonus));
    }
}

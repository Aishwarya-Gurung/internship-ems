package com.internship.ems.service;

import com.internship.ems.dao.EmployeeRepository;
import com.internship.ems.dao.ProjectRepository;
import com.internship.ems.dao.SalaryRepository;
import com.internship.ems.dao.UserRepository;
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

    public Employee save(Employee employee){

        return employeeRepo.save(employee);
    }

    public List<Employee> getAll() {
        List<Employee> result = new ArrayList<>();
        employeeRepo.findAll().forEach(result::add);
        return result;
    }
    public Employee getById(long id) {

        return employeeRepo.findById(id).orElseThrow(EntityNotFoundException::new);
    }

    public Employee updateEmployee(long id, Employee newEmployee) {
      Employee employee = employeeRepo.findById(id).orElseThrow(EntityNotFoundException::new);
        employee.setFirstName(newEmployee.getFirstName());
        employee.setLastName(newEmployee.getLastName());
        employee.setGender(newEmployee.getGender());
        employee.setAge(newEmployee.getAge());
        employee.setEmail(newEmployee.getEmail());
        employee.setDesignation(newEmployee.getDesignation());
        employee.setHireDate(newEmployee.getHireDate());
        employee.setResignedDate(newEmployee.getResignedDate());
        employee.setAddress(newEmployee.getAddress());
      employeeRepo.save(employee);
        return employee;
    }



    public String deleteEmployee(Long id){

       employeeRepo.deleteById(id);
        return "Employee of id" + " " + id + " " + "is deleted.";
    }
}

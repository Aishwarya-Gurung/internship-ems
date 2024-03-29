package com.internship.ems.dao;

import com.internship.ems.model.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Long> {

    List<Employee> findEmployeeByDesignation(String designation);


    @Query(value = "SELECT * FROM  employee WHERE first_name=:name", nativeQuery = true)
    List<Employee> getUserByFirstName(@Param("name") String firstName);

    @Modifying
    @Query("UPDATE Employee e SET e.age=:age WHERE e.employeeId=:employeeId")
    void updateEmployeeById(@Param("employeeId") Long employeeId, @Param("age") int age);

    @Modifying
    @Query("DELETE from Employee e WHERE e.employeeId=:employeeId")
    void deleteEmployeeById(@Param("employeeId") Long employeeId);
}

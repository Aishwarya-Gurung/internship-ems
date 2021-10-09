package com.internship.ems.listener;

import com.internship.ems.model.Employee;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import javax.persistence.*;
public class EmployeeListener {
    private static Log log = LogFactory.getLog(EmployeeListener.class);

    @PrePersist
    private void beforeSave(Employee employee) {
        log.info("Processing to save an employee");
    }

    @PreUpdate
    private void beforeUpdate(Employee employee) {
        log.info("Processing to update employee: " + employee.getEmployeeId());
    }

    @PreRemove
    private void beforeDelete(Employee employee) {
        log.info("Processing to delete employee: " + employee.getEmployeeId());
    }

    @PostPersist
    private void afterSave(Employee employee) {
        log.info("Save process completed for department: " + employee.getEmployeeId());
    }

    @PostUpdate
    private void afterUpdate(Employee employee) {
        log.info("Update process completed for employee : " + employee.getEmployeeId());
    }

    @PostRemove
    private void afterDelete(Employee employee) {
        log.info("Delete process completed for employee: " + employee.getEmployeeId());
    }

    @PostLoad
    private void afterLoad(Employee employee) {
        log.info("Employee loaded from database: " + employee.getEmployeeId());
    }
}

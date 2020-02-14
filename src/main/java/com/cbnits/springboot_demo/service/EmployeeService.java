package com.cbnits.springboot_demo.service;

import com.cbnits.springboot_demo.bean.entity.Employee;
import com.cbnits.springboot_demo.bean.request.EmployeeRequest;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service("emp1")
public class EmployeeService implements IEmployeeService {

    @Override
    public Employee createEmployee(EmployeeRequest request) {
        Employee employee = new Employee(
                UUID.randomUUID().toString(),
                request.getName(),
                request.getSalary(),
                request.getDesignation()
        );
        return employee;
    }
}

package com.cbnits.springboot_demo.service;

import com.cbnits.springboot_demo.bean.entity.Employee;
import com.cbnits.springboot_demo.bean.request.EmployeeRequest;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service("emp2")
public class EmployeeService2 implements IEmployeeService {

    @Override
    public Employee createEmployee(EmployeeRequest request) {
        Employee employee = new Employee(
                UUID.randomUUID().toString(),
                String.format("Mr. %s", request.getName()),
                request.getSalary(),
                request.getDesignation()
        );
        return employee;
    }
}

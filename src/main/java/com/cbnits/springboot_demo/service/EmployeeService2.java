package com.cbnits.springboot_demo.service;

import com.cbnits.springboot_demo.bean.entity.Employee;
import com.cbnits.springboot_demo.bean.pojo.Response;
import com.cbnits.springboot_demo.bean.request.EmployeeRequest;
import com.cbnits.springboot_demo.repository.EmployeeJpaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("db_employee")
public class EmployeeService2 implements IEmployeeService {

    @Autowired
    EmployeeJpaRepository repository;

    @Override
    public Employee createEmployee(EmployeeRequest request) {

        Employee employee = new Employee();
        employee.setName(request.getName());
        employee.setSalary(request.getSalary());
        employee.setDesignation(request.getDesignation());

        return repository.save(employee);
    }

    @Override
    public List<Employee> getEmployees() {
        return repository.findAll();
    }

    @Override
    public Employee get(String id) {
        return null;
    }

    @Override
    public Response delete(String id) {
        return null;
    }

    @Override
    public Employee update(String id, EmployeeRequest request) {
        return null;
    }
}

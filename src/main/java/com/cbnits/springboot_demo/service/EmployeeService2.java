package com.cbnits.springboot_demo.service;

import com.cbnits.springboot_demo.bean.entity.Employee;
import com.cbnits.springboot_demo.bean.pojo.Response;
import com.cbnits.springboot_demo.bean.request.EmployeeRequest;
import com.cbnits.springboot_demo.repository.EmployeeJpaRepository;
import com.cbnits.springboot_demo.util.exceptions.InvalidRequestException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

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
    public Employee get(Long id) {
        Optional<Employee> optionalEmployee = repository.findById(id);

        if (!optionalEmployee.isPresent())
            throw new InvalidRequestException(String.format("Employee with id: %s is not present", id));

        return optionalEmployee.get();
    }

    @Override
    public Response delete(Long id) {

        if (!repository.existsById(id))
            throw new InvalidRequestException(String.format("Employee with id: %s is not present", id));

        repository.deleteById(id);

        return new Response(false, "Employee deleted");
    }

    @Override
    public Employee update(Long id, EmployeeRequest request) {

        Optional<Employee> optionalEmployee = repository.findById(id);

        if (!optionalEmployee.isPresent())
            throw new InvalidRequestException(String.format("Employee with id: %s is not present", id));

        Employee employee = optionalEmployee.get();
        employee.setName(request.getName());
        employee.setSalary(request.getSalary());
        employee.setDesignation(request.getDesignation());

        return repository.save(employee);
    }
}

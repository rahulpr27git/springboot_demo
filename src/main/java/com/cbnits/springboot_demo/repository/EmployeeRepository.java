package com.cbnits.springboot_demo.repository;

import com.cbnits.springboot_demo.bean.entity.Employee;
import com.cbnits.springboot_demo.bean.request.EmployeeRequest;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Repository
public class EmployeeRepository implements IEmployeeRepository {

    private List<Employee> employees = new ArrayList<>();


    @Override
    public Employee insert(EmployeeRequest request) {
        Employee employee = new Employee(
                UUID.randomUUID().timestamp(),
                request.getName(),
                request.getSalary(),
                request.getDesignation()
        );

        employees.add(employee);
        return employee;
    }

    @Override
    public List<Employee> all() {
        return employees;
    }

    @Override
    public Optional<Employee> get(String id) {
        return employees.stream()
                .filter(employee -> employee.getId().equals(id))
                .findFirst();
    }

    @Override
    public boolean delete(String id) {
        return employees.removeIf(employee -> employee.getId().equals(id));
    }

    @Override
    public Employee update(String id, EmployeeRequest request) {
        Optional<Employee> optionalEmployee = employees.stream()
                .filter(employee -> employee.getId().equals(id))
                .findFirst();

        if (optionalEmployee.isPresent()) {
            Employee employee = optionalEmployee.get();
            employee.setDesignation(request.getDesignation());
            employee.setName(request.getName());
            employee.setSalary(request.getSalary());

            return employee;
        }
        return null;
    }
}

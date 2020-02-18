package com.cbnits.springboot_demo.repository;

import com.cbnits.springboot_demo.bean.entity.Employee;
import com.cbnits.springboot_demo.bean.request.EmployeeRequest;

import java.util.List;
import java.util.Optional;

public interface IEmployeeRepository {

    Employee insert(EmployeeRequest request);

    List<Employee> all();

    Optional<Employee> get(String id);

    boolean delete(String id);

    Employee update(String id, EmployeeRequest request);
}

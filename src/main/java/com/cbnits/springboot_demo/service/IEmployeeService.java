package com.cbnits.springboot_demo.service;

import com.cbnits.springboot_demo.bean.entity.Employee;
import com.cbnits.springboot_demo.bean.payload.Response;
import com.cbnits.springboot_demo.bean.request.EmployeeRequest;

import java.util.List;

public interface IEmployeeService {

    Employee createEmployee(EmployeeRequest request) throws Exception;

    List<Employee> getEmployees();

    Employee get(String id) throws Exception;

    Response delete(String id) throws Exception;

    Employee update(String id, EmployeeRequest request) throws Exception;
}

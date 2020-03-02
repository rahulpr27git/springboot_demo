package com.cbnits.springboot_demo.service;

import com.cbnits.springboot_demo.bean.entity.Employee;
import com.cbnits.springboot_demo.bean.pojo.Response;
import com.cbnits.springboot_demo.bean.request.EmployeeRequest;

import java.util.List;

public interface IEmployeeService {

    Employee createEmployee(EmployeeRequest request) throws Exception;

    List<Employee> getEmployees();

    Employee get(Long id);

    Response delete(Long id) ;

    Employee update(Long id, EmployeeRequest request);

    List<Employee> getByName(String name);
}

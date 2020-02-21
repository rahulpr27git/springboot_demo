package com.cbnits.springboot_demo.service;

import com.cbnits.springboot_demo.bean.entity.Employee;
import com.cbnits.springboot_demo.bean.pojo.Response;
import com.cbnits.springboot_demo.bean.request.EmployeeRequest;

import java.util.List;

public interface IEmployeeService {

    Employee createEmployee(EmployeeRequest request) throws Exception;

    List<Employee> getEmployees();

    Employee get(String id);

    Response delete(String id) ;

    Employee update(String id, EmployeeRequest request);
}

package com.cbnits.springboot_demo.service;

import com.cbnits.springboot_demo.bean.entity.Employee;
import com.cbnits.springboot_demo.bean.request.EmployeeRequest;

public interface IEmployeeService {

    Employee createEmployee(EmployeeRequest request);
}

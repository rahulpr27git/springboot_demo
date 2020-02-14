package com.cbnits.springboot_demo.controller;

import com.cbnits.springboot_demo.bean.entity.Employee;
import com.cbnits.springboot_demo.bean.request.EmployeeRequest;
import com.cbnits.springboot_demo.service.EmployeeService;
import com.cbnits.springboot_demo.service.IEmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("v1")
public class EmployeeController {

    @Autowired
    @Qualifier("emp2")
    private IEmployeeService service;

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping("employees")
    public Employee createEmployee(@RequestBody EmployeeRequest request) {
        return service.createEmployee(request);
    }
}

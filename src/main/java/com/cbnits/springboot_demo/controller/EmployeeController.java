package com.cbnits.springboot_demo.controller;

import com.cbnits.springboot_demo.bean.entity.Employee;
import com.cbnits.springboot_demo.bean.pojo.Response;
import com.cbnits.springboot_demo.bean.request.EmployeeRequest;
import com.cbnits.springboot_demo.service.IEmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpStatus;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@Validated
@RestController
@RequestMapping("v1")
public class EmployeeController {

    @Autowired
    @Qualifier("db_employee")
    private IEmployeeService service;

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping("employees")
    public Employee createEmployee(@RequestBody @Valid EmployeeRequest request) throws Exception {
        return service.createEmployee(request);
    }

    @ResponseStatus(HttpStatus.OK)
    @GetMapping("employees")
    public List<Employee> getAll() {
        return service.getEmployees();
    }

    @ResponseStatus(HttpStatus.OK)
    @GetMapping("employees/{id}")
    public Employee get1(@PathVariable("id") Long id) {
        return service.get(id);
    }

    @ResponseStatus(HttpStatus.OK)
    @DeleteMapping("employees/{id}")
    public Response delete(@PathVariable(value = "id") Long id) {
        return service.delete(id);
    }

    @ResponseStatus(HttpStatus.OK)
    @PutMapping("employees/{id}")
    public Employee update(
            @PathVariable("id") Long id,
            @RequestBody @Valid EmployeeRequest request
    ) {
        return service.update(id, request);
    }
}

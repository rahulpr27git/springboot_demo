package com.cbnits.springboot_demo.controller;

import com.cbnits.springboot_demo.bean.entity.Employee;
import com.cbnits.springboot_demo.bean.payload.Response;
import com.cbnits.springboot_demo.bean.request.EmployeeRequest;
import com.cbnits.springboot_demo.service.IEmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("v1")
public class EmployeeController {

    @Autowired
    private IEmployeeService service;

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping("employees")
    public Employee createEmployee(@RequestBody EmployeeRequest request) {
        return service.createEmployee(request);
    }

    @ResponseStatus(HttpStatus.OK)
    @GetMapping("employees")
    public List<Employee> getAll() {
        return service.getEmployees();
    }

    /*@ResponseStatus(HttpStatus.OK)
    @GetMapping("employees")
    public Employee get(@RequestParam("id") String id) throws Exception {
        return service.get(id);
    }*/

    @ResponseStatus(HttpStatus.OK)
    @GetMapping("employees/{id}")
    public Employee get1(@PathVariable("id") String id) throws Exception {
        return service.get(id);
    }

    @ResponseStatus(HttpStatus.OK)
    @DeleteMapping("employees/{id}")
    public Response delete(@PathVariable("id") String id) throws Exception {
        return service.delete(id);
    }

    @ResponseStatus(HttpStatus.OK)
    @PutMapping("employees/{id}")
    public Employee update(
            @PathVariable("id") String id,
            @RequestBody EmployeeRequest request
    ) throws Exception {
        return service.update(id, request);
    }
}

package com.cbnits.springboot_demo.controller;

import com.cbnits.springboot_demo.bean.entity.Employee;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("v1")
public class SampleController {

    @GetMapping
    public String defaultPage() {
        return "Hello! This is my first API";
    }

    @PostMapping("employee")
    public Employee postJsonRequestSample(@RequestBody Employee employee) {
        return employee;
    }
}

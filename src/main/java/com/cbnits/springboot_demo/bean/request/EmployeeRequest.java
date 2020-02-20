package com.cbnits.springboot_demo.bean.request;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

public class EmployeeRequest {

    //hibernate-validator
    @NotNull(message = "Name should not be null")
    private String name;

    @NotNull(message = "salary should not be null")
    @Min(value = 1, message = "Salary should be greater the 0")
    private Long salary;

    @NotNull(message = "designation should not be null")
    private String designation;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Long getSalary() {
        return salary;
    }

    public void setSalary(Long salary) {
        this.salary = salary;
    }

    public String getDesignation() {
        return designation;
    }

    public void setDesignation(String designation) {
        this.designation = designation;
    }
}

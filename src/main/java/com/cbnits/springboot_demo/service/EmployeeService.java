package com.cbnits.springboot_demo.service;

import com.cbnits.springboot_demo.bean.entity.Employee;
import com.cbnits.springboot_demo.bean.pojo.Response;
import com.cbnits.springboot_demo.bean.request.EmployeeRequest;
import com.cbnits.springboot_demo.repository.IEmployeeRepository;
import com.cbnits.springboot_demo.util.exceptions.InvalidRequestException;
import com.cbnits.springboot_demo.util.exceptions.SpringBootDemoException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EmployeeService implements IEmployeeService {

    @Autowired
    private IEmployeeRepository repository;

    @Override
    public Employee createEmployee(EmployeeRequest request) {
        return repository.insert(request);
    }

    @Override
    public List<Employee> getEmployees() {
        return repository.all();
    }

    @Override
    public Employee get(String id) {
        Optional<Employee> employee = repository.get(id);

        if (employee.isPresent())
            return employee.get();

        throw new InvalidRequestException(String.format("Employee with id: %s not present", id));
    }

    @Override
    public Response delete(String id) {
        boolean delete = repository.delete(id);
        if (delete)
            return new Response(false, String.format("Employee with id: %s successfully deleted.", id));

        throw new SpringBootDemoException(String.format("Employee with id: %s not present", id));
    }

    @Override
    public Employee update(String id, EmployeeRequest request) {
        Employee emp = repository.update(id, request);

        if (emp != null)
            return emp;

        throw new InvalidRequestException(String.format("Employee with id: %s not present", id));
    }
}

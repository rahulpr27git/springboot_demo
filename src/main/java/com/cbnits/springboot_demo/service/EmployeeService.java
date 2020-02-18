package com.cbnits.springboot_demo.service;

import com.cbnits.springboot_demo.bean.entity.Employee;
import com.cbnits.springboot_demo.bean.payload.Response;
import com.cbnits.springboot_demo.bean.request.EmployeeRequest;
import com.cbnits.springboot_demo.repository.IEmployeeRepository;
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
    public Employee get(String id) throws Exception {
        Optional<Employee> employee = repository.get(id);

        if (employee.isPresent())
            return employee.get();

        throw new Exception(String.format("Employee with id: %s not preset", id));
    }

    @Override
    public Response delete(String id) throws Exception {
        boolean delete = repository.delete(id);
        if (delete)
            return new Response(false, String.format("Employee with id: %s successfully deleted.", id));

        throw new Exception(String.format("Employee with id: %s not preset", id));
    }

    @Override
    public Employee update(String id, EmployeeRequest request) throws Exception {
        Employee emp = repository.update(id, request);

        if (emp != null)
            return emp;

        throw new Exception(String.format("Employee with id: %s not preset", id));
    }
}

package com.cbnits.springboot_demo.repository;

import com.cbnits.springboot_demo.bean.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface EmployeeJpaRepository extends JpaRepository<Employee, Long> {

    List<Employee> findByName(String name);
}

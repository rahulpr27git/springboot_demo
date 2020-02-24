package com.cbnits.springboot_demo.repository;

import com.cbnits.springboot_demo.bean.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmployeeJpaRepository extends JpaRepository<Employee, Long> {
}

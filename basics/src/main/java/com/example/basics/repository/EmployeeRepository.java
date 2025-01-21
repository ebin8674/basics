package com.example.basics.repository;

import com.example.basics.model.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
public interface EmployeeRepository extends JpaRepository<Employee, Long>{



}

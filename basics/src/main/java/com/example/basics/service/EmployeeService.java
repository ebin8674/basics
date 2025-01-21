package com.example.basics.service;


import com.example.basics.dto.EmployeeDTO;
import com.example.basics.model.Employee;
import com.example.basics.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service

public class EmployeeService {

        @Autowired
        private EmployeeRepository employeeRepository;

        public EmployeeDTO saveEmployee(EmployeeDTO employeeDTO) {
            Employee employee = new Employee(null, employeeDTO.getName(), employeeDTO.getDepartment(), employeeDTO.getSalary());
            Employee response = employeeRepository.save(employee);
            employeeDTO.setId(response.getId());
            return employeeDTO;
        }

        public List<Employee> getAllEmployees() {
            return employeeRepository.findAll();
        }

        public Employee getEmployeeById(Long id) {
            return employeeRepository.findById(id).orElse(null);
        }

        public void deleteEmployee(Long id) {
            employeeRepository.deleteById(id);
        }
    }



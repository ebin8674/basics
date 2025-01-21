package com.example.basics.controller;
import com.example.basics.dto.EmployeeDTO;
import com.example.basics.model.Employee;
import com.example.basics.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/employees")
public class EmployeeController {

    @Autowired
    private EmployeeService employeeService;

    @PostMapping ("/")
    public Employee createEmployee(@RequestBody EmployeeDTO employeeDTO) {
        Employee employee = new Employee(null, employeeDTO.getName(), employeeDTO.getDepartment(), employeeDTO.getSalary());
        return employeeService.saveEmployee(employee);
    }

    @GetMapping
    public List<Employee> getAllEmployees() {
        return employeeService.getAllEmployees();
    }

    @GetMapping("/{id}")
    public Employee getEmployeeById(@PathVariable Long id) {
        return employeeService.getEmployeeById(id);
    }

    @DeleteMapping("/{id}")
    public void deleteEmployee(@PathVariable Long id) { employeeService.deleteEmployee(id);
    }
}

package com.example.greetingapp.service;

import com.example.greetingapp.dto.EmployeeDTO;
import com.example.greetingapp.model.Employee;

import java.util.List;

public interface EmployeeService {
	Employee addEmployee(EmployeeDTO dto);
    List<Employee> getAllEmployees();
    Employee getEmployeeById(Long id);
    Employee updateEmployee(Long id, EmployeeDTO dto);
    void deleteEmployee(Long id);
}
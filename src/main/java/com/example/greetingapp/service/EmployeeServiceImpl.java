package com.example.greetingapp.service;

import com.example.greetingapp.dto.EmployeeDTO;
import com.example.greetingapp.exception.EmployeeNotFoundException;
import com.example.greetingapp.model.Employee;
import com.example.greetingapp.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class EmployeeServiceImpl implements EmployeeService{
	@Autowired
    private EmployeeRepository repository;

    @Override
    public Employee addEmployee(EmployeeDTO dto) {
        Employee emp = new Employee();
        emp.setName(dto.getName());
        emp.setDepartment(dto.getDepartment());
        emp.setSalary(dto.getSalary());
        return repository.save(emp);
    }

    @Override
    public List<Employee> getAllEmployees() {
        return repository.findAll();
    }

    @Override
    public Employee getEmployeeById(Long id) {
        return repository.findById(id)
                .orElseThrow(() -> new EmployeeNotFoundException("Employee not found with id: " + id));
    }

    @Override
    public Employee updateEmployee(Long id, EmployeeDTO dto) {
        Employee emp = getEmployeeById(id);
        emp.setName(dto.getName());
        emp.setDepartment(dto.getDepartment());
        emp.setSalary(dto.getSalary());
        return repository.save(emp);
    }

    @Override
    public void deleteEmployee(Long id) {
        repository.deleteById(id);
    }
}
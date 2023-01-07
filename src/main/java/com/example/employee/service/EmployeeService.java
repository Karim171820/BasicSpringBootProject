package com.example.employee.service;

import com.example.employee.model.Employee;
import com.example.employee.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeeService {
    @Autowired
    EmployeeRepository employeeRepository;

    public Employee createEmployee(Employee emp){
        return employeeRepository.save(emp);
    }

    public List<Employee> listEmployees (){
        return employeeRepository.findAll();
    }

    public void deleteEmployee (long emp_id){
        employeeRepository.deleteById(emp_id);
    }

    public Employee updateEmployee (long empId, Employee employeeDetails){
        Employee emp = employeeRepository.findById(empId).get();
        emp.setName(employeeDetails.getName());
        emp.setEmail(employeeDetails.getEmail());
        return employeeRepository.save(emp);
    }
}

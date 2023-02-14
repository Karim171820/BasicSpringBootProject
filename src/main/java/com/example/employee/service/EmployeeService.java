package com.example.employee.service;

import com.example.employee.model.Employee;
import com.example.employee.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import java.text.DateFormat;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.List;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

@Service
public class EmployeeService {
    @Autowired
    EmployeeRepository employeeRepository;

    public Employee createEmployee(Employee emp){
        return employeeRepository.save(emp);
    }
 @Scheduled(cron = "0 0 10 * * *")
    public List<Employee> listEmployees (){
    System.out.println("Function is exceuting...  Time :" + LocalTime.now());
        return employeeRepository.findAll();

    }

    public void deleteEmployee (long emp_id){
        employeeRepository.deleteById(emp_id);
    }
@Scheduled(fixedDelay = 5000)
    public Employee updateEmployee (long empId, Employee employeeDetails){
        Employee emp = employeeRepository.findById(empId).get();
        emp.setName(employeeDetails.getName());
        emp.setEmail(employeeDetails.getEmail());
        return employeeRepository.save(emp);
    }
}

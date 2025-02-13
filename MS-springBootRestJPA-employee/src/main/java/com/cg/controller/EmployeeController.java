package com.cg.controller;

import com.cg.dto.EmployeeDTO;
import com.cg.entity.*;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cg.service.IEmployeeService;

@RestController
@RequestMapping("/eapi")
public class EmployeeController 
{
    @Autowired
    IEmployeeService employeeService;
    
    @GetMapping("/employees")
    public List<Employee> getAllEmployees()
    {
    	return employeeService.findAllEmployees();
    }
    
    @GetMapping("/employees/{id}")
    public Employee getEmployeeById(@PathVariable int eid)
    {
    	return employeeService.findByEmployeeId(eid).get();
    }
    
    @PostMapping("/employees")
    public EmployeeDTO createEmployee(@RequestBody EmployeeDTO employeeDTO)
    {
    	Employee employee = employeeDTO.toEntity();
    	Employee em = employeeService.createNewEmployee(employee);
    	return employeeDTO.fromEntity(em);
    }
    
    @PutMapping("/employee/{id}")
    public Employee updateEmployee(@PathVariable int eid,@RequestBody Employee employee)
    {
    	Employee em=employeeService.findByEmployeeId(eid).get();
    	return employeeService.updateEmployee(em, employee);
    }
}

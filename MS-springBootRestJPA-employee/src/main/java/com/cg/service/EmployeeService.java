package com.cg.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cg.entity.Employee;
import com.cg.repository.EmployeeRepository;

@Service
public class EmployeeService implements IEmployeeService
{
    
	@Autowired
	EmployeeRepository employeeRepository;
	
	@Override
	public List<Employee> findAllEmployees()
	{
		return employeeRepository.findAll();
	}

	@Override
	public Optional<Employee> findByEmployeeId(int eid) 
	{
		return employeeRepository.findById(eid);
	}
	
	
	@Override
	public void deleteByEmployeeId(int eid) 
	{
	  employeeRepository.deleteById(eid);	
	}

	
	@Override
	public Employee createNewEmployee(Employee employee)
	{
		return employeeRepository.save(employee);
	}
	
	@Override
	public Employee updateEmployee(Employee em,Employee employee)
	{
		em.setEname(employee.getEname());
		em.setEsalary(employee.getEsalary());
		return em;
	}
	
}

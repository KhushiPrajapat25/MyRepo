package com.cg.service;

import java.util.List;
import java.util.Optional;

import com.cg.entity.Employee;

public interface IEmployeeService 
{
	public List<Employee> findAllEmployees();
    public Optional<Employee> findByEmployeeId(int eid);
    public void deleteByEmployeeId(int eid);
    public Employee createNewEmployee(Employee employee);
    public Employee updateEmployee(Employee em,Employee employee);

}

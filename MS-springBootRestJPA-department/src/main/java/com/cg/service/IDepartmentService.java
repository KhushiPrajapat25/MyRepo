package com.cg.service;

import java.time.LocalDate;

import com.cg.dto.DepartmentDTO;
import java.util.List;
import java.util.Optional;

import com.cg.entity.Department;

public interface IDepartmentService 
{
	public List<Department> findAllDepartments();
	public Optional<Department> findByDepartmentId(int did);
	
	public Department newDepartment(Department department);
	
	public void deleteByDepartmentId(int did);
	
	 public Department updateDepartment(Department dp,Department department);
}

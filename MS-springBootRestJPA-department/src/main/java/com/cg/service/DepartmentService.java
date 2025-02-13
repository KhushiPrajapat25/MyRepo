package com.cg.service;

import java.time.LocalDate;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cg.entity.Department;
import com.cg.repository.DepartmentRepository;

@Service
public class DepartmentService implements IDepartmentService 
{
	@Autowired
    DepartmentRepository departmentRepository;
	
    List<Department> departments=new ArrayList();
    
	@Override
	public List<Department> findAllDepartments() {
		return departmentRepository.findAll();
	}

	@Override
	public Optional<Department> findByDepartmentId(int did) {
		return departmentRepository.findById(did);
	}


	@Override
	public Department newDepartment(Department department) {
		return departmentRepository.save(department);
	}

	@Override
	public void deleteByDepartmentId(int did) 
	{
		departmentRepository.deleteById(did);
	}

	@Override
	public Department updateDepartment(Department dp, Department department) {
		dp.setDname(department.getDname());
		
		return dp;
	}
}

package com.cg.controller;
import com.cg.dto.DepartmentDTO;

import com.cg.entity.*;
import com.cg.exception.ResourceNotFoundException;
import com.cg.feign.DepartmentFeignClient;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.cg.service.IDepartmentService;

@RestController
@RequestMapping("/dapi")
public class DepartmentController 
{
	@Autowired
	IDepartmentService departmentService;

	@Autowired
	DepartmentFeignClient departmentFeignClient;
	
	@GetMapping(path="/departments", produces = {MediaType.APPLICATION_JSON_VALUE})
	public List<Department> getAllDepartments()
	{
		return departmentService.findAllDepartments();
	}
	
	@GetMapping("/departments/{id}")
	public Department getDepartmentById(@PathVariable int did) throws ResourceNotFoundException
	{
		return departmentService.findByDepartmentId(did)
				.orElseThrow(()->new ResourceNotFoundException("Department not found with this id "+did));
	}
	
	
	@DeleteMapping("/departments/{id}")
	public void deleteDepartmentById(@PathVariable int did)
	{
		departmentService.deleteByDepartmentId(did);
	}
	
	@PostMapping("/departments")
	public DepartmentDTO createOrder(@RequestBody DepartmentDTO departmentDTO)
	{
		Department department=departmentDTO.toEntity();
		Department dp = departmentService.newDepartment(department);
		return departmentDTO.fromEntity(dp);
	}
	
	
	@PutMapping("/departments/{id}")
	public Department updateTheDepartment(@PathVariable int did,@RequestBody Department department)
	{
		Department dp = departmentService.findByDepartmentId(did).get();
		return departmentService.updateDepartment(dp, department);
	}
	
	@GetMapping("/allemp")
	public ResponseEntity<String> getEmployees()
	{
		return ResponseEntity.ok().body(departmentFeignClient.employeeResponse());
	}
	
}

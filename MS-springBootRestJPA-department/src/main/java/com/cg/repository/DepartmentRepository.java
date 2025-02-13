package com.cg.repository;

import java.time.LocalDate;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.cg.entity.Department;

@Repository

public interface DepartmentRepository extends JpaRepository<Department,Integer>
{
	
}

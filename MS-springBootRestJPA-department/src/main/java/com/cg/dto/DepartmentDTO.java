package com.cg.dto;

import java.time.LocalDate;

import com.cg.entity.Department;

public class DepartmentDTO 
{
   private int did;
   private String dname;
   
   
public DepartmentDTO() {
	super();
	// TODO Auto-generated constructor stub
}



public DepartmentDTO(int did, String dname) {
	super();
	this.did = did;
	this.dname = dname;
}

   
public int getDid() {
	return did;
}



public void setDid(int did) {
	this.did = did;
}



public String getDname() {
	return dname;
}



public void setDname(String dname) {
	this.dname = dname;
}



public static DepartmentDTO fromEntity(Department department) {
    return new DepartmentDTO(department.getDid(),department.getDname());
}

public Department toEntity() {
    return new Department(this.did,this.dname);
}

}

package com.cg.dto;

import com.cg.entity.Employee;

public class EmployeeDTO 
{
   private int eid;
   private String ename;
   private double esalary;
public EmployeeDTO() {
	super();
	// TODO Auto-generated constructor stub
}
public EmployeeDTO(int eid, String ename, double esalary) {
	super();
	this.eid = eid;
	this.ename = ename;
	this.esalary = esalary;
}
public int getEid() {
	return eid;
}
public void setEid(int eid) {
	this.eid = eid;
}
public String getEname() {
	return ename;
}
public void setEname(String ename) {
	this.ename = ename;
}
public double getEsalary() {
	return esalary;
}
public void setEsalary(double esalary) {
	this.esalary = esalary;
}
@Override
public String toString() {
	return "EmployeeDTO [eid=" + eid + ", ename=" + ename + ", esalary=" + esalary + "]";
}
   
   public static EmployeeDTO fromEntity(Employee employee)
   {
	   return new EmployeeDTO(employee.getEid(),employee.getEname(),employee.getEsalary());
   }
   
   public Employee toEntity()
   {
	   return new Employee(this.eid,this.ename,this.esalary);
   }
}

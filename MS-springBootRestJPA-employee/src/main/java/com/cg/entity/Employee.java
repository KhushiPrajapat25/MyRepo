package com.cg.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "employeeEureka")
public class Employee 
{
   @Id
   @GeneratedValue(strategy = GenerationType.AUTO)
   private int eid;
   
   @Column(name = "ename")
   private String ename;
   
   @Column(name = "esalary")
	private double esalary;

public Employee() {
	super();
	// TODO Auto-generated constructor stub
}

public Employee(int eid, String ename, double esalary) {
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
	return "Employee [eid=" + eid + ", ename=" + ename + ", esalary=" + esalary + "]";
}
   
   
}

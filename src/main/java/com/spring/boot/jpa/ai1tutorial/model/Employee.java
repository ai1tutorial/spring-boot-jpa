package com.spring.boot.jpa.ai1tutorial.model;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Employee implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	
	@Id
	@GeneratedValue
	private int id;
	
	String empName;
	String empId;
	
	
	
	public Employee() {
		super();
	}


	public Employee(String empName, String empId) {
		super();
		this.empName = empName;
		this.empId = empId;
	}
	
	
	public String getEmpName() {
		return empName;
	}
	public void setEmpName(String empName) {
		this.empName = empName;
	}
	public String getEmpId() {
		return empId;
	}
	public void setEmpId(String empId) {
		this.empId = empId;
	}
	
	
}
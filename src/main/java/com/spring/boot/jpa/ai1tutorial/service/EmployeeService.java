package com.spring.boot.jpa.ai1tutorial.service;

import java.util.List;

import javax.validation.Valid;

import com.spring.boot.jpa.ai1tutorial.model.Employee;

public interface EmployeeService {

	Employee getEmployeeByid(Integer emcId) throws Exception ;

	Employee createEmployee(@Valid Employee Employee);

	void deleteEmployee(Employee Employee);

	List<Employee> findAll();

}
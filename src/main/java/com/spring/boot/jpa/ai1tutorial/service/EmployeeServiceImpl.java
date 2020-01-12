package com.spring.boot.jpa.ai1tutorial.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.spring.boot.jpa.ai1tutorial.model.Employee;
import com.spring.boot.jpa.ai1tutorial.repo.EmployeeRepository;




@Service
public class EmployeeServiceImpl implements EmployeeService {
	

	@Autowired
	private EmployeeRepository employeeRepository;
	
	@Override
	public List<Employee> findAll() {
		return employeeRepository.findAll();
	}
	
	
	@Override
	public Employee getEmployeeByid(Integer employeeId) throws Exception  {
		return employeeRepository
        .findById(employeeId)
        .orElseThrow(() -> new Exception("Employee not found on :: " + employeeId));
	}
	
	@Override
	public Employee createEmployee(Employee Employee) {
		 return employeeRepository.save(Employee);
	}
	
	@Override
	public void deleteEmployee(Employee Employee) {
		 employeeRepository.delete(Employee);
	}

}

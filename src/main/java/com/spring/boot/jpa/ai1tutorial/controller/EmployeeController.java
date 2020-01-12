package com.spring.boot.jpa.ai1tutorial.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.spring.boot.jpa.ai1tutorial.model.Employee;
import com.spring.boot.jpa.ai1tutorial.service.EmployeeService;


@RequestMapping("/ai1tutorial")
@RestController
public class EmployeeController {
	


	 @Autowired
	  private EmployeeService employeeService;
	  /**
	   * Get all Employees list.
	   *
	   * @return the list
	   */
	  @GetMapping("/Employees")
	  public List<Employee> getAllEmployees() {
	    return employeeService.findAll();
	  }

	  /**
	   * Gets Employees by id.
	   *
	   * @param EmployeeId the Employee id
	   * @return the Employees by id
	   * @throws Exception the resource not found exception
	   */
	  @GetMapping("/Employees/{id}")
	  public ResponseEntity<Employee> getEmployeesById(@PathVariable(value = "id") Integer EmployeeId)
	      throws Exception {
	        Employee Employee = employeeService.getEmployeeByid(EmployeeId);
	    return ResponseEntity.ok().body(Employee);
	  }

	  /**
	   * Create Employee Employee.
	   *
	   * @param Employee the Employee
	   * @return the Employee
	   */
	  @PostMapping("/createEmployee")
	  public Employee createEmployee(@Valid @RequestBody Employee Employee) {
	    return employeeService.createEmployee(Employee);
	  }
	  

	  /**
	   * Update Employee response entity.
	   *
	   * @param EmployeeId the Employee id
	   * @param employeeDetails the Employee details
	   * @return the response entity
	   * @throws ResourceNotFoundException the resource not found exception
	   */
	  @PutMapping("/Employees/{id}")
	  public ResponseEntity<Employee> updateEmployee(
	      @PathVariable(value = "id") Integer EmployeeId, @Valid @RequestBody Employee employeeDetails)
	      throws Exception {

	    Employee employee = employeeService.getEmployeeByid(EmployeeId);
	    employee.setEmpId(employeeDetails.getEmpId());
	    employee.setEmpName(employeeDetails.getEmpName());
	    final Employee updatedEmployee = employeeService.createEmployee(employee);
	    return ResponseEntity.ok(updatedEmployee);
	  }

	  /**
	   * Delete Employee map.
	   *
	   * @param EmployeeId the Employee id
	   * @return the map
	   * @throws Exception the exception
	   */
	  @DeleteMapping("/Employees/{id}")
	  public Map<String, Boolean> deleteEmployee(@PathVariable(value = "id") Integer EmployeeId) throws Exception {
	    Employee Employee = employeeService.getEmployeeByid(EmployeeId);
	    employeeService.deleteEmployee(Employee);
	    Map<String, Boolean> response = new HashMap<>();
	    response.put("deleted", Boolean.TRUE);
	    return response;
	  }


}

package com.spring.boot.jpa.ai1tutorial.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.spring.boot.jpa.ai1tutorial.model.Employee;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Integer> {}

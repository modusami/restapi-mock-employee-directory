package com.mike.mock_employee_directory.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


import com.mike.mock_employee_directory.entity.Employee;
import com.mike.mock_employee_directory.service.EmployeeService;

@RestController
@RequestMapping("/v1")
public class EmployeeRestController {
	
	private EmployeeService employeeService;
	
	@Autowired
	public EmployeeRestController(@Qualifier("employeeServiceImp") EmployeeService employeeService) {
		this.employeeService = employeeService;
	}
	
	@GetMapping("/employees")
	public List<Employee> getEmployees(){
		return employeeService.findAll();
	}
	
}

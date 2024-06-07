package com.mike.mock_employee_directory.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
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
	
	@GetMapping("/employees/{empid}")
	public Employee getEmployee(@PathVariable Integer empid) {
		Employee employee = employeeService.findById(empid);
		if (employee == null) {
			throw new RuntimeException("Employee of id {" + empid + "} not found.");
		}
		return employee;
	}
	
	@PostMapping("/employees")
	public Employee addEmployee(@RequestBody Employee theEmployee) {
		theEmployee.setId(0);
		Employee dbEmployee = employeeService.save(theEmployee);
		return dbEmployee;
	}
	
	@PutMapping("/employees")
	public Employee updateEmployee(@RequestBody Employee theEmployee) {
		return employeeService.save(theEmployee);
	}
	
	@DeleteMapping("/employees/{id}")
	public void deleteEmployee(@PathVariable Integer id) {
		employeeService.delete(id);
	}
	
}

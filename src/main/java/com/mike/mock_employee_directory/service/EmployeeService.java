package com.mike.mock_employee_directory.service;

import java.util.List;

import com.mike.mock_employee_directory.entity.Employee;

public interface EmployeeService {
	
	public List<Employee> findAll();
	public Employee findById(Integer idn);
	public Employee save(Employee theEmployee);
	public void delete(Integer id);
}


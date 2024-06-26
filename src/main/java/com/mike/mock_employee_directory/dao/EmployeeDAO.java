package com.mike.mock_employee_directory.dao;

import java.util.List;

import com.mike.mock_employee_directory.entity.Employee;

public interface EmployeeDAO {
	
	public List<Employee> findAll();
	public Employee findById(Integer idn);
	public Employee save(Employee theEmployee);
	public void delete(Integer id);
}

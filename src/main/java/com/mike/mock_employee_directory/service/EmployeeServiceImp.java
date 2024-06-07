package com.mike.mock_employee_directory.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.mike.mock_employee_directory.dao.EmployeeDAO;
import com.mike.mock_employee_directory.entity.Employee;

@Service
public class EmployeeServiceImp implements EmployeeService {
	
	private EmployeeDAO employeeDAO;
	
	@Autowired
	public EmployeeServiceImp(@Qualifier("employeeDAOImp") EmployeeDAO employeeDAO) {
		this.employeeDAO = employeeDAO;
	}

	@Override
	public List<Employee> findAll() {
		return employeeDAO.findAll();
	}

}

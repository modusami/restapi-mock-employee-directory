package com.mike.mock_employee_directory.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import com.mike.mock_employee_directory.entity.Employee;

// using this as the current DAO | simplifies the DAO to prevent code from being written
// compared to the old DAOs in this package
@RepositoryRestResource(path = "members")
public interface EmployeeRepository extends JpaRepository<Employee, Integer> {

}

package com.mike.mock_employee_directory.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.mike.mock_employee_directory.entity.Employee;

import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;

@Repository
public class EmployeeDAOImp implements EmployeeDAO {
	
	private EntityManager entityManager;
	
	@Autowired
	public EmployeeDAOImp(EntityManager entityManager) {
		this.entityManager = entityManager;
	}

	@Override
	public List<Employee> findAll() {
		TypedQuery<Employee> theQuery = entityManager.createQuery("FROM Employee", Employee.class);
		return theQuery.getResultList();
	}

	@Override
	public Employee findById(Integer id) {
		Employee employee = entityManager.find(Employee.class, id);
		return employee;
	}

	@Override
	public Employee save(Employee theEmployee) {
		Employee dbEmployee = entityManager.merge(theEmployee); // merge performs a save or update unless the id == 0
		// if id == 0, it will be an insert else it will be an update
		return dbEmployee; // has the updated id after the merge
	}

	@Override
	public void delete(Integer id) {
		Employee dbEmployee = entityManager.find(Employee.class, id);
		entityManager.remove(dbEmployee);
	}

}

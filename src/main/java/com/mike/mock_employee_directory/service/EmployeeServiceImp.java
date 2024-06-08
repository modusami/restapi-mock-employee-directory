//package com.mike.mock_employee_directory.service;
//
//import java.util.List;
//import java.util.Optional;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.beans.factory.annotation.Qualifier;
//import org.springframework.stereotype.Service;
//
//import com.mike.mock_employee_directory.dao.EmployeeDAO;
//import com.mike.mock_employee_directory.dao.EmployeeRepository;
//import com.mike.mock_employee_directory.entity.Employee;
//
//import jakarta.transaction.Transactional;
//
//@Service
//public class EmployeeServiceImp implements EmployeeService {
//	
//	private EmployeeRepository employeeRepository;
//	
//	@Autowired
//	public EmployeeServiceImp(EmployeeRepository employeeRepository) {
//		this.employeeRepository = employeeRepository;
//	}
//
//	@Override
//	public List<Employee> findAll() {
//		return employeeRepository.findAll();
//	}
//
//	@Override
//	public Employee findById(Integer idn) {
//		Optional<Employee> resultOptional = employeeRepository.findById(idn);
//		Employee theEmployee = null;
//		if(resultOptional.isPresent()) {
//			theEmployee = resultOptional.get();
//		}
//		else {
//			throw new RuntimeException("Did not find employee with id of {" + idn + "}.");
//		}
//		return theEmployee;
//	}
//
//	//@Transactional - not needed | JPA provides this functionality out of the box
//	@Override
//	public Employee save(Employee theEmployee) {
//		return employeeRepository.save(theEmployee);
//	}
//
//	//@Transactional - not needed | JPA provides this functionality out of the box
//	@Override
//	public void delete(Integer id) {
//		employeeRepository.deleteById(id);
//	}
//
//}

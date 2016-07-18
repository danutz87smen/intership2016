package com.internship.services;

import java.util.List;

import com.internship.model.Employee;

public interface IEmployeeService {

	Employee getEmployeeById(Long id);
	void persistEmployee(Employee emp);
	void saveEmployee(Employee emp);
	void deleteEmployeeById(Long id);
	List<Employee>getEmployees();
	
}

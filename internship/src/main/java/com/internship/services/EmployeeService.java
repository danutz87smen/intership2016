package com.internship.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.internship.dao.EmployeeDao;
import com.internship.model.Employee;

@Service
@Transactional
public class EmployeeService implements IEmployeeService{
	@Autowired
	private EmployeeDao employeeService;

	@Override
	public Employee getEmployeeById(Long id) {
		return employeeService.getEntityById(id);
		}

	@Override
	public void persistEmployee(Employee emp) {
		employeeService.createEntity(emp);		
	}

	@Override
	public void saveEmployee(Employee emp) {
		employeeService.updateEntity(emp);
	}

	@Override
	public void deleteEmployeeById(Long id) {
		employeeService.deleteEmployeeById(id);
	}

	@Override
	public List<Employee> getEmployees() {
		return employeeService.findAllEmployees();
	}
}

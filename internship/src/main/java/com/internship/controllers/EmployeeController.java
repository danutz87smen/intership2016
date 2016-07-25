package com.internship.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.internship.model.Employee;
import com.internship.services.IEmployeeService;

@RestController
public class EmployeeController {
	@Autowired
	private IEmployeeService service;
	
	@RequestMapping(value = "/employees/", method = RequestMethod.GET)
	public ResponseEntity<List<Employee>> getAllEmployee() {
		List<Employee> emps = service.getEmployees();
		return new ResponseEntity<List<Employee>>(emps, HttpStatus.OK);
	}

	@RequestMapping(value = "/employees/{id}", method = RequestMethod.GET)
	public ResponseEntity<Employee> getcategoryById(@PathVariable long id) {
		Employee emp = service.getEmployeeById(id);
		if (emp == null) {
			new ResponseEntity<Employee>(HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<Employee>(emp, HttpStatus.OK);
	}

	@RequestMapping(value = "/employees/{id}", method = RequestMethod.PUT)
	public ResponseEntity<Employee> updatecategory(@PathVariable long id, @RequestBody Employee emp) {
		Employee originalEmp = service.getEmployeeById(id);
		originalEmp.setName(emp.getName());
		originalEmp.setSurName(emp.getSurName());
		originalEmp.setEmail(emp.getEmail());
		originalEmp.setPhone(emp.getPhone());
		originalEmp.setBirthDate(emp.getBirthDate());
		service.saveEmployee(originalEmp);
		return new ResponseEntity<Employee>(originalEmp, HttpStatus.OK);
	}

	// @RequestMapping(value = "/employees/{id}", method = RequestMethod.DELETE)
	// public ResponseEntity<Employee> deletecategory(@PathVariable int id) {
	// try {
	// service.ge(id);
	// return new ResponseEntity<Employee>(HttpStatus.NO_CONTENT);
	// } catch (ModelNotFoundException e) {
	// return new ResponseEntity<Employee>(HttpStatus.NOT_FOUND);
	// }
	// }
	//
	@RequestMapping(value = "/employees/", method = RequestMethod.POST)
	public ResponseEntity<Employee> createcategory(@RequestBody Employee emp) {
		service.persistEmployee(emp);
		return new ResponseEntity<Employee>(emp, HttpStatus.CREATED);
	}
}

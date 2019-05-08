package com.capgemini.inheritancemapping.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.capgemini.inheritancemapping.entity.Employee;
import com.capgemini.inheritancemapping.service.EmployeeService;

@RestController
public class InheritanceController {
	
	@Autowired
	EmployeeService service;
	
	
	@RequestMapping("/")
	public void addNewEmployee() {
		Employee employee = new Employee(20000,2000,101,"Bikram");
		service.addNew(employee);
	}
	
	@RequestMapping("/new")
	public Employee getEmployee() {
		
		return service.getById(101);
		
	}

}

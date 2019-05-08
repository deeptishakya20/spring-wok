package com.capgemini.manytomany.controller;

import java.util.HashSet;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.capgemini.manytomany.entity.Employee;
import com.capgemini.manytomany.entity.Project;
import com.capgemini.manytomany.service.EmployeeService;

@RestController
public class ManyToManyController {
	
	@Autowired
	private EmployeeService service;
	
	@RequestMapping("/")
	public void addNew() {
		
		Set<Employee> employeeSet1 = new HashSet<Employee>();
		Set<Employee> employeeSet2 = new HashSet<Employee>();
		Set<Employee> employeeSet3 = new HashSet<Employee>();

		Set<Project> projectSet1 = new HashSet<Project>();
		Set<Project> projectSet2 = new HashSet<Project>();
		Set<Project> projectSet3 = new HashSet<Project>();

		Employee employee1 = new Employee(101,"Deepti");
		Employee employee2 = new Employee(102,"Bikram");
		Employee employee3 = new Employee(103,"Payal");
		
		Project project1 = new Project(201,"AWS");
		Project project2 = new Project(202, "Java");
		Project project3 = new Project(202, "Python");

		employeeSet1.add(employee1);
		employeeSet1.add(employee2);
		employeeSet2.add(employee3);
		employeeSet3.add(employee1);
		
		project1.setEmployee(employeeSet1);
		project2.setEmployee(employeeSet2);
		project3.setEmployee(employeeSet3);
		
		projectSet1.add(project1);
		projectSet1.add(project3);
		projectSet2.add(project1);
		projectSet3.add(project2);
		
		service.addNewEmployee(employeeSet1);
		service.addNewEmployee(employeeSet2);
		service.addNewEmployee(employeeSet3);
		service.addNewProject(projectSet1);
		service.addNewProject(projectSet2);
		service.addNewProject(projectSet3);
		
	}
	
	
	@RequestMapping("/new")
	public Set<Employee> getEmployee() {
		Set<Employee> employee = new HashSet<Employee>();
		
		for(int i = 101; i<=103; i++) {
			employee.add(service.getEmployeeById(i));
		}
		return employee;
		
	}

}

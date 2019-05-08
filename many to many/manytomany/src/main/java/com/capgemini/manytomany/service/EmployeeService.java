package com.capgemini.manytomany.service;

import java.util.Set;

import com.capgemini.manytomany.entity.Employee;
import com.capgemini.manytomany.entity.Project;

public interface EmployeeService {
	
	public void addNewEmployee(Set<Employee> employee);
	public void addNewProject(Set<Project> project);
	public Employee getEmployeeById(int EmployeeId);
}

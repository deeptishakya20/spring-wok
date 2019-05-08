package com.capgemini.onetomany.service;

import com.capgemini.onetomany.employee.Employee;

public interface EmployeeSerivce {
	
	public void addNew(Employee employee);
	Employee getById(int EmployeeId);

}

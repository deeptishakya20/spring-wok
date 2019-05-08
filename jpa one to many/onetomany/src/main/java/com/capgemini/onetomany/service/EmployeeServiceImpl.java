package com.capgemini.onetomany.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.capgemini.onetomany.dao.EmployeeDao;
import com.capgemini.onetomany.employee.Employee;

@Service
public class EmployeeServiceImpl implements EmployeeSerivce {
	
	@Autowired
	private EmployeeDao dao;

	@Override
	public void addNew(Employee employee) {
		dao.save(employee);
	}

	@Override
	public Employee getById(int EmployeeId) {
		return dao.findById(EmployeeId).get();
	}

}
package com.capgemini.inheritancemapping.entity;

import javax.persistence.Entity;
import javax.persistence.PrimaryKeyJoinColumn;

@Entity
@PrimaryKeyJoinColumn(name="ID")
public class Employee extends Person {
	
	private int employeeId;
	private String employeeName;
	
	public Employee() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Employee(double salary, double bonus,int employeeId, String employeeName) {
		super(salary, bonus);
		this.employeeId = employeeId;
		this.employeeName = employeeName;
	}

	public int getEmployeeId() {
		return employeeId;
	}
	public void setEmployeeId(int employeeId) {
		this.employeeId = employeeId;
	}
	public String getEmployeeName() {
		return employeeName;
	}
	public void setEmployeeName(String employeeName) {
		this.employeeName = employeeName;
	}
	
	@Override
	public String toString() {
		return "Employee [employeeId=" + employeeId + ", employeeName=" + employeeName +", salary="+ getSalary()+", bonus="+getBonus()+  "]";
	}

	
	
	
	

}

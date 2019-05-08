package com.capgemini.inheritancemapping.entity;

import javax.persistence.Entity;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;

@Entity
@Inheritance(strategy=InheritanceType.JOINED)  

public class Person {
	
	private double salary;
	private double bonus;
	
	public Person() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Person(double salary, double bonus) {
		super();
		this.salary = salary;
		this.bonus = bonus;
	}
	public double getSalary() {
		return salary;
	}
	public void setSalary(double salary) {
		this.salary = salary;
	}
	public double getBonus() {
		return bonus;
	}
	public void setBonus(double bonus) {
		this.bonus = bonus;
	}
	
	@Override
	public String toString() {
		return "Person [salary=" + salary + ", bonus=" + bonus + "]";
	}
	
	

}

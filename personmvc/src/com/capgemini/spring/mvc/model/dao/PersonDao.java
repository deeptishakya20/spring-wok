package com.capgemini.spring.mvc.model.dao;

import java.util.List;

import com.capgemini.spring.mvc.model.entity.Person;

public interface PersonDao {
	
	public void addNew(Person person);
	public List<Person> getAll();
	public boolean update(Person person);
	public boolean delete(Person person);
	public Person getPerson(int personId);
	
	
}

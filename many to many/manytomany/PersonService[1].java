package com.capgemini.onetomanyjpa.service;

import com.capgemini.onetomanyjpa.entity.Person;

public interface PersonService {
	public void addNew(Person person);
	public Person findPersonById(int id);
}

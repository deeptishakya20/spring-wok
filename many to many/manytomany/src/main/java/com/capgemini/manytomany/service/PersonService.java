package com.capgemini.manytomany.service;

import java.util.Set;

import com.capgemini.manytomany.entity.Person;
import com.capgemini.manytomany.entity.Project;



public interface PersonService {
	
	public void addNewPerson(Set<Person> person);
	public void addNewProject(Set<Project> project);
	public Person findPersonById(int id);

}

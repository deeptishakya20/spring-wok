package com.example.onetoonemappingjpa.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.onetoonemappingjpa.person.Person;
import com.example.onetoonemappingjpa.profile.Profile;
import com.example.onetoonemappingjpa.dao.PersonDao;

@RestController
public class PersonController {

	@Autowired
	private PersonDao dao;

	@RequestMapping("/")
	public void addNew() {
		Person person= new Person(101,"deepti",new Profile(301,"analyst"));
	    dao.save(person);
		
	}
	
	@RequestMapping("/new")
	public Person findAll() {
		Person person = dao.findById(101).get();
		return person;
		
	}
	
}

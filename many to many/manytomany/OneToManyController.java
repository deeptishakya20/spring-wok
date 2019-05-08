package com.capgemini.onetomanyjpa.controller;

import java.util.HashSet;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.capgemini.onetomanyjpa.entity.Certificate;
import com.capgemini.onetomanyjpa.entity.Person;
import com.capgemini.onetomanyjpa.service.PersonService;
@RestController
public class OneToManyController {
	
	@Autowired
	private PersonService service;
	
	
	/*
	 * @RequestMapping("/") public String home() { return "hello"; }
	 */
	
	@RequestMapping("/")
	public void setPerson()
	{
		Set<Certificate> certificate = new HashSet<Certificate>();
		certificate.add(new Certificate(301,"AWS"));
		certificate.add(new Certificate(302,"Java"));
		//person.setCertificate(certificate);
		Person person = new Person(101, "Ruchir", certificate);
		service.addNew(person);
	}
	
	@RequestMapping("/new")
	public Person getPerson()
	{
		Person person = service.findPersonById(101);
		return person;
	}
}

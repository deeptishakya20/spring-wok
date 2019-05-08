package com.capgemini.jpasimplemapping.controller;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.capgemini.jpasimplemapping.person.Person;
import com.capgemini.jpasimplemapping.service.PersonService;
import com.capgemini.jpasimplemapping.service.impl.PersonServiceImpl;

import antlr.collections.List;

@RestController
public class PersonController {
	
	@Autowired
	PersonService service;
	
	@RequestMapping("/")
	public String addOne() {
		Person person = new Person(101,"Deepti");
		service.addNewPerson(person);
		return "Hello";
		
		}
	
	@RequestMapping("/get")
	public Person getPerson() {
		Person person = service.getPerson(101);
		return person;
		
	}
	
	
	@RequestMapping("/delete")
	public ResponseEntity<HttpStatus> deletePerson() {
		service.deletePerson(101);
		return new ResponseEntity<HttpStatus>(HttpStatus.OK);
		
	}
	
	
	
	
	

}

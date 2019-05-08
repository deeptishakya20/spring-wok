package com.capgemini.jpasimplemapping.service.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.capgemini.jpasimplemapping.dao.PersonDao;
import com.capgemini.jpasimplemapping.person.Person;
import com.capgemini.jpasimplemapping.service.PersonService;

@Service
public  class PersonServiceImpl implements PersonService {
	
	@Autowired
	PersonDao dao;
	

	@Override
	public void addNewPerson(Person person) {
		dao.save(person);
	}
	
	@Override
	
	public Person getPerson(int personId) {
		
		Optional<Person> opt = dao.findById(personId);
		Person person = opt.get();
		
		return person;
		
		
	}

	public boolean deletePerson(int personId) {
		
		Optional<Person> person = dao.findById(personId);
		if(person == null)
			return false;
		
		 dao.deleteById(personId);
		 return true;
	}

	@Override
	public boolean updatePerson(int personId, String personName) {
		Optional<Person> person = dao.findById(personId);
		if(person==null)
			return false;

		
	}

//	@Override
//	public ArrayList<Person> findAllPerson() {
//		ArrayList<Person> person = (ArrayList<Person>) dao.findAll();
//		
//		if(person!=null)
//			return person;
//		return null; 
//	}


	
	
		

}

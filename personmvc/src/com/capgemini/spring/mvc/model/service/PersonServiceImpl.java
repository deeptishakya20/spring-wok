package com.capgemini.spring.mvc.model.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.capgemini.spring.mvc.model.dao.PersonDao;
import com.capgemini.spring.mvc.model.entity.Person;

@Service
public class PersonServiceImpl implements PersonService{

	
	@Autowired
	private PersonDao dao;
	
	
	@Override
	public void addNew(Person person) {
		
		
	}

	@Override
	public List<Person> getall() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void update(Person person) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void delete(int personId) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Person getPerson(int personId) {
		// TODO Auto-generated method stub
		return null;
	}

	
	
	

}

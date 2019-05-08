package com.capgemini.onetomanyjpa.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.capgemini.onetomanyjpa.dao.PersonDao;
import com.capgemini.onetomanyjpa.entity.Person;
@Service
public class PersonServiceImpl implements PersonService {

	@Autowired
	private PersonDao dao;
	@Override
	public void addNew(Person person) {
		dao.save(person);

	}

	@Override
	public Person findPersonById(int id) {
		Person person = dao.findById(id).get();
		System.out.println(person);
		return person;
	}

}

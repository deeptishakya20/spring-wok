package com.capgemini.jpasimplemapping.dao;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.capgemini.jpasimplemapping.person.Person;

@Repository
public interface PersonDao extends JpaRepository<Person, Integer>{
	

}

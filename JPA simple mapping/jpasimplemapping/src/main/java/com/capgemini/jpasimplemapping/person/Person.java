package com.capgemini.jpasimplemapping.person;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Person {
	
	int personId;
	String personName;
	
	public Person() {
		super();
	}

	public Person(int personId, String personName) {
		super();
		this.personId = personId;
		this.personName = personName;
	}

	@Id
	public int getPersonId() {
		return personId;
	}

	public void setPersonId(int personId) {
		this.personId = personId;
	}

	public String getPersonName() {
		return personName;
	}

	public void setPersonName(String personName) {
		this.personName = personName;
	}
	
	public String toString() {
		return personId+" "+personName;
	}
	

}

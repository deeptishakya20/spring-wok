package com.capgemini.main;

import com.capgemini.exception.AgeNotWithinRangeException;
import com.capgemini.name_exception.NameNotValidException;

public class StudentException {

	private int rollNumber;
	private String name;
	private int age;
	private String course;

	public StudentException() {
		super();

	}

	public StudentException(int rollNumber, String name, int age, String course)throws AgeNotWithinRangeException, NameNotValidException {
		super();
		this.rollNumber = rollNumber;

		if (age > 15 && age < 21)
			this.age = age;
		else
			throw new AgeNotWithinRangeException();
		
		for (int i = 0; i < name.length(); i++) {
			if ((name.charAt(i) < 65 || name.charAt(i) > 90) && (name.charAt(i) < 97 || name.charAt(i) > 122)) {
				
				throw new NameNotValidException();
			}
		}
		this.name = name;

		this.course = course;

	}

}

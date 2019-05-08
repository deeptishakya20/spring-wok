package com.capgemini.student.test;
import static org.junit.Assert.assertNotNull;

import org.junit.Test;

import com.capgemini.student.exception.AgeNotWithinRangeException;

import com.capgemini.student.exception.NameNotValidException;
import com.capgemini.student.main.Student;




public class StudentTest{

	Student student=new Student();

	@Test
	public void testStudentAgewithinRange() throws AgeNotWithinRangeException, NameNotValidException {
		Student student=new Student(21,"Ram",18,"Java");
		assertNotNull(student);
		
	}

	@Test(expected = AgeNotWithinRangeException.class)
	public void testStudentAgewithNotInRange() throws AgeNotWithinRangeException, NameNotValidException {
		Student student=new Student(21,"Ram",28,"Java");		
		assertNotNull(student);
	}

	@Test(expected = NameNotValidException.class)
	public void testStudentNameIsInValid() throws NameNotValidException, AgeNotWithinRangeException{
		Student student=new Student(21,"Raj12@",17,"Java");
		assertNotNull(student);
	}

}

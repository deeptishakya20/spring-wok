package com.capgemini.test;
import static org.junit.Assert.assertNotNull;

import org.junit.Test;

import com.capgemini.exception.AgeNotWithinRangeException;

import com.capgemini.main.StudentException;
import com.capgemini.name_exception.NameNotValidException;




public class StudentExceptionTest {

	StudentException student=new StudentException();

	@Test
	public void testStudentAgewithinRange() throws AgeNotWithinRangeException, NameNotValidException {
		StudentException student=new StudentException(21,"Ram",18,"Java");
		assertNotNull(student);
		
	}

	@Test(expected = AgeNotWithinRangeException.class)
	public void testStudentAgewithNotInRange() throws AgeNotWithinRangeException, NameNotValidException {
		StudentException student=new StudentException(21,"Ram",28,"Java");		
		assertNotNull(student);
	}

	@Test(expected = NameNotValidException.class)
	public void testStudentNameIsInValid() throws NameNotValidException, AgeNotWithinRangeException{
		StudentException student=new StudentException(21,"Raj12@",17,"Java");
		assertNotNull(student);
	}

}

package com.capgemini.demo.test;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.doThrow;
import static org.mockito.Mockito.when;

import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import com.capgemini.demo.demo.MathApplication;
import com.capgemini.demo.service.CalculatorService;

public class TestMathApplication {

	
	@Mock
	private CalculatorService service;
	
	@InjectMocks
	MathApplication application = new MathApplication(service);
	
	
	@Before
	public void setUp() {
		MockitoAnnotations.initMocks(this);
	}
	
	@Test
	public void TestAdditionWithTwoPositiveInteger() {
		when(service.addition(5,5)).thenReturn(10);
		assertEquals(10, application.performAddition(5,5));
	}
	
	@Test
	public void TestAdditionWithTwoNegativeInteger() {
		when(service.addition(-5,-3)).thenReturn(-8);
		assertEquals(-8, application.performAddition(-5,-3));
	}
	
	@Test
	public void TestAdditionWithOneNegativeAndOnePositiveInteger() {
		when(service.addition(-7,3)).thenReturn(-4);
		assertEquals(-4, application.performAddition(-7,3));
	}
	
	
	@Test
	public void TestAdditionWithOneZeroAndOneNonZenoInteger() {
		when(service.addition(7,0)).thenReturn(7);
		assertEquals(7, application.performAddition(7,0));
	}
	
	
	@Test
	public void TestSubtractionWithTwoPositiveInteger() {
		when(service.subtraction(6,5)).thenReturn(1);
		assertEquals(1, application.performSubtraction(6,5));
	}
	
	@Test
	public void TestSubtractionWithTwoNegativeInteger() {
		when(service.subtraction(-5,-3)).thenReturn(-2);
		assertEquals(-2, application.performSubtraction(-5,-3));
	}
	
	@Test
	public void TestSubtractionWithOneNegativeAndOnePositiveInteger() {
		when(service.subtraction(-7,3)).thenReturn(-11);
		assertEquals(-11, application.performSubtraction(-7,3));
	}
	
	
	@Test
	public void TestSubtractionWithOneZeroAndOneNonZenoInteger() {
		when(service.subtraction(7,0)).thenReturn(7);
		assertEquals(7, application.performSubtraction(7,0));
	}
	
	@Test
	public void TestMultiplicationWithTwoPositiveInteger() {
		when(service.multiplication(5,5)).thenReturn(25);
		assertEquals(25, application.performMultiplication(5,5));
	}
	
	@Test
	public void TestMultiplicationWithTwoNegativeInteger() {
		when(service.multiplication(-5,-3)).thenReturn(15);
		assertEquals(15, application.performMultiplication(-5,-3));
	}
	
	@Test
	public void TestMultiplicationWithOneNegativeAndOnePositiveInteger() {
		when(service.multiplication(-7,3)).thenReturn(-21);
		assertEquals(-21, application.performMultiplication(-7,3));
	}
	
	
	@Test
	public void TestMultiplicationWithOneZeroAndOneNonZenoInteger() {
		when(service.multiplication(7,0)).thenReturn(0);
		assertEquals(0, application.performMultiplication(7,0));
	}
	
	@Test
	public void TestDivisionWithTwoPositiveInteger() {
		when(service.division(16, 2)).thenReturn(8);
		assertEquals(8, application.performDivision(16,2));
	}
	
	@Test
	public void TestDivisionWithTwoNegativeInteger() {
		when(service.division(-10,-5)).thenReturn(2);
		assertEquals(2, application.performDivision(-10,-5));
	}
	
	@Test
	public void TestDivisionWithOneNegativeAndOnePositiveInteger() {
		when(service.division(30,-5)).thenReturn(-6);
		assertEquals(-6, application.performDivision(30,-5));
	}
	
	@Test(expected = ArithmeticException.class)
	public void TestDivisionWhenDivisorIsZero() {
		doThrow(new ArithmeticException("/ by zero")).when(service).division(30, 0);
		application.performDivision(30,0);
	}

	@Test
	public void TestFactorial() {
		when(service.factorial(5)).thenReturn(120L);
		assertEquals(120L, application.performFactorial(5));
	}
	
	@Test
	public void TestSquare() {
		when(service.square(12)).thenReturn(144L);
		assertEquals(144L, application.performSquare(12));
	}
	
	

}

package com.capgemini.sample.test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import org.junit.Before;
import org.junit.Test;

import com.capgemini.sample.model.BankAccount;

public class SampleTest {

	private BankAccount account;

	@Before
	public void setUp() {
		account = new BankAccount(101, "Raj", "SAVING", 35000);
	}

	@Test
	public void tetsBankAccountObjectIsCreatedWithDefaultConstructor() {
		BankAccount account = new BankAccount();
		assertNotNull(account);

	}

	@Test
	public void tetsBankAccountObjectIsCreatedWithParameterizedConstructor() {
		
		assertNotNull(account);
		assertEquals(101, account.getAccountId());
		assertEquals("Raj", account.getAccountHolderName());
		assertEquals("SAVING", account.getAccountType());
		assertEquals(35000.0, account.getAccountBalance(), 0.01);
	}

	@Test
	public void testBankAccountCurrentBalance() {
		assertEquals(35000, account.getAccountBalance(), 0.01);
	}

	@Test
	public void testWithdrawWithSufficientFund() {
		account.withdraw(5000);
		assertEquals(30000, account.getAccountBalance(), 0.01);
	}

	@Test
	public void testWithdrawWithInsufficientFund() {
		account.withdraw(45000);
		assertEquals(35000, account.getAccountBalance(), 0.01);
	}

	@Test
	public void testDeposit() {
		account.deposit(50000);
		assertEquals(85000, account.getAccountBalance(), 0.01);
	}

}

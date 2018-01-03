package com.abc.account;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.Before;
import org.junit.Test;

import com.abc.Transaction;

public class AccountAbstractTest {

	private static final double DOUBLE_DELTA = 1e-15;
	
	AccountAbstract account;
	
	@Before
	public void init() {
		account = new AccountAbstract() {
			
			@Override
			public String printAccountType() {
				return "Test Abstract Account Type";
			}
			
			@Override
			public double interestEarned() {
				return 1;
			}
		};
		
		account.deposit(400);
		account.withdraw(200);		
		
	}
	
	
	@Test
	public void testAccountAbstract() {
		assertTrue(account instanceof AccountAbstract);
		assertEquals("Test Abstract Account Type", account.printAccountType());
		assertEquals(1, account.interestEarned(), DOUBLE_DELTA);
		
	}

	@Test
	public void testGetTransactions() {
		List<Transaction> transactions = account.getTransactions();
		assertEquals(2, transactions.size());
	}

	@Test
	public void testDeposit() {
		List<Transaction> transactions = account.getTransactions();
		Transaction deposit = transactions.get(0);
		assertEquals(400, deposit.amount, DOUBLE_DELTA);
	}

	@Test
	public void testWithdraw() {
		List<Transaction> transactions = account.getTransactions();
		Transaction withdraw = transactions.get(1);
		assertEquals(-200, withdraw.amount, DOUBLE_DELTA);
	}

	@Test
	public void testTransfer() {
		AccountAbstract account2 = new AccountAbstract() {
			
			@Override
			public String printAccountType() {
				return "Test Abstract Account Type";
			}
			
			@Override
			public double interestEarned() {
				return 1;
			}
		};
		
		account.transfer(account2, 100);
		
		assertEquals(100, account2.sumTransactions(), DOUBLE_DELTA);
		
		account.deposit(100);
	}

	@Test
	public void testSumTransactions() {
		assertEquals(200, account.sumTransactions(), DOUBLE_DELTA);
	}

	@Test
	public void testHadWithdrawlInTheLast10Days() {
		assertTrue(account.hadWithdrawlInTheLast10Days());
	}

	@Test
	public void testCalculateCompoundInterest() {
		double interest = account.calculateCompoundInterest(10, 0.01);
		assertEquals(0.10050028723681592, interest, DOUBLE_DELTA);
	}

	// test exceptions
	
	public void testNoFunds() {
		boolean threw = false;
		try {
			account.withdraw(300);
		} catch (IllegalArgumentException e) {
			threw = true;
		}
		assertTrue(threw);
	}
	
	public void testMinusDeposit() {
		boolean threw = false;
		try {
			account.withdraw(-1);
		} catch (IllegalArgumentException e) {
			threw = true;
		}
		assertTrue(threw);
	}
	
	public void testMinusWithdraw() {
		boolean threw = false;
		try {
			account.withdraw(-1);
		} catch (IllegalArgumentException e) {
			threw = true;
		}
		assertTrue(threw);
	}
	
}

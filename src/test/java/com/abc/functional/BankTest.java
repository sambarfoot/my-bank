package com.abc.functional;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

import com.abc.Bank;
import com.abc.Customer;
import com.abc.account.Account;
import com.abc.account.types.Checking;
import com.abc.account.types.MaxiSavings;
import com.abc.account.types.Savings;

public class BankTest {
    private static final double DOUBLE_DELTA = 1e-15;

    @Test
    public void testOneCustomerSummary() {
        Bank bank = new Bank();
        Customer john = new Customer("John");
        john.openAccount(new Checking());
        bank.addCustomer(john);

        assertEquals("Customer Summary\n - John (1 account)", bank.customerSummary());
    }
    
    @Test
    public void testMultipleCustomerSummary() {
    	Bank bank = new Bank();
    	 Customer john = new Customer("John");
         john.openAccount(new Checking());
         bank.addCustomer(john);
         
         Customer mary = new Customer("Mary");
         mary.openAccount(new Checking()).openAccount(new Savings());
         bank.addCustomer(mary);
         
         Customer james = new Customer("James");
         james.openAccount(new Checking());
         bank.addCustomer(james);
         
         assertEquals("Customer Summary\n - John (1 account)\n"
         		+ " - Mary (2 accounts)\n"
         		+ " - James (1 account)", bank.customerSummary());    	
    }

    @Test
    public void testCheckingAccount() {
        Bank bank = new Bank();
        Account checkingAccount = new Checking();
        Customer bill = new Customer("Bill").openAccount(checkingAccount);
        bank.addCustomer(bill);

        checkingAccount.deposit(100.0);

        assertEquals(0.10004987954705769, bank.totalInterestPaid(), DOUBLE_DELTA);
    }

    @Test
    public void testSavingsAccount() {
        Bank bank = new Bank();
        Account checkingAccount = new Savings();
        bank.addCustomer(new Customer("Bill").openAccount(checkingAccount));

        checkingAccount.deposit(1500.0);

        assertEquals(2.0009979217924183, bank.totalInterestPaid(), DOUBLE_DELTA);
    }

    @Test
    public void testMaxiSavingsAccount() {
        Bank bank = new Bank();
        Account checkingAccount = new MaxiSavings();
        bank.addCustomer(new Customer("Bill").openAccount(checkingAccount));

        checkingAccount.deposit(3000.0);

        assertEquals(3.0014963864118727, bank.totalInterestPaid(), DOUBLE_DELTA);
    }

}

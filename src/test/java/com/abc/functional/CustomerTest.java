package com.abc.functional;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

import com.abc.Customer;
import com.abc.account.Account;
import com.abc.account.types.Checking;
import com.abc.account.types.MaxiSavings;
import com.abc.account.types.Savings;

public class CustomerTest {

	private static final double DOUBLE_DELTA = 1e-15;
	
    @Test //Test customer statement generation
    public void testApp(){

        Account checkingAccount = new Checking();
        Account savingsAccount = new Savings();

        Customer henry = new Customer("Henry").openAccount(checkingAccount).openAccount(savingsAccount);

        checkingAccount.deposit(100.0);
        savingsAccount.deposit(4000.0);
        savingsAccount.withdraw(200.0);

        assertEquals("Statement for Henry\n" +
                "\n" +
                "Checking Account\n" +
                "  deposit $100.00\n" +
                "Total $100.00\n" +
                "\n" +
                "Savings Account\n" +
                "  deposit $4,000.00\n" +
                "  withdrawal $200.00\n" +
                "Total $3,800.00\n" +
                "\n" +
                "Total In All Accounts $3,900.00", henry.getStatement());
    }

    @Test
    public void testOneAccount(){
        Customer oscar = new Customer("Oscar").openAccount(new Savings());
        assertEquals(1, oscar.getNumberOfAccounts());
    }

    @Test
    public void testTwoAccount(){
        Customer oscar = new Customer("Oscar")
                .openAccount(new Savings());
        oscar.openAccount(new Checking());
        assertEquals(2, oscar.getNumberOfAccounts());
    }

    @Test
    public void testThreeAcounts() {
        Customer oscar = new Customer("Oscar")
                .openAccount(new Savings());
        oscar.openAccount(new Checking());
        oscar.openAccount(new MaxiSavings());
        assertEquals(3, oscar.getNumberOfAccounts());
    }
    
    @Test
    public void testTransferAccountNumber() {
    	
    	Account checkingAccount = new Checking();
        Account savingsAccount = new Savings();

        Customer henry = new Customer("Henry").openAccount(checkingAccount).openAccount(savingsAccount);

        checkingAccount.deposit(100.0);
        savingsAccount.deposit(4000.0);
        
        henry.transfer(2, 1, 200);
        
        assertEquals(300, checkingAccount.sumTransactions(), DOUBLE_DELTA);
        
    }
    
    @Test
    public void testTransferAccountObject() {
    	
    	Account checkingAccount = new Checking();
        Account savingsAccount = new Savings();

        Customer henry = new Customer("Henry").openAccount(checkingAccount).openAccount(savingsAccount);

        checkingAccount.deposit(100.0);
        savingsAccount.deposit(4000.0);
        
        henry.transfer(savingsAccount, checkingAccount, 200);
        
        assertEquals(300, henry.getAccount(1).sumTransactions(), DOUBLE_DELTA);
    }
    
    @Test
    public void testTransferAccountObjectAlternate() {
    	
    	Account checkingAccount = new Checking();
        Account savingsAccount = new Savings();

        Customer henry = new Customer("Henry").openAccount(checkingAccount).openAccount(savingsAccount);

        checkingAccount.deposit(100.0);
        savingsAccount.deposit(4000.0);
        
        savingsAccount.transfer(checkingAccount, 200);
        
        assertEquals(300, henry.getAccount(1).sumTransactions(), DOUBLE_DELTA);
    }    
    
}

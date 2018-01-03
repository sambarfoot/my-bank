package com.abc;

import java.util.ArrayList;
import java.util.List;

import static java.lang.Math.abs;

import com.abc.account.Account;

public class Customer {
    private String name;
    private List<Account> accounts;

    public Customer(String name) {
        this.name = name;
        this.accounts = new ArrayList<Account>();
    }

    /**
	 * @return customer name
	 */
    public String getName() {
        return name;
    }

    /**
	 * open new account
	 * @return the customer object
	 */
    public Customer openAccount(Account account) {
        accounts.add(account);
        return this;
    }

    /**
	 * @return the number of accounts a customer has
	 */
    public int getNumberOfAccounts() {
        return accounts.size();
    }

    /**
	 * @return total interest a customer has accrued on all accounts
	 */
    public double totalInterestEarned() {
        double total = 0;
        for (Account a : accounts)
            total += a.interestEarned();
        return total;
    }

    /**
	 * @return a statement of the customer accounts at the bank
	 */
    public String getStatement() {
        String statement = "Statement for " + name + "\n";
        double total = 0.0;
        for (Account a : accounts) {
            statement += "\n" + statementForAccount(a) + "\n";
            total += a.getBalance();
        }
        statement += "\nTotal In All Accounts " + toDollars(total);
        return statement;
    }
    
    /**
	 * @return formats a double to dollars string
	 */
    private String toDollars(double d){
        return String.format("$%,.2f", abs(d));
    }

    /**
	 * @return a statement of an account at the bank
	 */
    private String statementForAccount(Account a) {
        return a.statementForAccount();
    }

}

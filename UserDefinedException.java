package com.labTest2;
class Account{
	private int balance=2000;
	public int balance() {
		return balance;
	}
	public void withdraw(int amount) throws NotSufficientFundException{
		if(amount > balance) {
			throw new NotSufficientFundException(String.format("Current balance %d is less than requested amount %d",balance,amount));
		}
		balance=balance-amount;
	}
	public void deposit(int amount) {
		if(amount<=0) {
			throw new IllegalArgumentException( String.format("Invalid deposit amount %s", amount)); 

		}
	}
}

class NotSufficientFundException extends RuntimeException { 
	private String message; 
	public NotSufficientFundException(String message) { 
		this.message = message; 
	} 
	public NotSufficientFundException(Throwable cause, String message) { 
		super(cause); this.message = message; 
	} 
	public String getMessage() { 
		return message; 
	} 
}

public class UserDefinedException {

	public static void main(String[] args) {
		Account acct = new Account(); 
		System.out.println("Current balance : " + acct.balance()); 
		System.out.println("Withdrawing $1100"); 
		acct.withdraw(1100); 
		System.out.println("Current balance : " + acct.balance()); 
		acct.withdraw(900);
	}

}

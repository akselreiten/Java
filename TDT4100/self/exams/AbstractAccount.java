package exams;

public abstract class AbstractAccount {

	private double balance; 
	protected double someVariable; 
	
	protected AbstractAccount(){
		setBalance(0);
	}
	
	public double getBalance(){
		return balance;
	}
	
	public void deposit(double amount){
		if (amount < 0){
			throw new IllegalArgumentException("amount is negative");
		}
		setBalance(getBalance() + amount);
	}
	
	public void withdraw(double amount){
		if (amount < 0){
			throw new IllegalArgumentException("amount is negative"); 
		}
		internalWithdraw(amount); 
	}
	
	protected abstract void internalWithdraw(double amount);

	public void setBalance(double d) {
		this.balance = d;
	}
	
}

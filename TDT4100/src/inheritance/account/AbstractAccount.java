package inheritance.account;

public abstract class AbstractAccount {

	double balance;
	
	public AbstractAccount(){
		balance = 0;
	}
	
	public void deposit(double amount){
		if (amount > 0){
			balance += amount;
		} else {
			throw new IllegalArgumentException("amount must be positive");
		}
	}
	
	public void withdraw(double amount){
		if (amount > 0) {
			internalWithdraw(amount);
		} else {
			throw new IllegalArgumentException("lol");
		}
		
	}
	
	abstract public void internalWithdraw(double amount);
	
	public double getBalance(){
		return balance; 
	}
	
}

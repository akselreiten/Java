package inheritance.account;

public class ForeldreSpar extends SavingsAccount{

	int withdrawLimit, withdrawCounter; 
	
	public ForeldreSpar(double interestRate, int withdrawLimit) {
		super(interestRate);
		this.withdrawLimit = withdrawLimit;
	}
	
	public int getRemainingWithdrawals(){
		return withdrawLimit - withdrawCounter;
	}
	
	public void withdrawFS(double amount){
		if (withdrawCounter < withdrawLimit){
			withdraw(amount);
			withdrawCounter++; 
		} else {
			throw new IllegalArgumentException("Number of withdrawals > Limit");
		}
	}
	
	
}

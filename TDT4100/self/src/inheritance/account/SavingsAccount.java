package inheritance.account;

public class SavingsAccount implements Account{

	public double balance, interestRate; 
	
	public SavingsAccount(double interestRate){
		if (interestRate > 0){
			this.interestRate = interestRate;
		}
	}
	
	public void deposit(double amount) {
		if (amount > 0) {
			balance += amount;
		} else {
			throw new IllegalArgumentException("Amount must be positive.");
		}
	}

	public void withdraw(double amount) {
		if (amount > 0) {
			if (amount <= balance){
				balance -= amount;
			} else {
				throw new IllegalStateException("Amount must be smaller or equal to balance.");
			}
		} else {
			throw new IllegalArgumentException("Amount must be positive.");
		}
		
	}

	public double getBalance() {
		return balance; 
	}

	public void endYearUpdate(){
		balance += balance*interestRate; 
	}
	
}

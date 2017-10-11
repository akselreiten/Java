package stateandbehavior;

public class Account {

	private double balance;
	private double interestRate;

	void deposit(double value) {
		if (value > 0) {
			balance = balance + value;
		}
	}

	void addInterest() {
		balance = balance + (interestRate * balance)/100;
	}

	double getBalance() {
		return balance;
	}

	double getInterestRate() {
		return interestRate;

	}

	void setInterestRate(double newInterestRate) {
		interestRate = newInterestRate;
	}
	
	public String toString() {
		return "Current balance is " + balance + ", interestRate is " + interestRate + ".";
	}

	public static void main(String[] args) {
		Account account1 = new Account();
		account1.deposit(1000);
		account1.setInterestRate(2);
		
		System.out.println(account1);
		
	} 
	
}

	


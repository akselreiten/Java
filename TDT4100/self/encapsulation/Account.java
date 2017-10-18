package encapsulation;

public class Account {

	private double startValue;
	private double interestRate;
	private double balance;

	public Account(double startValue, double interestRate) throws IllegalArgumentException {
		if (startValue < 0 || interestRate < 0) {
			throw new IllegalArgumentException("Values needs to be greater than 0.");
		}
		this.startValue = startValue;
		this.interestRate = interestRate;
		this.balance = startValue;
	}

	public double getBalance() {
		return balance;
	}

	public double getInterestRate() {
		return interestRate;
	}

	public void setInterestRate(double newInterestRate) {
		if (newInterestRate < 0) {
			throw new IllegalArgumentException("Value needs to be greater than 0.");
		}
		this.interestRate = newInterestRate;
	}

	public void deposit(double value) {
		if (value < 0) {
			throw new IllegalArgumentException("Value needs to be greater than 0.");
		}
				
		this.balance = balance + value;
	}

	public void withdraw(double value) {
		if (value < 0 || value > this.balance) {
			throw new IllegalArgumentException("Value needs to be positive, and less than balance.");
		}
			
		this.balance = balance - value;
	}

	public void addInterest() {
		this.balance = balance + (balance * interestRate) / 100;
	}

	 public String toSring() { 
		 return "Current balance is " + balance + ", current interest rate is " + interestRate; 
		 }
	 
	 
	 public static void main(String[] args) { 
		 
	 Account account1 = new Account(5000,5); 
	 account1.deposit(50000); 
	 account1.addInterest();
	 	 
	 System.out.println(account1.getBalance());
	 
	 }
}

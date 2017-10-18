package exams;

public class CreditAccount extends AbstractAccount{

	private double creditLine; 
	
	public CreditAccount(double creditLine){
		this.creditLine = creditLine;
	}
	
	public double getCreditLine(){
		return creditLine; 
	}
	
	public void setCreditLine(double value){
		if (value < 0){
			throw new IllegalArgumentException("value must be larger than 0.");
		}
		
		if (value + getBalance() < 0) {
			throw new IllegalStateException("value + balance < 0");
		}
		
		this.creditLine = value; 
	}
	
	@Override
	protected void internalWithdraw(double amount) {
		if (amount > getBalance() + creditLine) {
			throw new IllegalArgumentException("amount wrtong"); 
		}
		setBalance(getBalance() - amount);
	}
	
}

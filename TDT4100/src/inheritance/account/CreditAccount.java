package inheritance.account;

public class CreditAccount extends AbstractAccount{

	double creditLine;
	
	public CreditAccount(double creditLine){
		this.creditLine = creditLine; 
	}
	
	public double getCreditLine(){
		return creditLine;
	}
	
	public void setCreditLine(double newValue){
		if (newValue < 0){
			throw new IllegalArgumentException();
		}
		if ((balance < 0) && (balance + newValue) < 0) {
			throw new IllegalStateException();
		}
		else {
			this.creditLine = newValue;
		}
	}

	@Override
	public void internalWithdraw(double amount) {
		if (amount > (balance + creditLine)){
			throw new IllegalStateException();
		} else{
			balance -= amount; 
		}
	}
	
}

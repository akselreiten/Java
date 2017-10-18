package inheritance.account;

public class DebitAccount extends AbstractAccount{

	public void internalWithdraw(double amount) {
		if (amount < 0){
			throw new IllegalArgumentException("amount to high or not positive.");
		} else if ((balance - amount) >= 0){
			balance -= amount;
		} else {
			throw new IllegalStateException();
		}
	}
	
	
}

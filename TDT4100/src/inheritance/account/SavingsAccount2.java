package inheritance.account;

public class SavingsAccount2 extends AbstractAccount{

	private int maxWithdrawals, withdrawalCounter;
	private double fee; 
	
	public SavingsAccount2(int maxWithdrawals, double fee){
		if (maxWithdrawals > 0 && fee > 0){
			this.maxWithdrawals = maxWithdrawals;
			this.fee = fee;
		} else {
			throw new IllegalArgumentException();
		}
	}

	@Override
	public void internalWithdraw(double amount) {
		if (amount < 0){
			throw new IllegalArgumentException();
		} 
		
		if (withdrawalCounter >= maxWithdrawals){
			if ((amount+fee) <= balance){
				balance -= (amount + fee);
				withdrawalCounter++;
			} else {
				throw new IllegalStateException();
			}
		} else {
			if (amount < balance){
				balance -= amount;
				withdrawalCounter++;
			} else {
				throw new IllegalStateException();
			}
		}
	}
}

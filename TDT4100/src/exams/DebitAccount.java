package exams;

public class DebitAccount extends AbstractAccount{
	
	public DebitAccount(){
	}

	@Override
	protected void internalWithdraw(double amount) {
		if (super.getBalance() - amount < 0){
			throw new IllegalArgumentException("Can't withdraw this much money.");
		}
		super.setBalance(super.getBalance() - amount);
	}
	
	public void printSome(double someVariable){
		System.out.println(someVariable);
		System.out.println(this.someVariable);
		this.someVariable = 50; 
		
		
	}
	
	
	
}

package inheritance.account;

public class BSU extends SavingsAccount{

	double depositLimit, bsuBalance, bsuYearlyBalance;
	
	public BSU(double interestRate, double depositLimit) {
		super(interestRate);
		this.depositLimit = depositLimit;
	}
	
	public double getTaxDeduction(){
		double taxDeduction = bsuYearlyBalance*0.2;
		return taxDeduction;
	}
	
	public void depositBSU(double amount){
		if ((amount + bsuYearlyBalance) < depositLimit) {
			deposit(amount);
			bsuYearlyBalance += amount;
		}
	}
	
	public void withdrawBSU(double amount){
		if (amount < bsuYearlyBalance){
			withdraw(amount); 
			bsuYearlyBalance -= amount; 
		}
	} 
	
}

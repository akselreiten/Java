package inheritance.train;

public class TrainCar {

	private int deadWeight, totalWeight; 
	
	
	public TrainCar(int deadWeight){
		this.deadWeight = deadWeight; 
	}
	
	public int getTotalWeight(){
		return totalWeight; 
	}
	
	public int getDeadWeight(){
		return deadWeight;
	}
	
	public void setDeadWeight(int newWeight){
		this.deadWeight = newWeight;
	}
	
}

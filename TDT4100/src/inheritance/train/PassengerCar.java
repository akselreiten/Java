package inheritance.train;

public class PassengerCar extends TrainCar{

	int passengerWeight = 80; 
	int passengerCount;
	
	public PassengerCar(int deadWeight, int passengerCount){
		super(deadWeight);
		this.passengerCount = passengerCount;
	}
	
	public int getPassengerCount(){
		return passengerCount;
	}
	
	public void setPassengerCount(int number){
		this.passengerCount = number; 
	}
	
	@Override
	public int getTotalWeight(){
		return super.getDeadWeight() + passengerCount * passengerWeight;
	}
	
}

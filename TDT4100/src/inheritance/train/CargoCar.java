package inheritance.train;

public class CargoCar extends TrainCar{

	int cargoWeight; 
	
	public CargoCar(int deadWeight, int cargoWeight){
		super(deadWeight);
		this.cargoWeight = cargoWeight; 
	}
	
	public int getCargoWeight(){
		return cargoWeight;
	}
	
	public void setCargoWeight(int weight){
		this.cargoWeight = weight;
	}
	
	@Override
	public int getTotalWeight(){
		return super.getDeadWeight() + cargoWeight; 
	}
}

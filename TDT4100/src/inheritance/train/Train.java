package inheritance.train;

import java.util.ArrayList;
import java.util.List;

public class Train {
	
	private List<TrainCar> locomotive = new ArrayList<TrainCar>(); 
	
	public Train(){
		
	}
	
	public void addTrainCar(TrainCar trainCar){
		if(contains(trainCar)){
			locomotive.add(trainCar);
		}
	}
	
	public boolean contains(TrainCar trainCar){
		return locomotive.contains(trainCar);
	}
	
	public int getTotalWeight(){
		int total = 0;
		for (TrainCar car : locomotive){
			total += car.getTotalWeight();
		}
		return total;
	}
	
	public int getPassengerCount(){
		int total = 0; 
		for (TrainCar car : locomotive){
			if (car instanceof PassengerCar){
				total += ((PassengerCar) car).getPassengerCount();
			}
		}
		return total; 
	}
	
	public int getCargoWeight(){
		int total = 0; 
		for (TrainCar car:locomotive){
			if(car instanceof CargoCar){
				total += ((CargoCar) car).getCargoWeight();
			}
		}
		return total; 
	}
	
	public String toString(){
		String outstr = ""; 
		for (TrainCar car:locomotive){
			if (car instanceof CargoCar){
				outstr += "Type: CargoCar.\n Total weight = " + car.getTotalWeight() + "kg\nCargo weight = " + ((CargoCar) car).getCargoWeight(); 
			} else {
				outstr += "Type: PassengerCar. Total weight = " + car.getTotalWeight() + "kg\nPassenger count = " + ((PassengerCar) car).getPassengerCount();
			}
		}
		return outstr;
	}

	
}

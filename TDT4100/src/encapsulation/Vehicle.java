package encapsulation;

import java.util.Arrays;
import java.util.List;

public class Vehicle {
	
	private char vehicleType;
	private char fuelType;
	private String regNumber;

	private List<Character> validVehicleType = Arrays.asList('M', 'C');
	private List<Character> validFuelType = Arrays.asList('D', 'E', 'G', 'H');
	
	public Vehicle(char vehicleType, char fuelType, String regNumber) {
		if (checkVehicleType(vehicleType) && checkVehicleFuel(vehicleType, fuelType) && checkRegNumber(vehicleType, fuelType, regNumber)) {
			this.vehicleType = vehicleType;
			this.fuelType = fuelType;
			this.regNumber = regNumber;
		}
		 
		 else { 
			 throw new IllegalArgumentException("Wrong input.");
		 }
	}
	
	// check if vehicle type is a valid input
	private boolean checkVehicleType(char vehicleType) {
		if (validVehicleType.contains(vehicleType)) {
			return true;
		}
		else {
			return false;
		}
	}
	
	// check if vehicle fuel type is a valid input, and if it matches vehicleType. 
	private boolean checkVehicleFuel(char vehicleType, char fuelType) {
		if (validFuelType.contains(fuelType)) {
			if (vehicleType == 'M' && fuelType == 'H') {
				return false;
			}
			else {
				return true;
			}
	}
		return false;
	}
	
	// check if regNumber is a valid input based on fuelType and vehicleType 
	// OBS: Mange error her. Får ikke sjekket om riktig lengde. 
	private boolean checkRegNumber(char vehicleType, char fuelType, String regNumber) {
			
			if (fuelType == 'E') {
				if (regNumber.substring(0,2).equals("EL") 
						|| regNumber.substring(0,2).equals("EK")) {
					return true;
				}
				return false;
				}
			
			else if (fuelType == 'H') {
				if (regNumber.substring(0,2).equals("HY")) {
					return true;
				}
				return false; 
			}
			
			else if (fuelType == 'D' || fuelType == 'G') {
				if (regNumber.substring(0,2).equals("EK") 
						|| regNumber.substring(0,2).equals("EL")
						|| regNumber.substring(0,2).equals("HY")
						|| regNumber.substring(0,2).contains(".*[ÆØÅ].*")) {
					return false;
				}
				
				else if (vehicleType == 'C') {
					if (regNumber.length() == 7) {
						return true;
					}
					return false;
				}
				
				else if (vehicleType == 'M') {
					if (regNumber.length() == 6) {
						return true;
					}
					return false;
				}
			}
			return false;
		}
	
	public void setRegistrationNumber(String regNumber) {
		this.regNumber = regNumber;
	}
	
	public String getRegistrationNumber() {
		return this.regNumber;
	}
	
	public char getFuelType() {
		return this.fuelType; 
	}
	
	public char getVehicleType() {
		return this.vehicleType; 
	}
			
	
}

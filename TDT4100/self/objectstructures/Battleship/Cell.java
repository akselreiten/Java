package objectstructures.Battleship;

public class Cell {

	// 0 - initial value, gives ocean. 1 - ship is there and not hit, gives ocean. 
	// 2 - ocean that is hit, gives "O". 3 - ship that is hit, gives X.
	private int value; 
	
	public Cell(int value) {
		this.value = value;
	}
	
	public int getCellValue() { 
		return value; 
	}
	
	public void setValue(int newValue) {
		this.value = newValue; 
	}
	
	public boolean isOcean() {
		if (this.value == 0) {
			return true; 
		}
		else {
			return false; 
		}
	}
	
	public boolean isShip() {
		if (this.value == 1) {
			return true; 
		}
		else {
			return false; 
		}
	}

	public boolean isAlreadyHit() {
		if (this.value == 2 || this.value == 3) {
			return true;  //MÅ BYTTE DENNE MED "DU HAR ALLEREDE TRUFFET: SKRIV INN ET NYTT TALL:
		}
		else {
			return false; 
		}
	}
	
	//private void shipHealth(int )
	
	// O = forsøkt skutt, men utruffet
	// X = forsøkt skutt, og truffet
	// ~ = ikke forsøkt skutt
	
	
	
}

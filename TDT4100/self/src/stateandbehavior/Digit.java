package stateandbehavior;

public class Digit {

	int numSys;
	int siffer;
	String letters = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";

	int getValue() {
		return siffer;
	}

	boolean increment() {
		siffer++;
		if (siffer == numSys) {
			siffer = 0;
			return true;
		} else {
			return false;
		}
	}

	int getBase() {
		return numSys;
	}

	public String toString() {
		if (siffer < 10) {
			return Integer.toString(siffer);
		} 
		else {
			return "" + letters.charAt(siffer - 10);
			// charAt(int k) returns the character at position k
			
		}
	}
	
	public static void main(String[] args) {
		Digit digit1 = new Digit(); 
		
		digit1.numSys = 16;
		digit1.siffer = 10;
		digit1.increment();
		
		
		int numSys = digit1.getBase();
		
		System.out.println(digit1);
		
	}

}
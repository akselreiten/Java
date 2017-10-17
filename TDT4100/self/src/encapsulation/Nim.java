package encapsulation;

public class Nim {

	int number; 
	int targetPile; 
	int piles[] = new int[3]; 
	int pile1;
	int pile2; 
	int pile3; 
	
	public Nim (int pileSize) {
		/*for (int i=0; i==2; i++) {
			this.piles[i] = pileSize;
		}*/
		
		this.pile1 = pileSize;
		this.pile2 = pileSize;
		this.pile3 = pileSize;
		
	}
	
	public void removePieces(int number, int targetPile) {
		if (isValidMove(number, targetPile)) {
			if (targetPile == 0) {
				this.pile1 = this.pile1 - number;  
			}
			else if (targetPile == 1) {
				this.pile2 = this.pile2 - number; 
			}
			else if (targetPile == 2) {
				this.pile3 = this.pile3 - number; 
			}
		}
		else if (isGameOver()) {
			throw new IllegalStateException("Game is over");
		}
		else {
			throw new IllegalArgumentException("Wrong number or targetPile!");
		}
	}
	
	public boolean isTargetPileValid(int targetPile) {
		if (targetPile == 0 || targetPile == 1 || targetPile == 2) {
			return true;
		}
		else {
			return false;
		}
	}
	
	public boolean isValidMove(int number, int targetPile) {
		if (isGameOver()) {
			return false;
		}
		if (isTargetPileValid(targetPile) && number >= 1 && getPile(targetPile) >= number){
			return true; 
		}
		else {
			return false; 
		} 
	}
	
	public boolean isGameOver() {
		if (pile1 == 0 || pile2 == 0 || pile3 == 0) {
			return true; 
		}
		else {
			return false; 
		}
	}
	
	public int getPile(int targetPile) {
		if (targetPile == 0) {
			return pile1; 
		}
		else if (targetPile == 1) {
			return pile2; 
		}
		else if (targetPile == 2) {
			return pile3;
		}
		else {
			return 0; 
		}
	}
	
	public String toString() {
		return "Number of objects in pile number pile 1, 2 and 3 is " + pile1 + ", " + pile2 + ", " + pile3;
	}

}

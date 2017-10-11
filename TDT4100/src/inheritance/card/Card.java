package inheritance.card;

import java.util.Arrays;
import java.util.List;

public class Card {

	private final char suit; 
	private final int face; 
	
	public Card(char suit, int face){
		checkCard(suit,face);
		this.suit = suit; 
		this.face = face; 
	}
	
	public void checkCard(char suit, int face){
		List<Character> validSuits = Arrays.asList('S','C','D','H'); 
		
		if (!validSuits.contains(Character.toUpperCase(suit))){
			throw new IllegalArgumentException(suit + "is invalid");
		}
		if (face < 1 || face > 13) {
			throw new IllegalArgumentException(face + "is invalid");
		}
	}

	public char getSuit() {
		return suit;
	}

	public int getFace() {
		return face;
	}
	
	public String toString(){
		return "" + suit + face; 
	}
	
}

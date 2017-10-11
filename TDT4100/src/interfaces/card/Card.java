package interfaces.card;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
//import java.util.Comparable; 

public class Card implements Comparable<Card>{

	char cardType; 
	int cardValue; 
	
	private List<Character> validCardType = Arrays.asList('S', 'H', 'D', 'C');
	
	public Card (char cardType, int cardValue) {
		if (isValidCardType(cardType) && isValidCardValue(cardValue)) {
			this.cardType = cardType;
			this.cardValue = cardValue;
		}
		else {
			
			throw new IllegalArgumentException("Shit as, sorry bror.");
		}
	}
	
	public boolean isValidCardType(char cardType) {
		if (validCardType.contains(cardType)) {
			return true;
		}
		else {
			return false;
		}
	}
	
	public boolean isValidCardValue(int cardValue) {
		if (cardValue >= 1 && cardValue <= 13) {
			return true;
		}
		else {
			return false;
		}
	}
	
	public char getSuit() {
		return cardType; 
	}
	
	public int getFace() {
		return cardValue;
	}
	
	public String toString() {
		return cardType + String.valueOf(cardValue);
	}
	
	public int getTotalCardValue() {
		if (getSuit() == 'S'){
			return 39 + getFace();
		}
		else if (getSuit() == 'H'){
			return 26 + getFace();
		}
		else if (getSuit() == 'D'){
			return 13 + getFace();
		}
		else if (getSuit() == 'C'){
			return getFace(); 
		}
		else {
			throw new IllegalArgumentException("Feil i getTotalCardValue");
		}
	}
	
	@Override
	public int compareTo(Card c){ 
		if ((c).getTotalCardValue() > getTotalCardValue()) {
			return -1;
		}
		else if ((c).getTotalCardValue() < getTotalCardValue()) {
			return 1; 
		}
		else {
			return 0; 
		}
	}
	
}

package interfaces.card;

import java.util.ArrayList;
import java.util.Comparator; 

public class CardComparator implements Comparator<Card>{

//Hvordan kalle på metode fra klassen Card? 
	
	private boolean b;
	private char trumfType;
	
	
	public CardComparator(boolean b, char trumfType){
		this.b = b;
		this.trumfType = trumfType;
	}
	
	private boolean isAceHigh(){
		return b;
	}
	
	private ArrayList sortCardTypes() {
		char firstCardType; 
		char secondCardType;
		char thirdCardType; 
		char fourthCardType; 
		
		if (trumfType == ' ') {
			firstCardType = 'S'; 
			secondCardType = 'H';
			thirdCardType = 'D';
			fourthCardType = 'C';
		}
		else {
			firstCardType = trumfType; 
			if (firstCardType == 'S') {
				secondCardType = 'H';
				thirdCardType = 'D';
				fourthCardType = 'C'; 
			}
			else if (firstCardType == 'H') {
				secondCardType = 'S';
				thirdCardType = 'D';
				fourthCardType = 'C'; 
			}
			else if (firstCardType == 'D') {
				secondCardType = 'S';
				thirdCardType = 'H';
				fourthCardType = 'C'; 
			}
			else {
				secondCardType = 'S';
				thirdCardType = 'H';
				fourthCardType = 'D'; 
			}
		}
		
		ArrayList<Character> typeList = new ArrayList<Character>(); 
		typeList.add(fourthCardType);
		typeList.add(thirdCardType);
		typeList.add(secondCardType);
		typeList.add(firstCardType);
		
		System.out.println(fourthCardType);
		System.out.println(""+typeList.get(0) + typeList.get(1) + typeList.get(2) + typeList.get(3));
		
		return typeList;
		
	}

	private int totalCardValue(Card c) {
		ArrayList<Character> typeList = sortCardTypes();
		
		if (isAceHigh()) {
			if (c.getSuit() == typeList.get(3)) {
				int value  = 42;
				if (c.getFace() == 1){
					return value + 14;
				}
					
				return value + c.getFace(); 
			}
			else if (c.getSuit() == typeList.get(2)) {
				int value = 28;
				if (c.getFace() == 1){
					return value + 14;
				}
					return value + c.getFace(); 
			}
			else if (c.getSuit() == typeList.get(1)) {
				int value = 14; 
				if (c.getFace() == 1){
					return value + 14;
				}
				return value + c.getFace(); 
			}
			else {
				if (c.getFace() == 1){
					return 14;
				}
				return c.getFace();
			}
		}
		else {
			if (c.getSuit() == typeList.get(3)) {
				int value  = 39;
				return value + c.getFace(); 
			}
			else if (c.getSuit() == typeList.get(2)) {
				int value = 26;
				return value + c.getFace(); 
			}
			else if (c.getSuit() == typeList.get(1)) {
				int value = 13; 
				return value + c.getFace(); 
			}
			else {
				return c.getFace();
			}
		}
	}
	
	@Override
	public int compare(Card c1, Card c2) {
		if (totalCardValue(c1) < totalCardValue(c2)) {
			return -1;
		}
		else if (totalCardValue(c1) > totalCardValue(c2)) {
			return 1; 
		}
		else {
			return 0; 
		}
		
	}

}

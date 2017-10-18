package interfaces.card;

import java.util.Iterator;

import inheritance.CardContainer;

public class CardContainerIterator implements Iterator<Card> { 

	CardContainer cardcontainer; 
	int counter = 0; 
	
	public CardContainerIterator(CardContainer cardcontainer){
		this.cardcontainer = cardcontainer; 
	}

	/*
	 while (cardcontainer.hasNext()) {
		String element = cardcontainer1.next(); 
	}
	*/
	
	@Override
	public boolean hasNext() {
		if (counter <= cardcontainer.getCardCount()){
			return true; 
		}
		return false;
	}

	@Override
	public Card next() {
		counter++; 
		return cardcontainer.getCard(counter-1);
	}
	
	
	
}

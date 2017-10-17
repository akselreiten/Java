package inheritance.card;

import java.util.Iterator;

public class CardContainerIterator implements Iterator<Card>{

	CardContainer cardContainer; 
	int counter = 0; 
	
	public CardContainerIterator(CardContainer cardContainer){
		this.cardContainer = cardContainer; 
	}

	@Override
	public boolean hasNext() {
		return counter < cardContainer.getCardCount();
	}

	@Override
	public Card next() {
		Card c = cardContainer.getCard(counter);
		counter++; 
		return c; 
	}
	
	
	
	
}

package inheritance.card;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class CardHand extends CardContainerImpl{

	public CardHand(int maxCards){
		super(maxCards);
	}
	
	public void addCard(Card card){
		if (!cards.contains(card)){
			cards.add(card);
		}
	}
	
	public void play (int index){
		if (cards.contains(cards.get(index))){
			cards.remove(cards.indexOf(cards.get(index)));
		}
	}
	
}

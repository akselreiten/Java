package inheritance.card;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class CardContainerImpl implements CardContainer{
	
	protected List<Card> cards = new ArrayList<Card>(); 
	private final int maxCardCount; 
	
	protected CardContainerImpl(int maxCardCount){
		this.maxCardCount = maxCardCount;
	}
	
	public int getMaxCardCount() {
		return maxCardCount;
	}

	@Override
	public int getCardCount() {
		return cards.size();
	}

	@Override
	public Card getCard(int index) {
		if (index < 0 || index >= cards.size()){
			throw new IllegalArgumentException(index + " is out of bounds");
		}
		return cards.get(index);
	}

	@Override
	public Iterator<Card> iterator() {
		return cards.iterator();
	}
	
	public String toString(){
		String outstr = "";
		for (Card card : cards){
			outstr += "["+card.toString()+"] ";
		}
		outstr = outstr.trim();
		return outstr; 
	}
	
	
	
	
}



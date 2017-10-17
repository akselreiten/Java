package interfaces.card;

import java.util.Iterator;

public interface CardContainer extends Iterable<Card>{

	int getCardCount();
	Card getCard(int index);
	Iterator<Card> iterator();
}

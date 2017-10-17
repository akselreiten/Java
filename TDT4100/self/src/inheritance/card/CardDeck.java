package inheritance.card;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

public class CardDeck extends CardContainerImpl{
	
	private List<Character> suits = Arrays.asList('S', 'H', 'D', 'C');
	
	public CardDeck(int n){
		super(52);
		if (n > 0){
			for (Character suit : suits){
				for (int i=0; i<n; i++){
					cards.add(new Card(suit,i+1));
				}
			}
		} else {
			throw new IllegalArgumentException(n + " is not > 0");
		}
		
	}
	
	public void shufflePerfectly(){
		List<Card> shuffle = new ArrayList<Card>(); 
		
		for (int i=0; i<cards.size()/2; i++){
			shuffle.add(cards.get(i)); 
			shuffle.add(cards.get(i+cards.size()/2));
		}
		
		this.cards = shuffle; 
		
	}
	
	public void deal(CardHand ch, int numberOfCards){
		if (numberOfCards > cards.size()){
			throw new IllegalArgumentException("NumberOfCards, "+numberOfCards+", is out of bounds. CardDeck contains "+cards.size()+" cards.");
		}
		for (int i=0; i<numberOfCards ; i++){
			ch.addCard(cards.get(cards.size()-1));
			cards.remove(cards.size()-1);
		}
	}
	
	public static void main(String[] args) {
		CardDeck deck = new CardDeck(4); 
		CardHand hand = new CardHand(4);
		CardContainerImpl impl = new CardContainerImpl(52);
		CardContainer deck2 = new CardDeck(4); //CardDeck har metodene som finnes i CardContainer, da den extender CardContImpl som implementerer CardContainer;
		CardContainerImpl impl2 = new CardHand(4); //CardHand er en subklasse av CardContainerImpl
		
		//Det som instansieres står på høyre side. Dette må være en subklasse eller vær lik klassen som deklarerer typen på venstre side.
		//Interface kan ikke instansieres! 
		
		deck.deal(hand, 6);
		
		System.out.println(deck);
		System.out.println(hand);
		
		System.out.println(impl instanceof CardContainer);
		System.out.println(hand instanceof CardContainer);
		System.out.println(impl instanceof CardHand);
		System.out.println(deck2 instanceof CardDeck); 
		System.out.println(deck2 instanceof CardContainer);
		
	}
	
}

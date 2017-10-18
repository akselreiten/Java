package exams;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class Card {
		 
		   private final char suit;
		   private final int face;
		 
		   // initialises with suit ('S'=spade, 'H'=heart, 'D'=diamonds, 'C'=clubs) and face (1=ace, 2, ... 10, 11=knight, 12=queen and 13=king).
		   public Card(char suit, int face) {
		      this.suit = suit;
		      this.face = face;
		   }
		 
		   @Override
		   public String toString() {
		      return String.format("%s%s", suit, face);
		   }
		 
		   public char getSuit() {
		      return suit;
		   }
		 
		   public int getFace() {
		      return face;
		   }
		   
		   public static void main(String[] args) {
			   List<Card> cards = Arrays.asList(new Card('S', 1), new Card('S', 2), new Card('D', 12), new Card('S', 13), new Card('S',14));
			   
			   List<Card> a = cards.stream().filter(c -> c.getSuit() == 'H').collect(Collectors.toList());
			   List<Character> b = cards.stream().map(Card::getSuit).collect(Collectors.toList());
			   
			   //int c = cards.stream().map(Card::getFace).reduce((a,b) -> a+b).get();
			   //System.out.println(c);
			   
			   //boolean d = cards.stream()..allMatch(c -> c.getSuit() == 'D');
			   //System.out.println(d);
			   boolean bol = true; 
			   int num = 0;
			   if (cards.size() != 5){
				   bol = false;
			   }
			   while (bol == true){
				  if (num>=cards.size()){
					  break;
				  }
				   
				   if (cards.get(num).getSuit() != cards.get(0).getSuit()){
					   bol = false;
				   }
				   num++;
			   }
			   System.out.println(bol);
			   
			   System.out.println(cards.indexOf(null));
		}
	}

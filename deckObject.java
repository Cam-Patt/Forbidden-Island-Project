import java.util.Collections;
import java.util.Stack;

public class deckObject{
	private int numCards = 0;
	private Stack<cardObject> deck = new Stack<>();
	private Stack<cardObject> discarded = new Stack<>();
	
	public deckObject(){
		
	}
	public void addCard(cardObject c) { //adds specified card to the deck stack
		deck.push(c);
		numCards++;
	}
	public cardObject nextCard() { //pops and returns the first element of deck and pushes it onto the discarded stack
		cardObject card = deck.pop();
		discarded.push(card);
		return card;
	}
	public void remove(cardObject c) { //removes specified card from deck stack
		if(deck.contains(c)) {
			deck.remove(deck.indexOf(c));
		}
	}
	public void shuffle() { //shuffles the deck stack
		Collections.shuffle(deck);
	}
	public void shuffleDiscarded() { //shuffles the discarded stack and adds it to the front of the deck
		Collections.shuffle(discarded);
		deck.addAll(discarded);
		discarded.clear();
	}
}

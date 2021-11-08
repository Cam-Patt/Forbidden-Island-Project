
import java.util.Collections;
import java.util.Stack;

public class deckObject{
	private int numCards;
	private Stack<cardObject> deck = new Stack<>();
	private Stack<cardObject> discarded = new Stack<>();
	
	public deckObject(){
		
	}
	public cardObject nextCard() {
		cardObject card = deck.pop();
		discarded.push(card);
		return card;
	}
	public void remove(cardObject c) {
		if(deck.contains(c)) {
			deck.remove(deck.indexOf(c));
		}
	}
	public void shuffle() {
		Collections.shuffle(discarded);
		deck.addAll(discarded);
		discarded.clear();
	}
}

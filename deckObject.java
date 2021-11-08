import java.util.Stack;

public class deckObject{
  private int numCards;
  private Stack<cardObject> deck = new Stack<>();
  
  public deckObject(){
    
  }
  public cardObject nextCard() {
    return deck.pop();
  }
}

//Makes one player
import java.awt.*;
import java.util.ArrayList;
public class playerObject{
  private String name;
  private boolean[] abilities;
  private Color playerColor;
  private ArrayList<cardObject> hand;
  /*0 - can Move and shoreUp diagonally [explorer]
   *1 - move to any tile[pilot]
   *2 - move other players up 2 adjacent tiles per action [navigator]
   *3 - can move through different[diver]
   *4 - can shore up 2 tiles for 1 action[engineer]
   *5 - can give cards without having to be on the same tile[messenger]
   * */
  public playerObject(String n, boolean[] a, Color c) {
	  name = n;
	  abilities = a;
	  playerColor = c;
	  hand = new ArrayList<cardObject>();
  }
  public String getName() {
	  return name;
  }
  public Color getColor() {
	  return playerColor;
  }
  public String getAbility() {
	  if(abilities[0] == true) {
		 return "can move and shoreUp diagonally"; 
	  }
	  else if(abilities[2] == true) {
		  return "can move other players up to adjacent tiles per action";
	  }
	  else if(abilities[1] == true) {
		  return "can move any tile once per turn for 1 action";
	  }
	  else if(abilities[3] == true) {
		  return "can move through one or more adjacent missing and/or flooded tiles for 1 action";
	  }
	  else if(abilities[4] == true) {
		  return "can shore up 2 tiles for 1 action";
	  }
	  else if(abilities[5] == true) {
		  return "can give cards without having to be on the same tiles";
	  }
	  return "fuck getAbility isn't working";
  }
  public cardObject getCard(int index) {
	  return hand.get(index);
  }
  //returns false if they can add the card right
  //returns true if the hand is less than 6
  public boolean addCard(cardObject c) {
	  hand.add(c);
	  if(hand.size()> 5) {
		  return false;
	  }
	  else {
		  return true;
	  }
  }
  public int size() {
	  return hand.size();
  }
  public void removeCard(cardObject c) {
	  hand.remove(c);
  }
}

//here is the frame that we will use
import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.ListIterator;
import java.util.Random;
import java.util.Scanner;
import java.net.URL;

public class ForbiddenIslandFrame extends JFrame implements ActionListener{
	public static final int WIDTH = 1600;
	public static final int HEIGHT = 800;
	private TitlePanel title;
	private int difficulty;
	private ArrayList<playerObject> playerObjects;
	private boardPanel boardPanel;
	private deckObject floodDeck;
	private deckObject treasureDeck;
	private waterMeter meter;
	private gamePanel graphics; 
	private boolean hasWon;
	private boolean hasLost;
	private actionPanel action;
	private playerObject currentPlayer;
	private int amountOfActions;
	private boolean endOffTurnPressed;
	private ArrayList<String> treasures;
	public ForbiddenIslandFrame(String frameT) throws IOException{
		super(frameT);
		setSize(WIDTH,HEIGHT);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setVisible(true);
		makefloodDeck();
		makeTreasureDeck();
		title = new TitlePanel();
		add(title);
		title.b.start.addActionListener(this);
		validate();
		playerObjects = makePlayers();
		difficulty = 1000;
		hasWon = false;
		hasLost = false;
		endOffTurnPressed = false;
		amountOfActions = 0;
		//make deck god dam it
		floodDeck.shuffle();
		treasureDeck.shuffle();
		currentPlayer = new playerObject();
		treasures = new ArrayList<String>();
		treasures.add("Statue of the Wind");
		treasures.add("Earth Stone");
		treasures.add("Ocean's Chalice");
		treasures.add("Crystal of Fire");
	}
    public boolean stillTurn() throws IOException {
    	System.out.println("checking to see if the turn " + amountOfActions);
    	if(amountOfActions >= 3 || endOffTurnPressed == true) {
    		amountOfActions = 0;
    		endOffTurnPressed = false;
    		endOfTurn();
    		if(currentPlayer.getPlayerNum() >= 4) 
    			currentPlayer = playerObjects.get(0);
    		else 
    			currentPlayer = playerObjects.get(currentPlayer.getPlayerNum());
    		
    		int newPlayerNum = currentPlayer.getPlayerNum();
    		graphics.turn(newPlayerNum);
    		graphics.repaint();
    		revalidate();
    		return true;
    	}
    	return false;
    }
    private void startGame() {
    	System.out.println("Start button Pressed");
		remove(title); //removes the title panel
		validate();
		repaint();

    	System.out.println("Removed title + " + title.getDifficulty());
		boardObject o;
		difficulty = title.getDifficulty();
		if(difficulty == 0) {
			difficulty = 2;
		}

		setLayout(new GridBagLayout());
		GridBagConstraints c = new GridBagConstraints();

		setUpGame();
		
		boardPanel boardPanel = new boardPanel();
		try {
			o = new boardObject();
			boardPanel = new boardPanel(o);
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		allPlayerPanel panel = new allPlayerPanel(playerObjects);
		graphics = new gamePanel(panel, meter, boardPanel);
		boardPanel.setCallback(graphics);
		action = new actionPanel();

		c.gridx = 0;
		c.fill = 1;
		c.weightx=1;
		c.weighty=0.9;
		c.gridy = 0;
		add(graphics,c); 

		c.weighty=0.1;
		c.gridx = 0;
		c.gridy = 1;
		add(action,c);

		currentPlayer = playerObjects.get(0);
		graphics.turn(1);
		graphics.setCallBack(this);
		System.out.println("called graphic's turn");
		validate();
		System.out.println(playerObjects.toString());
		setPlayerLocation();
		try {
			floodIsland();
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		action.move.addActionListener(this);
		action.shoreUp.addActionListener(this);
		action.giveCards.addActionListener(this);
		action.getTreasure.addActionListener(this);
		action.leaveIsland.addActionListener(this);
		action.specialAction.addActionListener(this);
		action.endTurn.addActionListener(this);
    }
    
	public ArrayList<playerObject> makePlayers(){
		ArrayList<playerObject> fullList = new ArrayList<playerObject>();
		//makes a list of all possible characters
		playerObject explorer;
		boolean[] abilities = {true,false,false,false,false,false};
		Color c = new Color(0,204,0); //green
		explorer = new playerObject("Explorer",abilities, c, "Copper Gate");
		playerObject pilot;
		boolean[] abilitie = {false,true,false,false,false,false};
		c = new Color(0,0,255); //blue
		pilot = new playerObject("Pilot",abilitie, c, "Fools' Landing");
		playerObject navigator;
		boolean[] ab = {false,false,true,false,false,false};
		c = new Color(255,255,0); //yellow
		navigator= new playerObject("Navigator", ab, c, "Gold Gate");
		playerObject diver;
		boolean[] b = {false,false,false,true,false,false};
		c = Color.BLACK; //black
		diver = new playerObject("Diver", b, c, "Iron Gate");
		playerObject engineer;
		boolean[] a = {false,false,false,false,true,false};
		c = new Color(255,0,0); //red
		engineer = new playerObject("Engineer",a,c, "Bronze Gate");
		playerObject messenger;
		boolean[] list = {false,false,false,false,false,true};
		c = new Color(204,204,204); //white
		messenger = new playerObject("Messenger", list,c, "Silver Gate");
		
		fullList.add(explorer);
		fullList.add(pilot);
		fullList.add(navigator);
		fullList.add(diver);
		fullList.add(engineer);
		fullList.add(messenger);
		//randomly gets the characters from list
		ArrayList<playerObject> p = new ArrayList<playerObject>();
		//Random rand = new Random(12346);
		Random rand = new Random();
		int number = 1;
		for(int i =0; i < 4; i++) {
			int add = rand.nextInt(fullList.size());
			playerObject o = fullList.get(add);
			o.setPlayerNum(number);
			p.add(o);
			fullList.remove(add);
			number++;
		}
		fullList = p;
		return fullList;
	}
	public void makeTreasureDeck() throws IOException {
		ArrayList<String> titles;
		ArrayList<String> images;
		titles = new ArrayList<String>() {
			{
				add("Crystal of Fire");
				add("Crystal of Fire");
				add("Crystal of Fire");
				add("Crystal of Fire");
				add("Crystal of Fire");
				add("Earth Stone");
				add("Earth Stone");
				add("Earth Stone");
				add("Earth Stone");
				add("Earth Stone");
				add("Ocean's Chalice");
				add("Ocean's Chalice");
				add("Ocean's Chalice");
				add("Ocean's Chalice");
				add("Ocean's Chalice");
				add("Statue of the Wind");
				add("Statue of the Wind");
				add("Statue of the Wind");
				add("Statue of the Wind");
				add("Statue of the Wind");
				add("Water Rise!");
				add("Water Rise!");
				add("Water Rise!");
				add("Helicopter");
				add("Helicopter");
				add("Helicopter");
				add("Sand Bag");
				add("Sand Bag");
			}
		};
		
		images = new ArrayList<String>() {
			{
				add("Card_Crystal_of_Fire@2x.png");
				add("Card_Crystal_of_Fire@2x.png");
				add("Card_Crystal_of_Fire@2x.png");
				add("Card_Crystal_of_Fire@2x.png");
				add("Card_Crystal_of_Fire@2x.png");
				add("Card_Earth_Stone@2x.png");
				add("Card_Earth_Stone@2x.png");
				add("Card_Earth_Stone@2x.png");
				add("Card_Earth_Stone@2x.png");
				add("Card_Earth_Stone@2x.png");
				add("Card_Ocean_s_Chalice@2x.png");
				add("Card_Ocean_s_Chalice@2x.png");
				add("Card_Ocean_s_Chalice@2x.png");
				add("Card_Ocean_s_Chalice@2x.png");
				add("Card_Ocean_s_Chalice@2x.png");
				add("Card_Statue_of_the_Wind@2x.png");
				add("Card_Statue_of_the_Wind@2x.png");
				add("Card_Statue_of_the_Wind@2x.png");
				add("Card_Statue_of_the_Wind@2x.png");
				add("Card_Statue_of_the_Wind@2x.png");
				add("Card_Waters_Rise@2x.png");
				add("Card_Waters_Rise@2x.png");
				add("Card_Waters_Rise@2x.png");
				add("Card_Helicopter@2x.png");
				add("Card_Helicopter@2x.png");
				add("Card_Helicopter@2x.png");
				add("Card_Sand_Bag@2x.png");
				add("Card_Sand_Bag@2x.png");
			}
		};
		
		treasureDeck = new deckObject(); 
//		Scanner imageScanner = new Scanner(new File("treasureCard.txt"));
//		Scanner titleNames = new Scanner(new File("treasureCardTitle.txt"));
//		while(imageScanner.hasNext()) {
//			String imageTitle = imageScanner.nextLine();
//			BufferedImage b = ImageIO.read(ForbiddenIslandFrame.class.getResource("/cardFaces/" + imageTitle));
//			String title = titleNames.nextLine();
//			treasureCardObject card = new treasureCardObject(b, title);
//			if(title.equals("Water Rise!")) {
//				card = new waterRiseCardObject(b,title);
//			}
//			if(title.equals("Helicopter")) {
//				card = new specialActionCardObject(b,title,"Helicoper");
//			}
//			if(title.equals("Sand Bag")) {
//				card = new specialActionCardObject(b,title,"Sand Bag");
//			}
//			treasureDeck.addCard(card);
//		}
		for (int i=0; i < images.size(); i++) {
			String imageTitle = images.get(i);
			BufferedImage b = ImageIO.read(ForbiddenIslandFrame.class.getResource("/cardFaces/" + imageTitle));
			String title = titles.get(i);
			treasureCardObject card = new treasureCardObject(b, title);
			if(title.equals("Water Rise!")) {
				card = new waterRiseCardObject(b,title);
			}
			if(title.equals("Helicopter")) {
				card = new specialActionCardObject(b,title,"Helicoper");
			}
			if(title.equals("Sand Bag")) {
				card = new specialActionCardObject(b,title,"Sand Bag");
			}
			treasureDeck.addCard(card);
		}
	}
	public void makefloodDeck() throws IOException {
		ArrayList<String> tile_names = new ArrayList<String>() {
			{
				add("Breakers Bridge");
				add("Bronze Gate");
				add("Cave of Embers");
				add("Cave of Shadows");
				add("Cliffs of Abandon");
				add("Copper Gate");
				add("Coral Palace");
				add("Crimson Forest");
				add("Dunes of Deception");
				add("Fools_Landing");
				add("Gold Gate");
				add("Howling Garden");
				add("Iron Gate");
				add("Lost Lagoon");
				add("Misty Marsh");
				add("Observatory");
				add("Phantom Rock");
				add("Silver Gate");
				add("Temple of the Moon");
				add("Temple of the Sun");
				add("Tidal Palace");
				add("Twilight Hollow");
				add("Watchtower");
				add("Whispering Garden");
			}
		};
		floodDeck = new deckObject();
		for (String tile_name : tile_names) {
			String imageTitle = "Flood_Card_" + tile_name + "@2x.png";
			URL url = ForbiddenIslandFrame.class.getResource("/cardFaces/" + imageTitle);
			System.out.println(tile_name + ":" + url);
			BufferedImage b = ImageIO.read(url);
			floodCardObject card = new floodCardObject(b,tile_name);
			floodDeck.addCard(card);
		}
//		Scanner imageScanner = new Scanner(new File("floodCards.txt"));
//		Scanner titleNames = new Scanner(new File("tileList.txt"));
//		while(imageScanner.hasNext()) {
//			String imageTitle = imageScanner.nextLine();
//			//System.out.println(imageTitle);
//			URL url = ForbiddenIslandFrame.class.getResource("/cardFaces/" + imageTitle);
//			BufferedImage b = ImageIO.read(url);
//			//			BufferedImage b = ImageIO.read(ForbiddenIslandFrame.class.getResource("/cardFaces/" + imageTitle));
//			floodCardObject card = new floodCardObject(b,titleNames.nextLine());
//			floodDeck.addCard(card);
//		}
	}
	public void setUpGame() {
	//	System.out.println(treasureDeck.toString());
		//System.out.println(floodDeck.toString());
		//Adds all the cards to player hand
		ListIterator<playerObject> playerIter = playerObjects.listIterator();
		while(playerIter.hasNext()) {
			playerObject p = playerIter.next();
			for(int i =0; i < 2; i++) {
				cardObject card = treasureDeck.nextCard();
				if(card.getTitle().equals("Water Rise!")) {
					// Add to the treasure deck discard pile
					treasureDeck.discard(card);
					// *** Shouldn't this be the flooddeck?
//					treasureDeck.shuffleDiscarded();
					floodDeck.shuffleDiscarded();
					i--;
				}
				else {
					p.addHand(card);
				}
			}
		}
		//sets Water Meter
		meter = new waterMeter(difficulty);
	}
//	flood the island for the sixth times
	public void floodIsland() throws IOException {
		for(int k = 0; k < 6; k++) {
			floodCardObject temp = (floodCardObject)floodDeck.nextCard();
			floodDeck.discard(temp);
			graphics.getBoard().flood(temp);
			System.out.println(k + " " + temp.toString());
		}
	}
	//this will run the game play
	public void setPlayerLocation() {
		System.out.println("set Location");
		graphics.setPlayerLocation(playerObjects);
	}
	
	public void actionPerformed(ActionEvent e) {
	   	if (e.getSource() == title.b.start) {
	   		startGame();
	   	} 
	   	else {
	   		//graphics.board.unHighlight();
	   		if (e.getSource() == action.move) {
	   			System.out.println("move");
	   			try {
					move();
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
	   		} else if(e.getSource() == action.shoreUp) {
	   			System.out.println("shoreUp");
	   			try {
					shoreUp();
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
	   		} else if(e.getSource() == action.giveCards) {
	   			System.out.println("giveCards");
	   			try {
	   				System.out.println("Player is on the tile");
					giveCards();
	   				System.out.println("Player is on the tile");
				} catch (IOException e1) {
					// TODO Auto-generated catch block
	   				System.out.println("Inside the exception");
					e1.printStackTrace();
				}
	   		} else if(e.getSource() == action.getTreasure) {
	   			System.out.println("get Treasure");
	   			try {
					getTreasure();
				} catch (IOException e1) {
				// TODO Auto-generated catch block
					e1.printStackTrace();
				}
	   		} else if(e.getSource() == action.leaveIsland) {
	   			System.out.println("leaving island I mean that would be nice");
	   			leaveIsland();
	   		} else if(e.getSource() == action.endTurn) {
	   			System.out.println("we end the turn okay it is 9:45 I am tired");
	   			try {
					endTurn();
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
	   		} else if(e.getSource() == action.specialAction) {
	   			System.out.println("what special action we all are equal in the eyes of god");
	   			specialAction();
	   		}
	   	}
	 }
	 public void move() throws IOException {
		 stillTurn();
		 amountOfActions++;
		 graphics.highLightMove(currentPlayer);
		 graphics.setAction("move");	
		 validate();

		 }

	 public void shoreUp() throws IOException {
		 stillTurn();
		 amountOfActions++;
		 graphics.highLightShore(currentPlayer);
		 graphics.setAction("shoreUp");
		 validate();
	 }

	 public void giveCards() throws IOException {
		 amountOfActions++;
		 ArrayList<playerObject> playerOptions = graphics.highLightGiveCard(currentPlayer);
		 playerObject[] playerArray = new playerObject[playerOptions.size()];
		 for(int i = 0; i < playerArray.length; i++) {
			 playerArray[i] = playerOptions.get(i);
		 }
		 graphics.setAction("giveCard");
		 //Object[] cards = {"0","1","2","3","4","5"};
		 int index = JOptionPane.showOptionDialog(graphics, //location
				 "Select player to give too", //message
				 "Give Card - Step 1", //title of dialog
				 JOptionPane.YES_NO_OPTION, //needed
				 JOptionPane.QUESTION_MESSAGE, //needed
				 null, //needed
				 playerArray, //options
				 playerArray[0] //default
				 );
		 playerObject selectedPlayer = playerArray[index];
		ArrayList<cardObject> playerHand = currentPlayer.getHand();
		String[] hand = new String[playerHand.size()];
		for(int j = 1; j < hand.length; j++) {
			if(!playerHand.get(j-1).isSpecial())
				hand[j] = playerHand.get(j-1).toString();
		}
		hand[0] = "Don't Give";
		for(int k = 0; k < hand.length; k++) {
			System.out.println(hand[k] + " ");
		}
		int cardIndex = JOptionPane.showOptionDialog(graphics, "Select Treasure card to give", 
				"Give Card - Step 2", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE, null,hand, hand[0]);
		if(cardIndex == 0) {
			amountOfActions--;
		} else {
			cardObject selectedCard =playerHand.get(cardIndex - 1);
			currentPlayer.getHand().remove(selectedCard);
			selectedPlayer.getHand().add(selectedCard);
		}
		 stillTurn();
		repaint();
		graphics.validate();
		// graphics.players.currentPanel().unHighLightCards();
		 setPlayerLocation();
		 validate();

	 }

	 public void getTreasure() throws IOException{
		 stillTurn();
		 boolean lion = currentPlayer.getLocation().equals("Whispering Garden") ||currentPlayer.getLocation().equals("Howling Garden");
		 boolean shell = currentPlayer.getLocation().equals("Tidal Palace") || currentPlayer.getLocation().equals("Coral Palace");
		 boolean fire = currentPlayer.getLocation().equals("Cave of Embers") || currentPlayer.getLocation().equals("Cave of Shadows");
		 boolean rock = currentPlayer.getLocation().equals("Temple of the Sun") || currentPlayer.getLocation().equals("Temple of the Moon");
		 if(lion && currentPlayer.handContain4("Statue of the Wind") && treasures.contains("Statue of the Wind")) {
			 amountOfActions++;
			 currentPlayer.addTreasure("Statue of the Wind");
			 treasures.remove("Statue of the Wind");
		 } else if( shell && currentPlayer.handContain4("Ocean's Chalice") && treasures.contains("Ocean's Chalice")) {
			 currentPlayer.addTreasure("Ocean's Chalice");
			 treasures.remove("Ocean's Chalice");
			 amountOfActions++;

		 } else if(fire && currentPlayer.handContain4("Crystal of Fire") && treasures.contains("Crystal of Fire")) {
			 currentPlayer.addTreasure("Crystal of Fire");
			 treasures.remove("Crystal of Fire");
			 amountOfActions++;

		 } else if(rock && currentPlayer.handContain4("Earth Stone") && treasures.contains("Earth Stone")) {
			 currentPlayer.addTreasure("Earth Stone");
			 treasures.remove("Earth Stone");
			 amountOfActions++;

		 }else {
			 System.out.println("Silly you can't do that");
		 }
		 graphics.setAction("treasure");
		 validate();
		 stillTurn();

	 }
	 public void leaveIsland() {
		 amountOfActions++;
		 graphics.setAction("leave Island");
		 if(treasures.size() == 0) {
			 for(int i = 0; i < 4; i++) {
				 if(graphics.players.allOnFools()) {
					 removeAll();
					 hasWonPanel h = new hasWonPanel();
					 add(h);
					 revalidate();
				 }
			 }
		 }
		 validate();
		 }
	 public void endTurn() throws IOException{
		 endOffTurnPressed = true;
		 stillTurn();
		 graphics.setAction("end turn");
		 checkGameState();
		 validate();
	 }
	 public void specialAction() {
		 ArrayList<playerPanel> playerPs = graphics.players.listThatHasSpecial();
		 playerObject[] players = new playerObject[playerPs.size()];
		 int index = JOptionPane.showOptionDialog(graphics, //location
				 "Select player to give too", //message
				 "Give Card - Step 1", //title of dialog
				 JOptionPane.YES_NO_OPTION, //needed
				 JOptionPane.QUESTION_MESSAGE, //needed
				 null, //needed
				 players, //options
				 players[0] //default
				 );
	 }
	 public void endOfTurn() throws IOException {
		 // Draw cards 
		 for(int i =0; i < 2; i++) {
			 treasureCardObject card = (treasureCardObject) treasureDeck.nextCard();
			 if(card.toString().equals("water Rise!")) {
				 System.out.println("WaterRise!");
				 graphics.waterMeter.rise();
				 treasureDeck.discard(card);
				 floodDeck.shuffleDiscarded();
			 } else {
				 currentPlayer.addHand(card);
				 //*** count number of cards
				 //*** if greater than 5, highlight and get user to discard one
				 if(currentPlayer.getHand().size() > 5) {
					 // highlight/number 6 cards
					 graphics.players.currentPanel().highLightCards();
					 // allow user to pick which card to discard
					 Object[] cards = {"0","1","2","3","4","5"};
					 int index = JOptionPane.showOptionDialog(graphics, //location
							 "Select card to discard", //message
							 "Discard", //title of dialog
							 JOptionPane.YES_NO_OPTION, //needed
							 JOptionPane.QUESTION_MESSAGE, //needed
							 null, //needed
							 cards, //options
							 cards[0] //default
							 );
					 graphics.players.currentPanel().unHighLightCards();
					 //get selected card from player hand
					 treasureCardObject discarded_card = (treasureCardObject) currentPlayer.getHand().get(index);
					 System.out.println("user discarding: " + discarded_card + " at "+ index);
					 // Remove card from players hand
					 currentPlayer.getHand().remove(index);
					// discarded card to the treasuredeck discard
					 treasureDeck.discard(discarded_card);
				 }
			 }
			 if(treasureDeck.getSize() == 0) {
				 treasureDeck.shuffleDiscarded();
			 }
		 }
		 System.out.println(treasureDeck.toString());

		 //Flood the board based on current water level
		 for(int j = 0; j < graphics.waterMeter.getLevel(); j++) {
			 floodCardObject floodCard = (floodCardObject) floodDeck.nextCard();
			 graphics.board.flood(floodCard);
			 floodDeck.discard(floodCard);
			// System.out.println("FloodDeck = \n"+floodDeck.toString());
		 }

		 graphics.repaint();
		 validate();
		 checkGameState();
	 }

	 //check to see if you won or lost
	 public void checkGameState() {
		 //check if skull and bones reached
		 if(graphics.waterMeter.hasLost()) {
			 String[] lost = new String[1];
			 lost[0] = "OK";
			 int index = JOptionPane.showOptionDialog(graphics, //location
					 "G A M E O V E R", //message
					 "WATER METER RECEAHED", //title of dialog
					 JOptionPane.YES_NO_OPTION, //needed
					 JOptionPane.QUESTION_MESSAGE, //needed
					 null, //needed
					 lost, //options
					 lost[0] //default
					 );
			 this.dispose();
		 }
	 }
}

package Test;

import javax.imageio.ImageIO;

import java.awt.image.BufferedImage;

import java.awt.*;
import javax.swing.*;

public class playerPanel extends JPanel {
	private String playerRole;
	private BufferedImage Navigator, Messenger, Explorer, Pilot, Engineer, Diver, Card_Crystal_of_Fire, Card_Earth_Stone, Card_Oceans_Chalice, Card_Statue_of_the_Wind, Card_Helicopter, Card_Sand_Bag;
	//public playerPanel(playerObject p) {
	public playerPanel() {
		//playerRole = p.getRole();
		//playerRole = "Pilot";
//		try {
//			Navigator = ImageIO.read(getClass().getResource("/Images/Navigator.PNG"));
//			Messenger = ImageIO.read(getClass().getResource("/Images/Messenger.PNG"));
//			Explorer = ImageIO.read(getClass().getResource("/Images/Explorer.PNG"));
//			Pilot = ImageIO.read(getClass().getResource("/Images/Pilot.PNG"));
//			Engineer = ImageIO.read(getClass().getResource("/Images/Engineer.PNG"));
//			Diver = ImageIO.read(getClass().getResource("/Images/Diver.PNG"));
//			Card_Crystal_of_Fire = ImageIO.read(getClass().getResource("/Images/Card_Crystal_of_Fire.png"));
//			Card_Earth_Stone = ImageIO.read(getClass().getResource("/Images/Card_Earth_Stone.png"));
//			Card_Oceans_Chalice = ImageIO.read(getClass().getResource("/Images/Card_Oceans_Chalice.png"));
//			Card_Statue_of_the_Wind = ImageIO.read(getClass().getResource("/Images/Card_Statue_of_the_Wind.png"));
//			Card_Helicopter = ImageIO.read(getClass().getResource("/Images/Card_Helicopter.png"));
//			Card_Sand_Bag = ImageIO.read(getClass().getResource("/Images/Card_Sand_Bag.png"));
//		}
//		catch (Exception E){
//			System.out.println("Roles not found");
//		}

		//add(new JButton("worked"));
		//setSize(200, 200);
		//setVisible(true);
		System.out.println(getWidth()+" "+getHeight());
	}
	//paint panel not being called
	public void paint(Graphics g) {
		
		//super.paintComponent(g);
		g.setColor(Color.RED);
		//g.fillRect(0, 0, 300, 234);
		System.out.println(getWidth()+" "+getHeight());
		//g.fillRect(0, 0, getWidth(), getHeight());
		
		
//		switch (playerRole) {
//		case "Navigator":
//			g.drawImage(Navigator, 0, 0, 250, 180, null);
//			break;
//		case "Messenger":
//			g.drawImage(Messenger, 0, 0, 250, 180, null);
//			break;
//		case "Explorer":
//			g.drawImage(Explorer, 0, 0, 250, 180, null);
//			break;
//		case "Pilot": 
//			g.drawImage(Pilot, 0, 0, 250, 180, null);
//			break;
//		case "Engineer": 
//			g.drawImage(Engineer, 0, 0, 250, 180, null);
//			break;
//		case "Diver": 
//			g.drawImage(Diver, 0, 0, 250, 180, null);
//			break;
//		default: 
//			System.out.println("Player Role Not Found");
//		}
		
//		for(int i=0;i<p.getDeck().size();i++) {
//			switch (p.getDeck().get(i)) {
//			case "Fire":
//				g.drawImage(Card_Crystal_of_Fire, 100, 100, 100+i*120, 100, null);
//				break;
//			case "Stone":
//				g.drawImage(Card_Earth_Stone, 100, 100, 100+i*120, 100, null);
//				break;
//			case "Chalice":
//				g.drawImage(Card_Oceans_Chalice, 100, 100, 100+i*120, 100, null);
//				break;
//			case "Wind":
//				g.drawImage(Card_Statue_of_the_Wind, 100, 100, 100+i*120, 100, null);
//				break;
//			case "Helicopter":
//				g.drawImage(Card_Helicopter, 100, 100, 100+i*120, 100, null);
//				break;
//			case "Sandbag":
//				g.drawImage(Card_Sand_Bag, 100, 100, 100+i*120, 100, null);
//				break;
//			default:
//				System.out.println("Error with player cards");
//		}
	}
}

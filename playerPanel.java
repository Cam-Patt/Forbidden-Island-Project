import javax.imageio.ImageIO;
import javax.swing.JPanel;
import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.util.ArrayList;

public class playerPanel extends JPanel {
	private String playerRole;
	private playerObject p;
	private boolean border=false;
	private ArrayList<String> cards;
	private BufferedImage Navigator, Messenger, Explorer, Pilot, Engineer, Diver, Card_Crystal_of_Fire, Card_Earth_Stone, Card_Oceans_Chalice, Card_Statue_of_the_Wind, Card_Helicopter, Card_Sand_Bag;
	public playerPanel(playerObject p) {
		this.p = p;
		playerRole = p.getRole();
		try {
			Navigator = ImageIO.read(getClass().getResource("/Images/Navigator.PNG"));
			Messenger = ImageIO.read(getClass().getResource("/Images/Messenger.PNG"));
			Explorer = ImageIO.read(getClass().getResource("/Images/Explorer.PNG"));
			Pilot = ImageIO.read(getClass().getResource("/Images/Pilot.PNG"));
			Engineer = ImageIO.read(getClass().getResource("/Images/Engineer.PNG"));
			Diver = ImageIO.read(getClass().getResource("/Images/Diver.PNG"));
			Card_Crystal_of_Fire = ImageIO.read(getClass().getResource("/Images/Card_Crystal_of_Fire.png"));
			Card_Earth_Stone = ImageIO.read(getClass().getResource("/Images/Card_Earth_Stone.png"));
			Card_Oceans_Chalice = ImageIO.read(getClass().getResource("/Images/Card_Oceans_Chalice.png"));
			Card_Statue_of_the_Wind = ImageIO.read(getClass().getResource("/Images/Card_Statue_of_the_Wind.png"));
			Card_Helicopter = ImageIO.read(getClass().getResource("/Images/Card_Helicopter.png"));
			Card_Sand_Bag = ImageIO.read(getClass().getResource("/Images/Card_Sand_Bag.png"));
		}
		catch (Exception E){
			System.out.println("Roles not found");
		}
	}
	public void paint(Graphics g) {
		for(int i=0;i<p.getDeck().size();i++) {
			switch (p.getDeck().get(i)) {
			case "Fire":
				g.drawImage(Card_Crystal_of_Fire, i*136, 0, 136, 200, null);
				break;
			case "Stone":
				g.drawImage(Card_Earth_Stone, i*136, 0, 136, 200, null);
				break;
			case "Chalice":
				g.drawImage(Card_Oceans_Chalice, i*136, 0, 136, 200, null);
				break;
			case "Wind":
				g.drawImage(Card_Statue_of_the_Wind, i*136, 0, 136, 200, null);
				break;
			case "Helicopter":
				g.drawImage(Card_Helicopter, i*136, 0, 136, 200, null);
				break;
			case "Sandbag":
				g.drawImage(Card_Sand_Bag, i*136, 0, 136, 200, null);
				break;
			default:
				System.out.println("Error with player cards");
			}
		}
		switch (playerRole) {
		case "Navigator":
			g.drawImage(Navigator, 0, 0, 250, 180, null);
			break;
		case "Messenger":
			g.drawImage(Messenger, 0, 0, 250, 180, null);
			break;
		case "Explorer":
			g.drawImage(Explorer, 0, 0, 250, 180, null);
			break;
		case "Pilot": 
			g.drawImage(Pilot, 0, 0, 65, 50, null);
			break;
		case "Engineer": 
			g.drawImage(Engineer, 0, 0, 250, 180, null);
			break;
		case "Diver": 
			g.drawImage(Diver, 0, 0, 250, 180, null);
			break;
		default: 
			System.out.println("Player Role Not Found");
		}
		Graphics2D g2 = (Graphics2D) g;
		if(border) {
			g.setColor(Color.RED);
		}
		g2.setStroke(new BasicStroke(5));
		g.drawRect(0, 0, getWidth()-1, getHeight()-1);
		g.setColor(Color.BLACK);
	}
	public void highlightOn() {
		border=true;
	}
	public void highlightOff() {
		border=false;
	}
}

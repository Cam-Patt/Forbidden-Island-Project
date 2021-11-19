
import javax.imageio.ImageIO;
import javax.swing.JPanel;
import java.awt.image.BufferedImage;
import java.awt.Graphics;

public class playerPanel extends JPanel {
	private playerObject player;
	private String playerRole;
	private BufferedImage Navigator, Messenger, Explorer, Pilot, Engineer, Diver;
	public playerPanel(playerObject p) {
		player = p;
		playerRole = player.getRole();
		try {
			Navigator = ImageIO.read(getClass().getResource("/Images/Navigator.PNG"));
			Messenger = ImageIO.read(getClass().getResource("/Images/Messenger.PNG"));
			Explorer = ImageIO.read(getClass().getResource("/Images/Explorer.PNG"));
			Pilot = ImageIO.read(getClass().getResource("/Images/Pilot.PNG"));
			Engineer = ImageIO.read(getClass().getResource("/Images/Engineer.PNG"));
			Diver = ImageIO.read(getClass().getResource("/Images/Diver.PNG"));
			
		}
		catch (Exception E){
			System.out.println("Roles not found");
		}
	}
	public void paint(Graphics g) {
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
			g.drawImage(Pilot, 0, 0, 250, 180, null);
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
		for(int i=0;i<player.getDeck().size();i++) {
			switch (player.getDeck().get(i)) {
			case "Fire":
				g.drawImage(Card_Crystal_of_Fire, 100, 100, 100+i*120, 100, null);
				break;
			case "Stone":
				g.drawImage(Card_Earth_Stone, 100, 100, 100+i*120, 100, null);
				break;
			case "Chalice":
				g.drawImage(Card_Oceans_Chalice, 100, 100, 100+i*120, 100, null);
				break;
			case "Wind":
				g.drawImage(Card_Statue_of_the_Wind, 100, 100, 100+i*120, 100, null);
				break;
			case "Helicopter":
				g.drawImage(Card_Helicopter, 100, 100, 100+i*120, 100, null);
				break;
			case "Sandbag":
				g.drawImage(Card_Sand_Bag, 100, 100, 100+i*120, 100, null);
				break;
			default:
				System.out.println("Error with player cards");
		}
	}
}

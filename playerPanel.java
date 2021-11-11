
import javax.imageio.ImageIO;
import javax.swing.JPanel;
import java.awt.image.BufferedImage;
import java.awt.Graphics;

public class playerPanel extends JPanel {
	private String playerRole;
	private BufferedImage Navigator, Messenger, Explorer, Pilot, Engineer, Diver;
	public playerPanel(playerObject p) {
		playerRole = p.getRole();
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
	}
}

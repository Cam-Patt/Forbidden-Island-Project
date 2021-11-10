
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
		super.paintComponent(g);
		switch (playerRole) {
		case "Navigator":
			break;
		case "Messenger":
			break;
		case "Explorer":
			break;
		case "Pilot": 
			break;
		case "Engineer": 
			break;
		case "Diver": 
			break;
		default: 
			System.out.println("Player Role Not Found");
		}
	}
}

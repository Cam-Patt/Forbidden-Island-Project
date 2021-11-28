import java.awt.Graphics;
import java.awt.image.BufferedImage;
import javax.imageio.ImageIO;
import javax.swing.JPanel;

public class hasWonPanel extends JPanel{
	private BufferedImage background;

	public hasWonPanel(){
		try {
		  background = ImageIO.read(getClass().getResource("/Images/forbiddenisland.jpg"));
		}
		catch(Exception E) {
			System.out.println("hasWonPanel image error");
		}
	}
	public void paint(Graphics g){
		g.drawImage(background, 0, 0, 1200, 480, null);
		g.drawString("You have successfully escaped the island!", 400, 150);
		
	}
}

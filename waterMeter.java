import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.IOException;
import javax.imageio.ImageIO;
import javax.swing.JPanel;
public class waterMeter
{
	private BufferedImage meter;
	private int level;
	int cardsToDraw;
	
	public waterMeter(int difficulty)
	{
		level = difficulty;
		
		try
		{
			meter = ImageIO.read(WaterPanel.class.getResource("/images/WaterMeter.png"));
		}
		catch(Exception E)
		{
			System.out.println("Exception Error");
		}
		
	}
	
	public void rise()
	{
		level++;
	}
	
	public boolean hasLost()
	{
		if(level == 1 || level == 2)
		{
			cardsToDraw = 2;
			System.out.println("draw "+cardsToDraw+" cards");
			return false;
		}
		
		else if(level >=3 && level <=5)
		{
			cardsToDraw = 3;
			System.out.println("draw "+cardsToDraw+" cards");
			return false;
		}
		
		else if(level == 6 || level == 7)
		{
			cardsToDraw = 4;
			System.out.println("draw "+cardsToDraw+" cards");
			return false;
		}
		
		else if(level == 8 || level == 9)
		{
			cardsToDraw = 5;
			System.out.println("draw "+cardsToDraw+" cards");
			return false;
		}
		
		else if(level == 10)
		{
			System.out.println("game over");
			return true;
		}
		return false; // added only to suppress error in method
	}
	
	public void paint(Graphics g)
	{
		//g.drawImage(meter, 0, 0, 800, 400, null);
	}
}

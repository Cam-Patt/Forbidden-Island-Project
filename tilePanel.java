import java.awt.*;
import javax.swing.*;
import java.awt.image.BufferedImage;
import java.io.IOException;

public class tilePanel extends JPanel{
	private BufferedImage unFlooded;
	private BufferedImage Flooded;
	private BufferedImage shown;
	private TileObject t;
	public tilePanel(TileObject t) {
		unFlooded = t.getUnFloodedImage();
		Flooded = t.getFloodedImage();
		shown = Flooded;
		this.t = t;
	}
	public void paint(Graphics g) {
		g.drawImage(shown, 0,0,getWidth(), getHeight(),null);
	}
	public void flood() throws IOException {
		if(shown.equals(unFlooded)) {
			shown = Flooded;
		} else {
			t =  new TileObject("water","none","Tile_Flood_Water@2x.png", "Tile_Flood_Water@2x.png");
		}
	}
}

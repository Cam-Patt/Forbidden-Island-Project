import java.awt.image.*;
public class cardObject {
	private BufferedImage cardFace;
	private String title;
	public cardObject(BufferedImage i, String s) {
		cardFace = i;
		title = s;
	}
	public BufferedImage getFace() {
		return cardFace;
	}
	public String getTitle() {
		return title;
	}
	public boolean isEqual(cardObject c) {
		return(c.getTitle().equals(this.title));
	}
}

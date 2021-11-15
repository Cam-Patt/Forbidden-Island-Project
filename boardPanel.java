import java.awt.*;
import javax.swing.*;
public class boardPanel extends JPanel{
	private boardObject board;
	public boardPanel(boardObject b) {
		board = b;
	}
	public void paint(Graphics g) {
		TileObject[][] b = board.getBoard();
		GridLayout lay = new GridLayout(6,6);
		setLayout(lay);
		add(new tilePanel(b[0][0]),0,0);
	}
}

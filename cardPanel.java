
import javax.swing.JButton;
import javax.swing.JPanel;
import java.awt.Graphics;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class cardPanel extends JPanel implements MouseListener{
	public cardPanel() {
		setVisible(true);
		addMouseListener(this);
		JButton backButton = new JButton("Back");
		backButton.setSize(100, 30);
		backButton.setLocation(250, 250);
		
		
	}	
	public void paint(Graphics g) {
		super.paintComponent(g);
		
	}
	@Override
	public void mouseClicked(MouseEvent e) {
		
	}
	@Override
	public void mousePressed(MouseEvent e) {
		
	}
	@Override
	public void mouseReleased(MouseEvent e) {
		
	}
	@Override
	public void mouseEntered(MouseEvent e) {
		
	}
	@Override
	public void mouseExited(MouseEvent e) {
		
	}

}

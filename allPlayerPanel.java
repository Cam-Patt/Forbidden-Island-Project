import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.BasicStroke;
import java.awt.Color;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import java.util.ArrayList;
import java.awt.GridLayout;
import java.awt.LayoutManager;
import java.awt.ComponentOrientation;

public class allPlayerPanel extends JPanel {
    private ArrayList<playerObject> playerObjects;
    //private ArrayList<playerPanel> playerPanels;
    playerPanel p1, p2, p3, p4;
    public allPlayerPanel() {
    	p1 = new playerPanel();
    	add(p1);
    	p2 = new playerPanel();
    	add(p2);
    	p3 = new playerPanel();
    	add(p3);
    	p4 = new playerPanel();
    	add(p4);
    	setVisible(true);
    } 
    public void paint(Graphics g) {
    	p1.setSize(680, 200);
    	p2.setSize(680, 200);
    	p3.setSize(680, 200);
    	p4.setSize(680, 200);
    	p1.setLocation(0, 0);
    	p2.setLocation(685, 0);
    	p3.setLocation(0, 205);
    	p4.setLocation(685, 205);
    	p1.repaint();
    	p2.repaint();
    	p3.repaint();
    	p4.repaint();

    	
    }
    public void turn(int playerNum) { //draws a border around the player
    	p1.highlightOff();p2.highlightOff();p3.highlightOff();p4.highlightOff();
    	switch(playerNum) {
    	case 1:
    		p1.highlightOn();
    		break;
    	case 2:
    		p2.highlightOn();
    		break;
    	case 3:
    		p3.highlightOn();
    		break;
    	case 4:
    		p4.highlightOn();
    		break;
    	}
    	repaint();
    }
    public void highlight(ArrayList<playerObject> list) { //draws a border around all players in list
    	p1.highlightOff();p2.highlightOff();p3.highlightOff();p4.highlightOff();
    	for(int i=0;i<list.size();i++) {
    		switch(list.get(i).getNum()) {
        	case 1:
        		p1.highlightOn();
        		break;
        	case 2:
        		p2.highlightOn();
        		break;
        	case 3:
        		p3.highlightOn();
        		break;
        	case 4:
        		p4.highlightOn();
        		break;
        	}
    	}
    	repaint();
    }
}

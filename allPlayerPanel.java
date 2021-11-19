package Test;

import java.awt.Graphics;
import java.awt.Color;
import javax.swing.*;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import java.util.ArrayList;
import java.awt.GridLayout;
import java.awt.LayoutManager;
import java.awt.ComponentOrientation;

public class allPlayerPanel extends JPanel {
    //private ArrayList<playerObject> playerObjects;
    private ArrayList<playerPanel> playerPanels;
    int turnNum;
    playerPanel sub1, sub2, sub3, sub4;
   
    //GridLayout
    public allPlayerPanel() {
    	//playerPanel p1 = new playerPanel();
    	//playerPanel p2 = new playerPanel();
    	//playerPanel p3 = new playerPanel();
    	//playerPanel p4 = new playerPanel();
    	
    	
    	//JPanel main = new JPanel();
    	//main.setLayout(new GridLayout(2, 2));
    	//JPanel sub1 = new JPanel();
    	//sub1.setBackground(Color.BLUE);
    	//sub1.add(new JLabel("panel 1", SwingConstants.CENTER));
    	
    	//JPanel sub2 = new JPanel();
    	//sub2.setBackground(Color.RED);
    	//sub2.add(new JLabel("panel 2", SwingConstants.CENTER));
    	
//    	main.add(sub1);main.add(sub2);
//    	add(main);
    	//setComponentOrientation(ComponentOrientation.LEFT_TO_RIGHT);
    	
    	sub1 = new playerPanel();
    	add(sub1);
    	//sub1.setSize(200, 200);
    	
    	sub2 = new playerPanel();
    	add(sub2);
    	//sub2.setSize(200, 200);
    	
    	sub3 = new playerPanel();
    	add(sub3);
    	
    	sub4 = new playerPanel();
    	add(sub4);
   
    	setVisible(true);
    	//setLayout(new GridLayout(2, 2));
    	
    	
    	//add(p1);
    	//add(p2);
    	//add(p3);
    	//add(p4);
    	
    	//allPlayers.setSize(500, 500);
    	
    	//repaint();
    } 
    public void paint(Graphics g) {
//    	for(int i=0;i<playerObjects.size();i++) {
//    		if(playerObjects.get(i).getPlayerNum)
//    	}
    	g.fillRect(0, 0, this.getWidth(), this.getHeight());
    	sub1.repaint();
    	sub2.repaint();
    	sub3.repaint();
    	sub4.repaint();
    	
    }
    public void turn(int playerNum) { //draws a border around the player
    	
    	turnNum = playerNum;
    	for(int i=0;i<playerPanels.size();i++) {
    		
    		repaint();
    	}
    }
//    public void highlight(ArrayList<playerObject> list) { //draws a border around all players in list
//     	
//    }
}

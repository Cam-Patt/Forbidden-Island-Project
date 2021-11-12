//here is the frame that we will use
import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.Random;
public class ForbiddenIslandFrame extends JFrame{
	public static final int WIDTH = 1200;
	public static final int HEIGHT = 480;
	public ForbiddenIslandFrame(String frameT){
		super(frameT);
		setSize(WIDTH,HEIGHT);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setVisible(true);
		//JPanel j = new JPanel();
		titlePanel title = new titlePanel();
		add(title);
		while(!(title.start())) {
			//this is empty so the code runs til the start is set
		}
	}
	public ArrayList<playerObject> makePlayers(){
		ArrayList<playerObject> fullList = new ArrayList<playerObject>();
		//makes a list of all possible characters
		playerObject explorer;
		boolean[] abilities = {true,false,false,false,false,false};
		Color c = new Color(2);
		explorer = new playerObject("Explorer",abilities, c);
		playerObject pilot;
		boolean[] abilitie = {false,true,false,false,false,false};
		c = new Color(3);
		pilot = new playerObject("Pilot",abilitie, c);
		playerObject navigator;
		boolean[] ab = {false,false,true,false,false,false};
		c = new Color(4);
		navigator= new playerObject("Navigator", ab, c);
		playerObject diver;
		boolean[] b = {false,false,false,true,false,false};
		c = new Color(5);
		diver = new playerObject("Diver", b, c);
		playerObject engineer;
		boolean[] a = {false,false,false,false,true,false};
		c = new Color(6);
		engineer = new playerObject("Engineer",a,c);
		playerObject messenger;
		boolean[] list = {false,false,false,false,false,true};
		c = new Color(7);
		messenger = new playerObject("Messenger", list,c);
		
		fullList.add(explorer);
		fullList.add(pilot);
		fullList.add(navigator);
		fullList.add(diver);
		fullList.add(engineer);
		fullList.add(messenger);
		//randomly gets the characters from list
		for(int i =0; i < 4; i++) {
			Random r = new Random(12346);
		}
		return fullList;
	}
}

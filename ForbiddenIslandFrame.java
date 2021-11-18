//here is the frame that we will use
import javax.swing.*;
import java.awt.*;
import java.io.IOException;
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
		remove(title);
		try {
			boardPanel board = new boardPanel(new boardObject());
			add(board);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public ArrayList<playerObject> makePlayers() throws IOException{
		ArrayList<playerObject> fullList = new ArrayList<playerObject>();
		//makes a list of all possible characters
		playerObject explorer;
		boolean[] abilities = {true,false,false,false,false,false};
		Color c = new Color(2);
		explorer = new playerObject("Explorer",abilities, c, new TileObject("Copper Gate", "Explorer", "Copper Gate" + "@2x.png", "Copper Gate" + "_flood@2x.png"));
		playerObject pilot;
		boolean[] abilitie = {false,true,false,false,false,false};
		c = new Color(3);
		pilot = new playerObject("Pilot",abilitie, c, new TileObject("Fools' Landing" , "Pilot", "Fools' Landing" + "@2x.png", "Fools' Landing" + "_flood@2x.png"));
		playerObject navigator;
		boolean[] ab = {false,false,true,false,false,false};
		c = new Color(4);
		navigator= new playerObject("Navigator", ab, c, new TileObject("Gold Gate", "Navigator", "Gold Gate" + "@2x.png", "Gold Gate" + "_flood@2x.png"));
		playerObject diver;
		boolean[] b = {false,false,false,true,false,false};
		c = new Color(5);
		diver = new playerObject("Diver", b, c,new TileObject("Iron Gate", "Diver", "Iron Gate" + "@2x.png", "Iron Gate" + "_flood@2x.png"));
		playerObject engineer;
		boolean[] a = {false,false,false,false,true,false};
		c = new Color(6);
		engineer = new playerObject("Engineer",a,c, new TileObject("Bronze Gate", "Engineer", "Bronze Gate" + "@2x.png", "Bronze Gate" + "_flood@2x.png"));
		playerObject messenger;
		boolean[] list = {false,false,false,false,false,true};
		c = new Color(7);
		messenger = new playerObject("Messenger", list,c, new TileObject("Silver Gate", "Messenger", "Silver Gate" + "@2x.png", "Silver Gate" + "_flood@2x.png"));
		
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

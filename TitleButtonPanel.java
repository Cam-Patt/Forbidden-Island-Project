import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JPanel;
import java.awt.Color;
import java.awt.Font;

public class TitleButtonPanel extends JPanel implements ActionListener {
	private JComboBox<String> diff;
	private int difficulty;
	private boolean s; //can start or not
	public JButton start, info, temp;
	public TitleButtonPanel() {
		s = false;
		difficulty = 1;
		this.setLayout(new GridLayout(1, 2));
	
		String[] difficulty = {"Select Difficulty", "Novice", "[Default] Normal", "Elite", "Legendary"};
		diff = new JComboBox<String>(difficulty);
		diff.setBackground(Color.BLACK);
		diff.setForeground(Color.WHITE);
		diff.setFont(new Font(Font.SERIF, Font.BOLD, 25));

		
		start = new JButton("Start Game");
		start.addActionListener(this);
		start.setForeground(Color.WHITE);
		start.setBackground(Color.BLACK);
		start.setFont(new Font(Font.SERIF, Font.BOLD, 25));
		
		info = new JButton("Get Instructions");
		info.addActionListener(this);
		info.setBackground(Color.BLACK);
		info.setForeground(Color.WHITE);
		info.setFont(new Font(Font.SERIF, Font.BOLD, 25));
		
		this.add(start);
		this.add(diff);
		this.add(info);
		this.setVisible(true);
	}

	public void actionPerformed(ActionEvent e) {
		if(e.getSource() == start) {
			if (diff.getSelectedIndex() != 0 ) {
				//This is where you get Difficulty
				
				System.out.println("difficulty in titlebutton panel " + difficulty);
				s = true;
			}
			else {
				System.out.println("Select Difficulty");
			}
		}
		else if(e.getSource() == info) {
			System.out.println("Do Whatever");
				print();
			}
		}	
	public void print()  {
		String f = "Forbidden Island Instructions\r\n"
				+ "Set-Up\r\n"
				+ "Read the instructions :)\r\n"
				+ "Set the difficulty you wish to play (Novice(0), Normal(1), Elite(2), and Legendary(3))\r\n"
				+ "Press the start button\r\n"
				+ "B. Turn\r\n"
				+ "Choose 1-3 of the following Actions\r\n"
				+ "Move\r\n"
				+ "Press the move button at the bottom of the screen\r\n"
				+ "Press the highlighted tile on the board. If there are multiple highlighted tiles pick, one you would like to move to.\r\n"
				+ "Shore Up\r\n"
				+ "Press the shore up at the bottom of the screen\r\n"
				+ "Press the highlighted tile on the board. If there are multiple highlighted tiles pick one, you would like to shore up.\r\n"
				+ "Give Cards\r\n"
				+ "Press the given cards at the bottom of the screen\r\n"
				+ "Press the player’s hand that you wish to give cards to (it should be highlighted).\r\n"
				+ "Press the card you wish to give to the other player\r\n"
				+ "If that player has more than 5 cards, press the player’s card they wish to discard, or they can play a special action card with the special action card button\r\n"
				+ "Get Treasure\r\n"
				+ "You can only give a treasure if you have 4 of the proper treasure cards, and on the corresponding island\r\n"
				+ "Draw Cards\r\n"
				+ "Ends turn, by drawing 2 cards from the Treasure Deck\r\n"
				+ "If your hand contains more than 5 cards, click the cards you wish to discard or play your special action cards till you only have 5 cards remaining \r\n"
				+ "Special Action Card\r\n"
				+ "Press one of the highlighted special action cards\r\n"
				+ "If the card you select is a helicopter card, select one of the highlighted tiles, then a second one. (It will transfer everyone on the first selected tile to the second selected tile)\r\n"
				+ "If the card you select is a sand bag card, select one of the highlighted flooded tiles to flip it up.\r\n"
				+ "*Note: After you draw cards, flood cards are drawn equal to the number stated on the water meter on the right side of the screen\r\n"
				+ "**First is Player 1’s turn, then Player’s 2 and so on till it is Player’s 4 turn, then it is Player’s 1 turn again\r\n"
				+ "C. Winning the Game\r\n"
				+ "To win the game, all 4 players must be on fool’s landing, with all 4 treasure’s collected, and one player possessing a helicopter action card\r\n"
				+ "Press the win game button at the bottom of the screen\r\n"
				+ "D.Losing the Game\r\n"
				+ "If Fool’s Landing sinks, you lose the game\r\n"
				+ "If the both Temples, Caves, Palaces, or Gardens sink before you collect their respective treasures\r\n"
				+ "If any player is on an Island tile that sinks and there is adjacent tile to swim to\r\n"
				+ "If the water level reaches the skull and cross bones";
		File o = new File("instruction.txt");
			PrintWriter outfile;
			try {
				outfile = new PrintWriter(o);
				outfile.write(f);
				outfile.close();
			} catch (FileNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	}
	public boolean start() {
		return s;
	}
	public int getDifficulty() {
		difficulty = diff.getSelectedIndex();
		return difficulty;
	}
}

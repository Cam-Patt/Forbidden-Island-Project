import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.Iterator;
import java.util.Random;
public class boardObject {
	private TileObject[][] boardMatrix;
	private ArrayList<TileObject> tiles;
	public boardObject() throws IOException {
		boardMatrix = new TileObject[6][6];
		tiles = new ArrayList<TileObject>();	
		/* Making all the tiles*/
		//tiles.add( new TileObject("Breakers Bridge","none","Breakers Bridge@2x.png", "Breakers Bridge_flood@2x.png"));
		File f = new File("tileList.txt"); //has the name of each tile
		Scanner tileTitle = new Scanner(f);
		while(tileTitle.hasNext()) {
			String title = tileTitle.nextLine();
			TileObject t;
			if(title.equals("Tidal Palace")) {
				 t = new TileObject(title, "Ocean", title + "@2x.png", title + "_flood@2x.png");

			}
			if(title.equals("Coral Palace")) {
				 t = new TileObject(title, "Ocean", title + "@2x.png", title + "_flood@2x.png");

			}
			if(title.equals("Temple of the Moon")) {
				 t = new TileObject(title, "Earth", title + "@2x.png", title + "_flood@2x.png");

			}
			if(title.equals("Temple of the Sun")) {
				 t = new TileObject(title, "Earth", title + "@2x.png", title + "_flood@2x.png");

			}
			if(title.equals("Cave of Shadows")) {
				 t = new TileObject(title, "Fire", title + "@2x.png", title + "_flood@2x.png");

			}
			if(title.equals("Cave of Embers")) {
				 t = new TileObject(title, "Fire", title + "@2x.png", title + "_flood@2x.png");

			}
			if(title.equals("Howling Garden")) {
				 t = new TileObject(title, "Wind", title + "@2x.png", title + "_flood@2x.png");

			}
			if(title.equals("Whispering Garden")) {
				 t = new TileObject(title, "Wind", title + "@2x.png", title + "_flood@2x.png");

			}
			if(title.equals("Fools' Landing")) {
				 t = new TileObject(title, "Pilot", title + "@2x.png", title + "_flood@2x.png");

			}
			if(title.equals("Gold Gate")) {
				 t = new TileObject(title, "Navigator", title + "@2x.png", title + "_flood@2x.png");

			}
			if(title.equals("Iron Gate")) {
				 t = new TileObject(title, "Diver", title + "@2x.png", title + "_flood@2x.png");

			}
			if(title.equals("Copper Gate")) {
				 t = new TileObject(title, "Explorer", title + "@2x.png", title + "_flood@2x.png");

			}
			if(title.equals("Silver Gate")) {
				 t = new TileObject(title, "Messenger", title + "@2x.png", title + "_flood@2x.png");

			}
			if(title.equals("Bronze Gate")) {
				 t = new TileObject(title, "Engineer", title + "@2x.png", title + "_flood@2x.png");

			}
			else {
				t = new TileObject(title, "none", title + "@2x.png", title + "_flood@2x.png");

			}
			tiles.add(t);
		}
		/* w = water
		 * t = tiles
		 * 
		 *   0 1 2 3 4 5
		 *0  w w t t w w
		 *1  w t t t t w
		 *2  t t t t t t
		 *3  t t t t t t
		 *4  w t t t t w
		 *5  w w t t w w*/
		shuffle(12346);
	}
	public void shuffle(int sed) throws IOException {
		ArrayList<TileObject> temp = new ArrayList<TileObject>();
		Random r = new Random(sed);
		while(tiles.size() > 0) {
			int index = r.nextInt(tiles.size());
			temp.add(tiles.get(index));
			tiles.remove(index);
	
		}
		tiles = temp;
		fill(tiles);
	}
	public void fill(ArrayList<TileObject>t) throws IOException {
		Iterator<TileObject> iter = t.iterator();
		/*
		    0 1 2 3 4 5
		 *0  w w t t w w
		 *1  w w t t w w
		 *2  w w t t w w
		 *3  w w t t w w
		 *4  w w t t w w
		 *5  w w t t w w*/
		for(int i = 0; i < boardMatrix.length; i++) {
			boardMatrix[i][2] = iter.next();
			boardMatrix[i][3] = iter.next();
		}
		
		/*
	    0 1 2 3 4 5
	 *0  w w t t w w
	 *1  w w t t w w
	 *2  t t t t w w
	 *3  t t t t w w
	 *4  w w t t w w
	 *5  w w t t w w*/
		boardMatrix[2][0] = iter.next();
		boardMatrix[2][1] = iter.next();
		boardMatrix[3][0] = iter.next();
		boardMatrix[3][1] = iter.next();
		
		/*
	    0 1 2 3 4 5
	 *0  w w t t w w
	 *1  w w t t w w
	 *2  t t t t t t
	 *3  t t t t t t
	 *4  w w t t w w
	 *5  w w t t w w*/
		boardMatrix[2][4] = iter.next();
		boardMatrix[2][5] = iter.next();
		boardMatrix[3][4] = iter.next();
		boardMatrix[3][5] = iter.next();
		
		/*
	    0 1 2 3 4 5
	 *0  w w t t w w
	 *1  w t t t t w
	 *2  t t t t t t
	 *3  t t t t t t
	 *4  w t t t t w
	 *5  w w t t w w*/
		boardMatrix[1][1] = iter.next();
		boardMatrix[1][4] = iter.next();
		boardMatrix[4][1] = iter.next();
		boardMatrix[4][4] = iter.next();
		
		//filling the rest with water
		for(int r = 0; r < boardMatrix.length; r++) {
			for(int c = 0; c < boardMatrix[r].length; c++) {
				if(boardMatrix[r][c] == null) {
					boardMatrix[r][c] = new TileObject("water","none","Tile_Flood_Water@2x.png", "Tile_Flood_Water@2x.png");
					boardMatrix[r][c].setCanTravel(false);
				}
			}
		}
	}
	public TileObject[][] getBoard() {
		return boardMatrix;
	}
	public String toString() {
		String str = "";
		for(int l = 0; l < boardMatrix.length; l++) {
			for(int g = 0; g < boardMatrix[l].length; g++) {
			str+=("|"+boardMatrix[l][g].getName() + "|");
			}
			str += "\n";
		}
		return str;
	}
}

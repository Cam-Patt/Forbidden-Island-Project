import java.util.ArrayList;
import java.util.TreeMap;
public class coordinate 
{
	private ArrayList <TileObject> tiles = new ArrayList<>();
	private TreeMap<String, String> coordinates = new TreeMap<>();
	
	public coordinate(ArrayList<TileObject> t)
	{
		tiles = t;
		
		coordinates.put("A1", null);
		coordinates.put("A2", null);
		coordinates.put("B1", null);
		coordinates.put("B2", null);
		coordinates.put("B3", null);
		coordinates.put("B4", null);
		coordinates.put("C1", null);
		coordinates.put("C2", null);
		coordinates.put("C3", null);
		coordinates.put("C4", null);
		coordinates.put("C5", null);
		coordinates.put("C6", null);
		coordinates.put("D1", null);
		coordinates.put("D2", null);
		coordinates.put("D3", null);
		coordinates.put("D4", null);
		coordinates.put("D5", null);
		coordinates.put("D6", null);
		coordinates.put("E1", null);
		coordinates.put("E2", null);
		coordinates.put("E3", null);
		coordinates.put("E4", null);
		coordinates.put("F1", null);
		coordinates.put("F2", null);

	}
}

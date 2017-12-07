package mainGame;

import java.util.LinkedList;
import java.util.Queue;

public class MainClass {

	static Character maxwell = new Character("Maxwell");
	static Location endLocation;

	private static void doAnalysis(int i, int j, char loc) {
		try {
			switch (loc) {
			case '@': {
				Location tmp = new Location(j, i, null);
				maxwell.location = tmp;
				break;
			}
			
			case 'Y': {
				Location tmp = new Location(j, i, null);
				tmp.myItem = new Item('Y', "Yakıt Bidonu");
				maxwell.necessaryItems.add(tmp);
				break;
			}
			case 'H': {
				Location tmp = new Location(j, i, null);
				tmp.myItem = new Item('H', "Anahtar");
				maxwell.necessaryItems.add(tmp);
				break;
			}
			case 'A': {
				Location tmp = new Location(j, i, null);
				tmp.myItem = new Item('A', "Anten");
				maxwell.necessaryItems.add(tmp);
				break;
			}
			case 'J': {
				Location tmp = new Location(j, i, null);
				tmp.myItem = new Item('J', "Jeneratör");
				maxwell.necessaryItems.add(tmp);
				break;
			}
			
			case 'W': {
				Item item = new Item('W', "Tahta Kulübe");
				Location tmp = new Location(j, i, item);
				endLocation = tmp;
				break;
			}
			}

		} catch (Exception err) {
			err.printStackTrace();
		}
	}

	private static void analysisLoc(char[][] map) {
		try {
			for (int i = 0; i < map.length; i++) {
				for(int j = 0; j < map[i].length; j++)
				{
					doAnalysis(i, j, map[i][j]);
				}
			}
		} catch (Exception err) {
			err.printStackTrace();
		}
	}

	
	public static void main(String[] args) {

		char[][] Map = {
				{ 'o', 'o', 'o', 'o', 'o', 'o', 'o', 'o', 'o', 'B', '.', '.', '.', '.', '.', '.', '.', '.', '.', '.','.', '.', '.', '.', '.', '.', '.', '.', '.' },
				{ '@', 'S', 'T', 'T', 'S', 'o', 'o', 'o', 'o', 'V', '.', '.', '.', '.', '.', '.', '.', '.', '.', '.','.', '.', '.', '.', '.', '.', '.', '.', '.' },
				{ 'o', 'o', 'o', 'o', 'Y', 'B', 'V', 'B', 'V', 'B', '.', '.', '.', '.', '.', 'S', 'o', 'o', 'o', 'o','o', 'J', 'o', '.', '.', '.', '.', '.', '.' },
				{ '.', '.', '.', '.', '.', '.', '.', '.', '.', '.', '.', '.', '.', '.', '.', 'o', 'o', 'o', 'o', 'A','o', 'o', 'o', '.', '.', '.', '.', '.', '.' },
				{ '.', '.', '.', '.', '.', '.', '.', '.', '.', '.', '.', '.', '.', '.', '.', 'W', 'o', 'o', 'o', 'o','o', 'o', 'H', '.', '.', '.', '.', '.', '.' } };

		analysisLoc(Map);
		Queue<Location> path = new LinkedList<Location>();
		path = maxwell.findPath(maxwell.location, Map, endLocation);
		maxwell.Move(path);
		maxwell.printPath();
	}

}

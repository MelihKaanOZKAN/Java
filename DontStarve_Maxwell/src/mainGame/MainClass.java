package mainGame;

import java.util.Queue;

public class MainClass {

	static Character maxwell = new Character("Maxwell");
	static Location endLocation;

	private static void doAnalysis(int i, int j, char loc) {
		try {
			switch (loc) {
			case '@': {
				Location tmp = new Location(i, j, null);
				maxwell.location = tmp;
				break;
			}
			
			case 'W': {
				Item item = new Item('W', "Tahta Kulübe");
				Location tmp = new Location(i, j, item);
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

	private static Queue<String> pathFinder(char[][] Map ){
		return null;
		
	}
	
	
	public static void main(String[] args) {

		char[][] Map = {
				{ 'o', 'o', 'o', 'o', 'o', 'o', 'o', 'o', 'o', 'B', '.', '.', '.', '.', '.', '.', '.', '.', '.', '.',
						'.', '.', '.', '.', '.', '.', '.', '.', '.' },
				{ '@', 'o', 'T', 'T', 'o', 'o', 'o', 'o', 'o', 'V', '.', '.', '.', '.', '.', '.', '.', '.', '.', '.',
						'.', '.', '.', '.', '.', '.', '.', '.', '.' },
				{ 'o', 'o', 'o', 'o', 'Y', 'B', 'V', 'B', 'V', 'B', '.', '.', '.', '.', '.', 'S', 'H', 'o', 'o', 'o',
						'o', 'o', 'o', '.', '.', '.', '.', '.', '.' },
				{ '.', '.', '.', '.', '.', '.', '.', '.', '.', '.', '.', '.', '.', '.', '.', 'o', 'A', 'o', 'o', 'o',
						'o', 'o', 'o', '.', '.', '.', '.', '.', '.' },
				{ '.', '.', '.', '.', '.', '.', '.', '.', '.', '.', '.', '.', '.', '.', '.', 'o', 'o', 'o', 'o', 'o',
						'J', 'o', 'W', '.', '.', '.', '.', '.', '.' } };

		analysisLoc(Map);
		maxwell.CalcDistance();
		System.out.println(maxwell.necessaryItems.get(maxwell.GetNearest()).myItem.name);
	}

}

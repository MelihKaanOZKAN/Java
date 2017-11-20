package mainGame;

public class MainClass {

	static Character maxwell;
	static Location endLocation;

	private static Location[][] analysisLoc(char[][] map) {
		Location result[][] = new Location[map.length][map[0].length];
		try {
			for (int i = 0; i < map.length; i++) {

				for (int j = 0; i < map[i].length; j++) {
					System.out.println(map.length + " " + map[i].length + " " +i + " " + j + " " + map[i][j]);
					switch (map[i][j]) {
					case '@': {
						Location tmp = new Location(i, j, null);
						maxwell = new Character("Maxwell", tmp);
						result[i][j] = tmp;
						break;
					}
					case 'o': {
						Location tmp = new Location(i, j, null);
						result[i][j] = tmp;
						break;
					}
					case '.': {
						Location tmp = new Location(i, j, null);
						result[i][j] = tmp;
						break;
					}
					case 'S': {
						Item item = new Item('S', "Saman Destesi");
						Location tmp = new Location(i, j, item);
						result[i][j] = tmp;
						break;
					}
					case 'T': {
						Item item = new Item('T', "Dal Parçasý");
						Location tmp = new Location(i, j, item);
						result[i][j] = tmp;
						break;
					}
					case 'B': {
						Item item = new Item('B', "Bambu");
						Location tmp = new Location(i, j, item);
						result[i][j] = tmp;
						break;
					}
					case 'W': {
						Item item = new Item('W', "Tahta Kulübe");
						Location tmp = new Location(i, j, item);
						result[i][j] = tmp;
						endLocation = tmp;
						break;
					}
					case 'V': {
						Item item = new Item('V', "Sarmaþýk");
						Location tmp = new Location(i, j, item);
						result[i][j] = tmp;
						break;
					}
					case 'H': {
						Item item = new Item('H', "Anahtar");
						Location tmp = new Location(i, j, item);
						result[i][j] = tmp;
						maxwell.necessaryItems.push(item);
						break;
					}
					case 'Y': {
						Item item = new Item('Y', "Yakýt Bidonu");
						Location tmp = new Location(i, j, item);
						result[i][j] = tmp;
						maxwell.necessaryItems.push(item);
						break;
					}
					case 'J': {
						Item item = new Item('J', "Jeneratör");
						Location tmp = new Location(i, j, item);
						result[i][j] = tmp;
						maxwell.necessaryItems.push(item);
						break;
					}
					case 'A': {
						Item item = new Item('A', "Anten");
						Location tmp = new Location(i, j, item);
						result[i][j] = tmp;
						maxwell.necessaryItems.push(item);
						break;
					}
					}
				}
			}
		} catch (Exception err) {

		}
		return result;
	}

	public static void main(String[] args) {

		char[][] Map = {
				{ 'o', 'o', 'o', 'o', 'o', 'o', 'o', 'o', 'o', 'B', '.', '.', '.', '.', '.', '.', '.', '.', '.', '.',
						'.', '.', '.', '.', '.', '.', '.', '.', '.' },
				{ '@', 'S', 'T', 'T', 'S', 'o', 'o', 'o', 'o', 'V', '.', '.', '.', '.', '.', '.', '.', '.', '.', '.',
						'.', '.', '.', '.', '.', '.', '.', '.', '.' },
				{ 'o', 'o', 'o', 'o', 'Y', 'B', 'V', 'B', 'V', 'B', '.', '.', '.', '.', '.', 'S', 'H', 'o', 'o', 'o',
						'o', 'o', 'o', '.', '.', '.', '.', '.', '.' },
				{ '.', '.', '.', '.', '.', '.', '.', '.', '.', '.', '.', '.', '.', '.', '.', 'o', 'A', 'o', 'o', 'o',
						'o', 'o', 'o', '.', '.', '.', '.', '.', '.' },
				{ '.', '.', '.', '.', '.', '.', '.', '.', '.', '.', '.', '.', '.', '.', '.', 'o', 'o', 'o', 'o', 'o',
						'J', 'o', 'W', '.', '.', '.', '.', '.', '.' } };

		Location[][] locMap = analysisLoc(Map);
		System.out.println(endLocation.X);
	}

}

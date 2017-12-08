package mainGame;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
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
			case 'S': {
				Location tmp = new Location(j, i, null);
				tmp.myItem = new Item('S', "Saman Destesi");
				maxwell.necessaryItems.add(tmp);
				break;
			}

			case 'T': {
				Location tmp = new Location(j, i, null);
				tmp.myItem = new Item('T', "Çubuk");
				maxwell.necessaryItems.add(tmp);
				break;
			}
			case 'B': {
				Location tmp = new Location(j, i, null);
				tmp.myItem = new Item('B', "Bambu");
				maxwell.necessaryItems.add(tmp);
				break;
			}

			case 'V': {
				Location tmp = new Location(j, i, null);
				tmp.myItem = new Item('V', "Sarmaşık");
				maxwell.necessaryItems.add(tmp);
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
				for (int j = 0; j < map[i].length; j++) {
					doAnalysis(i, j, map[i][j]);
				}
			}
		} catch (Exception err) {
			err.printStackTrace();
		}
	}

	@SuppressWarnings("resource")
	private static char[][] readMap(String path) {
		char[][] result = null;

		try {
			File file = new File(path);
			BufferedReader br = new BufferedReader(new FileReader(file));

			String mainMap = "";
			for (String line; (line = br.readLine()) != null;) {
				mainMap += line;
				mainMap += "-";
			}

			String[] tmp = mainMap.split("-");
			int x = tmp[0].length();
			int y = tmp.length;
			result = new char[y][x];
			for (int i = 0; i < y; i++) {
				result[i] = tmp[i].toCharArray();
			}
		} catch (Exception err) {
			err.printStackTrace();
		}

		return result;
	}

	public static void main(String[] args) {

		System.out.println("Maxwell Carter kendini bir adada zifiri karanlığın içinde bulur.\r\n"
				+ "Yanında sadece bir meşale vardır ve meşalesiz ilerleyememektedir.\r\n"
				+ "Adalar takımından kurtulabilmesi için radyo vericisinden dış dünyaya\r\n"
				+ "yardım sinyali göndermeyi akıl eder. Ancak radyo vericisi kilitli bir tahta\r\n"
				+ "kulübe içerisindedir. Bu vericiyi çalıştırabilmek için jeneratör, yakıt ve\r\n"
				+ "anten ile kulübeyi açmak için bir anahtar gerekmektedir...");

		System.out.println("\n\n\nGerekli malzemeleri toplamak için aşağıdaki yolu izledi.. ");
		char[][] Map;
		Map = readMap("C:\\Map.txt"); // Dosyadan Harita Okuma
		analysisLoc(Map);
		Queue<Location> path = new LinkedList<Location>();
		path = maxwell.findPath(maxwell.location, Map, endLocation);
		maxwell.Move(path);
		maxwell.printPath();
	}

}

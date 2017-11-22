package mainGame;

public class Location {
	protected int X;
	protected int Y;
	protected Item myItem;

	public Location(int x, int y, Item item) {
		try {
			this.X = x;
			this.Y = y;
			this.myItem = item;
		} catch (Exception err) {

		}
	}

	private Item getItem(char symbol) {
		Item result = null;
		try {
			switch (symbol) {
			case 'S': {
				result = new Item('S', "Saman Destesi");
				break;
			}
			case 'T': {
				result = new Item('T', "Dal Parçasý");
				break;
			}
			case 'B': {
				result = new Item('B', "Bambu");
				break;
			}
			case 'V': {
				result = new Item('V', "Sarmaþýk");
				break;
			}
			case 'Y': {
				result = new Item('Y', "Yakýt Bidonu");
				break;
			}
			case 'H':{
				result = new Item ( 'H', "Anahtar");
				break;
			}
			case 'A':{
				result = new Item ( 'A', "Anahtar");
				break;
			}
			case 'J':{
				result = new Item ( 'J', "Jeneratör");
				break;
			}
			}
		} catch (Exception err) {
			err.printStackTrace();
		}
		return result;
	}

	public Location north(char[][] Map) {
		Location tmp = new Location(X, Y - 1, null);
		tmp.myItem = getItem(Map[tmp.X][tmp.Y]);
		return tmp;
	}

	public Location south(char[][] Map) {
		Location tmp = new Location(X, Y + 1, null);
		tmp.myItem = getItem(Map[tmp.X][tmp.Y]);
		return tmp;
	}

	public Location east(char[][] Map) {
		Location tmp = new Location(X + 1, Y, null);
		tmp.myItem = getItem(Map[tmp.X][tmp.Y]);
		return tmp;
	}

	public Location west(char[][] Map) {
		Location tmp = new Location(X - 1, Y, null);
		tmp.myItem = getItem(Map[tmp.X][tmp.Y]);
		return tmp;
	}
}

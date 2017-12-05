package mainGame;

public class Location {
	protected int X;
	protected int Y;
	protected Item myItem;
	protected boolean isWater = false;

	protected boolean south;
	protected boolean north;
	protected boolean east;
	protected boolean west;

	public Location(int x, int y, Item item) {
		try {
			this.X = x;
			this.Y = y;
			this.myItem = item;
		} catch (Exception err) {

		}
	}

	private Location getItem(char symbol, Location loc) {
		Location result = loc;
		try {
			switch (symbol) {
			case 'S': {
				result.myItem = new Item('S', "Saman Destesi");
				break;
			}
			case 'T': {
				result.myItem = new Item('T', "Dal Par�as�");
				break;
			}
			case 'B': {
				result.myItem = new Item('B', "Bambu");
				break;
			}
			case 'V': {
				result.myItem = new Item('V', "Sarma��k");
				break;
			}
			case 'Y': {
				result.myItem = new Item('Y', "Yak�t Bidonu");
				break;
			}
			case 'H': {
				result.myItem = new Item('H', "Anahtar");
				break;
			}
			case 'A': {
				result.myItem = new Item('A', "Anahtar");
				break;
			}
			case 'J': {
				result.myItem = new Item('J', "Jenerat�r");
				break;
			}
			case '.': {
				result.isWater = true;
				break;
			}
			}
		} catch (Exception err) {
			err.printStackTrace();
		}
		return result;
	}

	public Location north(char[][] Map) {
		Location tmp = new Location(X - 1, Y, null);
		if (tmp.X > 0 && tmp.Y > 0 && tmp.X <= Map.length && tmp.Y <= Map[0].length) {
			tmp = getItem(Map[tmp.X][tmp.Y], tmp);
			return tmp;
		} else {
			return null;
		}
	}

	public Location south(char[][] Map) {
		Location tmp = new Location(X + 1, Y, null);
		if (tmp.X > 0 && tmp.Y > 0 && tmp.X <= Map.length && tmp.Y <= Map[0].length) {
			tmp = getItem(Map[tmp.X][tmp.Y], tmp);
			return tmp;
		} else {
			return null;
		}
	}

	public Location east(char[][] Map) {
		Location tmp = new Location(X, Y + 1, null);
		 System.out.println("A:" +tmp.X + "A:" + tmp.Y + "A:" + Map[0].length + "A:"
		 +Map.length);
		if (tmp.X > 0 && tmp.Y > 0 && tmp.X <= Map.length && tmp.Y <= Map[0].length) {
			tmp = getItem(Map[tmp.X][tmp.Y], tmp);
			return tmp;
		} else {
			return null;
		}
	}

	public Location west(char[][] Map) {
		Location tmp = new Location(X, Y - 1, null);
		if (tmp.X > 0 && tmp.Y > 0 && tmp.X <= Map.length && tmp.Y <= Map[0].length) {
			tmp = getItem(Map[tmp.X][tmp.Y], tmp);
			return tmp;
		} else {
			return null;
		}
	}
}

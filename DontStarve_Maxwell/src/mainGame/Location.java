package mainGame;

public class Location {
	protected int X;
	protected int Y;
	protected Item myItem;
	
	public Location(int x, int y, Item item)
	{
		try {
			this.X = x;
			this.Y=y;
			this.myItem = item;
		} catch (Exception err) {

		}
	}
}

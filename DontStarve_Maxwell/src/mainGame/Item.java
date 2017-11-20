package mainGame;

public class Item {

	protected char symbol;
	protected String name;
	public Item(char symbol, String name)
	{
		try {
			this.symbol = symbol;
			this.name = name;
		} catch (Exception err) {

		}
	}
	public String toString() {
		String result = null;
		try {
			result =  "(" + this.symbol + "," + this.name + ")";
		} catch (Exception err) {

		}
		return result;
	}
}

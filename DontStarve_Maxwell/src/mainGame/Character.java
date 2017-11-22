package mainGame;

import java.util.Comparator;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class Character {

	String name;
	protected boolean isTorchActive;
	protected int torchLife;
	private Inventory inventory;
	char symbol = '@';
	Location location;
	Queue<String> correctPath;
	LinkedList<Location> necessaryItems = new LinkedList<Location>();
	int[] necessaryItems_Distance;

	public Character(String name) {
		try {
			this.name = name;
			isTorchActive = true;
			torchLife = 15;
			inventory = new Inventory();

		} catch (Exception err) {

		}
	}

	protected void addItemToInventory(Item item) {
		try {
			inventory.addItemToPartition(item);
		} catch (Exception err) {

		}
	}

	protected Item[] getItemFromInventory(char symbol, int piece) {
		Item[] result = null;
		try {
			for (int i = 0; i < piece; i++) {
				result[i] = inventory.getItem(symbol);
			}
		} catch (Exception err) {
			err.getStackTrace();
		}
		return result;
	}

	protected boolean CanMove() {
		boolean result = false;
		try {
			if (torchLife == 0) {
				isTorchActive = false;
				if (inventory.inventory.get(8).isEmpty()) {
					result = false;
				} else {
					result = true;
				}
			} else {
				result = true;
			}

		} catch (Exception err) {

		}
		return result;
	}

	private int calcDistance(Location calc, Location loc) {
		int result = 0;
		try {
			result = (int) Math.sqrt((calc.X - loc.X) ^ 2 - (calc.Y - loc.Y) ^ 2);
		} catch (Exception err) {
			err.printStackTrace();
		}

		return result;
	}

	@SuppressWarnings("unchecked")
	protected void CalcDistance() {
		try {
			necessaryItems_Distance = new int[necessaryItems.size()];
			for (int i = 0; i < necessaryItems.size(); i++) {
				necessaryItems_Distance[i] = calcDistance(necessaryItems.get(i), location);
			}
		} catch (Exception err) {
			err.printStackTrace();
		}
	}

	protected int GetNearest() {
		int result = -1;
		try {
			int refDistance = necessaryItems_Distance[0];
			int index = -1;
			for (int i = 0; i < necessaryItems.size(); i++) {
				if (refDistance > necessaryItems_Distance[i] && necessaryItems_Distance[i] != -1)
					;
				{
					refDistance = necessaryItems_Distance[i];
					index = i;
				}
			}
			necessaryItems_Distance[index] = -1;
			result = index;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return result;
	}

	protected Item craftTorch() {
		Item result = null;
		try {

			Item[] straw = this.getItemFromInventory('*', 2);
			isTorchActive = true;
			torchLife = 15;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return result;
	}

	protected void Move(Location dest) {
		try {
			if (CanMove()) {
				if (isTorchActive) {

				}
				location = dest;
				if (location.myItem != null) {
					inventory.addItemToPartition(location.myItem);
				}
			} else {
				System.out.println("Maxwell DEAD! :(");
				System.exit(0);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}

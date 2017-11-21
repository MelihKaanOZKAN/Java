package mainGame;

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
	LinkedList<Item> necessaryItems = new LinkedList<Item>();

	public Character(String name, Location location) {
		try {
			this.name = name;
			this.location = location;
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

	protected Item getItemFromInventory(char symbol) {
		Item result = null;
		try {
			result = inventory.getItem(symbol);
		} catch (Exception err) {

		}
		return result;
	}

	protected void makeTorch() {
		try {
				
		} catch (Exception err) {

		}
	}
}

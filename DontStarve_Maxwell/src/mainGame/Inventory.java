package mainGame;

import java.util.LinkedList;

public class Inventory {

	protected LinkedList<LinkedList> inventory = new LinkedList<LinkedList>();

	public Inventory() {
		try {
			for (int i = 0; i < 10; i++) {
				inventory.addLast(new LinkedList<Item>());
			}
		} catch (Exception err) {

		}
	}

	protected void viewItems() {
		try {
			for (int i = 0; i < 10; i++) {
				System.out.println("Bölme " + i + " : ");
				if (inventory.get(i).isEmpty()) {
					System.out.println(" Bölme Boþ");
				} else {
					@SuppressWarnings("unchecked")
					LinkedList<Item> tmp = inventory.get(i);
					System.out.println(tmp.getFirst().symbol + " " + tmp.getFirst().name + " " + tmp.size());
				}
			}
		} catch (Exception err) {

		}
	}

	@SuppressWarnings("unchecked")
	protected void addItemToPartition(Item item) {
		try {
			switch (item.symbol) {
			case 'S': {
				inventory.get(0).add(item);
				//System.out.println("In");
				break;
			}
			case 'T': {
				inventory.get(1).add(item);
				break;
			}
			case 'B': {
				inventory.get(2).add(item);
				break;
			}
			case 'V': {
				inventory.get(3).add(item);
				break;
			}
			case 'Y': {
				inventory.get(4).add(item);
				break;
			}
			case 'H': {
				inventory.get(5).add(item);
				break;
			}
			case 'J': {
				inventory.get(6).add(item);
				break;
			}
			case 'A': {
				inventory.get(7).add(item);
				break;
			}
			case '*': {
				inventory.get(8).add(item);
				break;
			}
			case '#': {
				inventory.get(9).add(item);
				break;
			}
			}
		} catch (Exception err) {

		}
	}

	protected Item getItem(char symbol) {
		Item result = null;
		try {
			switch (symbol) {
			case 'S': {
				if(inventory.get(0).size() != 0)
				{
					result =  (Item) inventory.get(0).removeLast();
					//System.out.println("Out");
				}
				break;
			}
			case 'T': {
				if(inventory.get(1).size() != 0)
				{
					result =  (Item) inventory.get(1).removeLast();
				}
				break;
			}
			case 'B': {
				if(inventory.get(2).size() != 0)
				{
					result =  (Item) inventory.get(2).removeLast();
				}
				break;
			}
			case 'V': {
				if(inventory.get(3).size() != 0)
				{
					result =  (Item) inventory.get(3).removeLast();
				}
				break;
			}
			case 'Y': {
				result = (Item) inventory.get(4).getLast();
				inventory.get(4).removeLast();
				break;
			}
			case 'H': {
				result = (Item) inventory.get(5).getLast();
				inventory.get(5).removeLast();
				break;
			}
			case 'J': {
				result = (Item) inventory.get(6).getLast();
				inventory.get(6).removeLast();
				break;
			}
			case 'A': {
				result = (Item) inventory.get(7).getLast();
				inventory.get(7).removeLast();
				break;
			}
			case '*': {
				if(inventory.get(8).size() != 0)
				{
					result =  (Item) inventory.get(8).removeLast();
				}
				break;
			}
			case '#': {
				result = (Item) inventory.get(9).getLast();
				inventory.get(9).removeLast();
				break;
			}
			}
		} catch (Exception err) {
			result = null;
		}
		return result;
	}

}

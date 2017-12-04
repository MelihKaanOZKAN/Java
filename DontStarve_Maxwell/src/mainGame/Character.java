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
	Location location, oldLocation;
	Queue<String> correctPath = new LinkedList<String>();
	LinkedList<Location> necessaryItems = new LinkedList<Location>();
	int[] necessaryItems_Distance;
	private Item activeRaft = null;

	protected void printPath(Queue<Location> path) {
		try {
			path.toString();
			/*for ( int i = 0; i < tmp.length; i =+2 )
			{
				correctPath.add(this.getStringofPath(tmp[i], tmp[i+1]));
			}
			*/
			//System.out.println(correctPath.toString());
		} catch (Exception err) {
			err.printStackTrace();
		}
	}

	public Character(String name) {
		try {
			this.name = name;
			isTorchActive = true;
			torchLife = 15;
			inventory = new Inventory();
		} catch (Exception err) {
			err.printStackTrace();
		}
	}

	protected void addItemToInventory(Item item) {
		try {
			inventory.addItemToPartition(item);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	protected Item[] getItemFromInventory(char symbol, int piece) {
		Item[] result = new Item[piece];
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
				getTorch();
				if (this.isTorchActive) {
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

			Item[] straw1 = this.getItemFromInventory('S', 2);
			Item[] straw2 = this.getItemFromInventory('T', 2);

			if (straw1.length == 2 && straw2.length == 2) {
				result = new Item('*', "Meþale");
			} else {
				for (int i = 0; i < straw1.length; i++) {
					this.addItemToInventory(straw1[i]);
				}

				for (int i = 0; i < straw2.length; i++) {
					this.addItemToInventory(straw2[i]);
				}
			}
			correctPath.add("*");
		} catch (Exception e) {
			e.printStackTrace();
		}
		return result;
	}

	protected Item craftRaft() {
		Item result = null;
		try {

			Item[] straw1 = this.getItemFromInventory('B', 4);
			Item[] straw2 = this.getItemFromInventory('V', 3);
			if (straw1.length == 4 && straw2.length == 3) {
				result = new Item('#', "Sal");
				correctPath.add("#");
			} else {
				for (int i = 0; i < straw1.length; i++) {
					this.addItemToInventory(straw1[i]);
				}

				for (int i = 0; i < straw2.length; i++) {
					this.addItemToInventory(straw2[i]);
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return result;
	}

	protected void printInventory() {
		try {
			inventory.viewItems();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	private String getStringofPath(Location oldLocation, Location newLocation) {
		String result = "";
		try {
			// System.out.println(oldLocation.X + " " + oldLocation.Y);
			// System.out.println(newLocation.X + " " + newLocation.Y);

			if (oldLocation.X > newLocation.X) {
				result += "u";
			} else if (oldLocation.X < newLocation.X) {
				result += "d";
			} else if (oldLocation.Y < newLocation.Y) {
				result += "r";
			} else if (oldLocation.Y > newLocation.Y) {
				result += "l";
			}
			if (newLocation.myItem != null) {
				result += newLocation.myItem.symbol;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return result;
	}

	private void getTorch() {
		try {
			Item result = null;
			if (this.inventory.inventory.get(8).isEmpty()) {
				craftTorch();
			} else {
				result = this.getItemFromInventory('*', 1)[0];
			}

			if (result != null) {
				torchLife = 15;
				this.isTorchActive = true;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	protected void Move(Location dest) {
		try {
			if (CanMove()) {
				if (!isTorchActive) {

					oldLocation = location;
					return;
				}
				if (dest.isWater) {
					activeRaft = getItemFromInventory('#', 1)[0];
					if (activeRaft == null) {
						this.addItemToInventory(craftRaft());
						return;
					}
				} else {
					if (activeRaft != null) {
						addItemToInventory(activeRaft);
						activeRaft = null;
					}
				}
				oldLocation = location;
				location = dest;
				torchLife--;
				if (location.myItem != null) {
					inventory.addItemToPartition(location.myItem);
				}
			} else {
				if (!isTorchActive) {
					System.out.println("Maxwell DEAD! :(");
					System.exit(0);
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	protected boolean isCorrect(char[][] Map, Location endLocation)
	{
		boolean result = false;
		try {
				boolean generator = !inventory.inventory.get(6).isEmpty();
				boolean gas = !inventory.inventory.get(4).isEmpty();
				boolean antenna = !inventory.inventory.get(7).isEmpty();
				boolean key = !inventory.inventory.get(5).isEmpty();
				if(generator && gas && antenna && key && location.X == endLocation.X && location.Y == endLocation.Y)
				{
					System.out.println("TRUEe");
					result = true;
				}
		}catch (Exception e) {
			e.printStackTrace(); 
		}
		return result;
	}
	protected Queue<Location> findPath(Location currentLoc, char[][] Map, Queue<Location> path, Location endLocation) {
		Queue<Location> result = new LinkedList<Location>();
		try {
			Location east = currentLoc.east(Map), west = currentLoc.west(Map), north = currentLoc.north(Map),
					south = currentLoc.south(Map);
			if(this.isCorrect(Map, endLocation))
			{
				result = path;
			}
			if (east.myItem != null) {
				path.add(currentLoc);
				this.Move(east);
				this.findPath(currentLoc, Map, path, endLocation);
			}
			if (west.myItem != null) {
				path.add(currentLoc);
				this.Move(west);
				this.findPath(currentLoc, Map, path, endLocation);
			}
			if (north.myItem != null) {
				path.add(currentLoc);
				this.Move(north);
				this.findPath(currentLoc, Map, path, endLocation);
			}
			if (south.myItem != null) {
				path.add(currentLoc);
				this.Move(south);
				this.findPath(currentLoc, Map, path, endLocation);
			}
			System.out.println(currentLoc.X + " " + currentLoc.Y);
			//path.remove(currentLoc);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return result;
	}

}

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

	protected void printPath() {
		try {

			System.out.println(correctPath.toString());
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

	protected void Move(Queue<Location> path) {
		try {
			while (!path.isEmpty()) {
				Move(path.poll());
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	private void Move(Location dest) {
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
				this.correctPath.add(this.getStringofPath(dest, location));
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

	protected boolean isEnd(char[][] Map, Location currentLocation, Location endLocation) {
		boolean result = false;
		try {
			boolean generator = !inventory.inventory.get(6).isEmpty();
			boolean gas = !inventory.inventory.get(4).isEmpty();
			boolean antenna = !inventory.inventory.get(7).isEmpty();
			boolean key = !inventory.inventory.get(5).isEmpty();
			if (generator && gas && antenna && key && currentLocation.X == endLocation.X
					&& currentLocation.Y == endLocation.Y) {
				System.out.println("TRUE");
				result = true;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return result;
	}

	protected Queue<Location> findPath(Location currentLoc, char[][] Map, Location endLocation) {
		Queue<Location> result = new LinkedList<Location>();
		try {
			Location east, west, north, south, currentLocation;
			result.add(currentLoc);
			while (!result.isEmpty()) {
				int tmp = 4;
				currentLocation = result.poll();
				east = currentLocation.east(Map);
				west = currentLocation.west(Map);
				north = currentLocation.north(Map);
				south = currentLocation.south(Map);
				System.out.println("CL: " + currentLocation.toString() + " ");
				if (this.isEnd(Map, currentLocation, endLocation)) {
					break;
				}
				if (east != null) {

					if (east.myItem != null) {
						// System.out.println(east.myItem.name);
						//System.out.println("E " + east.toString());
						tmp--;
						result.add(east);
						if (Map[east.Y][east.X] == '.') {
							Map[east.Y][east.X] = '.';
						} else {
							Map[east.Y][east.X] = 'o';
						}
					}
				}
				if (west != null) {

					if (west.myItem != null) {
						tmp--;
						//System.out.println("W " + west.toString());
						result.add(west);
						if (Map[west.Y][west.X] == '.') {
							Map[west.Y][west.X] = '.';
						} else {
							Map[west.Y][west.X] = 'o';
						}
					}
				}
				if (north != null) {
					if (north.myItem != null) {
						tmp--;
						//System.out.println("N " + north.toString());
						result.add(north);
						//System.out.println("Nitem" +north.myItem.name);
						if (Map[north.Y][north.X] == '.') {
							Map[north.Y][north.X] = '.';
						} else {
							Map[north.Y][north.X] = 'o';
						}
					}
				}
				if (south != null) {

					if (south.myItem != null) {
						result.add(south);
						//System.out.println("S " + south.toString());
						tmp--;
						if (Map[south.Y][south.X] == '.') {
							Map[south.Y][south.X] = '.';
						} else {
							Map[south.Y][south.X] = 'o';
						}
					}
				}
				System.out.println(currentLocation.toString() + " tmp: " + tmp);

				if (tmp == 444) {
					Location goTo = new Location(endLocation.X / 2, endLocation.Y / 2, null);
					if (currentLocation.Y < goTo.Y) {
						result.add(south);
					} else if (currentLocation.Y > goTo.Y) {
						result.add(north);
					} else if (currentLocation.X < goTo.X) {
						result.add(east);
					} else if (currentLocation.X > goTo.X) {
						result.add(west);
					}
				}
			}

			if (!result.isEmpty()) {
				return result;
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		return result;
	}

}

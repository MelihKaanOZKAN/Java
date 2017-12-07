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
	Location location, oldLocation, endLocation;
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
					result = true;
				} else {
					result = false;
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

	protected void craftTorch() {
		try {

			Item[] straw1 = this.getItemFromInventory('S', 2);
			Item[] straw2 = this.getItemFromInventory('T', 2);

			if (straw1.length == 2 && straw2.length == 2) {
				this.addItemToInventory(new Item('*', "Meþale"));

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
	}

	protected void craftRaft() {
		try {

			Item[] straw1 = this.getItemFromInventory('B', 4);
			Item[] straw2 = this.getItemFromInventory('V', 3);
			if (straw1.length == 4 && straw2.length == 3) {
				this.addItemToInventory(new Item('#', "Sal"));
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
	}

	protected void printInventory() {
		try {
			inventory.viewItems();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	private String getStringofPath(Location oldLocation, Location newLocation, Location endLocation) {
		String result = "";
		try {

			if (oldLocation.X > newLocation.X) {
				if (newLocation.X == endLocation.X && newLocation.Y == endLocation.Y) {
					result += "W";
				} else {
					result += "l";
				}
			} else if (oldLocation.X < newLocation.X) {
				if (newLocation.X == endLocation.X && newLocation.Y == endLocation.Y) {
					result += "W";
				} else {
					result += "r";
				}
			} else if (oldLocation.Y < newLocation.Y) {
				if (newLocation.X == endLocation.X && newLocation.Y == endLocation.Y) {
					result += "W";
				} else {
					result += "d";
				}
			} else if (oldLocation.Y > newLocation.Y) {
				if (newLocation.X == endLocation.X && newLocation.Y == endLocation.Y) {
					result += "W";
				} else {
					result += "u";
				}
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
				result = this.getItemFromInventory('*', 1)[0];
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
			Location oldLoc, newloc;
			while (!path.isEmpty()) {
				newloc = path.poll();
				Move(newloc);
				oldLoc = newloc;
				if(!oldLoc.equal(this.location))
				{
					Move(newloc);
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	private void Move(Location dest) {
		try {
			if (CanMove()) {
				if (dest.isWater) {
					// System.out.println(activeRaft);
					if (activeRaft == null) {
						craftRaft();
						activeRaft = getItemFromInventory('#', 1)[0];
						torchLife--;
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
				this.correctPath.add(this.getStringofPath(oldLocation, location, endLocation));
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
		Queue<Location> temp = new LinkedList<Location>();
		try {
			this.endLocation = endLocation;
			Location east, west, north, south, currentLocation;
			temp.add(currentLoc);
			while (!temp.isEmpty()) {
				int tmp = 4;
				currentLocation = temp.poll();
				east = currentLocation.east(Map);
				west = currentLocation.west(Map);
				north = currentLocation.north(Map);
				south = currentLocation.south(Map);
				boolean canAdd = true;
				if (this.isEnd(Map, currentLocation, endLocation)) {
					break;
				}
				if (east != null) {

					if (east.myItem != null && canAdd) {
						tmp--;
						result.add(east);
						temp.add(east);
						canAdd = false;
						if (Map[east.Y][east.X] == '.') {
							Map[east.Y][east.X] = '.';
						} else {
							Map[east.Y][east.X] = 'o';
						}
					}
				}
				if (west != null) {

					if (west.myItem != null && canAdd) {
						tmp--;
						result.add(west);
						temp.add(west);
						canAdd = false;
						if (Map[west.Y][west.X] == '.') {
							Map[west.Y][west.X] = '.';
						} else {
							Map[west.Y][west.X] = 'o';
						}
					}
				}
				if (north != null) {
					if (north.myItem != null && canAdd) {
						tmp--;
						result.add(north);
						temp.add(north);
						canAdd = false;
						if (Map[north.Y][north.X] == '.') {
							Map[north.Y][north.X] = '.';
						} else {
							Map[north.Y][north.X] = 'o';
						}
					}
				}
				if (south != null) {

					if (south.myItem != null && canAdd) {
						result.add(south);
						temp.add(south);
						canAdd = false;
						tmp--;
						if (Map[south.Y][south.X] == '.') {
							Map[south.Y][south.X] = '.';
						} else {
							Map[south.Y][south.X] = 'o';
						}
					}
				}
				if (tmp == 4) {
					Location goTo = new Location(endLocation.X, endLocation.Y, null);
					if (currentLocation.Y < goTo.Y) {
						result.add(south);
						temp.add(south);
					} else if (currentLocation.Y > goTo.Y) {
						result.add(north);
						temp.add(north);
					} else if (currentLocation.X < goTo.X) {
						result.add(east);
						temp.add(east);
					} else if (currentLocation.X > goTo.X) {
						result.add(west);
						temp.add(west);
					}
				}
			}

			if (!temp.isEmpty()) {
				return result;
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		return result;
	}

}

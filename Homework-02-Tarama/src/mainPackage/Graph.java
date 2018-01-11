package mainPackage;

import java.util.Arrays;
import java.util.LinkedList;

public class Graph {
	LinkedList<String> neighbors;
	int[][] relationships;
	LinkedList<String> weights;

	// Constructor
	public Graph(LinkedList<String> neighbors) {
		try {
			this.neighbors = neighbors;
			this.weights = new LinkedList<String>();
			this.weights.addLast("0");
			this.relationships = new int[this.neighbors.size()][this.neighbors.size()];
			// set all relationships to 0
			for (int i = 0; i < this.relationships.length; i++) {
				this.relationships[i][i] = 0;
			}
			for (int i = 1; i < this.neighbors.size(); i++) {
				this.relationships[i][0] = i;
				this.relationships[0][i] = i;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void addRelation(int from, int to, int index) {
		try {
			// System.out.println("From: " + from + " To: " + to + " Index: " + index);
			// set relationships
			this.relationships[from][to] = index;
			this.relationships[to][from] = index;
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void printNeighbors() {
		System.out.println("Oyuncularýn listesi");
		for (int i = 1; i < this.neighbors.size(); i++) {
			System.out.println(i + ". sýradaki oyuncu " + this.neighbors.get(i));
		}
		System.out.println("");
	}

	public void printWeights() {
		System.out.println("Filmlerin listesi");
		for (int i = 1; i < this.weights.size(); i++) {
			System.out.println(i + ". sýradaki film " + this.weights.get(i));
		}
		System.out.println("");
	}

	public void print() {
		try {
			this.printNeighbors();
			this.printWeights();
			System.out.println("");
			System.out.println("Oluþturulan Matris: ");
			int max = 0;
			int max_ = 0;
			for (int i = 1; i < this.weights.size(); i++) {
				if (this.weights.get(i).length() > max_) {
					max_ = this.weights.get(i).length();
				}
			}
			max_++;
			for (int i = 0; i < this.relationships.length; i++) {
				for (int j = 0; j < this.relationships.length; j++) {
					if (i == 0 && j == 0) {
						System.out.print("  ");
					} else if (i >= 1 && j >= 1) {
						String text = this.weights.get(this.relationships[i][j]);

						int diffefence = max_ - text.length();
						for (int k = 0; k < diffefence / 2 + 3; k++) {
							text += " ";
						}
						for (int k = 0; k < diffefence / 2; k++) {
							text = " " + text;
						}
						System.out.print(text);
					} else {
						String text = this.neighbors.get(this.relationships[i][j]);
						if (max < text.length()) {
							max = text.length();
						} else {
							int diffefence = max - text.length();
							for (int k = 0; k < diffefence; k++) {
								text += " ";
							}
						}
						if (i == 0 && j == 1) {
							for (int k = 0; k < max; k++) {
								System.out.print(" ");
							}

						}
						if (i == 0) {
							int diffefence = max_ - text.length();

							for (int k = 0; k < diffefence / 2 + 3; k++) {
								text += " ";
							}
							for (int k = 1; k < diffefence / 2; k++) {
								text = " " + text;
							}
						}
						System.out.print(text);
					}
				}
				System.out.println("");
			}

			System.out.println("");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public PathClass findPath(int from, int to, LinkedList<Integer> connections, int start) {
		PathClass result = new PathClass();
		for (int i = 1; i < this.relationships[from].length; i++) {
			if (this.relationships[from][i] != 0 && i != start && i != from) {
				connections.add(i);
			}
		}
		LinkedList<Integer> connections_ = new LinkedList<Integer>();
		for (int i = 1; i < this.relationships[to].length; i++) {
			if (this.relationships[to][i] != 0) {
				connections_.add(i);
			}
		}
		if (connections_.size() == 1) {
			if (connections_.getLast() == to) {
				return null;
			}
		}

		result.path.addLast(from);
		if (connections.size() > 0) {
			if (connections.contains(to)) {
				result.path.addLast(to);
			} else {
				int from_ = connections.getLast();
				result = result.mergePath(findPath(from_, to, connections, start).path);

			}
		} else {
			return null;
		}
		return result;
	}

	public int findNeigbor(String name) {
		int result = 0;
		for (int i = 0; i < this.neighbors.size(); i++) {
			if (this.neighbors.get(i).equalsIgnoreCase(name)) {
				result = i;
			}
		}
		return result;
	}

}

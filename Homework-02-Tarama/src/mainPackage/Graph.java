package mainPackage;

import java.util.Arrays;
import java.util.LinkedList;

public class Graph {
	LinkedList<String> neighbors;
	int[][] relationships;
	LinkedList<String> weights;

	public Graph(LinkedList<String> neighbors) {
		try {
			this.neighbors = neighbors;
			this.weights = new LinkedList<String>();
			this.weights.addLast("0");
			this.relationships = new int[this.neighbors.size()][this.neighbors.size()];
			for (int i = 0; i < this.relationships.length; i++) {
				this.relationships[i][i] = 0;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void addRelation(int from, int to, int index) {
		try {
			// System.out.println("From: " + from + " To: " + to + " Index: " + index);
			this.relationships[from][to] = index;
			this.relationships[to][from] = index;
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void print() {
		try {
			String[][] data = new String[this.neighbors.size()][this.neighbors.size()];
			System.out.print('\t');
			String leftAlignFormat = "%20s";
			String leftAlignFormat_ = "%3s";
			for(int i = 1; i < this.neighbors.size(); i++)
			{
				data[0][i] = this.neighbors.get(i);
			}
			for(int i = 1; i < this.neighbors.size(); i++)
			{
				data[i][0] = this.neighbors.get(i);
				for(int j = 1; j < this.neighbors.size() ; j++)
				{
					data[i][j] = this.weights.get(this.relationships[i][j]);
				}
			}
			for(int i = 0; i < data.length; i++)
			{
				System.out.println(Arrays.toString(data[i]));
			}
		}catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void findPath(int from, int to) {
		
	}
}

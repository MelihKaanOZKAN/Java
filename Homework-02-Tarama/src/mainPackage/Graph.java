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

	public void print() {
		try {
			String[][] data = new String[this.neighbors.size()][this.neighbors.size()];
			System.out.print('\t');
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

	public PathClass findPath(int from, int to, LinkedList<Integer> connections) {
		PathClass result = new PathClass();
		for(int i = 0; i < this.relationships[from].length; i++)
		{
			if(this.relationships[from][i] != 0)
			{
				connections.add(i);
			}
		}
		
		 LinkedList<Integer> connections_ = new  LinkedList<Integer>();
		for(int i = 0; i < this.relationships[to].length; i++)
		{
			if(this.relationships[to][i] != 0)
			{
				connections_.add(i);
			}
		}
		if(connections_.size() == 1)
		{
			if(connections_.getLast() == to)
			{
				return null;
			}
		}
		
		result.path.addLast(from);
		result.cost++;
		if(connections.size() > 0)
		{
				if(connections.contains(to))
				{
					result.path.addLast(to);
				}
				else {
					int from_ = connections.pop();
					result = result.mergePath(findPath(from_, to, connections).path);
				}
		}
		else {
			return null;
		}
		return result;
	}

	public int findNeigbor(String name)
	{
		int result = 0;
		for(int i = 0; i < this.neighbors.size(); i++)
		{
			if(this.neighbors.get(i).equalsIgnoreCase(name))
			{
				result =  i;
			}
		}
		return result;
	}


}

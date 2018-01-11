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
			this.relationships = new int[this.neighbors.size()-1][this.neighbors.size()-1];
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
			//System.out.println("From: " + from + " To: " + to + " Index: " + index);
			// set relationships
			this.relationships[from-1][to-1] = index;
			this.relationships[to-1][from-1] = index;
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void printNeighbors()
	{
		System.out.println("Oyuncular�n listesi");
		for(int i = 1; i < this.neighbors.size(); i++)
		{
			System.out.println(i +". s�radaki oyuncu " + this.neighbors.get(i) +", matris indis numaras� " + (i-1));
		}
	}
	public void print() {
		try {
			this.printNeighbors();
			System.out.println("");
			System.out.println("Olu�turulan Matris: ");
			for(int i = 0; i < this.relationships.length; i++)
			{
				for(int j = 0; j < this.relationships.length; j++)
				{
					System.out.print(this.relationships[i][j] + " ");
				}
				System.out.println("");
			}

			System.out.println("");
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

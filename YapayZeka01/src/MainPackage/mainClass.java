package MainPackage;

import java.util.LinkedList;

public class mainClass {

	public static void main(String[] args) {
		char edges[] = {'A','B','C','D','Ê'};
		int matrix[][] = {  {0,10,0,25,0},
							{10,0,0,0,25},
							{0,0,0,12,19},
							{30,0,12,0,0},
							{0,25,0,0,19}
							};
		
		Node start = new Node(5,0);
		start = start.findNeighbors(matrix, 4, new LinkedList<Integer>());
		
		if(start!= null)
		{
			start.print(edges,1);
		}
	}

}

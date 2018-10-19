package MainPackage;

import java.util.LinkedList;

public class mainClass {

	public static void main(String[] args) {
		char edges[] = {'A','B','C','D','E'};
		int matrix[][] = {  {0,1,0,1,0},
							{1,0,0,0,1},
							{0,0,0,1,1},
							{1,0,1,0,0},
							{0,1,0,0,1}
							};
		
		Node start = new Node(5,0);
		start = start.findNeighbors(matrix, 4, new LinkedList<Integer>());
		
		if(start!= null)
		{
			LinkedList<String> lines = new LinkedList<String>();
			  
			start.print(edges,0, lines);
			
			for(int i = 0; i < lines.size(); i++)
			{
				System.out.println(lines.get(i));
			}
		}
	}

}

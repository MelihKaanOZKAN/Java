package MainPackage;

import java.util.LinkedList;

public class mainClass {

	public static void main(String[] args) {
		char edges[] = {'A','B','C','D','E'}; //set nodeNames
		int matrix[][] = {  {0,1,0,1,0},
							{1,0,0,0,1},
							{0,0,0,1,1},
							{1,0,1,0,0},
							{0,1,0,0,1}
							};//set matrix 
		
		Node start = new Node(5,0); // create root
		start = start.CreateTree(matrix, 4, new LinkedList<Integer>()); //send goal and other thing to create a tree
		
		if(start!= null)//if creating successful
		{
			LinkedList<String> lines = new LinkedList<String>();//create a line list
			  
			start.print(edges, lines);//print itself to list
			
			for(int i = 0; i < lines.size(); i++)//print list to screen
			{
				System.out.println(lines.get(i));
			}
		}
	}

}

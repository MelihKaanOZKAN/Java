package MainPackage;

import java.util.LinkedList;

public class mainClass {

	public static void main(String[] args) {
		char edges[] = {'A','B','C','D','E'}; //set nodeNames
		int matrix[][] = {  {0,1,0,1,0},
							{0,0,0,0,0},
							{0,0,0,0,1},
							{0,0,1,0,0},
							{0,0,0,0,0}
							};//set matrix 
		
		Node start = new Node(0); // create root
		start = start.CreateTree(matrix,  new Node(4)); //send goal and other thing to create a tree
		
		if(start!= null)//if creating successful
		{
			
			start.print(edges);//print itself to list
		
		}
	}

}

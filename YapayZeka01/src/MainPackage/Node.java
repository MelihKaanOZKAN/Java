package MainPackage;

import java.util.LinkedList;

public class Node {

	 int nodeId;
	 Node nodes[];
	 int nodeLevel;
	 public Node() {
		 
	 }
	public Node(int NodeCount, int nodeId)
	{
		nodes = new Node[NodeCount];
		this.nodeId = nodeId;
	}
	
	public Node findNeighbors(int[][] matrix, int goalId, LinkedList<Integer> prevs)
	{
		Node result = this;
		
		int ConnectionCount = 0;
		if (this.nodeId == goalId)
		{
			result= this;
		}
		else {
			if(prevs.contains(nodeId))
			{
				result= null;
			}
			else {
				for(int i = 0; i < nodes.length; i++)
				{
					if( i == nodeId)
					{
						prevs.add(i);
						continue;
					}
					else if(matrix[nodeId][i] != 0){
						Node tmp = new Node(nodes.length, i);
						prevs.add(i);
						tmp = tmp.findNeighbors(matrix, goalId, prevs);
						if(tmp == null)
						{
							continue;
						}
						else{
							tmp.nodeLevel = this.nodeLevel +1;
							nodes[ConnectionCount] = tmp;
							ConnectionCount++;
						}
					}
				}
			}
			
		}
		return result;
	}

	public void print(char edges[], int level) {
		
		if(level < this.nodeLevel)
		{
			return;
		}
		else if (level == this.nodeLevel)
		{
			System.out.print(edges[this.nodeId]);
			
			return;
		}
		else {
			for(int i = 0; i < this.nodes.length; i++)
			{
				if(nodes[i] != null)
				{
					nodes[i].print(edges, this.nodeLevel+1);
				}
			}
		}
	}
}

package MainPackage;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class Node {
	int nodeId;
	ArrayList<Node> nodes;
	public Node() {

	}

	public Node( int nodeId) { //initialize node
		nodes = new ArrayList<>(); //Create Node List
		this.nodeId = nodeId; //set nodeId
	}
	public ArrayList<Node>  getConnections(int[][] matrix){
		if(this.nodes.size()<=0) {
			for(int k = 0; k < matrix.length; k++)
			{
				if (matrix[nodeId][k] != 0) {
					Node tmp = new Node(k);
					this.nodes.add(tmp);
				}
					
			}
		}
		return this.nodes;
	}
	public Node CreateTree(int[][] matrix, Node goal) {
		Node result = new Node(this.nodeId); //set result to this object
		Queue<Node> queue = new LinkedList<>();
		LinkedList<Node> prevs = new LinkedList<Node>();
		ArrayList<Node> connections = this.getConnections(matrix);
		queue.add(this);
		prevs.add(this);
		Node topNode = null;
		while(!queue.isEmpty()){
			
	        Node current = queue.remove();
	        current.getConnections(matrix);
	        topNode = result;
	        result = result.getData(result.nodes, current);
	        
            if(current.nodeId ==goal.nodeId) {
              
               break;
            }
            else{
                if(current.getConnections(matrix).isEmpty()) {
                	
                 continue;
                }
                else {
                	if(!prevs.contains(current))
                	{
                		//current.nodes.clear();
            	        result.nodes.add(current);
                	}
                    queue.addAll(current.getConnections(matrix));
                }
            }
            prevs.add(current);
        }
		result = this;
		return result; //return result
	}
	private Node RemoveData(ArrayList<Node> list, Node data) {
		Node result = this;;
		for (int i = 0; i < list.size(); i++) {//search list to find incoming data
			if (list.get(i).nodeId == data.nodeId) { //if its found, remove
				result = list.get(i);
			}
		}
		return result;
	}
	
	private Node getData(ArrayList<Node> list, Node data) {
		Node result = this;;
		for (int i = 0; i < list.size(); i++) {//search list to find incoming data
			if (list.get(i).nodeId == data.nodeId) { //if its found, remove
				result = list.get(i);
			}
		}
		return result;
	}

	

	public void print(char edges[]) {
		System.out.println(edges[this.nodeId]);
		Node tmp = this;
		Node topLine = this;
		int NodeSize = 0;
		while(tmp.nodes.size()>0)
		{
			
			for(int i = 0; i < tmp.nodes.size(); i++)
			{
				System.out.print(edges[tmp.nodes.get(i).nodeId]);
				System.out.print(" ");
			}
			System.out.println("|");
		
			tmp = topLine.nodes.get(NodeSize++);

			if(tmp.nodes.size()<=0)
			{
				tmp = topLine.nodes.get(NodeSize);
				NodeSize++;
				System.out.print("   ");
			}
			if(NodeSize == topLine.nodes.size())
			{
				NodeSize = 0;
				topLine = topLine.nodes.get(NodeSize);
			    
			}
			
		}

	}
}

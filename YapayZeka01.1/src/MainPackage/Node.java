package MainPackage;

import java.util.LinkedList;

public class Node {
	int nodeId;
	Node nodes[];
	int nodeLevel;
	public Node() {

	}

	public Node(int NodeCount, int nodeId) { //initialize node
		nodes = new Node[NodeCount]; //set connection list
		this.nodeId = nodeId; //set nodeId
	}

	public Node CreateTree(int[][] matrix, int goalId, LinkedList<Integer> prevs) {
		Node result = this; //set result to this object
		prevs.add(this.nodeId); // add tick to visited
		int ConnectionCount = 0; // Node connection count except visited
		if (this.nodeId == goalId) { //if this node is goalNode, return this node;
			result = this;
		} else {
			for (int i = 0; i < nodes.length; i++) { //search matrix to find a connection 
				if (matrix[nodeId][i] != 0) {
					if (prevs.contains(i)) { // if i is visited, pass
						continue;
					}
					Node tmp = new Node(nodes.length, i); // else create a node of connection
					tmp.nodeLevel = this.nodeLevel + 1;//set node level
					tmp = tmp.CreateTree(matrix, goalId, prevs);//find a connection of new node with recursive call
					if (tmp == null) {//if return is null, pass
						continue;
					} else {
						nodes[ConnectionCount] = tmp; //else set tmp to node list
						ConnectionCount++;//increase connection count
						this.removeData(prevs, i);//remove connection from visited list
					}

				}
			}

		}
		return result; //return result
	}

	private LinkedList<Integer> removeData(LinkedList<Integer> list, int data) {
		for (int i = 0; i < list.size(); i++) {//search list to find incoming data
			if (list.get(i) == data) { //if its found, remove
				list.remove(i);
			}
		}
		return list;
	}

	public void print(char edges[],  LinkedList<String> lines) {

		if (lines.size() <= this.nodeLevel) { // if level doesn't exist in line list, create
			lines.addLast("");
		}
		String tmp = lines.get(this.nodeLevel); //get line of level
		boolean oneNode = true; 
		for (int j = 0; j < this.nodes.length; j++) {//search node connections
			if (nodes[j] != null) { // if exist, print space and set oneNode to false because its not.
				tmp += "  ";
				oneNode = false;
			}
		}
		if(oneNode)//if its oneNode
		{
			String topLine = lines.get(this.nodeLevel-1);//get top line
			for(int i = 0; i < topLine.length()-2;i++) { //print space 'till topLine length-2

				tmp += " ";
			}
		}
		lines.set(this.nodeLevel, tmp += edges[this.nodeId]);//add node name to end of line and replace from list

		for (int i = 0; i < this.nodes.length; i++) {//search node connections
			if (nodes[i] != null) {//if its found, call 'print' for print itself and his connections
				nodes[i].print(edges, lines);
			}
		}

	}
}

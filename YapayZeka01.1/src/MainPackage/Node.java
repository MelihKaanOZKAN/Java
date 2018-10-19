package MainPackage;

import java.util.LinkedList;

public class Node {
	int nodeId;
	Node nodes[];
	int nodeLevel;

	public Node() {

	}

	public Node(int NodeCount, int nodeId) {
		nodes = new Node[NodeCount];
		this.nodeId = nodeId;
	}

	public Node findNeighbors(int[][] matrix, int goalId, LinkedList<Integer> prevs) {
		Node result = this;
		prevs.add(this.nodeId);
		int ConnectionCount = 0;
		if (this.nodeId == goalId) {
			result = this;
		} else {
			for (int i = 0; i < nodes.length; i++) {
				if (matrix[nodeId][i] != 0) {
					if (prevs.contains(i)) {

						continue;
					}
					Node tmp = new Node(nodes.length, i);
					tmp = tmp.findNeighbors(matrix, goalId, prevs);
					if (tmp == null) {
						continue;
					} else {
						tmp.nodeLevel = this.nodeLevel + 1;
						nodes[ConnectionCount] = tmp;
						ConnectionCount++;
						this.removeData(prevs, i);
					}

				}
			}

		}
		return result;
	}

	private LinkedList<Integer> removeData(LinkedList<Integer> list, int data) {
		for (int i = 0; i < list.size(); i++) {
			if (list.get(i) == data) {
				list.remove(i);
			}
		}
		return list;
	}

	public void print(char edges[], int level, LinkedList<String> lines) {

		if (lines.size() < level + 1) {
			lines.addLast("");
		}
		String tmp = lines.get(level);
		for (int j = 0; j < this.nodes.length; j++) {
			if (nodes[j] != null) {
				tmp += " ";
			}
		}
		lines.set(level, tmp += edges[this.nodeId] + " ");

		for (int i = 0; i < this.nodes.length; i++) {
			if (nodes[i] != null) {
				nodes[i].print(edges, this.nodeLevel + 1, lines);
			}
		}

	}
}

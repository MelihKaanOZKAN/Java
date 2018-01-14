package mainPackage;

import java.util.LinkedList;

public class PathClass {
	protected LinkedList<Integer> path = new LinkedList<Integer>();
	protected int cost = 0;
	public PathClass mergePath (LinkedList<Integer> path_)
	{
		LinkedList<Integer> tmpPath = new LinkedList<Integer>();
		for(int i = 0; i < path.size(); i++)
		{
			tmpPath.addLast(path.get(i));
			cost++;
		}
		for(int i = 0; i < path_.size(); i++)
		{
			tmpPath.addLast(path_.get(i));
			cost++;
		}
		this.path = tmpPath;
		return this;
	}
}

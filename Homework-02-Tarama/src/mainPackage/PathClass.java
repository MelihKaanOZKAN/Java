package mainPackage;

import java.util.LinkedList;

public class PathClass {
	protected LinkedList<Integer> path = new LinkedList<Integer>();
	public PathClass mergePath (LinkedList<Integer> path_)
	{
		LinkedList<Integer> tmpPath = new LinkedList<Integer>();
		for(int i = 0; i < path.size(); i++)
		{
			tmpPath.addLast(path.get(i));
		}
		for(int i = 0; i < path_.size(); i++)
		{
			tmpPath.addLast(path_.get(i));
		}
		this.path = tmpPath;
		return this;
	}
}

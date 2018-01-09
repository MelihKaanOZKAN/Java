package mainPackage;

public class Graph {
	String[] neighbors;
	int[][] relationships;
	String[] weights;
	public Graph (String[] neighbors, String[] weights)
	{
		try {
			this.neighbors = neighbors;
			this.weights = weights;
			
			this.relationships = new int[this.neighbors.length][this.neighbors.length];
			for(int i = 0; i < this.relationships.length; i++)
			{
				this.relationships[i][i] = 0;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	public  void addRelation(int from, int to, int index)
	{
		try {
			this.relationships[from][to] = index;
			this.relationships[to][from] = index;
		}
		catch (Exception e) {
			e.printStackTrace();
		}
	}
	public void print() {
		try {
			System.out.print('\t');
			for(int i = 0; i < this.neighbors.length; i++)
			{
				System.out.print(this.neighbors[i] + "\t");
			}
			System.out.println("");
			for(int i = 0; i < this.neighbors.length; i++)
			{
				System.out.print(this.neighbors[i] + "\t");
				for(int j = 0; j < this.neighbors.length ; j++)
				{
					System.out.print(this.weights[this.relationships[i][j]]  + "\t" );
				}
				System.out.println("");
			}
			
		}catch (Exception e) {
			e.printStackTrace();
		}
	}
	
}

package mainPackage;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.LinkedList;

public class mainClass {

	
	
	private static Graph getGraphFromFile(File file)
	{
		Graph result = null;
		try {
			BufferedReader br = new BufferedReader(new FileReader(file));
			String line = br.readLine();
			String[] tmp = line.split("-");
			tmp[0] = "";
			String[] neighbors = tmp.clone();
		
			for (String line1; (line1 = br.readLine()) != null;) {
				line += line1;
				line += "&";
			}
			tmp = line.split("&");
			
			String[] weights = new String[tmp.length];

			LinkedList<LinkedList> tmp3 = new LinkedList<LinkedList>();
			for(int i = 1; i < tmp.length; i++)
			{

				LinkedList<Integer> tmpIndex = new LinkedList<Integer>();
				String[] tmp2 = tmp[i].split("-");
				weights[i] = tmp2[0];
				for(int j = 1; j < tmp2.length; j++)
				{
					if(tmp2[j] == "1")
					{
						tmpIndex.add(j);
					}
				}

				tmp3.add(tmpIndex);
				
				
			}
			result = new Graph(neighbors, weights);
			
			for(int i = 0; i < tmp3.size(); i++)
			{
				LinkedList<Integer> tmp4 = tmp3.get(i);
				for(int k = 0; k < tmp4.size(); k+=2)
				{
					result.addRelation(k, k+1, i);
				}
			}
			
		}catch (Exception e) {
			e.printStackTrace();
		}
		return result;
	}
	
	
	public static void main(String[] args) {
		
		File file = new File("C:\\graphdata.txt");
		Graph test = getGraphFromFile(file);
		test.print();
	}

}

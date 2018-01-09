package mainPackage;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.LinkedList;

import com.sun.glass.ui.Clipboard;

public class mainClass {

	private void addRelationsAndWeights(String data, Graph graph, int index) {
		String[] fragmentedData = data.split("-");
		graph.weights.addLast(fragmentedData[0]);

		LinkedList<Integer> Ids = new LinkedList<Integer>();
		for (int i = 1; i < fragmentedData.length; i++) {

			if (fragmentedData[i].equalsIgnoreCase("1")) {
				Ids.addLast(i);
			}
		}

		// System.out.println(index);
		if (Ids.size() % 2 == 0) {
			for (int i = 0; i < Ids.size(); i += 2) {
				 //System.out.println(Ids.get(i) + " " + Ids.get(i+1) + " " + index);
				graph.addRelation(Ids.get(i), Ids.get(i + 1), index);
			}
		} else if (Ids.size() % 2 == 1) {
			while (Ids.size() != 0) {
				for (int i = 1; i < Ids.size() && Ids.size() != 1; i++) {
					// System.out.println(Ids.get(0) + " " + Ids.get(i) + " " + index);
					graph.addRelation(Ids.get(0), Ids.get(i), index);
				}
				Ids.removeFirst();
			}
		}

	}

	private static Graph getGraphFromFile(File file) {
		Graph result = null;
		try {
			BufferedReader br = new BufferedReader(new FileReader(file));
			String line = br.readLine();
			String[] tmp = line.split("-");
			tmp[0] = "";
			LinkedList<String> neighbors = new LinkedList<String>();
			neighbors.addLast("");
			for (int i = 1; i < tmp.length; i++) {
				neighbors.addLast(tmp[i]);
			}

			result = new Graph(neighbors);
			int index = 1;
			mainClass main = new mainClass();
			for (String line1; (line1 = br.readLine()) != null;) {
				main.addRelationsAndWeights(line1, result, index);
				index++;
			}

		} catch (Exception e) {
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

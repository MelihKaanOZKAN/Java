package HomeWork_0301;

public class MainClass {

	public static void main(String[] args) {
		Node root = new Node(10);
		root.addBST(8);
		root.addBST(12);
		root.addBST(7); 
		root.inorderTravelsel();
		root.addBST(9);
		root.addBST(11); 
		 root.addBST(15); 
		 System.out.println("******"); 
		root.inorderTravelsel(); 
		Node a=root.searchParent(15,root);
		System.out.println("Out:"+a.getId()); 
		System.out.println("R:"+root.getId()); 
		System.out.println("B:"+root.searchMax().getId()); 
		System.out.println("K:"+root.searchMin().getId());
		System.out.println("D:"+root.searchMax(root.Search(10)).getId()); 
		System.out.println("C:"+root.searchMin(root.Search(10)).getId());
		System.out.println("******"); 
		root.addBST(18); 
		root.remove(8);
		root.inorderTravelsel();
		root.remove(root.searchMax().getId());
		root.inorderTravelsel();

	}

}

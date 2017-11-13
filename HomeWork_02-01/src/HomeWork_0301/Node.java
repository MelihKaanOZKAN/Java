package HomeWork_0301;

public class Node {
	private int id;
	private Node left;
	private Node right;

	public Node(int id) {
		try {
			this.id = id;
			this.left = null;
			this.right = null;
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void addBST(int item) {
		try {
			if (item < this.id) {
				if (this.left == null) {
					this.left = new Node(item);
					return;
				} else {
					this.left.addBST(item);
					return;
				}
			}
			if (item > this.id) {
				if (this.right == null) {
					this.right = new Node(item);
					return;
				} else {
					this.right.addBST(item);
					return;
				}
			}
			System.out.println(item + " Exist in the BST");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public int getId() {
		return this.id;
	}

	public void inorderTravelsel() {
		try {
			if (this.left != null) {
				this.left.inorderTravelsel();
			}
			System.out.println(this.id);
			if (this.right != null) {
				this.right.inorderTravelsel();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public Node Search(int item) {
		Node result = null;
		try {

			if (this.id == item) {
				result = this;
			} else if (this.id < item) {
				result = this.right.Search(item);
			} else if (this.id > item) {
				result = this.left.Search(item);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return result;
	}

	public Node searchParent(int item, Node parent) {
		Node result = null;
		try {
			if (this.left.id == item || this.right.id == item) {
				result = this;
			} else if (item < this.id) {
				result = this.left.searchParent(item, parent);
			} else if (item > this.id) {
				result = this.right.searchParent(item, parent);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return result;
	}

	public Node searchMax() {
		Node result = null;
		try {
			if (this.right != null) {
				result = this.right.searchMax();
			} else {
				result = this;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return result;
	}

	public Node searchMin() {
		Node result = null;
		try {
			if (this.left != null) {
				result = this.left.searchMin();
			} else {
				result = this;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return result;
	}

	public Node searchMax(Node nd) {
		Node result = null;
		try {
			if (this == nd) {
				result = this.searchMax();
			} else if (this.id < nd.id) {
				result = this.right.searchMax(nd);
			} else if (this.id > nd.id) {
				result = this.left.searchMax(nd);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return result;
	}

	public Node searchMin(Node nd) {
		Node result = null;
		try {
			if (this.equals(nd)) {
				result = this.searchMin();
			} else if (this.id < nd.id) {
				result = this.right.searchMin(nd);
			} else if (this.id > nd.id) {
				result = this.left.searchMin(nd);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return result;
	}

	public void remove(int item) {
		try {
			Node tmp = searchParent(item, this);
			if (tmp != null) {
				if (tmp.left.id == item) {
					if (tmp.left.left == null && tmp.left.right == null) {
						tmp.left = null;
						return;
					}
					if (tmp.left.left != null && tmp.left.right == null) {
						tmp.left.id = tmp.left.left.id;
						tmp.left.left = null;
						return;
					}
					if (tmp.left.left == null && tmp.left.right != null) {
						tmp.left.id = tmp.left.right.id;
						tmp.left.right = null;
						return;
					}
					if (tmp.left.left != null && tmp.left.right != null) {

					
						Node temp = tmp.left.searchParent(tmp.left.searchMax().id, this);
						Node temp2 = tmp.left.searchMax();
						tmp.left.id = tmp.left.searchMax().id;
						if(temp.left == temp2)
						{
							temp.left = null;
						}
						else if(temp.right == temp2)
						{
							temp.right = null;
						}
						return;
					}
				}

				if (tmp.right.id == item) {
					if (tmp.right.left == null && tmp.right.right == null) {
						tmp.right = null;
						return;
					}
					if (tmp.right.left != null && tmp.right.right == null) {
						tmp.right.id = tmp.right.left.id;
						tmp.right.left = null;
						return;
					}
					if (tmp.right.left == null && tmp.right.right != null) {
						tmp.right.id = tmp.right.right.id;
						tmp.right.right = null;
						return;
					}
					if (tmp.right.left != null && tmp.right.right != null) {

						Node temp = tmp.right.searchParent(tmp.right.searchMax().id, this);
						Node temp2 = tmp.right.searchMax();
						tmp.right.id = tmp.right.searchMax().id;
						if(temp.left == temp2)
						{
							temp.left = null;
						}
						else if(temp.right == temp2)
						{
							temp.right = null;
						}
						return;
					}
				}

			} else {
				System.out.println(item + " Couldn't Found!");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

	}
}



public class BinarySearchTree{

	private Node root;

	public void insert(int d){
		Node prev = null;
		Node check = root;
		while (check != null){
			if (check.getData() == d){
				return;
			} else if (d < check.getData()){
				prev = check;
				check = check.getLeft();
			} else {
				prev = check;
				check = check.getRight();
			}
		} 

		if (prev == null){
				root = new Node(d);
		} else if (d < check.getData()){
			prev.setLeft(new Node(d));
		} else {
			prev.setRight(new Node(d));
		}

	}

	public Node search(int d){
		Node check = root;
		while (check != null && check.getData() != d){
			if (d < check.getData()){
				check = check.getLeft();	
			} else {
				check = check.getRight();
			}
		} 
		return check;

	}

	public Node search2(int x){
		return search2h(root,x);
	}

	public Node search2h(Node c, int x){
		if (c == null || c.getData() == x){
			return c;
		} else if (x < c.getData()){
			return search2h(c.getLeft(),x);
		} else {
			return search2h(c.getRight(),x);
		}
	}

	public String toString(){
		return null;
	}

}
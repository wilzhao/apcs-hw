

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
		} else if (d < prev.getData()){
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

	public void delete(int d){
		//taken from the insert
		Node prev = null;
		Node check = root;
		boolean right = false;// if true, then prev.getRight() gives check
		while (check != null){
			if (check.getData() == d){
				return;
			} else if (d < check.getData()){
				prev = check;
				check = check.getLeft();
				right = false;
			} else {
				prev = check;
				check = check.getRight();
				right = true;
			}
		} 
		//now, prev is pointing to the node before the node we want to delete
		if (check == null){
			return;
		} else if (check.getLeft() == null){
			if (right){
				check.setRight(check.getRight());
			} else {
				check.setLeft(check.getRight());
			}
		} else if (check.getRight() == null){
			if (right){
				check.setRight(check.getLeft());
			} else {
				check.setLeft(check.getLeft());
			}
		} else { //two children
			Node largest = findLargestInSubTree(check.getLeft());
			delete(largest.getData());
			Node R = check.getRight();
			Node L = check.getLeft();
			check = largest;
			check.setRight(R);
			check.setLeft(L);
		}
	}

	private Node findLargestInSubTree(Node root){
		Node prev = null;
		Node check = root;
		while(check != null){
			prev = check;
			check = check.getRight();
		}
		return prev;
	}

	public String toString(){
		return null;
	}

}
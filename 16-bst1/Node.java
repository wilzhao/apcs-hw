

public class Node{

	private int data;
	private Node left, right;

	public Node(int d){
		data = d;
	}

	public int getData(){
		return data;
	}

	public Node getLeft(){
		return left;
	}

	public Node getRight(){
		return right;
	}

	public void setLeft(Node L){
		left = L;
	}

	public void setRight(Node R){
		right = R;
	}

	public void set(int d){
		data = d;
	}



}
public class MyStack {
    private Node top; 
    private int numElts;

    public MyStack(){
	top = null;
	numElts = 0;
    }

    public void push(String s){
	Node tmp = new Node(s);
	tmp.setNext(top);
	top = tmp;
	numElts = numElts + 1;
    }

    public String pop() {
	String s = top.getData();
	top = top.getNext();
	numElts = numElts - 1;
	return s;
    }

    public String peek() {
	return top.getData();
    }

    public int size() {
	return numElts;
    }

    public boolean isEmpty() {
	return top == null;
    }
    public String toString() {
	String s = "";
	for (Node tmp = top; tmp != null; tmp = tmp.getNext()){
	    s += tmp.getData()+", ";
	}
	// Node tmp = top;
	// while (tmp != null){
	//     s += tmp.getData() +", ";
	//     tmp = tmp.getNext();
	// }
	return s;
    }

}

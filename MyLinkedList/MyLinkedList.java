

public class MyLinkedList{
    private Node head;

    public MyLinkedList(){
	head = null;
    }

    public String toString(){
	String s = "";
	Node temp = head;
	while (!(temp == null)){
	    s += temp + " ";
	    temp = temp.getNext();
	}
	return s;
    }

    public void add (String d){
	Node tmp = new Node(d);
	//head = tmp;
	tmp.setNext(head);//works no matter what is in the array
	head = tmp;
    }

}

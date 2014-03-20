

public class MyLinkedList{
    private Node head;

    public MyLinkedList(){
	head = null;
    }

    public String toString(){
	String s = "";
	Node temp = head;
	while (temp != null){
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

    public void add(int i, String s){
	Node adding = new Node(s);
	Node prev = null;
	Node temp = head;
	while (i > 0){
	    prev = temp;
	    temp = temp.getNext();
	    i--;
	}
	adding.setNext(temp);
	if (prev != null){
	    prev.setNext(adding);
	} else {
	    head = adding;
	}
	
    }
    
    public String get(int i){
	Node temp = head;
	int j = 0;
	while (temp != null){
	    if (i == j){
		return temp.getData();
	    }
	    j++;
	    temp = temp.getNext();
	}
	return null;
	
    }

    public String set(int i, String s){
	Node prev = null;
	Node temp = head;
	Node change = new Node(s);
	int j = 0;
	while (temp != null){
	    if (i == j){
		change.setNext(temp.getNext());
		if (prev != null){
		    prev.setNext(change);
		}
		return temp.getData();
	    }
	    prev = temp;
	    temp = temp.getNext();
	    j++;
	}
	return null;
    }
    
    public String remove(int i){
	Node prev = null;
	Node temp = head;
	int j = 0;
	while (temp != null){
	    if (i == j){
		if (i == 0){
		    head = temp.getNext();
		} else {
		    prev.setNext(temp.getNext());
		}
		return temp.getData();
	    }
	    prev = temp;
	    temp = temp.getNext();
	    j++;
	    }
	return null;
    }

    public int find (String s){
	int ind = 0;
	Node temp = head;
	while (temp != null){
	    if (s.equals(temp.getData())){
		return ind;
	    }
	    ind++;
	    temp = temp.getNext();
	}
	return -1;
    }

    public int length(){
	int len = 0;
	Node temp = head;
	while (temp != null){
	    len++;
	    temp = temp.getNext();
	}
	return len;
    }

}



public class LinkedListTail<E> implements Iterable<E>{
    private Node<E> head;
    private Node<E> tail;

    public LinkedListTail(){
	head = new Node<E>();
	tail = head;
    }
    
    public Node<E> getHead(){
	return head;
    }

    public LinkedListIterator<E> iterator(){
	return new LinkedListIterator<E>(this);
    }

    public String toString(){
	String s = "";
	Node<E> temp = head.getNext();
	while (temp != null){
	    s += temp + " ";
	    temp = temp.getNext();
	}
	return s;
    }

    public void add (E d){
	Node<E> add = new Node<E>(d);
	tail.setNext(add);
	tail = add;
    }

    public void add(int i, E s){
	Node<E> adding = new Node<E>(s);
	Node<E> prev = head;
	Node<E> temp = head.getNext();
	while (i > 0){
	    prev = temp;
	    temp = temp.getNext();
	    i--;
	}
	adding.setNext(temp);
	
	prev.setNext(adding);
	if (temp == null){
	    tail = adding;
	}

    }
    
    public E get(int i){
	Node<E> temp = head.getNext();
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

    public E set(int i, E s){
	Node<E> prev = head;
	Node<E> temp = head.getNext();
	Node<E> change = new Node<E>(s);
	int j = 0;
	while (temp != null){
	    if (i == j){
		change.setNext(temp.getNext());
		prev.setNext(change);
		if (temp.equals(tail)){
		    tail = change;
		}
		return temp.getData();
	    }
	    prev = temp;
	    temp = temp.getNext();
	    j++;
	}
	return null;
    }

    public Node<E> getTail(){
	return tail;
    }
    
    public E remove(int i){
	Node<E> prev = head;
	Node<E> temp = head.getNext();
	int j = 0;
	while (temp != null){
	    if (i == j){
		prev.setNext(temp.getNext());
		if (temp.getNext() == null){
		    tail = prev;
		}
		return temp.getData();
	    }
	    prev = temp;
	    temp = temp.getNext();
	    j++;
	}
	
	return null;
    }

    public int find (E s){
	int ind = 0;
	Node<E> temp = head.getNext();
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
	Node<E> temp = head.getNext();
	while (temp != null){
	    len++;
	    temp = temp.getNext();
	}
	return len;
    }

}

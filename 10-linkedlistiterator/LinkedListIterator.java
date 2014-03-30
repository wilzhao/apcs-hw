import java.util.Iterator;

public class LinkedListIterator<E> implements Iterator<E>{
    
    LinkedListTail L;
    Node<E> current;

    public LinkedListIterator(LinkedListTail L){
	this.L = L;
	current = L.getHead();
    }

    public boolean hasNext(){
	return (current != null);
    }

    public E next(){
	Node<E> temp = current;
	current = current.getNext();
	return temp.getData();
    }
    
    public void remove(){
	return;
    }
    
}

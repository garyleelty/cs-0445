
public class LinkedQueue<T> implements Queue<T> {
	 private int n;         // number of elements on queue
	 private Node first;    // beginning of queue
	 private Node last;
	 
	 //create a node 
	 private class Node {
	        private T item;
	        private Node next;
	    }
	
	    // set the new linkQueue
	 public LinkedQueue() {
	        first = null;
	        last  = null;
	        n = 0;
	    }
	@Override
	public T remove() {
		exception(); // empty can't remve
		T item = first.item; //return items
        first = first.next; // linked to next item
        n--;
        if (isEmpty()) last = null;  
        return item;
	}

	public void exception() {
		if(isEmpty()) {
			throw new UnsupportedOperationException("sss");
		}
	}
	@Override
	public T peek() {
		return first.item;
	}

	@Override
	public void add(T thing) {
		 	Node oldlast = last; // put in last
	        last = new Node();
	        last.item = thing;//put thing inn the node
	        if (isEmpty()) first = last; //check it empty or not if is empty the first item is been insert
	        else   oldlast.next = last;
	        n++;// items number++
	}

	@Override
	public boolean isEmpty() {
	
		return n == 0; 
	}

}

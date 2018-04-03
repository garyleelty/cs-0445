public class LinkedStack<T> implements Stack<T> {
	private int size;
	private Node first;
	// create the node first and size value
	 private class Node {
	   
			private T item;
	        private Node next;
	    }
	 //create the node class and the node next

	public LinkedStack()
	  {
	    first=null;
	    size = 0;
	  }
	//set the linked stack
	public void exception() throws UnsupportedOperationException{
		if(isEmpty()) {
			throw new UnsupportedOperationException("Invalid operation for sorted list.");
		}
	}
	//throw exception when the link list is empty, so you can't pop any value out

	@Override
	public T pop() {
		exception();
		 
		 
		T result = first.item;
		 first = first.next;
		 size--;
		 return result;
	}
	//first check the link list is not empty then pop one out and return the value

	@Override
	public T peek() {
	        return first.item;
	}
	// peek the first value of the array
	
	@Override
	public void push(T thing) {
		Node temp = first;
		first=new Node();
		first.item = thing;
		first.next = temp;
		size++;
		
	}
	//push or connect one thing in to a link list 

	@Override
	public boolean isEmpty() {

		return first==null;
	}
	//the first value is null. so the link list is empty

}

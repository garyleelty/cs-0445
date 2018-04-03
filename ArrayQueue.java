
public class ArrayQueue<T> implements Queue<T> {
	private T[] A; // new array
	private int front; // remove 
	private int last; // insert
	private int indexItems;//index in an array
	private int capity=10; //cap
	
	// new array queue
	@SuppressWarnings("unchecked")
	public ArrayQueue() {
		
		 A = (T[])(new Object[capity]);
		front=0;
		last=0;
		indexItems=0;
	}
	
	@Override
	public T remove() {
			exception();// check
			T removed = A[front%capity];
			A[front%capity]=null;//throw the non need stuff
			front++;
			indexItems--;
			return removed;
    }

	//exception
	public void exception() {
		if(indexItems==0) {
			throw new UnsupportedOperationException();
		}
	}

	@Override
	public T peek() {
		exception();
        return A[front%capity];//peeek
	}

	@Override
	public void add(T thing) {
		if(last%capity==front%capity&&indexItems>0) { 
		resize(); // double size
	}
	 	A [last%capity] = thing;
	    indexItems++;
	    last++;
	  
	}

	private void resize() {
	@SuppressWarnings("unchecked")
	T[]temp=(T[])(new Object[capity*2]);// new array double size
	//System.out.println(capity);
	//System.out.println(indexItems);
	
	
	
	for(int i=0;i< indexItems;i++){
		
		temp[i]=A[(front+i)%capity];
	}
		front=0; //become 0 
		last=indexItems; // last new pointer
		capity*=2; // for next time resize
		A=temp;  
	}

	@Override
	public boolean isEmpty() {
		return indexItems==0;// index = 0is empty
	}


}

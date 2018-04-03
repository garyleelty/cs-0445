

public class ArrayStack<T> implements Stack<T> {
	private int sizeIndex;
	private T[]A;
	//create  an arrayStack type T, and also create an int show the size
	

	@SuppressWarnings("unchecked")
	public ArrayStack() {
		
		A= (T[]) (new Object[10]);
		sizeIndex=0;
	}
	public void exception() throws UnsupportedOperationException {
		if(isEmpty()) {
			throw new UnsupportedOperationException("Invalid operation for sorted list.");
		
		}
	}
	//throw exception when trying to pop the array while is empty
	
	@Override
	public T pop() {
		exception();
		//exception method
		T top = A[sizeIndex- 1];
		A[sizeIndex- 1] = null;
		sizeIndex--;
		return top;	
		}
//pop one thing out, and decease the size by 1, when the array stack is empty check and throw exception
	@Override
	public T peek() {
		T top=null;
			top=A[sizeIndex-1];
			return top;
	}
	//peek the top one without pop it

	@Override
	public void push(T thing) {
		if(sizeIndex>=A.length) {
			addArray();
		}
		A[sizeIndex]=thing;
		sizeIndex++;	
	}
	//add one thing on the array stack and when the stack is full and extened the stack

	private void addArray() {
		@SuppressWarnings("unchecked")
		T[] newArray = (T[]) (new Object[2 * sizeIndex]);
		for (int i = 0; i < sizeIndex; i++) {
			newArray[i] = A[i];
		}
		A = newArray;
	}
	//extened array by double the size of the stack, i think is the fast way, it that right?
		

	@Override
	public boolean isEmpty() {
		return sizeIndex == 0;
	}
	//if the size of index is zero and will the stack must be empty



}


package assi1;


public class StringArrayList implements StringList {
	private String[]list;
	private int elements;
	
	public StringArrayList() {
		list=new String[5];
		elements=0;
	}
	
	public void capacity(int cap) {
	int oldCap=elements;

	
	if(cap>oldCap) {
		@SuppressWarnings("unused")
		String oldData[]=list;
		int newCap=(oldCap*3)/2+1;
		if(newCap<cap) {
			newCap=cap;
		}
		list=new String[newCap];
		for(int i=0; i<oldCap ;i++) {
			list[i]=oldData[i];
			
		}
		
	}
	
			
	}
	
	public void range(int index) {
		if (index > elements || index < 0) {
			throw new IndexOutOfBoundsException(outOfBoundsMsg(index));}
			
	}
	
	private String outOfBoundsMsg(int index) {
		return "Index: "+index+", Size: "+ elements;
	}

	
	public int add(String s) {
		if(elements<list.length) {
			list[elements]=s;
			elements++;
		} else {
			capacity(elements++);
		}
		return elements;
		
		
	}


	public String get(int i) {
		range(i);
		return list[i];
	}

	public boolean contains(String s) {
		
		return indexOf(s)>=0;
	}

	public int indexOf(String s) {
		
			for(int i=0;i<elements;i++) {
				if(s.equals(list[i]))
					return i;
			}
		return -1;
	}


	public int size() {                
		return elements;
	}

	
	public int add(int index, String s) {
		range(index);
		capacity(elements+1);
		System.arraycopy(list, index, list, index+1,
				elements-index);
		list[index]=s;
		elements++;
		return index-1;
	}


	public void clear() {
		for(int i=0;i<elements;i++) {
			list[i]=null;
		}
			elements=0;
	}

	
	public boolean isEmpty() {
		return elements==0;
	}

	
	public String remove(int i) {
		range(i);
		String oldValue=list[i];
		int move=elements-i-1;
		if(move>0)
			System.arraycopy(list, i+1, list, i, move);
		list[--elements]=null;
		return oldValue;
	}


	public void set(int index, String s) {
		range(index);
	     list[index] = s;
	}


	public String[] toArray() {
		String[] array = new String[elements];

		for (int i = 0; i < elements; i++) {
		    array[i] = list[i];}
		return array;

	}
}

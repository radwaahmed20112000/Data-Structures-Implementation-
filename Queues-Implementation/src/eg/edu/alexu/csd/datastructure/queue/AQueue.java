package eg.edu.alexu.csd.datastructure.queue;

public class AQueue implements IQueue,IArrayBased{
	
	static int n;
	Object[] A;
	public AQueue(int x){
		n =x;
		A = new Object[n];
	}
	int front=0,size=0;
	
	@Override
	public void enqueue(Object item) {
		if(size == n-1) {
			throw new RuntimeException("The Queue is full");
		}else {
			A[size]=item;
			size ++;
		}
		
	}

	@Override
	public Object dequeue() {
		if(size==0) {
			return null;
		}else {
			Object x = A[0];
			for(int i=0;i<size ;i++) {
				if(i != size-1) {
					A[i]=A[i+1];}
			}
			size --;
			return x;
		}
	}

	@Override
	public boolean isEmpty() {
		if(size ==0) {
			return true;
		}else{
			return false;
		}
	}

	@Override
	public int size() {
		
		return size;
	}

}

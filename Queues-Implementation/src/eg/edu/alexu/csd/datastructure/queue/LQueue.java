package eg.edu.alexu.csd.datastructure.queue;

public class LQueue implements IQueue,ILinkedBased{

	private class Node{
		Node next ;
		Object data;
	}
	Node front ,rear = new Node();
	int size=0;
	@Override
	public void enqueue(Object item) {
		Node n =new Node();
		n.data = item;
		if(size ==0) {
			front = n;
			rear = n;
			size++;
		}else {
			rear.next = n;
			rear = rear.next;
			size++;
		}
		
	}

	@Override
	public Object dequeue() {
		if(size ==0) {
			return null;
		}else {
			Object z = front.data;
			front = front.next;
			size--;
			return z;
		}
	}

	@Override
	public boolean isEmpty() {
		if(size==0) {
			return true;
		}else {
			return false;
		}
	}

	@Override
	public int size() {
		return size;
	}

}

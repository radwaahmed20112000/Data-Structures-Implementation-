package eg.edu.alexu.csd.datastructure.stack.cs23;

public class Stack implements IStack {
	
	private class Node{
		Node link;
		Object data;
	}
	int size=0;
	Node top;
	
	@Override
	public Object pop() {
		if(size==0) {
			return null;
		}else {
		    Object n = top.data;
		    top = top.link;
		    size--;
			return n;}
	}

	@Override
	public Object peek() {
		if(size==0) {
			return null;
		}else {
			Object n = top.data;
			return n;}
	}

	@Override
	public void push(Object element) {		
		Node n = new Node();
		n.data = element;
		n.link = top;
		top = n;
		size++;
	}

	@Override
	public boolean isEmpty() {
		if(size==0) {
			return true;
		}else {
			return false;}
	}

	@Override
	public int size() {
		int x=0;
		if(size==0) {
			return 0;
		}
		Node n = top;
		while (n.link != null) {
			n = n.link;
			x++;
		}
		return ++x;
	}
	
	public void show() {
		Node n=top;
		for(int i=0;i<size;i++) {
			System.out.println(n.data);
			n=n.link;
		}
	}

}

package eg.edu.alexu.csd.datastructure.linkedList;


public class DoubleLinkedList implements ILinkedList {
	private class Node{
		Object data;
		Node next;
		Node prev;
	}
	Node head;
	Node tail;
	@Override
	public void add(int index, Object element) {
		Node node = new Node();
		node.data = element;
		Node n = head;
		if(index == 0) {
			insertAtStart(element);
		}
		else {
			for(int i =0 ;i< index;i++) {
				n= n.next;
			}
			Node d = n.prev;
			d.next = node;
			n.prev = node;
			node.next =n;
			node.prev = d;

		}
		
	}

	@Override
	public void add(Object element) {
        Node tmp = new Node();
        tmp.data = element;
        if(tail != null) {
        	tail.next = tmp;
        }
        tail = tmp;
        if(head == null) {
        	head = tmp;
       	}
	}

	@Override
	public Object get(int index) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void set(int index, Object element) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void clear() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public boolean isEmpty() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public void remove(int index) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public int size() {
		Node node = head;
		int i = 0;
		if(head == null) {
			return 0;
		}else {
		while(node.next != null) {
			node = node.next;
			i++;
		}
		return ++i;}
	}

	@Override
	public ILinkedList sublist(int fromIndex, int toIndex) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean contains(Object o) {
		// TODO Auto-generated method stub
		return false;
	}
	public void show() {
		if(head==null) {
			System.out.println("Empty");
		}else {
			Node node = head;
			while(node.next != null) {
				System.out.println(node.data);
				node= node.next;
			}
			System.out.println(node.data);
		}
	}
	public void insertAtStart(Object data) {
		Node node = new Node();
		node.data = data;
		node.next = null;
		node.next =head;
		if(head == null) {
			head = node;
		}
		else {
			head.prev = node;
			head = node;
		}
		if(tail != null ) {
			tail = node;
		}
	}
}

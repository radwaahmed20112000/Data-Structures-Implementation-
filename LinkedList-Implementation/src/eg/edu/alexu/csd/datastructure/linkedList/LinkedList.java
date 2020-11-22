package eg.edu.alexu.csd.datastructure.linkedList;

import eg.edu.alexu.csd.datastructure.linkedList.DoubleLink.Node;

public class LinkedList implements ILinkedList {
	
	private class Node {
		Object data;
		Node next;
	}
	
	Node head;
	
	@Override
	public void add(int index, Object element) {
		if(index <0 || index > size()) {
			throw new NullPointerException("invalid index");
		}
		Node node =new Node();
		node.data=element;
		node.next=null;
		if(index==0) {
			insertAtStart(element);
		}else {
			Node n = head;
			for(int i=0;i<index-1;i++) {
				n = n.next;
			}
			node.next = n.next;
			n.next=node;
		}
	}

	@Override
	public void add(Object element) {
		// TODO Auto-generated method stub
		Node node = new Node();
		node.data =element;
		if(head == null) {
			head = node;
		}
		else {
			Node n=head;
			while(n.next != null) {
				n= n.next;
			}
			n.next = node;
		}
	}

	@Override
	public Object get(int index) {
		// TODO Auto-generated method stub
		if(index <0 || index > size()) {
			throw new NullPointerException("invalid index");
		}
		Node n = head;
		for(int i =0;i<index;i++) {
			n = n.next;
		}
		return n.data;
	}

	@Override
	public void set(int index, Object element) {
		if(index <0 || index > size()) {
			throw new NullPointerException("invalid index");
		}
		// TODO Auto-generated method stub
		Node n = head;
		for(int i =0;i<index;i++) {
			n= n.next;
		}
		n.data= element;
	}

	@Override
	public void clear() {
		// TODO Auto-generated method stub
		Node n = head;
		for(int i=this.size()-1;i>0;i--){
			this.remove(i);
		}
		head=null;
	}

	@Override
	public boolean isEmpty() {
		// TODO Auto-generated method stub
		if(head==null) {
			return true;
		}
		return false;
	}

	@Override
	public void remove(int index) {
		// TODO Auto-generated method stub
		
		if(index <0 || index > size()) {
			throw new NullPointerException("invalid index");
		}
		if(index==0) {
			head = head.next;
		}
		else {
			Node n = head;
			Node n1=null;
			for(int i=0;i<index-1;i++) {
				n= n.next;
			}
			n1= n.next;
			n.next=n1.next;
			n1=null;
		}
	
	}
	

	@Override
	public int size() {
		// TODO Auto-generated method stub
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
		if(fromIndex <0 || fromIndex > size() || toIndex <0 || toIndex > size() || fromIndex > toIndex ) {
			throw new NullPointerException("invalid index");
		}
		
		// TODO Auto-generated method stub
		ILinkedList x = new LinkedList();
		for(int i=fromIndex-1;i<toIndex;i++) {
			x.add(this.get(i));
		}
		return x;
	}

	@Override
	public boolean contains(Object o) {
		// TODO Auto-generated method stub
		Node node =new Node();
		Node n =head;
		node.data=o;
		while(n.next != null) {
			if(n.data == node.data) {
				return true;
			}
			n=n.next;
		}
		return false;
	}
	
	public void insertAtStart(Object data) {
		Node node = new Node();
		node.data = data;
		node.next = null;
		if(head == null) {
			head = node;
		}
		else {
			Node n=head;
			node.next = n;
			n = n.next;
		}
		head = node;
		
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
	/*public ILinkedList copy(ILinkedList radwa) {
		Node node= head;
		while(node.next != null) {
			radwa.add(node.data);
			node = node.next;
		}
		radwa.add(node.data);
		return radwa;
		
	}*/
	public void reverse() {
		Node s = head;
		Object n;
		for(int i=0 ;i< size()/2-1;i++) {
			Node e = head;
			for(int j=0;j<size()-1-i;j++) {
				e = e.next;
			}
			n = s.data;
			s.data =e.data;
			e.data=n;
		}
	}
	public boolean order() {
		Node s =head;
		Object n;
		for(int i=0 ;i< size()/2;i++) {
			Node e = head;
			for(int j=0;j<size()-1-i;j++) {
				if((int)s.data > (int)e.data) {
					return false;
				}
				e = e.next;
			}
			s= s.next;
		}
		return true;
	}
	public void sort() {
		for(int i=0;i<size();i++) {
		Node s =head;
		Node e = head.next;
		for(int j=0;j<this.size()-1;j++) {
			if((int)s.data > (int)e.data) {
				Object k = s.data;
				s.data = e.data;
				e.data =k;
			}
			s = e;
			e= e.next;
		}
		}
	}
	public boolean palindrome() {
		Node n = head;int z=0;
		for(int i =0 ; i< this.size();i++) {
			if(this.get(i)==this.get(size()-i-1)) {
				z++;
			}
		}
		if(z==size()) {
			return true;
		}else {
			return false;
		}
	}
	
}



public class hashDictionary<K, V> implements IDictionary<K, V>{	
	int size;
	Node[] hash;
	int s=0;
	
	public hashDictionary(int s) {
		size = s;
		hash = new Node[size];
		for(int i=0;i<size;i++) {
			hash[i] = new Node<K, V>();
			hash[i] = null;
		}
	}
	@Override
	public V get(K key) {
		if(key == null) {
			throw new NullPointerException("You didn't Enter any key");
		}
		int k = Math.abs(key.hashCode());
		
		Node node = new Node();
		node = hash[k%size];
		
		while(node != null ) {
			if(key == node.getkey()) {
				return  (V) node.getvalue();
			}
			node = node.next;
		}
		return null;
	}

	@Override
	public V set(K key, V value) {
		if(key== null || value == null) {
			throw new NullPointerException("you didn't enter value or key");
		}
		if(get(key)==null ) {
			//Assign new node with the given key and value.
			Node<K, V> n = new Node<K, V>();
			n.set(key, value);
			
			//Calculate the index of Hash table array "Chaining".
			int k = Math.abs(key.hashCode());
			Node node = new Node();
			node = hash[k%size];
			if(node ==null) {
				node = n;
				hash[k%size] = node;
				s++;
				return null;
			}else {
				while(node.next != null) {
					node= node.next;
				}
				node.next = n;
				s++;
				return null;
			}
		}else {
			V val = remove(key);
			set(key,value);
			return val;
		}
	}

	@Override
	public V remove(K key) {
		if(key == null) {
			throw new NullPointerException("You didn't Enter any key");
		}
		int k = Math.abs(key.hashCode());
		Node node = new Node();
		node = hash[k%size];
		if(key == node.getkey()) {
			V val = (V) node.getvalue();
			hash[k%size] = hash[k%size].next;
			s--;
			return  val;
		}else {
			while(node.next != null ) {
				node = node.next;
				if(key == node.getkey()) {
					V val = (V) node.getvalue();
					Node n1 = null;
					n1= node;
					node=n1.next;
					n1=null;
					s--;
					return  val;
				}
			}
			return null;
		}
	}

	@Override
	public boolean isEmpty() {
		if(s==0) {
			return true;
		}else {
			return false;
		}
	}



}

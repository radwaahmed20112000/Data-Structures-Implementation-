
public class Node<K,V> {
	K key;
	V value;
	Node next=null;
	
	public void set (K k, V v){
		key = k;
		value = v;
		next = null;
	}

	public K getkey() {
		return key;
	}
	public V getvalue() {
		return value;
	}
}

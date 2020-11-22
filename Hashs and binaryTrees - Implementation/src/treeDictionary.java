
public class treeDictionary<K,V> implements IDictionary<K,V> {
	int size=0;
	
	private class bstNode {
		K key;
		V value;
		bstNode left,right;
	}
	bstNode root;
	
	@Override
	public V get(K key) {
		if(key == null) {
			throw new NullPointerException("You didn't Enter any key");
		}
		bstNode x = root;
		while (x != null)
		{
			int cmp = ((String)key).compareTo((String)x.key);
			if (cmp < 0) {
				x = x.left;
			}
			else if (cmp > 0) {
				x = x.right;
			}
			else if (cmp == 0) {
				return x.value;
			}
		}
		return null;
	}

	@Override
	public V set(K key, V value) {
		if(key== null || value == null) {
			throw new NullPointerException("you didn't enter value or key");
		}
		if(val == null) {
			size++;
		}
		root = set(root, key, value); 
		
		
		return val;

	}
	V val = null;
	private bstNode set(bstNode x, K key, V value) {
		if(get(key) == null) {
			if (x == null) {
				bstNode n = new bstNode();
				n.key = key;
				n.value = value;
				return n;
			}
			int cmp = ((String)key).compareTo((String)x.key);
			if (cmp < 0) {
				x.left = set(x.left, key, value);
			}
			else if (cmp > 0) {
				x.right = set(x.right, key, value);
			}
			else if (cmp == 0) {
				x.value = value;
			}
			return x;
		}else {
			val = remove(key);
			set(x,key,value);
			return x ;
		}

	}

	@Override
	public V remove(K key) {
		root = delete(root, key); 
		return null;
	}
	
	private bstNode deleteMin(bstNode x){
	if (x.left == null) {
		return x.right;
	}
	x.left = deleteMin(x.left);
	return x;
	}
	
	private bstNode delete(bstNode x, K key) {
		if (x == null) return null;
		int cmp = ((String)key).compareTo((String)x.key);
		if(cmp < 0) {
			x.left = delete(x.left, key);
		}
		else if(cmp > 0) {
			x.right = delete(x.right, key);
		}
		else {
			if (x.right == null) {
				return x.left;
			}
			if (x.left   == null) {
				return x.right;
			}
			bstNode t = x;
			x = min(t.right);
			x.right = deleteMin(t.right);
			x.left = t.left;
		}
		return x;
		}


	private bstNode min(bstNode right) {
		while(right !=null) {
			right = right.left;
		}
		return right;
	}

	@Override
	public boolean isEmpty() {
		if(size == 0) {
			return true;
		}else {
			return false;
		}
	}

}

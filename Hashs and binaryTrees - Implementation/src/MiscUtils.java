import eg.edu.alexu.csd.datastructure.stack.cs23.Stack;

public class MiscUtils implements IMiscUtils{
	int sum = 0;
	boolean left = true,right = true;

	@Override
	public BinaryTreeNode insert(BinaryTreeNode root, int element) {
		BinaryTreeNode node = new BinaryTreeNode(element);
		if(root==null) {
			return node;
		}else {
			if(element > (int)root.element) { 
				root.right = insert(root.right,element);
			}else if(element < (int)root.element) {
				root.left = insert(root.left,element);
			}
		}
		return root;
	}

	@Override
	public int sumRange(BinaryTreeNode root, int low, int high) {
		if(root == null) {
			return 0;
		}else {
			if( (int) root.element >= low && (int) root.element <= high ) {
				sum = sum + (int) root.element;
				sumRange(root.left,low,high);
				sumRange(root.right,low,high);
			}
		}
		return sum;
	}

	@Override
	public boolean isValidBST(BinaryTreeNode root) {
		if (root == null) {
			return true;
		}else {

			if(root.left != null && (int)root.left.element >= (int)root.element ) {
				left = false;
			}
			if(root.right != null && (int)root.right.element <= (int)root.element ) {
				right = false;
			}
			if(!isValidBST(root.right)) {
				return false;
			}
			if(!isValidBST(root.left)) {
				return false;
			}
			return (left && right) ;
		}
	}

	@Override
	public int[] nextSmallerNumber(int[] array) {
		Stack s = new Stack();
		int[] result = new int[array.length];
		for(int i =0 ;i< array.length;i++) {
			s.push(array[array.length-i-1]);
		}
		int i =1,j=1,x=0;
		while(!s.isEmpty()) {
			if(j == i) {
				x = (int) s.pop();
			}
			if(j<array.length && array[j] < x) {
				result[i-1] = j;
				j = ++i;
			}else if(j >= array.length){
				result[i-1] = -1;
				j = ++i;
			}else {
				j++;
			}
		}
		return result;
	}

}

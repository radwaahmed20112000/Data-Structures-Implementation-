
public class main {

	public static void main(String[] args) {
		MiscUtils m = new MiscUtils();
		BinaryTreeNode root = null;
		BinaryTreeNode l = new BinaryTreeNode(25);
		BinaryTreeNode l1 = new BinaryTreeNode(30);
		BinaryTreeNode l2 = new BinaryTreeNode(15);
		BinaryTreeNode l3 = new BinaryTreeNode(24);
		/*root = m.insert(root, 5);
		root =m.insert(root, 6);
		root =m.insert(root, 8);
		root =m.insert(root, 4);
		root =m.insert(root, 3);
		root =m.insert(root, 2);*/
		root = l;
		root.right = l1;
		root.left = l2 ;
		root.right.left = l3;
		//int x = m.sumRange(root, 0,0);
		//System.out.println(x);
		boolean z = m.isValidBST(root);
		System.out.println(z);
		int[] i = {200,300,400,500};
		//int[] g = m.nextSmallerNumber(i);
		/*for(int j=0;j<g.length;j++) {
			System.out.println(g[j]);
		}*/
		treeDictionary O = new treeDictionary();
		/*O.set(10, "k");
		O.set(12, 250);
		O.set(2, 90);
		O.set(13, 40);
		O.set(4, 66);
		System.out.println(O.get(2));
		O.set(12, 230);
		System.out.println(O.s);
		O.set(33, 40);
		O.set(13, 405);
		O.set(23, 40);
		System.out.println(O.get(13));
		System.out.println(O.s);
		System.out.println(O.get(23));
		System.out.println(O.s);*/
		
		O.set("10", "k");
		O.set("12", 250);
		O.set("2", 90);
		O.set("13", 40);
		O.set("4", 66);
		System.out.println(O.remove("12"));
		O.set("12", 230);
		System.out.println(O.size);
		System.out.println(O.remove("13"));
		O.set("33", 40);
		O.set("13", 405);
		O.set("23", 40);
		System.out.println(O.size);
		System.out.println(O.get("23"));
		System.out.println(O.size);
		/*System.out.println(O.remove(23));
		System.out.println(O.size);*/
		

		
		
	}

}

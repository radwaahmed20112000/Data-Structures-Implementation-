package eg.edu.alexu.csd.datastructure.linkedList;

import static org.junit.Assert.assertEquals;

public class mm {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		LinkedList radwa = new LinkedList();
		LinkedList Ahmed = new LinkedList();
		radwa.add(1);
		radwa.add(2);
		radwa.add(1);
		radwa.add(1);
		radwa.add(7);
		radwa.add(1);
		if(radwa.palindrome()) {
			System.out.println("palindrome");
		}
		radwa.sort();
		radwa.show();
		//System.out.println(radwa.size());
		//System.out.println(radwa.size());
		
		
		
		
		
		
	}

}

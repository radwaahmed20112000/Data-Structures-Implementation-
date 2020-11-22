package eg.edu.alexu.csd.datastructure.linkedList;

import static org.junit.Assert.*;

import org.junit.Test;

public class Linktest {
	LinkedList b = new LinkedList();
	ILinkedList h = new LinkedList();
	
	/*public void testException() {
		b.get(-1);
	}*/
	
	@Test
	public void test1() {
		b.add(20);
		b.add(30);
		b.add(40);
		b.add(50);
		b.add(60);
		Object x;
		x= b.get(2);
		assertEquals(x,40);
	}
	
	@Test( expected = NullPointerException.class )
	public void testException() {
		b.add(20);
		b.add(30);
		b.add(40);
		b.add(50);
		b.add(60);
		b.get(-1);
		b.set(89, 5);
		b.remove(-5);
		b.sublist(8, 2);
		b.sublist(-2, 3);
	}
	@Test
	public void test2() {
		b.add(20);
		b.add(30);
		b.add(40);
		b.add(50);
		b.add(60);
		b.add(2, 666);
		Object x;
		x= b.get(2);
		assertEquals(x,666);
	}
	@Test
	public void test3() {
		b.add(20);
		b.add(30);
		b.add(40);
		b.add(50);
		b.add(60);
		b.set(2, 555);
		Object x;
		x= b.get(2);
		assertEquals(x,555);
	}
	@Test
	public void test4() {
		b.add(20);
		b.add(30);
		b.add(40);
		b.add(50);
		b.add(60);
		ILinkedList h= new LinkedList();
		h = b.sublist(2, 4);
		int n =h.size() ;
		assertEquals(n,3);
		Object z1 = h.get(0);
		Object z2 = h.get(1);
		Object z3 = h.get(2);
		assertEquals(z1,30);
		assertEquals(z2,40);
		assertEquals(z3,50);
	}
	@Test
	public void test5() {
		b.add(20);
		b.add(30);
		b.add(40);
		b.add(50);
		b.add(60);
		Object x;
		b.remove(2);
		int z= b.size();
		x = b.get(2);
		assertEquals(z,4);
		assertEquals(x,50);
	}
	@Test
	public void test6() {
		b.add(20);
		b.add(30);
		b.add(40);
		b.add(50);
		b.add(60);
		Object x;
		boolean z= b.contains(40);
		x = b.get(2);
		boolean n = b.contains(-1);
		assertTrue("True",z);
		assertFalse("False",n);
	}
	@Test
	public void test7() {
		b.add(20);
		b.add(30);
		b.add(40);
		b.add(50);
		b.add(60);
		b.clear();
		boolean z = b.isEmpty();
		assertTrue("True",z);
	}
	
	
	

}

package eg.edu.alexu.csd.datastructure.linkedList;

import static org.junit.Assert.*;

import javax.management.RuntimeErrorException;

import org.junit.Test;

public class polynomialsolvertest {
	polyfarida t = new polyfarida();
	int[][] terms = new int[100][2]; 
	@Test
	public void test() {
		t.A.add(1);
		t.A.add(-1);
		t.A1.add(2);
		t.A1.add(0);
		float b =t.evaluatePolynomial('A', 1);
		assertEquals( 0.0 , b , .0 );
		
	}
	
	@Test( expected = RuntimeException.class )
	public void testException() {
		t.A.add(1);
		t.A.add(-1);
		t.A1.add(2);
		t.A1.add(0);
		float b =t.evaluatePolynomial('T', 1);
		t.setPolynomial('y', terms);
		t.print('2');
		t.clearPolynomial('5');
		t.add(')', 'o');
		t.subtract('P', 'A');
		t.multiply('B', 'Z');
	}
	@Test
	public void test2() {
		t.A.add(1);
		t.A.add(-1);
		t.A1.add(2);
		t.A1.add(0);
		t.B.add(1);
		t.B.add(-1);
		t.B1.add(1);
		t.B1.add(0);
		int[][] terms = t.add('A', 'b');
		String s= t.print('R');
		assertEquals( s ,"X^(2)+X-2" );
	}
	@Test
	public void test3() {
		t.A.add(1);
		t.A.add(-1);
		t.A1.add(2);
		t.A1.add(0);
		t.B.add(1);
		t.B.add(-1);
		t.B1.add(1);
		t.B1.add(0);
		int[][] terms = t.subtract('A', 'b');
		String s= t.print('R');
		assertEquals( s ,"X^(2)-X" );
	}
	@Test
	public void test4() {
		t.A.add(1);
		t.A.add(-1);
		t.A1.add(2);
		t.A1.add(0);
		t.B.add(1);
		t.B.add(-1);
		t.B1.add(1);
		t.B1.add(0);
		int[][] terms = t.multiply('A', 'b');
		String s= t.print('R');
		assertEquals( s ,"X^(3)-X^(2)-X+1" );
		t.A.add(1);
		t.A.add(1);
		t.A1.add(3);
		t.A1.add(2);
		t.B.add(1);
		t.B.add(1);
		t.B1.add(-1);
		t.B1.add(0);
		int[][] terms1 = t.add('A', 'b');
		String s1= t.print('R');

		assertEquals(s1,"X^(3)+X^(2)+1+X^(-1)");
		
	}
	
	
	

}

package eg.edu.alexu.csd.datastructure.stack.cs23;

import static org.junit.Assert.*;

import org.junit.Test;

public class ExpressionEvaluatorTest {
	ExpressionEvaluator x = new ExpressionEvaluator();
	
	@Test
	public void test() {
		String s = x.infixToPostfix("((9-3)*(4+2)-6+10)/4/5");
		int t = x.evaluate(s);
		assertEquals(2,t);
	}
	
	@Test
	public void test2() {
		String s = x.infixToPostfix("(a / (b - c + d)) * (e - a) * c");
		assertEquals("a b c - d + / e a - * c * ",s);
	}
	@Test
	public void test3() {
		String s = x.infixToPostfix("(5)");
		int t = x.evaluate(s);
		assertEquals("5 ",s);
		assertEquals(5,t);
	}
	@Test
	public void test4() {
		String s = x.infixToPostfix("(5)");
		int t = x.evaluate(s);
		assertEquals("5 ",s);
		assertEquals(5,t);
	}
	@Test
	public void test5() {
		String s = x.infixToPostfix("-555+-888*7-(68/(25+(9/2)))");
		int t = x.evaluate(s);
		assertEquals("0 1 - 555 * 0 888 - 7 * + 68 25 9 2 / + / - ",s);
		assertEquals(-6773,t);
	}
	
	@Test( expected = RuntimeException.class )
	public void testException() {
		x.infixToPostfix("(8-9");
		x.infixToPostfix("");
		x.infixToPostfix("5+9/0");
		x.infixToPostfix("8+&-3");
		x.infixToPostfix("1++3");
		x.infixToPostfix("3+()");
		
	}
	
	


}

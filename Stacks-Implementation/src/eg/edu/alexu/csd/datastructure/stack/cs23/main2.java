package eg.edu.alexu.csd.datastructure.stack.cs23;

public class main2 {

	public static void main(String[] args) {
		ExpressionEvaluator radwa = new ExpressionEvaluator();
		String x = radwa.infixToPostfix("()");
		String s = radwa.DummyZero(x);
		//(0-(4+3))
		//int t = radwa.evaluate(s);
		System.out.println(s);
	}

}

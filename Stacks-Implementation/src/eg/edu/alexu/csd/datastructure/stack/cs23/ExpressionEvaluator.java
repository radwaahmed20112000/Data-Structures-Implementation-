package eg.edu.alexu.csd.datastructure.stack.cs23;

public class ExpressionEvaluator implements IExpressionEvaluator{
	
	Stack opt = new Stack(); //operators Stack used in infixtopostfix
	Stack opr = new Stack(); //operands Stack used in evaluation 
	int i1=0; //counter for infixToPostfix
	/**
	* Takes a symbolic/numeric infix expression as input and converts it to
	* postfix notation. There is no assumption on spaces between terms or the
	* length of the term (e.g., two digits symbolic or numeric term)
	*
	* @param expression
	* infix expression
	* @return postfix expression
	*/
	@Override
	public String infixToPostfix(String expression) {
		StringBuilder pf = new StringBuilder(); // the postfix expression 
		expression = removespaces(expression); 
		expression = CheckInputValidation(expression);
		expression = DummyZero(expression);
		String e = expression;
		for(i1 = 0 ; i1 < e.length() ;i1++) { 
			//take operand and append it to the string
			if(Character.isDigit(e.charAt(i1)) || Character.isLetter(e.charAt(i1))) { //check if the character is letter or number
				int j =0; //counter to know how many digits in the following operand 
				while (i1 != e.length() &&e.charAt(i1) != '+' &&e.charAt(i1) != '-' && e.charAt(i1) != '/' && e.charAt(i1) != '*'&&e.charAt(i1) != ')'&&e.charAt(i1) != '(' ) {
					j++;
					i1++;
				}
				if(j>0) {
					String s = e.substring(i1-j, i1);
					pf.append( s ).append(' ');
				}
				i1--;
				if(i1 == e.length()-1 ) {
					break;
				}
			}
			else if (e.charAt(i1)=='(') {
				opt.push(e.charAt(i1));
			}
			else if(e.charAt(i1)=='-'||e.charAt(i1)=='/'||e.charAt(i1)=='+'||e.charAt(i1)=='*') {
				while(!(opt.isEmpty()) && higherpres(e.charAt(i1)) && (char)opt.peek() !='(') {
					pf.append( opt.pop() ).append(' ');
				}
				opt.push(e.charAt(i1));
			}
			else if (e.charAt(i1)==')') {
				while((char)opt.peek() != '(') {
					pf.append( opt.pop() ).append(' ');
				}
				opt.pop();
			}
		}
		while(!(opt.isEmpty()) ) {
			if((char)opt.peek() != '(') {
				pf.append(opt.pop()).append(' ');}
			else if((char)opt.peek()=='(') {
				opt.pop();
			}
		}
		return pf.toString();
		
	}
	/**
	* Takes String with negative numbers and return it with a dummy zero 
	* example : convert 3*-4 to 3*(0-4)  
	* @param expression
	* infix expression
	* @return  expression with dummy zero
	*/
	public String DummyZero(String expression) {
		
		StringBuilder e = new StringBuilder(); //the string with dummy zeroes
		int i=0; 
		if(expression.charAt(0)=='-') {
			e.append("(0-1)*");
			i++;
		}
		
		for(int j=i ; j < expression.length() ;j++) {
			if(expression.charAt(j)=='-' ||expression.charAt(j)=='+'||expression.charAt(j)=='/'||expression.charAt(j)=='*'||expression.charAt(j)=='(') {
				e.append(expression.charAt(j));
				if((j+1 != expression.length() && expression.charAt(j+1)=='-')) {
					if(j+2!=expression.length() && expression.charAt(j+2)=='(') {
						e.append("(0-1)*");
						j++;
					}else {
						e.append("(0-");
						j++;
						while(++j != expression.length() && Character.isDigit(expression.charAt(j))) {
							e.append(expression.charAt(j));
						}
						j--;
						e.append(')');}
				}
			}else {
				e.append(expression.charAt(j));
			}
		}
		return e.toString();
	}

	/**
	* function checks validation of input . if it has incomplete parentheses , division by zero , -
	* any Special character or repeated operators ,it'll throw an exception
	* 
	* @param expression
	* infix expression
	* @return Same exception  
	*/
	public String CheckInputValidation(String e ) {
		//Check division by zero
		for(int i=0;i<e.length();i++) {
			if(e.charAt(i)== '/') {
				if(e.charAt(i+1)=='0' && i+1 != e.length()-1) {
					throw new RuntimeException("You can't Divide by zero!");
				}
			}
		}
		//Check incomplete parentheses
	    Stack st=new Stack(); //stack is used to make sure that the parentheses are complete
	    for(int i =0;i<e.length();i++) {
	    	if(e.charAt(i)=='(') {
	    		st.push('(');
	    	}
	    	if(e.charAt(i)==')') {
	    		if(st.isEmpty()) {
	    			throw new RuntimeException("Invalid Input ");
	    		}
	    		else if((char)st.pop()=='('){
	    		}else {
	    			throw new RuntimeException("Invalid Input");
	    		}
	    	}
	    }
	    if(!(st.isEmpty())) {
			throw new RuntimeException("Invalid Input");
	    }
	    
	    //Check Special Characters existance .
	    for(int i =0 ;i<e.length();i++) {
	    	char n= e.charAt(i);
	    	if(Character.isDigit(n)||Character.isLetter(n)||e.charAt(i)=='+'||e.charAt(i)=='-'||e.charAt(i)=='*'||e.charAt(i)=='/'||e.charAt(i)==')'||e.charAt(i)=='(') {
	    	}else {
	    		throw new RuntimeException("Invalid Input");
	    	}
	    }
	    //Check repeated operators
	    int i =0;
	    int n = e.length();
	    for(int j =0 ;j<n;j++) {
		    if(e.charAt(j)=='+'||e.charAt(j)=='*'||e.charAt(j)=='-'||e.charAt(j)=='/') {
		    	while(++j != n && (e.charAt(j)=='+'||e.charAt(j)=='/'||e.charAt(j)=='*'))
		    		i++;
		   	}}
	    if(i>0) {
    		throw new RuntimeException("Invalid Input");
	    }
	    if(e.length()==0 ) {
	    	throw new RuntimeException("Invalid Input");
	    }
	    //Check Empty parentheses 
	    for(int j=0;j<e.length();j++) {
	    	if(j+1 != e.length() && e.charAt(j)=='('&&e.charAt(j+1)==')') {
	    		throw new RuntimeException("Invalid Input");
	    	}
	    }
		return e ;
	}
	
	/**
	* Take operator in the expression and compare its precedence with the last operator 
	* in the Stack .
	*
	* @param operator
	* 
	* @return true or false
	*/
	public boolean higherpres(char oprt) {
		if(oprt == '+'|| oprt =='-') {
			if((char)opt.peek() == '*' || (char)opt.peek() == '/' ) {
				return true;
			}else {
				return true;
			}
		}else if (oprt == '/'|| oprt =='*') {
			if((char)opt.peek() == '+' || (char)opt.peek() == '-' ) {
				return false;
			}else {
				return true;
			}
		}
		return false;
	}
	/**
	* Evaluate a postfix numeric expression, with a single space separator
	*
	* @param expression
	* postfix expression
	* @return the expression evaluated value
	*/
	@Override
	public int evaluate(String expression) {
		String e =expression;
		float result=0; //the returned result 
		if(e.length()==2) {
			e = removespaces(e);
			int z =Integer.parseInt(e);
			return z;
		}
		for(int i =0 ;i<expression.length();i++){
			if(Character.isLetter(e.charAt(i))){
				throw new RuntimeException("You Can't evaluate letters");
			}
		}
		for(int i =0 ;i<expression.length()-1;i++) {
			while(e.charAt(i) != '+' &&e.charAt(i) != '/' &&e.charAt(i) != '-' &&e.charAt(i) != '*' ) {
				int j = 0;
				while(e.charAt(i) != ' ' ) {
					j++;
					i++;
				}
				if(j>0) {
					String k = e.substring(i-j, i);
					k = removespaces(k);
					float z = Integer.parseInt(k);
					opr.push(z);}
				i++;
			}
			if(e.charAt(i)== '+') {
				float x = (float)opr.pop();
				result = (float)opr.pop();
				result = result + x;
				opr.push(result);
			}
			else if(e.charAt(i)== '*') {
				float x = (float)opr.pop();
				result = (float)opr.pop();
				result = result * x;
				opr.push(result);
			}
			else if(e.charAt(i)== '-') {
				float x = (float)opr.pop();
				result = (float)opr.pop();
				result = result - x;
				opr.push(result);
			}
			else if(e.charAt(i)== '/') {
				float x = (float)opr.pop();
				result = (float)opr.pop();
				result = result / x;
				opr.push(result);
			}
			
		}
		return (int)result;

	}
	/**
	* it takes any string with spaces and remove its spaces.
	*
	* @param String
	* 
	* @return String without spaces
	*/
	public String removespaces(String inputString) {
        char[] charArray = inputString.toCharArray();
        
        String stringWithoutSpaces = "";
         
        for (int i = 0; i < charArray.length; i++) 
        {
            if ( (charArray[i] != ' ') && (charArray[i] != '\t') )
            {
                stringWithoutSpaces = stringWithoutSpaces + charArray[i];
            }
        }
        return stringWithoutSpaces;
	}

}

package eg.edu.alexu.csd.datastructure.linkedList;

import java.util.Scanner;

import javax.management.RuntimeErrorException;

public class PolynomialSolver implements IPolynomialSolver {
	LinkedList A= new LinkedList();
	LinkedList A1= new LinkedList();
	LinkedList B= new LinkedList();
	LinkedList B1= new LinkedList();
	LinkedList C= new LinkedList();
	LinkedList C1= new LinkedList();
	LinkedList R= new LinkedList();
	LinkedList R1= new LinkedList();
	Scanner input=new Scanner (System .in);

	
	public void setPolynomial(char poly, int[][] terms) {
		 poly=Character.toUpperCase(poly);
		int opt=1;  
		for(int j=0;j<terms.length;j++) {
			for(int u=0;u<terms[1].length;u++) {
				terms[j][u]=0;
			}
		}
		
		String k; int p=0;  int u=0; int i=0; int e=0;int i1=0; String k3;int inv=0; char c;
		System.out.println("Insert the polynomial terms in the form (coef1,exponent1),(coef2,exponent2) without any spaces or special characters");
		k=input.nextLine();
		
		k =removespaces(k);
        inv=0;
		for(int e1=0;e1<k.length();e1++) {
			c=k.charAt(e1);
			if((Character.isDigit(c)==false)&&(c!=')')&&(c!='(')&&(c!=','))
			{System.out.println("INVALID INPUT SCAN AGAIN");inv++; break;}
		}
		if(inv!=0) {System.out.println("Insert the polynomial terms in the form (coef1,exponent1),(coef2,exponent2)");
		k=input.next();}
		
		
		for(int t=0;t<k.length();t++) {
			if(k.charAt(t)=='(') {
				if (k.charAt(t+2)!=',') {p=t+1;
				  while(k.charAt(p)!=',') {p++; }
				k3=k.substring(t+1, p);
				terms[i][0]=Integer.parseInt(k3);
				}
				if(k.charAt(t+2)==',') {terms[i][0]=k.charAt(t+1)-'0';}i++;}
				
			if(k.charAt(t)==')') {
				if (k.charAt(t-2)!=',') {p=t-1;
			  while(k.charAt(p)!=',') {p--; }
			k3=k.substring(p+1, t);
			terms[i1][1]=Integer.parseInt(k3);
			}
			if(k.charAt(t-2)==',') {terms[i1][1]=k.charAt(t-1)-'0';}i1++;}
		}
		////////////////////////////////////////////////////////////
		if (poly=='A') {
			transferarraytoLK(terms,A,A1,i);
			removedubli(A,A1);
		}
		else if (poly=='B') {
			transferarraytoLK(terms,B,B1,i);
			removedubli(B,B1);
		}
		else if (poly=='C') {
			transferarraytoLK(terms,C,C1,i);
			removedubli(C,C1);
		}
		else {
			throw new RuntimeException("Enter the right choise");
		}
		
	    }
		
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
    public void removedubli(LinkedList choosen,LinkedList choosen1) {
    	for(int i=0;i<choosen1.size();i++) {
    		for(int j=i+1;j<choosen1.size();j++) {
    			if(choosen1.get(j)==choosen1.get(i)) {
    				choosen.set(i,(int)choosen.get(i)+(int)choosen.get(j));
    				choosen.remove(j);
    				choosen1.remove(j);}}}}	
	public void transferarraytoLK(int[][] terms,LinkedList choosen,LinkedList choosen1,int n)
	{
		if(choosen.isEmpty() ==false) {
			throw new RuntimeException("You've entered this poly before");
		}
		for(int j=0;j<n;j++) {
			choosen.add(terms[j][0]);
			choosen1.add(terms[j][1]);
		}
		for(int i =0;i<choosen.size();i++) {
			for(int i1 =0;i1<choosen.size();i1++) {
			if((int)choosen.get(i1)==0) {
				choosen.remove(i1);
				choosen1.remove(i1);
			}
		}}

	}
/////////////////parameters 
	//void
	public int[][] transfer2LKtoarray(LinkedList choosen,LinkedList choosen1) {
		
		int[][] terms = new int[choosen.size()][2];
		for(int i=0 ;i<choosen.size();i++) {
			terms[i][0]=(int)choosen.get(i);
			terms[i][1]=(int)choosen1.get(i);
		}
		return terms;
	}
	
////////////////////////////////
	
	@Override
	public String print(char poly) {
		if (poly=='A') {
			int[][] terms = transfer2LKtoarray(A,A1);
			terms = SortArray(terms);
			String s = WriteString(terms);
			return s;
		}
		else if (poly=='B') {
			int[][] terms = transfer2LKtoarray(B,B1);
			terms = SortArray(terms);
			String s = WriteString(terms);
			return s;
		}
		else if (poly=='C') {
			int[][] terms = transfer2LKtoarray(C,C1);
			terms = SortArray(terms);
			String s = WriteString(terms);
			return s;
		}
		else if (poly=='R') {
			int[][] terms = transfer2LKtoarray(R,R1);
			terms = SortArray(terms);
			String s = WriteString(terms);
			return s;
		}
		else {
			throw new RuntimeException("Enter the Right Choise from A,B,C and R");}
	}
//////////////////////////////sort Array 
	public int[][] SortArray(int[][] terms ){
		for(int i =0;i < terms.length; i++) {
			for(int j =0 ;j < terms.length-1;j++) {
				if(terms[j][1]<terms[j+1][1]) {
					int temp = terms[j][1];
					terms[j][1]= terms[j+1][1];
					terms[j+1][1]=temp;
					temp = terms[j][0];
					terms[j][0]= terms[j+1][0];
					terms[j+1][0]=temp;
				}
			}
		}
		return terms;
	}
//////////////////////////////////write string
	public String WriteString(int[][] terms) {
		StringBuilder s = new StringBuilder();
		for(int i=0 ;i< terms.length;i++) {
			String b0 = Integer.toString(terms[i][0]);
			String b1 = Integer.toString(terms[i][1]);
			if(terms[i][0]==0) {
				continue;}
			
			if(terms[i][0]==1 &&terms[i][1]==0) {
				s.append(b0);
			}
			if(terms[i][0]== -1 && terms[i][1]==0) {
				s.append(b0);
			}else if(terms[i][0]== -1 && terms[i][1] !=0) {
				s.append('-');
			}
			if( terms[i][0]!=1 &&terms[i][0]!=-1) {
				s.append(b0);}
			
			if(terms[i][1]>1 ||terms[i][1]<0) {
				if(i == terms.length-1 || terms[i+1][0]<0) {
					s.append("X").append("^(").append(b1).append(")");
				}else {
					s.append("X").append("^(").append(b1).append(")+");
				}
			}
			else if( terms[i][1]==1 ) {
				if(i == terms.length-1 || terms[i+1][0]<0) {
					s.append("X");
				}else {
					s.append("X").append("+");
				}
			}
			else if( terms[i][1]==0 ) {
				if(i != terms.length-1 && terms[i+1][0] >0) {
					s.append('+');
				}
			}
		}
		return s.toString();
	}
	
	@Override
	public void clearPolynomial(char poly) {
		 poly=Character.toUpperCase(poly);
		if(poly=='A') {
			A.clear();
			A1.clear();}
		else if(poly=='B') {
			B.clear();
			B1.clear();}
		else if(poly=='C') {
			C.clear();
			C1.clear();}
		else if(poly=='R') {
			R.clear();
			R1.clear();}
		else {
			throw new RuntimeException("Enter the Right Choise from A,B,C and R");}
	}
	
	@Override
	public float evaluatePolynomial(char poly, float value) {
		 poly=Character.toUpperCase(poly);
		float X;
		if (poly=='A') {
			int[][] terms = transfer2LKtoarray(A,A1);
			X = evaluate(terms,value);
		}
		else if (poly=='B') {
			int[][] terms = transfer2LKtoarray(B,B1);
			terms = SortArray(terms);
			X = evaluate(terms,value);
		}
		else if (poly=='C') {
			int[][] terms = transfer2LKtoarray(C,C1);
			terms = SortArray(terms);
			X = evaluate(terms,value);
		}
		else if (poly=='R') {
			int[][] terms = transfer2LKtoarray(R,R1);
			terms = SortArray(terms);
			X = evaluate(terms,value);
		}
		else {
			throw new RuntimeException("Enter the Right Choise from A,B,C and R");}
		return X;
	}
	
	public float evaluate(int[][] terms,float value) {
		float X=0;
		for(int i =0 ;i< terms.length;i++) {
			X += terms[i][0]*Math.pow(value,terms[i][1]);
		}
		return X;
	}

	@Override
	public int[][] add(char poly1, char poly2) {
		if(R.isEmpty()==false) {
			R.clear();
			R1.clear();}
		 poly1=Character.toUpperCase(poly1);
		 poly2=Character.toUpperCase(poly2);

		if((poly1 == 'A' && poly2=='B')|| (poly2 == 'A' && poly1=='B')) {
			if(A.isEmpty() || B.isEmpty()) {
				throw new NullPointerException("Not Set");
			}else {
			int[][] sum = addsubtract(A,A1,B,B1,'+');
			return sum;}
		}
		else if((poly1 == 'B' && poly2=='C')|| (poly2 == 'B' && poly1=='C')) {
			if(C.isEmpty() || B.isEmpty()) {
				throw new NullPointerException("Not Set");
			}else {
			int[][] sum = addsubtract(C,C1,B,B1,'+');
			return sum;}
		}
		else if((poly1 == 'A' && poly2=='C')|| (poly2 == 'A' && poly1=='C')) {
			if(C.isEmpty() || B.isEmpty()) {
				throw new NullPointerException("Not Set");
			}else {
			int[][] sum = addsubtract(A,A1,C,C1,'+');
			return sum;}
		}else {
			throw new RuntimeException("Enter the Right Choise from A,B and C");}
	}

	@Override
	public int[][] subtract(char poly1, char poly2) {
		if(R.isEmpty()==false) {
			R.clear();
			R1.clear();}
		 poly1=Character.toUpperCase(poly1);
		 poly2=Character.toUpperCase(poly2);
		if((poly1 == 'A' && poly2=='B')) {
			if(A.isEmpty() || B.isEmpty()) {
				throw new NullPointerException("Not Set");
			}else {
			int[][] diff = addsubtract(A,A1,B,B1,'-');
			return diff;}
		}
		else if(poly1 == 'B' && poly2=='A') {
			if(A.isEmpty() || B.isEmpty()) {
				throw new NullPointerException("Not Set");
			}else {
			int[][] diff = addsubtract(B,B1,A,A1,'-');
			return diff;}
		}
		else if(poly1 == 'A' && poly2=='C') {
			if(A.isEmpty() || C.isEmpty()) {
				throw new NullPointerException("Not Set");
			}else {
			int[][] diff = addsubtract(A,A1,C,C1,'-');
			return diff;}
		}
		else if(poly1 == 'C' && poly2=='A') {
			if(A.isEmpty() || C.isEmpty()) {
				throw new NullPointerException("Not Set");
			}else {
			int[][] diff = addsubtract(C,C1,A,A1,'-');
			return diff;}
		}
		else if(poly1 == 'C' && poly2=='B') {
			if(C.isEmpty() || B.isEmpty()) {
				throw new NullPointerException("Not Set");
			}else {
			int[][] diff = addsubtract(C,C1,B,B1,'-');
			return diff;}
		}
		else if(poly1 == 'B' && poly2=='C') {
			if(C.isEmpty() || B.isEmpty()) {
				throw new NullPointerException("Not Set");
			}else {
			int[][] diff = addsubtract(B,B1,C,C1,'-');
			return diff;}
		}else {
			throw new RuntimeException("Enter the Right Choise from A,B and C");}
	}
	
	public int[][] addsubtract(LinkedList a ,LinkedList a1, LinkedList b ,LinkedList b1, char oprt){

		int o;
		int z=0,i=0,j=0,exist=0;
		for( i =0 ;i<a.size();i++) {
			for( j=0;j<b.size();j++) {
				if(b1.get(j)==a1.get(i)) {
					R1.add(b1.get(j));
					if(oprt =='+') {
						o= (int)b.get(j) + (int)a.get(i);
					}
					else {
						o= (int)a.get(j) - (int)b.get(i);
					}
					R.add(o);
					z++;
				}
			}
			if(z==0) {
				R1.add(a1.get(i));
				R.add(a.get(i));
			}
			z=0;
		}
		int n= R.size();
		for(i =0;i<b.size();i++) {
			for(j=0;j<n;j++) {
				if(b1.get(i)==R1.get(j)) {
					exist++;
				}
			}
			if(exist==0) {
				R1.add(b1.get(i));
				if(oprt=='+') {
				R.add(b.get(i));}
				else { R.add((-1)*(int)b.get(i));}
			}
			exist =0;
		}
		for(int i1 =0;i1<R.size();i1++) {
			for(int i2 =0;i2 <R.size();i2++) {
			if( (int)R.get(i2) == 0 ) {
				R.remove(i2);
				R1.remove(i2);
			}}
		}
		removedubli(R,R1);
		int[][] terms = transfer2LKtoarray( R, R1 );
		return terms;
	}
	public int[][] multip(LinkedList a ,LinkedList a1, LinkedList b ,LinkedList b1){

		for(int i =0 ;i < a.size();i++) {
			for(int j =0 ;j<b.size();j++) {
				R.add( (int)a.get(i) * (int)b.get(j) );
				R1.add((int)a1.get(i) + (int)b1.get(j));
			}
		}
		for(int i1 =0;i1<R.size();i1++) {
			for(int i2 =0;i2 <R.size();i2++) {
			if( (int)R.get(i2) == 0 ) {
				R.remove(i2);
				R1.remove(i2);
			}}
		}
		removedubli(R,R1);
		int[][] terms = transfer2LKtoarray( R, R1 );
		return terms;
	}
	
	@Override
	public int[][] multiply(char poly1, char poly2) {
		if(R.isEmpty()==false) {
			R.clear();
			R1.clear();}
		 poly1=Character.toUpperCase(poly1);
		 poly2=Character.toUpperCase(poly2);
		if((poly1 == 'A' && poly2=='B')|| (poly2 == 'A' && poly1=='B')) {
			if(A.isEmpty() || B.isEmpty()) {
				throw new NullPointerException("Not Set");
			}else {
			int[][] multip = multip(A,A1,B,B1);
			return multip;}
		}
		else if((poly1 == 'B' && poly2=='C')|| (poly2 == 'B' && poly1=='C')) {
			if(C.isEmpty() || B.isEmpty()) {
				throw new NullPointerException("Not Set");
			}else {
				int[][] multip = multip(C,C1,B,B1);
				return multip;}
		}
		else if((poly1 == 'A' && poly2=='C')|| (poly2 == 'A' && poly1=='C')) {
			if(C.isEmpty() || B.isEmpty()) {
				throw new NullPointerException("Not Set");
			}else {
				int[][] multip = multip(A,A1,C,C1);
				return multip;}
		}else {
			throw new RuntimeException("Enter the Right Choise from A,B and C");}
	}

}
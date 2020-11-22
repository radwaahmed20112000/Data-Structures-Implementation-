package eg.edu.alexu.csd.datastructure.linkedList;

import java.util.Scanner;

public class main {

		public static void main(String[] args) {
			int terms[][]=new int[2][100];
			polyfarida t=new polyfarida();
			Scanner input=new Scanner (System .in);
			 int opt;
			 do {

				 System.out.println("1-set polynomial");
				 System.out.println("2-print polynomial");
				 System.out.println("3-clear polynomial");
				 System.out.println("4- evaluate polynomial at some point ");
				 System.out.println("5-add two polynomials");
				 System.out.println("6-subtract two polynomials");
				 System.out.println("7-multiply two polynomials");
				 System.out.println("8-Exit");
				 opt=input.nextInt();
				 if(opt==1) {
					 System.out.println("enter the poly A..B...C");
					char poly =input.next().charAt(0);
					t.setPolynomial(poly, terms);
				 }
			    if(opt==2) {
			    	 System.out.println("enter the poly A..B..C..R");
			 		char poly =input.next().charAt(0);
			 		String s=t.print(poly);
			 		System.out.println(s);
				 }
			    if(opt==3) { 
			    	System.out.println("enter the poly A..B...C");
				     char poly =input.next().charAt(0);
				     t.clearPolynomial(poly);
					 
				 }
			    if(opt==4) { 
			    	System.out.println("enter the poly A..B...C");
				    char poly =input.next().charAt(0);
				    System.out.println("enter value");
					float value =input.nextFloat();
					System.out.println(t.evaluate(terms, value));
					
				 }
			    if(opt==5) {
			    	 System.out.println("enter the poly A..B...C");
			 		char poly1 =input.next().charAt(0);
			 		System.out.println("enter the poly A..B...C");
			 		char poly2 =input.next().charAt(0);
			 		int result[][]=t.add(poly1, poly2);
				 }
			    if(opt==6) { 
			    	System.out.println("enter the poly A..B...C");
			 		char poly1 =input.next().charAt(0);
			 		System.out.println("enter the poly A..B...C");
			 		char poly2 =input.next().charAt(0);
			 		int result[][]=t.subtract(poly1, poly2);
				 }
			    if(opt==7) { 
			    	System.out.println("enter the poly A..B...C");
				    char poly1 =input.next().charAt(0);
				    System.out.println("enter the poly A..B...C");
				    char poly2 =input.next().charAt(0);
				    t.multiply(poly1, poly2);
				 }
			 }while(opt!=8);    //(1,2),(-1,0)         (1,1),(-1,0)

		}}




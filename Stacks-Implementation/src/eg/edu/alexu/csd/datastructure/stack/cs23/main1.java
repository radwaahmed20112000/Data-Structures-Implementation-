package eg.edu.alexu.csd.datastructure.stack.cs23;

import java.util.Scanner;

public class main1 {

	public static void main(String[] args) {
		Stack St = new Stack();
		Scanner input=new Scanner (System .in);
		 String opt;
		 do {

			 System.out.println("1: Push");
			 System.out.println("2: Pop");
			 System.out.println("3: Peek");
			 System.out.println("4: Get size ");
			 System.out.println("5: Check if empty");
			 System.out.println("6: Exit");
			 opt=input.next();
			 while(!(Character.isDigit(opt.charAt(0))) ){
				 System.out.println("You've Entered a wrong Number , Try again !");
				 opt=input.next();
			 }
			 if(opt.charAt(0)=='1') {
				 System.out.println("Enter the element you want to push :");
				 String x =input.next();
				 St.push(x);
			 }
		    if(opt.charAt(0)=='2') {
		    	if(St.isEmpty()==true) {
		    		 System.out.println("You can't pop elements because the stack is Empty");
		    	}else {
		    		System.out.println("The Element you poped :" + St.pop());
		    	}
			 }
		    if(opt.charAt(0)=='3') { 
		    	if(St.isEmpty()==true) {
		    		 System.out.println("You can't peek elements because the stack is Empty");
		    	}else {
		    		System.out.println("The Element you peeked :" + St.pop());
		    	}			 }
		    if(opt.charAt(0)=='4') { 
				 System.out.println("Size of stack =" + St.size());
			 }
		    if(opt.charAt(0)=='5') {
		    	if(St.isEmpty()) {
		    		System.out.println("Stack is Empty");
		    	}else {
		    		System.out.println("Stack is not Empty");
		    	}
			 }

		 }while(opt.charAt(0)!='6');
	}
	

}

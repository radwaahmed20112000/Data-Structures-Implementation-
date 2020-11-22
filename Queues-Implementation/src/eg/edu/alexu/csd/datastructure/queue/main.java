package eg.edu.alexu.csd.datastructure.queue;

import java.util.Scanner;

public class main {

	public static void main(String[] args) {
		
		LQueue A = new LQueue();
		Scanner input=new Scanner (System .in);
		 String opt;
		 do {

			 System.out.println("1: EnQueue");
			 System.out.println("2: DeQueue");
			 System.out.println("3: Get size ");
			 System.out.println("4: Check if empty");
			 System.out.println("5: Exit");
			 opt=input.next();
			 while(!(Character.isDigit(opt.charAt(0))) ){
				 System.out.println("You've Entered a wrong Number , Try again !");
				 opt=input.next();
			 }
			 if(opt.charAt(0)=='1') {
				 System.out.println("Enter the element you want to enqueue :");
				 String x =input.next();
				 A.enqueue(x);
			 }
		    if(opt.charAt(0)=='2') {
		    	if(A.isEmpty()==true) {
		    		 System.out.println("You can't dequeue elements because the Queue is Empty");
		    	}else {
		    		System.out.println("The Element you dequeued :" + A.dequeue());
		    	}
			 }
		    if(opt.charAt(0)=='3') { 
				 System.out.println("Size of Queue =" + A.size());
		    }
		    if(opt.charAt(0)=='4') { 
		    	if(A.isEmpty()) {
		    		System.out.println("Queue is Empty");
		    	}else {
		    		System.out.println("Queue is not Empty");
		    	}
			 }

		 }while(opt.charAt(0)!='5');
	}
	

}

/*

 game where a user is given 1 - 6 digits and a final number 
	user is to figure out which set of operations will equate to the final number
	easy mode is 2 nums all the way up to 6:

	int num1
	int num2
	
	bit shift...
		
	thinking of assigning up to N int's for
	

	*num1* -operation- *num2* -operation- *num3* so forth 

	what if we scan for * / first, then perform operation?
	
	
	
*/
import java.util.Random;
public class game {
	public static void main(String arg[]) {
		System.out.println("hello");
		Random rand = new Random();
		int num = rand.nextInt(10);	
		for (int i = 0; i < 9; i++) {
			System.out.println(i + " Random Number = " + num);
			num = rand.nextInt(10)+1;
		}	
		/*
			random operator generator
			wait can you return an operator????
				-checked stack, operator is neither value nor variable :c
			
		*/	
		//System.out.println("num is " + num);
		num = rand.nextInt(4);
		for (int i = 0; i < 5; i++) {
			System.out.println("operator random = " + num);
			num = rand.nextInt(4);
			// if (num = last rand num) reiterate:
		}
		System.out.println("calling operatorRando " + operatorRandom(0,0)); 	
	}
	static int operatorRandom(int a, int b) {
		System.out.println("we in dis");
		Random rand = new Random();
		int num = rand.nextInt(4); 
		switch(num) {
			case 0:
			System.out.println("case 0");
			break;
			
			case 1:
			System.out.println("case 1");
			break;

			case 2:
			System.out.println("case 2");
			break;

			case 3: 
			System.out.println("case 3");
			break;

			default:
			System.out.println("u fukd up");
			break;
		}

		return 0;
	}
	
}

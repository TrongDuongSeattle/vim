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
import java.util.*;
public class game {
	public static void main(String arg[]) {
		System.out.print("Input length:");
		Scanner sc = new Scanner(System.in);
		int length = sc.nextInt();
		
		List<Integer> list = new ArrayList<Integer>(); //used this so it'd print prettier
		
		 
		
		Random rand = new Random(); 
		for (int i = 0; i < length; i++) {
			list.add(rand.nextInt(10) %  (int)  System.currentTimeMillis());
			//System.out.println(list.get(i));
		}
		//System.out.println("Array of numbers: " + list);
		System.out.println(list);		
		int num = rand.nextInt(10);	
		int num2 = rand.nextInt(10);
		for (int i = 0; i < 5; i++) {
			// if (num = last rand num) reiterate:
			System.out.println("Num 1 is: " + num + " num2: " + num2);
                        System.out.println("calling operatorRando(" +  num + ", " + num2 + ")" + operatorRandom(num,num2));
			System.out.println();
			num = (rand.nextInt(10) %  (int)  System.currentTimeMillis());
			num = (rand.nextInt(10) %  (int)  System.currentTimeMillis());
		}			
	}
	static int operatorRandom(int a, int b) {
		Random rand = new Random();
		int num = rand.nextInt(4); 
		switch(num) {
			case 0:
			System.out.println("case 0,Sum");
			return a + b;
			
			case 1:
			System.out.println("case 1, Subtraction");
			return a - b;

			case 2:
			System.out.println("case 3, multiply");
			return a * b;

			case 3: 
			System.out.println("case 3, divide");
			if (b == 0) {
				System.out.println("0 Denominator");
				break;
			}
			return a / b; 

			default:
			System.out.println("u fukd up");
			break;
		}

		return 0;
	}
	
}

/*
	
	
*/
import java.util.*;
public class game {
	public static void main(String arg[]) {
		System.out.print("Input length:");
		Scanner sc = new Scanner(System.in);
		int length = sc.nextInt();
		
		//List<Integer> list = new ArrayList<Integer>(); //used this so it'd print prettier
		
		List<Integer> list = new LinkedList<Integer>(); //used this so it'd print prettier
		 
		
		Random rand = new Random(); 
		for (int i = 0; i < length; i++) {
			list.add(rand.nextInt(10) %  (int)  System.currentTimeMillis());
			//System.out.println(list.get(i));
		}
		//System.out.println("Array of numbers: " + list);
		System.out.println(list);		
		int num = rand.nextInt(10);	
		int num2 = rand.nextInt(10);
		/*
		for (int i = 0; i < list.size() - 1; i++) {
			// if (num = last rand num) reiterate:
			num = list.get(i); 
			num2 = list.get(i+2); 
			System.out.println("Num 1 is: " + num + " num2: " + num2);
                        System.out.println("calling operatorRando(" +  num + ", " + num2 + ")" + operatorRandom(num,num2));
			System.out.println();
		}*/

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

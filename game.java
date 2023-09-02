/*
09/01/23:
Algorithm works now, uses recursion ;)) in the event a number doesn't divide evenly
we now  have at least one valid equation for the number. 

What's the premise?
randomize order of numbers?

How to verify user answer? build a friggin calculator?
take user input as an array or a way to keep order, switch - case: and update goal?
	then if their goal matches this.goal ... that seems rather long but it would cover the case where user finds a different way to get this.goal 

is there a point to remembering order of ops for verification algo?
	-could just direct match chars this way
	if (userinput == 'some char')


*/
import java.util.*;
public class game {
	public static void main(String arg[]) {
		System.out.print("Input length: ");
		Scanner sc = new Scanner(System.in);
		int length = sc.nextInt();
		
		List<Integer> list = new ArrayList<Integer>(); //used this so it'd print prettier
		 
		
		Random rand = new Random(); 
		for (int i = 0; i < length; i++) {
			list.add((rand.nextInt(8 + 1)) %  (int)  System.currentTimeMillis());
		}
		System.out.println(list);		
		int num = list.get(0); 
		int goal = list.get(0);

		
		for (int i = 1; i < list.size(); i++) {
			goal = operatorRandom(goal, list.get(i));
		}
		System.out.println("Final value: " + goal);

	}
	static int operatorRandom(int a, int b) {
		Random rand = new Random();
		int num = rand.nextInt(4); 
		switch(num) {
			case 0:
			return a + b;
			
			case 1:
			return a - b;

			case 2:
			return a * b;

			case 3: 
			 if (a / b == 0 || a % b != 0 || b == 0) {
				System.out.println();
				System.out.println("Recursive case because you're a badass");
				return operatorRandom(a, b); //yeaaaaa im a fukn badass
			}
			return a / b; 

			default:
			System.out.println("u fukd up");
			break;
		}

		return 0;
	}
	
}

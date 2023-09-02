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


later on 09/01....
I'm gonna stick with the way generated is the only way to form the answer
since we don't know how to make a GUI really yet, let's just do it old school and just have user enter it in one by one:
	okay, maybe we'll figure out a way to evaluate 
	
for now, not randomizing numbers
*/
import java.util.*;
public class game {
	public static void main(String arg[]) {
		System.out.print("Input length: ");
		Scanner sc = new Scanner(System.in);
		int length = sc.nextInt();
		int operationListLength = length - 1;
		
		List<Integer> list = new ArrayList<Integer>(); //used this so it'd print prettier
		 
		
		Random rand = new Random(); 
		for (int i = 0; i < length; i++) {
			list.add((rand.nextInt(8) + 1) %  (int)  System.currentTimeMillis());
		}
		System.out.println(list);		
		int goal = list.get(0);

		List<Character> keyList = new ArrayList<Character>();
		for (int i = 1; i < list.size(); i++) {
			goal = operatorRandomTest(goal, list.get(i),keyList); //to see answer 
		
		}
		System.out.println("Answer Key: " + keyList);	
		System.out.println("Final value: " + goal);
		System.out.println();	
		System.out.println("Enter the operations in order from left to right");

		List<Character> charList = new ArrayList<Character>();
		//account for wrong input
		for (int i = 0; i < operationListLength; i++) { //1 less operation than numbers
			System.out.print("Enter operation " + (i + 1) + "/" + operationListLength +": ");	
			charList.add(sc.next().charAt(0));
		}
		System.out.println();	
		System.out.println("charList: " + charList);	
		boolean winLoss = listComparator(keyList, charList);
		if(winLoss){
			System.out.println("w");
		}
		

	}
	/*
	gives answer 
	*/
	static boolean listComparator(List<Character> keyList, List<Character> charList) {
		for (int i = 0; i < keyList.size(); i++) {
			if (keyList.get(i) != charList.get(i)) {
				System.out.println("Incorrect Guess");
				return false;
			}
		}
		return true;
	}
		
	static int operatorRandomTest(int a, int b, List<Character> charList) {
		Random rand = new Random();
		int num = rand.nextInt(4); 
		switch(num) {
			case 0:
			System.out.println("+");
			charList.add('+');
			return a + b;
			
			case 1:
			System.out.println("-");
			charList.add('-');
			return a - b;

			case 2:
			System.out.println("*");
			charList.add('*');
			return a * b;

			case 3: 
			System.out.println("/");
			 if (a / b == 0 || a % b != 0 || b == 0) {
				System.out.println();
				System.out.println("Recursive case because you're a badass");
				return operatorRandom(a, b); //yeaaaaa im a fukn badass
			}
			charList.add('/');
			return a / b; 

			default:
			System.out.println("u fukd up");
			break;
		}
		return 0;
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

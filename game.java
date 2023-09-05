/*
09/04/23
digits does not allow for division of non divisible numbers it 2/5 
always gives 6 numbers
does not allow negatives, in other words wrong input not allowed
evaluates user input and then matches to goal
	order of operations can change
	edit operatorRandom to evaluate use input as well

there is an undo button
allows you to randomly select ints and ops 
	have verified way
		just allow user to randomly select pairs 


*/
import java.util.*;
public class game {
	public static void main(String arg[]) {
		Scanner sc = new Scanner(System.in);
		int length = 6;
		int operationListLength = length - 1;
		
		List<Integer> list = new ArrayList<Integer>(); //used this so it'd print prettier
		 
		
		Random rand = new Random(); 
		for (int i = 0; i < length; i++) {
			list.add((rand.nextInt(8) + 1) %  (int)  System.currentTimeMillis());
		}
		System.out.println(list);		
		int goal = list.get(0);

		int operator = rand.nextInt(4) %  (int)  System.currentTimeMillis();
		List<Character> keyList = new ArrayList<Character>();
		for (int i = 1; i < list.size(); i++) {
			goal = operatorRandomTest(goal, list.get(i),keyList, operator); //to see answer 
			operator = rand.nextInt(4) %  (int)  System.currentTimeMillis();		
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
	static void getUserInput(Scanner sc, ArrayList list) {
		/*
		user can choose number and then operation;
		oh but the recursive case won't work for evaluation...(set a flag xD how complicated could it get?)

		*/
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
		
	static int operatorRandomTest(int a, int b, List<Character> charList, int operator) {
		Random rand = new Random(); // this could definitely be better;
		switch(operator) {
			case 0:
			System.out.println("+");
			charList.add('+');
			return a + b;
			
			case 1:
			System.out.println("-");
			if (a - b < 0) {
				operator = rand.nextInt(4) %  (int)  System.currentTimeMillis();		 
				return operatorRandomTest(a, b, charList, operator);
			}
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
				operator = rand.nextInt(3) % (int) System.currentTimeMillis(); 
				return operatorRandomTest(a, b, charList,operator); //yeaaaaa im a fukn badass
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

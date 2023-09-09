/*	
09/04/23
digits does not allow for division of non divisible numbers it 2/5 
always gives 6 numbers
does not allow negatives, in other words wrong input not allowed
evaluates user input and then matches to goal
	order of operations can change
	edit operatorRandom to evaluate use input as well
provides a longest and shortest solution
	we have a longest,
	maybe use recursive backtracking to then go through all the operations with the other numbers to find a match?
		remember the idea of saving a tree so that you don't have to go through it later? dynamic programming?
	 
there is an undo button
user can select numbers and operations, prints out result 
	have verified way
	 

operatorRandom cannot be used to evaluate and generaete
	could override it or something but maybe make 2 to keep it simple
*/
import java.sql.SQLOutput;
import java.util.*;
public class game {
	public static void main(String arg[]) {
		Scanner sc = new Scanner(System.in);
		int length = 6;
		int operationListLength = length - 1;
		List<Integer> list = new LinkedList<Integer>(); //used this so it'd print prettier
		Random rand = new Random(); 
		for (int i = 0; i < length; i++) {
			list.add((rand.nextInt(8) + 1) %  (int)  System.currentTimeMillis());
		}
		System.out.println(list);		



		int goal = list.get(0);
		int operator = rand.nextInt(4) %  (int)  System.currentTimeMillis();
		List<Character> keyList = new LinkedList<Character>();
		for (int i = 1; i < list.size(); i++) {
			goal = operatorRandomTest(goal, list.get(i),keyList, operator); //to see answer 
			operator = rand.nextInt(4) %  (int)  System.currentTimeMillis();		
		}
		System.out.println("Answer Key: " + keyList);	
		System.out.println("Final value: " + goal);


		System.out.println();	

		getUserInput(sc, list, goal);

		}
		

	static void getUserInput(Scanner sc, List<Integer> list, int goal){
		/*			
		by using 2 stacks, the order is not preserved
		by saving state, only the last order is preserved
		technically there is a gui so no wrong input can be provided...i think...
		If I create another linked list and set that = to original passed list...wha

		do{} while input != r?
		*/
		int num1;
		int num2; 
		char ch;
		int result;
		LinkedList<Integer> undoList= new LinkedList<Integer>();
		LinkedList<Integer> listCopy = new LinkedList<Integer>();

		listCopy.addAll(list);
		System.out.println("Enter the operations in order from left to right");
		for (int i = 0; i < 5; i++) { //1 less operation than numbers
			    System.out.println(goal);
				System.out.println("Operation " + (i + 1) + "/5");
				System.out.println(listCopy);	
				System.out.print("Select number: ");
				if (i > 0) {
					System.out.print("\n" + "Select 'R' to undo last operation: ");
				}
			if (sc.hasNextInt()) {
				num1 = sc.nextInt();
				undoList.add(num1);
				listCopy.remove((Integer) num1);

				System.out.print("Select operation: ");
				ch = sc.next().charAt(0);	
				System.out.print("Select number: ");
				num2 = sc.nextInt();
				undoList.add(num2);
				listCopy.remove((Integer) num2);

				result = inputEvaluator(num1, num2, ch);
				if (result == goal) { 
					System.out.println("Nice.");
					return;
				}
			//this is supposed to be a button
			} else if (sc.next().toLowerCase().charAt(0) == 'r') {
				System.out.println("You're on the right track");
				System.out.println(undoList);
				num1 = undoList.pop();
				num2 = undoList.pop();
				System.out.println(undoList);
				listCopy.add(list.indexOf(num1),num1);
				listCopy.add(list.indexOf(num2),num2);//adding a value whose index is beyond the current size is bad throws error
				//System.out.println(listCopy);
				i -= 2;

			}
			System.out.println();
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
	/*
		evaluates user input, 	
		prints out result

	*/		
	static int inputEvaluator(int a, int b, char ch) {	
		switch(ch) {
			case '+':
			System.out.println(a + " + " + b + " = " + (a + b));
			return a + b;
			
			case '-':
			System.out.println(a + " - " + b +  " = " + (a - b));
			if (a - b < 0) {
			//maybe just take care of it in calling function?
			//do nothing	
			//don't allow, redo
				return -1;
			}
			return a - b;

			case '*':
			System.out.println(a + " * " + b + " = " +  a * b);
			return a * b;

			case '/': 
			System.out.println(a + " / " + b + " = " +  a / b);
			 if (a / b == 0 || a % b != 0 || b == 0) {
				 return -1;
			}
			return a / b; 

			default:
			System.out.println("u fukd up");
			break;
		}
		return 0;
	}
	//provides longest and shortest answer 	
	/* 
		what if we randomly generate a number 
	*/
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

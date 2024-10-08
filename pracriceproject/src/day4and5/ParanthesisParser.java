package day4and5;

import java.util.Scanner;
import java.util.Stack;

public class ParanthesisParser {
	
	private static String expression;
	private static Scanner scanner;
	
	static {
		scanner = new Scanner(System.in);
	}

	{
		expression = "((()()))";
	}
	
	public static boolean areParanthesisBalanced() {
		Stack <Character> stack = new Stack<>();
		for(char ch : expression.toCharArray()) {
			if(ch == '(')
				stack.push(ch);
			else if (ch == ')') {
				if(stack.isEmpty()) // unmatched closing parenthesis
					return false;
				stack.pop(); // remove the matching opening parenthesis
			}
		}
		return stack.isEmpty();
	}
	
	public static int countPairOfParanthesis() {
		int count = 0;
		Stack <Character> stack = new Stack<>();
		for(int i = 0; i < expression.length(); i++) {
			char ch = expression.charAt(i);
			if(ch == '(')
				stack.push(ch);
			else if (ch == ')') {
				if(stack.isEmpty()) // unmatched closing parenthesis
					return -1;
				stack.pop(); // remove the matching opening parenthesis
				count++;
			}
		}
		if(stack.isEmpty())
			return count;
		else
			return -1;
	}
	
	public static void main(String[] args) {
		System.out.print("Enter the expression of paranthesis: ");
		expression = scanner.next();
		int numberOfPairs = countPairOfParanthesis();
		//boolean balanced = areParanthesisBalanced();
		if(numberOfPairs == -1)
			System.out.println("Paranthesis are not balanced");
		else
			System.out.println("Number of pairs of Paranthesis is " + numberOfPairs);
	}
}

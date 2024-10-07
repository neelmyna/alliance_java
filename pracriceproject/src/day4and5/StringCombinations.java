package day4and5;

import java.util.LinkedList;
import java.util.Queue;

public class StringCombinations {

	public static void generateCombinations(String userString) {
		Queue <String> queue = new LinkedList<>();
		queue.add(""); // Start with an empty string
		for(char ch : userString.toCharArray()) {
			int currentQueueSize = queue.size();
			
			// Access each char from the current size of the queue
			for(int i = 0; i < currentQueueSize; i++) {
				String currentCombination = queue.poll(); // Generate the combination of strings
				queue.add(currentCombination);
				queue.add(currentCombination + ch); // include the current combination with the new character
			}  // End of inner for loop
		}  // End of outer for loop
		while(!queue.isEmpty()) {
			String combination = queue.poll();
			System.out.println(combination);
		}
	}
	
	public static void main(String[] args) {
		String userStr = "abcd";
		System.out.println("Copmbinations of the string " + userStr + " are:");
		generateCombinations(userStr);
	}
}

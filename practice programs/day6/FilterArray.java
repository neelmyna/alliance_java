package day6;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class FilterArray {
public static void main(String[] args) {
		
		List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 12, 15, 18, 20, 21);
		List<Integer> evenNumbers = numbers.stream().filter(num -> num % 2 == 0).collect(Collectors.toList());
		System.out.println("All numbers:\n" + numbers);
		System.out.println("\nEven numbers:\n" + evenNumbers);
	}
}

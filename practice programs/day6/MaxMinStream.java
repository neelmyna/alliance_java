package day6;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;

public class MaxMinStream {

	// count the number of even numbers
	public static void myFunction1(List<Integer> numbers) {
		long count = numbers.stream().filter(num -> num % 2 == 0).count();
		System.out.println("Number of Even numbers is " + count);
	}
	
	// find sum of numbers
	public static void myFunction2(List<Integer> numbers) {
		int sum = numbers.stream().reduce(0, Integer::sum);
		System.out.println("Sum of all Numbers is " + sum);
	}
	
	// find distinct of numbers
	public static void myFunction3(List<Integer> numbers) {
		numbers.stream().distinct().forEach(System.out::println);
	}
	
	// find distinct of numbers
	public static void myFunction4() {
		List<List<String>> listOfLists = Arrays.asList(
			Arrays.asList("carrot", "olive", "beans"),
			Arrays.asList("cashews", "raisins", "badam", "pista"),
			Arrays.asList("strawberry", "russberry", "avacardo")
		);
		listOfLists.stream()
		.flatMap(List::stream)
		.forEach(System.out::println);
	}
	
	public static void main(String[] args) {
		List<Integer> numbers = Arrays.asList(23, 11, 7, 5, 11, 2, 3, 5, 7, 7, 2, 2, 2, 19, 17);
		Optional <Integer> max = numbers.stream().max(Comparator.naturalOrder());
		max.ifPresent(System.out::println);

		Optional <Integer> min = numbers.stream().min(Comparator.naturalOrder());
		min.ifPresent(System.out::println);
		
		myFunction1(numbers);
		myFunction2(numbers);
		myFunction3(numbers);
		myFunction4();
	}
}

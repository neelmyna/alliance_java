package java_concepts;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class LinkedList {
	
	public  static void main(String args[]) {
		List<Integer> myList = new ArrayList<>();
		myList.add(10);
		myList.add(45);
		myList.add(30);
		List<Integer> evenNumbers = myList.stream()
				.filter(i -> i % 2 == 0)
				.collect(Collectors.toUnmodifiableList());
		System.out.println(evenNumbers);
		evenNumbers.add(20);
	}
}

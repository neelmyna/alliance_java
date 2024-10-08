package day6;

import java.util.Arrays;
import java.util.List;

public class MethodReference {

	public static void main(String[] args) {
		List<String> sweets = Arrays.asList("jamoon", "jilebi", "rassgulla", "rabdi");
		sweets.forEach(System.out::println);
	}
}

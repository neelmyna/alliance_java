package day6;

import java.util.Arrays;
import java.util.List;

public class StreamMapExample {

	public static void main(String[] args) {
		List<String> fruits = Arrays.asList("jack", "apple", "grapes", "chiku");
		fruits.stream().map(String::toUpperCase).forEach(System.out::println);
	}

}

package day6;

import java.util.Arrays;
import java.util.List;

public class Stream1 {
// create a stream from a list
	public static void main(String[] args) {
		List<String> mountainPasses = Arrays.asList("sach-pass", "nathula-pass", "sela-pass", "rohtang-pass", "zojila-pass");
		mountainPasses.stream().forEach(System.out::println);
	}
}

package java_concepts;

import java.util.*;

public class Lambda1 {

	public static void main(String[] args) {
		List<String> places = Arrays.asList("hosur", "attibele", "anekal");
		
		places.forEach(place -> System.out.println(place));
	}
}
package java_concepts;

import java.util.Arrays;
import java.util.List;

@FunctionalInterface
interface PrintPlaces {
	void printPlace(String place);
}

public class Lambda2 {
	
	public static void myFunction1() {
		PrintPlaces print = (place) -> System.out.println("We are in: " + place);
		print.printPlace("Anekal");
	}
	
	public static void myFunction2() {
		List<String> places = Arrays.asList("hosur", "attibele", "anekal");
		
		PrintPlaces print = (place) -> System.out.println("We are in: " + place);
		places.forEach( place -> print.printPlace(place));
		
		//places.forEach( place -> System.out.println(place));
		//print.printPlace("Anekal");
	}
	
	public static void main(String[] args) {
		myFunction1();
		myFunction2();
	}
}

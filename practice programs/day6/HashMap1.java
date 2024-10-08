package day6;

import java.util.HashMap;

public class HashMap1 {

	public static void main(String[] args) {
		HashMap <Integer, String> places = new HashMap<>();

		// Add entries
		places.put(570001, "mysuru");
		places.put(110001, "delhi");
		places.put(560001, "bengaluru");
		places.put(400001, "mumbai");
		
		// retrieve the values
		System.out.println("Pin 570001 referes to " + places.get(570001));
		
		// Print the hash map
		for(Integer key : places.keySet()) {
			System.out.println(key + ": " + places.get(key));
		}
	}

}

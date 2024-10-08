package day6;

import java.net.MulticastSocket;
import java.util.HashMap;
import java.util.Map;

public class HashMap2 {

	public static void main(String[] args) {
		HashMap <String, Integer> places = new HashMap<>();

		// Add entries
		places.put("mysuru", 2100000);
		places.put("delhi", 15500000);
		places.put("bengaluru", 13000000);
		places.put("mumbai", 14900000);
		
		String keyPlace = "mumbai";
		if(places.containsKey(keyPlace)) {
			System.out.println(keyPlace + " is present in Map");
		}
		else 
			System.out.println(keyPlace + " is not present in the Map");
		
		System.out.println("The Places & Population are: \n" + places);
		places.remove(keyPlace);
		System.out.println("After removal, the Places are: \n" + places);
		
		// print using entrySet
		for(Map.Entry<String, Integer> newEntry : places.entrySet()) {
			System.out.println(newEntry.getKey() + ": " + newEntry.getValue());
		}
		
		// print using keySet
		for(String key : places.keySet())
			System.out.println(key + ":" + places.get(key));
		
		System.out.println("Bengaluru population is " + places.getOrDefault("bengaluru", 1000000));
		System.out.println("Nagpur population is " + places.getOrDefault("Nagpur", 1000000));
		System.out.println("Chennai population is " + places.get("chennai"));
	}
}

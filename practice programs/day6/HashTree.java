package day6;

import java.util.HashMap;

class HashTree1 {

	HashMap<String, HashTree1> places = new HashMap<>();
	boolean isPlace;
	
	public HashTree1() {
		isPlace = false;
	}
}

public class HashTree {
	private HashTree1 head;
	
	public HashTree() {
		head = new HashTree1();
	}
	
	public void addPlace(String place) {
		HashTree1 newPlace = this.head;
		for(char ch : place.toCharArray()) {
			String key = String.valueOf(ch);
			newPlace.places.putIfAbsent(key, new HashTree1());
			newPlace = newPlace.places.get(key);
		}
		newPlace.isPlace = true;
	}
	
	//inserting place in to the HashTree
	public void insert(String place) {
		HashTree1 newPlace = head;
		for(char ch : place.toCharArray()) {
			String key = String.valueOf(ch);
			newPlace.places.putIfAbsent(key, new HashTree1());
			newPlace = newPlace.places.get(key);
		}
		newPlace.isPlace = true;
	}
	
	// searching for a place
	public boolean search(String place) {
		HashTree1 newPlace = head;
		for(char ch : place.toCharArray()) {
			String key = String.valueOf(ch);
			if(!newPlace.places.containsKey(key))
				return false;
			newPlace = newPlace.places.get(key);
		}
		return newPlace.isPlace;
	}
	
	public void displayPlaces() {
		displayPlacesRecursively(head, "");
	}
	
	private void displayPlacesRecursively(HashTree1 presentPlace, String prefix) {
		if(presentPlace.isPlace)
			System.out.println(prefix);
		for(String key : presentPlace.places.keySet()) {
			displayPlacesRecursively(presentPlace.places.get(key), prefix+key);
		}
	}
	
	public static void main(String[] args) {
		HashTree htree = new HashTree();
		
		htree.insert("madurai");
		htree.insert("kanyakumari");
		htree.insert("sathyamangalam");
		htree.insert("krishnagiri");
		
		System.out.println(htree.search("coimbatore"));
		System.out.println(htree.search("madurai"));
		System.out.println(htree.search("krishnagiri"));
		System.out.println(htree.search("nagapattinam"));
		
		htree.displayPlaces();
		
	}
}

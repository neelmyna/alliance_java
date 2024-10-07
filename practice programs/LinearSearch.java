package java_concepts;

import java.util.Arrays;
import java.util.Scanner;

public class LinearSearch {
	private int inputSize;
	private double[] array;
	private double searchKey;
	private static Scanner scanner;
	
	static {
		scanner = new Scanner(System.in);
	}
	
	public void readInputData() {
		System.out.print("Enter input size of the list: ");
		inputSize = scanner.nextInt();
		array = new double[inputSize];
		System.out.println("Enter " + inputSize + " numbers:");
		for(int i = 0; i < inputSize; i++)
			array[i] = scanner.nextDouble();
		System.out.println("User given List of numbers is \n" + Arrays.toString(array));
		System.out.print("Enter search element: ");
		searchKey = scanner.nextDouble();
	}
	
	public int linearSearch() {
		for(int i = 0; i < inputSize; i++) {
			if (array[i] == searchKey)
				return i; // return index of 1st occurrence of key
		}
		return -1; // Element not found
	}
	
	public static void main(String[] args) {
		LinearSearch ls = new LinearSearch();
		ls.readInputData();
		int keyIndex = ls.linearSearch();
		if(keyIndex == -1)
			System.out.println("Search element not found");
		else
			System.out.println("Search element found at position " + (keyIndex+1));
	}
}

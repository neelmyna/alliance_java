package java_concepts;

import java.util.Arrays;
import java.util.Scanner;

public class BinarySearch {
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
		Arrays.sort(array);
		System.out.println("User given List of numbers is \n" + Arrays.toString(array));
		System.out.print("Enter search element: ");
		searchKey = scanner.nextDouble();
	}
	
	public int binarySearch() {
		int low = 0;
		int high = inputSize-1;
		do {
			int mid = (low + high) / 2;
			if (array[mid] == searchKey)
				return mid;
			else if(searchKey < array[mid])
				high = mid-1;
			else
				low = mid+1;
		}while(low <= high); // until list has at least one element
		
		return -1; // Element not found
	}
	
	public static void main(String[] args) {
		BinarySearch ls = new BinarySearch();
		ls.readInputData();
		int keyIndex = ls.binarySearch();
		if(keyIndex == -1)
			System.out.println("Search element not found");
		else
			System.out.println("Search element found at position " + (keyIndex+1));
	}
}
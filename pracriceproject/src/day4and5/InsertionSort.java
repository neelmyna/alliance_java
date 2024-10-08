package java_concepts;


import java.util.Arrays;
import java.util.Scanner;

public class InsertionSort {
	private int inputSize;
	private int[] array;
	private static Scanner scanner;
	
	static {
		scanner = new Scanner(System.in);
	}

	public void readInputData() {
		System.out.print("Enter input size of the list: ");
		inputSize = scanner.nextInt();
		array = new int[inputSize];
		System.out.println("Enter " + inputSize + " numbers:");
		for(int i = 0; i < inputSize; i++)
			array[i] = scanner.nextInt();
		System.out.println("User given List of numbers is \n" + Arrays.toString(array));
	}
	
	public void insertionSort() {
		for(int i = 1; i < inputSize; i++) {
			int element = array[i];
			int j = i - 1;
			while(j >= 0 && element < array[j]) {
				array[j+1] = array[j];
				j--;
			}
			array[j+1] = element;
		}
	}
	
	public static void main(String[] args) {
		InsertionSort bs = new InsertionSort();
		bs.readInputData();
		bs.insertionSort();
		System.out.println("Sorted Array is:");
		System.out.println(Arrays.toString(bs.array));
	}
}

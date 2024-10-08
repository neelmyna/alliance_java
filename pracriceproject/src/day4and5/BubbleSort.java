package java_concepts;

import java.util.Arrays;
import java.util.Scanner;

public class BubbleSort {
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
	
	public void bubbleSort() {
		for(int i = 0; i < inputSize-1; i++) {
			boolean sorted = true;
			for(int j = 0; j < inputSize-i-1; j++) {
				if(array[j] > array[j+1]) {
					int temp = array[j];
					array[j] = array[j+1];
					array[j+1] = temp;
					sorted = false;
				}
			}
			if(sorted)
				return;
		}
	}
	
	public static void main(String[] args) {
		BubbleSort bs = new BubbleSort();
		bs.readInputData();
		bs.bubbleSort();
		System.out.println("Sorted Array is:");
		System.out.println(Arrays.toString(bs.array));
	}
}

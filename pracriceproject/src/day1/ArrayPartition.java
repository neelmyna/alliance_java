package day1;

import java.util.Arrays;
import java.util.Scanner;

public class ArrayPartition {

	public static void partitionArray(int[] array ) {
		int j = 0;
		int lastIndex = array.length-1;
		int pivot = array[lastIndex];
		for(int i = 0; i < lastIndex; i++) {
			if(array[i] < pivot) {
				int temp = array[i];
				array[i] = array[j];
				array[j] = temp;
				j++;
			}
		}
		int temp = array[j];
		array[j] = array[lastIndex];
		array[lastIndex] = temp;
	}
	
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in); 
		System.out.print("Enter size of the array: ");
		int n = scanner.nextInt();
		int[] array = new int[n];
		System.out.println("Enter " + n + " numbers of the Array:");
		for(int i = 0; i < n; i++)
			array[i] = scanner.nextInt();
		System.out.println("User given " + n + " numbers are:");
		System.out.println(Arrays.toString(array));
		partitionArray(array);
		System.out.println("After partioning, the array is:");
		System.out.println(Arrays.toString(array));
		scanner.close();
	}

}

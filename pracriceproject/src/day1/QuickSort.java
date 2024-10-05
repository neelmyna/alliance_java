package day1;

import java.util.Arrays;
import java.util.Scanner;

public class QuickSort {

	protected static int partitionArray(int[] array, int low, int high) {
		int j = low;
		int pivot = array[high];
		for(int i = low; i < high; i++) {
			if(array[i] < pivot) {
				int temp = array[i];
				array[i] = array[j];
				array[j] = temp;
				j++;
			}
		}
		int temp = array[j];
		array[j] = array[high];
		array[high] = temp;
		return j;
	}
	
	public static void quickSort(int[] array, int low, int high) {
		if(low < high) {
			int pivotIndex = partitionArray(array, low, high);
			quickSort(array, low, pivotIndex-1);
			quickSort(array, pivotIndex+1, high);
		}
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
		quickSort(array, 0, array.length-1);
		System.out.println("After sorting, the array is:");
		System.out.println(Arrays.toString(array));
		scanner.close();
	}
}

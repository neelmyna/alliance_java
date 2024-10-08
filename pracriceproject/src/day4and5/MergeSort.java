package java_concepts;

import java.util.Arrays;
import java.util.Scanner;

public class MergeSort {
	private int inputSize;
	private double[] array;
	private static Scanner scanner;

	static {
		scanner = new Scanner(System.in);
	}

	public void readInputData() {
		System.out.print("Enter input size of the list: ");
		inputSize = scanner.nextInt();
		array = new double[inputSize];
		System.out.println("Enter " + inputSize + " numbers:");
		for (int i = 0; i < inputSize; i++)
			array[i] = scanner.nextInt();
		System.out.println("User given List of numbers is \n" + Arrays.toString(array));
	}

	public void merge(double[] array, double[] left, double[] right) {
		int i = 0, j = 0, k = 0;
		while (i < left.length && j < right.length) {
			if (left[i] < right[j])
				array[k++] = left[i++];
			else
				array[k++] = right[j++];
		}
		while (i < left.length)
			array[k++] = left[i++];

		while (j < right.length)
			array[k++] = right[j++];
	}

	public void mergeSort(double[] array) {
		if (array.length > 1) {
			int mid = array.length / 2;
			double[] left = new double[mid];
			double[] right = new double[array.length - mid];
			System.arraycopy(array, 0, left, 0, mid);
			System.arraycopy(array, mid, right, 0, array.length - mid);

			mergeSort(left);
			mergeSort(right);
			merge(array, left, right);
		}
	}

	public static void main(String[] args) {
		MergeSort bs = new MergeSort();
		bs.readInputData();
		bs.mergeSort(bs.array);
		System.out.println("Sorted Array is:");
		System.out.println(Arrays.toString(bs.array));
	}
}

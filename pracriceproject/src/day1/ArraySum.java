package day1;

public class ArraySum {

	public static int findSum(int[] array, int i) {
		if (i == 0)
			return array[0];
		return array[i] + findSum(array, i-1);
	}
	
	public static void main(String[] args) {
		int[] array = new int[args.length];
		System.out.println("The User given " + args.length + " numbers are:");
		for(int i = 0; i < args.length; i++) {
			System.out.print(args[i] + "  ");
			array[i] = Integer.parseInt(args[i]);
		}
		int sumOfArrayNumbers = findSum(array, array.length-1);
		System.out.println("\nSum of Array numbers = " + sumOfArrayNumbers);
	}
}

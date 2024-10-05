package day1;

public class CallStack {
	private static int num;
	
	public static void anekal(int num1, int num2) {
		float num3;
		System.out.println("I came to see Fox in the Anekal Forest");
		hosur();
		System.out.println("I came to see if I can get play with an Elephant");
	}
	
	public static void hogenakkal() {
		System.out.println("I came to lose my back pain with the waterfall");
	}

	public static void hosur() {
		String str;
		System.out.println("I came to enjoy the local Fish Fry");
		hogenakkal();
		System.out.println("I came back to buy Standard Fire works for Deepawali");
	}

	
	public static void main(String[] args) {
		System.out.println("I am in Home");
		anekal(20, 50);
		System.out.println("I am back Home");
	}
}

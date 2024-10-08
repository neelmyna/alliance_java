package day1;

public class MyString {

	public static void main(String[] args) {
		String s1 = "mysuru";
		for (int i = 0, j = 65; i < s1.length(); i++, j++) {
			s1 = s1 + String.valueOf(j);
			System.out.print(s1);
		}
	}
}
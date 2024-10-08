package java_concepts;

public class MyProgram {

	public static void main(String[] args) {
		String s1 = "mysuru";
		int length = s1.length(), j = 0;
		for(int i = 0; i < length; i++, j++) {
			char ch = (char)(j+65);
			s1 = s1 + String.valueOf(ch);
			System.out.println(s1);
		}
		System.out.println("Number of times new String object created is " + j);
	}
}

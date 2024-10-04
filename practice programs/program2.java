public static void main(String[] args) {
		Student student1 = new Student();
		Student student2 = new Student(101, "nithin", "comp-sc", 89.5f, (byte) 7, 9988554477L);
		
		if (student1 == student2)
			System.out.println("Both references refer to the same object");
		else
			System.out.println("student1 and student2 are different objects");
		student1 = student2;
		if (student1 == student2)
			System.out.println("Both references refer to the same object");
		else
			System.out.println("student1 and student2 are different objects");
	}
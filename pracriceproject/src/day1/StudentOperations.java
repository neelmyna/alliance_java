package day1;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class StudentOperations {

	private static List <Student> students;
	
	public static void createStudentList() {
		students = new ArrayList<Student>();
	}
	
	public static Student readStudentDetails() {
		Scanner scanner = new Scanner(System.in);
		System.out.print("Enter name of the student: ");
		String name = scanner.next();
		System.out.print("Enter Branch of the student: ");
		String branch = scanner.next();
		System.out.print("Enter Average Score of the student: ");
		float averageScore = scanner.nextFloat();
		System.out.print("Enter Semester of the student: ");
		byte semester = scanner.nextByte();
		System.out.print("Enter Phone Number of the student: ");
		long phoneNumber = scanner.nextLong();
		return new Student(0, name, branch, averageScore, semester, phoneNumber);
	}
	
	public static void create() {
		Student student = readStudentDetails();
		students.add(student);
	}

	public static void findById() {
		if(students.isEmpty()) {
			System.out.println("No students enrolled yet");
			return;
		}
		Scanner scanner = new Scanner(System.in);
		boolean found = false;
		System.out.print("Enter Id of the student: ");
		int id = scanner.nextInt();
		for(Student student : students) {
			if(student.getId() == id) {
				System.out.println("Student details are \n" + student);
				found = true;
			}
		}
		if(!found)
			System.out.println("Student with id = " + id + " not found");
	}

	public static void findByIdAndDelete() {
		if(students.isEmpty()) {
			System.out.println("No students enrolled yet");
			return;
		}
		Scanner scanner = new Scanner(System.in);
		boolean found = false; // Assume student not found
		System.out.print("Enter id of the student to delete: ");
		int id = scanner.nextInt();
		for(Student student : students) {
			if(student.getId() == id) {
				students.remove(student);
				found = true;
			}
		}
		if(found)
			System.out.println("Student with id = " + id + " is deleted");
		else
			System.out.println("Student with id = " + id + " not found");
	}

	public static void readNewStudentData(Student student) {
		Scanner scanner = new Scanner(System.in);
		String choice = null;
		System.out.print("Do you want to update Name (Y/N): ");
		choice = scanner.next();
		if(choice.toLowerCase().charAt(0) == 'y') {
			System.out.print("Enter new Name of the student: ");
			String name = scanner.next();
			student.setName(name);
		}
		System.out.print("Do you want to update Branch (Y/N): ");
		choice = scanner.next();
		if(choice.toLowerCase().charAt(0) == 'y') {
			System.out.print("Enter new Branch of the student: ");
			String branch = scanner.next();
			student.setName(branch);
		}
		System.out.print("Do you want to update PhoneNumber (Y/N): ");
		choice = scanner.next();
		if(choice.toLowerCase().charAt(0) == 'y') {
			System.out.print("Enter new Branch of the student: ");
			long phoneNumber = scanner.nextLong();
			student.setPhoneNumber(phoneNumber);
		}
	}
	
	public static void findByIdAndUpdate() {
		if(students.isEmpty()) {
			System.out.println("No students enrolled yet");
			return;
		}
		Scanner scanner = new Scanner(System.in);
		boolean found = false; // Assume student not found
		System.out.print("Enter id of the student to update: ");
		int id = scanner.nextInt();
		//int i = 0;
		for(Student student : students) {
			if(student.getId() == id) {
				readNewStudentData(student);
				//students.remove(i);
				//students.add(i, student);
				found = true;
			}
			//i++;
		}
		if(found)
			System.out.println("Student with id = " + id + " is updated");
		else
			System.out.println("Student with id = " + id + " not found");
	}

	public static void listAll() {
		if(students.isEmpty()) {
			System.out.println("No students enrolled yet");
			return;
		}
		for(Student student : students) {
			System.out.println(student);
		}
	}

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		createStudentList();
		int choice = 0;
		do {
			System.out.println("1:Insert 2:Delete 3:Search 4:Update 5:ListAll 6:Exit \t Your Choice? ");
			choice = scanner.nextInt();
			switch (choice) {
			case 1: create(); break;
			case 2: findByIdAndDelete(); break;
			case 3: findById(); break;
			case 4: findByIdAndUpdate(); break;
			case 5: listAll(); break;
			case 6: System.out.println("End of program");
					students = null;
					choice = 0;
					break;
			default: System.out.println("Invalid choice entered");
			}
		} while (choice != 0);
		scanner.close();
	}
}
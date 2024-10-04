package day1;

import java.util.Objects;

public class Student extends Object {
	private static int generateId = 1;
	private int id;
	private String name;
	private String branch;
	private float averageScore;
	private byte semester;
	private long phoneNumber = 123;
	
	static {
		generateId = 1;
	}

	{
		phoneNumber = 456;
	}
	
	public Student() {
		super();
		phoneNumber = 789;
		this.id = Student.generateId;
		generateId++;
	}

	public Student(int id, String name, String branch, float averageScore, byte semester, long phoneNumber) {
		super();
		this.id = id;
		this.name = name;
		this.branch = branch;
		this.averageScore = averageScore;
		this.semester = semester;
		this.phoneNumber = phoneNumber;
	}

	public static int getGenerateId() {
		return generateId;
	}

	public static void setGenerateId(int generateId) {
		Student.generateId = generateId;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getBranch() {
		return branch;
	}

	public void setBranch(String branch) {
		this.branch = branch;
	}

	public float getAverageScore() {
		return averageScore;
	}

	public void setAverageScore(float averageScore) {
		this.averageScore = averageScore;
	}

	public byte getSemester() {
		return semester;
	}

	public void setSemester(byte semester) {
		this.semester = semester;
	}

	public long getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(long phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	@Override
	public String toString() {
		return "Student [id=" + id + ", name=" + name + ", branch=" + branch + ", averageScore=" + averageScore
				+ ", semester=" + semester + ", phoneNumber=" + phoneNumber + "]";
	}

	@Override
	public int hashCode() {
		return Objects.hash(averageScore, branch, id, name, phoneNumber, semester);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Student other = (Student) obj;
		return Float.floatToIntBits(averageScore) == Float.floatToIntBits(other.averageScore)
				&& Objects.equals(branch, other.branch) && id == other.id && Objects.equals(name, other.name)
				&& phoneNumber == other.phoneNumber && semester == other.semester;
	}
	
	public static void main(String[] args) {
		for(int i = 0; i < args.length; i++) {
			System.out.print(args[i] + "   ");
		}
		System.out.println(args[0] instanceof String);
		System.out.println(Integer.parseInt(args[1]) instanceof String);
	}

}

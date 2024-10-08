package employeeapp;

public class Employee {
	private int id;
	private String name;
	private String designation;
	private String location;
	private String technology;
	private int age;
	private byte yearsOfExperience;
	private float commission;
	private float salary;
	private long phoneNumber;
	
	public Employee() {
		super();
	}

	public Employee(String name, String designation, String location, String technology, int age,
			byte yearsOfExperience, float commission, float salary, long phoneNumber) {
		super();
		this.name = name;
		this.designation = designation;
		this.location = location;
		this.technology = technology;
		this.age = age;
		this.yearsOfExperience = yearsOfExperience;
		this.commission = commission;
		this.salary = salary;
		this.phoneNumber = phoneNumber;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDesignation() {
		return designation;
	}

	public void setDesignation(String designation) {
		this.designation = designation;
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	public String getTechnology() {
		return technology;
	}

	public void setTechnology(String technology) {
		this.technology = technology;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}
	
	public void setId(int id) {
		this.id= id;
	}

	public byte getYearsOfExperience() {
		return yearsOfExperience;
	}

	public void setYearsOfExperience(byte yearsOfExperience) {
		this.yearsOfExperience = yearsOfExperience;
	}

	public float getCommission() {
		return commission;
	}

	public void setCommission(float commission) {
		this.commission = commission;
	}

	public float getSalary() {
		return salary;
	}

	public void setSalary(float salary) {
		this.salary = salary;
	}

	public long getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(long phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public int getId() {
		return id;
	}

	@Override
	public String toString() {
		return "Employee [id=" + id + ", name=" + name + ", designation=" + designation + ", location=" + location
				+ ", technology=" + technology + ", age=" + age + ", yearsOfExperience=" + yearsOfExperience
				+ ", commission=" + commission + ", salary=" + salary + ", phoneNumber=" + phoneNumber + "]";
	}	
}

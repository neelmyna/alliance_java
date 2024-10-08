package employeeapp;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class EmployeeDAO {
	public Connection connectDB() throws SQLException, ClassNotFoundException {
		Class.forName("com.mysql.cj.jdbc.Driver");
		Connection connection = null;
		String url = "jdbc:mysql://localhost:3306/nithin_db";
		String userID = "root";
		String password = "Root123";
		connection = DriverManager.getConnection(url, userID, password);
		System.out.println("DB Connected successfully");
		return connection;
	}
	
	public void disconnectDB(Connection connection) throws SQLException {
		connection.close();
		System.out.println("DB disConnected successfully");
	}
	
	public void createTable() {
		String createTablequery = "create table IF NOT EXISTS employees(id int primary key auto_increment, name varchar(30) not null, designation varchar(30), location varchar(30), technology varchar(30) not null, phone_number bigint unique, commission float default (0), salary float check(salary > 9000), age tinyint, years_of_experience tinyint)";

		try {
			Connection connection = connectDB();
			Statement statement = connection.createStatement();
			boolean created = statement.execute(createTablequery);
			if (!created)
				System.out.println("Table created successfully");
			statement.close();
			disconnectDB(connection);
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}
	
	public String insertRow(Employee employee) {
		String query = "insert into employees(name, designation, location, technology, phone_number, commission, salary, age, years_of_experience) values(?, ?, ?, ?, ?, ?, ?, ?, ?)";
		String result = "";
		try {
			Connection connection = connectDB();
			PreparedStatement pt = connection.prepareStatement(query);
			pt.setString(1, employee.getName());
			pt.setString(2, employee.getDesignation());
			pt.setString(3, employee.getLocation());
			pt.setString(4, employee.getTechnology());
			pt.setLong(5, employee.getPhoneNumber());
			pt.setFloat(6, employee.getCommission());
			pt.setFloat(7, employee.getSalary());
			pt.setInt(8, employee.getAge());
			pt.setInt(9, employee.getYearsOfExperience());
			boolean res = pt.execute();
			pt.close();
			disconnectDB(connection);
			if (!res)
				result = "Row Inserted Successfully";
			else
				result = "Row Insertion failed";
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		System.out.println(result);
		return result;
	}
	
	public Employee readEmployeeDetails() {
		Scanner scanner = new Scanner(System.in);
		String name = "";
		String designation = "";
		String location = "";
		String technology = "";
		long phoneNumber = 0;
		float commission = 0.0f;
		float salary = 0.0f;
		int age = 0;
		byte yearsOfExperience = 0;
		System.out.print("Enter employee name: ");
		name = scanner.next();
		System.out.print("Enter employee designation: ");
		designation = scanner.next();
		System.out.print("Enter employee location: ");
		location = scanner.next();
		System.out.print("Enter employee technology: ");
		technology = scanner.next();
		System.out.print("Enter employee phone_number: ");
		phoneNumber = scanner.nextLong();
		System.out.print("Enter employee commission: ");
		commission = scanner.nextFloat();
		System.out.print("Enter employee salary: ");
		salary = scanner.nextFloat();
		System.out.print("Enter employee age: ");
		age = scanner.nextInt();
		System.out.print("Enter employee years_of_experience: ");
		yearsOfExperience = scanner.nextByte();
		
		Employee employee = new Employee(name, designation, location, technology, age, yearsOfExperience, commission, salary, phoneNumber);
		return employee;
	}
	
	Employee readEmployeeDetailsForUpdate() {
		String location = "";
		float commission = 0.0f;
		int age = 0;
		int id = 0;
		Scanner scanner = new Scanner(System.in);
		System.out.print("Enter employee location: ");
		location = scanner.next();
		System.out.print("Enter employee commission: ");
		commission = scanner.nextFloat();
		System.out.print("Enter employee age: ");
		age = scanner.nextInt();
		System.out.print("Enter employee Id to update the record: ");
		id = scanner.nextInt();
		Employee employee = new Employee();
		employee.setId(id);
		employee.setAge(age);
		employee.setLocation(location);
		employee.setCommission(commission);
		return employee;
	}
	
	public String updateRow(Employee employee) {
		String query = "update employees set location = ?, age = ?, commission = ? where id = ?";
		String result = "";
		try {
			Connection connection = connectDB();
			PreparedStatement pt = connection.prepareStatement(query);
			pt.setString(1, employee.getLocation());
			pt.setInt(2, employee.getAge());
			pt.setFloat(3, employee.getCommission());
			pt.setInt(4, employee.getId());
			int count = pt.executeUpdate();
			pt.close();
			disconnectDB(connection);
			if (count != 1)
				result = "Employee with ID=" + employee.getId() + " not found";
			result = "Employee details updated successfully";
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		System.out.println(result);
		return result;
	}
	
	public String deleteRow() {
		Scanner scanner = new Scanner(System.in);
		System.out.print("Enter employee Id to delete the record: ");
		int id = scanner.nextInt();
		String query = "delete from employees where id = ?";
		String result = "";
		try {
			Connection connection = connectDB();
			PreparedStatement pt = connection.prepareStatement(query);
			pt.setInt(1, id);
			int count = pt.executeUpdate();
			pt.close();
			disconnectDB(connection);
			if (count != 1)
				result = "Employee with ID=" + id + " not found";
			result = "Employee record deleted successfully";
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		System.out.println(result);
		return result;
	}
	
	public Employee searchRow() {
		Scanner scanner = new Scanner(System.in);
		System.out.print("Enter employee Id to search the record: ");
		int id = scanner.nextInt();
		String query = "select * from employees where id = ?";
		Employee employee = null;
		try {
			Connection connection = connectDB();
			PreparedStatement pt = connection.prepareStatement(query);
			pt.setInt(1, id);
			ResultSet rs = pt.executeQuery();
			if (rs.next()) {
				employee = new Employee();
				employee.setId(rs.getInt(1));
				employee.setName(rs.getString(2));
				employee.setDesignation(rs.getString(3));
				employee.setLocation(rs.getString(4));
				employee.setTechnology(rs.getString(5));
				employee.setPhoneNumber(rs.getLong(6));
				employee.setCommission(rs.getFloat(7));
				employee.setSalary(rs.getFloat(8));
				employee.setAge(rs.getInt(9));
				employee.setYearsOfExperience(rs.getByte(10));				
				System.out.println(employee);
				pt.close();
				disconnectDB(connection);
			}	
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		return employee;
	}
	
	public void printAllRecords(List<Employee> employees) {
		String template1 = "%-2s %-9s %-11s %-10s %-12s %-12s %-10s %-8s %-3s %-10s \n";
		String template2 = "%-2d %-9s %-11s %-10s %-12s %-12d %-10.1f %-8.1f %-3d %d\n";
		String[] s = {"ID", "NAME", "DESIGNATION", "LOCATION ", "TECHNOLOGY", "PHONE-NUMBER", "COMMISSION", "SALARY", "AGE", "EXPERIENCE"};
		System.out.printf(template1, s[0], s[1], s[2], s[3], s[4], s[5], s[6], s[7], s[8], s[9]);
		for(Employee e : employees)
			System.out.printf(template2, e.getId(), e.getName(), e.getDesignation(), e.getLocation(), e.getTechnology(), e.getPhoneNumber(), e.getCommission(), e.getSalary(), e.getAge(), e.getYearsOfExperience());
	}
	
	public List<Employee> listAllEmployees() {
		String query = "select * from employees";
		List <Employee> employees = new ArrayList<Employee>();
		try {
			Connection connection = connectDB();
			Statement statement = connection.createStatement();
			ResultSet rs = statement.executeQuery(query)
;
			Employee employee = new Employee();
			while(rs.next()) {
				employee = new Employee();
				employee.setId(rs.getInt(1));
				employee.setName(rs.getString(2));
				employee.setDesignation(rs.getString(3));
				employee.setLocation(rs.getString(4));
				employee.setTechnology(rs.getString(5));
				employee.setPhoneNumber(rs.getLong(6));
				employee.setCommission(rs.getFloat(7));
				employee.setSalary(rs.getFloat(8));
				employee.setAge(rs.getInt(9));
				employee.setYearsOfExperience(rs.getByte(10));
				employees.add(employee);
			} // end of while
			printAllRecords(employees);
		}
		catch(SQLException e) {
			System.out.println(e.getMessage());
		}
		catch(ClassNotFoundException e) {
			System.out.println(e.getMessage());
		}
		return employees;
	} // end of method
	
	public static void main(String[] args) {
		EmployeeDAO dao = new EmployeeDAO();
		dao.listAllEmployees();
	}
}

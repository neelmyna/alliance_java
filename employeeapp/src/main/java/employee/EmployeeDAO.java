package employee;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class EmployeeDAO {
	
	private static Scanner scanner;
	
	static {
		scanner = new Scanner(System.in);
	}
	
	public Connection connectDB() throws SQLException {
		String url = "jdbc:mysql://localhost:3306/guvi_db";
		String userName = "root";
		String password = "root";
		Connection connection = DriverManager.getConnection(url, userName, password);
		System.out.println("Database connection established");
		return connection;
	}
	
	public void disconnectDB(Connection connection) throws SQLException {
		connection.close();
		System.out.println("DB disconnected");
	}
	
	public void createTable() {
		String query = "create table IF NOT EXISTS employees(id int primary key auto_increment, name varchar(32) not null, designation varchar(64), salary float default 0.0, commission int, phoneNumber bigint unique)";
		try {
			Connection connection = connectDB();
			Statement statement = connection.createStatement();
			boolean created = statement.execute(query);
			if(!created)
				System.out.println("Table created successfully");
			statement.close();			
			disconnectDB(connection);
		} catch (SQLException e) {
			System.out.println("Some Error occured while connecting to the dB");
			e.printStackTrace();
		}
	}
	
	public Employee readEmployeeDetails() {
		System.out.print("Enter name of the employee: ");
		String name = scanner.next();
		System.out.print("Enter designation of the employee: ");
		String designation = scanner.next();
		System.out.print("Enter salary of the employee: ");
		float salary = scanner.nextFloat();
		System.out.print("Enter commission of the employee: ");
		int commission = scanner.nextInt();
		System.out.print("Enter phone number of the employee: ");
		long phoneNumber = scanner.nextLong();
		Employee employee = new Employee(0, name, designation, salary, commission, phoneNumber);
		return employee;
	}
	
	public void insertRow() {
		String query = "insert into employees(name, designation, salary, commission, phoneNumber) values(?, ?, ?, ?, ?)";
		try {
			Employee employee = readEmployeeDetails();
			Connection connection = connectDB();
			PreparedStatement ps = connection.prepareStatement(query);
			ps.setString(1, employee.getName());
			ps.setString(2, employee.getDesignation());
			ps.setFloat(3, employee.getSalary());
			ps.setInt(4, employee.getCommission());
			ps.setLong(5, employee.getPhoneNumber());
			boolean result = ps.execute();
			if(!result)
				System.out.println("Row inserted successfully");
			ps.close();			
			disconnectDB(connection);
		} catch (SQLException e) {
			System.out.println("Some Error occured while connecting to the dB");
			e.printStackTrace();
		}
	}
	
	public void deleteRow() {
		String query = "delete from employees where id = ?";
		try {
			System.out.print("Enter Id of the employee to delete: ");
			int id = scanner.nextInt();
			Connection connection = connectDB();
			PreparedStatement ps = connection.prepareStatement(query);
			ps.setInt(1, id);
			int numberOfRows = ps.executeUpdate();
			if(numberOfRows == 1)
				System.out.println("Row deleted successfully");
			else
				System.out.println("Employee with Id " + id + " not found");
			ps.close();			
			disconnectDB(connection);
		} catch (SQLException e) {
			System.out.println("Some Error occured while connecting to the dB");
			e.printStackTrace();
		}
	}
	
	public void updateRow() {
		String query = "update employees set designation = ?, salary = ? where id = ?";
		try {
			System.out.print("Enter Id of the employee to update: ");
			int id = scanner.nextInt();
			System.out.print("Enter designation of the employee to update: ");
			String designation = scanner.next();
			System.out.print("Enter salary of the employee to update: ");
			float salary = scanner.nextFloat();
			
			Connection connection = connectDB();
			PreparedStatement ps = connection.prepareStatement(query);
			ps.setString(1, designation);
			ps.setFloat(2, salary);
			ps.setInt(3, id);
			int numberOfRows = ps.executeUpdate();
			if(numberOfRows == 1)
				System.out.println("Row updated successfully");
			else
				System.out.println("Employee with Id " + id + " not found");
			ps.close();			
			disconnectDB(connection);
		} catch (SQLException e) {
			System.out.println("Some Error occured while connecting to the dB");
			e.printStackTrace();
		}
	}
	
	public void searchRow() {
		String query = "select * from employees where id = ?";
		try {
			System.out.print("Enter Id of the employee to update: ");
			int id = scanner.nextInt();
			Connection connection = connectDB();
			PreparedStatement ps = connection.prepareStatement(query);
			ps.setInt(1, id);
			ResultSet rs = ps.executeQuery();
			if(rs.next()) {
				Employee employee = new Employee();
				employee.setId(rs.getInt((1)));
				employee.setName(rs.getString((2)));
				employee.setDesignation(rs.getString((3)));
				employee.setSalary(rs.getFloat((4)));
				employee.setCommission(rs.getInt((5)));
				employee.setPhoneNumber(rs.getLong((6)));
				System.out.println(employee);
			}
			else
				System.out.println("Employee with Id " + id + " not found");
			ps.close();			
			disconnectDB(connection);
		} catch (SQLException e) {
			System.out.println("Some Error occured while connecting to the dB");
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) {
		EmployeeDAO dao = new EmployeeDAO();
		dao.searchRow();
		scanner.close();
	}
}

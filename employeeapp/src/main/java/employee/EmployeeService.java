package employeeapp;

import java.util.List;
import java.util.Scanner;

public class EmployeeService {
	private EmployeeDAO dao;
	
	{ dao = new EmployeeDAO(); }
	
	public void createTable() {
		dao.createTable();
	}
	
	public Employee searchEmployee() {
		Employee employee = dao.searchRow();
		return employee;
	}
	
	public String updateEmployee() {
		Employee employee = dao.readEmployeeDetailsForUpdate();
		String result = dao.updateRow(employee);
		return result;
	}
	
	public String deleteEmployee() {
		String result = dao.deleteRow();
		return result;
	}
	
	public String insertEmployee() {
		Employee employee = dao.readEmployeeDetails();
		String result = dao.insertRow(employee);
		return result;
	}
	
	public List<Employee> listAllEmployees() {
		List<Employee> employees = dao.listAllEmployees();
		return employees;
	}
	
	public static void main(String[] args) {
		int countOfOperations = 20, choice = 0;
		EmployeeService services = new EmployeeService();
		Scanner scanner = new Scanner(System.in);
		do {
			System.out.println("1:Insert 2:Delete 3:Update 4:Search 5:ListAll 6:Exit");
			choice = scanner.nextInt();
			switch(choice) {
			case 1 : services.insertEmployee(); break;
			case 2 : services.deleteEmployee(); break;
			case 3 : services.updateEmployee(); break;
			case 4 : services.searchEmployee(); break;
			case 5 : services.listAllEmployees(); break;
			case 6 : countOfOperations = 0;
			}
			countOfOperations--;
		}while(countOfOperations >= 1);
		System.out.println("End of Program...");
	}
}

package com.canddella.training.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.HashMap;
import java.util.Map;

public class MySqlConnectDemo2 {

	HashMap<Integer, Employee> employeeMap = new HashMap<>();

	public void retrieveAndPrint() {
		retrieve();
		printData();
	}

	public void retrieve() {
		String dbUrl = "jdbc:mysql://localhost:3306/training";
		String userName = "root";
		String password = "revathy@#2023";

		Connection dbConnection;
		try {
			dbConnection = DriverManager.getConnection(dbUrl, userName, password);

			Statement statement = dbConnection.createStatement();
			String qry = "select * from employee";
			ResultSet rs = statement.executeQuery(qry);
			while (rs.next()) {
				int employeeId = rs.getInt("employee_id");
				String firstName = rs.getString("first_name");
				String lastName = rs.getString("last_name");
				Employee employee = new Employee(employeeId, firstName, lastName);
				employeeMap.put(employeeId, employee);
			}
			statement.close();
			rs.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public void printData() {

		System.out.println("******************************************************");
		System.out.println("Employee ID\tFirst Name\tLast Name");
		System.out.println("******************************************************");
		for (Map.Entry<Integer, Employee> entry : employeeMap.entrySet()) {
			System.out.println(entry.getKey() + "\t\t " + entry.getValue().getFirstName() + "\t\t "
					+ entry.getValue().getLastName());
		}
		System.out.println("******************************************************");
	}

	public static void main(String[] args) {

		MySqlConnectDemo2 employeeManager = new MySqlConnectDemo2();
		employeeManager.retrieveAndPrint();

	}
}

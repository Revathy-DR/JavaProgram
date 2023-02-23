package training.database.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class MySqlNewDemo {

	public static void main(String[] args) {

		String dbUrl = "jdbc:mysql://localhost:3306/training";
		String userName = "root";
		String password = "revathy@#2023";

		HashMap<Integer, Employee> customers = new HashMap<Integer, Employee>();

		try {

			Connection dbConnection = DriverManager.getConnection(dbUrl, userName, password);

			EmployeeDetails.getEmployee(customers, dbConnection);
			EmployeeDetails.printCustomer(customers);

		} catch (SQLException e) {

			e.printStackTrace();
		}

	}

}

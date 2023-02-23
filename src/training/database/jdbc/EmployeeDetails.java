package training.database.jdbc;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class EmployeeDetails {

	static void getEmployee( HashMap<Integer, Employee> customers, Connection dbConnection ) throws SQLException {
		String qryWithParameter = "select * from employee where dob = ?";
		PreparedStatement prepStmt = dbConnection.prepareStatement( qryWithParameter );
		prepStmt.setString( 1, "2001-02-21" );
		ResultSet rs2 = prepStmt.executeQuery();

		while (rs2.next()) {

			int customer_id = rs2.getInt( "employee_id" );
			String firstName = rs2.getString( "first_name" );
			String lastName = rs2.getString( "last_name" );

			customers.put(customer_id, new Employee( firstName, lastName ));
		}

		rs2.close();
		prepStmt.close();
		dbConnection.close();
	}

	public static void printCustomer( HashMap<Integer, Employee> customers ) {
		Iterator<Map.Entry<Integer, Employee>> iterator = customers.entrySet().iterator();
		
        System.out.println( "***********************************************************" );
		System.out.println( "Employee ID" + "\t\t" + "First Name" + "\t" + "Last Name" );
		System.out.println( "***********************************************************" );
		System.out.println();

		while ( iterator.hasNext() ) {

			Map.Entry<Integer, Employee> keyValuePair = iterator.next();
			Integer key = keyValuePair.getKey();
			Employee value = keyValuePair.getValue();

			System.out.print( key );
			System.out.print( "\t\t\t" + value.first_name + "\t\t" + value.last_name );
			System.out.println();
		}
		System.out.println( "***********************************************************" );
		
	}
	
}

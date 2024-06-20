package jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class EmployeeFetchData {
	public static void main(String[] args) throws  Exception {
		
		
		// 1 load the driver

				Class.forName("com.mysql.cj.jdbc.Driver");

				// 2 Established the connection

				Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/employeedb", "root", "root");

				// create statements

				Statement statement = connection.createStatement();
				
				ResultSet set= statement.executeQuery("SELECT * FROM employee ");
				
				while (set.next()) {
					System.out.print(set.getInt("id")+" | ");
					System.out.print(set.getString("name")+" | ");
					System.out.print(set.getLong("phone")+" | ");
					System.out.print(set.getDouble("salary")+" | ");
					System.out.print(set.getString("address")+" | ");
					System.out.println();
					System.out.println("-------------------------------------------------------------------------------------------");
				}
				
				connection.close();
						
					
	}
}

package jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class EmployeeInsert {

	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		// 1 load the driver

		Class.forName("com.mysql.cj.jdbc.Driver");

		// 2 Established the connection

		Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/employeedb", "root", "root");

		// create statements

		Statement statement = connection.createStatement();

		// 4. execute statement and process the result

		int result = statement.executeUpdate("INSERT INTO EMPLOYEE VALUES(4,'Aditya',8877665544,60000.0,'Beed'),(5,'Siddharth',9988776655,550000.0,'Mulshi')");

		if (result != 0) {
			System.out.println("Data Inserted");
		} else {
			System.out.println("Data Not Found");
		}

	}
}

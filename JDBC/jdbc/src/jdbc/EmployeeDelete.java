package jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class EmployeeDelete {

	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		// 1 load the driver

		Class.forName("com.mysql.cj.jdbc.Driver");

		// 2 Established the connection

		Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/employeedb", "root", "root");

		// create statements

		Statement statement = connection.createStatement();

		// 4. execute statement and process the result

		int result = statement.executeUpdate(
				"DELETE FROM EMPLOYEE WHERE id=5 ;");

		if (result != 0) {
			System.out.println("Data Deleted!");
		} else {
			System.out.println("Data Not Found");
		}
			connection.close();
	}
}

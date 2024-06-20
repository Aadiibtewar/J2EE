package jdbc_preparedStatement;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.util.Scanner;

public class StudentInsert {

	public static void main(String[] args) throws Exception {

		Scanner scanner = new Scanner(System.in);

		System.out.println("Enter the id");

		int id = scanner.nextInt();
		scanner.nextLine();
		
		System.out.println("Enter the name");
		String studentName = scanner.nextLine();
	

		System.out.println("enter the father name");
		String fatherName = scanner.nextLine();
	

		System.out.println("enter the mother name");
		String motherName = scanner.nextLine();
		

		System.out.println("enter the phone number");
		long phone = scanner.nextLong();
		scanner.nextLine();
		System.out.println("enter the address");
		String address = scanner.nextLine();
	

		System.out.println("enter the marks");
		double marks = scanner.nextDouble();

		String className = "com.mysql.cj.jdbc.Driver";

		String url = "jdbc:mysql://localHost:3306/studentdb";
		String password = "root";
		String user = "root";

		String sql = "INSERT INTO STUDENT VALUES(?,?,?,?,?,?,?)";

		Class.forName(className);

		Connection connection = DriverManager.getConnection(url, user, password);
		PreparedStatement preparedStatement = connection.prepareStatement(sql);

		preparedStatement.setInt(1, id);
		preparedStatement.setString(2, studentName);
		preparedStatement.setString(3, fatherName);

		preparedStatement.setLong(5, phone);
		preparedStatement.setString(4, motherName);
		preparedStatement.setString(6, address);
		preparedStatement.setDouble(7, marks);

		int result = preparedStatement.executeUpdate();

		if (result != 0) {
			System.out.println("data inserted!");
		} else {
			System.out.println("data not inserted");
		}

		connection.close();

	}
}

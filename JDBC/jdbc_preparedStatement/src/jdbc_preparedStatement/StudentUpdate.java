package jdbc_preparedStatement;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.util.Scanner;

public class StudentUpdate {

	public StudentUpdate() {
		// TODO Auto-generated constructor stub
	}
	
	public static void main(String[] args) throws Exception {
		
		Scanner scanner = new Scanner(System.in);
		
		String className = "com.mysql.cj.jdbc.Driver";

		String url = "jdbc:mysql://localHost:3306/studentdb";
		String password = "root";
		String user = "root";

		String sql = "UPDATE student SET fatherName =?, motherName=?,studentName=? where id =?";

		Class.forName(className);

		Connection connection = DriverManager.getConnection(url, user, password);
		PreparedStatement preparedStatement = connection.prepareStatement(sql);
		

		System.out.println("id:");
		int id= scanner.nextInt();
		
		System.out.println("new phone number:");
		long newPhone = scanner.nextLong();
		
		preparedStatement.setLong(1, newPhone);
		preparedStatement.setInt(2, id);
		
		
		connection.close();
		
		
		int result =preparedStatement.executeUpdate();
		
		if(result!=0) {
			System.out.println("data updated !");
		}else {
			System.out.println("data not updated !");
		}
		
		
		
		
		
	}
}

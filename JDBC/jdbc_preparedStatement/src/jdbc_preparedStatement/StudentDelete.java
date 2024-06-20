package jdbc_preparedStatement;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.util.Scanner;

public class StudentDelete {

	public StudentDelete() {
		// TODO Auto-generated constructor stub
	}
	public static void main(String[] args) throws Exception {
		
		Scanner scanner= new Scanner(System.in);
		
		String className="com.mysql.cj.jdbc.Driver";
		String url= "jdbc:mysql://localHost:3306/studentdb";
		String user="root";
		String password="root";
		
		Class.forName(className);
		
		Connection connection= DriverManager.getConnection(url, user, password);
		
		
		String sql="DELETE FROM STUDENT WHERE ID=?";
		
		
		System.out.println("Enter id want to delete");
		int id= scanner.nextInt();
		
		PreparedStatement preparedStatement =connection.prepareStatement(sql);
		
		
		preparedStatement.setInt(1, id);
		
		int result= preparedStatement.executeUpdate();
		
		if (result!=0) {
			System.out.println("data deleted");
		}
		else {
			System.out.println("data not deleted");
		}
		connection.close();
	}
}

package jdbc_preparedStatement;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class StudentFetchData {

	public StudentFetchData() {
		// TODO Auto-generated constructor stub
	}

	public static void main(String[] args) throws Exception {
		
		String className= "com.mysql.cj.jdbc.Driver";
		
		String url ="jdbc:mysql://localHost:3306/studentdb";
		
		String user= "root";
		String password= "root";
		
		Class.forName(className);
		
		Connection connection =DriverManager.getConnection(url, user, password);
		
		String sql = "SELECT * FROM STUDENT where id=?";
		int id=1;
		PreparedStatement preparedStatement= connection.prepareStatement(sql);
		preparedStatement.setInt(1, id);
		
		ResultSet set= preparedStatement.executeQuery();
		
		while(set.next()) {
			System.out.print(set.getInt("id")+" | ");
			System.out.print(set.getString("student_name")+" | ");
			System.out.print(set.getString("father_name")+" | ");
			System.out.print(set.getString("mother_name")+" | ");
			System.out.print(set.getLong("phone")+" | ");
			System.out.print(set.getString("address")+" | ");
			System.out.print(set.getDouble("marks")+" | ");
			System.out.println();
			System.out.println("-----------------------------------------------------------------------------------");
		}
		connection.close();
		
	}

}

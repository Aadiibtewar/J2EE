package jdbc_servlet;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class PersonCrud {
	
//	Person person = new Person();

	public Connection getConnection() throws Exception {
		String className="com.mysql.cj.jdbc.Driver";
		Class.forName(className);
		
		String url="jdbc:mysql://localHost:3306/servlets";
		String user="root";
		String password="root";
		
		Connection connection= DriverManager.getConnection(url, user, password);
		
		return connection;
	}
	
	public int userSignUp(Person person) throws Exception {
		Connection connection= getConnection();
		
		String sql="INSERT INTO person VALUES(?,?,?,?,?,?)";
		
		PreparedStatement preparedStatement= connection.prepareStatement(sql);
		
		preparedStatement.setInt(1,person.getId());
		preparedStatement.setString(2, person.getName());
		preparedStatement.setString(3, person.getPhone());
		preparedStatement.setString(4, person.getAddress());
		preparedStatement.setString(5, person.getEmail());
		preparedStatement.setString(6, person.getPassword());

		
		int result = preparedStatement.executeUpdate();
		connection.close();
		return result;
	
	}
	public String getPassword(String email) throws Exception {
		Connection connection= getConnection();
		String sql= "SELECT  PASSWORD FROM PERSON where email=?";
		
		PreparedStatement preparedStatement = connection.prepareStatement(sql);
		preparedStatement.setString(1, email);
		
		ResultSet resultSet= preparedStatement.executeQuery();

		String password = null;
		while(resultSet.next()) {
			password= resultSet.getString("password");
		}
		connection.close();
		
		
		return password;
	}

}

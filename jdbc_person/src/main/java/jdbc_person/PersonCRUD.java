package jdbc_person;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class PersonCRUD {

	public PersonCRUD() {
		// TODO Auto-generated constructor stub
	}
	
	public Connection getConnection() throws Exception {
		String className = "com.mysql.cj.jdbc.Driver";

		String url = "jdbc:mysql://localHost:3306/persondb";
		String password = "root";
		String user = "root";
		
		Class.forName(className);
		
		Connection connection = DriverManager.getConnection(url, user, password);
		
		return connection;
		
	}
	
	public int signUpPerson(Person person) throws Exception {
		Connection connection= getConnection();
		
		String sql="INSERT INTO PERSON VALUES(?,?,?,?,?)";
		
		PreparedStatement preparedStatement= connection.prepareStatement(sql);
		
		preparedStatement.setInt(1, person.getId());
		preparedStatement.setString(2, person.getName());
		preparedStatement.setLong(3, person.getPhone());
		preparedStatement.setString(4, person.getEmail());
		preparedStatement.setString(5, person.getPassword());
		
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
	
	
	public ResultSet getInfo(String email) throws Exception {
		Connection connection=getConnection();
		String sql = "SELECT * FROM PERSON WHERE EMAIL=?";
		
		PreparedStatement preparedStatement= connection.prepareStatement(sql);
		
		preparedStatement.setString(1, email);
		
		ResultSet resultSet= preparedStatement.executeQuery();
		
		while(resultSet.next()) {
			System.out.println("Name: "+resultSet.getString("name"));
			System.out.println("Id: "+resultSet.getInt("id"));
			System.out.println("Phone: "+resultSet.getLong("phone"));
			System.out.println("Email: "+resultSet.getString("email"));
			
		}
		connection.close();
			
		return resultSet;
		
	}
	public int updatePassword(String oldPassword, String newPassword) throws Exception {
		Connection connection=getConnection();
		String sql = "UPDATE PERSON SET PASSWORD =? WHERE password=?";
		
		PreparedStatement preparedStatement= connection.prepareStatement(sql);
		
		preparedStatement.setString(2, oldPassword);
		preparedStatement.setString(1, newPassword);
		
		int result = preparedStatement.executeUpdate();
		
		connection.close();
		return result;
	}
	
	public int deleteAccount(String password) throws Exception {
		Connection connection=getConnection();
		String sql = "DELETE FROM PERSON WHERE PASSWORD=?";
		
		PreparedStatement preparedStatement= connection.prepareStatement(sql);
		
		preparedStatement.setString(1, password);
		
		int result = preparedStatement.executeUpdate();
		
		connection.close();
		
		return result;
	}
	

}

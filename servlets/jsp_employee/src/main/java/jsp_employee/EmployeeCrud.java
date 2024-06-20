package jsp_employee;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class EmployeeCrud{

	public Connection getConnection() throws ClassNotFoundException, SQLException {
		
		Class.forName("com.mysql.cj.jdbc.Driver");
		
		return DriverManager.getConnection("jdbc:mysql://localhost:3306/jsp", "root","root");
	}
	
	public int signUpEmployee(Employee employee) throws ClassNotFoundException, SQLException {
		
		Connection connection = getConnection();
		
		PreparedStatement preparedStatement = connection.prepareStatement("INSERT INTO EMPLOYEE (ID, NAME, PHONE, EMAIL, DESIGNATION, SALARY, PASSWORD) VALUES (?,?,?,?,?,?,?)");
		
		preparedStatement.setInt(1, employee.getId());
		preparedStatement.setString(2, employee.getName());
		preparedStatement.setLong(3, employee.getPhone());
		preparedStatement.setString(4, employee.getEmail());
		preparedStatement.setString(5, employee.getDesignation());
		preparedStatement.setDouble(6, employee.getSalary());
		preparedStatement.setString(7, employee.getPassword());
		
		
		int result = preparedStatement.executeUpdate();
		
		connection.close();
		
		return result;
	}
	
	public String loginEmployee(String email) throws Exception {
		
		Connection connection = getConnection();
		
		PreparedStatement preparedStatement = connection.prepareStatement("SELECT PASSWORD FROM EMPLOYEE WHERE EMAIL=?");
		
		preparedStatement.setString(1, email);
		
		ResultSet resultSet = preparedStatement.executeQuery();
		
		String password = null;
		
		while(resultSet.next()) {
			
			 password = resultSet.getString("password");
		}
		connection.close();
		
		return password;
	}
	
	public List<Employee> getInfo() throws ClassNotFoundException, SQLException {
		Connection connection=getConnection();
		String sql = "SELECT * FROM employee ";
		
		PreparedStatement preparedStatement= connection.prepareStatement(sql);
		
		ResultSet resultSet= preparedStatement.executeQuery();
		
		List<Employee>list= new ArrayList<Employee>();
		
		while(resultSet.next()) {
			Employee emp= new Employee();
			emp.setId(resultSet.getInt(1));
			emp.setName(resultSet.getString(2));
			emp.setPhone(resultSet.getLong(3));
			emp.setEmail(resultSet.getString(4));
			emp.setPassword(resultSet.getString(5));
			emp.setDesignation(resultSet.getString(6));
			emp.setSalary(resultSet.getDouble(7));
			list.add(emp);
			
			
		}
		connection.close();
			
		return list;
		
	}
	public int delEmp(int id) throws ClassNotFoundException, SQLException {
		Connection connection= getConnection();
		String sql="DELETE FROM EMPLOYEE WHERE ID=?";
		PreparedStatement preparedStatement=connection.prepareStatement(sql);
		preparedStatement.setInt(1, id);
		int result= preparedStatement.executeUpdate();
		
		connection.close();
		return result;
		
	}
	public int updateEmp(Employee employee) throws SQLException, ClassNotFoundException {
		Connection connection= getConnection();
		String sql="UPDATE EMPLOYEE SET NAME=?,PHONE=?,EMAIL=?,PASSWORD=?,DESIGNATION=?,SALARY=? WHERE ID =?";
		PreparedStatement preparedStatement=connection.prepareStatement(sql);
		preparedStatement.setString(1,employee.getName());
		preparedStatement.setLong(2, employee.getPhone());
		preparedStatement.setString(3, employee.getEmail());
		preparedStatement.setString(6, employee.getPassword());
		preparedStatement.setString(4, employee.getDesignation());
		preparedStatement.setDouble(5, employee.getSalary());
		preparedStatement.setInt(7, employee.getId());
		
		
		int result= preparedStatement.executeUpdate();
		
		connection.close();
		return result;
	}
	public Employee findEmp(int id) throws ClassNotFoundException, SQLException {
		Connection connection= getConnection();
		String sql="SELECT * FROM EMPLOYEE WHERE ID=?";
		

		PreparedStatement preparedStatement=connection.prepareStatement(sql);
		preparedStatement.setInt(1,id );
		ResultSet resultSet=preparedStatement.executeQuery();
		Employee emp=null;
		while(resultSet.next()) {
			emp= new Employee();
			emp.setId(resultSet.getInt("id"));
			emp.setName(resultSet.getString("name"));
			emp.setPhone(resultSet.getLong("phone"));
			emp.setEmail(resultSet.getString("email"));
			emp.setPassword(resultSet.getString("password"));
			emp.setDesignation(resultSet.getString("desigantion"));
			emp.setSalary(resultSet.getDouble("salary"));
		}
		connection.close();
		return emp;
	}
	
}

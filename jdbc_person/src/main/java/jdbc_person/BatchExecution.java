package jdbc_person;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.util.ArrayList;
import java.util.List;

public class BatchExecution {
	
	public static void main(String[] args) throws Exception {
		Customer customer1= new Customer();
		customer1.setId(11);
		customer1.setName("sid");
		customer1.setPhone(9988776655l);
		customer1.setAddress("pune");
		
		Customer customer2= new Customer();
		customer2.setId(12);
		customer2.setName("raju");
		customer2.setPhone(99776655l);
		customer2.setAddress("mumbai");
		
		Customer customer3= new Customer();
		customer3.setId(13);
		customer3.setName("kaju");
		customer3.setPhone(8877996655l);
		customer3.setAddress("satara");
		
		List<Customer>list= new ArrayList<Customer>();
		
		list.add(customer1);
		list.add(customer2);
		list.add(customer3);
		
		
		String className="com.mysql.cj.jdbc.Driver";
		Class.forName(className);
		
		String url="jdbc:mysql://localHost:3306/customerdb";
		String user="root";
		String password="root";
		
		Connection connection= DriverManager.getConnection(url, user, password);
		
		String sql="INSERT INTO CUSTOMER(id,name,phone,address) VALUES(?,?,?,?)";
		
		PreparedStatement preparedStatement= connection.prepareStatement(sql);
		
		for (Customer customer : list) {
			preparedStatement.setInt(1,customer.getId());
			preparedStatement.setString(2, customer.getName());
			preparedStatement.setLong(3, customer.getPhone());
			preparedStatement.setString(4, customer.getAddress());		
			
			preparedStatement.addBatch();
			
		}
		preparedStatement.executeBatch();
		System.out.println("Batch Executed");
		connection.close();
	}
	
}

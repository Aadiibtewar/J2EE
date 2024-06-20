package onetomany_uni.controller;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import onetomany_uni.dao.CompanyDao;
import onetomany_uni.dto.Company;
import onetomany_uni.dto.Employee;

public class Main {
	public static void main(String[] args) {
//		Employee employee1=new Employee();
//		employee1.setId(4);
//		employee1.setName("kachara");
//		employee1.setPhone(7788996655l);
//		employee1.setAddress("Mumbai");
//		Employee employee2=new Employee();
//		employee2.setId(5);
//		employee2.setName("bandya");
//		employee2.setPhone(9988996655l);
//		employee2.setAddress("Thane");
//		Employee employee3=new Employee();
//		employee3.setId(6);
//		employee3.setName("manav");
//		employee3.setPhone(8888996655l);
//		employee3.setAddress("Pune");
//		
//		List<Employee>list= new ArrayList<Employee>();
//		list.add(employee1);
//		list.add(employee2);
//		list.add(employee3);
//		
//		
//		Company company = new Company();
//		company.setId(101);
//		company.setName("Epam");
//		company.setLocation("Hydrabad");
//		company.setList(list);
////		
//		EntityManagerFactory factory=Persistence.createEntityManagerFactory("aadi");
//		EntityManager manager= factory.createEntityManager();
//		EntityTransaction transaction=manager.getTransaction();
//		
//		transaction.begin();
//		manager.persist(employee1);
//		manager.persist(employee2);
//		manager.persist(employee3);
//		manager.persist(company);
//		
//		transaction.commit();
//		System.out.println("saved sussessfully");
		
		
		CompanyDao dao =new CompanyDao();
	//	dao.saveCompany(company);
		//dao.deleteCompany(101);
		
		Employee employee=new Employee();
		employee.setId(7);
		employee.setName("ramesh");
		employee.setPhone(9874563210l);
		employee.setAddress("satara");
		
		dao.addEmployee(employee, 101);
//		
	}
}

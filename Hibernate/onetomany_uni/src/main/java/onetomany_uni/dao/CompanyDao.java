package onetomany_uni.dao;

import java.util.List;
import java.util.Scanner;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import onetomany_uni.dto.Company;
import onetomany_uni.dto.Employee;

public class CompanyDao {
	EntityManagerFactory factory=Persistence.createEntityManagerFactory("aadi");
	EntityManager manager= factory.createEntityManager();
	EntityTransaction transaction=manager.getTransaction();
	
	public void saveCompany(Company company) {
		List<Employee>list=company.getList();
		transaction.begin();
		for (Employee employee:list) {
			manager.persist(employee);
		}
		manager.persist(company);
		
		transaction.commit();
		
		System.out.println("saved");
	}
	
	public void deleteCompany(int id) {
		Company company =manager.find(Company.class, id);
		
		if (company!=null) {
			List<Employee>list=company.getList();
			transaction.begin();
			for (Employee employee:list) {
				manager.remove(employee);
			}
			manager.remove(company);
			
			transaction.commit();
		}
		else {
			System.out.println("id not found");
		}
	}
	public void updateCompany(int id) {
		Company company =manager.find(Company.class, id);
		
		if (company!=null) {
			List<Employee>list=company.getList();
			transaction.begin();
			for (Employee employee:list) {
				manager.merge(employee);
			}
			manager.merge(company);
			
			transaction.commit();
		}
		else {
			System.out.println("id not found");
		}
	}
	public Company findData(int id) {
		Company company =manager.find(Company.class, id);
		return company;
	}
	
	public void addEmployee(Employee employee,int id) {
		Company company =manager.find(Company.class, id);
		
		if(company !=null) {
			company.getList().add(employee);
			transaction.begin();
			manager.persist(employee);
			transaction.commit();
			
		}
		else {
			System.out.println("id not found!!");
		}
		
	}
	public void addMultipleEmp(List<Employee>list,int id) {
		Company company=findData(id);
		
		if (company!=null) {
			company.getList().add((Employee) list);
			transaction.begin();
			manager.persist(list);
			transaction.commit();
			
		}
		else {
			System.out.println("id not found!!");
		}
		
	}
}	












package manytomany_uni.controller;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import manytomany_uni.dao.UserDao;
import manytomany_uni.dto.Application;
import manytomany_uni.dto.User;

public class Main {
	public static void main(String[] args) {
		
//		Application application1 = new Application();
//		application1.setId(101);
//		application1.setName("Facebook");
//		application1.setCompany("Meta");
//		
//		Application application2 = new Application();
//		application2.setId(102);
//		application2.setName("Instagram");
//		application2.setCompany("Meta");
//		
//		Application application3 = new Application();
//		application3.setId(103);
//		application3.setName("What'sapp");
//		application3.setCompany("Meta");
//		
//		Application application4 = new Application();
//		application4.setId(104);
//		application4.setName("Snapchat");
//		application4.setCompany("Snap");
//		
//		List<Application> li1=new ArrayList<Application>();
//		li1.add(application2);
//		li1.add(application3);
//		
//		List<Application> li2=new ArrayList<Application>();
//		li2.add(application1);
//		li2.add(application2);
//		li2.add(application3);
//		li2.add(application4);
//		
//		List<Application> li3=new ArrayList<Application>();
//		li3.add(application1);
//		li3.add(application3);
//		li3.add(application4);
//		
//		User user1 = new User();
//		user1.setId(1);
//		user1.setName("Raju");
//		user1.setPhone(9876543210l);
//		user1.setAddress("pune");
//		user1.setList(li1);
//		
//		User user2 = new User();
//		user2.setId(2);
//		user2.setName("Shyam");
//		user2.setPhone(9976543210l);
//		user2.setAddress("mumbai");
//		user2.setList(li2);
//		
//		User user3 = new User();
//		user3.setId(3);
//		user3.setName("Baburao");
//		user3.setPhone(8876543210l);
//		user3.setAddress("satara");
//		user3.setList(li3);
//		
//		EntityManagerFactory factory=Persistence.createEntityManagerFactory("aadi");
//		EntityManager manager = factory.createEntityManager();
//		EntityTransaction transaction =manager.getTransaction();
//		 
//		transaction.begin();
//		
//		manager.persist(application1);
//		manager.persist(application2);
//		manager.persist(application3);
//		manager.persist(application4);
//		manager.persist(user1);
//		manager.persist(user2);
//		manager.persist(user3);
//		transaction.commit();
		
		
		
		UserDao dao =new UserDao();
		//System.out.println(dao.findData(1));
		
		dao.delete(1);
		
		User user4=new User();
		user4.setId(2);
		user.set
		
		dao.saveData();
	
		
	
	}
}

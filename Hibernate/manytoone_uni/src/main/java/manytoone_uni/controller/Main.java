package manytoone_uni.controller;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import manytoone_uni.dao.StudentDao;
import manytoone_uni.dto.College;
import manytoone_uni.dto.Student;

public class Main {
	public static void main(String[] args) {
		StudentDao dao =new StudentDao();
		College college =new College();
		college.setId(101);
		college.setName("FC");
		college.setFees(100000);
		
		
//		Student student1 = new Student();
//		
//		student1.setId(1);
//		student1.setName("Raju");
//		student1.setPhone(9876543210l);
//		student1.setAddress("Pune");
//		student1.setCollege(college);
//		
//		Student student2 = new Student();
//		
//		student2.setId(2);
//		student2.setName("Shyam");
//		student2.setPhone(8876543210l);
//		student2.setAddress("Mumbai");
//		student2.setCollege(college);
//		
//		Student student3 = new Student();
//		
//		student3.setId(3);
//		student3.setName("Baburao");
//		student3.setPhone(7776543210l);
//		student3.setAddress("Thane");
//		student3.setCollege(college);
		
//		List<Student> list= new ArrayList<Student>();
//		list.add(student1);
//		list.add(student2);
//		list.add(student3);
//		
//		EntityManagerFactory factory=Persistence.createEntityManagerFactory("aadi");
//		EntityManager manager = factory.createEntityManager();
//		EntityTransaction transaction =manager.getTransaction();
//		 
//		transaction.begin();
//		
//		manager.persist(college);
//		manager.persist(student1);
//		manager.persist(student2);
//		manager.persist(student3);
//		transaction.commit();
//		
		Student student4=new Student();
		student4.setId(4);
		student4.setName("Bheem");
		student4.setPhone(7744556699l);
		student4.setAddress("Dholakpur");
		student4.setCollege(college);
		
//		dao.saveData(student4);
		
//		System.out.println(dao.findStudent(1));
		
//		dao.removeStudent(3);
		
		Student student5=new Student();
		student5.setId(1);
		student5.setName("rajesh");
		student5.setPhone(7777444411l);
		student5.setAddress("pune");
		student5.setCollege(college);
		dao.updateStu(1, student5);
	}
}

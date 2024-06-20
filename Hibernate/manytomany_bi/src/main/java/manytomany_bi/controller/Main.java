package manytomany_bi.controller;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import manytomany_bi.dto.Course;
import manytomany_bi.dto.Student;

public class Main {

	public static void main(String[] args) {
		
		Student student1 = new Student();
		student1.setName("Raja");
		student1.setPhone(7894561230l);
		student1.setAddress("Pune");
		
		Student student2 = new Student();
		student2.setName("ravi");
		student2.setPhone(7894561230l);
		student2.setAddress("Mumbai");
		
		Student student3 = new Student();
		student3.setName("Raja");
		student3.setPhone(7894561230l);
		student3.setAddress("Pune");
		
		
		Course course1 = new Course();
		course1.setName("SQL");
		course1.setFees(8000);
		course1.setDuration(1.5);

		List<Student>ls1 = new ArrayList<Student>();
		ls1.add(student1);
		ls1.add(student2);
		ls1.add(student3);
		course1.setStudents(ls1);
		
		
		Course course2 = new Course();
		course2.setName("Java");
		course2.setFees(10000);
		course2.setDuration(4);

		List<Student>ls2 = new ArrayList<Student>();
		ls2.add(student1);
		ls2.add(student2);
		ls2.add(student3);
		course2.setStudents(ls2);
		
		Course course3 = new Course();
		course3.setName("Manual Tesing");
		course3.setFees(8000);
		course3.setDuration(2.5);

		List<Student>ls3 = new ArrayList<Student>();
		
		ls3.add(student2);
		ls3.add(student3);
	
		
		Course course4 = new Course();
		course4.setName("SQL");
		course4.setFees(8000);
		course4.setDuration(1.5);

		List<Student>ls4 = new ArrayList<Student>();
		ls1.add(student1);
	
		ls1.add(student3);
		course4.setStudents(ls1);
		
		List<Course>lc1= new ArrayList<Course>();
		lc1.add(course1);
		lc1.add(course2);
		lc1.add(course4);
		student1.setCourses(lc1);
		
		List<Course>lc2= new ArrayList<Course>();
		lc2.add(course1);
		lc2.add(course2);
		lc2.add(course3);
		student2.setCourses(lc2);
		
		List<Course>lc3= new ArrayList<Course>();
		lc3.add(course1);
		lc3.add(course2);
		lc3.add(course2);
		lc3.add(course4);
		student3.setCourses(lc3);
		
		EntityManagerFactory factory=Persistence.createEntityManagerFactory("aadi");
		EntityManager manager = factory.createEntityManager();
		EntityTransaction transaction =manager.getTransaction();
		
		transaction.begin();
		manager.persist(student1);
		manager.persist(student2);
		manager.persist(student3);
		manager.persist(course1);
		manager.persist(course2);
		manager.persist(course3);
		manager.persist(course4);
		transaction.commit();
		
		
		
		
		
	}
}

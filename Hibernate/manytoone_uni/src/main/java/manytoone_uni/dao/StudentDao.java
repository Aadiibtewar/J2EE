package manytoone_uni.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import manytoone_uni.dto.College;
import manytoone_uni.dto.Student;

public class StudentDao {
	EntityManagerFactory factory=Persistence.createEntityManagerFactory("aadi");
	EntityManager manager = factory.createEntityManager();
	EntityTransaction transaction =manager.getTransaction();
	
	public void saveData(Student student) {
		
		College college =new College();
		
		transaction.begin();
		manager.persist(college);
		manager.persist(student);
		transaction.commit();
		
		System.out.println("Data Added!!");
		
	}
	
	public Student findStudent(int id) {
		
		Student student= manager.find(Student.class, id);
		
		return student;
	}
	
	public void removeStudent(int id) {
		Student student=findStudent(id);
		if (student!=null) {
			transaction.begin();
			
			manager.remove(student);
			transaction.commit();
		}
		else {
			System.out.println("id not found!!");
		}
	}
	
	public void updateStu(int id,Student student) {
		Student dbstudent=findStudent(id);
		if (student!=null) {
			transaction.begin();
			
			manager.merge(student);
			transaction.commit();
		}
		
	}
	
	
	
}

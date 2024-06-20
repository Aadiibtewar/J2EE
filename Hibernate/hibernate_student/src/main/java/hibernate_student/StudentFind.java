package hibernate_student;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class StudentFind {
	public static void main(String[] args) {
		EntityManagerFactory factory = Persistence.createEntityManagerFactory("aadi");
		EntityManager manager= factory.createEntityManager();
		
		Student findStud= manager.find(Student.class, 1);
		 if (findStud!=null) {
			 System.out.println(findStud);
		 }
		 else {
			 System.out.println("id not found!");
		 }
	}
}

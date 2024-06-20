package hibernate_student;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

public class StudentDelete {
	public static void main(String[] args) {
		
		EntityManagerFactory factory = Persistence.createEntityManagerFactory("aadi");
		
		EntityManager  manager = factory.createEntityManager();
		
		EntityTransaction transaction = manager.getTransaction();
		
		Student findStud= manager.find(Student.class,1);
		
		if (findStud!=null) {
			transaction.begin();
			manager.remove(findStud);;
			transaction.commit();
			
		}
		else {
			System.out.println("id not found");
		}
	}
}

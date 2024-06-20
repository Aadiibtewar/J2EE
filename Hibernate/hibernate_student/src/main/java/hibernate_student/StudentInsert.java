package hibernate_student;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

public class StudentInsert {

	public static void main(String[] args) {
		Student student = new Student();
		student.setId(3);
		student.setName("shaym");
		student.setPhone(7776543210l);
		student.setMarks(70);
		student.setAddress("pune");
		
		EntityManagerFactory factory=Persistence.createEntityManagerFactory("aadi");
		EntityManager manager= factory.createEntityManager();
		EntityTransaction transaction = manager.getTransaction();
		
		transaction.begin();
		manager.persist(student);
		
		transaction.commit();
	}
}

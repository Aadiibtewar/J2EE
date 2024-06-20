package hibernate_student;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

public class StudentUpdate {

	public static void main(String[] args) {
		
		Student student= new Student();
		
		student.setId(1);
		student.setName("ravi");
		student.setPhone(9876543210l);
		student.setMarks(78);
		student.setAddress("nigdi");
		
		EntityManagerFactory factory = Persistence.createEntityManagerFactory("aadi");
		
		EntityManager  manager = factory.createEntityManager();
		
		EntityTransaction transaction = manager.getTransaction();
		
		Student findStud= manager.find(Student.class,1);
		
		if (findStud!=null) {
			transaction.begin();
			manager.merge(student);
			transaction.commit();
			
		}
		else {
			System.out.println("id not found");
		}
	}
}

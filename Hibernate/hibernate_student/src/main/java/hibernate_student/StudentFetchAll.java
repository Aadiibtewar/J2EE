package hibernate_student;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;



public class StudentFetchAll {
	public static void main(String[] args) {
		EntityManagerFactory factory = Persistence.createEntityManagerFactory("aadi");
		EntityManager manager=factory.createEntityManager();
		
		
		Query query = manager.createQuery("SELECT e FROM Student e");
		
		List<Student> list = query.getResultList();
		
		System.out.println(list);
	}
}

package hibernate_person.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;


import hibernate_person.dto.Person;

public class PersonDao {
	public EntityManager getEntityManager() {
		return Persistence.createEntityManagerFactory("aadi").createEntityManager();
	}
	
	public void savePerson(Person person) {
		EntityManager manager=getEntityManager();
		EntityTransaction transaction =  manager.getTransaction();
		transaction.begin();
		manager.persist(person);
		transaction.commit();
		
		
	}
	
	public Person getPerson(String email) {
		EntityManager manager=getEntityManager();
		Query query= manager.createQuery("SELECT e FROM Person e WHERE e.email=?1");
		query.setParameter(1, email);
		try {
			Person person = (Person) query.getSingleResult();
			return person;
		} catch (Exception e) {
			return null;
		}
		
	}
	
	public void updatePerson(Person person) {
		EntityManager manager=getEntityManager();
		EntityTransaction transaction =  manager.getTransaction();
		
		Person findPerson= manager.find(Person.class, person.getId());
		
		if(findPerson!=null) {
			transaction.begin();
			manager.merge(person);
			transaction.commit();
			System.out.println("update succesfully");
		}else {
			System.out.println("Id not found");;
		}
		
	}
	public Person findById(int id) {
		EntityManager manager=getEntityManager();
		Person findPerson=manager.find(Person.class , id);
		if (findPerson !=null) {
		
			
			return findPerson;
		}
		else {
			return null;
		}
		
	}
	public Person findByPhone(Long phone) {
		EntityManager manager=getEntityManager();
		
		Query query= manager.createQuery("SELECT e FROM Person e WHERE e.phone=?1");
				query.setParameter(1, phone);
		try {
				return (Person) query.getSingleResult();
		} catch (Exception e) {
			return null;
		}
	}
	public List<Person>  findByName(String name) {
		EntityManager manager=getEntityManager();
		
		Query query= manager.createQuery("SELECT e FROM Person e WHERE e.name=?1");
				query.setParameter(1, name);
		try {
			List<Person> list = query.getResultList();
			return list;
		} catch (Exception e) {
			return null;
		}
	}
	
	public int deleteById(int id) {
		EntityManager manager=getEntityManager();
		EntityTransaction transaction =  manager.getTransaction();
		Person findPerson=manager.find(Person.class , id);
		if (findPerson !=null) {
			transaction.begin();
			manager.remove(findPerson);
			transaction.commit();
			return 1;
		}
		else {
			return 0;
		}
	}

	public void deleteByEmail(String email) {
		EntityManager manager=getEntityManager();
		EntityTransaction transaction =  manager.getTransaction();
		
		
		Query query=manager.createQuery("Select e from Person e where e.email=?1").setParameter(1, email);
		
		if (query.getSingleResult()!=null) {
			transaction.begin();
			manager.remove(query.getSingleResult());
			transaction.commit();
			
		}
		else {
			System.out.println("Email not found");
		}
	}
	
	public void deleteByPhone(Long phone) {
		EntityManager manager=getEntityManager();
		EntityTransaction transaction =  manager.getTransaction();
		
		
		Query query=manager.createQuery("Select e from Person e where e.phone=?1").setParameter(1, phone);
		
		if (query.getSingleResult()!=null) {
			transaction.begin();
			manager.remove(query.getSingleResult());
			transaction.commit();
			System.out.println("deleted succesfully!");
			
		}
		else {
			System.out.println("phone number not found");
		}
	}
}

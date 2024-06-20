package manytomany_uni.dao;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;

import manytomany_uni.dto.User;

public class UserDao {
	EntityManagerFactory factory=Persistence.createEntityManagerFactory("aadi");
	EntityManager manager = factory.createEntityManager();
	EntityTransaction transaction =manager.getTransaction();
	
	public void saveData(User user) {
		transaction.begin();
		manager.persist(user);
		transaction.commit();
		System.out.println("data added");
	}
	
	public User findData(int id) {
	
		User user = manager.find(User.class, id);
		return user;
	}
	
	public void delete(int id) {
		User user = findData(id);
		if (user != null) {
			transaction.begin();
			manager.remove(user);
			
			transaction.commit();
			System.out.println("deleted!!");
		}
		else {
			System.out.println("Id not found");
		}
		
	}
	public void update(int id,User user) {
		User user2=findData(id);
		if (user2!=null) {
			transaction.begin();
			manager.merge(user);
			
			transaction.commit();
		}
	}
	
	
}

package manytomany_uni.controller;

import javax.persistence.EntityManager;
import javax.persistence.Persistence;

import manytomany_uni.dto.User;


public class FetchExample {
	public static void main(String[] args) {
		

		EntityManager manager =Persistence.createEntityManagerFactory("aadi").createEntityManager();
		
		manager.find(User.class, 2);	// Default  FetctType is Lazy
		
		
	}
}

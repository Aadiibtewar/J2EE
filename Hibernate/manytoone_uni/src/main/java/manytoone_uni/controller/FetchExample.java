package manytoone_uni.controller;

import javax.persistence.EntityManager;
import javax.persistence.Persistence;

import manytoone_uni.dto.Student;

public class FetchExample {
	public static void main(String[] args) {
		
		EntityManager manager =Persistence.createEntityManagerFactory("aadi").createEntityManager();
		
		manager.find(Student.class, 1);// Default FetchType id Eager
		
		
		
	}
}

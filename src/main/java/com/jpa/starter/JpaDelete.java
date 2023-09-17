package com.jpa.starter;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

public class JpaDelete {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("myApp");
		EntityManager em = emf.createEntityManager();
		Employee emp = em.find(Employee.class, 3);
		
		EntityTransaction et=em.getTransaction();
		et.begin();	
		
		//If not specified cascade at reverse mapping then throw error else it's fine
		em.remove(emp);
		
		et.commit();
		em.close();
		emf.close();
	}

}

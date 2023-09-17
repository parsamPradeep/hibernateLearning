package com.jpa.starter;

import java.util.Arrays;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

public class JpaUpdate {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("myApp");
		EntityManager em = emf.createEntityManager();
		Employee emp = em.find(Employee.class, 4);
		EmployeeGroup eg1=em.find(EmployeeGroup.class, 7);
		EmployeeGroup eg2=em.find(EmployeeGroup.class, 8);
		
		emp.setEmployeeGroup(Arrays.asList(eg1, eg2));
		eg1.setEmployee(Arrays.asList(emp));
		eg2.setEmployee(Arrays.asList(emp));
		
		EntityTransaction et=em.getTransaction();
		et.begin();	
		
		em.persist(emp);
		em.persist(eg1);
		em.persist(eg2);
		
		et.commit();
		em.close();
		emf.close();
	}

}

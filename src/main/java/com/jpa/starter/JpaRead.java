package com.jpa.starter;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class JpaRead {

	public static void main(String[] args) {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("myApp");
		EntityManager em = emf.createEntityManager();
		Employee emp = em.find(Employee.class, 3);
		System.out.println("***************Fetching emp*********************");
		System.out.println(emp);
		System.out.println("***************Fetching payslip*********************");
		//PaySlip ac = em.find(PaySlip.class, 5);
		System.out.println(emp.getEmployeeGroup());
		em.close();
		emf.close();
	}

}

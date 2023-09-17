package com.jpa.starter;

import java.util.Arrays;
import java.util.Date;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

public class JpaStarterWrite {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		AccessCard ac1 = new AccessCard();
		ac1.setDateOfActive(new Date());
		ac1.setActive(true);

		AccessCard ac2 = new AccessCard();
		ac2.setDateOfActive(new Date());
		ac2.setActive(false);

		Employee emp = new Employee();
		emp.setName("Pradeep");
		emp.setEmpType(EmployeeType.FULL_TIME);
		emp.setAge(26);

		Employee emp2 = new Employee();
		emp2.setName("Virat");
		emp2.setEmpType(EmployeeType.PART_TIME);
		emp2.setAge(27);

		PaySlip payslip1 = new PaySlip();
		payslip1.setPaySlipDate(new Date());
		payslip1.setSalary(10000);

		PaySlip payslip2 = new PaySlip();
		payslip2.setPaySlipDate(new Date());
		payslip2.setSalary(20000);
		
		EmployeeGroup eg1=new EmployeeGroup();
		eg1.setName("Group1");
		
		EmployeeGroup eg2=new EmployeeGroup();
		eg2.setName("Group2");

		emp.setAccessCard(ac1);
		ac1.setOwner(emp);

		emp2.setAccessCard(ac2);
		ac2.setOwner(emp2);
		
		payslip1.setEmploye(emp);
		payslip2.setEmploye(emp);
		
		emp.setPaySlip(Arrays.asList(payslip1, payslip2));
		//emp2.setPaySlip(Arrays.asList(payslip2));
		
		eg1.setEmployee(Arrays.asList(emp));
		eg2.setEmployee(Arrays.asList(emp));
		
		emp.setEmployeeGroup(Arrays.asList(eg1, eg2));
		//emp2.setEmployeeGroup(Arrays.asList(eg1, eg2));
		
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("myApp");
		EntityManager em = emf.createEntityManager();
		EntityTransaction et = em.getTransaction();
		et.begin();
		em.persist(ac1);
		em.persist(ac2);

		em.persist(emp);
		em.persist(emp2);
		
		em.persist(payslip2);
		em.persist(payslip1);
		
		em.persist(eg1);
		em.persist(eg2);
		
		et.commit();
		em.close();
		emf.close();
	}

}
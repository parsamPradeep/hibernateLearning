package com.jpa.starter;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class PaySlip {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	private Date paySlipDate;
	private float salary;
	@ManyToOne
	@JoinColumn(name = "payslipFor")
	private Employee employe;



	public Employee getEmploye() {
		return employe;
	}

	public void setEmploye(Employee employee) {
		this.employe = employee;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Date getPaySlipDate() {
		return paySlipDate;
	}

	public void setPaySlipDate(Date paySlipDate) {
		this.paySlipDate = paySlipDate;
	}

	public float getSalary() {
		return salary;
	}

	public void setSalary(float salaty) {
		this.salary = salaty;
	}

	@Override
	public String toString() {
		return "PaySlip [id=" + id + ", paySlipDate=" + paySlipDate + ", salary=" + salary + "]";
	}


}

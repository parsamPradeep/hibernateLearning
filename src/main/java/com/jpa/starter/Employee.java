package com.jpa.starter;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Transient;

@Entity
@Table(name = "EMPLOYEE_DATA")
public class Employee {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	
	private String name;
	
	private int age;
	
	//Default is Ordinal
	@Enumerated(EnumType.STRING)
	EmployeeType empType;
	
	//In one-to-one always FetchType is Eager by default
	@OneToOne
	AccessCard accessCard;
	
	@Transient
	private String debugId;
	
	//Do not add in to toString() it will cause stackoverflow error
	//cascading used to do delete/save automatically in referenced relation too else throw Referential integrity error
	//In one-to-many always FetchType is Lazy by default
	@OneToMany(mappedBy = "employe", cascade = {CascadeType.REMOVE,CascadeType.PERSIST})
	private List<PaySlip> paySlip;
	
	//Do not add in to toString() it will cause stackoverflow error
	//JoingColumn used to rename the relationship table and also column if required
	//In many-to-many always FetchType is Lazy by default
	// In many-to-many we can have mappedBy in any one side of the relation, this doesn't cause any problem 
	@ManyToMany
	@JoinTable(name = "EMAIL_GROUP_LIST", joinColumns = @JoinColumn(name = "EMPLOYEE_ID"), inverseJoinColumns = @JoinColumn(name = "GROUP_ID"))
	private List<EmployeeGroup> employeeGroup;

	public List<EmployeeGroup> getEmployeeGroup() {
		return employeeGroup;
	}

	public void setEmployeeGroup(List<EmployeeGroup> employeeGroup) {
		this.employeeGroup = employeeGroup;
	}

	public List<PaySlip> getPaySlip() {
		return paySlip;
	}

	public void setPaySlip(List<PaySlip> paySlip) {
		this.paySlip = paySlip;
	}

	@Override
	public String toString() {
		return "Employee [id=" + id + ", name=" + name + ", age=" + age + ", empType=" + empType + ", accessCard="
				+ accessCard + "]";
	}

	public AccessCard getAccessCard() {
		return accessCard;
	}

	public void setAccessCard(AccessCard accessCard) {
		this.accessCard = accessCard;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public EmployeeType getEmpType() {
		return empType;
	}

	public void setEmpType(EmployeeType empType) {
		this.empType = empType;
	}

	public long getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

}

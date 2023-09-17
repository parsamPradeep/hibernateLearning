package com.jpa.starter;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;

@Entity
public class AccessCard {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	private Date dateOfActive;
	private boolean isActive;
	@OneToOne(mappedBy = "accessCard")
	private Employee owner;

	public Employee getOwner() {
		return owner;
	}

	public void setOwner(Employee owner) {
		this.owner = owner;
	}

	@Override
	public String toString() {
		return "AccessCard [id=" + id + ", dateOfActive=" + dateOfActive + ", isActive=" + isActive + "]";
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Date getDateOfActive() {
		return dateOfActive;
	}

	public void setDateOfActive(Date dateOfActive) {
		this.dateOfActive = dateOfActive;
	}

	public boolean isActive() {
		return isActive;
	}

	public void setActive(boolean isActive) {
		this.isActive = isActive;
	}

}

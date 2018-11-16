package com.HibernateList;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

public class Employee {

	   private int id;
	   private String firstName; 
	   private String lastName;   
	   private int salary;
	   @SuppressWarnings("rawtypes")
	   private List certificates;
	   
	   public Employee() {}
	   public Employee(String firstName, String lastName, int salary) {
		this.firstName = firstName;
		this.lastName = lastName;
		this.salary = salary;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public int getSalary() {
		return salary;
	}
	public void setSalary(int salary) {
		this.salary = salary;
	}
	@SuppressWarnings("rawtypes")
	public List getCertificates() {
		return certificates;
	}
	@SuppressWarnings("rawtypes")
	public void setCertificates(List cert) {
		this.certificates = cert;
	}
	
}

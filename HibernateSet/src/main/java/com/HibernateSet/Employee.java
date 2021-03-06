package com.HibernateSet;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class Employee {

	   private int id;
	   private String firstName; 
	   private String lastName;   
	   private int salary;
	   @SuppressWarnings("rawtypes")
	   private Map certificates;
	   
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
	public Map getCertificates() {
		return certificates;
	}
	@SuppressWarnings("rawtypes")
	public void setCertificates(Map certificates) {
		this.certificates = certificates;
	}
	
}

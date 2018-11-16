package com.HibernateList;

import java.util.*;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class ManageEmployee {
	private static SessionFactory factory;
	@SuppressWarnings({ "unchecked", "rawtypes", "unused" })
	public static void main(String[] args) {
		try {
			factory = new Configuration().configure().buildSessionFactory();
		}catch(Throwable ex){
			System.err.println("Failed to create sessionFactory object." + ex);
	         throw new ExceptionInInitializerError(ex); 
		}
		ManageEmployee ME = new ManageEmployee();
		/*adding certificates*/
		List set1 = new ArrayList();
		set1.add(new Certificate("BA"));
		set1.add(new Certificate("MBA"));
		set1.add(new Certificate("ACA"));
		/*adding another certificate set*/
		ArrayList set2 = new ArrayList();
	      set2.add(new Certificate("BCA"));
	      set2.add(new Certificate("BA"));
	      
	      Integer empID1 = ME.addEmployee("Manoj", "Kumar", 4000, set1);
	      Integer empID2 = ME.addEmployee("Dilip", "Kumar", 3000, set2);
	      Integer empID3 = ME.addEmployee("Abhaz", "patel", 4500, set1);
	      Integer empID4 = ME.addEmployee("bhaba", "aadio", 4500, set1);
/*		 List down all the employees */
	      ME.listEmployees();

	      /* Update employee's salary records */
	      ME.updateEmployee(empID1, 5000);

	      // Delete an employee from the database 
	     // ME.deleteEmployee(empID2);

	      // List down all the employees 
	      ME.listEmployees();
	}
	
	@SuppressWarnings("rawtypes")
	public Integer addEmployee(String fname, String lname, int salary, List cert)
	{
		Session session = factory.openSession();
		Transaction tx = null;
		Integer EmployeeID = null;
		try {
			tx=session.beginTransaction();
			Employee emp = new Employee(fname,lname,salary);
			emp.setCertificates(cert);
			EmployeeID = (Integer) session.save(emp);
			tx.commit();
			
		}catch(HibernateException ex) {
			if(tx!=null) tx.rollback();
			ex.printStackTrace();
		}finally {
			session.close();
		}
		return EmployeeID;
	}
	@SuppressWarnings("rawtypes")
	public void listEmployees( ){
	      Session session = factory.openSession();
	      Transaction tx = null;
	      try {
	         tx = session.beginTransaction();
	         List employees = session.createQuery("FROM Employee").list(); 
	         for (Iterator iterator1 = employees.iterator(); iterator1.hasNext();){
	            Employee employee = (Employee) iterator1.next(); 
	            System.out.print("First Name: " + employee.getFirstName()); 
	            System.out.print("  Last Name: " + employee.getLastName()); 
	            System.out.println("  Salary: " + employee.getSalary());
	            List certificates = employee.getCertificates();
	            for (Iterator iterator2 = certificates.iterator(); iterator2.hasNext();){
	               Certificate certName = (Certificate) iterator2.next(); 
	               System.out.println("Certificate: " + certName.getName()); 
	            }
	         }
	         tx.commit();
	      } catch (HibernateException e) {
	         if (tx!=null) tx.rollback();
	         e.printStackTrace(); 
	      } finally {
	         session.close(); 
	      }
	   }
	  /* Method to update salary for an employee */
	   public void updateEmployee(Integer EmployeeID, int salary ){
	      Session session = factory.openSession();
	      Transaction tx = null;
	      
	      try {
	         tx = session.beginTransaction();
	         Employee employee = (Employee)session.get(Employee.class, EmployeeID); 
	         employee.setSalary( salary );
	         session.update(employee);
	         tx.commit();
	      } catch (HibernateException e) {
	         if (tx!=null) tx.rollback();
	         e.printStackTrace(); 
	      } finally {
	         session.close(); 
	      }
	   }
	   
	   /* Method to delete an employee from the records */
	   public void deleteEmployee(Integer EmployeeID){
	      Session session = factory.openSession();
	      Transaction tx = null;
	      
	      try {
	         tx = session.beginTransaction();
	         Employee employee = (Employee)session.get(Employee.class, EmployeeID); 
	         session.delete(employee); 
	         tx.commit();
	      } catch (HibernateException e) {
	         if (tx!=null) tx.rollback();
	         e.printStackTrace(); 
	      } finally {
	         session.close(); 
	      }
	   }
	
}

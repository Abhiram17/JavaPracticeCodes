package com.HibernateChacheBatch_T;
import java.util.*; 
 
import org.hibernate.HibernateException;
import org.hibernate.ScrollableResults;
import org.hibernate.Session; 
import org.hibernate.Transaction;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;


public class ManageEmployee {
   private static SessionFactory factory; 
   public static void main(String[] args) {
      
      try {
         factory = new Configuration().configure().buildSessionFactory();
      } catch (Throwable ex) { 
         System.err.println("Failed to create sessionFactory object." + ex);
         throw new ExceptionInInitializerError(ex); 
      }
      ManageEmployee ME = new ManageEmployee();

      /* Add employee records in batches */
     // ME.addEmployees( );
      ME.listEmployees();
      
   }
   
   @SuppressWarnings("rawtypes")
private void listEmployees() {
	   Session session = factory.openSession();
	   Transaction tx = session.beginTransaction();

	   List result =  session.createQuery("FROM Employee").list();
	   int count = 0;

	   for(Iterator iterator = result.iterator(); iterator.hasNext();)
	   {
		   Employee employee = (com.HibernateChacheBatch_T.Employee) iterator.next();
           System.out.print("First Name: " + employee.getFirstName()+"\t"); 
           System.out.println("  Last Name: " + employee.getLastName());
           if ( ++count % 50 == 0 ) {
        	      session.flush();
        	      session.clear();
        	      System.out.println("");
        	   }
	   }
	   tx.commit();
	   session.close();
	
}

/* Method to create employee records in batches */
   public void addEmployees( ){
      Session session = factory.openSession();
      Transaction tx = null;
      Integer employeeID = null;
      
      try {
         tx = session.beginTransaction();
         for ( int i=0; i<100000; i++ ) {
            String fname = "First Name " + i;
            String lname = "Last Name " + i;
            Integer salary = i;
            Employee employee = new Employee(fname, lname, salary);
            session.save(employee);
         	/*if( i % 50 == 0 ) {
               session.flush();
               session.clear();
            }*/
         }
         tx.commit();
      } catch (HibernateException e) {
         if (tx!=null) tx.rollback();
         e.printStackTrace(); 
      } finally {
         session.close(); 
      }
      return ;
   }
}
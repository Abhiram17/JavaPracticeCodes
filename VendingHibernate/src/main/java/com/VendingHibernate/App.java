package com.VendingHibernate;

import java.util.*;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class App 
{
	private static SessionFactory factory;
	static Scanner s = new Scanner(System.in);
	static int input;
    public static void main( String[] args )
    {
    	try 
    	{
			factory = new Configuration().configure().buildSessionFactory();
		}
    	catch(Throwable ex)
    	{
			System.err.println("Failed to create sessionFactory object." + ex);
	         throw new ExceptionInInitializerError(ex); 
		}
    	//before adding data load initial data to display
    	//initializeData();
    	//System.out.println("its done!!!");
    	//Print menu and take your choice, return choice(input)
    	printMenu();	
    }

	@SuppressWarnings({"unused" })
	private static void initializeData()
	{
		Session session = factory.openSession();
		Transaction tx= null;
		try {
		tx = session.beginTransaction();
		ItemDesc I1 = new ItemDesc("Beer");
		ItemDesc I2 = new ItemDesc("Whiskey");
		ItemDesc I3 = new ItemDesc("Wine");
    	session.persist(I1);
    	session.persist(I2);
    	session.persist(I3);
    	SubItemDesc SI1 = new SubItemDesc("Beer","Lager", 3);
    	SubItemDesc SI2 = new SubItemDesc("Beer","pale ale", 5);
    	session.persist(SI1);
    	session.persist(SI2);
    	SubItemDesc SI3 = new SubItemDesc("Whiskey","Scotch", 8);
    	SubItemDesc SI4 = new SubItemDesc("Whiskey","Bourbon", 9);
    	session.persist(SI3);
    	session.persist(SI4);
    	SubItemDesc SI5 = new SubItemDesc("Wine","Red", 6);
    	SubItemDesc SI6 = new SubItemDesc("Wine","White", 8);
    	session.persist(SI5);
    	session.persist(SI6);
    	tx.commit();
		}
		catch(HibernateException ex) 
		{
			if(tx!=null) tx.rollback();
			ex.printStackTrace();
		}
		finally
		{
			session.close();
			System.out.println("Initialized data");
		}
	}

	@SuppressWarnings({ "rawtypes" })
	private static void addItems(List employees) 
	{
		Session session = factory.openSession();
		Transaction tx= null;
		
		Integer itemNum=null;
		System.out.println("Enter the name of the item");
		String newItem = s.nextLine();
		System.out.println("Enter the number of subItems");
		try
		{
		itemNum = Integer.parseInt(s.nextLine());
		}
		catch(Exception e)
		{
			System.out.println("Error: Enter a valid quantity");
			printErrorMenu();
		}
		if(itemNum>4 || itemNum <=0)
		{
			System.out.println("Error: Cannot add more than 3 sub items or less than 1 sub item");
			printErrorMenu();
		}
		tx = session.beginTransaction();
		ItemDesc newIt = new ItemDesc(newItem);
		for(int i = 1;i<=itemNum;i++)
		{
			System.out.println("Enter the name of item number "+i+ " and enter price after pressing {ENTER}");
			String subName = s.nextLine();
			int subPrice = Integer.parseInt(s.nextLine());
			SubItemDesc SIN = new SubItemDesc(newItem ,subName, subPrice);
			session.persist(SIN);
		}
		session.persist(newIt);		
		tx.commit();
		System.out.println("added items!");
		
	}

	@SuppressWarnings({ "unused", "rawtypes" })
	private static void printMenu()
	{ 
	    Session session = factory.openSession();
	    Transaction tx = null;
	    List employees = null;
		int i = 1;
		
		 try
		    {
		         tx = session.beginTransaction();
		         employees = session.createQuery("FROM com.VendingHibernate.ItemDesc").list(); 
		         System.out.println("Whats your Poision ¥");
		         for (Iterator iterator1 = employees.iterator(); iterator1.hasNext();i++)
		         {
		            ItemDesc itm = (ItemDesc) iterator1.next(); 
		            System.out.println(itm.id +" "+ itm.name); 
		         }
		         System.out.println(employees.size()+1+" Add Items");
		         tx.commit();
		      } catch (HibernateException e) {
		         if (tx!=null) tx.rollback();
		         e.printStackTrace(); 
		      } finally {
		         session.close(); 
		      }		
		String inp = s.nextLine();
		// Catch invalid inputs
		try 
		{
		input = Integer.parseInt(inp);
		}
		catch(Exception e)
		{
			System.out.println("Error: Enter valid inputs");
			printErrorMenu();
		}
		if(input>employees.size()+1 || input<=0) 
		{
			System.out.println("Error: Enter options as displayed in the menu");
			printErrorMenu();
		}
		if(input>employees.size())
		{
    		//add item to existing list of items
        	addItems(employees);
        	try 
        	{
				Thread.sleep(1000);
			} 
        	catch (InterruptedException e) 
        	{
				e.printStackTrace();
			}
        	
        	//returns to printing menu
        	printMenu();
    	}
		else
		{	
    		//Print the sub items depending on the choice
    		printItems(employees);
    	}
	}

	@SuppressWarnings({ "rawtypes", "unused" })
	private static void printItems(List employees) 
	{
		Session session = factory.openSession();
	    Transaction tx = null;
		Integer input1 = null;
		ItemDesc ourItem = (ItemDesc) employees.get(input-1); 
		System.out.println("you chose "+ourItem.name);
		System.out.println("choose one of the below options");
		tx = session.beginTransaction();
		List list = session.createQuery("From SubItemDesc S where S.PName = :nm").setParameter("nm", ourItem.name).list();
		int i=1;
		for(Iterator itr = list.iterator(); itr.hasNext();i++)
		{
				SubItemDesc subItem = (SubItemDesc) itr.next();
				System.out.println(i+". "+subItem.name+" $"+subItem.price);
		}	
		try 
		{	
		input1 = Integer.parseInt(s.nextLine());
		}
		catch(Exception e)
		{
			System.out.println("Error: Enter valid inputs");
			try 
	    	{
				Thread.sleep(1000);
			} 
	    	catch (InterruptedException ee) 
	    	{
				ee.printStackTrace();
			}
			printItems(employees);
		}
		if(input1>list.size() || input1 <=0) 
		{
			System.out.println("Error: Enter options as displayed in the sublist");
			try 
	    	{
				Thread.sleep(1000);
			} 
	    	catch (InterruptedException e) 
	    	{
				e.printStackTrace();
			}
			printItems(employees);
		}
		SubItemDesc itm = (SubItemDesc) list.get(input1-1);
		System.out.println("You chose "+itm.name+ " and it costs $"+itm.price+" for each");
		System.out.println("Enter the amount of "+ itm.name);
		int quant = Integer.parseInt(s.nextLine());
		calculateTotal(input1,itm,quant);
		tx.commit();
	}	

	private static void calculateTotal(int input1, SubItemDesc list, int quant) 
	{
		System.out.println("You chose "+quant+" "+list.name);
		System.out.println("Your Total is "+quant+"x"+list.price+" = $"+(list.price)*quant);
		System.out.println("\n");
		printMenu();	
	}
	
	private static void printErrorMenu() 
	{
		try 
    	{
			Thread.sleep(1000);
		} 
    	catch (InterruptedException e) 
    	{
			e.printStackTrace();
		}
		printMenu();
		
	}
	
}

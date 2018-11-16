package com.VendingM;

import java.util.*;

public class App 
{
	static Map<Integer, ItemDesc> itemList;
	@SuppressWarnings("rawtypes")
	public static Map<String,HashMap> subItemMap;
	static HashMap<Integer,SubItemDesc> subItemList;
	static HashMap<Integer,SubItemDesc> subItemList1;
	static HashMap<Integer,SubItemDesc> subItemList2;
	static Scanner s = new Scanner(System.in);
	static int input;
    public static void main( String[] args )
    {
    	//before adding data load initial data to display
    	initializeData();
    	//Print menu and take your choice, return choice(input)
    	printMenu();	
    }

	@SuppressWarnings({ "unchecked", "rawtypes" })
	private static void initializeData()
	{
		
		itemList = new HashMap<Integer,ItemDesc>();
    	itemList.put(1, new ItemDesc("Beer"));
    	itemList.put(2, new ItemDesc("Whiskey"));
    	itemList.put(3, new ItemDesc("Wine"));
    	subItemMap = new HashMap<String, HashMap>();
    	subItemMap.put(itemList.get(1).name, new HashMap<Integer,SubItemDesc>());
    	subItemMap.put(itemList.get(2).name, new HashMap<Integer,SubItemDesc>());
    	subItemMap.put(itemList.get(3).name, new HashMap<Integer,SubItemDesc>());
    	subItemList = subItemMap.get(itemList.get(1).name);
    	subItemList.put(1, new SubItemDesc("Lager", 3));
    	subItemList.put(2, new SubItemDesc("pale ale", 5));
    	
    	subItemList = subItemMap.get(itemList.get(2).name);
    	subItemList.put(1, new SubItemDesc("Scotch", 8));
    	subItemList.put(2, new SubItemDesc("Bourbon", 9));
    	
    	subItemList = subItemMap.get(itemList.get(3).name);
    	subItemList.put(1, new SubItemDesc("Red", 6));
    	subItemList.put(2, new SubItemDesc("White", 8));
	}

	@SuppressWarnings("unchecked")
	private static void addItems() 
	{
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
		itemList.put((itemList.size())+1, new ItemDesc(newItem));
		subItemMap.put(newItem, new HashMap<Integer,SubItemDesc>());
		subItemList = subItemMap.get(newItem);
		for(int i = 1;i<=itemNum;i++)
		{
			System.out.println("Enter the name of item number "+i+ " and enter price after pressing {ENTER}");
			String subName = s.nextLine();
			int subPrice = Integer.parseInt(s.nextLine());
			subItemList.put(i, new SubItemDesc(subName, subPrice));
		}
		
		System.out.println("added items!");
		
	}

	@SuppressWarnings({ "unused", "unchecked" })
	private static void printMenu()
	{
		int i;
		HashMap<Integer,SubItemDesc> subItemList = (HashMap<Integer, SubItemDesc>) (subItemMap.get((itemList).get(1).name));
		System.out.println("Whats your Poision ¥");
		for(i=1;i<=itemList.size();i++) 
		{
			System.out.println(i+". "+itemList.get(i).name);
		}
		System.out.println(i+". "+"Add items");
		
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
		if(input>itemList.size()+1 || input<=0) 
		{
			System.out.println("Error: Enter options as displayed in the menu");
			printErrorMenu();
		}
		if(input>itemList.size())
		{
    		//add item to existing list of items
        	addItems();
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
    		printItems();
    	}
	}

	@SuppressWarnings({ "unchecked" })
	private static void printItems() 
	{
		Integer input1 = null;
		System.out.println("you chose "+itemList.get(input).name);
		System.out.println("choose one of the below options");
			HashMap<Integer,SubItemDesc> list = subItemMap.get(itemList.get(input).name);
			for(int i =1;i<=list.size();i++) 
			{
			System.out.println(i+". "+(list.get(i)).name+" $"+ (list.get(i)).price);
			}
		try {	
		input1 = Integer.parseInt(s.nextLine());
		}
		catch(Exception e)
		{
			System.out.println("Error: Enter valid inputs");
			printErrorItems();
		}
		if(input1>list.size() || input1 <=0) 
		{
			System.out.println("Error: Enter options as displayed in the sublist");
			printErrorItems();
		}
		System.out.println("You chose "+list.get(input1).name+ " and it costs $"+list.get(input1).price+" for each");
		System.out.println("Enter the amount of "+ list.get(input1).name);
		int quant = Integer.parseInt(s.nextLine());
		calculateTotal(input1,list,quant);	
	}	

	private static void calculateTotal(int input1, HashMap<Integer, SubItemDesc> list, int quant) 
	{
		System.out.println("You chose "+quant+" "+list.get(input1).name);
		System.out.println("Your Total is "+quant+"x"+list.get(input1).price+" = $"+(list.get(input1).price)*quant);
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
	private static void printErrorItems() {
		try 
    	{
			Thread.sleep(1000);
		} 
    	catch (InterruptedException e) 
    	{
			e.printStackTrace();
		}
		printItems();
		
	}
}

import java.util.*;
import java.util.concurrent.TimeUnit;

public class VendingMachine2
{
	//Global Scanner
	static Scanner s = new Scanner(System.in);
	
	//menu
	static List<String> menu = new ArrayList<String>();
	
	// first level
	static Map<Integer, Map<Integer, String>> m1 = new HashMap<>();
	
	// Second level
	static Map<Integer, String> map1 = new HashMap<>();
	static Map<Integer, String> map2 = new HashMap<>();
	static Map<Integer, String> map3 = new HashMap<>();
	
	//Global variable declared to help recall a method
	static double Total;
	static int option ;
	static String data;
	public static void main(String[] args) throws Exception
	{
	// menu Initialization
		
		menu.add("Beer");
		menu.add("Whiskey");
		menu.add("Wine");
		menu.add("Add new item");
		// put level one
		m1.put(1, map1);
		m1.put(2, map2);
		m1.put(3, map3);
		// put level two
		map1.put(1, "Lager -$ 7");
		map1.put(2, "PaleAle -$ 8");
		map2.put(1, "Scotch -$ 23");
		map2.put(2, "Bourbon -$ 30");
		map3.put(1, "White -$ 15");
		map3.put(2, "Red -$ 18");
		// Start code here...
		try {
				printChoice();
			}

			catch (Exception e)
			{
				System.out.println("Check your inputs");
				System.out.println();
				System.out.println();
				TimeUnit.SECONDS.sleep(3);
				printChoice();
				
			}
	}
	//Display's menu and takes user input
	
	private static void printChoice() throws Exception
	{
		int compare=0;
		System.out.println("Choose your item...");
		
		//display menu
		
		for (int i = 0; i <VendingMachine2.menu.size(); i++) {
			System.out.println(i + 1 + ". " + VendingMachine2.menu.get(i));
		}
		
		//Take user Input
		System.out.println("Select an item..");
		String st = s.nextLine();
		try {
			if(st!="") 
			{
				option = Integer.parseInt(st);
				compare=VendingMachine2.menu.size();
			}
			else
			{
				throw new Exception();
			}
			
		} catch (Exception e)
		{
			
			System.out.println("Please Enter the displayed choices..");
			System.out.println();
			TimeUnit.SECONDS.sleep(2);
			printChoice();
		}		
		//Check input and decide whether to add item or display
		try 
		{
			if(option<compare)
			{
				choose(m1, option);
			}
			else if(option==compare)
			{
				addItemName();
			}
			else 
			{
				throw new Exception();
			}
		}
		catch(Exception e) 
		{
			System.out.println("Wrong inputs. Enter inputs as shown...");
			TimeUnit.SECONDS.sleep(3);
			printChoice();
			//throw new Exception();
		}
	}

	//Choose is called if we select an an item to buy
	
	private static void choose(Map<Integer, Map<Integer, String>> m1, int option) throws Exception
	{
		@SuppressWarnings("rawtypes")
		Map mapNext = (Map) m1.get(option);
		int option2 = 0;
		String val = "";
		try {
			for (int i = 0; i < mapNext.size(); i++) 
			{
				//Display the sub-options of a file
				System.out.println(i + 1 + ". " + mapNext.get(i + 1));
			}
			//Take the customers choice
			System.out.println("Make your next Choice...");
			String st = s.nextLine();
			option2 = Integer.parseInt(st);
			//Check validity of inputs
			if (option2 <= mapNext.size() && option > 0) 
			{
				val = (String) mapNext.get(option2);
			} 
			else 
			{
				throw new Exception();
			}
			
		}

		catch (Exception e) 
		{
			System.out.println("Wrong inputs. Enter inputs as shown...");
			System.out.println();
			choose(m1, option);
		}
		data = val;
		calcQuantAndTotal(data);
	}
	
	// called to take quantity of an item and calculate the total cost
	
	private static void calcQuantAndTotal(String str) throws Exception 
	{
		int quant;
		List<Integer> numb = new ArrayList<>();
		List<String> name = new ArrayList<>();
		// Sort the input as "Item's name" and "Item's price
		String[] str1 = str.split(" ");
		for (String str2 : str1) {
			try {
				numb.add(Integer.parseInt(str2));
			} catch (Exception e) {
				name.add(str2);
			}
		}
		//confirm customer's choice before entering quantity
		System.out.println("your choice was " + name.get(0) + " and it cost's $" + numb.get(0));
		System.out.println("Enter the quantity..");
		System.out.println("quantity must be between 0 and 11");
		String st = s.nextLine();
		try 
		{
			if(st=="")
			{
			throw new Exception();
			}
			quant = Integer.parseInt(st);
		
		//Check validity of quantity input
		
			if (quant > 0 && quant < 11) 
			{
				int total = quant * numb.get(0);
				System.out.println("Your Total is $" + total);
				System.out.println();
				System.out.println();
				TimeUnit.SECONDS.sleep(3);
				printChoice();
			}
			else
			{
				throw new Exception();
			}
		} catch (Exception e)
		{			
			System.out.println("Enter value from 1 to 10 only!!");
			TimeUnit.SECONDS.sleep(2);
			System.out.println();
			calcQuantAndTotal(data);
		}

	}

	//Method addItemName is called when customer selects to add an item 
	
	private static void addItemName() throws Exception
	{
		System.out.println("Enter name of item");
		String newItem=s.nextLine();
		
		//check validity of input number item
		try
		{
			String sizeNewItem1="";
			System.out.println("Enter number of sub items");
			sizeNewItem1 = s.nextLine();
			int sizeNewItem = Integer.parseInt(sizeNewItem1);
			if(sizeNewItem>0 && sizeNewItem<4)
			{
				//If validity passes call to take item information
				addItemInfo(newItem,sizeNewItem);
			}
			else 
			{
				throw new Exception();
			}
		}
		catch(Exception e) 
		{
			System.out.println("Enter 3 types only");
			//printChoice();
			addItemName();
		}
	}

	//called to take complete information of items to be added
	private static void addItemInfo(String newItem,int size) throws Exception
	{
		String NamePrice="";
		Map<Integer, String> newMap = new HashMap<>();
		int m1length = m1.size()+1;	
		m1.put(m1length, newMap);
		for(int i=1;i<=size;i++) 
		{
			//s.nextLine();
			System.out.println("Enter name of item and price in this format \"{Name}{space}{price}\"");
			NamePrice = s.nextLine();
			addMap(NamePrice,i,newMap);
			
		}
		//Update the menu after passing validity check
		int menuIndex=VendingMachine2.menu.size();
		menu.remove(menuIndex-1);
		menu.add(newItem);
		menu.add("Add new item");
		TimeUnit.SECONDS.sleep(2);
		printChoice();
	}
	
	//Adding the confirmed items to the map m1
	
	private static void addMap(String namePrice,int i, Map<Integer, String> newMap) 
	{
		String[] str1 = namePrice.split(" ");
		String name="";
		int numb=0;
		for(String str2 : str1) 
		{
			try
			{
			    
				numb=(Integer.parseInt(str2));
			}
			catch (NumberFormatException ex) 
			{
			    name=(str2);
			}
		}
		newMap.put(i,name+" -$ "+(numb));		
	}
}

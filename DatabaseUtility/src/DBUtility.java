import java.sql.*;

public class DBUtility {
	 	 //Database credentials
		static String USER = "root";
		static String PASS = "abiramroot";
		static Connection conn = null;
		static Statement stmt = null;
		/**
		 * Enter the name of the Database you would like to create while creating the object
		 * @param dBName
		 * Its of type String
		 */
	public DBUtility(String dBName) 
	{
			super();
			DBConnect(dBName);
	}
	/**
	 * Its called when the constructor is invoked with the Database name 
	 * @param DBName
	 * Its of type String
	 */
	public void DBConnect(String DBName) {
		String JDBC_DRIVER = "com.mysql.jdbc.Driver";  
		String DB_URL = "jdbc:mysql://localhost/";

		if(null!=conn)
		{
			System.out.println("Connected to database."); 
		}
		else
		{
			//Register JDBC driver
		    try {
				Class.forName(JDBC_DRIVER);
				//Open a connection
			    System.out.println("Connecting to database...");
			    conn = DriverManager.getConnection(DB_URL, USER, PASS);
			    stmt = conn.createStatement();
			    String createDB="CREATE DATABASE "+DBName;
			    stmt.executeUpdate(createDB);
			    DB_URL=DB_URL+DBName;
			    conn = DriverManager.getConnection(DB_URL, USER, PASS);
			    stmt = conn.createStatement();
			    System.out.println("Connected to the database.");
			    
			    }
		    	
		    catch (ClassNotFoundException|SQLException e) 
		    {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	/**
	 * Enter the query in to create a table with type declaration
	 * Accepts {Int} {String} {String}
	 * first element is the Primary Key
	 * @param query
	 * Its of type String
	 */
	public void DBCreateTable(String query) 
	{
		try 
		{
			stmt.executeUpdate(query);
		}
		catch (SQLException e)
		{	
			System.out.println("Table could not be created");
			e.printStackTrace();
		}
	}
	/**
	 * Enter row to a table. Parameter must be a Insert statement
	 * @param query
	 * Its of type String
	 */
	public void DBInsertTable(String query) 
	{
		try 
		{
			stmt.executeUpdate(query);
		}
		catch (SQLException e)
		{	
			System.out.println("Row could not be inserted");
			e.printStackTrace();
		}
	}
	/**
	 * Calls the table of +tableName+ and prints every row in it
	 * @param tableName
	 * Its of type String
	 */
	public void DBReadTable(String tableName)
	{
		ResultSet rs;
		try
		{
			rs = stmt.executeQuery("Select * from "+tableName);
			while(rs.next())
				System.out.println(rs.getInt(1)+"  "+rs.getString(2)+"  "+rs.getString(3));
		} catch (SQLException e) 
		{
			e.printStackTrace();
		}	
	}
	/**
	 * Accepts query statement to update an element
	 * @param updateQuery
	 * Its of type String
	 */
	public void DBUpdateRecord(String updateQuery) 
	{
		try 
		{
			stmt.executeUpdate(updateQuery);
		} catch (SQLException e) 
		{
			System.out.println("Update Failed..");
			e.printStackTrace();
		}
		
	}
	/**
	 * Accepts query statement to delete a record
	 * @param deleteQuery
	 * Its of type String
	 */
	public void DBDeleteRecord(String deleteQuery)
	{
		try {
			stmt.executeUpdate(deleteQuery);
		} catch (SQLException e) {
			System.out.println("Delete Failed..");
			e.printStackTrace();
		}
	}
	/**
	 * Close data base with 
	 */
	public void DBClose()
	{
		try {
			conn.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}

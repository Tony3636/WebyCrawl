package database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

public class DatabaseConnector
{
	public static Connection c_webpages = null;
	private static Statement stmt = null;

	public static void connect()
	{
		try
		{
			Class.forName("org.sqlite.JDBC");
			c_webpages = DriverManager.getConnection("jdbc:sqlite:data/webpages.db");
			createTables();
		}
		catch (Exception e)
		{
			System.err.println(e.getClass().getName() + ": " + e.getMessage());
			System.exit(0);
		}
		System.out.println("Opened database successfully");
	}

	private static void createTables()
	{
		try
		{
			stmt = c_webpages.createStatement();
			String sql = "CREATE TABLE WEBSITE " + "(ID INT PRIMARY KEY NOT NULL, " + "URL TEXT NOT NULL, " + "SEARCHURL TEXT NOT NULL, " + "FRAMETAG TEXT NOT NULL, " + "PICTURETAG TEXT NOT NULL" + ")";
			stmt.executeUpdate(sql);
			stmt.close();
			c_webpages.close();
		}
		catch (Exception e)
		{
			System.err.println(e.getClass().getName() + ": " + e.getMessage());
			System.exit(0);
		}
		System.out.println("Table created successfully");
	}
	
	public static void insert()
	{
		
	}
	
	public static void select()
	{
		
	}
}

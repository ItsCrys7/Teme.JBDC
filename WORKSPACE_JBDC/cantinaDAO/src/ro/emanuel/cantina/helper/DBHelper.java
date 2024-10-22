package ro.emanuel.cantina.helper;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class DBHelper {

	private static Connection conn;
	
	public static Connection getConnections() throws SQLException 
	{
		
		if (conn == null || conn.isClosed()) 
		{
			Properties connectionProps = new Properties();
			connectionProps.put("user", "root");
			connectionProps.put("password", "");
			conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/oop2024.cantina",connectionProps);
			
		}
		return conn;
	}
	
	public static void closeConnection() throws SQLException
	{
		if(conn!=null && !conn.isClosed())
		{
			conn.close();
		}
	}
}

	
	
	
	
	

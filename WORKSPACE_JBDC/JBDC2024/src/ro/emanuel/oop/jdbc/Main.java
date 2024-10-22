package ro.emanuel.oop.jdbc;

import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;

import com.mysql.jdbc.Connection;

public class Main {

	public static void main(String[] args) throws SQLException {
		
		// prepare the connection obj auth props
		Properties connectionProps = new Properties ();
		connectionProps.put ("user", "root");
		connectionProps.put("password", "");
		
		// open connection (create Connection obj)
		Connection conn = (Connection) DriverManager.getConnection(
				"jdbc:mysql://localhost:3306/oop2024",
				connectionProps);
		
		// open statement (create Statement obj to run sql commands)
		Statement stmt = conn.createStatement();
		
		//INSERT
		final String commandInsert = "insert into bank (name, address, swift) values ('Banca Transilvania', 'Romania', 'BTRL')";
		int rowsAffected = stmt.executeUpdate(commandInsert);
		System.out.println(rowsAffected + " rows affected");
		
		//get results
		ResultSet rs = stmt.executeQuery("select * from bank");
		
		//map results
		while (rs.next()) {
			int id=rs.getInt("id");
			String bankName=rs.getString("name");
			String bankAdress=rs.getString("address");
			String bankSwift = rs.getString("swift");
			
			System.out.println(id+" | " + bankName
			+ " " + bankName +" " + bankSwift);
			
		}
		conn.close();
	}
}
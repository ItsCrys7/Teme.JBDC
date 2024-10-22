package ro.emanuel.oop.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;

public class t1 {

	public static void main(String[] args) throws SQLException {
		
		Properties connectionProps = new Properties();
		connectionProps.put("user", "root");
		connectionProps.put("password","" );
		
		Connection conn = DriverManager.getConnection(
				"jdbc:mysql://localhost:3306/oop2024",
				connectionProps);
		
		String nume = "Andrei";
		String sex = "masculin";
		String varsta = "28";
		
		
		Statement stmt = conn.createStatement();
		//insert
		String sqlInsert = "INSERT INTO calatori (nume , sex , varsta) VALUES (? , ? , ?)";
		PreparedStatement ps = conn.prepareStatement(sqlInsert);
		ps.setString(1, nume);
		ps.setString(2, sex);
		ps.setString(3, varsta);
		ps.executeUpdate();
		//update
		String update = "UPDATE calatori SET nume = ? WHERE id = ?";
		PreparedStatement psu = conn.prepareStatement(update);
		psu.setString(1, nume);
		psu.setInt(2, 1);
		psu.executeUpdate();
		//delete
		String delete = "DELETE FROM calatori WHERE id >= ?";
		PreparedStatement psd = conn.prepareStatement(delete);
		psd.setInt(1, 5);
		int result = psd.executeUpdate();
		
		System.out.println(result);
		//select
		ResultSet rs = stmt.executeQuery("select * from calatori");
		while(rs.next()) {
			int id = rs.getInt("id");
			String cNume = rs.getString("nume");
			String cSex = rs.getString("sex");
			String cVarsta = rs.getString("varsta");
			
			System.out.println(id + " | " + cNume + " | " + cSex+" | " + cVarsta);
		}
		conn.close();
	}
}
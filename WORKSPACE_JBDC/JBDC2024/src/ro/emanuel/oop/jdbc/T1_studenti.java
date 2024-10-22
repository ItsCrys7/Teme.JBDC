package ro.emanuel.oop.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;

public class T1_studenti {

	public static void main(String[] args) throws SQLException {
		
		Properties connectionProps = new Properties();
		connectionProps.put("user", "root");
		connectionProps.put("password","" );
		
		Connection conn = DriverManager.getConnection(
				"jdbc:mysql://localhost:3306/oop2024",
				connectionProps);
		
		String nume = "dvd";
		String facultate = "INFO";
		String an = "2";
		
		
		Statement stmt = conn.createStatement();
		//insert
		String sqlInsert = "INSERT INTO studenti (nume , facultate , an) VALUES (? , ? , ?)";
		PreparedStatement ps = conn.prepareStatement(sqlInsert);
		ps.setString(1, nume);
		ps.setString(2, facultate);
		ps.setString(3, an);
		ps.executeUpdate();
		//update
		String update = "UPDATE studenti SET nume = ? WHERE id = ?";
		PreparedStatement psu = conn.prepareStatement(update);
		psu.setString(1, nume);
		psu.setInt(2, 1);
		psu.executeUpdate();
		//delete
		String delete = "DELETE FROM studenti WHERE id >= ?";
		PreparedStatement psd = conn.prepareStatement(delete);
		psd.setInt(1, 5);
		int result = psd.executeUpdate();
		
		System.out.println(result);
		//select
		ResultSet rs = stmt.executeQuery("select * from studenti");
		while(rs.next()) {
			int id = rs.getInt("id");
			String sNume = rs.getString("nume");
			String sFacultate = rs.getString("facultate");
			String sAn = rs.getString("an");
			
			System.out.println(id + " | " + sNume + " | " + sFacultate+" | " + sAn);
		}
		conn.close();
	}
}
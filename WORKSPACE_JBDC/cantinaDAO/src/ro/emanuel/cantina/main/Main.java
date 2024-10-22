package ro.emanuel.cantina.main;

import java.sql.SQLException;

import ro.emanuel.cantina.dao.MeniuDAO;
import ro.emanuel.cantina.pojo.Meniu;

public class Main {

	public static void main(String [] args) throws SQLException {
		
		Meniu m1=MeniuDAO.getMeniuById(1);
		System.out.println(m1.getId()+" "+m1.getFel1());
	}
}
 
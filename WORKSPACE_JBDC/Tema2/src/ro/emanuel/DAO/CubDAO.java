package ro.emanuel.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import ro.emanuel.DBHelper.DBHelper;

public class CubDAO {
   
    public CubDAO(int id, String brand, int weight, int sides) {
		// TODO Auto-generated constructor stub
	}

	public static List<CubDAO> getCub() throws SQLException {
        List<CubDAO> cubs = new ArrayList<>();

        
        Connection conn = DBHelper.getConnection();
        Statement stmt = conn.createStatement();
        
        
        ResultSet rs = stmt.executeQuery("select * from Cub");
        while(rs.next()) {

        	int id = rs.getInt("id");
            String brand = rs.getString("brand");
            int weight = rs.getInt("weight");
            int sides = rs.getInt("sides");
            CubDAO Cub = new CubDAO(id, brand, weight, sides);
            cubs.add(Cub);
        }
        
        DBHelper.closeConnection(); 
        
       
		List<CubDAO> Cub = null;
		return Cub;
    }

    public static int deleteCub(int id) throws SQLException {
        Connection conn = DBHelper.getConnection();
        Statement stmt = conn.createStatement();
        
        int deletedRows = stmt.executeUpdate("delete Cub where id = " + id);
        
        DBHelper.closeConnection();
        
        return deletedRows;
    }

    public static int createCub(CubDAO CubToCreate) throws SQLException {
        Connection conn = DBHelper.getConnection();
        String query = "insert into bank (brand, weight, sides) values(?,?,?)";
        PreparedStatement ps = conn.prepareStatement(query);
        
        ps.setString(1, CubToCreate.getBrand());
        ps.setInt(2, CubToCreate.getWeight());
        ps.setInt(3, CubToCreate.getSides());
        
        int affectedRows = ps.executeUpdate();
        
        DBHelper.closeConnection();
        
        return affectedRows;
    }

    private int getSides() {
		// TODO Auto-generated method stub
		return 0;
	}

	private String getBrand() {
		// TODO Auto-generated method stub
		return null;
	}

	private int getWeight() {
		// TODO Auto-generated method stub
		return 0;
	}

	public static int updateBank(CubDAO Cub) throws SQLException {
        Connection conn = DBHelper.getConnection();
        String query = "update bank set brand = ?, weight = ?, sides = ? where id = ?";
        PreparedStatement ps = conn.prepareStatement(query);
        
        ps.setString(1, Cub.getBrand());
        ps.setInt(2, Cub.getWeight());
        ps.setInt(3, Cub.getSides());
        ps.setInt(4, Cub.getId());
        
        
        int rowsUpdated = ps.executeUpdate();
        
        DBHelper.closeConnection();
        
        return rowsUpdated; 
    }

    private int getId() {
		// TODO Auto-generated method stub
		return 0;
	}

	public static CubDAO getById(int id) throws SQLException {
        Connection conn = DBHelper.getConnection();
        
        List<CubDAO> Cubs = getCubs();
        for(CubDAO b : Cubs) {
            if(b.getId() == id) {
                return b; 
            }
        }
        
        return null;
    }

	private static List<CubDAO> getCubs() {
		// TODO Auto-generated method stub
		return null;
	}
}

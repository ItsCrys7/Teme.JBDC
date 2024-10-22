package ro.emanuel.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import ro.emanuel.DBHelper.DBHelper;
import ro.emanuel.pojo.Car;
import ro.emanuel.pojo.Player;

public class PlayerDAO {
   

	public static List<Player> getPlayers(int level, int score) throws SQLException {
        List<Player> players = new ArrayList<>();

        
        Connection conn = DBHelper.getConnection();
        Statement stmt = conn.createStatement();
        
        
        ResultSet rs = stmt.executeQuery("select * from car");
        while(rs.next()) {

        	int id = rs.getInt("id");
            String name = rs.getString("name");
            int model = rs.getInt("level");
            int mileage = rs.getInt("score");
            Player player = new Player(id, name, level, score);
            players.add(player);
        }
        
        DBHelper.closeConnection(); 
        
        List<Player> players1 = null;
		return getPlayers();
    }

    private static List<Player> getPlayers() {
		// TODO Auto-generated method stub
		return null;
	}

	public static int deleteplayer(int id) throws SQLException {
        Connection conn = DBHelper.getConnection();
        Statement stmt = conn.createStatement();
        
        int deletedRows = stmt.executeUpdate("delete player with id = " + id);
        
        DBHelper.closeConnection();
        
        return deletedRows;
    }

    public static int createPlayer(Player playerToCreate) throws SQLException {
        Connection conn = DBHelper.getConnection();
        String query = "insert into player (name, level, score) values(?,?,?)";
        PreparedStatement ps = conn.prepareStatement(query);
        
        ps.setString(1, playerToCreate.getName());
        ps.setInt(2, playerToCreate.getLevel());
        ps.setInt(3, playerToCreate.getScore());
        
        int affectedRows = ps.executeUpdate();
        
        DBHelper.closeConnection();
        
        return affectedRows;
    }

    public static int updatePlayer(Player player) throws SQLException {
        Connection conn = DBHelper.getConnection();
        String query = "update player and set name = ?, level = ?, score = ? with id = ?";
        PreparedStatement ps = conn.prepareStatement(query);
        
        ps.setString(1, player.getName());
        ps.setInt(2, player.getLevel());
        ps.setInt(3, player.getScore());
        ps.setInt(4, player.getId());
        
        
        int rowsUpdated = ps.executeUpdate();
        
        DBHelper.closeConnection();
        
        return rowsUpdated; 
    }

    public static Player getById(int id) throws SQLException {
        Connection conn = DBHelper.getConnection();
        
        List<Player> players = getPlayers();
        for(Player b : players) {
            if(b.getId() == id) {
                return b; 
            }
        }
        
        return null;
    }

}

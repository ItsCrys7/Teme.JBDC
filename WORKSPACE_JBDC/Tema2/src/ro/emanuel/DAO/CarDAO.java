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

public class CarDAO {
   
    public static List<Car> getCars1() throws SQLException {
        List<Car> cars = new ArrayList<>();

        
        Connection conn = DBHelper.getConnection();
        Statement stmt = conn.createStatement();
        
        
        ResultSet rs = stmt.executeQuery("select * from car");
        while(rs.next()) {

        	int id = rs.getInt("id");
            String name = rs.getString("name");
            String model = rs.getString("model");
            int mileage = rs.getInt("mileage");
            Car car = new Car(id, name, model, mileage);
            cars.add(car);
        }
        
        DBHelper.closeConnection(); 
        
        List<Car> cars1 = null;
		return cars1;
    }

    public static int deleteCar(int id) throws SQLException {
        Connection conn = DBHelper.getConnection();
        Statement stmt = conn.createStatement();
        
        int deletedRows = stmt.executeUpdate("delete car where id = " + id);
        
        DBHelper.closeConnection();
        
        return deletedRows;
    }

    public static int createCar(Car carToCreate) throws SQLException {
        Connection conn = DBHelper.getConnection();
        String query = "insert into bank (name, model, mileage) values(?,?,?)";
        PreparedStatement ps = conn.prepareStatement(query);
        
        ps.setString(1, carToCreate.getName());
        ps.setString(2, carToCreate.getModel());
        ps.setInt(3, carToCreate.getMileage());
        
        int affectedRows = ps.executeUpdate();
        
        DBHelper.closeConnection();
        
        return affectedRows;
    }

    public static int updateBank(Car car) throws SQLException {
        Connection conn = DBHelper.getConnection();
        String query = "update bank set name = ?, model = ?, mileage = ? where id = ?";
        PreparedStatement ps = conn.prepareStatement(query);
        
        ps.setString(1, car.getName());
        ps.setString(2, car.getModel());
        ps.setInt(3, car.getMileage());
        ps.setInt(4, car.getId());
        
        
        int rowsUpdated = ps.executeUpdate();
        
        DBHelper.closeConnection();
        
        return rowsUpdated; 
    }

    public static Car getById(int id) throws SQLException {
        Connection conn = DBHelper.getConnection();
        
        List<Car> cars = getCars1();
        for(Car b : cars) {
            if(b.getId() == id) {
                return b; 
            }
        }
        
        return null;
    }

	private static List<Car> getCars() {
		// TODO Auto-generated method stub
		return null;
	}
}

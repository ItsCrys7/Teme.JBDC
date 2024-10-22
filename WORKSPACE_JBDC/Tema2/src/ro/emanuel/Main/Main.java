package ro.emanuel.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

import ro.emanuel.helper.DBHelper;
import ro.emanuel.pojo.Car;
import ro.emanuel.pojo;
import ro.emanuel.CarDAO;
import ro.emanuel.CubDAO;
import ro.emanuel.PlayerDAO;

public class Main {
	
	public static void main(String[] args) throws SQLException, ClassNotFoundException {
				
	
		// 1. Luam toate bancile si le afisam
        List<Car> cars = Car.createCar();
        System.out.println("Lista bancilor:");
        for (Car cars1 : cars) {
            System.out.println(cars);
        }
        
        System.out.println("=====================");
        System.out.println("=====================");
        
        // 2. Cream o banca noua
        Car newcar = new Car("Ford", "Focus", "200 km");
        int rowsInserted = cars.createcar(newcar);
        System.out.println("Msina noua a fost creata. Rinduri inserate: " + rowsInserted);
        
        System.out.println();
        System.out.println("=====================");
        System.out.println("=====================");
        System.out.println();


        // 3. Luam o banca dupa ID si o afisam
        Car car = Car.getById(7);
        System.out.println("Banca gasita dupa ID: " + car);
        
        System.out.println();
        System.out.println("=====================");
        System.out.println("=====================");
        System.out.println();



        // 4. Facem update la banca cu ID-ul 1, ii setam numele "Banca BNR", swift si adresa noua
        // apoi afisam si verificam actualizarea
        Car carToUpdate = new car1(7, "Toyota", "Pryus", "500 km");
        int rowsUpdated = cars.updatecar(carToUpdate);
        System.out.println("Banca a fost actualizata. Rinduri updatate: " + rowsUpdated);
        
        // iau banca cu id-ul specificat din db folosind dao, si verific daca s-a actualizat
        car = cars.getById(7);
        System.out.println("Banca actualizata: " + car);
        
        System.out.println();
        System.out.println("=====================");
        System.out.println("=====================");
        System.out.println();

        
        // 5. Stergem banca cu ID-ul 1
        int rowsDeleted = cars.deletecar(7);
        System.out.println("Banca a fost stearsa. Rinduri sterse: " + rowsDeleted);
        // acum incerc sa o iau din nou din db, si pentru ca tocmai am sters-o, ar trebui sa primim null fiindca asa am facut in DAO.
        car = cars.getById(7);
        System.out.println(car);

        
        

		
				
	}
	


}
